package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.firstparty.zzb;

@Deprecated
public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
   public static final Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
   private final int mVersionCode;
   byte[] zzbpP;
   byte[] zzbpQ;

   GetBuyFlowInitializationTokenRequest() {
      this(1, (byte[])null, (byte[])null);
   }

   GetBuyFlowInitializationTokenRequest(int var1, byte[] var2, byte[] var3) {
      this.mVersionCode = var1;
      this.zzbpP = var2;
      this.zzbpQ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
