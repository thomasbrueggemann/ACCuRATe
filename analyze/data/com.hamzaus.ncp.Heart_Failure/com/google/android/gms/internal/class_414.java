package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.class_370;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.cz
public final class class_414 {
   // $FF: renamed from: a (android.os.Bundle) int
   public static int method_2530(Bundle var0) {
      Object var1 = var0.get("RESPONSE_CODE");
      if(var1 == null) {
         class_370.method_2358("Bundle with null response code, assuming OK (known issue)");
         return 0;
      } else if(var1 instanceof Integer) {
         return ((Integer)var1).intValue();
      } else if(var1 instanceof Long) {
         return (int)((Long)var1).longValue();
      } else {
         class_370.method_2358("Unexpected type for intent response code. " + var1.getClass().getName());
         return 5;
      }
   }

   // $FF: renamed from: c (android.content.Intent) int
   public static int method_2531(Intent var0) {
      Object var1 = var0.getExtras().get("RESPONSE_CODE");
      if(var1 == null) {
         class_370.method_2358("Intent with no response code, assuming OK (known issue)");
         return 0;
      } else if(var1 instanceof Integer) {
         return ((Integer)var1).intValue();
      } else if(var1 instanceof Long) {
         return (int)((Long)var1).longValue();
      } else {
         class_370.method_2358("Unexpected type for intent response code. " + var1.getClass().getName());
         return 5;
      }
   }

   // $FF: renamed from: d (android.content.Intent) java.lang.String
   public static String method_2532(Intent var0) {
      return var0 == null?null:var0.getStringExtra("INAPP_PURCHASE_DATA");
   }

   // $FF: renamed from: e (android.content.Intent) java.lang.String
   public static String method_2533(Intent var0) {
      return var0 == null?null:var0.getStringExtra("INAPP_DATA_SIGNATURE");
   }

   // $FF: renamed from: p (java.lang.String) java.lang.String
   public static String method_2534(String var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            String var2 = (new JSONObject(var0)).getString("developerPayload");
            return var2;
         } catch (JSONException var3) {
            class_370.method_2358("Fail to parse purchase data");
            return null;
         }
      }
   }

   // $FF: renamed from: q (java.lang.String) java.lang.String
   public static String method_2535(String var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            String var2 = (new JSONObject(var0)).getString("purchaseToken");
            return var2;
         } catch (JSONException var3) {
            class_370.method_2358("Fail to parse purchase data");
            return null;
         }
      }
   }
}
