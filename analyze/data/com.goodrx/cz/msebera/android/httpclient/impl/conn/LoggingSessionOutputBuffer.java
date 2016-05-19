package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.impl.conn.Wire;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

@Deprecated
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
   private final String charset;
   private final SessionOutputBuffer out;
   private final Wire wire;

   public LoggingSessionOutputBuffer(SessionOutputBuffer var1, Wire var2, String var3) {
      this.out = var1;
      this.wire = var2;
      if(var3 == null) {
         var3 = Consts.ASCII.name();
      }

      this.charset = var3;
   }

   public void flush() throws IOException {
      this.out.flush();
   }

   public HttpTransportMetrics getMetrics() {
      return this.out.getMetrics();
   }

   public void write(int var1) throws IOException {
      this.out.write(var1);
      if(this.wire.enabled()) {
         this.wire.output(var1);
      }

   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.out.write(var1, var2, var3);
      if(this.wire.enabled()) {
         this.wire.output(var1, var2, var3);
      }

   }

   public void writeLine(CharArrayBuffer var1) throws IOException {
      this.out.writeLine(var1);
      if(this.wire.enabled()) {
         String var2 = new String(var1.buffer(), 0, var1.length());
         String var3 = var2 + "\r\n";
         this.wire.output(var3.getBytes(this.charset));
      }

   }

   public void writeLine(String var1) throws IOException {
      this.out.writeLine(var1);
      if(this.wire.enabled()) {
         String var2 = var1 + "\r\n";
         this.wire.output(var2.getBytes(this.charset));
      }

   }
}
