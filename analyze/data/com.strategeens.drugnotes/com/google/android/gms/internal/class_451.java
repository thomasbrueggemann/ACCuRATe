package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_366;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cw
@ey
public final class class_451 {
   // $FF: renamed from: a (org.json.JSONObject, java.lang.String) java.util.List
   public static List<String> method_2917(JSONObject var0, String var1) throws JSONException {
      JSONArray var2 = var0.optJSONArray(var1);
      if(var2 == null) {
         return null;
      } else {
         ArrayList var3 = new ArrayList(var2.length());

         for(int var4 = 0; var4 < var2.length(); ++var4) {
            var3.add(var2.getString(var4));
         }

         return Collections.unmodifiableList(var3);
      }
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, com.google.android.gms.internal.fy, java.lang.String, boolean, java.util.List) void
   public static void method_2918(Context var0, String var1, fy var2, String var3, boolean var4, List<String> var5) {
      String var6;
      if(var4) {
         var6 = "1";
      } else {
         var6 = "0";
      }

      String var8;
      for(Iterator var7 = var5.iterator(); var7.hasNext(); (new class_366(var0, var1, var8)).start()) {
         var8 = ((String)var7.next()).replaceAll("@gw_adlocid@", var3).replaceAll("@gw_adnetrefresh@", var6).replaceAll("@gw_qdata@", var2.field_1402.field_1492).replaceAll("@gw_sdkver@", var1).replaceAll("@gw_sessid@", class_381.field_1166).replaceAll("@gw_seqnum@", var2.field_1395);
         if(var2.field_1387 != null) {
            var8 = var8.replaceAll("@gw_adnetid@", var2.field_1387.field_1494).replaceAll("@gw_allocid@", var2.field_1387.field_1496);
         }
      }

   }
}
