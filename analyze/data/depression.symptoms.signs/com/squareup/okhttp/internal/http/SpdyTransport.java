package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.http.UnknownLengthHttpInputStream;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.URL;

public final class SpdyTransport implements Transport {
   private final HttpEngine httpEngine;
   private final SpdyConnection spdyConnection;
   private SpdyStream stream;

   public SpdyTransport(HttpEngine var1, SpdyConnection var2) {
      this.httpEngine = var1;
      this.spdyConnection = var2;
   }

   public OutputStream createRequestBody() throws IOException {
      long var1 = this.httpEngine.policy.getFixedContentLength();
      if(var1 != -1L) {
         this.httpEngine.requestHeaders.setContentLength(var1);
      }

      this.writeRequestHeaders();
      return this.stream.getOutputStream();
   }

   public void flushRequest() throws IOException {
      this.stream.getOutputStream().close();
   }

   public InputStream getTransferStream(CacheRequest var1) throws IOException {
      return new UnknownLengthHttpInputStream(this.stream.getInputStream(), var1, this.httpEngine);
   }

   public boolean makeReusable(boolean var1, OutputStream var2, InputStream var3) {
      if(var1) {
         if(this.stream == null) {
            return false;
         }

         this.stream.closeLater(ErrorCode.CANCEL);
      }

      return true;
   }

   public ResponseHeaders readResponseHeaders() throws IOException {
      RawHeaders var1 = RawHeaders.fromNameValueBlock(this.stream.getResponseHeaders());
      this.httpEngine.receiveHeaders(var1);
      ResponseHeaders var2 = new ResponseHeaders(this.httpEngine.uri, var1);
      var2.setTransport("spdy/3");
      return var2;
   }

   public void writeRequestBody(RetryableOutputStream var1) throws IOException {
      throw new UnsupportedOperationException();
   }

   public void writeRequestHeaders() throws IOException {
      if(this.stream == null) {
         this.httpEngine.writingRequestHeaders();
         RawHeaders var1 = this.httpEngine.requestHeaders.getHeaders();
         String var2;
         if(this.httpEngine.connection.getHttpMinorVersion() == 1) {
            var2 = "HTTP/1.1";
         } else {
            var2 = "HTTP/1.0";
         }

         URL var3 = this.httpEngine.policy.getURL();
         var1.addSpdyRequestHeaders(this.httpEngine.method, HttpEngine.requestPath(var3), var2, HttpEngine.getOriginAddress(var3), this.httpEngine.uri.getScheme());
         boolean var4 = this.httpEngine.hasRequestBody();
         this.stream = this.spdyConnection.newStream(var1.toNameValueBlock(), var4, true);
         this.stream.setReadTimeout((long)this.httpEngine.client.getReadTimeout());
      }
   }
}
