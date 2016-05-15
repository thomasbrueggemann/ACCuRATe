package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzm;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
   public static final Creator<CreateFileIntentSenderRequest> CREATOR = new zzm();
   final int mVersionCode;
   final int zzaox;
   final String zzapg;
   final DriveId zzapj;
   final MetadataBundle zzaqw;
   final Integer zzaqx;

   CreateFileIntentSenderRequest(int var1, MetadataBundle var2, int var3, String var4, DriveId var5, Integer var6) {
      this.mVersionCode = var1;
      this.zzaqw = var2;
      this.zzaox = var3;
      this.zzapg = var4;
      this.zzapj = var5;
      this.zzaqx = var6;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }
}
