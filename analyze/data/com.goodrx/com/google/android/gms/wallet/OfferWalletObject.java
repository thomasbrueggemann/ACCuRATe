package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzo;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
   public static final Creator<OfferWalletObject> CREATOR = new zzo();
   private final int mVersionCode;
   CommonWalletObject zzboB;
   String zzbpB;
   String zzio;

   OfferWalletObject() {
      this.mVersionCode = 3;
   }

   OfferWalletObject(int var1, String var2, String var3, CommonWalletObject var4) {
      this.mVersionCode = var1;
      this.zzbpB = var3;
      if(var1 < 3) {
         this.zzboB = CommonWalletObject.zzIr().zzgK(var2).zzIs();
      } else {
         this.zzboB = var4;
      }
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
