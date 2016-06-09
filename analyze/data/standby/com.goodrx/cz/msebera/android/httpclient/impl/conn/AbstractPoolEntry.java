package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;

@Deprecated
public abstract class AbstractPoolEntry {
   protected final ClientConnectionOperator connOperator;
   protected final OperatedClientConnection connection;
   protected volatile HttpRoute route;
   protected volatile Object state;
   protected volatile RouteTracker tracker;

   protected AbstractPoolEntry(ClientConnectionOperator var1, HttpRoute var2) {
      Args.notNull(var1, "Connection operator");
      this.connOperator = var1;
      this.connection = var1.createConnection();
      this.route = var2;
      this.tracker = null;
   }

   public Object getState() {
      return this.state;
   }

   public void layerProtocol(HttpContext var1, HttpParams var2) throws IOException {
      Args.notNull(var2, "HTTP parameters");
      Asserts.notNull(this.tracker, "Route tracker");
      Asserts.check(this.tracker.isConnected(), "Connection not open");
      Asserts.check(this.tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
      boolean var4;
      if(!this.tracker.isLayered()) {
         var4 = true;
      } else {
         var4 = false;
      }

      Asserts.check(var4, "Multiple protocol layering not supported");
      HttpHost var5 = this.tracker.getTargetHost();
      this.connOperator.updateSecureConnection(this.connection, var5, var1, var2);
      this.tracker.layerProtocol(this.connection.isSecure());
   }

   public void open(HttpRoute var1, HttpContext var2, HttpParams var3) throws IOException {
      Args.notNull(var1, "Route");
      Args.notNull(var3, "HTTP parameters");
      if(this.tracker != null) {
         boolean var11;
         if(!this.tracker.isConnected()) {
            var11 = true;
         } else {
            var11 = false;
         }

         Asserts.check(var11, "Connection already open");
      }

      this.tracker = new RouteTracker(var1);
      HttpHost var6 = var1.getProxyHost();
      ClientConnectionOperator var7 = this.connOperator;
      OperatedClientConnection var8 = this.connection;
      HttpHost var9;
      if(var6 != null) {
         var9 = var6;
      } else {
         var9 = var1.getTargetHost();
      }

      var7.openConnection(var8, var9, var1.getLocalAddress(), var2, var3);
      RouteTracker var10 = this.tracker;
      if(var10 == null) {
         throw new InterruptedIOException("Request aborted");
      } else if(var6 == null) {
         var10.connectTarget(this.connection.isSecure());
      } else {
         var10.connectProxy(var6, this.connection.isSecure());
      }
   }

   public void setState(Object var1) {
      this.state = var1;
   }

   protected void shutdownEntry() {
      this.tracker = null;
      this.state = null;
   }

   public void tunnelProxy(HttpHost var1, boolean var2, HttpParams var3) throws IOException {
      Args.notNull(var1, "Next proxy");
      Args.notNull(var3, "Parameters");
      Asserts.notNull(this.tracker, "Route tracker");
      Asserts.check(this.tracker.isConnected(), "Connection not open");
      this.connection.update((Socket)null, var1, var2, var3);
      this.tracker.tunnelProxy(var1, var2);
   }

   public void tunnelTarget(boolean var1, HttpParams var2) throws IOException {
      Args.notNull(var2, "HTTP parameters");
      Asserts.notNull(this.tracker, "Route tracker");
      Asserts.check(this.tracker.isConnected(), "Connection not open");
      boolean var4;
      if(!this.tracker.isTunnelled()) {
         var4 = true;
      } else {
         var4 = false;
      }

      Asserts.check(var4, "Connection is already tunnelled");
      this.connection.update((Socket)null, this.tracker.getTargetHost(), var1, var2);
      this.tracker.tunnelTarget(var1);
   }
}
