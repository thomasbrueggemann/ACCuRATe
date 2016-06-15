package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.internal.ji
public abstract class class_345 implements SafeParcelable {
   // $FF: renamed from: MA java.lang.ClassLoader
   private static ClassLoader field_973 = null;
   // $FF: renamed from: MB java.lang.Integer
   private static Integer field_974 = null;
   // $FF: renamed from: Mz java.lang.Object
   private static final Object field_975 = new Object();
   // $FF: renamed from: MC boolean
   private boolean field_976 = false;

   // $FF: renamed from: a (java.lang.Class) boolean
   private static boolean method_2363(Class<?> var0) {
      try {
         boolean var3 = "SAFE_PARCELABLE_NULL_STRING".equals(var0.getField("NULL").get((Object)null));
         return var3;
      } catch (NoSuchFieldException var4) {
         return false;
      } catch (IllegalAccessException var5) {
         return false;
      }
   }

   // $FF: renamed from: aW (java.lang.String) boolean
   protected static boolean method_2364(String var0) {
      ClassLoader var1 = method_2365();
      if(var1 == null) {
         return true;
      } else {
         try {
            boolean var3 = method_2363(var1.loadClass(var0));
            return var3;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   // $FF: renamed from: hs () java.lang.ClassLoader
   protected static ClassLoader method_2365() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ht () java.lang.Integer
   protected static Integer method_2366() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: hu () boolean
   protected boolean method_2367() {
      return this.field_976;
   }
}
