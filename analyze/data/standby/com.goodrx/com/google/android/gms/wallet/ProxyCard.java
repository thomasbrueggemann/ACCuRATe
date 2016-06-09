package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzr;

public final class ProxyCard implements SafeParcelable {
   public static final Creator<ProxyCard> CREATOR = new zzr();
   private final int mVersionCode;
   String zzbpF;
   String zzbpG;
   int zzbpH;
   int zzbpI;

   ProxyCard(int var1, String var2, String var3, int var4, int var5) {
      this.mVersionCode = var1;
      this.zzbpF = var2;
      this.zzbpG = var3;
      this.zzbpH = var4;
      this.zzbpI = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
