package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_438;

// $FF: renamed from: com.google.android.gms.internal.da
public class class_439 {
   // $FF: renamed from: mx java.lang.String
   private final String field_1996;

   public class_439(String var1) {
      this.field_1996 = var1;
   }

   // $FF: renamed from: a (java.lang.String, int, android.content.Intent) boolean
   public boolean method_2671(String var1, int var2, Intent var3) {
      if(var1 != null && var3 != null) {
         String var4 = class_414.method_2532(var3);
         String var5 = class_414.method_2533(var3);
         if(var4 != null && var5 != null) {
            if(!var1.equals(class_414.method_2534(var4))) {
               class_370.method_2358("Developer payload not match.");
               return false;
            }

            if(this.field_1996 != null && !class_438.method_2669(this.field_1996, var4, var5)) {
               class_370.method_2358("Fail to verify signature.");
               return false;
            }

            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: bh () java.lang.String
   public String method_2672() {
      return class_365.method_2306();
   }
}
