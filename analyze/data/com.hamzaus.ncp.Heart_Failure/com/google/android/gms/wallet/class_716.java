package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_717;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.d
public final class class_716 implements SafeParcelable {
   public static final Creator<d> CREATOR = new class_717();
   LoyaltyWalletObject aiL;
   OfferWalletObject aiM;
   // $FF: renamed from: xJ int
   private final int field_3867;

   class_716() {
      this.field_3867 = 2;
   }

   class_716(int var1, LoyaltyWalletObject var2, OfferWalletObject var3) {
      this.field_3867 = var1;
      this.aiL = var2;
      this.aiM = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3867;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_717.method_4081(this, var1, var2);
   }
}
