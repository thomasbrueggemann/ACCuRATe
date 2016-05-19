package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.video.VideoConfiguration;

public class VideoConfigurationCreator implements Creator<VideoConfiguration> {
   static void zza(VideoConfiguration var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.zzyd());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzc(var1, 2, var0.zzye());
      zzb.zza(var1, 3, (String)var0.getStreamUrl(), false);
      zzb.zza(var1, 4, (String)var0.zzyf(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhb(var1);
   }

   public VideoConfiguration zzeG(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = zza.zzau(var1);
      String var5 = null;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var6 = zza.zzg(var1, var8);
            break;
         case 2:
            var3 = zza.zzg(var1, var8);
            break;
         case 3:
            var5 = zza.zzp(var1, var8);
            break;
         case 4:
            var2 = zza.zzp(var1, var8);
            break;
         case 1000:
            var7 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new VideoConfiguration(var7, var6, var3, var5, var2);
      }
   }

   public VideoConfiguration[] zzhb(int var1) {
      return new VideoConfiguration[var1];
   }
}
