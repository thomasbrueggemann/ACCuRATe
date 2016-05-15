package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zze;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
   public static final Creator<CancelPendingActionsRequest> CREATOR = new zze();
   final int mVersionCode;
   final List<String> zzapG;

   CancelPendingActionsRequest(int var1, List<String> var2) {
      this.mVersionCode = var1;
      this.zzapG = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
