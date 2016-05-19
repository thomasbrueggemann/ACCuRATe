package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzn;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
   public static final Creator<CreateFileRequest> CREATOR = new zzn();
   final int mVersionCode;
   final String zzaoV;
   final String zzaoY;
   final int zzaqA;
   final boolean zzaqd;
   final Contents zzaql;
   final MetadataBundle zzaqw;
   final Integer zzaqx;
   final DriveId zzaqy;
   final int zzaqz;

   CreateFileRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, Integer var5, boolean var6, String var7, int var8, int var9, String var10) {
      if(var4 != null && var9 != 0) {
         boolean var11;
         if(var4.getRequestId() == var9) {
            var11 = true;
         } else {
            var11 = false;
         }

         zzx.zzb(var11, "inconsistent contents reference");
      }

      if((var5 == null || var5.intValue() == 0) && var4 == null && var9 == 0) {
         throw new IllegalArgumentException("Need a valid contents");
      } else {
         this.mVersionCode = var1;
         this.zzaqy = (DriveId)zzx.zzz(var2);
         this.zzaqw = (MetadataBundle)zzx.zzz(var3);
         this.zzaql = var4;
         this.zzaqx = var5;
         this.zzaoV = var7;
         this.zzaqz = var8;
         this.zzaqd = var6;
         this.zzaqA = var9;
         this.zzaoY = var10;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
