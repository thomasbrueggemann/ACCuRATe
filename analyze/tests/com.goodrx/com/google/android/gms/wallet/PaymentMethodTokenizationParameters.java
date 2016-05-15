package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzq;

public final class PaymentMethodTokenizationParameters implements SafeParcelable {
   public static final Creator<PaymentMethodTokenizationParameters> CREATOR = new zzq();
   private final int mVersionCode;
   int zzbpC;
   Bundle zzbpD = new Bundle();

   private PaymentMethodTokenizationParameters() {
      this.mVersionCode = 1;
   }

   PaymentMethodTokenizationParameters(int var1, int var2, Bundle var3) {
      this.mVersionCode = var1;
      this.zzbpC = var2;
      this.zzbpD = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzq.zza(this, var1, var2);
   }
}
