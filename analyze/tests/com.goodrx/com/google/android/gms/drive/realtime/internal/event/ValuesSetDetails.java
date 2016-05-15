package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzk;

public class ValuesSetDetails implements SafeParcelable {
   public static final Creator<ValuesSetDetails> CREATOR = new zzk();
   final int mIndex;
   final int mVersionCode;
   final int zzauP;
   final int zzauQ;

   ValuesSetDetails(int var1, int var2, int var3, int var4) {
      this.mVersionCode = var1;
      this.mIndex = var2;
      this.zzauP = var3;
      this.zzauQ = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
