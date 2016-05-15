package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;
import com.google.android.gms.nearby.sharing.internal.zzj;

public final class StopProvidingContentRequest implements SafeParcelable {
   public static final Creator<StopProvidingContentRequest> CREATOR = new zzj();
   final int versionCode;
   public long zzbdn;
   public zzc zzbdo;

   StopProvidingContentRequest() {
      this.versionCode = 1;
   }

   StopProvidingContentRequest(int var1, long var2, IBinder var4) {
      this.versionCode = var1;
      this.zzbdn = var2;
      this.zzbdo = zzc.zza.zzdH(var4);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbdo.asBinder();
   }
}
