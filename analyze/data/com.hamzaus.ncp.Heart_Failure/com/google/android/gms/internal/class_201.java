package com.google.android.gms.internal;

import com.google.android.gms.internal.class_194;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.bm
public final class class_201 {
   // $FF: renamed from: ni java.lang.String
   public final String field_646;
   // $FF: renamed from: nj java.lang.String
   public final String field_647;
   // $FF: renamed from: nk java.util.List
   public final List<String> field_648;
   // $FF: renamed from: nl java.lang.String
   public final String field_649;
   // $FF: renamed from: nm java.lang.String
   public final String field_650;
   // $FF: renamed from: nn java.util.List
   public final List<String> field_651;
   // $FF: renamed from: no java.lang.String
   public final String field_652;

   public class_201(JSONObject var1) throws JSONException {
      this.field_647 = var1.getString("id");
      JSONArray var2 = var1.getJSONArray("adapters");
      ArrayList var3 = new ArrayList(var2.length());

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         var3.add(var2.getString(var4));
      }

      this.field_648 = Collections.unmodifiableList(var3);
      this.field_649 = var1.optString("allocation_id", (String)null);
      this.field_651 = class_194.method_1308(var1, "imp_urls");
      JSONObject var5 = var1.optJSONObject("ad");
      String var6;
      if(var5 != null) {
         var6 = var5.toString();
      } else {
         var6 = null;
      }

      this.field_646 = var6;
      JSONObject var7 = var1.optJSONObject("data");
      String var8;
      if(var7 != null) {
         var8 = var7.toString();
      } else {
         var8 = null;
      }

      this.field_652 = var8;
      String var9 = null;
      if(var7 != null) {
         var9 = var7.optString("class_name");
      }

      this.field_650 = var9;
   }
}
