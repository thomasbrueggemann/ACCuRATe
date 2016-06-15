package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.class_688;

public final class WalletFragmentInitParams implements SafeParcelable {
   public static final Creator<WalletFragmentInitParams> CREATOR = new class_688();
   // $FF: renamed from: CK int
   final int field_4496;
   // $FF: renamed from: DZ java.lang.String
   private String field_4497;
   private MaskedWalletRequest awg;
   private MaskedWallet awh;
   private int awu;

   private WalletFragmentInitParams() {
      this.field_4496 = 1;
      this.awu = -1;
   }

   WalletFragmentInitParams(int var1, String var2, MaskedWalletRequest var3, int var4, MaskedWallet var5) {
      this.field_4496 = var1;
      this.field_4497 = var2;
      this.awg = var3;
      this.awu = var4;
      this.awh = var5;
   }

   public static WalletFragmentInitParams.Builder newBuilder() {
      WalletFragmentInitParams var0 = new WalletFragmentInitParams();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountName() {
      return this.field_4497;
   }

   public MaskedWallet getMaskedWallet() {
      return this.awh;
   }

   public MaskedWalletRequest getMaskedWalletRequest() {
      return this.awg;
   }

   public int getMaskedWalletRequestCode() {
      return this.awu;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_688.method_3880(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public WalletFragmentInitParams build() {
         boolean var1 = true;
         boolean var2;
         if((WalletFragmentInitParams.this.awh == null || WalletFragmentInitParams.this.awg != null) && (WalletFragmentInitParams.this.awh != null || WalletFragmentInitParams.this.awg == null)) {
            var2 = false;
         } else {
            var2 = var1;
         }

         class_335.method_2302(var2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
         if(WalletFragmentInitParams.this.awu < 0) {
            var1 = false;
         }

         class_335.method_2302(var1, "masked wallet request code is required and must be non-negative");
         return WalletFragmentInitParams.this;
      }

      public WalletFragmentInitParams.Builder setAccountName(String var1) {
         WalletFragmentInitParams.this.field_4497 = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWallet(MaskedWallet var1) {
         WalletFragmentInitParams.this.awh = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWalletRequest(MaskedWalletRequest var1) {
         WalletFragmentInitParams.this.awg = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWalletRequestCode(int var1) {
         WalletFragmentInitParams.this.awu = var1;
         return this;
      }
   }
}
