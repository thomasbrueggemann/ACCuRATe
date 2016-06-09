package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzi;

public final class IsReadyToPayRequest implements SafeParcelable {
   public static final Creator<IsReadyToPayRequest> CREATOR = new zzi();
   final int mVersionCode;

   IsReadyToPayRequest() {
      this.mVersionCode = 1;
   }

   IsReadyToPayRequest(int var1) {
      this.mVersionCode = var1;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
