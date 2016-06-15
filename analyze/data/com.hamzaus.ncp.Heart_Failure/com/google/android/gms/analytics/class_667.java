package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.ab
class class_667 {
   // $FF: renamed from: wI java.util.Map
   private final Map<String, Integer> field_3570 = new HashMap();
   // $FF: renamed from: wJ java.util.Map
   private final Map<String, String> field_3571 = new HashMap();
   // $FF: renamed from: wK boolean
   private final boolean field_3572;
   // $FF: renamed from: wL java.lang.String
   private final String field_3573;

   class_667(String var1, boolean var2) {
      this.field_3572 = var2;
      this.field_3573 = var1;
   }

   // $FF: renamed from: c (java.lang.String, int) void
   void method_3871(String var1, int var2) {
      if(this.field_3572) {
         Integer var3 = (Integer)this.field_3570.get(var1);
         if(var3 == null) {
            var3 = Integer.valueOf(0);
         }

         this.field_3570.put(var1, Integer.valueOf(var2 + var3.intValue()));
      }
   }

   // $FF: renamed from: dl () java.lang.String
   String method_3872() {
      if(!this.field_3572) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.field_3573);
         Iterator var3 = this.field_3570.keySet().iterator();

         while(var3.hasNext()) {
            String var7 = (String)var3.next();
            var1.append("&").append(var7).append("=").append(this.field_3570.get(var7));
         }

         Iterator var4 = this.field_3571.keySet().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            var1.append("&").append(var5).append("=").append((String)this.field_3571.get(var5));
         }

         return var1.toString();
      }
   }
}
