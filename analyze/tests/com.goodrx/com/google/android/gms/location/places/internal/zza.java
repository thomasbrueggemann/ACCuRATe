package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.ArrayList;
import java.util.List;

public class zza implements Creator<AutocompletePredictionEntity> {
   static void zza(AutocompletePredictionEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.zzaQd, false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zza(var1, 2, (String)var0.zzaPH, false);
      zzb.zza(var1, 3, (List)var0.zzaPd, false);
      zzb.zzc(var1, 4, var0.zzaQe, false);
      zzb.zzc(var1, 5, var0.zzaQf);
      zzb.zza(var1, 6, (String)var0.zzaQg, false);
      zzb.zzc(var1, 7, var0.zzaQh, false);
      zzb.zza(var1, 8, (String)var0.zzaQi, false);
      zzb.zzc(var1, 9, var0.zzaQj, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhW(var1);
   }

   public AutocompletePredictionEntity zzfk(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      ArrayList var8 = null;
      String var9 = null;
      ArrayList var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var13);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13, AutocompletePredictionEntity.SubstringEntity.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13, AutocompletePredictionEntity.SubstringEntity.CREATOR);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13, AutocompletePredictionEntity.SubstringEntity.CREATOR);
            break;
         case 1000:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AutocompletePredictionEntity(var12, var11, var10, var2, var9, var8, var7, var6, var5, var3);
      }
   }

   public AutocompletePredictionEntity[] zzhW(int var1) {
      return new AutocompletePredictionEntity[var1];
   }
}
