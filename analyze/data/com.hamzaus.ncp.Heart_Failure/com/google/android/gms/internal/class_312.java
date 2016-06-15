package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.class_311;
import com.google.android.gms.internal.class_349;

// $FF: renamed from: com.google.android.gms.internal.jl
public final class class_312 implements SafeParcelable {
   public static final class_311 CREATOR = new class_311();
   // $FF: renamed from: UX int
   private final int field_1265;
   // $FF: renamed from: VX int
   private final int field_1266;
   // $FF: renamed from: VY com.google.android.gms.internal.jn
   private final class_310 field_1267;
   // $FF: renamed from: xJ int
   private final int field_1268;

   class_312(int var1, int var2, int var3, class_310 var4) {
      this.field_1268 = var1;
      this.field_1265 = var2;
      this.field_1266 = var3;
      this.field_1267 = var4;
   }

   public int describeContents() {
      class_311 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_312)) {
            return false;
         }

         class_312 var2 = (class_312)var1;
         if(this.field_1265 != var2.field_1265 || this.field_1266 != var2.field_1266 || !this.field_1267.equals(var2.field_1267)) {
            return false;
         }
      }

      return true;
   }

   public int getVersionCode() {
      return this.field_1268;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_1265), Integer.valueOf(this.field_1266)};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: iX () int
   public int method_2026() {
      return this.field_1265;
   }

   // $FF: renamed from: iZ () int
   public int method_2027() {
      return this.field_1266;
   }

   // $FF: renamed from: ja () com.google.android.gms.internal.jn
   public class_310 method_2028() {
      return this.field_1267;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("transitionTypes", Integer.valueOf(this.field_1265)).method_4301("loiteringTimeMillis", Integer.valueOf(this.field_1266)).method_4301("placeFilter", this.field_1267).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_311 var10000 = CREATOR;
      class_311.method_2019(this, var1, var2);
   }
}
