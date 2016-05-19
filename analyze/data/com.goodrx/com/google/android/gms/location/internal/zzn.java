package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;

public class zzn implements Creator<LocationRequestUpdateData> {
   static void zza(LocationRequestUpdateData var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzaOU);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaOV, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzyQ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.mPendingIntent, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzyR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (IBinder)var0.zzyS(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhE(var1);
   }

   public LocationRequestUpdateData zzeY(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      int var5 = 1;
      IBinder var6 = null;
      PendingIntent var7 = null;
      IBinder var8 = null;
      LocationRequestInternal var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = zza.zzat(var1);
         switch(zza.zzca(var10)) {
         case 1:
            var5 = zza.zzg(var1, var10);
            break;
         case 2:
            var9 = (LocationRequestInternal)zza.zza(var1, var10, LocationRequestInternal.CREATOR);
            break;
         case 3:
            var8 = zza.zzq(var1, var10);
            break;
         case 4:
            var7 = (PendingIntent)zza.zza(var1, var10, PendingIntent.CREATOR);
            break;
         case 5:
            var6 = zza.zzq(var1, var10);
            break;
         case 6:
            var2 = zza.zzq(var1, var10);
            break;
         case 1000:
            var4 = zza.zzg(var1, var10);
            break;
         default:
            zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new LocationRequestUpdateData(var4, var5, var9, var8, var7, var6, var2);
      }
   }

   public LocationRequestUpdateData[] zzhE(int var1) {
      return new LocationRequestUpdateData[var1];
   }
}
