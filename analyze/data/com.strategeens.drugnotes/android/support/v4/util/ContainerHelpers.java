package android.support.v4.util;

class ContainerHelpers {
   static final int[] EMPTY_INTS = new int[0];
   static final long[] EMPTY_LONGS = new long[0];
   static final Object[] EMPTY_OBJECTS = new Object[0];

   static int binarySearch(int[] var0, int var1, int var2) {
      int var3 = 0;
      int var4 = var1 - 1;

      int var5;
      while(true) {
         if(var3 > var4) {
            var5 = ~var3;
            break;
         }

         var5 = var3 + var4 >>> 1;
         int var6 = var0[var5];
         if(var6 < var2) {
            var3 = var5 + 1;
         } else {
            if(var6 <= var2) {
               break;
            }

            var4 = var5 - 1;
         }
      }

      return var5;
   }

   static int binarySearch(long[] var0, int var1, long var2) {
      int var4 = 0;
      int var5 = var1 - 1;

      int var6;
      while(true) {
         if(var4 > var5) {
            var6 = ~var4;
            break;
         }

         var6 = var4 + var5 >>> 1;
         long var7 = var0[var6];
         if(var7 < var2) {
            var4 = var6 + 1;
         } else {
            if(var7 <= var2) {
               break;
            }

            var5 = var6 - 1;
         }
      }

      return var6;
   }

   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static int idealByteArraySize(int var0) {
      for(int var1 = 4; var1 < 32; ++var1) {
         if(var0 <= -12 + (1 << var1)) {
            var0 = -12 + (1 << var1);
            break;
         }
      }

      return var0;
   }

   public static int idealIntArraySize(int var0) {
      return idealByteArraySize(var0 * 4) / 4;
   }

   public static int idealLongArraySize(int var0) {
      return idealByteArraySize(var0 * 8) / 8;
   }
}
