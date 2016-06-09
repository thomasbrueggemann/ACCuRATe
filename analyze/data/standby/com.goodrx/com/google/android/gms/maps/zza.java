package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Creator<GoogleMapOptions> {
   static void zza(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (byte)var0.zzzK());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (byte)var0.zzzL());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getMapType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.getCamera(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (byte)var0.zzzM());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (byte)var0.zzzN());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (byte)var0.zzzO());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (byte)var0.zzzP());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (byte)var0.zzzQ());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (byte)var0.zzzR());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (byte)var0.zzzS());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (byte)var0.zzzT());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (byte)var0.zzzU());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzft(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzih(var1);
   }

   public GoogleMapOptions zzft(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      byte var4 = -1;
      byte var5 = -1;
      int var6 = 0;
      CameraPosition var7 = null;
      byte var8 = -1;
      byte var9 = -1;
      byte var10 = -1;
      byte var11 = -1;
      byte var12 = -1;
      byte var13 = -1;
      byte var14 = -1;
      byte var15 = -1;
      byte var16 = -1;

      while(var1.dataPosition() < var2) {
         int var17 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var17)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 5:
            var7 = (CameraPosition)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, CameraPosition.CREATOR);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 13:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var17);
            break;
         case 14:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
            break;
         case 15:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GoogleMapOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   public GoogleMapOptions[] zzih(int var1) {
      return new GoogleMapOptions[var1];
   }
}
