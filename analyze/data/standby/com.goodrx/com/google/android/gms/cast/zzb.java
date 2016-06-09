package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;

public class zzb implements Creator<CastDevice> {
   static void zza(CastDevice var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzny(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzZU, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getFriendlyName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getModelName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.getDeviceVersion(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.getServicePort());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.getIcons(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 9, var0.getCapabilities());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.getStatus());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (String)var0.zznz(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaa(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaX(var1);
   }

   public CastDevice[] zzaX(int var1) {
      return new CastDevice[var1];
   }

   public CastDevice zzaa(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = -1;
      ArrayList var6 = null;
      int var7 = 0;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14, WebImage.CREATOR);
            break;
         case 9:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 10:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CastDevice(var13, var12, var11, var10, var9, var8, var7, var6, var2, var5, var3);
      }
   }
}
