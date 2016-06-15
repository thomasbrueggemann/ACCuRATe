package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_553;
import com.google.android.gms.internal.class_554;
import com.google.android.gms.internal.class_71;
import com.google.android.gms.internal.class_72;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.i
public abstract class class_555 extends class_554 {
   // $FF: renamed from: kA java.lang.reflect.Method
   private static Method field_2545;
   // $FF: renamed from: kB java.lang.reflect.Method
   private static Method field_2546;
   // $FF: renamed from: kC java.lang.reflect.Method
   private static Method field_2547;
   // $FF: renamed from: kD java.lang.reflect.Method
   private static Method field_2548;
   // $FF: renamed from: kE java.lang.reflect.Method
   private static Method field_2549;
   // $FF: renamed from: kF java.lang.reflect.Method
   private static Method field_2550;
   // $FF: renamed from: kG java.lang.reflect.Method
   private static Method field_2551;
   // $FF: renamed from: kH java.lang.reflect.Method
   private static Method field_2552;
   // $FF: renamed from: kI java.lang.reflect.Method
   private static Method field_2553;
   // $FF: renamed from: kJ java.lang.String
   private static String field_2554;
   // $FF: renamed from: kK java.lang.String
   private static String field_2555;
   // $FF: renamed from: kL java.lang.String
   private static String field_2556;
   // $FF: renamed from: kM com.google.android.gms.internal.o
   private static class_553 field_2557;
   // $FF: renamed from: kN boolean
   static boolean field_2558 = false;
   private static long startTime = 0L;

