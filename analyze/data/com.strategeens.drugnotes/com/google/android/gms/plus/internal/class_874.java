package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_873;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.plus.internal.h
public class class_874 implements SafeParcelable {
   public static final class_873 CREATOR = new class_873();
   // $FF: renamed from: CK int
   private final int field_3758;
   // $FF: renamed from: DZ java.lang.String
   private final String field_3759;
   private final String[] anQ;
   private final String[] anR;
   private final String[] anS;
   private final String anT;
   private final String anU;
   private final String anV;
   private final String anW;
   private final PlusCommonExtras anX;

   class_874(int var1, String var2, String[] var3, String[] var4, String[] var5, String var6, String var7, String var8, String var9, PlusCommonExtras var10) {
      this.field_3758 = var1;
      this.field_3759 = var2;
      this.anQ = var3;
      this.anR = var4;
      this.anS = var5;
      this.anT = var6;
      this.anU = var7;
      this.anV = var8;
      this.anW = var9;
      this.anX = var10;
   }

   public class_874(String var1, String[] var2, String[] var3, String[] var4, String var5, String var6, String var7, PlusCommonExtras var8) {
      this.field_3758 = 1;
      this.field_3759 = var1;
      this.anQ = var2;
      this.anR = var3;
      this.anS = var4;
      this.anT = var5;
      this.anU = var6;
      this.anV = var7;
      this.anW = null;
      this.anX = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_874) {
         class_874 var2 = (class_874)var1;
         if(this.field_3758 == var2.field_3758 && class_336.equal(this.field_3759, var2.field_3759) && Arrays.equals(this.anQ, var2.anQ) && Arrays.equals(this.anR, var2.anR) && Arrays.equals(this.anS, var2.anS) && class_336.equal(this.anT, var2.anT) && class_336.equal(this.anU, var2.anU) && class_336.equal(this.anV, var2.anV) && class_336.equal(this.anW, var2.anW) && class_336.equal(this.anX, var2.anX)) {
            return true;
         }
      }

      return false;
   }

   public String getAccountName() {
      return this.field_3759;
   }

   public int getVersionCode() {
      return this.field_3758;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3758), this.field_3759, this.anQ, this.anR, this.anS, this.anT, this.anU, this.anV, this.anW, this.anX};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: oA () java.lang.String[]
   public String[] method_4916() {
      return this.anR;
   }

   // $FF: renamed from: oB () java.lang.String[]
   public String[] method_4917() {
      return this.anS;
   }

   // $FF: renamed from: oC () java.lang.String
   public String method_4918() {
      return this.anT;
   }

   // $FF: renamed from: oD () java.lang.String
   public String method_4919() {
      return this.anU;
   }

   // $FF: renamed from: oE () java.lang.String
   public String method_4920() {
      return this.anV;
   }

   // $FF: renamed from: oF () java.lang.String
   public String method_4921() {
      return this.anW;
   }

   // $FF: renamed from: oG () com.google.android.gms.plus.internal.PlusCommonExtras
   public PlusCommonExtras method_4922() {
      return this.anX;
   }

   // $FF: renamed from: oH () android.os.Bundle
   public Bundle method_4923() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(PlusCommonExtras.class.getClassLoader());
      this.anX.method_3038(var1);
      return var1;
   }

   // $FF: renamed from: oz () java.lang.String[]
   public String[] method_4924() {
      return this.anQ;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("versionCode", Integer.valueOf(this.field_3758)).method_3424("accountName", this.field_3759).method_3424("requestedScopes", this.anQ).method_3424("visibleActivities", this.anR).method_3424("requiredFeatures", this.anS).method_3424("packageNameForAuth", this.anT).method_3424("callingPackageName", this.anU).method_3424("applicationName", this.anV).method_3424("extra", this.anX.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_873.method_4913(this, var1, var2);
   }
}
