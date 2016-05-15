package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.ParcelableGeofence;

public class zzo implements Creator<ParcelableGeofence> {
   static void zza(ParcelableGeofence var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getRequestId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.getExpirationTime());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (short)var0.zzyT());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.getLatitude());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.getLongitude());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzyU());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzyV());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.getNotificationResponsiveness());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 9, var0.zzyW());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhH(var1);
   }

   public ParcelableGeofence zzeZ(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      int var5 = 0;
      short var6 = 0;
      double var7 = 0.0D;
      double var9 = 0.0D;
      float var11 = 0.0F;
      long var12 = 0L;
      int var14 = 0;
      int var15 = -1;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var4 = zza.zzp(var1, var16);
            break;
         case 2:
            var12 = zza.zzi(var1, var16);
            break;
         case 3:
            var6 = zza.zzf(var1, var16);
            break;
         case 4:
            var7 = zza.zzn(var1, var16);
            break;
         case 5:
            var9 = zza.zzn(var1, var16);
            break;
         case 6:
            var11 = zza.zzl(var1, var16);
            break;
         case 7:
            var5 = zza.zzg(var1, var16);
            break;
         case 8:
            var14 = zza.zzg(var1, var16);
            break;
         case 9:
            var15 = zza.zzg(var1, var16);
            break;
         case 1000:
            var3 = zza.zzg(var1, var16);
            break;
         default:
            zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ParcelableGeofence(var3, var4, var5, var6, var7, var9, var11, var12, var14, var15);
      }
   }

   public ParcelableGeofence[] zzhH(int var1) {
      return new ParcelableGeofence[var1];
   }
}
