package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class NativeAdOptionsParcel implements SafeParcelable {
   public static final zzj CREATOR = new zzj();
   public final int versionCode;
   public final boolean zzyA;
   public final int zzyB;
   public final boolean zzyC;

   public NativeAdOptionsParcel(int var1, boolean var2, int var3, boolean var4) {
      this.versionCode = var1;
      this.zzyA = var2;
      this.zzyB = var3;
      this.zzyC = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
