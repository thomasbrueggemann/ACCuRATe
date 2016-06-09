package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.service.zza;

public class FitnessSensorServiceRequest implements SafeParcelable {
   public static final Creator<FitnessSensorServiceRequest> CREATOR = new zza();
   private final int mVersionCode;
   private final long zzaBR;
   private final long zzaBS;
   private final zzk zzaBh;
   private final DataSource zzavU;

   FitnessSensorServiceRequest(int var1, DataSource var2, IBinder var3, long var4, long var6) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzaBh = zzk.zza.zzbt(var3);
      this.zzaBR = var4;
      this.zzaBS = var6;
   }

   private boolean zza(FitnessSensorServiceRequest var1) {
      return zzw.equal(this.zzavU, var1.zzavU) && this.zzaBR == var1.zzaBR && this.zzaBS == var1.zzaBS;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof FitnessSensorServiceRequest && this.zza((FitnessSensorServiceRequest)var1);
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, Long.valueOf(this.zzaBR), Long.valueOf(this.zzaBS)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzavU};
      return String.format("FitnessSensorServiceRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public long zzux() {
      return this.zzaBR;
   }

   IBinder zzvb() {
      return this.zzaBh.asBinder();
   }

   public long zzvs() {
      return this.zzaBS;
   }
}
