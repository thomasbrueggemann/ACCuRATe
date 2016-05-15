package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class RewardedVideoAdRequestParcel implements SafeParcelable {
   public static final zzh CREATOR = new zzh();
   public final int versionCode;
   public final AdRequestParcel zzHt;
   public final String zzrj;

   public RewardedVideoAdRequestParcel(int var1, AdRequestParcel var2, String var3) {
      this.versionCode = var1;
      this.zzHt = var2;
      this.zzrj = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
