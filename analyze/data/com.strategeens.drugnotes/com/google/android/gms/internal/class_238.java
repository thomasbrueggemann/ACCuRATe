package com.google.android.gms.internal;

import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ey;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.bv
@ey
public class class_238 {
   // $FF: renamed from: pM com.google.android.gms.internal.u
   private class_548 field_449;
   // $FF: renamed from: pN com.google.android.gms.internal.ah
   private class_0 field_450;
   // $FF: renamed from: pO org.json.JSONObject
   private JSONObject field_451;

   public class_238(class_548 var1, class_0 var2, JSONObject var3) {
      this.field_449 = var1;
      this.field_450 = var2;
      this.field_451 = var3;
   }

   // $FF: renamed from: aw () void
   public void method_1606() {
      this.field_449.method_19();
   }

   // $FF: renamed from: b (java.lang.String, int) void
   public void method_1607(String var1, int var2) {
      try {
         JSONObject var3 = new JSONObject();
         var3.put("asset", var2);
         var3.put("template", var1);
         JSONObject var7 = new JSONObject();
         var7.put("ad", this.field_451);
         var7.put("click", var3);
         this.field_450.method_3("google.afma.nativeAds.handleClick", var7);
      } catch (JSONException var8) {
         class_368.method_2508("Unable to create click JSON.", var8);
      }
   }

   public interface class_1220 {
      // $FF: renamed from: a (com.google.android.gms.internal.bv) void
      void method_1005(class_238 var1);
   }
}
