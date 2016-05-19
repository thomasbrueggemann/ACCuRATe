package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.firstparty.zze;

public final class GetInstrumentsResponse implements SafeParcelable {
   public static final Creator<GetInstrumentsResponse> CREATOR = new zze();
   private final int mVersionCode;
   String[] zzbpT;
   byte[][] zzbpU;

   GetInstrumentsResponse() {
      this(1, new String[0], new byte[0][]);
   }

   GetInstrumentsResponse(int var1, String[] var2, byte[][] var3) {
      this.mVersionCode = var1;
      this.zzbpT = var2;
      this.zzbpU = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
