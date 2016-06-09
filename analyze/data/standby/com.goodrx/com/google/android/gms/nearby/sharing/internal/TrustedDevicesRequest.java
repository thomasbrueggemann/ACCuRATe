package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;
import com.google.android.gms.nearby.sharing.internal.zzk;

public final class TrustedDevicesRequest implements SafeParcelable {
   public static final Creator<TrustedDevicesRequest> CREATOR = new zzk();
   final int versionCode;
   public zzc zzbdo;
   public String zzbdq;
   public byte[] zzbdr;

   TrustedDevicesRequest(int var1, String var2, byte[] var3, IBinder var4) {
      this.versionCode = var1;
      this.zzbdq = (String)zzx.zzz(var2);
      this.zzbdr = (byte[])zzx.zzz(var3);
      this.zzbdo = zzc.zza.zzdH(var4);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbdo.asBinder();
   }
}
