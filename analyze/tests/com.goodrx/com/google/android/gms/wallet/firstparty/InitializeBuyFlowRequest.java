package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.firstparty.zzf;

public class InitializeBuyFlowRequest implements SafeParcelable {
   public static final Creator<InitializeBuyFlowRequest> CREATOR = new zzf();
   private final int mVersionCode;
   byte[][] zzbpV;

   InitializeBuyFlowRequest(int var1, byte[][] var2) {
      this.mVersionCode = var1;
      this.zzbpV = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }
}
