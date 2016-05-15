package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveFileRange;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import java.util.ArrayList;

public class zzay implements Creator<OnDownloadProgressResponse> {
   static void zza(OnDownloadProgressResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzasi);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzasj);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzBc);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzask, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdw(var1);
   }

   public OnDownloadProgressResponse zzbB(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var6 = null;
      long var7 = var2;
      int var9 = 0;

      while(var1.dataPosition() < var5) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10, DriveFileRange.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new OnDownloadProgressResponse(var9, var7, var2, var4, var6);
      }
   }

   public OnDownloadProgressResponse[] zzdw(int var1) {
      return new OnDownloadProgressResponse[var1];
   }
}
