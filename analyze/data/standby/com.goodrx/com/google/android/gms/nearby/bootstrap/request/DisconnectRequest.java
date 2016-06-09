package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.nearby.bootstrap.request.zzd;

public class DisconnectRequest implements SafeParcelable {
   public static final zzd CREATOR = new zzd();
   final int versionCode;
   private final Device zzbaS;
   private final zzqg zzbaV;

   DisconnectRequest(int var1, Device var2, IBinder var3) {
      this.versionCode = var1;
      this.zzbaS = (Device)zzx.zzz(var2);
      zzx.zzz(var3);
      this.zzbaV = zzqg.zza.zzds(var3);
   }

   public int describeContents() {
      zzd var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd var10000 = CREATOR;
      zzd.zza(this, var1, var2);
   }

   public Device zzEd() {
      return this.zzbaS;
   }
}
