package com.google.android.gms.internal;

import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_486;
import com.google.android.gms.internal.class_539;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cd
@ez
public final class class_464 implements class_9 {
    // $FF: renamed from: pL com.google.android.gms.internal.bz
    private final class_42 field_1794;
    // $FF: renamed from: pM com.google.android.gms.internal.v
    private final class_539 field_1795;

    public class_464(class_42 var1, class_539 var2) {
        this.field_1794 = var1;
        this.field_1795 = var2;
    }

    // $FF: renamed from: b (java.util.Map) boolean
    private static boolean method_2847(Map<String, String> var0) {
        return "1".equals(var0.get("custom_close"));
    }

    // $FF: renamed from: c (java.util.Map) int
    private static int method_2848(Map<String, String> var0) {
        String var1 = (String)var0.get("o");
        if(var1 != null) {
            if("p".equalsIgnoreCase(var1)) {
                return class_383.method_2525();
            }

            if("l".equalsIgnoreCase(var1)) {
                return class_383.method_2524();
            }
        }

        return -1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
    public void method_24(gv var1, Map<String, String> var2) {
        String var3 = (String)var2.get("a");
        if(var3 == null) {
            class_378.method_2461("Action missing from an open GMSG.");
        } else {
            if(this.field_1795 != null && !this.field_1795.method_3298()) {
                this.field_1795.method_3299((String)var2.get("u"));
                return;
            }

            class_364 var4 = var1.method_2486();
            if("expand".equalsIgnoreCase(var3)) {
                if(var1.method_2490()) {
                    class_378.method_2461("Cannot expand WebView that is already expanded.");
                    return;
                }

                var4.method_2401(method_2847(var2), method_2848(var2));
                return;
            }

            if("webapp".equalsIgnoreCase(var3)) {
                String var8 = (String)var2.get("u");
                if(var8 != null) {
                    var4.method_2402(method_2847(var2), method_2848(var2), var8);
                    return;
                }

                var4.method_2403(method_2847(var2), method_2848(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
                return;
            }

            if(!"in_app_purchase".equalsIgnoreCase(var3)) {
                var4.method_2395(new class_486((String)var2.get("i"), (String)var2.get("u"), (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
                return;
            }

            String var5 = (String)var2.get("product_id");
            String var6 = (String)var2.get("report_urls");
            if(this.field_1794 != null) {
                if(var6 != null && !var6.isEmpty()) {
                    String[] var7 = var6.split(" ");
                    this.field_1794.method_178(var5, new ArrayList(Arrays.asList(var7)));
                    return;
                }

                this.field_1794.method_178(var5, new ArrayList());
                return;
            }
        }

    }
}
