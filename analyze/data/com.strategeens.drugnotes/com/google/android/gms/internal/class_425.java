package com.google.android.gms.internal;

import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_374;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gu;
import java.util.Map;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.fs
@ey
public final class class_425 {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1353 = new Object();
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   class_371 field_1354;
   // $FF: renamed from: uE java.lang.String
   private String field_1355;
   // $FF: renamed from: uF com.google.android.gms.internal.gj
   private gj<fu> field_1356 = new class_374();
   // $FF: renamed from: uG com.google.android.gms.internal.cd
   public final class_46 field_1357 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };
   // $FF: renamed from: uH com.google.android.gms.internal.cd
   public final class_46 field_1358 = new class_46() {
      // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
      public void method_213(gu param1, Map<String, String> param2) {
         // $FF: Couldn't be decompiled
      }
   };

   public class_425(String var1) {
      this.field_1355 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fs) java.lang.Object
   // $FF: synthetic method
   static Object method_2815(class_425 var0) {
      return var0.field_1353;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.fs) com.google.android.gms.internal.gj
   // $FF: synthetic method
   static class_374 method_2816(class_425 var0) {
      return var0.field_1356;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.fs) java.lang.String
   // $FF: synthetic method
   static String method_2817(class_425 var0) {
      return var0.field_1355;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.gu) void
   public void method_2818(class_371 var1) {
      class_335.method_2304("setAdWebView must be called on the main thread.");
      this.field_1354 = var1;
   }

   // $FF: renamed from: cR () java.util.concurrent.Future
   public Future<fu> method_2819() {
      return this.field_1356;
   }

   // $FF: renamed from: cS () void
   public void method_2820() {
      class_335.method_2304("destroyAdWebView must be called on the main thread.");
      if(this.field_1354 != null) {
         this.field_1354.destroy();
         this.field_1354 = null;
      }

   }
}
