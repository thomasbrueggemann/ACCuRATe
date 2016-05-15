package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.GiftCardWalletObject;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.zzd;

public final class CreateWalletObjectsRequest implements SafeParcelable {
   public static final Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
   private final int mVersionCode;
   LoyaltyWalletObject zzbol;
   OfferWalletObject zzbom;
   GiftCardWalletObject zzbon;

   CreateWalletObjectsRequest() {
      this.mVersionCode = 3;
   }

   CreateWalletObjectsRequest(int var1, LoyaltyWalletObject var2, OfferWalletObject var3, GiftCardWalletObject var4) {
      this.mVersionCode = var1;
      this.zzbol = var2;
      this.zzbom = var3;
      this.zzbon = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
