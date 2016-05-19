package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.NearbyAlertFilter;
import com.google.android.gms.location.places.UserDataType;
import java.util.ArrayList;
import java.util.List;

public class zzd implements Creator<NearbyAlertFilter> {
   static void zza(NearbyAlertFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 1, var0.zzaPj, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (List)var0.zzaPk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaPl, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzaPm, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzaPn);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfc(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhM(var1);
   }

   public NearbyAlertFilter zzfc(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      ArrayList var6 = null;
      ArrayList var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var9);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var9);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9, UserDataType.CREATOR);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 1000:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new NearbyAlertFilter(var8, var7, var6, var5, var3, var2);
      }
   }

   public NearbyAlertFilter[] zzhM(int var1) {
      return new NearbyAlertFilter[var1];
   }
}
