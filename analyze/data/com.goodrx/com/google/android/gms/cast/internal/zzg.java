package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.internal.DeviceStatus;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DeviceStatus> {
   static void zza(DeviceStatus var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.getVersionCode());
      zzb.zza(var1, 2, var0.zzok());
      zzb.zza(var1, 3, var0.zzot());
      zzb.zzc(var1, 4, var0.zzol());
      zzb.zza(var1, 5, (Parcelable)var0.getApplicationMetadata(), var2, false);
      zzb.zzc(var1, 6, var0.zzom());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzae(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbo(var1);
   }

   public DeviceStatus zzae(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      double var4 = 0.0D;
      ApplicationMetadata var6 = null;
      int var7 = 0;
      boolean var8 = false;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var10);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var6 = (ApplicationMetadata)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, ApplicationMetadata.CREATOR);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DeviceStatus(var9, var4, var8, var7, var6, var2);
      }
   }

   public DeviceStatus[] zzbo(int var1) {
      return new DeviceStatus[var1];
   }
}
