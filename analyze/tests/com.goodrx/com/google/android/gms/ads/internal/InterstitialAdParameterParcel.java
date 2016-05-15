package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class InterstitialAdParameterParcel implements SafeParcelable {
   public static final zzl CREATOR = new zzl();
   public final int versionCode;
   public final boolean zzql;
   public final boolean zzqm;
   public final String zzqn;
   public final boolean zzqo;
   public final float zzqp;

   InterstitialAdParameterParcel(int var1, boolean var2, boolean var3, String var4, boolean var5, float var6) {
      this.versionCode = var1;
      this.zzql = var2;
      this.zzqm = var3;
      this.zzqn = var4;
      this.zzqo = var5;
      this.zzqp = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
