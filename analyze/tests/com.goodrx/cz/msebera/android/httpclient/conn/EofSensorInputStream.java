package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.EofSensorWatcher;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
   private final EofSensorWatcher eofWatcher;
   private boolean selfClosed;
   protected InputStream wrappedStream;

   public EofSensorInputStream(InputStream var1, EofSensorWatcher var2) {
      Args.notNull(var1, "Wrapped stream");
      this.wrappedStream = var1;
      this.selfClosed = false;
      this.eofWatcher = var2;
   }

   public void abortConnection() throws IOException {
      this.selfClosed = true;
      this.checkAbort();
   }

   public int available() throws IOException {
      boolean var1 = this.isReadAllowed();
      int var2 = 0;
      if(var1) {
         int var4;
         try {
            var4 = this.wrappedStream.available();
         } catch (IOException var5) {
            this.checkAbort();
            throw var5;
         }

         var2 = var4;
      }

      return var2;
   }

   protected void checkAbort() throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void checkClose() throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected void checkEOF(int param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void close() throws IOException {
      this.selfClosed = true;
      this.checkClose();
   }

   protected boolean isReadAllowed() throws IOException {
      if(this.selfClosed) {
         throw new IOException("Attempted read on closed stream.");
      } else {
         return this.wrappedStream != null;
      }
   }

   public int read() throws IOException {
      int var1 = -1;
      if(this.isReadAllowed()) {
         try {
            var1 = this.wrappedStream.read();
            this.checkEOF(var1);
         } catch (IOException var3) {
            this.checkAbort();
            throw var3;
         }
      }

      return var1;
   }

   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = -1;
      if(this.isReadAllowed()) {
         try {
            var4 = this.wrappedStream.read(var1, var2, var3);
            this.checkEOF(var4);
         } catch (IOException var6) {
            this.checkAbort();
            throw var6;
         }
      }

      return var4;
   }

   public void releaseConnection() throws IOException {
      this.close();
   }
}
