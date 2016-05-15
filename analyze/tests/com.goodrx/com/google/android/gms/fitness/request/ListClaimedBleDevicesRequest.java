package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzr;
import com.google.android.gms.internal.zzpj;

public class ListClaimedBleDevicesRequest implements SafeParcelable {
   public static final Creator<ListClaimedBleDevicesRequest> CREATOR = new zzr();
   private final int mVersionCode;
   private final zzpj zzaBc;

   ListClaimedBleDevicesRequest(int var1, IBinder var2) {
      this.mVersionCode = var1;
      this.zzaBc = zzpj.zza.zzbT(var2);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaBc.asBinder();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
