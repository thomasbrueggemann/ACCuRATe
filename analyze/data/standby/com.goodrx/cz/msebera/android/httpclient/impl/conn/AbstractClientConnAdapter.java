package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
public abstract class AbstractClientConnAdapter implements ManagedClientConnection, HttpContext {
   private final ClientConnectionManager connManager;
   private volatile long duration;
   private volatile boolean markedReusable;
   private volatile boolean released;
   private volatile OperatedClientConnection wrappedConnection;

   protected AbstractClientConnAdapter(ClientConnectionManager var1, OperatedClientConnection var2) {
      this.connManager = var1;
      this.wrappedConnection = var2;
      this.markedReusable = false;
      this.released = false;
      this.duration = Long.MAX_VALUE;
   }

   public void abortConnection() {
      // $FF: Couldn't be decompiled
   }

   protected final void assertValid(OperatedClientConnection var1) throws ConnectionShutdownException {
      if(this.isReleased() || var1 == null) {
         throw new ConnectionShutdownException();
      }
   }

   protected void detach() {
      synchronized(this){}

      try {
         this.wrappedConnection = null;
         this.duration = Long.MAX_VALUE;
      } finally {
         ;
      }

   }

   public void flush() throws IOException {
      OperatedClientConnection var1 = this.getWrappedConnection();
      this.assertValid(var1);
      var1.flush();
   }

   public Object getAttribute(String var1) {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      return var2 instanceof HttpContext?((HttpContext)var2).getAttribute(var1):null;
   }

   protected ClientConnectionManager getManager() {
      return this.connManager;
   }

   public InetAddress getRemoteAddress() {
      OperatedClientConnection var1 = this.getWrappedConnection();
      this.assertValid(var1);
      return var1.getRemoteAddress();
   }

   public int getRemotePort() {
      OperatedClientConnection var1 = this.getWrappedConnection();
      this.assertValid(var1);
      return var1.getRemotePort();
   }

   public SSLSession getSSLSession() {
      OperatedClientConnection var1 = this.getWrappedConnection();
      this.assertValid(var1);
      if(this.isOpen()) {
         Socket var2 = var1.getSocket();
         if(var2 instanceof SSLSocket) {
            return ((SSLSocket)var2).getSession();
         }
      }

      return null;
   }

   protected OperatedClientConnection getWrappedConnection() {
      return this.wrappedConnection;
   }

   public boolean isMarkedReusable() {
      return this.markedReusable;
   }

   public boolean isOpen() {
      OperatedClientConnection var1 = this.getWrappedConnection();
      return var1 == null?false:var1.isOpen();
   }

   protected boolean isReleased() {
      return this.released;
   }

   public boolean isResponseAvailable(int var1) throws IOException {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      return var2.isResponseAvailable(var1);
   }

   public boolean isStale() {
      if(!this.isReleased()) {
         OperatedClientConnection var1 = this.getWrappedConnection();
         if(var1 != null) {
            return var1.isStale();
         }
      }

      return true;
   }

   public void markReusable() {
      this.markedReusable = true;
   }

   public void receiveResponseEntity(HttpResponse var1) throws HttpException, IOException {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      this.unmarkReusable();
      var2.receiveResponseEntity(var1);
   }

   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
      OperatedClientConnection var1 = this.getWrappedConnection();
      this.assertValid(var1);
      this.unmarkReusable();
      return var1.receiveResponseHeader();
   }

   public void releaseConnection() {
      // $FF: Couldn't be decompiled
   }

   public void sendRequestEntity(HttpEntityEnclosingRequest var1) throws HttpException, IOException {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      this.unmarkReusable();
      var2.sendRequestEntity(var1);
   }

   public void sendRequestHeader(HttpRequest var1) throws HttpException, IOException {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      this.unmarkReusable();
      var2.sendRequestHeader(var1);
   }

   public void setAttribute(String var1, Object var2) {
      OperatedClientConnection var3 = this.getWrappedConnection();
      this.assertValid(var3);
      if(var3 instanceof HttpContext) {
         ((HttpContext)var3).setAttribute(var1, var2);
      }

   }

   public void setIdleDuration(long var1, TimeUnit var3) {
      if(var1 > 0L) {
         this.duration = var3.toMillis(var1);
      } else {
         this.duration = -1L;
      }
   }

   public void setSocketTimeout(int var1) {
      OperatedClientConnection var2 = this.getWrappedConnection();
      this.assertValid(var2);
      var2.setSocketTimeout(var1);
   }

   public void unmarkReusable() {
      this.markedReusable = false;
   }
}
