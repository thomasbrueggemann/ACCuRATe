package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.ez;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ed
@ez
public final class class_427 {
    // $FF: renamed from: D (java.lang.String) java.lang.String
    public static String method_2691(String var0) {
        if(var0 == null) {
            return null;
        } else {
            try {
                String var2 = (new JSONObject(var0)).getString("developerPayload");
                return var2;
            } catch (JSONException var3) {
                class_378.method_2461("Fail to parse purchase data");
                return null;
            }
        }
    }

    // $FF: renamed from: E (java.lang.String) java.lang.String
    public static String method_2692(String var0) {
        if(var0 == null) {
            return null;
        } else {
            try {
                String var2 = (new JSONObject(var0)).getString("purchaseToken");
                return var2;
            } catch (JSONException var3) {
                class_378.method_2461("Fail to parse purchase data");
                return null;
            }
        }
    }

    // $FF: renamed from: b (android.os.Bundle) int
    public static int method_2693(Bundle var0) {
        Object var1 = var0.get("RESPONSE_CODE");
        if(var1 == null) {
            class_378.method_2461("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if(var1 instanceof Integer) {
            return ((Integer)var1).intValue();
        } else if(var1 instanceof Long) {
            return (int)((Long)var1).longValue();
        } else {
            class_378.method_2461("Unexpected type for intent response code. " + var1.getClass().getName());
            return 5;
        }
    }

    // $FF: renamed from: d (android.content.Intent) int
    public static int method_2694(Intent var0) {
        Object var1 = var0.getExtras().get("RESPONSE_CODE");
        if(var1 == null) {
            class_378.method_2461("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if(var1 instanceof Integer) {
            return ((Integer)var1).intValue();
        } else if(var1 instanceof Long) {
            return (int)((Long)var1).longValue();
        } else {
            class_378.method_2461("Unexpected type for intent response code. " + var1.getClass().getName());
            return 5;
        }
    }

    // $FF: renamed from: e (android.content.Intent) java.lang.String
    public static String method_2695(Intent var0) {
        return var0 == null?null:var0.getStringExtra("INAPP_PURCHASE_DATA");
    }

    // $FF: renamed from: f (android.content.Intent) java.lang.String
    public static String method_2696(Intent var0) {
        return var0 == null?null:var0.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
