package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzh;

public class ValueChangedDetails implements SafeParcelable {
   public static final Creator<ValueChangedDetails> CREATOR = new zzh();
   final int mVersionCode;
   final int zzauO;

   ValueChangedDetails(int var1, int var2) {
      this.mVersionCode = var1;
      this.zzauO = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
