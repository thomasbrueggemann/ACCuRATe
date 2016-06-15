package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_675;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.plus.internal.h
public class class_677 implements SafeParcelable {
   public static final class_675 CREATOR = new class_675();
   private final String[] abQ;
   private final String[] abR;
   private final String[] abS;
   private final String abT;
   private final String abU;
   private final String abV;
   private final String abW;
   private final PlusCommonExtras abX;
   // $FF: renamed from: xJ int
   private final int field_3624;
   // $FF: renamed from: yN java.lang.String
   private final String field_3625;

   class_677(int var1, String var2, String[] var3, String[] var4, String[] var5, String var6, String var7, String var8, String var9, PlusCommonExtras var10) {
      this.field_3624 = var1;
      this.field_3625 = var2;
      this.abQ = var3;
      this.abR = var4;
      this.abS = var5;
      this.abT = var6;
      this.abU = var7;
      this.abV = var8;
      this.abW = var9;
      this.abX = var10;
   }

   public class_677(String var1, String[] var2, String[] var3, String[] var4, String var5, String var6, String var7, PlusCommonExtras var8) {
      this.field_3624 = 1;
      this.field_3625 = var1;
      this.abQ = var2;
      this.abR = var3;
      this.abS = var4;
      this.abT = var5;
      this.abU = var6;
      this.abV = var7;
      this.abW = null;
      this.abX = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_677) {
         class_677 var2 = (class_677)var1;
         if(this.field_3624 == var2.field_3624 && class_349.equal(this.field_3625, var2.field_3625) && Arrays.equals(this.abQ, var2.abQ) && Arrays.equals(this.abR, var2.abR) && Arrays.equals(this.abS, var2.abS) && class_349.equal(this.abT, var2.abT) && class_349.equal(this.abU, var2.abU) && class_349.equal(this.abV, var2.abV) && class_349.equal(this.abW, var2.abW) && class_349.equal(this.abX, var2.abX)) {
            return true;
         }
      }

      return false;
   }

   public String getAccountName() {
      return this.field_3625;
   }

   public int getVersionCode() {
      return this.field_3624;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3624), this.field_3625, this.abQ, this.abR, this.abS, this.abT, this.abU, this.abV, this.abW, this.abX};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: jU () java.lang.String[]
   public String[] method_3937() {
      return this.abQ;
   }

   // $FF: renamed from: jV () java.lang.String[]
   public String[] method_3938() {
      return this.abR;
   }

   // $FF: renamed from: jW () java.lang.String[]
   public String[] method_3939() {
      return this.abS;
   }

   // $FF: renamed from: jX () java.lang.String
   public String method_3940() {
      return this.abT;
   }

   // $FF: renamed from: jY () java.lang.String
   public String method_3941() {
      return this.abU;
   }

   // $FF: renamed from: jZ () java.lang.String
   public String method_3942() {
      return this.abV;
   }

   // $FF: renamed from: ka () java.lang.String
   public String method_3943() {
      return this.abW;
   }

   // $FF: renamed from: kb () com.google.android.gms.plus.internal.PlusCommonExtras
   public PlusCommonExtras method_3944() {
      return this.abX;
   }

   // $FF: renamed from: kc () android.os.Bundle
   public Bundle method_3945() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(PlusCommonExtras.class.getClassLoader());
      this.abX.method_2681(var1);
      return var1;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("versionCode", Integer.valueOf(this.field_3624)).method_4301("accountName", this.field_3625).method_4301("requestedScopes", this.abQ).method_4301("visibleActivities", this.abR).method_4301("requiredFeatures", this.abS).method_4301("packageNameForAuth", this.abT).method_4301("callingPackageName", this.abU).method_4301("applicationName", this.abV).method_4301("extra", this.abX.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_675.method_3932(this, var1, var2);
   }
}
