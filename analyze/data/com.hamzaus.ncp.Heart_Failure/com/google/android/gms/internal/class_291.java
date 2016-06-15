package com.google.android.gms.internal;

import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.ih
public final class class_291 {
   // $FF: renamed from: a (java.lang.StringBuilder, double[]) void
   public static void method_1959(StringBuilder var0, double[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Double.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, float[]) void
   public static void method_1960(StringBuilder var0, float[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Float.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, int[]) void
   public static void method_1961(StringBuilder var0, int[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Integer.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, long[]) void
   public static void method_1962(StringBuilder var0, long[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Long.toString(var1[var3]));
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.Object[]) void
   public static <T> void method_1963(StringBuilder var0, T[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(var1[var3].toString());
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String[]) void
   public static void method_1964(StringBuilder var0, String[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append("\"").append(var1[var3]).append("\"");
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, boolean[]) void
   public static void method_1965(StringBuilder var0, boolean[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Boolean.toString(var1[var3]));
      }

   }

   // $FF: renamed from: fV () java.util.ArrayList
   public static <T> ArrayList<T> method_1966() {
      return new ArrayList();
   }
}
