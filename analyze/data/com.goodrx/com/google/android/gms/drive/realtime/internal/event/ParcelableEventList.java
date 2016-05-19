package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.zzd;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
   public static final Creator<ParcelableEventList> CREATOR = new zzd();
   final int mVersionCode;
   final DataHolder zzavf;
   final boolean zzavg;
   final List<String> zzavh;
   final ParcelableChangeInfo zzavi;
   final List<ParcelableEvent> zzpH;

   ParcelableEventList(int var1, List<ParcelableEvent> var2, DataHolder var3, boolean var4, List<String> var5, ParcelableChangeInfo var6) {
      this.mVersionCode = var1;
      this.zzpH = var2;
      this.zzavf = var3;
      this.zzavg = var4;
      this.zzavh = var5;
      this.zzavi = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
