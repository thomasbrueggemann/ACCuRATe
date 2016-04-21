package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.class_1090;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    // $FF: renamed from: BK java.util.Map
    Map<String, String> field_3336 = new HashMap();

    // $FF: renamed from: aq (java.lang.String) java.util.Map
    public Map<String, String> method_3787(String var1) {
        HashMap var2 = new HashMap();
        Iterator var3 = this.field_3336.entrySet().iterator();

        while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var2.put(var1 + (String)var4.getKey(), var4.getValue());
        }

        return var2;
    }

    void put(String var1, String var2) {
        class_1090.method_5681(var1, "Name should be non-null");
        this.field_3336.put(var1, var2);
    }

    public Promotion setCreative(String var1) {
        this.put("cr", var1);
        return this;
    }

    public Promotion setId(String var1) {
        this.put("id", var1);
        return this;
    }

    public Promotion setName(String var1) {
        this.put("nm", var1);
        return this;
    }

    public Promotion setPosition(String var1) {
        this.put("ps", var1);
        return this;
    }
}
