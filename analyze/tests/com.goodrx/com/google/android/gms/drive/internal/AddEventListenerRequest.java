package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;
import com.google.android.gms.drive.internal.zza;

public class AddEventListenerRequest implements SafeParcelable {
   public static final Creator<AddEventListenerRequest> CREATOR = new zza();
   final int mVersionCode;
   final int zzanf;
   final DriveId zzaoz;
   final TransferStateOptions zzapY;
   final TransferProgressOptions zzapZ;
   final ChangesAvailableOptions zzapy;

   AddEventListenerRequest(int var1, DriveId var2, int var3, ChangesAvailableOptions var4, TransferStateOptions var5, TransferProgressOptions var6) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzanf = var3;
      this.zzapy = var4;
      this.zzapY = var5;
      this.zzapZ = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
