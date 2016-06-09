package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;
import com.google.android.gms.wallet.fragment.zzb;

public final class WalletFragmentOptions implements SafeParcelable {
   public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
   private int mTheme;
   final int mVersionCode;
   private int zzaoy;
   private int zzbpM;
   private WalletFragmentStyle zzbqs;

   private WalletFragmentOptions() {
      this.mVersionCode = 1;
      this.zzbpM = 3;
      this.zzbqs = new WalletFragmentStyle();
   }

   WalletFragmentOptions(int var1, int var2, int var3, WalletFragmentStyle var4, int var5) {
      this.mVersionCode = var1;
      this.zzbpM = var2;
      this.mTheme = var3;
      this.zzbqs = var4;
      this.zzaoy = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getEnvironment() {
      return this.zzbpM;
   }

   public WalletFragmentStyle getFragmentStyle() {
      return this.zzbqs;
   }

   public int getMode() {
      return this.zzaoy;
   }

   public int getTheme() {
      return this.mTheme;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
