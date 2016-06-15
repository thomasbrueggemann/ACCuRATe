package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_936;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.d
public final class class_935 implements SafeParcelable {
   public static final Creator<d> CREATOR = new class_936();
   // $FF: renamed from: CK int
   private final int field_3950;
   LoyaltyWalletObject auJ;
   OfferWalletObject auK;

   class_935() {
      this.field_3950 = 2;
   }

   class_935(int var1, LoyaltyWalletObject var2, OfferWalletObject var3) {
      this.field_3950 = var1;
      this.auJ = var2;
      this.auK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_3950;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_936.method_5192(this, var1, var2);
   }
}
