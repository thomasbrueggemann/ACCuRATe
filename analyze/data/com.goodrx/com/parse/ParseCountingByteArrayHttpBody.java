package com.parse;

import com.parse.ParseByteArrayHttpBody;
import com.parse.ProgressCallback;
import java.io.IOException;
import java.io.OutputStream;

class ParseCountingByteArrayHttpBody extends ParseByteArrayHttpBody {
   private static final int DEFAULT_CHUNK_SIZE = 4096;
   private final ProgressCallback progressCallback;

   public ParseCountingByteArrayHttpBody(byte[] var1, String var2, ProgressCallback var3) {
      super(var1, var2);
      this.progressCallback = var3;
   }

   public void writeTo(OutputStream var1) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("Output stream may not be null");
      } else {
         int var2 = 0;
         int var3 = this.content.length;

         while(var2 < var3) {
            int var4 = Math.min(var3 - var2, 4096);
            var1.write(this.content, var2, var4);
            var1.flush();
            if(this.progressCallback != null) {
               var2 += var4;
               int var5 = var2 * 100 / var3;
               this.progressCallback.done(Integer.valueOf(var5));
            }
         }

      }
   }
}
