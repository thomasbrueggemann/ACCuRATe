package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.SharedPreferencesUtil;
import java.util.HashMap;
import java.util.Map;

class InstallReferrerUtil {
    static final String INTENT_EXTRA_REFERRER = "referrer";
    static final String PREF_KEY_REFERRER = "referrer";
    static final String PREF_NAME_CLICK_REFERRERS = "gtm_click_referrers";
    static final String PREF_NAME_INSTALL_REFERRER = "gtm_install_referrer";
    @VisibleForTesting
    static Map<String, String> clickReferrers = new HashMap();
    private static String installReferrer;

    static void addClickReferrer(Context var0, String var1) {
        String var2 = extractComponent(var1, "conv");
        if(var2 != null && var2.length() > 0) {
            clickReferrers.put(var2, var1);
            SharedPreferencesUtil.saveAsync(var0, "gtm_click_referrers", var2, var1);
        }

    }

    static void cacheInstallReferrer(String param0) {
        // $FF: Couldn't be decompiled
    }

    static String extractComponent(String var0, String var1) {
        return var1 == null?(var0.length() > 0?var0:null):Uri.parse("http://hostname/?" + var0).getQueryParameter(var1);
    }

    static String getClickReferrer(Context var0, String var1, String var2) {
        String var3 = (String)clickReferrers.get(var1);
        if(var3 == null) {
            SharedPreferences var4 = var0.getSharedPreferences("gtm_click_referrers", 0);
            if(var4 != null) {
                var3 = var4.getString(var1, "");
            } else {
                var3 = "";
            }

            clickReferrers.put(var1, var3);
        }

        return extractComponent(var3, var2);
    }

    static String getInstallReferrer(Context param0, String param1) {
        // $FF: Couldn't be decompiled
    }

    static void saveInstallReferrer(Context var0, String var1) {
        SharedPreferencesUtil.saveAsync(var0, "gtm_install_referrer", "referrer", var1);
        addClickReferrer(var0, var1);
    }
}
