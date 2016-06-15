package com.google.android.gms.internal;

import com.google.android.gms.internal.class_336;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.la
public final class class_724 {
   // $FF: renamed from: a (java.lang.Object[], java.lang.Object) int
   public static <T> int method_4206(T[] var0, T var1) {
      int var2 = 0;
      int var3;
      if(var0 != null) {
         var3 = var0.length;
      } else {
         var3 = 0;
         var2 = 0;
      }

      while(var2 < var3) {
         if(class_336.equal(var0[var2], var1)) {
            return var2;
         }

         ++var2;
      }

      return -1;
   }

   // $FF: renamed from: a (java.lang.StringBuilder, double[]) void
   public static void method_4207(StringBuilder var0, double[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Double.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, float[]) void
   public static void method_4208(StringBuilder var0, float[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Float.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, int[]) void
   public static void method_4209(StringBuilder var0, int[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Integer.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, long[]) void
   public static void method_4210(StringBuilder var0, long[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Long.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.Object[]) void
   public static <T> void method_4211(StringBuilder var0, T[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(var1[var3].toString());
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String[]) void
   public static void method_4212(StringBuilder var0, String[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append("\"").append(var1[var3]).append("\"");
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, boolean[]) void
   public static void method_4213(StringBuilder var0, boolean[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Boolean.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (int[]) java.lang.Integer[]
   public static Integer[] method_4214(int[] var0) {
      Integer[] var2;
      if(var0 == null) {
         var2 = null;
      } else {
         int var1 = var0.length;
         var2 = new Integer[var1];

         for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = Integer.valueOf(var0[var3]);
         }
      }

      return var2;
   }

   // $FF: renamed from: b (java.lang.Object[]) java.util.ArrayList
   public static <T> ArrayList<T> method_4215(T[] var0) {
      int var1 = var0.length;
      ArrayList var2 = new ArrayList(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.add(var0[var3]);
      }

      return var2;
   }

   // $FF: renamed from: b (java.lang.Object[], java.lang.Object) boolean
   public static <T> boolean method_4216(T[] var0, T var1) {
      return method_4206(var0, var1) >= 0;
   }

   // $FF: renamed from: ie () java.util.ArrayList
   public static <T> ArrayList<T> method_4217() {
      return new ArrayList();
   }
}
