package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zze implements Creator<PersonEntity.CoverPhotoEntity> {
   static void zza(PersonEntity.CoverPhotoEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzoH);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzF, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzoG);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgI(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjP(var1);
   }

   public PersonEntity.CoverPhotoEntity zzgI(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var4 = new HashSet();
      String var5 = null;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            var4.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            var4.add(Integer.valueOf(4));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PersonEntity.CoverPhotoEntity(var4, var7, var6, var5, var2);
      }
   }

   public PersonEntity.CoverPhotoEntity[] zzjP(int var1) {
      return new PersonEntity.CoverPhotoEntity[var1];
   }
}
