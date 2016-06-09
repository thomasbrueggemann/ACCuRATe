package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzb;

public class ObjectChangedDetails implements SafeParcelable {
   public static final Creator<ObjectChangedDetails> CREATOR = new zzb();
   final int mVersionCode;
   final int zzauP;
   final int zzauQ;

   ObjectChangedDetails(int var1, int var2, int var3) {
      this.mVersionCode = var1;
      this.zzauP = var2;
      this.zzauQ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
