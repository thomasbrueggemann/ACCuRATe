package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzbk;

public class OpenContentsRequest implements SafeParcelable {
   public static final Creator<OpenContentsRequest> CREATOR = new zzbk();
   final int mVersionCode;
   final int zzaoy;
   final DriveId zzaqj;
   final int zzasx;

   OpenContentsRequest(int var1, DriveId var2, int var3, int var4) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
      this.zzaoy = var3;
      this.zzasx = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbk.zza(this, var1, var2);
   }
}
