package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzbm;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();
   final int mVersionCode;
   final String zzapg;
   final String[] zzaph;
   final DriveId zzapj;
   final FilterHolder zzasz;

   OpenFileIntentSenderRequest(int var1, String var2, String[] var3, DriveId var4, FilterHolder var5) {
      this.mVersionCode = var1;
      this.zzapg = var2;
      this.zzaph = var3;
      this.zzapj = var4;
      this.zzasz = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbm.zza(this, var1, var2);
   }
}
