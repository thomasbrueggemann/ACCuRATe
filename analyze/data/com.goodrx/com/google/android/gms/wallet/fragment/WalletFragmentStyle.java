package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.zzc;

public final class WalletFragmentStyle implements SafeParcelable {
   public static final Creator<WalletFragmentStyle> CREATOR = new zzc();
   final int mVersionCode;
   Bundle zzbqu;
   int zzbqv;

   public WalletFragmentStyle() {
      this.mVersionCode = 1;
      this.zzbqu = new Bundle();
      this.zzbqu.putInt("buyButtonAppearanceDefault", 4);
      this.zzbqu.putInt("maskedWalletDetailsLogoImageTypeDefault", 3);
   }

   WalletFragmentStyle(int var1, Bundle var2, int var3) {
      this.mVersionCode = var1;
      this.zzbqu = var2;
      this.zzbqv = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
