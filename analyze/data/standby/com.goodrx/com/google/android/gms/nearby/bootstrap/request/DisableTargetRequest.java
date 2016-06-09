package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.request.zzc;

public class DisableTargetRequest implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   final int versionCode;
   private final zzqg zzbaV;

   DisableTargetRequest(int var1, IBinder var2) {
      this.versionCode = var1;
      zzx.zzz(var2);
      this.zzbaV = zzqg.zza.zzds(var2);
   }

   public int describeContents() {
      zzc var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV == null?null:this.zzbaV.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc var10000 = CREATOR;
      zzc.zza(this, var1, var2);
   }
}
