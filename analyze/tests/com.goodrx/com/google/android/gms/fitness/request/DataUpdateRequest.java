package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zzm;
import com.google.android.gms.internal.zzow;

public class DataUpdateRequest implements SafeParcelable {
   public static final Creator<DataUpdateRequest> CREATOR = new zzm();
   private final int mVersionCode;
   private final long zzRD;
   private final zzow zzaAD;
   private final long zzavV;
   private final DataSet zzaxn;

   DataUpdateRequest(int var1, long var2, long var4, DataSet var6, IBinder var7) {
      this.mVersionCode = var1;
      this.zzRD = var2;
      this.zzavV = var4;
      this.zzaxn = var6;
      this.zzaAD = zzow.zza.zzbR(var7);
   }

   private boolean zzb(DataUpdateRequest var1) {
      return this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && com.google.android.gms.common.internal.zzw.equal(this.zzaxn, var1.zzaxn);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataUpdateRequest && this.zzb((DataUpdateRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public DataSet getDataSet() {
      return this.zzaxn;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxn};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSet", this.zzaxn).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public long zzud() {
      return this.zzavV;
   }
}
