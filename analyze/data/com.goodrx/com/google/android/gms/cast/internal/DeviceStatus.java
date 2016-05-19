package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzg;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DeviceStatus implements SafeParcelable {
   public static final Creator<DeviceStatus> CREATOR = new zzg();
   private final int mVersionCode;
   private double zzabs;
   private boolean zzabt;
   private int zzadG;
   private int zzadH;
   private ApplicationMetadata zzadR;

   public DeviceStatus() {
      this(3, Double.NaN, false, -1, (ApplicationMetadata)null, -1);
   }

   DeviceStatus(int var1, double var2, boolean var4, int var5, ApplicationMetadata var6, int var7) {
      this.mVersionCode = var1;
      this.zzabs = var2;
      this.zzabt = var4;
      this.zzadG = var5;
      this.zzadR = var6;
      this.zzadH = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof DeviceStatus)) {
            return false;
         }

         DeviceStatus var2 = (DeviceStatus)var1;
         if(this.zzabs != var2.zzabs || this.zzabt != var2.zzabt || this.zzadG != var2.zzadG || !zzf.zza(this.zzadR, var2.zzadR) || this.zzadH != var2.zzadH) {
            return false;
         }
      }

      return true;
   }

   public ApplicationMetadata getApplicationMetadata() {
      return this.zzadR;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Double.valueOf(this.zzabs), Boolean.valueOf(this.zzabt), Integer.valueOf(this.zzadG), this.zzadR, Integer.valueOf(this.zzadH)};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }

   public double zzok() {
      return this.zzabs;
   }

   public int zzol() {
      return this.zzadG;
   }

   public int zzom() {
      return this.zzadH;
   }

   public boolean zzot() {
      return this.zzabt;
   }
}
