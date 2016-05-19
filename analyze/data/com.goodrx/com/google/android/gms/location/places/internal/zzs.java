package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.PlacesParams;

public class zzs implements Creator<PlacesParams> {
   static void zza(PlacesParams var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.zzaQX, false);
      zzb.zzc(var1, 1000, var0.versionCode);
      zzb.zza(var1, 2, (String)var0.zzaQY, false);
      zzb.zza(var1, 3, (String)var0.zzaQZ, false);
      zzb.zza(var1, 4, (String)var0.zzaPU, false);
      zzb.zzc(var1, 6, var0.zzaRa);
      zzb.zzc(var1, 7, var0.zzaRb);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfo(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzib(var1);
   }

   public PlacesParams zzfo(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 1000:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PlacesParams(var9, var8, var7, var6, var3, var5, var2);
      }
   }

   public PlacesParams[] zzib(int var1) {
      return new PlacesParams[var1];
   }
}
