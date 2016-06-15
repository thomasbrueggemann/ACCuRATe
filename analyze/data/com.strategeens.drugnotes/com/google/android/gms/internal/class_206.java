package com.google.android.gms.internal;

import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.ey;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ad
@ey
public final class class_206 {
   // $FF: renamed from: mD java.lang.String
   private final String field_332;
   // $FF: renamed from: mE org.json.JSONObject
   private final JSONObject field_333;
   // $FF: renamed from: mF java.lang.String
   private final String field_334;
   // $FF: renamed from: mG java.lang.String
   private final String field_335;

   public class_206(String var1, class_369 var2, String var3, JSONObject var4) {
      this.field_335 = var2.field_1121;
      this.field_333 = var4;
      this.field_334 = var1;
      this.field_332 = var3;
   }

   // $FF: renamed from: aE () java.lang.String
   public String method_1487() {
      return this.field_332;
   }

   // $FF: renamed from: aF () java.lang.String
   public String method_1488() {
      return this.field_335;
   }

   // $FF: renamed from: aG () org.json.JSONObject
   public JSONObject method_1489() {
      return this.field_333;
   }

   // $FF: renamed from: aH () java.lang.String
   public String method_1490() {
      return this.field_334;
   }
}
