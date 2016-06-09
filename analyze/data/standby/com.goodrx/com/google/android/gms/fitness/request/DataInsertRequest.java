package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.internal.zzow;

public class DataInsertRequest implements SafeParcelable {
   public static final Creator<DataInsertRequest> CREATOR = new zze();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final boolean zzaAJ;
   private final DataSet zzaxn;

   DataInsertRequest(int var1, DataSet var2, IBinder var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzaxn = var2;
      this.zzaAD = zzow.zza.zzbR(var3);
      this.zzaAJ = var4;
   }

   private boolean zzc(DataInsertRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzaxn, var1.zzaxn);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataInsertRequest && this.zzc((DataInsertRequest)var1);
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
      Object[] var1 = new Object[]{this.zzaxn};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataSet", this.zzaxn).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   public boolean zzuO() {
      return this.zzaAJ;
   }
}
