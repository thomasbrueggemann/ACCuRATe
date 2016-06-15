package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.fu
@ey
class class_423 {
   // $FF: renamed from: tq int
   private int field_1326;
   // $FF: renamed from: uX java.util.List
   private final List<String> field_1327;
   // $FF: renamed from: uY java.util.List
   private final List<String> field_1328;
   // $FF: renamed from: uZ java.lang.String
   private final String field_1329;
   // $FF: renamed from: va java.lang.String
   private final String field_1330;
   // $FF: renamed from: vb java.lang.String
   private final String field_1331;
   // $FF: renamed from: vc java.lang.String
   private final String field_1332;
   // $FF: renamed from: vd boolean
   private final boolean field_1333;
   // $FF: renamed from: ve int
   private final int field_1334;
   // $FF: renamed from: vf java.lang.String
   private String field_1335;

   public class_423(int var1, Map<String, String> var2) {
      this.field_1335 = (String)var2.get("url");
      this.field_1330 = (String)var2.get("base_uri");
      this.field_1331 = (String)var2.get("post_parameters");
      this.field_1333 = parseBoolean((String)var2.get("drt_include"));
      this.field_1329 = (String)var2.get("activation_overlay_url");
      this.field_1328 = this.method_2790((String)var2.get("check_packages"));
      this.field_1334 = this.parseInt((String)var2.get("request_id"));
      this.field_1332 = (String)var2.get("type");
      this.field_1327 = this.method_2790((String)var2.get("errors"));
      this.field_1326 = var1;
   }

   // $FF: renamed from: J (java.lang.String) java.util.List
   private List<String> method_2790(String var1) {
      return var1 == null?null:Arrays.asList(var1.split(","));
   }

   private static boolean parseBoolean(String var0) {
      return var0 != null && (var0.equals("1") || var0.equals("true"));
   }

   private int parseInt(String var1) {
      return var1 == null?0:Integer.parseInt(var1);
   }

   // $FF: renamed from: cT () java.util.List
   public List<String> method_2791() {
      return this.field_1327;
   }

   // $FF: renamed from: cU () java.lang.String
   public String method_2792() {
      return this.field_1331;
   }

   // $FF: renamed from: cV () boolean
   public boolean method_2793() {
      return this.field_1333;
   }

   public int getErrorCode() {
      return this.field_1326;
   }

   public String getType() {
      return this.field_1332;
   }

   public String getUrl() {
      return this.field_1335;
   }

   public void setUrl(String var1) {
      this.field_1335 = var1;
   }
}
