package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.firstparty.zzd;

public final class GetInstrumentsRequest implements SafeParcelable {
   public static final Creator<GetInstrumentsRequest> CREATOR = new zzd();
   private final int mVersionCode;
   int[] zzbpS;

   GetInstrumentsRequest() {
      this(1, (int[])null);
   }

   GetInstrumentsRequest(int var1, int[] var2) {
      this.mVersionCode = var1;
      this.zzbpS = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
