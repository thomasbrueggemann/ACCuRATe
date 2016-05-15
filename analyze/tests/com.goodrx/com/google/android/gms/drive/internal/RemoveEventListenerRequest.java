package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.internal.zzbp;

public class RemoveEventListenerRequest implements SafeParcelable {
   public static final Creator<RemoveEventListenerRequest> CREATOR = new zzbp();
   final int mVersionCode;
   final int zzanf;
   final DriveId zzaoz;
   final TransferProgressOptions zzapZ;

   RemoveEventListenerRequest(int var1, DriveId var2, int var3, TransferProgressOptions var4) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzanf = var3;
      this.zzapZ = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbp.zza(this, var1, var2);
   }
}
