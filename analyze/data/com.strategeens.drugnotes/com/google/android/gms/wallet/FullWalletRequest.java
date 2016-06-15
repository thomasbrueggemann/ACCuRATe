package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.class_934;

public final class FullWalletRequest implements SafeParcelable {
   public static final Creator<FullWalletRequest> CREATOR = new class_934();
   // $FF: renamed from: CK int
   private final int field_2926;
   String auL;
   String auM;
   Cart auV;

   FullWalletRequest() {
      this.field_2926 = 1;
   }

   FullWalletRequest(int var1, String var2, String var3, Cart var4) {
      this.field_2926 = var1;
      this.auL = var2;
      this.auM = var3;
      this.auV = var4;
   }

   public static FullWalletRequest.Builder newBuilder() {
      FullWalletRequest var0 = new FullWalletRequest();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public Cart getCart() {
      return this.auV;
   }

   public String getGoogleTransactionId() {
      return this.auL;
   }

   public String getMerchantTransactionId() {
      return this.auM;
   }

   public int getVersionCode() {
      return this.field_2926;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_934.method_5189(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public FullWalletRequest build() {
         return FullWalletRequest.this;
      }

      public FullWalletRequest.Builder setCart(Cart var1) {
         FullWalletRequest.this.auV = var1;
         return this;
      }

      public FullWalletRequest.Builder setGoogleTransactionId(String var1) {
         FullWalletRequest.this.auL = var1;
         return this;
      }

      public FullWalletRequest.Builder setMerchantTransactionId(String var1) {
         FullWalletRequest.this.auM = var1;
         return this;
      }
   }
}
