package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.class_459;
import com.google.android.gms.internal.class_65;
import com.google.android.gms.internal.class_66;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.j
public abstract class class_460 extends class_459 {
   // $FF: renamed from: jS java.lang.reflect.Method
   private static Method field_2754;
   // $FF: renamed from: jT java.lang.reflect.Method
   private static Method field_2755;
   // $FF: renamed from: jU java.lang.reflect.Method
   private static Method field_2756;
   // $FF: renamed from: jV java.lang.reflect.Method
   private static Method field_2757;
   // $FF: renamed from: jW java.lang.reflect.Method
   private static Method field_2758;
   // $FF: renamed from: jX java.lang.reflect.Method
   private static Method field_2759;
   // $FF: renamed from: jY java.lang.String
   private static String field_2760;
   // $FF: renamed from: jZ com.google.android.gms.internal.p
   private static class_454 field_2761;
   // $FF: renamed from: ka boolean
   static boolean field_2762 = false;
   private static long startTime = 0L;

   protected class_460(Context var1, class_65 var2, class_66 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.n) java.lang.String
   static String method_2842(Context param0, class_65 param1) throws class_460.class_1164 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.view.MotionEvent, android.util.DisplayMetrics) java.util.ArrayList
   static ArrayList<Long> method_2843(MotionEvent var0, DisplayMetrics var1) throws class_460.class_1164 {
      if(field_2757 != null && var0 != null) {
         try {
            ArrayList var4 = (ArrayList)field_2757.invoke((Object)null, new Object[]{var0, var1});
            return var4;
         } catch (IllegalAccessException var5) {
            throw new class_460.class_1164(var5);
         } catch (InvocationTargetException var6) {
            throw new class_460.class_1164(var6);
         }
      } else {
         throw new class_460.class_1164();
      }
   }

   // $FF: renamed from: a (java.lang.String, android.content.Context, com.google.android.gms.internal.n) void
   protected static void method_2844(String param0, Context param1, class_65 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.n) java.lang.String
   static String method_2845(Context param0, class_65 param1) throws class_460.class_1164 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (byte[], java.lang.String) java.lang.String
   private static String method_2846(byte[] var0, String var1) throws class_460.class_1164 {
      try {
         String var2 = new String(field_2761.method_2813(var0, var1), "UTF-8");
         return var2;
      } catch (class_454.class_1168 var5) {
         throw new class_460.class_1164(var5);
      } catch (UnsupportedEncodingException var6) {
         throw new class_460.class_1164(var6);
      }
   }

   // $FF: renamed from: d (android.content.Context) java.lang.String
   static String method_2847(Context param0) throws class_460.class_1164 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (android.content.Context) void
   private static void method_2848(Context param0) throws class_460.class_1164 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: v () java.lang.String
   static String method_2849() throws class_460.class_1164 {
      if(field_2760 == null) {
         throw new class_460.class_1164();
      } else {
         return field_2760;
      }
   }

   // $FF: renamed from: w () java.lang.Long
   static Long method_2850() throws class_460.class_1164 {
      if(field_2754 == null) {
         throw new class_460.class_1164();
      } else {
         try {
            Long var2 = (Long)field_2754.invoke((Object)null, new Object[0]);
            return var2;
         } catch (IllegalAccessException var3) {
            throw new class_460.class_1164(var3);
         } catch (InvocationTargetException var4) {
            throw new class_460.class_1164(var4);
         }
      }
   }

   // $FF: renamed from: x () java.lang.String
   static String method_2851() throws class_460.class_1164 {
      if(field_2755 == null) {
         throw new class_460.class_1164();
      } else {
         try {
            String var2 = (String)field_2755.invoke((Object)null, new Object[0]);
            return var2;
         } catch (IllegalAccessException var3) {
            throw new class_460.class_1164(var3);
         } catch (InvocationTargetException var4) {
            throw new class_460.class_1164(var4);
         }
      }
   }

   // $FF: renamed from: b (android.content.Context) void
   protected void method_2840(Context var1) {
      try {
         try {
            this.a(1, method_2851());
         } catch (class_460.class_1164 var10) {
            ;
         }

         try {
            this.a(2, method_2849());
         } catch (class_460.class_1164 var9) {
            ;
         }

         try {
            this.a(25, method_2850().longValue());
         } catch (class_460.class_1164 var8) {
            ;
         }

         try {
            this.a(24, method_2847(var1));
         } catch (class_460.class_1164 var7) {
            ;
         }
      } catch (IOException var11) {
         ;
      }
   }

   // $FF: renamed from: c (android.content.Context) void
   protected void method_2841(Context var1) {
      try {
         try {
            this.a(2, method_2849());
         } catch (class_460.class_1164 var17) {
            ;
         }

         try {
            this.a(1, method_2851());
         } catch (class_460.class_1164 var16) {
            ;
         }

         try {
            long var10 = method_2850().longValue();
            this.a(25, var10);
            if(startTime != 0L) {
               this.a(17, var10 - startTime);
               this.a(23, startTime);
            }
         } catch (class_460.class_1164 var15) {
            ;
         }

         try {
            ArrayList var9 = method_2843(this.jO, this.jP);
            this.a(14, ((Long)var9.get(0)).longValue());
            this.a(15, ((Long)var9.get(1)).longValue());
            if(var9.size() >= 3) {
               this.a(16, ((Long)var9.get(2)).longValue());
            }
         } catch (class_460.class_1164 var14) {
            ;
         }

         try {
            this.a(27, method_2842(var1, this.jQ));
         } catch (class_460.class_1164 var13) {
            ;
         }

         try {
            this.a(29, method_2845(var1, this.jQ));
         } catch (class_460.class_1164 var12) {
            ;
         }
      } catch (IOException var18) {
         ;
      }
   }

   static class class_1164 extends Exception {
      public class_1164() {
      }

      public class_1164(Throwable var1) {
         super(var1);
      }
   }
}
