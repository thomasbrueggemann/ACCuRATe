package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.internal.hb
public abstract class class_350 implements SafeParcelable {
   // $FF: renamed from: FU java.lang.Object
   private static final Object field_1425 = new Object();
   // $FF: renamed from: FV java.lang.ClassLoader
   private static ClassLoader field_1426 = null;
   // $FF: renamed from: FW java.lang.Integer
   private static Integer field_1427 = null;
   // $FF: renamed from: FX boolean
   private boolean field_1428 = false;

   // $FF: renamed from: a (java.lang.Class) boolean
   private static boolean method_2175(Class<?> var0) {
      try {
         boolean var3 = "SAFE_PARCELABLE_NULL_STRING".equals(var0.getField("NULL").get((Object)null));
         return var3;
      } catch (NoSuchFieldException var4) {
         return false;
      } catch (IllegalAccessException var5) {
         return false;
      }
   }

   // $FF: renamed from: aA (java.lang.String) boolean
   protected static boolean method_2176(String var0) {
      ClassLoader var1 = method_2177();
      if(var1 == null) {
         return true;
      } else {
         try {
            boolean var3 = method_2175(var1.loadClass(var0));
            return var3;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   // $FF: renamed from: fk () java.lang.ClassLoader
   protected static ClassLoader method_2177() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: fl () java.lang.Integer
   protected static Integer method_2178() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: fm () boolean
   protected boolean method_2179() {
      return this.field_1428;
   }
}
