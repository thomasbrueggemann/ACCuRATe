package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.impl.conn.HttpPoolEntry;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
class ManagedClientConnectionImpl implements ManagedClientConnection {
   private volatile long duration;
   private final ClientConnectionManager manager;
   private final ClientConnectionOperator operator;
   private volatile HttpPoolEntry poolEntry;
   private volatile boolean reusable;

   ManagedClientConnectionImpl(ClientConnectionManager var1, ClientConnectionOperator var2, HttpPoolEntry var3) {
      Args.notNull(var1, "Connection manager");
      Args.notNull(var2, "Connection operator");
      Args.notNull(var3, "HTTP pool entry");
      this.manager = var1;
      this.operator = var2;
      this.poolEntry = var3;
      this.reusable = false;
      this.duration = Long.MAX_VALUE;
   }

   private OperatedClientConnection ensureConnection() {
      HttpPoolEntry var1 = this.poolEntry;
      if(var1 == null) {
         throw new ConnectionShutdownException();
      } else {
         return (OperatedClientConnection)var1.getConnection();
      }
   }

   private HttpPoolEntry ensurePoolEntry() {
      HttpPoolEntry var1 = this.poolEntry;
      if(var1 == null) {
         throw new ConnectionShutdownException();
      } else {
         return var1;
      }
   }

   private OperatedClientConnection getConnection() {
      HttpPoolEntry var1 = this.poolEntry;
      return var1 == null?null:(OperatedClientConnection)var1.getConnection();
   }

   public void abortConnection() {
      // $FF: Couldn't be decompiled
   }

   public void close() throws IOException {
      HttpPoolEntry var1 = this.poolEntry;
      if(var1 != null) {
         OperatedClientConnection var2 = (OperatedClientConnection)var1.getConnection();
         var1.getTracker().reset();
         var2.close();
      }

   }

   HttpPoolEntry detach() {
      HttpPoolEntry var1 = this.poolEntry;
      this.poolEntry = null;
      return var1;
   }

   public void flush() throws IOException {
      this.ensureConnection().flush();
   }

   public ClientConnectionManager getManager() {
      return this.manager;
   }

   HttpPoolEntry getPoolEntry() {
      return this.poolEntry;
   }

   public InetAddress getRemoteAddress() {
      return this.ensureConnection().getRemoteAddress();
   }

   public int getRemotePort() {
      return this.ensureConnection().getRemotePort();
   }

   public HttpRoute getRoute() {
      return this.ensurePoolEntry().getEffectiveRoute();
   }

   public SSLSession getSSLSession() {
      Socket var1 = this.ensureConnection().getSocket();
      boolean var2 = var1 instanceof SSLSocket;
      SSLSession var3 = null;
      if(var2) {
         var3 = ((SSLSocket)var1).getSession();
      }

      return var3;
   }

   public boolean isMarkedReusable() {
      return this.reusable;
   }

   public boolean isOpen() {
      OperatedClientConnection var1 = this.getConnection();
      return var1 != null?var1.isOpen():false;
   }

   public boolean isResponseAvailable(int var1) throws IOException {
      return this.ensureConnection().isResponseAvailable(var1);
   }

   public boolean isStale() {
      OperatedClientConnection var1 = this.getConnection();
      return var1 != null?var1.isStale():true;
   }

   public void layerProtocol(HttpContext param1, HttpParams param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void markReusable() {
      this.reusable = true;
   }

   public void open(HttpRoute param1, HttpContext param2, HttpParams param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void receiveResponseEntity(HttpResponse var1) throws HttpException, IOException {
      this.ensureConnection().receiveResponseEntity(var1);
   }

   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
      return this.ensureConnection().receiveResponseHeader();
   }

   public void releaseConnection() {
      // $FF: Couldn't be decompiled
   }

   public void sendRequestEntity(HttpEntityEnclosingRequest var1) throws HttpException, IOException {
      this.ensureConnection().sendRequestEntity(var1);
   }

   public void sendRequestHeader(HttpRequest var1) throws HttpException, IOException {
      this.ensureConnection().sendRequestHeader(var1);
   }

   public void setIdleDuration(long var1, TimeUnit var3) {
      if(var1 > 0L) {
         this.duration = var3.toMillis(var1);
      } else {
         this.duration = -1L;
      }
   }

   public void setSocketTimeout(int var1) {
      this.ensureConnection().setSocketTimeout(var1);
   }

   public void setState(Object var1) {
      this.ensurePoolEntry().setState(var1);
   }

   public void shutdown() throws IOException {
      HttpPoolEntry var1 = this.poolEntry;
      if(var1 != null) {
         OperatedClientConnection var2 = (OperatedClientConnection)var1.getConnection();
         var1.getTracker().reset();
         var2.shutdown();
      }

   }

   public void tunnelProxy(HttpHost param1, boolean param2, HttpParams param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void tunnelTarget(boolean param1, HttpParams param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void unmarkReusable() {
      this.reusable = false;
   }
}
