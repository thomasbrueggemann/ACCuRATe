package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzl;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
   public static final zzl CREATOR = new zzl();
   final int mVersionCode;
   final DataHolder zzahi;
   final boolean zzapQ;
   final int zzapR;

   QueryResultEventParcelable(int var1, DataHolder var2, boolean var3, int var4) {
      this.mVersionCode = var1;
      this.zzahi = var2;
      this.zzapQ = var3;
      this.zzapR = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void zzJ(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
