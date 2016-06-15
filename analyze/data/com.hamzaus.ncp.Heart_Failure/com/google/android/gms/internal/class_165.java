package com.google.android.gms.internal;

import com.google.android.gms.internal.class_373;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ab
public final class class_165 {
   // $FF: renamed from: lm java.lang.String
   private final String field_517;
   // $FF: renamed from: ln org.json.JSONObject
   private final JSONObject field_518;
   // $FF: renamed from: lo java.lang.String
   private final String field_519;
   // $FF: renamed from: lp java.lang.String
   private final String field_520;

   public class_165(String var1, class_373 var2, String var3, JSONObject var4) {
      this.field_520 = var2.field_1607;
      this.field_518 = var4;
      this.field_519 = var1;
      this.field_517 = var3;
   }

   // $FF: renamed from: am () java.lang.String
   public String method_1246() {
      return this.field_517;
   }

   // $FF: renamed from: an () java.lang.String
   public String method_1247() {
      return this.field_520;
   }

   // $FF: renamed from: ao () org.json.JSONObject
   public JSONObject method_1248() {
      return this.field_518;
   }

   // $FF: renamed from: ap () java.lang.String
   public String method_1249() {
      return this.field_519;
   }
}
