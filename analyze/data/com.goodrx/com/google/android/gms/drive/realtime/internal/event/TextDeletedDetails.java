package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zzf;

public class TextDeletedDetails implements SafeParcelable {
   public static final Creator<TextDeletedDetails> CREATOR = new zzf();
   final int mIndex;
   final int mVersionCode;
   final int zzavn;

   TextDeletedDetails(int var1, int var2, int var3) {
      this.mVersionCode = var1;
      this.mIndex = var2;
      this.zzavn = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }
}
