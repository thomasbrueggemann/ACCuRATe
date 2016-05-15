package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzc;
import com.google.android.gms.internal.zzog;

public class DailyTotalRequest implements SafeParcelable {
   public static final Creator<DailyTotalRequest> CREATOR = new zzc();
   private final int mVersionCode;
   private final zzog zzaAE;
   private DataType zzavT;

   DailyTotalRequest(int var1, IBinder var2, DataType var3) {
      this.mVersionCode = var1;
      this.zzaAE = zzog.zza.zzbB(var2);
      this.zzavT = var3;
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAE.asBinder();
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzavT.zzuo()};
      return String.format("DailyTotalRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
