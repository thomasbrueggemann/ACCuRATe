package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_457;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ag
public class class_159 implements class_0 {
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   private final class_369 field_35;

   public class_159(Context var1, class_373 var2) {
      this.field_35 = class_369.method_2333(var1, new class_172(), false, false, (class_457)null, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.af$a) void
   public void method_0(final class_0.class_1182 var1) {
      this.field_35.method_2349().method_2322(new class_367.class_1262() {
         // $FF: renamed from: a (com.google.android.gms.internal.ey) void
         public void method_756(class_369 var1x) {
            var1.method_757();
         }
      });
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.bd) void
   public void method_1(String var1, class_10 var2) {
      this.field_35.method_2349().method_2325(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
   public void method_2(String var1, JSONObject var2) {
      this.field_35.method_2343(var1, var2);
   }

   // $FF: renamed from: d (java.lang.String) void
   public void method_3(String var1) {
      this.field_35.loadUrl(var1);
   }

   // $FF: renamed from: e (java.lang.String) void
   public void method_4(String var1) {
      this.field_35.method_2349().method_2325(var1, (class_10)null);
   }

   public void pause() {
      class_365.method_2295(this.field_35);
   }

   public void resume() {
      class_365.method_2302(this.field_35);
   }
}
