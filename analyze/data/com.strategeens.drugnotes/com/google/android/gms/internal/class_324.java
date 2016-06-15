package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.io;

// $FF: renamed from: com.google.android.gms.internal.io
public class class_324 implements SafeParcelable {
   public static final Creator<io> CREATOR = new class_323();
   // $FF: renamed from: CK int
   private final int field_825;
   // $FF: renamed from: Gp double
   private double field_826;
   // $FF: renamed from: Gq boolean
   private boolean field_827;
   // $FF: renamed from: HD com.google.android.gms.cast.ApplicationMetadata
   private ApplicationMetadata field_828;
   // $FF: renamed from: Hr int
   private int field_829;
   // $FF: renamed from: Hs int
   private int field_830;

   public class_324() {
      this(3, Double.NaN, false, -1, (ApplicationMetadata)null, -1);
   }

   class_324(int var1, double var2, boolean var4, int var5, ApplicationMetadata var6, int var7) {
      this.field_825 = var1;
      this.field_826 = var2;
      this.field_827 = var4;
      this.field_829 = var5;
      this.field_828 = var6;
      this.field_830 = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof class_324)) {
            return false;
         }

         class_324 var2 = (class_324)var1;
         if(this.field_826 != var2.field_826 || this.field_827 != var2.field_827 || this.field_829 != var2.field_829 || !class_322.method_2262(this.field_828, var2.field_828) || this.field_830 != var2.field_830) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: fZ () double
   public double method_2278() {
      return this.field_826;
   }

   public ApplicationMetadata getApplicationMetadata() {
      return this.field_828;
   }

   public int getVersionCode() {
      return this.field_825;
   }

   // $FF: renamed from: gi () boolean
   public boolean method_2279() {
      return this.field_827;
   }

   // $FF: renamed from: gj () int
   public int method_2280() {
      return this.field_829;
   }

   // $FF: renamed from: gk () int
   public int method_2281() {
      return this.field_830;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Double.valueOf(this.field_826), Boolean.valueOf(this.field_827), Integer.valueOf(this.field_829), this.field_828, Integer.valueOf(this.field_830)};
      return class_336.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_323.method_2268(this, var1, var2);
   }
}
