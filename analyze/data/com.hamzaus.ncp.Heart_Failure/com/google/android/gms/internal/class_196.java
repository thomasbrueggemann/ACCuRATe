package com.google.android.gms.internal;

import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.class_194;
import com.google.android.gms.internal.class_201;
import com.google.android.gms.internal.class_370;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.bn
public final class class_196 {
   // $FF: renamed from: np java.util.List
   public final List<bm> field_618;
   // $FF: renamed from: nq long
   public final long field_619;
   // $FF: renamed from: nr java.util.List
   public final List<String> field_620;
   // $FF: renamed from: ns java.util.List
   public final List<String> field_621;
   // $FF: renamed from: nt java.util.List
   public final List<String> field_622;
   // $FF: renamed from: nu java.lang.String
   public final String field_623;
   // $FF: renamed from: nv long
   public final long field_624;
   // $FF: renamed from: nw int
   public int field_625;
   // $FF: renamed from: nx int
   public int field_626;

   public class_196(String var1) throws JSONException {
      JSONObject var2 = new JSONObject(var1);
      if(class_370.method_2362(2)) {
         class_370.method_2357("Mediation Response JSON: " + var2.toString(2));
      }

      JSONArray var3 = var2.getJSONArray("ad_networks");
      ArrayList var4 = new ArrayList(var3.length());
      int var5 = -1;

      for(int var6 = 0; var6 < var3.length(); ++var6) {
         class_201 var7 = new class_201(var3.getJSONObject(var6));
         var4.add(var7);
         if(var5 < 0 && this.method_1313(var7)) {
            var5 = var6;
         }
      }

      this.field_625 = var5;
      this.field_626 = var3.length();
      this.field_618 = Collections.unmodifiableList(var4);
      this.field_623 = var2.getString("qdata");
      JSONObject var9 = var2.optJSONObject("settings");
      if(var9 != null) {
         this.field_619 = var9.optLong("ad_network_timeout_millis", -1L);
         this.field_620 = class_194.method_1308(var9, "click_urls");
         this.field_621 = class_194.method_1308(var9, "imp_urls");
         this.field_622 = class_194.method_1308(var9, "nofill_urls");
         long var10 = var9.optLong("refresh", -1L);
         long var12;
         if(var10 > 0L) {
            var12 = var10 * 1000L;
         } else {
            var12 = -1L;
         }

         this.field_624 = var12;
      } else {
         this.field_619 = -1L;
         this.field_620 = null;
         this.field_621 = null;
         this.field_622 = null;
         this.field_624 = -1L;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bm) boolean
   private boolean method_1313(class_201 var1) {
      Iterator var2 = var1.field_648.iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!((String)var2.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));

      return true;
   }
}
