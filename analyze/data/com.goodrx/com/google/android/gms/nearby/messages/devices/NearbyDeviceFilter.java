package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.devices.zzg;

public class NearbyDeviceFilter implements SafeParcelable {
   public static final Creator<NearbyDeviceFilter> CREATOR = new zzg();
   final int mVersionCode;
   final int zzbci;
   final byte[] zzbcj;
   final boolean zzbck;

   NearbyDeviceFilter(int var1, int var2, byte[] var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzbci = var2;
      this.zzbcj = var3;
      this.zzbck = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
