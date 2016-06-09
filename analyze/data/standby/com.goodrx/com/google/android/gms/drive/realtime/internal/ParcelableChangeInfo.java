package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.zzp;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

public class ParcelableChangeInfo implements SafeParcelable {
   public static final Creator<ParcelableChangeInfo> CREATOR = new zzp();
   final int mVersionCode;
   final long zzaez;
   final List<ParcelableEvent> zzpH;

   ParcelableChangeInfo(int var1, long var2, List<ParcelableEvent> var4) {
      this.mVersionCode = var1;
      this.zzaez = var2;
      this.zzpH = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
