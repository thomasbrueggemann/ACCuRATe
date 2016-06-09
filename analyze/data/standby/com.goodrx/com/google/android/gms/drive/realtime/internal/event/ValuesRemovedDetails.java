package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzj;

public class ValuesRemovedDetails implements SafeParcelable {
   public static final Creator<ValuesRemovedDetails> CREATOR = new zzj();
   final int mIndex;
   final int mVersionCode;
   final int zzauP;
   final int zzauQ;
   final String zzavq;
   final int zzavr;

   ValuesRemovedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.mVersionCode = var1;
      this.mIndex = var2;
      this.zzauP = var3;
      this.zzauQ = var4;
      this.zzavq = var5;
      this.zzavr = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
