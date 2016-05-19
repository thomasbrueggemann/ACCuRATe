package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zzb;

public class Contents implements SafeParcelable {
   public static final Creator<Contents> CREATOR = new zzb();
   final int mVersionCode;
   final ParcelFileDescriptor zzajL;
   final boolean zzaoA;
   final int zzaox;
   final int zzaoy;
   final DriveId zzaoz;
   final String zzsU;

   Contents(int var1, ParcelFileDescriptor var2, int var3, int var4, DriveId var5, boolean var6, String var7) {
      this.mVersionCode = var1;
      this.zzajL = var2;
      this.zzaox = var3;
      this.zzaoy = var4;
      this.zzaoz = var5;
      this.zzaoA = var6;
      this.zzsU = var7;
   }

   public int describeContents() {
      return 0;
   }

   public int getRequestId() {
      return this.zzaox;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
