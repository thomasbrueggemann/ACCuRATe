package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzi;

public class ValuesAddedDetails implements SafeParcelable {
   public static final Creator<ValuesAddedDetails> CREATOR = new zzi();
   final int mIndex;
   final int mVersionCode;
   final int zzauP;
   final int zzauQ;
   final String zzavo;
   final int zzavp;

   ValuesAddedDetails(int var1, int var2, int var3, int var4, String var5, int var6) {
      this.mVersionCode = var1;
      this.mIndex = var2;
      this.zzauP = var3;
      this.zzauQ = var4;
      this.zzavo = var5;
      this.zzavp = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
