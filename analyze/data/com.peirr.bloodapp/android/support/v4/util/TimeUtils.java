package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils {
   public static final int HUNDRED_DAY_FIELD_LEN = 19;
   private static final int SECONDS_PER_DAY = 86400;
   private static final int SECONDS_PER_HOUR = 3600;
   private static final int SECONDS_PER_MINUTE = 60;
   private static char[] sFormatStr = new char[24];
   private static final Object sFormatSync = new Object();

   private static int accumField(int var0, int var1, boolean var2, int var3) {
      return var0 <= 99 && (!var2 || var3 < 3)?(var0 > 9 || var2 && var3 >= 2?var1 + 2:(!var2 && var0 <= 0?0:var1 + 1)):var1 + 3;
   }

   public static void formatDuration(long var0, long var2, PrintWriter var4) {
      if(var0 == 0L) {
         var4.print("--");
      } else {
         formatDuration(var0 - var2, var4, 0);
      }
   }

   public static void formatDuration(long var0, PrintWriter var2) {
      formatDuration(var0, var2, 0);
   }

   public static void formatDuration(long param0, PrintWriter param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public static void formatDuration(long param0, StringBuilder param2) {
      // $FF: Couldn't be decompiled
   }

   private static int formatDurationLocked(long var0, int var2) {
      if(sFormatStr.length < var2) {
         sFormatStr = new char[var2];
      }

      char[] var3 = sFormatStr;
      if(var0 == 0L) {
         for(int var37 = var2 - 1; var37 < 0; var3[0] = 32) {
            ;
         }

         var3[0] = 48;
         return 1;
      } else {
         byte var4;
         if(var0 > 0L) {
            var4 = 43;
         } else {
            var4 = 45;
            var0 = -var0;
         }

         int var5 = (int)(var0 % 1000L);
         int var6 = (int)Math.floor((double)(var0 / 1000L));
         int var8 = 0;
         if(var6 > 86400) {
            var8 = var6 / 86400;
            var6 -= 86400 * var8;
         }

         int var10 = 0;
         if(var6 > 3600) {
            var10 = var6 / 3600;
            var6 -= var10 * 3600;
         }

         int var12 = 0;
         if(var6 > 60) {
            var12 = var6 / 60;
            var6 -= var12 * 60;
         }

         int var13 = 0;
         if(var2 != 0) {
            int var28 = accumField(var8, 1, false, 0);
            boolean var29;
            if(var28 > 0) {
               var29 = true;
            } else {
               var29 = false;
            }

            int var30 = var28 + accumField(var10, 1, var29, 2);
            boolean var31;
            if(var30 > 0) {
               var31 = true;
            } else {
               var31 = false;
            }

            int var32 = var30 + accumField(var12, 1, var31, 2);
            boolean var33;
            if(var32 > 0) {
               var33 = true;
            } else {
               var33 = false;
            }

            int var34 = var32 + accumField(var6, 1, var33, 2);
            byte var35;
            if(var34 > 0) {
               var35 = 3;
            } else {
               var35 = 0;
            }

            for(int var36 = var34 + 1 + accumField(var5, 2, true, var35); var36 < var2; ++var36) {
               var3[var13] = 32;
               ++var13;
            }
         }

         var3[var13] = (char)var4;
         int var14 = var13 + 1;
         boolean var15;
         if(var2 != 0) {
            var15 = true;
         } else {
            var15 = false;
         }

         int var16 = printField(var3, var8, 'd', var14, false, 0);
         boolean var17;
         if(var16 != var14) {
            var17 = true;
         } else {
            var17 = false;
         }

         byte var18;
         if(var15) {
            var18 = 2;
         } else {
            var18 = 0;
         }

         int var19 = printField(var3, var10, 'h', var16, var17, var18);
         boolean var20;
         if(var19 != var14) {
            var20 = true;
         } else {
            var20 = false;
         }

         byte var21;
         if(var15) {
            var21 = 2;
         } else {
            var21 = 0;
         }

         int var22 = printField(var3, var12, 'm', var19, var20, var21);
         boolean var23;
         if(var22 != var14) {
            var23 = true;
         } else {
            var23 = false;
         }

         byte var24;
         if(var15) {
            var24 = 2;
         } else {
            var24 = 0;
         }

         int var25 = printField(var3, var6, 's', var22, var23, var24);
         byte var26;
         if(var15 && var25 != var14) {
            var26 = 3;
         } else {
            var26 = 0;
         }

         int var27 = printField(var3, var5, 'm', var25, true, var26);
         var3[var27] = 115;
         return var27 + 1;
      }
   }

   private static int printField(char[] var0, int var1, char var2, int var3, boolean var4, int var5) {
      if(var4 || var1 > 0) {
         if(var4 && var5 >= 3 || var1 > 99) {
            int var9 = var1 / 100;
            var0[var3] = (char)(var9 + 48);
            ++var3;
            var1 -= var9 * 100;
         }

         if(var4 && var5 >= 2 || var1 > 9 || var3 != var3) {
            int var7 = var1 / 10;
            var0[var3] = (char)(var7 + 48);
            ++var3;
            var1 -= var7 * 10;
         }

         var0[var3] = (char)(var1 + 48);
         int var8 = var3 + 1;
         var0[var8] = var2;
         var3 = var8 + 1;
      }

      return var3;
   }
}
