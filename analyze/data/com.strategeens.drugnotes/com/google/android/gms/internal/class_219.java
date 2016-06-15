package com.google.android.gms.internal;

import com.google.android.gms.internal.class_221;
import com.google.android.gms.internal.class_368;
import java.util.PriorityQueue;

// $FF: renamed from: com.google.android.gms.internal.as
public class class_219 {
   // $FF: renamed from: a (int, int, long, long, long) long
   static long method_1531(int var0, int var1, long var2, long var4, long var6) {
      long var8 = var4 * ((2147483647L + (long)var0) % 1073807359L) % 1073807359L;
      return (var6 * ((var2 + 1073807359L - var8) % 1073807359L) % 1073807359L + (2147483647L + (long)var1) % 1073807359L) % 1073807359L;
   }

   // $FF: renamed from: a (long, int) long
   static long method_1532(long var0, int var2) {
      if(var2 == 0) {
         var0 = 1L;
      } else if(var2 != 1) {
         if(var2 % 2 == 0) {
            return method_1532(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L;
         }

         return var0 * (method_1532(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L) % 1073807359L;
      }

      return var0;
   }

   // $FF: renamed from: a (java.lang.String[], int, int) java.lang.String
   static String method_1533(String[] var0, int var1, int var2) {
      if(var0.length < var1 + var2) {
         class_368.method_2503("Unable to construct shingle");
         return "";
      } else {
         StringBuffer var3 = new StringBuffer();

         for(int var4 = var1; var4 < -1 + var1 + var2; ++var4) {
            var3.append(var0[var4]);
            var3.append(' ');
         }

         var3.append(var0[-1 + var1 + var2]);
         return var3.toString();
      }
   }

   // $FF: renamed from: a (int, long, java.lang.String, java.util.PriorityQueue) void
   static void method_1534(int var0, long var1, String var3, PriorityQueue<class_219.class_1104> var4) {
      class_219.class_1104 var5 = new class_219.class_1104(var1, var3);
      if((var4.size() != var0 || ((class_219.class_1104)var4.peek()).value <= var5.value) && !var4.contains(var5)) {
         var4.add(var5);
         if(var4.size() > var0) {
            var4.poll();
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String[], int, int, java.util.PriorityQueue) void
   public static void method_1535(String[] var0, int var1, int var2, PriorityQueue<class_219.class_1104> var3) {
      long var4 = method_1536(var0, 0, var2);
      method_1534(var1, var4, method_1533(var0, 0, var2), var3);
      long var6 = method_1532(16785407L, var2 - 1);

      for(int var8 = 1; var8 < 1 + (var0.length - var2); ++var8) {
         var4 = method_1531(class_221.method_1540(var0[var8 - 1]), class_221.method_1540(var0[-1 + var8 + var2]), var4, var6, 16785407L);
         method_1534(var1, var4, method_1533(var0, var8, var2), var3);
      }

   }

   // $FF: renamed from: b (java.lang.String[], int, int) long
   private static long method_1536(String[] var0, int var1, int var2) {
      long var3 = (2147483647L + (long)class_221.method_1540(var0[var1])) % 1073807359L;

      for(int var5 = var1 + 1; var5 < var1 + var2; ++var5) {
         var3 = (var3 * 16785407L % 1073807359L + (2147483647L + (long)class_221.method_1540(var0[var5])) % 1073807359L) % 1073807359L;
      }

      return var3;
   }

   public static class class_1104 {
      // $FF: renamed from: oa java.lang.String
      final String field_897;
      final long value;

      class_1104(long var1, String var3) {
         this.value = var1;
         this.field_897 = var3;
      }

      public boolean equals(Object var1) {
         return var1 != null && var1 instanceof class_219.class_1104 && ((class_219.class_1104)var1).value == this.value;
      }

      public int hashCode() {
         return (int)this.value;
      }
   }
}
