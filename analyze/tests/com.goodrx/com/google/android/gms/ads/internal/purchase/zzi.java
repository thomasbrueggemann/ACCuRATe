package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzi {
   public String zzaq(String var1) {
      if(var1 == null) {
         return null;
      } else {
         try {
            new JSONObject;
            String var4 = JSONObjectInstrumentation.init(var1).getString("developerPayload");
            return var4;
         } catch (JSONException var5) {
            zzin.zzaK("Fail to parse purchase data");
            return null;
         }
      }
   }

   public int zzd(Intent var1) {
      if(var1 == null) {
         return 5;
      } else {
         Object var2 = var1.getExtras().get("RESPONSE_CODE");
         if(var2 == null) {
            zzin.zzaK("Intent with no response code, assuming OK (known issue)");
            return 0;
         } else if(var2 instanceof Integer) {
            return ((Integer)var2).intValue();
         } else if(var2 instanceof Long) {
            return (int)((Long)var2).longValue();
         } else {
            zzin.zzaK("Unexpected type for intent response code. " + var2.getClass().getName());
            return 5;
         }
      }
   }

   public int zzd(Bundle var1) {
      Object var2 = var1.get("RESPONSE_CODE");
      if(var2 == null) {
         zzin.zzaK("Bundle with null response code, assuming OK (known issue)");
         return 0;
      } else if(var2 instanceof Integer) {
         return ((Integer)var2).intValue();
      } else if(var2 instanceof Long) {
         return (int)((Long)var2).longValue();
      } else {
         zzin.zzaK("Unexpected type for intent response code. " + var2.getClass().getName());
         return 5;
      }
   }

   public String zze(Intent var1) {
      return var1 == null?null:var1.getStringExtra("INAPP_PURCHASE_DATA");
   }

   public String zzf(Intent var1) {
      return var1 == null?null:var1.getStringExtra("INAPP_DATA_SIGNATURE");
   }
}
