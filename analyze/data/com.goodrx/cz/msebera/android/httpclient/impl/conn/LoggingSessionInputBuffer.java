package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.impl.conn.Wire;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

@Deprecated
public class LoggingSessionInputBuffer implements EofSensor, SessionInputBuffer {
   private final String charset;
   private final EofSensor eofSensor;
   // $FF: renamed from: in cz.msebera.android.httpclient.io.SessionInputBuffer
   private final SessionInputBuffer field_457;
   private final Wire wire;

   public LoggingSessionInputBuffer(SessionInputBuffer var1, Wire var2, String var3) {
      this.field_457 = var1;
      EofSensor var4;
      if(var1 instanceof EofSensor) {
         var4 = (EofSensor)var1;
      } else {
         var4 = null;
      }

      this.eofSensor = var4;
      this.wire = var2;
      if(var3 == null) {
         var3 = Consts.ASCII.name();
      }

      this.charset = var3;
   }

   public HttpTransportMetrics getMetrics() {
      return this.field_457.getMetrics();
   }

   public boolean isDataAvailable(int var1) throws IOException {
      return this.field_457.isDataAvailable(var1);
   }

   public boolean isEof() {
      return this.eofSensor != null?this.eofSensor.isEof():false;
   }

   public int read() throws IOException {
      int var1 = this.field_457.read();
      if(this.wire.enabled() && var1 != -1) {
         this.wire.input(var1);
      }

      return var1;
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.field_457.read(var1, var2, var3);
      if(this.wire.enabled() && var4 > 0) {
         this.wire.input(var1, var2, var4);
      }

      return var4;
   }

   public int readLine(CharArrayBuffer var1) throws IOException {
      int var2 = this.field_457.readLine(var1);
      if(this.wire.enabled() && var2 >= 0) {
         int var3 = var1.length() - var2;
         String var4 = new String(var1.buffer(), var3, var2);
         String var5 = var4 + "\r\n";
         this.wire.input(var5.getBytes(this.charset));
      }

      return var2;
   }
}
