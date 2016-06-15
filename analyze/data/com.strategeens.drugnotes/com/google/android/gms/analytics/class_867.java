package com.google.android.gms.analytics;

import android.app.Activity;
import com.google.android.gms.analytics.class_171;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.am
class class_867 implements class_171 {
   // $FF: renamed from: CA int
   int field_3710 = -1;
   // $FF: renamed from: CB java.util.Map
   Map<String, String> field_3711 = new HashMap();
   // $FF: renamed from: Cv java.lang.String
   String field_3712;
   // $FF: renamed from: Cw double
   double field_3713 = -1.0D;
   // $FF: renamed from: Cx int
   int field_3714 = -1;
   // $FF: renamed from: Cy int
   int field_3715 = -1;
   // $FF: renamed from: Cz int
   int field_3716 = -1;

   // $FF: renamed from: am (java.lang.String) java.lang.String
   public String method_4862(String var1) {
      String var2 = (String)this.field_3711.get(var1);
      return var2 != null?var2:var1;
   }

   // $FF: renamed from: fA () boolean
   public boolean method_4863() {
      return this.field_3716 != -1;
   }

   // $FF: renamed from: fB () boolean
   public boolean method_4864() {
      return this.field_3716 == 1;
   }

   // $FF: renamed from: fC () boolean
   public boolean method_4865() {
      return this.field_3710 == 1;
   }

   // $FF: renamed from: ft () boolean
   public boolean method_4866() {
      return this.field_3712 != null;
   }

   // $FF: renamed from: fu () java.lang.String
   public String method_4867() {
      return this.field_3712;
   }

   // $FF: renamed from: fv () boolean
   public boolean method_4868() {
      return this.field_3713 >= 0.0D;
   }

   // $FF: renamed from: fw () double
   public double method_4869() {
      return this.field_3713;
   }

   // $FF: renamed from: fx () boolean
   public boolean method_4870() {
      return this.field_3714 >= 0;
   }

   // $FF: renamed from: fy () boolean
   public boolean method_4871() {
      return this.field_3715 != -1;
   }

   // $FF: renamed from: fz () boolean
   public boolean method_4872() {
      return this.field_3715 == 1;
   }

   public int getSessionTimeout() {
      return this.field_3714;
   }

   // $FF: renamed from: k (android.app.Activity) java.lang.String
   public String method_4873(Activity var1) {
      return this.method_4862(var1.getClass().getCanonicalName());
   }
}
