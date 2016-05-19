package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.impl.io.AbstractSessionInputBuffer;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
   private boolean eof;
   private final Socket socket;

   public SocketInputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      Args.notNull(var1, "Socket");
      this.socket = var1;
      this.eof = false;
      int var5 = var2;
      if(var2 < 0) {
         var5 = var1.getReceiveBufferSize();
      }

      if(var5 < 1024) {
         var5 = 1024;
      }

      this.init(var1.getInputStream(), var5, var3);
   }

   protected int fillBuffer() throws IOException {
      int var1 = super.fillBuffer();
      boolean var2;
      if(var1 == -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.eof = var2;
      return var1;
   }

   public boolean isDataAvailable(int var1) throws IOException {
      boolean var2 = this.hasBufferedData();
      if(!var2) {
         int var3 = this.socket.getSoTimeout();
         boolean var8 = false;

         boolean var6;
         try {
            var8 = true;
            this.socket.setSoTimeout(var1);
            this.fillBuffer();
            var6 = this.hasBufferedData();
            var8 = false;
         } finally {
            if(var8) {
               this.socket.setSoTimeout(var3);
            }
         }

         var2 = var6;
         this.socket.setSoTimeout(var3);
      }

      return var2;
   }

   public boolean isEof() {
      return this.eof;
   }
}
