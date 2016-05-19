package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.video.VideoCapabilities;

public class VideoCapabilitiesCreator implements Creator<VideoCapabilities> {
   static void zza(VideoCapabilities var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, var0.zzxZ());
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, var0.zzxY());
      zzb.zza(var1, 3, var0.zzya());
      zzb.zza(var1, 4, (boolean[])var0.zzyb(), false);
      zzb.zza(var1, 5, (boolean[])var0.zzyc(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgY(var1);
   }

   public VideoCapabilities zzeF(Parcel var1) {
      boolean[] var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      boolean[] var5 = null;
      boolean var6 = false;
      boolean var7 = false;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = zza.zzat(var1);
         switch(zza.zzca(var9)) {
         case 1:
            var7 = zza.zzc(var1, var9);
            break;
         case 2:
            var6 = zza.zzc(var1, var9);
            break;
         case 3:
            var3 = zza.zzc(var1, var9);
            break;
         case 4:
            var5 = zza.zzu(var1, var9);
            break;
         case 5:
            var2 = zza.zzu(var1, var9);
            break;
         case 1000:
            var8 = zza.zzg(var1, var9);
            break;
         default:
            zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new VideoCapabilities(var8, var7, var6, var3, var5, var2);
      }
   }

   public VideoCapabilities[] zzgY(int var1) {
      return new VideoCapabilities[var1];
   }
}
