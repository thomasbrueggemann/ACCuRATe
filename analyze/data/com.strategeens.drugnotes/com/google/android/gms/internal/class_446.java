package com.google.android.gms.internal;

import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_451;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cr
@ey
public final class class_446 {
   // $FF: renamed from: qA long
   public final long field_1484;
   // $FF: renamed from: qB int
   public int field_1485;
   // $FF: renamed from: qC int
   public int field_1486;
   // $FF: renamed from: qu java.util.List
   public final List<cq> field_1487;
   // $FF: renamed from: qv long
   public final long field_1488;
   // $FF: renamed from: qw java.util.List
   public final List<String> field_1489;
   // $FF: renamed from: qx java.util.List
   public final List<String> field_1490;
   // $FF: renamed from: qy java.util.List
   public final List<String> field_1491;
   // $FF: renamed from: qz java.lang.String
   public final String field_1492;

   public class_446(String var1) throws JSONException {
      JSONObject var2 = new JSONObject(var1);
      if(class_368.method_2511(2)) {
         class_368.method_2505("Mediation Response JSON: " + var2.toString(2));
      }

      JSONArray var3 = var2.getJSONArray("ad_networks");
      ArrayList var4 = new ArrayList(var3.length());
      int var5 = -1;

      for(int var6 = 0; var6 < var3.length(); ++var6) {
         class_447 var7 = new class_447(var3.getJSONObject(var6));
         var4.add(var7);
         if(var5 < 0 && this.method_2896(var7)) {
            var5 = var6;
         }
      }

      this.field_1485 = var5;
      this.field_1486 = var3.length();
      this.field_1487 = Collections.unmodifiableList(var4);
      this.field_1492 = var2.getString("qdata");
      JSONObject var9 = var2.optJSONObject("settings");
      if(var9 != null) {
         this.field_1488 = var9.optLong("ad_network_timeout_millis", -1L);
         this.field_1489 = class_451.method_2917(var9, "click_urls");
         this.field_1490 = class_451.method_2917(var9, "imp_urls");
         this.field_1491 = class_451.method_2917(var9, "nofill_urls");
         long var10 = var9.optLong("refresh", -1L);
         long var12;
         if(var10 > 0L) {
            var12 = var10 * 1000L;
         } else {
            var12 = -1L;
         }

         this.field_1484 = var12;
      } else {
         this.field_1488 = -1L;
         this.field_1489 = null;
         this.field_1490 = null;
         this.field_1491 = null;
         this.field_1484 = -1L;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cq) boolean
   private boolean method_2896(class_447 var1) {
      Iterator var2 = var1.field_1495.iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!((String)var2.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));

      return true;
   }
}
