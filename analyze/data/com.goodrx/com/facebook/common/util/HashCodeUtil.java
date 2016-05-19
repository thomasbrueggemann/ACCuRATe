package com.facebook.common.util;

import javax.annotation.Nullable;

public class HashCodeUtil {
   // $FF: renamed from: X int
   private static final int field_536 = 31;

   public static int hashCode(int var0) {
      return var0 + 31;
   }

   public static int hashCode(int var0, int var1) {
      return var1 + 31 * (var0 + 31);
   }

   public static int hashCode(int var0, int var1, int var2) {
      return var2 + 31 * (var1 + 31 * (var0 + 31));
   }

   public static int hashCode(int var0, int var1, int var2, int var3) {
      return var3 + 31 * (var2 + 31 * (var1 + 31 * (var0 + 31)));
   }

   public static int hashCode(int var0, int var1, int var2, int var3, int var4) {
      return var4 + 31 * (var3 + 31 * (var2 + 31 * (var1 + 31 * (var0 + 31))));
   }

   public static int hashCode(int var0, int var1, int var2, int var3, int var4, int var5) {
      return var5 + 31 * (var4 + 31 * (var3 + 31 * (var2 + 31 * (var1 + 31 * (var0 + 31)))));
   }

   public static int hashCode(@Nullable Object var0) {
      int var1;
      if(var0 == null) {
         var1 = 0;
      } else {
         var1 = var0.hashCode();
      }

      return hashCode(var1);
   }

   public static int hashCode(@Nullable Object var0, @Nullable Object var1) {
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = var0.hashCode();
      }

      int var3 = 0;
      if(var1 != null) {
         var3 = var1.hashCode();
      }

      return hashCode(var2, var3);
   }

   public static int hashCode(@Nullable Object var0, @Nullable Object var1, @Nullable Object var2) {
      int var3;
      if(var0 == null) {
         var3 = 0;
      } else {
         var3 = var0.hashCode();
      }

      int var4;
      if(var1 == null) {
         var4 = 0;
      } else {
         var4 = var1.hashCode();
      }

      int var5 = 0;
      if(var2 != null) {
         var5 = var2.hashCode();
      }

      return hashCode(var3, var4, var5);
   }

   public static int hashCode(@Nullable Object var0, @Nullable Object var1, @Nullable Object var2, @Nullable Object var3) {
      int var4;
      if(var0 == null) {
         var4 = 0;
      } else {
         var4 = var0.hashCode();
      }

      int var5;
      if(var1 == null) {
         var5 = 0;
      } else {
         var5 = var1.hashCode();
      }

      int var6;
      if(var2 == null) {
         var6 = 0;
      } else {
         var6 = var2.hashCode();
      }

      int var7 = 0;
      if(var3 != null) {
         var7 = var3.hashCode();
      }

      return hashCode(var4, var5, var6, var7);
   }

   public static int hashCode(@Nullable Object var0, @Nullable Object var1, @Nullable Object var2, @Nullable Object var3, @Nullable Object var4) {
      int var5;
      if(var0 == null) {
         var5 = 0;
      } else {
         var5 = var0.hashCode();
      }

      int var6;
      if(var1 == null) {
         var6 = 0;
      } else {
         var6 = var1.hashCode();
      }

      int var7;
      if(var2 == null) {
         var7 = 0;
      } else {
         var7 = var2.hashCode();
      }

      int var8;
      if(var3 == null) {
         var8 = 0;
      } else {
         var8 = var3.hashCode();
      }

      int var9 = 0;
      if(var4 != null) {
         var9 = var4.hashCode();
      }

      return hashCode(var5, var6, var7, var8, var9);
   }

   public static int hashCode(@Nullable Object var0, @Nullable Object var1, @Nullable Object var2, @Nullable Object var3, @Nullable Object var4, @Nullable Object var5) {
      int var6;
      if(var0 == null) {
         var6 = 0;
      } else {
         var6 = var0.hashCode();
      }

      int var7;
      if(var1 == null) {
         var7 = 0;
      } else {
         var7 = var1.hashCode();
      }

      int var8;
      if(var2 == null) {
         var8 = 0;
      } else {
         var8 = var2.hashCode();
      }

      int var9;
      if(var3 == null) {
         var9 = 0;
      } else {
         var9 = var3.hashCode();
      }

      int var10;
      if(var4 == null) {
         var10 = 0;
      } else {
         var10 = var4.hashCode();
      }

      int var11 = 0;
      if(var5 != null) {
         var11 = var5.hashCode();
      }

      return hashCode(var6, var7, var8, var9, var10, var11);
   }
}
