package com.google.android.gms.internal;

public final class zzmy {
   public static String zza(byte[] var0, int var1, int var2, boolean var3) {
      if(var0 != null && var0.length != 0 && var1 >= 0 && var2 > 0 && var1 + var2 <= var0.length) {
         byte var4 = 57;
         if(var3) {
            var4 = 75;
         }

         StringBuilder var5 = new StringBuilder(var4 * ((-1 + var2 + 16) / 16));
         int var6 = var1;
         int var7 = var2;
         int var8 = 0;

         int var13;
         for(int var9 = 0; var7 > 0; var7 = var13) {
            if(var9 == 0) {
               if(var2 < 65536) {
                  Object[] var27 = new Object[]{Integer.valueOf(var6)};
                  var5.append(String.format("%04X:", var27));
                  var8 = var6;
               } else {
                  Object[] var25 = new Object[]{Integer.valueOf(var6)};
                  var5.append(String.format("%08X:", var25));
                  var8 = var6;
               }
            } else if(var9 == 8) {
               var5.append(" -");
            }

            Object[] var11 = new Object[]{Integer.valueOf(255 & var0[var6])};
            var5.append(String.format(" %02X", var11));
            var13 = var7 - 1;
            int var14 = var9 + 1;
            if(var3 && (var14 == 16 || var13 == 0)) {
               int var17 = 16 - var14;
               if(var17 > 0) {
                  for(int var23 = 0; var23 < var17; ++var23) {
                     var5.append("   ");
                  }
               }

               if(var17 >= 8) {
                  var5.append("  ");
               }

               var5.append("  ");

               for(int var19 = 0; var19 < var14; ++var19) {
                  char var20 = (char)var0[var8 + var19];
                  if(var20 < 32 || var20 > 126) {
                     var20 = 46;
                  }

                  var5.append(var20);
               }
            }

            int var16;
            if(var14 != 16 && var13 != 0) {
               var16 = var14;
            } else {
               var5.append('\n');
               var16 = 0;
            }

            ++var6;
            var9 = var16;
         }

         return var5.toString();
      } else {
         return null;
      }
   }
}
