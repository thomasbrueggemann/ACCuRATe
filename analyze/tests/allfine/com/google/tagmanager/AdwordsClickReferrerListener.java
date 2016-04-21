package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.InstallReferrerUtil;
import java.util.Map;

class AdwordsClickReferrerListener implements DataLayer.Listener {
    private final Context context;

    public AdwordsClickReferrerListener(Context var1) {
        this.context = var1;
    }

    public void changed(Map<Object, Object> var1) {
        Object var2 = var1.get("gtm.url");
        if(var2 == null) {
            Object var4 = var1.get("gtm");
            if(var4 != null && var4 instanceof Map) {
                var2 = ((Map)var4).get("url");
            }
        }

        if(var2 != null && var2 instanceof String) {
            String var3 = Uri.parse((String)var2).getQueryParameter("referrer");
            if(var3 != null) {
                InstallReferrerUtil.addClickReferrer(this.context, var3);
                return;
            }
        }

    }
}
