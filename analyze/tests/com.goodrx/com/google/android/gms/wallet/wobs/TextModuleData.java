package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.zzf;

public final class TextModuleData implements SafeParcelable {
   public static final Creator<TextModuleData> CREATOR = new zzf();
   String body;
   private final int mVersionCode;
   String zzbqO;

   TextModuleData() {
      this.mVersionCode = 1;
   }

   TextModuleData(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzbqO = var2;
      this.body = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }
}
