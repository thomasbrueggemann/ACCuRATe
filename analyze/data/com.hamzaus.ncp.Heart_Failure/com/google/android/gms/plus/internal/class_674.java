package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_677;
import java.util.ArrayList;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.plus.internal.i
public class class_674 {
   private String[] abS;
   private String abT;
   private String abU;
   private String abV;
   private PlusCommonExtras abX;
   private final ArrayList<String> abY = new ArrayList();
   private String[] abZ;
   // $FF: renamed from: yN java.lang.String
   private String field_3623;

   public class_674(Context var1) {
      this.abU = var1.getPackageName();
      this.abT = var1.getPackageName();
      this.abX = new PlusCommonExtras();
      this.abY.add("https://www.googleapis.com/auth/plus.login");
   }

   // $FF: renamed from: bz (java.lang.String) com.google.android.gms.plus.internal.i
   public class_674 method_3927(String var1) {
      this.field_3623 = var1;
      return this;
   }

   // $FF: renamed from: e (java.lang.String[]) com.google.android.gms.plus.internal.i
   public class_674 method_3928(String... var1) {
      this.abY.clear();
      this.abY.addAll(Arrays.asList(var1));
      return this;
   }

   // $FF: renamed from: f (java.lang.String[]) com.google.android.gms.plus.internal.i
   public class_674 method_3929(String... var1) {
      this.abZ = var1;
      return this;
   }

   // $FF: renamed from: kd () com.google.android.gms.plus.internal.i
   public class_674 method_3930() {
      this.abY.clear();
      return this;
   }

   // $FF: renamed from: ke () com.google.android.gms.plus.internal.h
   public class_677 method_3931() {
      if(this.field_3623 == null) {
         this.field_3623 = "<<default account>>";
      }

      String[] var1 = (String[])this.abY.toArray(new String[this.abY.size()]);
      return new class_677(this.field_3623, var1, this.abZ, this.abS, this.abT, this.abU, this.abV, this.abX);
   }
}
