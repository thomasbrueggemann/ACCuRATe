package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbn;

public class ParcelableTransferPreferences implements SafeParcelable {
   public static final Creator<ParcelableTransferPreferences> CREATOR = new zzbn();
   final int mVersionCode;
   final int zzarG;
   final int zzarH;
   final boolean zzasA;

   ParcelableTransferPreferences(int var1, int var2, int var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzarG = var2;
      this.zzarH = var3;
      this.zzasA = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbn.zza(this, var1, var2);
   }
}
