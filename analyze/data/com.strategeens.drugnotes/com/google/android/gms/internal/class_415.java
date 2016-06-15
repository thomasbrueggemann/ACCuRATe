package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_416;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ek
@ey
public class class_415 {
   // $FF: renamed from: oK java.lang.String
   private final String field_1289;

   public class_415(String var1) {
      this.field_1289 = var1;
   }

   // $FF: renamed from: a (java.lang.String, int, android.content.Intent) boolean
   public boolean method_2748(String var1, int var2, Intent var3) {
      if(var1 != null && var3 != null) {
         String var4 = class_414.method_2745(var3);
         String var5 = class_414.method_2746(var3);
         if(var4 != null && var5 != null) {
            if(!var1.equals(class_414.method_2741(var4))) {
               class_368.method_2506("Developer payload not match.");
               return false;
            }

            if(this.field_1289 != null && !class_416.method_2752(this.field_1289, var4, var5)) {
               class_368.method_2506("Fail to verify signature.");
               return false;
            }

            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: cC () java.lang.String
   public String method_2749() {
      return class_375.method_2574();
   }
}
