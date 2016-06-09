package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.zze;

public class ReferenceShiftedDetails implements SafeParcelable {
   public static final Creator<ReferenceShiftedDetails> CREATOR = new zze();
   final int mVersionCode;
   final String zzavj;
   final String zzavk;
   final int zzavl;
   final int zzavm;

   ReferenceShiftedDetails(int var1, String var2, String var3, int var4, int var5) {
      this.mVersionCode = var1;
      this.zzavj = var2;
      this.zzavk = var3;
      this.zzavl = var4;
      this.zzavm = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
