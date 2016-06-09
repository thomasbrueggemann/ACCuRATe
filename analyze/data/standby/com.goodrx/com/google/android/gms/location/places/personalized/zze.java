package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.PlaceUserData;
import java.util.ArrayList;

public class zze implements Creator<PlaceUserData> {
   static void zza(PlaceUserData var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.zzzD(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getPlaceId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzzE(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfs(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzif(var1);
   }

   public PlaceUserData zzfs(Parcel var1) {
      ArrayList var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var6 = zza.zzp(var1, var7);
            break;
         case 2:
            var5 = zza.zzp(var1, var7);
            break;
         case 6:
            var2 = zza.zzc(var1, var7, PlaceAlias.CREATOR);
            break;
         case 1000:
            var4 = zza.zzg(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PlaceUserData(var4, var6, var5, var2);
      }
   }

   public PlaceUserData[] zzif(int var1) {
      return new PlaceUserData[var1];
   }
}
