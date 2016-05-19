package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.impl.HttpConnectionMetricsImpl;
import cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.DefaultHttpResponseParser;
import cz.msebera.android.httpclient.impl.io.HttpRequestWriter;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.SocketTimeoutException;

@Deprecated
public abstract class AbstractHttpClientConnection implements HttpClientConnection {
   private final EntityDeserializer entitydeserializer = this.createEntityDeserializer();
   private final EntitySerializer entityserializer = this.createEntitySerializer();
   private EofSensor eofSensor = null;
   private SessionInputBuffer inbuffer = null;
   private HttpConnectionMetricsImpl metrics = null;
   private SessionOutputBuffer outbuffer = null;
   private HttpMessageWriter<HttpRequest> requestWriter = null;
   private HttpMessageParser<HttpResponse> responseParser = null;

   protected abstract void assertOpen() throws IllegalStateException;

   protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics var1, HttpTransportMetrics var2) {
      return new HttpConnectionMetricsImpl(var1, var2);
   }

   protected EntityDeserializer createEntityDeserializer() {
      return new EntityDeserializer(new LaxContentLengthStrategy());
   }

   protected EntitySerializer createEntitySerializer() {
      return new EntitySerializer(new StrictContentLengthStrategy());
   }

   protected HttpResponseFactory createHttpResponseFactory() {
      return DefaultHttpResponseFactory.INSTANCE;
   }

   protected HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer var1, HttpParams var2) {
      return new HttpRequestWriter(var1, (LineFormatter)null, var2);
   }

   protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer var1, HttpResponseFactory var2, HttpParams var3) {
      return new DefaultHttpResponseParser(var1, (LineParser)null, var2, var3);
   }

   protected void doFlush() throws IOException {
      this.outbuffer.flush();
   }

   public void flush() throws IOException {
      this.assertOpen();
      this.doFlush();
   }

   protected void init(SessionInputBuffer var1, SessionOutputBuffer var2, HttpParams var3) {
      this.inbuffer = (SessionInputBuffer)Args.notNull(var1, "Input session buffer");
      this.outbuffer = (SessionOutputBuffer)Args.notNull(var2, "Output session buffer");
      if(var1 instanceof EofSensor) {
         this.eofSensor = (EofSensor)var1;
      }

      this.responseParser = this.createResponseParser(var1, this.createHttpResponseFactory(), var3);
      this.requestWriter = this.createRequestWriter(var2, var3);
      this.metrics = this.createConnectionMetrics(var1.getMetrics(), var2.getMetrics());
   }

   protected boolean isEof() {
      return this.eofSensor != null && this.eofSensor.isEof();
   }

   public boolean isResponseAvailable(int var1) throws IOException {
      this.assertOpen();

      try {
         boolean var3 = this.inbuffer.isDataAvailable(var1);
         return var3;
      } catch (SocketTimeoutException var4) {
         return false;
      }
   }

   public boolean isStale() {
      if(this.isOpen() && !this.isEof()) {
         try {
            this.inbuffer.isDataAvailable(1);
            boolean var4 = this.isEof();
            return var4;
         } catch (SocketTimeoutException var5) {
            return false;
         } catch (IOException var6) {
            return true;
         }
      } else {
         return true;
      }
   }

   public void receiveResponseEntity(HttpResponse var1) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      this.assertOpen();
      var1.setEntity(this.entitydeserializer.deserialize(this.inbuffer, var1));
   }

   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
      this.assertOpen();
      HttpResponse var1 = (HttpResponse)this.responseParser.parse();
      if(var1.getStatusLine().getStatusCode() >= 200) {
         this.metrics.incrementResponseCount();
      }

      return var1;
   }

   public void sendRequestEntity(HttpEntityEnclosingRequest var1) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      this.assertOpen();
      if(var1.getEntity() != null) {
         this.entityserializer.serialize(this.outbuffer, var1, var1.getEntity());
      }
   }

   public void sendRequestHeader(HttpRequest var1) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      this.assertOpen();
      this.requestWriter.write(var1);
      this.metrics.incrementRequestCount();
   }
}
