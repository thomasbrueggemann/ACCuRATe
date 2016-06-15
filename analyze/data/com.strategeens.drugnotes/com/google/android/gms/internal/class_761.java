package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_762;
import com.google.android.gms.internal.class_763;

// $FF: renamed from: com.google.android.gms.internal.ns
public final class class_761 implements SafeParcelable {
   public static final class_762 CREATOR = new class_762();
   // $FF: renamed from: CK int
   private final int field_3423;
   private final int agd;
   private final int ahp;
   private final class_763 ahq;

   class_761(int var1, int var2, int var3, class_763 var4) {
      this.field_3423 = var1;
      this.agd = var2;
      this.ahp = var3;
      this.ahq = var4;
   }

   public int describeContents() {
      class_762 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_761)) {
            return false;
         }

         class_761 var2 = (class_761)var1;
         if(this.agd != var2.agd || this.ahp != var2.ahp || !this.ahq.equals(var2.ahq)) {
            return false;
         }
      }

      return true;
   }

   public int getVersionCode() {
      return this.field_3423;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.agd), Integer.valueOf(this.ahp)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: np () int
   public int method_4358() {
      return this.agd;
   }

   // $FF: renamed from: ns () int
   public int method_4359() {
      return this.ahp;
   }

   // $FF: renamed from: nt () com.google.android.gms.internal.nu
   public class_763 method_4360() {
      return this.ahq;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("transitionTypes", Integer.valueOf(this.agd)).method_3424("loiteringTimeMillis", Integer.valueOf(this.ahp)).method_3424("placeFilter", this.ahq).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_762 var10000 = CREATOR;
      class_762.method_4361(this, var1, var2);
   }
}
