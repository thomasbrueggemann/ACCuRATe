package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
   private StringBuilder mBuilder = new StringBuilder(128);
   private final String mTag;

   public LogWriter(String var1) {
      this.mTag = var1;
   }

   private void flushBuilder() {
      if(this.mBuilder.length() > 0) {
         Log.d(this.mTag, this.mBuilder.toString());
         this.mBuilder.delete(0, this.mBuilder.length());
      }

   }

   public void close() {
      this.flushBuilder();
   }

   public void flush() {
      this.flushBuilder();
   }

   public void write(char[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var1[var2 + var4];
         if(var5 == 10) {
            this.flushBuilder();
         } else {
            this.mBuilder.append(var5);
         }
      }

   }
}
