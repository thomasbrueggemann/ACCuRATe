package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;

public final class GifFormatChecker {
   private static final byte[] FRAME_HEADER_END_1 = new byte[]{(byte)0, (byte)44};
   private static final byte[] FRAME_HEADER_END_2 = new byte[]{(byte)0, (byte)33};
   private static final int FRAME_HEADER_SIZE = 10;
   private static final byte[] FRAME_HEADER_START = new byte[]{(byte)0, (byte)33, (byte)-7, (byte)4};

   @VisibleForTesting
   static boolean circularBufferMatchesBytePattern(byte[] var0, int var1, byte[] var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var2);
      boolean var5;
      if(var1 >= 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      Preconditions.checkArgument(var5);
      if(var2.length <= var0.length) {
         int var6 = 0;

         while(true) {
            if(var6 >= var2.length) {
               return true;
            }

            if(var0[(var6 + var1) % var0.length] != var2[var6]) {
               break;
            }

            ++var6;
         }
      }

      return false;
   }

   public static boolean isAnimated(InputStream param0) {
      // $FF: Couldn't be decompiled
   }
}
