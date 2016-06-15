package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.v
@ey
public class class_549 {
   // $FF: renamed from: mk com.google.android.gms.internal.v$a
   private class_549.class_1475 field_2531;
   // $FF: renamed from: ml boolean
   private boolean field_2532;
   // $FF: renamed from: mm boolean
   private boolean field_2533;

   public class_549() {
      Bundle var1 = class_381.method_2605();
      boolean var2 = false;
      if(var1 != null) {
         boolean var3 = var1.getBoolean("gads:block_autoclicks", false);
         var2 = false;
         if(var3) {
            var2 = true;
         }
      }

      this.field_2533 = var2;
   }

   public class_549(boolean var1) {
      this.field_2533 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.v$a) void
   public void method_3335(class_549.class_1475 var1) {
      this.field_2531 = var1;
   }

   // $FF: renamed from: av () void
   public void method_3336() {
      this.field_2532 = true;
   }

   // $FF: renamed from: az () boolean
   public boolean method_3337() {
      return !this.field_2533 || this.field_2532;
   }

   // $FF: renamed from: d (java.lang.String) void
   public void method_3338(String var1) {
      class_368.method_2502("Action was blocked because no click was detected.");
      if(this.field_2531 != null) {
         this.field_2531.method_444(var1);
      }

   }

   public interface class_1475 {
      // $FF: renamed from: e (java.lang.String) void
      void method_444(String var1);
   }

   @ey
   public static class class_1476 implements class_549.class_1475 {
      // $FF: renamed from: mn com.google.android.gms.internal.fy$a
      private final class_432.class_1521 field_2920;
      // $FF: renamed from: mo com.google.android.gms.internal.gu
      private final class_371 field_2921;

      public class_1476(class_432.class_1521 var1, class_371 var2) {
         this.field_2920 = var1;
         this.field_2921 = var2;
      }

      // $FF: renamed from: e (java.lang.String) void
      public void method_444(String var1) {
         class_368.method_2502("An auto-clicking creative is blocked");
         Builder var2 = new Builder();
         var2.scheme("https");
         var2.path("//pagead2.googlesyndication.com/pagead/gen_204");
         var2.appendQueryParameter("id", "gmob-apps-blocked-navigation");
         if(!TextUtils.isEmpty(var1)) {
            var2.appendQueryParameter("navigationURL", var1);
         }

         if(this.field_2920 != null && this.field_2920.field_4105 != null && !TextUtils.isEmpty(this.field_2920.field_4105.field_1452)) {
            var2.appendQueryParameter("debugDialog", this.field_2920.field_4105.field_1452);
         }

         class_375.method_2569(this.field_2921.getContext(), this.field_2921.method_2534().field_1121, var2.toString());
      }
   }
}
