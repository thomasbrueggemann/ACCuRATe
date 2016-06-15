package com.google.android.gms.analytics;

import android.app.Activity;
import com.google.android.gms.analytics.class_137;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.aj
class class_670 implements class_137 {
   // $FF: renamed from: xA java.util.Map
   Map<String, String> field_3584 = new HashMap();
   // $FF: renamed from: xu java.lang.String
   String field_3585;
   // $FF: renamed from: xv double
   double field_3586 = -1.0D;
   // $FF: renamed from: xw int
   int field_3587 = -1;
   // $FF: renamed from: xx int
   int field_3588 = -1;
   // $FF: renamed from: xy int
   int field_3589 = -1;
   // $FF: renamed from: xz int
   int field_3590 = -1;

   // $FF: renamed from: T (java.lang.String) java.lang.String
   public String method_3893(String var1) {
      String var2 = (String)this.field_3584.get(var1);
      return var2 != null?var2:var1;
   }

   // $FF: renamed from: dA () java.lang.String
   public String method_3894() {
      return this.field_3585;
   }

   // $FF: renamed from: dB () boolean
   public boolean method_3895() {
      return this.field_3586 >= 0.0D;
   }

   // $FF: renamed from: dC () double
   public double method_3896() {
      return this.field_3586;
   }

   // $FF: renamed from: dD () boolean
   public boolean method_3897() {
      return this.field_3587 >= 0;
   }

   // $FF: renamed from: dE () boolean
   public boolean method_3898() {
      return this.field_3588 != -1;
   }

   // $FF: renamed from: dF () boolean
   public boolean method_3899() {
      return this.field_3588 == 1;
   }

   // $FF: renamed from: dG () boolean
   public boolean method_3900() {
      return this.field_3589 != -1;
   }

   // $FF: renamed from: dH () boolean
   public boolean method_3901() {
      return this.field_3589 == 1;
   }

   // $FF: renamed from: dI () boolean
   public boolean method_3902() {
      return this.field_3590 == 1;
   }

   // $FF: renamed from: dz () boolean
   public boolean method_3903() {
      return this.field_3585 != null;
   }

   public int getSessionTimeout() {
      return this.field_3587;
   }

   // $FF: renamed from: j (android.app.Activity) java.lang.String
   public String method_3904(Activity var1) {
      return this.method_3893(var1.getClass().getCanonicalName());
   }
}
