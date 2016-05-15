package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzh;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
   public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
   final int mVersionCode;
   final String zzaoV;
   final boolean zzaoW;
   final boolean zzapa;
   final DriveId zzaqj;
   final MetadataBundle zzaqk;
   final Contents zzaql;
   final int zzaqm;
   final int zzaqn;
   final boolean zzaqo;

   CloseContentsAndUpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, boolean var5, String var6, int var7, int var8, boolean var9, boolean var10) {
      this.mVersionCode = var1;
      this.zzaqj = var2;
      this.zzaqk = var3;
      this.zzaql = var4;
      this.zzaoW = var5;
      this.zzaoV = var6;
      this.zzaqm = var7;
      this.zzaqn = var8;
      this.zzaqo = var9;
      this.zzapa = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
