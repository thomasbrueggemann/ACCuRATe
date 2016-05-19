package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.zzh;

public final class UriData implements SafeParcelable {
   public static final Creator<UriData> CREATOR = new zzh();
   String description;
   private final int mVersionCode;
   String zzbdg;

   UriData() {
      this.mVersionCode = 1;
   }

   UriData(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzbdg = var2;
      this.description = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
