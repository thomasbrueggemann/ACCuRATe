package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_333;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.gk;

// $FF: renamed from: com.google.android.gms.internal.gk
public class class_334 implements SafeParcelable {
   public static final Creator<gk> CREATOR = new class_333();
   // $FF: renamed from: AM double
   private double field_1355;
   // $FF: renamed from: AN boolean
   private boolean field_1356;
   // $FF: renamed from: BO int
   private int field_1357;
   // $FF: renamed from: xJ int
   private final int field_1358;

   public class_334() {
      this(1, Double.NaN, false, -1);
   }

   class_334(int var1, double var2, boolean var4, int var5) {
      this.field_1358 = var1;
      this.field_1355 = var2;
      this.field_1356 = var4;
      this.field_1357 = var5;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: ec () double
   public double method_2126() {
      return this.field_1355;
   }

   // $FF: renamed from: ei () boolean
   public boolean method_2127() {
      return this.field_1356;
   }

   // $FF: renamed from: ej () int
   public int method_2128() {
      return this.field_1357;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof class_334)) {
            return false;
         }

         class_334 var2 = (class_334)var1;
         if(this.field_1355 != var2.field_1355 || this.field_1356 != var2.field_1356 || this.field_1357 != var2.field_1357) {
            return false;
         }
      }

      return true;
   }

   public int getVersionCode() {
      return this.field_1358;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Double.valueOf(this.field_1355), Boolean.valueOf(this.field_1356), Integer.valueOf(this.field_1357)};
      return class_349.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_333.method_2123(this, var1, var2);
   }
}
