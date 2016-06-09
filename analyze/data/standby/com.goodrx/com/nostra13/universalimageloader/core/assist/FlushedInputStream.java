package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlushedInputStream extends FilterInputStream {
   public FlushedInputStream(InputStream var1) {
      super(var1);
   }

   public long skip(long var1) throws IOException {
      long var3;
      long var5;
      for(var3 = 0L; var3 < var1; var3 += var5) {
         var5 = this.in.skip(var1 - var3);
         if(var5 == 0L) {
            if(this.read() < 0) {
               break;
            }

            var5 = 1L;
         }
      }

      return var3;
   }
}
