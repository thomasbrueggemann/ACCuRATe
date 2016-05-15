package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.request.zzi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class CapabilityParcel implements SafeParcelable {
   public static final Creator<CapabilityParcel> CREATOR = new zzi();
   public final int versionCode;
   public final boolean zzIn;
   public final boolean zzIo;
   public final boolean zzIp;

   CapabilityParcel(int var1, boolean var2, boolean var3, boolean var4) {
      this.versionCode = var1;
      this.zzIn = var2;
      this.zzIo = var3;
      this.zzIp = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
