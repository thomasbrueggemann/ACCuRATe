package com.google.android.gms.internal;

import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_549;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ci
@ey
public final class class_456 implements class_46 {
   // $FF: renamed from: qc com.google.android.gms.internal.ce
   private final class_47 field_1537;
   // $FF: renamed from: qd com.google.android.gms.internal.v
   private final class_549 field_1538;

   public class_456(class_47 var1, class_549 var2) {
      this.field_1537 = var1;
      this.field_1538 = var2;
   }

   // $FF: renamed from: b (java.util.Map) boolean
   private static boolean method_2920(Map<String, String> var0) {
      return "1".equals(var0.get("custom_close"));
   }

   // $FF: renamed from: c (java.util.Map) int
   private static int method_2921(Map<String, String> var0) {
      String var1 = (String)var0.get("o");
      if(var1 != null) {
         if("p".equalsIgnoreCase(var1)) {
            return class_375.method_2572();
         }

         if("l".equalsIgnoreCase(var1)) {
            return class_375.method_2571();
         }
      }

      return -1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu, java.util.Map) void
   public void method_213(gu var1, Map<String, String> var2) {
      String var3 = (String)var2.get("a");
      if(var3 == null) {
         class_368.method_2506("Action missing from an open GMSG.");
      } else {
         if(this.field_1538 != null && !this.field_1538.method_3337()) {
            this.field_1538.method_3338((String)var2.get("u"));
            return;
         }

         class_356 var4 = var1.method_2531();
         if("expand".equalsIgnoreCase(var3)) {
            if(var1.method_2535()) {
               class_368.method_2506("Cannot expand WebView that is already expanded.");
               return;
            }

            var4.method_2452(method_2920(var2), method_2921(var2));
            return;
         }

         if("webapp".equalsIgnoreCase(var3)) {
            String var8 = (String)var2.get("u");
            if(var8 != null) {
               var4.method_2453(method_2920(var2), method_2921(var2), var8);
               return;
            }

            var4.method_2454(method_2920(var2), method_2921(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
            return;
         }

         if(!"in_app_purchase".equalsIgnoreCase(var3)) {
            var4.method_2446(new class_458((String)var2.get("i"), (String)var2.get("u"), (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
            return;
         }

         String var5 = (String)var2.get("product_id");
         String var6 = (String)var2.get("report_urls");
         if(this.field_1537 != null) {
            if(var6 != null && !var6.isEmpty()) {
               String[] var7 = var6.split(" ");
               this.field_1537.method_214(var5, new ArrayList(Arrays.asList(var7)));
               return;
            }

            this.field_1537.method_214(var5, new ArrayList());
            return;
         }
      }

   }
}
