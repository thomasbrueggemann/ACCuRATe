package com.google.android.gms.internal;

import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bh
public final class class_185 implements class_10 {
   // $FF: renamed from: nb com.google.android.gms.internal.be
   private final class_9 field_591;

   public class_185(class_9 var1) {
      this.field_591 = var1;
   }

   // $FF: renamed from: a (java.util.Map) boolean
   private static boolean method_1297(Map<String, String> var0) {
      return "1".equals(var0.get("custom_close"));
   }

   // $FF: renamed from: b (java.util.Map) int
   private static int method_1298(Map<String, String> var0) {
      String var1 = (String)var0.get("o");
      if(var1 != null) {
         if("p".equalsIgnoreCase(var1)) {
            return class_365.method_2305();
         }

         if("l".equalsIgnoreCase(var1)) {
            return class_365.method_2304();
         }
      }

      return -1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ey, java.util.Map) void
   public void method_19(ey var1, Map<String, String> var2) {
      String var3 = (String)var2.get("a");
      if(var3 == null) {
         class_370.method_2358("Action missing from an open GMSG.");
      } else {
         class_367 var4 = var1.method_2349();
         if("expand".equalsIgnoreCase(var3)) {
            if(var1.method_2352()) {
               class_370.method_2358("Cannot expand WebView that is already expanded.");
               return;
            }

            var4.method_2326(method_1297(var2), method_1298(var2));
            return;
         }

         if("webapp".equalsIgnoreCase(var3)) {
            String var8 = (String)var2.get("u");
            if(var8 != null) {
               var4.method_2327(method_1297(var2), method_1298(var2), var8);
               return;
            }

            var4.method_2328(method_1297(var2), method_1298(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
            return;
         }

         if(!"in_app_purchase".equalsIgnoreCase(var3)) {
            var4.method_2320(new class_421((String)var2.get("i"), (String)var2.get("u"), (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
            return;
         }

         String var5 = (String)var2.get("product_id");
         String var6 = (String)var2.get("report_urls");
         if(this.field_591 != null) {
            if(var6 != null && !var6.isEmpty()) {
               String[] var7 = var6.split(" ");
               this.field_591.method_18(var5, new ArrayList(Arrays.asList(var7)));
               return;
            }

            this.field_591.method_18(var5, new ArrayList());
            return;
         }
      }

   }
}
