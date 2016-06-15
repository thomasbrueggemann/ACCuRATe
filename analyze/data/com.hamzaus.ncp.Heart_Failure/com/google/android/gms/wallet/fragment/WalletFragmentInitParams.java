package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.class_584;

public final class WalletFragmentInitParams implements SafeParcelable {
   public static final Creator<WalletFragmentInitParams> CREATOR = new class_584();
   private MaskedWalletRequest akj;
   private MaskedWallet akk;
   private int akx;
   // $FF: renamed from: xJ int
   final int field_4343;
   // $FF: renamed from: yN java.lang.String
   private String field_4344;

   private WalletFragmentInitParams() {
      this.field_4343 = 1;
      this.akx = -1;
   }

   WalletFragmentInitParams(int var1, String var2, MaskedWalletRequest var3, int var4, MaskedWallet var5) {
      this.field_4343 = var1;
      this.field_4344 = var2;
      this.akj = var3;
      this.akx = var4;
      this.akk = var5;
   }

   public static WalletFragmentInitParams.Builder newBuilder() {
      WalletFragmentInitParams var0 = new WalletFragmentInitParams();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountName() {
      return this.field_4344;
   }

   public MaskedWallet getMaskedWallet() {
      return this.akk;
   }

   public MaskedWalletRequest getMaskedWalletRequest() {
      return this.akj;
   }

   public int getMaskedWalletRequestCode() {
      return this.akx;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_584.method_3267(this, var1, var2);
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
         if((WalletFragmentInitParams.this.akk == null || WalletFragmentInitParams.this.akj != null) && (WalletFragmentInitParams.this.akk != null || WalletFragmentInitParams.this.akj == null)) {
            var2 = false;
         } else {
            var2 = var1;
         }

         class_347.method_2161(var2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
         if(WalletFragmentInitParams.this.akx < 0) {
            var1 = false;
         }

         class_347.method_2161(var1, "masked wallet request code is required and must be non-negative");
         return WalletFragmentInitParams.this;
      }

      public WalletFragmentInitParams.Builder setAccountName(String var1) {
         WalletFragmentInitParams.this.field_4344 = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWallet(MaskedWallet var1) {
         WalletFragmentInitParams.this.akk = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWalletRequest(MaskedWalletRequest var1) {
         WalletFragmentInitParams.this.akj = var1;
         return this;
      }

      public WalletFragmentInitParams.Builder setMaskedWalletRequestCode(int var1) {
         WalletFragmentInitParams.this.akx = var1;
         return this;
      }
   }
}
