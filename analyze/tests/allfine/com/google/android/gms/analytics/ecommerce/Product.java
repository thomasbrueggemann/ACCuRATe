package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.class_928;
import com.google.android.gms.common.internal.class_1090;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    // $FF: renamed from: BK java.util.Map
    Map<String, String> field_5364 = new HashMap();

    // $FF: renamed from: aq (java.lang.String) java.util.Map
    public Map<String, String> method_6015(String var1) {
        HashMap var2 = new HashMap();
        Iterator var3 = this.field_5364.entrySet().iterator();

        while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var2.put(var1 + (String)var4.getKey(), var4.getValue());
        }

        return var2;
    }

    void put(String var1, String var2) {
        class_1090.method_5681(var1, "Name should be non-null");
        this.field_5364.put(var1, var2);
    }

    public Product setBrand(String var1) {
        this.put("br", var1);
        return this;
    }

    public Product setCategory(String var1) {
        this.put("ca", var1);
        return this;
    }

    public Product setCouponCode(String var1) {
        this.put("cc", var1);
        return this;
    }

    public Product setCustomDimension(int var1, String var2) {
        this.put(class_928.method_4794(var1), var2);
        return this;
    }

    public Product setCustomMetric(int var1, int var2) {
        this.put(class_928.method_4795(var1), Integer.toString(var2));
        return this;
    }

    public Product setId(String var1) {
        this.put("id", var1);
        return this;
    }

    public Product setName(String var1) {
        this.put("nm", var1);
        return this;
    }

    public Product setPosition(int var1) {
        this.put("ps", Integer.toString(var1));
        return this;
    }

    public Product setPrice(double var1) {
        this.put("pr", Double.toString(var1));
        return this;
    }

    public Product setQuantity(int var1) {
        this.put("qt", Integer.toString(var1));
        return this;
    }

    public Product setVariant(String var1) {
        this.put("va", var1);
        return this;
    }
}