   protected class_555(Context var1, class_71 var2, class_72 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.m) java.lang.String
   static String method_3370(Context param0, class_71 param1) throws class_555.class_1662 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.view.MotionEvent, android.util.DisplayMetrics) java.util.ArrayList
   static ArrayList<Long> method_3371(MotionEvent var0, DisplayMetrics var1) throws class_555.class_1662 {
      if(field_2549 != null && var0 != null) {
         try {
            ArrayList var4 = (ArrayList)field_2549.invoke((Object)null, new Object[]{var0, var1});
            return var4;
         } catch (IllegalAccessException var5) {
            throw new class_555.class_1662(var5);
         } catch (InvocationTargetException var6) {
            throw new class_555.class_1662(var6);
         }
      } else {
         throw new class_555.class_1662();
      }
   }

   // $FF: renamed from: a (java.lang.String, android.content.Context, com.google.android.gms.internal.m) void
   protected static void method_3372(String param0, Context param1, class_71 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.m) java.lang.String
   static String method_3373(Context param0, class_71 param1) throws class_555.class_1662 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (byte[], java.lang.String) java.lang.String
   private static String method_3374(byte[] var0, String var1) throws class_555.class_1662 {
      try {
         String var2 = new String(field_2557.method_3360(var0, var1), "UTF-8");
         return var2;
      } catch (class_553.class_1550 var5) {
         throw new class_555.class_1662(var5);
      } catch (UnsupportedEncodingException var6) {
         throw new class_555.class_1662(var6);
      }
   }

   // $FF: renamed from: d (android.content.Context) java.lang.String
   static String method_3375(Context param0) throws class_555.class_1662 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (android.content.Context) java.util.ArrayList
   static ArrayList<Long> method_3376(Context param0) throws class_555.class_1662 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (android.content.Context) int[]
   static int[] method_3377(Context var0) throws class_555.class_1662 {
      if(field_2553 == null) {
         throw new class_555.class_1662();
      } else {
         try {
            int[] var3 = (int[])((int[])field_2553.invoke((Object)null, new Object[]{var0}));
            return var3;
         } catch (IllegalAccessException var4) {
            throw new class_555.class_1662(var4);
         } catch (InvocationTargetException var5) {
            throw new class_555.class_1662(var5);
         }
      }
   }

   // $FF: renamed from: g (android.content.Context) void
   private static void method_3378(Context param0) throws class_555.class_1662 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: v () java.lang.String
   static String method_3379() throws class_555.class_1662 {
      if(field_2554 == null) {
         throw new class_555.class_1662();
      } else {
         return field_2554;
      }
   }

   // $FF: renamed from: w () java.lang.Long
   static Long method_3380() throws class_555.class_1662 {
      if(field_2545 == null) {
         throw new class_555.class_1662();
      } else {
         try {
            Long var2 = (Long)field_2545.invoke((Object)null, new Object[0]);
            return var2;
         } catch (IllegalAccessException var3) {
            throw new class_555.class_1662(var3);
         } catch (InvocationTargetException var4) {
            throw new class_555.class_1662(var4);
         }
      }
   }

   // $FF: renamed from: x () java.lang.String
   static String method_3381() throws class_555.class_1662 {
      if(field_2547 == null) {
         throw new class_555.class_1662();
      } else {
         try {
            String var2 = (String)field_2547.invoke((Object)null, new Object[0]);
            return var2;
         } catch (IllegalAccessException var3) {
            throw new class_555.class_1662(var3);
         } catch (InvocationTargetException var4) {
            throw new class_555.class_1662(var4);
         }
      }
   }

   // $FF: renamed from: y () java.lang.Long
   static Long method_3382() throws class_555.class_1662 {
      if(field_2546 == null) {
         throw new class_555.class_1662();
      } else {
         try {
            Long var2 = (Long)field_2546.invoke((Object)null, new Object[0]);
            return var2;
         } catch (IllegalAccessException var3) {
            throw new class_555.class_1662(var3);
         } catch (InvocationTargetException var4) {
            throw new class_555.class_1662(var4);
         }
      }
   }

   // $FF: renamed from: b (android.content.Context) void
   protected void method_3368(Context var1) {
      try {
         try {
            this.a(1, method_3381());
         } catch (class_555.class_1662 var22) {
            ;
         }

         try {
            this.a(2, method_3379());
         } catch (class_555.class_1662 var21) {
            ;
         }

         try {
            long var13 = method_3380().longValue();
            this.a(25, var13);
            if(startTime != 0L) {
               this.a(17, var13 - startTime);
               this.a(23, startTime);
            }
         } catch (class_555.class_1662 var20) {
            ;
         }

         try {
            ArrayList var12 = method_3376(var1);
            this.a(31, ((Long)var12.get(0)).longValue());
            this.a(32, ((Long)var12.get(1)).longValue());
         } catch (class_555.class_1662 var19) {
            ;
         }

         try {
            this.a(33, method_3382().longValue());
         } catch (class_555.class_1662 var18) {
            ;
         }

         try {
            this.a(27, method_3370(var1, this.ky));
         } catch (class_555.class_1662 var17) {
            ;
         }

         try {
            this.a(29, method_3373(var1, this.ky));
         } catch (class_555.class_1662 var16) {
            ;
         }

         try {
            int[] var11 = method_3377(var1);
            this.a(5, (long)var11[0]);
            this.a(6, (long)var11[1]);
         } catch (class_555.class_1662 var15) {
            ;
         }
      } catch (IOException var23) {
         ;
      }
   }

   // $FF: renamed from: c (android.content.Context) void
   protected void method_3369(Context var1) {
      try {
         try {
            this.a(2, method_3379());
         } catch (class_555.class_1662 var11) {
            ;
         }

         try {
            this.a(1, method_3381());
         } catch (class_555.class_1662 var10) {
            ;
         }

         try {
            this.a(25, method_3380().longValue());
         } catch (class_555.class_1662 var9) {
            ;
         }

         try {
            ArrayList var7 = method_3371(this.kw, this.kx);
            this.a(14, ((Long)var7.get(0)).longValue());
            this.a(15, ((Long)var7.get(1)).longValue());
            if(var7.size() >= 3) {
               this.a(16, ((Long)var7.get(2)).longValue());
            }

         } catch (class_555.class_1662 var8) {
            ;
         }
      } catch (IOException var12) {
         ;
      }
   }

   static class class_1662 extends Exception {
      public class_1662() {
      }

      public class_1662(Throwable var1) {
         super(var1);
      }
   }
}
