package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.internal.zzhb;

@zzhb
public class ThinAdSizeParcel extends AdSizeParcel {
   public void writeToParcel(Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, this.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)this.zzuh, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, this.height);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, this.width);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }
}
