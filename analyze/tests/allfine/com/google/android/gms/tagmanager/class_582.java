package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_579;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_633;
import com.google.android.gms.tagmanager.class_634;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.dj
class class_582 extends class_579 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3094;
    private static final String asd;
    private static final String ase;
    private static final String asf;
    private static final String asg;
    private static final String ash;
    private static final String asi;
    private static final String asj;
    private static final String ask;
    private static final String asl;
    private static final List<String> asm;
    private static Map<String, String> asn;
    private static Map<String, String> aso;
    private final DataLayer aod;
    private final Set<String> asp;
    private final class_633 asq;

    static {
        field_3094 = class_530.field_2521.toString();
        asd = class_529.field_2295.toString();
        ase = class_529.field_2304.toString();
        asf = class_529.field_2316.toString();
        asg = class_529.field_2363.toString();
        ash = class_529.field_2362.toString();
        asi = class_529.field_2303.toString();
        asj = class_529.field_2429.toString();
        ask = class_529.field_2432.toString();
        asl = class_529.field_2434.toString();
        asm = Arrays.asList(new String[] {"detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"});
    }

    public class_582(Context var1, DataLayer var2) {
        this(var1, var2, new class_633(var1));
    }

    class_582(Context var1, DataLayer var2, class_633 var3) {
        super(field_3094, new String[0]);
        this.aod = var2;
        this.asq = var3;
        this.asp = new HashSet();
        this.asp.add("");
        this.asp.add("0");
        this.asp.add("false");
    }

    // $FF: renamed from: M (java.util.Map) com.google.android.gms.analytics.ecommerce.Promotion
    private Promotion method_3425(Map<String, String> var1) {
        Promotion var2 = new Promotion();
        String var3 = (String)var1.get("id");
        if(var3 != null) {
            var2.setId(String.valueOf(var3));
        }

        String var4 = (String)var1.get("name");
        if(var4 != null) {
            var2.setName(String.valueOf(var4));
        }

        String var5 = (String)var1.get("creative");
        if(var5 != null) {
            var2.setCreative(String.valueOf(var5));
        }

        String var6 = (String)var1.get("position");
        if(var6 != null) {
            var2.setPosition(String.valueOf(var6));
        }

        return var2;
    }

    // $FF: renamed from: N (java.util.Map) com.google.android.gms.analytics.ecommerce.Product
    private Product method_3426(Map<String, Object> var1) {
        Product var2 = new Product();
        Object var3 = var1.get("id");
        if(var3 != null) {
            var2.setId(String.valueOf(var3));
        }

        Object var4 = var1.get("name");
        if(var4 != null) {
            var2.setName(String.valueOf(var4));
        }

        Object var5 = var1.get("brand");
        if(var5 != null) {
            var2.setBrand(String.valueOf(var5));
        }

        Object var6 = var1.get("category");
        if(var6 != null) {
            var2.setCategory(String.valueOf(var6));
        }

        Object var7 = var1.get("variant");
        if(var7 != null) {
            var2.setVariant(String.valueOf(var7));
        }

        Object var8 = var1.get("coupon");
        if(var8 != null) {
            var2.setCouponCode(String.valueOf(var8));
        }

        Object var9 = var1.get("position");
        if(var9 != null) {
            var2.setPosition(this.method_3439(var9).intValue());
        }

        Object var10 = var1.get("price");
        if(var10 != null) {
            var2.setPrice(this.method_3438(var10).doubleValue());
        }

        Object var11 = var1.get("quantity");
        if(var11 != null) {
            var2.setQuantity(this.method_3439(var11).intValue());
        }

        return var2;
    }

    // $FF: renamed from: O (java.util.Map) java.util.Map
    private Map<String, String> method_3427(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(ask);
        if(var2 != null) {
            return this.method_3433(var2);
        } else {
            if(asn == null) {
                HashMap var3 = new HashMap();
                var3.put("transactionId", "&ti");
                var3.put("transactionAffiliation", "&ta");
                var3.put("transactionTax", "&tt");
                var3.put("transactionShipping", "&ts");
                var3.put("transactionTotal", "&tr");
                var3.put("transactionCurrency", "&cu");
                asn = var3;
            }

            return asn;
        }
    }

    // $FF: renamed from: P (java.util.Map) java.util.Map
    private Map<String, String> method_3428(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(asl);
        if(var2 != null) {
            return this.method_3433(var2);
        } else {
            if(aso == null) {
                HashMap var3 = new HashMap();
                var3.put("name", "&in");
                var3.put("sku", "&ic");
                var3.put("category", "&iv");
                var3.put("price", "&ip");
                var3.put("quantity", "&iq");
                var3.put("currency", "&cu");
                aso = var3;
            }

            return aso;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.analytics.Tracker, java.util.Map) void
    private void method_3429(Tracker param1, Map<String, class_53.class_1172> param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.analytics.Tracker, java.util.Map) void
    private void method_3430(Tracker param1, Map<String, class_53.class_1172> param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.util.Map, java.lang.String, java.lang.String) void
    private void method_3431(Map<String, String> var1, String var2, String var3) {
        if(var3 != null) {
            var1.put(var2, var3);
        }

    }

    // $FF: renamed from: c (java.lang.String, java.util.Map) com.google.android.gms.analytics.ecommerce.ProductAction
    private ProductAction method_3432(String var1, Map<String, Object> var2) {
        ProductAction var3 = new ProductAction(var1);
        Object var4 = var2.get("id");
        if(var4 != null) {
            var3.setTransactionId(String.valueOf(var4));
        }

        Object var5 = var2.get("affiliation");
        if(var5 != null) {
            var3.setTransactionAffiliation(String.valueOf(var5));
        }

        Object var6 = var2.get("coupon");
        if(var6 != null) {
            var3.setTransactionCouponCode(String.valueOf(var6));
        }

        Object var7 = var2.get("list");
        if(var7 != null) {
            var3.setProductActionList(String.valueOf(var7));
        }

        Object var8 = var2.get("option");
        if(var8 != null) {
            var3.setCheckoutOptions(String.valueOf(var8));
        }

        Object var9 = var2.get("revenue");
        if(var9 != null) {
            var3.setTransactionRevenue(this.method_3438(var9).doubleValue());
        }

        Object var10 = var2.get("tax");
        if(var10 != null) {
            var3.setTransactionTax(this.method_3438(var10).doubleValue());
        }

        Object var11 = var2.get("shipping");
        if(var11 != null) {
            var3.setTransactionShipping(this.method_3438(var11).doubleValue());
        }

        Object var12 = var2.get("step");
        if(var12 != null) {
            var3.setCheckoutStep(this.method_3439(var12).intValue());
        }

        return var3;
    }

    // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
    private Map<String, String> method_3433(class_53.class_1172 var1) {
        Object var2 = class_634.method_3548(var1);
        if(!(var2 instanceof Map)) {
            return null;
        } else {
            Map var3 = (Map)var2;
            LinkedHashMap var4 = new LinkedHashMap();
            Iterator var5 = var3.entrySet().iterator();

            while(var5.hasNext()) {
                Entry var6 = (Entry)var5.next();
                var4.put(var6.getKey().toString(), var6.getValue().toString());
            }

            return var4;
        }
    }

    // $FF: renamed from: dc (java.lang.String) java.lang.String
    private String method_3434(String var1) {
        Object var2 = this.aod.get(var1);
        return var2 == null?null:var2.toString();
    }

    // $FF: renamed from: dd (java.lang.String) java.util.List
    private List<Map<String, String>> method_3435(String var1) {
        Object var2 = this.aod.get(var1);
        if(var2 == null) {
            return null;
        } else if(!(var2 instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        } else {
            Iterator var3 = ((List)var2).iterator();

            do {
                if(!var3.hasNext()) {
                    return (List)var2;
                }
            } while(var3.next() instanceof Map);

            throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
        }
    }

    // $FF: renamed from: f (java.util.Map, java.lang.String) boolean
    private boolean method_3436(Map<String, class_53.class_1172> var1, String var2) {
        class_53.class_1172 var3 = (class_53.class_1172)var1.get(var2);
        return var3 == null?false:class_634.method_3547(var3).booleanValue();
    }

    // $FF: renamed from: p (com.google.android.gms.internal.d$a) java.util.Map
    private Map<String, String> method_3437(class_53.class_1172 var1) {
        if(var1 == null) {
            return new HashMap();
        } else {
            Map var2 = this.method_3433(var1);
            if(var2 == null) {
                return new HashMap();
            } else {
                String var3 = (String)var2.get("&aip");
                if(var3 != null && this.asp.contains(var3.toLowerCase())) {
                    var2.remove("&aip");
                }

                return var2;
            }
        }
    }

    // $FF: renamed from: y (java.lang.Object) java.lang.Double
    private Double method_3438(Object var1) {
        if(var1 instanceof String) {
            try {
                Double var3 = Double.valueOf((String)var1);
                return var3;
            } catch (NumberFormatException var4) {
                throw new RuntimeException("Cannot convert the object to Double: " + var4.getMessage());
            }
        } else if(var1 instanceof Integer) {
            return Double.valueOf(((Integer)var1).doubleValue());
        } else if(var1 instanceof Double) {
            return (Double)var1;
        } else {
            throw new RuntimeException("Cannot convert the object to Double: " + var1.toString());
        }
    }

    // $FF: renamed from: z (java.lang.Object) java.lang.Integer
    private Integer method_3439(Object var1) {
        if(var1 instanceof String) {
            try {
                Integer var3 = Integer.valueOf((String)var1);
                return var3;
            } catch (NumberFormatException var4) {
                throw new RuntimeException("Cannot convert the object to Integer: " + var4.getMessage());
            }
        } else if(var1 instanceof Double) {
            return Integer.valueOf(((Double)var1).intValue());
        } else if(var1 instanceof Integer) {
            return (Integer)var1;
        } else {
            throw new RuntimeException("Cannot convert the object to Integer: " + var1.toString());
        }
    }

    // $FF: renamed from: E (java.util.Map) void
    public void method_3419(Map<String, class_53.class_1172> var1) {
        Tracker var2 = this.asq.method_3537("_GTM_DEFAULT_TRACKER_");
        if(this.method_3436(var1, asf)) {
            this.method_3430(var2, var1);
        } else if(this.method_3436(var1, ase)) {
            var2.send(this.method_3437((class_53.class_1172)var1.get(asi)));
        } else if(this.method_3436(var1, asj)) {
            this.method_3429(var2, var1);
        } else {
            class_612.method_3459("Ignoring unknown tag.");
        }
    }
}
