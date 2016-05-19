package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzp;

public final class PaymentMethodToken implements SafeParcelable {
   public static final Creator<PaymentMethodToken> CREATOR = new zzp();
   private final int mVersionCode;
   String zzbaW;
   int zzbpC;

   private PaymentMethodToken() {
      this.mVersionCode = 1;
   }

   PaymentMethodToken(int var1, int var2, String var3) {
      this.mVersionCode = var1;
      this.zzbpC = var2;
      this.zzbaW = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
