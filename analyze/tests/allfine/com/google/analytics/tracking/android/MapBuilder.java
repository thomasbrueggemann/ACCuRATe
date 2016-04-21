package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage;
import com.google.analytics.tracking.android.Log;
import com.google.analytics.tracking.android.Utils;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    private Map<String, String> map = new HashMap();

    static String booleanToString(Boolean var0) {
        return var0 == null?null:(var0.booleanValue()?"1":"0");
    }

    public static MapBuilder createAppView() {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_APP_VIEW);
        MapBuilder var0 = new MapBuilder();
        var0.set("&t", "appview");
        return var0;
    }

    public static MapBuilder createEvent(String var0, String var1, String var2, Long var3) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
        MapBuilder var4 = new MapBuilder();
        var4.set("&t", "event");
        var4.set("&ec", var0);
        var4.set("&ea", var1);
        var4.set("&el", var2);
        String var9;
        if(var3 == null) {
            var9 = null;
        } else {
            var9 = Long.toString(var3.longValue());
        }

        var4.set("&ev", var9);
        return var4;
    }

    public static MapBuilder createException(String var0, Boolean var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
        MapBuilder var2 = new MapBuilder();
        var2.set("&t", "exception");
        var2.set("&exd", var0);
        var2.set("&exf", booleanToString(var1));
        return var2;
    }

    public static MapBuilder createItem(String var0, String var1, String var2, String var3, Double var4, Long var5, String var6) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
        MapBuilder var7 = new MapBuilder();
        var7.set("&t", "item");
        var7.set("&ti", var0);
        var7.set("&ic", var2);
        var7.set("&in", var1);
        var7.set("&iv", var3);
        String var13;
        if(var4 == null) {
            var13 = null;
        } else {
            var13 = Double.toString(var4.doubleValue());
        }

        var7.set("&ip", var13);
        String var15 = null;
        if(var5 != null) {
            var15 = Long.toString(var5.longValue());
        }

        var7.set("&iq", var15);
        var7.set("&cu", var6);
        return var7;
    }

    public static MapBuilder createSocial(String var0, String var1, String var2) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
        MapBuilder var3 = new MapBuilder();
        var3.set("&t", "social");
        var3.set("&sn", var0);
        var3.set("&sa", var1);
        var3.set("&st", var2);
        return var3;
    }

    public static MapBuilder createTiming(String var0, Long var1, String var2, String var3) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
        MapBuilder var4 = new MapBuilder();
        var4.set("&t", "timing");
        var4.set("&utc", var0);
        String var7 = null;
        if(var1 != null) {
            var7 = Long.toString(var1.longValue());
        }

        var4.set("&utt", var7);
        var4.set("&utv", var2);
        var4.set("&utl", var3);
        return var4;
    }

    public static MapBuilder createTransaction(String var0, String var1, Double var2, Double var3, Double var4, String var5) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
        MapBuilder var6 = new MapBuilder();
        var6.set("&t", "transaction");
        var6.set("&ti", var0);
        var6.set("&ta", var1);
        String var10;
        if(var2 == null) {
            var10 = null;
        } else {
            var10 = Double.toString(var2.doubleValue());
        }

        var6.set("&tr", var10);
        String var12;
        if(var3 == null) {
            var12 = null;
        } else {
            var12 = Double.toString(var3.doubleValue());
        }

        var6.set("&tt", var12);
        String var14 = null;
        if(var4 != null) {
            var14 = Double.toString(var4.doubleValue());
        }

        var6.set("&ts", var14);
        var6.set("&cu", var5);
        return var6;
    }

    public Map<String, String> build() {
        return new HashMap(this.map);
    }

    public String get(String var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_GET);
        return (String)this.map.get(var1);
    }

    public MapBuilder set(String var1, String var2) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET);
        if(var1 != null) {
            this.map.put(var1, var2);
            return this;
        } else {
            Log.method_2107(" MapBuilder.set() called with a null paramName.");
            return this;
        }
    }

    public MapBuilder setAll(Map<String, String> var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_ALL);
        if(var1 == null) {
            return this;
        } else {
            this.map.putAll(new HashMap(var1));
            return this;
        }
    }

    public MapBuilder setCampaignParamsFromUrl(String var1) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        String var2 = Utils.filterCampaign(var1);
        if(TextUtils.isEmpty(var2)) {
            return this;
        } else {
            Map var3 = Utils.parseURLParameters(var2);
            this.set("&cc", (String)var3.get("utm_content"));
            this.set("&cm", (String)var3.get("utm_medium"));
            this.set("&cn", (String)var3.get("utm_campaign"));
            this.set("&cs", (String)var3.get("utm_source"));
            this.set("&ck", (String)var3.get("utm_term"));
            this.set("&ci", (String)var3.get("utm_id"));
            this.set("&gclid", (String)var3.get("gclid"));
            this.set("&dclid", (String)var3.get("dclid"));
            this.set("&gmob_t", (String)var3.get("gmob_t"));
            return this;
        }
    }
}
