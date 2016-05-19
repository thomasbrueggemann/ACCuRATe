package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.impl.AbstractHttpClientConnection;
import cz.msebera.android.httpclient.impl.io.SocketInputBuffer;
import cz.msebera.android.httpclient.impl.io.SocketOutputBuffer;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

@Deprecated
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
   private volatile boolean open;
   private volatile Socket socket = null;

   private static void formatAddress(StringBuilder var0, SocketAddress var1) {
      if(var1 instanceof InetSocketAddress) {
         InetSocketAddress var3 = (InetSocketAddress)var1;
         Object var4;
         if(var3.getAddress() != null) {
            var4 = var3.getAddress().getHostAddress();
         } else {
            var4 = var3.getAddress();
         }

         var0.append(var4).append(':').append(var3.getPort());
      } else {
         var0.append(var1);
      }
   }

   protected void assertNotOpen() {
      boolean var1;
      if(!this.open) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "Connection is already open");
   }

   protected void assertOpen() {
      Asserts.check(this.open, "Connection is not open");
   }

   protected void bind(Socket var1, HttpParams var2) throws IOException {
      Args.notNull(var1, "Socket");
      Args.notNull(var2, "HTTP parameters");
      this.socket = var1;
      int var5 = var2.getIntParameter("http.socket.buffer-size", -1);
      this.init(this.createSessionInputBuffer(var1, var5, var2), this.createSessionOutputBuffer(var1, var5, var2), var2);
      this.open = true;
   }

   public void close() throws IOException {
      if(this.open) {
         this.open = false;
         Socket var1 = this.socket;

         try {
            this.doFlush();

            try {
               try {
                  var1.shutdownOutput();
               } catch (IOException var11) {
                  ;
               }

               try {
                  var1.shutdownInput();
               } catch (IOException var10) {
                  ;
               }
            } catch (UnsupportedOperationException var12) {
               ;
            }
         } finally {
            var1.close();
         }

      }
   }

   protected SessionInputBuffer createSessionInputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      return new SocketInputBuffer(var1, var2, var3);
   }

   protected SessionOutputBuffer createSessionOutputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      return new SocketOutputBuffer(var1, var2, var3);
   }

   public InetAddress getRemoteAddress() {
      return this.socket != null?this.socket.getInetAddress():null;
   }

   public int getRemotePort() {
      return this.socket != null?this.socket.getPort():-1;
   }

   protected Socket getSocket() {
      return this.socket;
   }

   public boolean isOpen() {
      return this.open;
   }

   public void setSocketTimeout(int var1) {
      this.assertOpen();
      if(this.socket != null) {
         try {
            this.socket.setSoTimeout(var1);
         } catch (SocketException var3) {
            return;
         }
      }

   }

   public void shutdown() throws IOException {
      this.open = false;
      Socket var1 = this.socket;
      if(var1 != null) {
         var1.close();
      }

   }

   public String toString() {
      if(this.socket != null) {
         StringBuilder var1 = new StringBuilder();
         SocketAddress var2 = this.socket.getRemoteSocketAddress();
         SocketAddress var3 = this.socket.getLocalSocketAddress();
         if(var2 != null && var3 != null) {
            formatAddress(var1, var3);
            var1.append("<->");
            formatAddress(var1, var2);
         }

         return var1.toString();
      } else {
         return super.toString();
      }
   }
}
