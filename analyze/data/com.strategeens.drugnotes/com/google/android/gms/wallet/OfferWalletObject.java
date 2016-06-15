package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_946;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
   public static final Creator<OfferWalletObject> CREATOR = new class_946();
   // $FF: renamed from: CK int
   private final int field_4448;
   String avN;
   CommonWalletObject avO;
   // $FF: renamed from: fl java.lang.String
   String field_4449;

   OfferWalletObject() {
      this.field_4448 = 3;
   }

   OfferWalletObject(int var1, String var2, String var3, CommonWalletObject var4) {
      this.field_4448 = var1;
      this.avN = var3;
      if(var1 < 3) {
         this.avO = CommonWalletObject.method_5770().method_3222(var2).method_3223();
      } else {
         this.avO = var4;
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.avO.getId();
   }

   public String getRedemptionCode() {
      return this.avN;
   }

   public int getVersionCode() {
      return this.field_4448;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_946.method_5224(this, var1, var2);
   }
}
