package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.af
public class class_869 {
   // $FF: renamed from: BO java.util.Map
   private final Map<String, Integer> field_3719 = new HashMap();
   // $FF: renamed from: BP java.util.Map
   private final Map<String, String> field_3720 = new HashMap();
   // $FF: renamed from: BQ boolean
   private final boolean field_3721;
   // $FF: renamed from: BR java.lang.String
   private final String field_3722;

   public class_869(String var1, boolean var2) {
      this.field_3721 = var2;
      this.field_3722 = var1;
   }

   // $FF: renamed from: e (java.lang.String, int) void
   public void method_4878(String var1, int var2) {
      if(this.field_3721) {
         Integer var3 = (Integer)this.field_3719.get(var1);
         if(var3 == null) {
            var3 = Integer.valueOf(0);
         }

         this.field_3719.put(var1, Integer.valueOf(var2 + var3.intValue()));
      }
   }

   // $FF: renamed from: fg () java.lang.String
   public String method_4879() {
      if(!this.field_3721) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.field_3722);
         Iterator var3 = this.field_3719.keySet().iterator();

         while(var3.hasNext()) {
            String var7 = (String)var3.next();
            var1.append("&").append(var7).append("=").append(this.field_3719.get(var7));
         }

         Iterator var4 = this.field_3720.keySet().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            var1.append("&").append(var5).append("=").append((String)this.field_3720.get(var5));
         }

         return var1.toString();
      }
   }

   // $FF: renamed from: g (java.lang.String, java.lang.String) void
   public void method_4880(String var1, String var2) {
      if(this.field_3721 && !TextUtils.isEmpty(var1)) {
         this.field_3720.put(var1, var2);
      }
   }
}
