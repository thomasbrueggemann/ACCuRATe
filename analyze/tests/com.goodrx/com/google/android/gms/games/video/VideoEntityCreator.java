package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.video.VideoEntity;

public class VideoEntityCreator implements Creator<VideoEntity> {
   static void zza(VideoEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getDuration());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.zzxX(), false);
      zzb.zza(var1, 3, var0.getFileSize());
      zzb.zza(var1, 4, var0.getStartTime());
      zzb.zza(var1, 5, (String)var0.getPackageName(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeH(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhc(var1);
   }

   public VideoEntity zzeH(Parcel var1) {
      long var2 = 0L;
      String var4 = null;
      int var5 = 0;
      int var6 = zza.zzau(var1);
      long var7 = var2;
      String var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var6) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var5 = zza.zzg(var1, var11);
            break;
         case 2:
            var9 = zza.zzp(var1, var11);
            break;
         case 3:
            var7 = zza.zzi(var1, var11);
            break;
         case 4:
            var2 = zza.zzi(var1, var11);
            break;
         case 5:
            var4 = zza.zzp(var1, var11);
            break;
         case 1000:
            var10 = zza.zzg(var1, var11);
            break;
         default:
            zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new VideoEntity(var10, var5, var9, var7, var2, var4);
      }
   }

   public VideoEntity[] zzhc(int var1) {
      return new VideoEntity[var1];
   }
}
