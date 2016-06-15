package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.class_549;
import com.google.android.gms.internal.class_557;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.ey;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.aj
@ey
public class class_230 implements class_0 {
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_404;

   public class_230(Context var1, class_369 var2) {
      this.field_404 = class_371.method_2515(var1, new class_237(), false, false, (class_557)null, var2);
   }

   private void runOnUiThread(Runnable var1) {
      if(class_367.method_2500()) {
         var1.run();
      } else {
         class_367.field_1120.post(var1);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ah$a) void
   public void method_0(final class_0.class_1544 var1) {
      this.field_404.method_2531().method_2448(new class_356.class_1535() {
         // $FF: renamed from: a (com.google.android.gms.internal.gu) void
         public void method_729(class_371 var1x) {
            var1.method_734();
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.ds, com.google.android.gms.internal.cb, com.google.android.gms.internal.dv, boolean, com.google.android.gms.internal.ce) void
   public void method_1(class_67 var1, class_49 var2, class_45 var3, class_50 var4, boolean var5, class_47 var6) {
      this.field_404.method_2531().method_2450(var1, var2, var3, var4, var5, var6, new class_549(false));
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.cd) void
   public void method_2(String var1, class_46 var2) {
      this.field_404.method_2531().method_2451(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
   public void method_3(final String var1, final JSONObject var2) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            class_230.this.field_404.method_2524(var1, var2);
         }
      });
   }

   public void destroy() {
      this.field_404.destroy();
   }

   // $FF: renamed from: f (java.lang.String) void
   public void method_4(final String var1) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            class_230.this.field_404.loadUrl(var1);
         }
      });
   }

   // $FF: renamed from: g (java.lang.String) void
   public void method_5(String var1) {
      this.field_404.method_2531().method_2451(var1, (class_46)null);
   }

   public void pause() {
      class_375.method_2560(this.field_404);
   }

   public void resume() {
      class_375.method_2565(this.field_404);
   }
}
