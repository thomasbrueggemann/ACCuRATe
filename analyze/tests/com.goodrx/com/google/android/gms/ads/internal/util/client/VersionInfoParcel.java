package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.util.client.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class VersionInfoParcel implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   public String afmaVersion;
   public final int versionCode;
   public int zzMZ;
   public int zzNa;
   public boolean zzNb;

   VersionInfoParcel(int var1, String var2, int var3, int var4, boolean var5) {
      this.versionCode = var1;
      this.afmaVersion = var2;
      this.zzMZ = var3;
      this.zzNa = var4;
      this.zzNb = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
