package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzj;
import com.google.android.gms.internal.zzoj;

public class DataTypeReadRequest implements SafeParcelable {
   public static final Creator<DataTypeReadRequest> CREATOR = new zzj();
   private final String mName;
   private final int mVersionCode;
   private final zzoj zzaBa;

   DataTypeReadRequest(int var1, String var2, IBinder var3) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzaBa = zzoj.zza.zzbE(var3);
   }

   private boolean zzb(DataTypeReadRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.mName, var1.mName);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataTypeReadRequest && this.zzb((DataTypeReadRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaBa.asBinder();
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
