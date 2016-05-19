package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.zzr;

public class ParcelableIndexReference implements SafeParcelable {
   public static final Creator<ParcelableIndexReference> CREATOR = new zzr();
   final int mIndex;
   final int mVersionCode;
   final String zzauL;
   final boolean zzauM;
   final int zzauN;

   ParcelableIndexReference(int var1, String var2, int var3, boolean var4, int var5) {
      this.mVersionCode = var1;
      this.zzauL = var2;
      this.mIndex = var3;
      this.zzauM = var4;
      this.zzauN = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
