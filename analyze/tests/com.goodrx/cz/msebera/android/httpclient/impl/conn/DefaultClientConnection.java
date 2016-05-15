package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.SocketHttpClientConnection;
import cz.msebera.android.httpclient.impl.conn.DefaultHttpResponseParser;
import cz.msebera.android.httpclient.impl.conn.LoggingSessionInputBuffer;
import cz.msebera.android.httpclient.impl.conn.LoggingSessionOutputBuffer;
import cz.msebera.android.httpclient.impl.conn.Wire;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
public class DefaultClientConnection extends SocketHttpClientConnection implements ManagedHttpClientConnection, OperatedClientConnection, HttpContext {
   private final Map<String, Object> attributes = new HashMap();
   private boolean connSecure;
   public HttpClientAndroidLog headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   private volatile boolean shutdown;
   private volatile Socket socket;
   private HttpHost targetHost;
   public HttpClientAndroidLog wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");

   public void close() throws IOException {
      try {
         super.close();
         if(this.log.isDebugEnabled()) {
            this.log.debug("Connection " + this + " closed");
         }

      } catch (IOException var2) {
         this.log.debug("I/O error closing connection", var2);
      }
   }

   protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer var1, HttpResponseFactory var2, HttpParams var3) {
      return new DefaultHttpResponseParser(var1, (LineParser)null, var2, var3);
   }

   protected SessionInputBuffer createSessionInputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      if(var2 <= 0) {
         var2 = 8192;
      }

      Object var4 = super.createSessionInputBuffer(var1, var2, var3);
      if(this.wireLog.isDebugEnabled()) {
         var4 = new LoggingSessionInputBuffer((SessionInputBuffer)var4, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(var3));
      }

      return (SessionInputBuffer)var4;
   }

   protected SessionOutputBuffer createSessionOutputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      if(var2 <= 0) {
         var2 = 8192;
      }

      Object var4 = super.createSessionOutputBuffer(var1, var2, var3);
      if(this.wireLog.isDebugEnabled()) {
         var4 = new LoggingSessionOutputBuffer((SessionOutputBuffer)var4, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(var3));
      }

      return (SessionOutputBuffer)var4;
   }

   public Object getAttribute(String var1) {
      return this.attributes.get(var1);
   }

   public SSLSession getSSLSession() {
      return this.socket instanceof SSLSocket?((SSLSocket)this.socket).getSession():null;
   }

   public final Socket getSocket() {
      return this.socket;
   }

   public final boolean isSecure() {
      return this.connSecure;
   }

   public void openCompleted(boolean var1, HttpParams var2) throws IOException {
      Args.notNull(var2, "Parameters");
      this.assertNotOpen();
      this.connSecure = var1;
      this.bind(this.socket, var2);
   }

   public void opening(Socket var1, HttpHost var2) throws IOException {
      this.assertNotOpen();
      this.socket = var1;
      this.targetHost = var2;
      if(this.shutdown) {
         var1.close();
         throw new InterruptedIOException("Connection already shutdown");
      }
   }

   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
      HttpResponse var1 = super.receiveResponseHeader();
      if(this.log.isDebugEnabled()) {
         this.log.debug("Receiving response: " + var1.getStatusLine());
      }

      if(this.headerLog.isDebugEnabled()) {
         this.headerLog.debug("<< " + var1.getStatusLine().toString());
         Header[] var2 = var1.getAllHeaders();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Header var5 = var2[var4];
            this.headerLog.debug("<< " + var5.toString());
         }
      }

      return var1;
   }

   public void sendRequestHeader(HttpRequest var1) throws HttpException, IOException {
      if(this.log.isDebugEnabled()) {
         this.log.debug("Sending request: " + var1.getRequestLine());
      }

      super.sendRequestHeader(var1);
      if(this.headerLog.isDebugEnabled()) {
         this.headerLog.debug(">> " + var1.getRequestLine().toString());
         Header[] var2 = var1.getAllHeaders();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Header var5 = var2[var4];
            this.headerLog.debug(">> " + var5.toString());
         }
      }

   }

   public void setAttribute(String var1, Object var2) {
      this.attributes.put(var1, var2);
   }

   public void shutdown() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void update(Socket var1, HttpHost var2, boolean var3, HttpParams var4) throws IOException {
      this.assertOpen();
      Args.notNull(var2, "Target host");
      Args.notNull(var4, "Parameters");
      if(var1 != null) {
         this.socket = var1;
         this.bind(var1, var4);
      }

      this.targetHost = var2;
      this.connSecure = var3;
   }
}
