package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.zza;

public class BeginCompoundOperationRequest implements SafeParcelable {
   public static final Creator<BeginCompoundOperationRequest> CREATOR = new zza();
   final String mName;
   final int mVersionCode;
   final boolean zzauG;
   final boolean zzauH;

   BeginCompoundOperationRequest(int var1, boolean var2, String var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzauG = var2;
      this.mName = var3;
      this.zzauH = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
