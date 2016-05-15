package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.zza;

public final class WalletFragmentInitParams implements SafeParcelable {
   public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
   final int mVersionCode;
   private String zzVa;
   private MaskedWalletRequest zzbqc;
   private MaskedWallet zzbqd;
   private int zzbqq;

   private WalletFragmentInitParams() {
      this.mVersionCode = 1;
      this.zzbqq = -1;
   }

   WalletFragmentInitParams(int var1, String var2, MaskedWalletRequest var3, int var4, MaskedWallet var5) {
      this.mVersionCode = var1;
      this.zzVa = var2;
      this.zzbqc = var3;
      this.zzbqq = var4;
      this.zzbqd = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountName() {
      return this.zzVa;
   }

   public MaskedWallet getMaskedWallet() {
      return this.zzbqd;
   }

   public MaskedWalletRequest getMaskedWalletRequest() {
      return this.zzbqc;
   }

   public int getMaskedWalletRequestCode() {
      return this.zzbqq;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
