package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.UserDataType;
import java.util.ArrayList;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
   static void zza(PlaceFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (List)var0.zzaPk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaPA);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaPl, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 6, var0.zzaPj, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfe(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhO(var1);
   }

   public PlaceFilter zzfe(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8, UserDataType.CREATOR);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var8);
            break;
         case 1000:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PlaceFilter(var7, var6, var2, var5, var3);
      }
   }

   public PlaceFilter[] zzhO(int var1) {
      return new PlaceFilter[var1];
   }
}
