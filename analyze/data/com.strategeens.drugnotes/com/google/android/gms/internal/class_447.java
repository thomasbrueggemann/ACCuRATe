package com.google.android.gms.internal;

import com.google.android.gms.internal.class_451;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cq
@ey
public final class class_447 {
   // $FF: renamed from: qn java.lang.String
   public final String field_1493;
   // $FF: renamed from: qo java.lang.String
   public final String field_1494;
   // $FF: renamed from: qp java.util.List
   public final List<String> field_1495;
   // $FF: renamed from: qq java.lang.String
   public final String field_1496;
   // $FF: renamed from: qr java.lang.String
   public final String field_1497;
   // $FF: renamed from: qs java.util.List
   public final List<String> field_1498;
   // $FF: renamed from: qt java.lang.String
   public final String field_1499;

   public class_447(JSONObject var1) throws JSONException {
      this.field_1494 = var1.getString("id");
      JSONArray var2 = var1.getJSONArray("adapters");
      ArrayList var3 = new ArrayList(var2.length());

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         var3.add(var2.getString(var4));
      }

      this.field_1495 = Collections.unmodifiableList(var3);
      this.field_1496 = var1.optString("allocation_id", (String)null);
      this.field_1498 = class_451.method_2917(var1, "imp_urls");
      JSONObject var5 = var1.optJSONObject("ad");
      String var6;
      if(var5 != null) {
         var6 = var5.toString();
      } else {
         var6 = null;
      }

      this.field_1493 = var6;
      JSONObject var7 = var1.optJSONObject("data");
      String var8;
      if(var7 != null) {
         var8 = var7.toString();
      } else {
         var8 = null;
      }

      this.field_1499 = var8;
      String var9 = null;
      if(var7 != null) {
         var9 = var7.optString("class_name");
      }

      this.field_1497 = var9;
   }
}
