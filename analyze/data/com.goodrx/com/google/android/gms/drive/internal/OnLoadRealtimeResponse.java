package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbg;

public class OnLoadRealtimeResponse implements SafeParcelable {
   public static final Creator<OnLoadRealtimeResponse> CREATOR = new zzbg();
   final int mVersionCode;
   final boolean zzqA;

   OnLoadRealtimeResponse(int var1, boolean var2) {
      this.mVersionCode = var1;
      this.zzqA = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbg.zza(this, var1, var2);
   }
}
