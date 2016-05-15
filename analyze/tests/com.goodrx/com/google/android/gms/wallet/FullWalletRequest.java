package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.zzf;

public final class FullWalletRequest implements SafeParcelable {
   public static final Creator<FullWalletRequest> CREATOR = new zzf();
   private final int mVersionCode;
   String zzboo;
   String zzbop;
   Cart zzboz;

   FullWalletRequest() {
      this.mVersionCode = 1;
   }

   FullWalletRequest(int var1, String var2, String var3, Cart var4) {
      this.mVersionCode = var1;
      this.zzboo = var2;
      this.zzbop = var3;
      this.zzboz = var4;
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
