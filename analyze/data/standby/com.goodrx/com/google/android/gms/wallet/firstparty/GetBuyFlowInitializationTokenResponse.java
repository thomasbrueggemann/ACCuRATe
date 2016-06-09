package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.firstparty.zzc;

public final class GetBuyFlowInitializationTokenResponse implements SafeParcelable {
   public static final Creator<GetBuyFlowInitializationTokenResponse> CREATOR = new zzc();
   private final int mVersionCode;
   byte[] zzbpR;

   GetBuyFlowInitializationTokenResponse() {
      this(1, new byte[0]);
   }

   GetBuyFlowInitializationTokenResponse(int var1, byte[] var2) {
      this.mVersionCode = var1;
      this.zzbpR = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
