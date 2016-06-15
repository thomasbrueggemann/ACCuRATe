package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.class_715;

public final class FullWalletRequest implements SafeParcelable {
   public static final Creator<FullWalletRequest> CREATOR = new class_715();
   String aiN;
   String aiO;
   Cart aiX;
   // $FF: renamed from: xJ int
   private final int field_3061;

   FullWalletRequest() {
      this.field_3061 = 1;
   }

   FullWalletRequest(int var1, String var2, String var3, Cart var4) {
      this.field_3061 = var1;
      this.aiN = var2;
      this.aiO = var3;
      this.aiX = var4;
   }

   public static FullWalletRequest.Builder newBuilder() {
      FullWalletRequest var0 = new FullWalletRequest();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public Cart getCart() {
      return this.aiX;
   }

   public String getGoogleTransactionId() {
      return this.aiN;
   }

   public String getMerchantTransactionId() {
      return this.aiO;
   }

   public int getVersionCode() {
      return this.field_3061;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_715.method_4078(this, var1, var2);
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
         FullWalletRequest.this.aiX = var1;
         return this;
      }

      public FullWalletRequest.Builder setGoogleTransactionId(String var1) {
         FullWalletRequest.this.aiN = var1;
         return this;
      }

      public FullWalletRequest.Builder setMerchantTransactionId(String var1) {
         FullWalletRequest.this.aiO = var1;
         return this;
      }
   }
}
