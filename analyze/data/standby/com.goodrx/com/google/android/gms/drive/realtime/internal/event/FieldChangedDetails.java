package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zza;

public class FieldChangedDetails implements SafeParcelable {
   public static final Creator<FieldChangedDetails> CREATOR = new zza();
   final int mVersionCode;
   final int zzauO;

   FieldChangedDetails(int var1, int var2) {
      this.mVersionCode = var1;
      this.zzauO = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
