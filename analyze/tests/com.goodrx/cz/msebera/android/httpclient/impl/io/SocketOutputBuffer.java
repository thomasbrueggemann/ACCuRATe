package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.impl.io.AbstractSessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
   public SocketOutputBuffer(Socket var1, int var2, HttpParams var3) throws IOException {
      Args.notNull(var1, "Socket");
      int var5 = var2;
      if(var2 < 0) {
         var5 = var1.getSendBufferSize();
      }

      if(var5 < 1024) {
         var5 = 1024;
      }

      this.init(var1.getOutputStream(), var5, var3);
   }
}
