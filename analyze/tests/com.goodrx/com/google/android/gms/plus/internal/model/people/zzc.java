package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzc implements Creator<PersonEntity.CoverEntity> {
   static void zza(PersonEntity.CoverEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzbgg, var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzbgh, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzbgi);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjN(var1);
   }

   public PersonEntity.CoverEntity zzgG(Parcel var1) {
      PersonEntity.CoverPhotoEntity var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var5 = new HashSet();
      PersonEntity.CoverInfoEntity var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            PersonEntity.CoverInfoEntity var12 = (PersonEntity.CoverInfoEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, PersonEntity.CoverInfoEntity.CREATOR);
            var5.add(Integer.valueOf(2));
            var6 = var12;
            break;
         case 3:
            PersonEntity.CoverPhotoEntity var10 = (PersonEntity.CoverPhotoEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, PersonEntity.CoverPhotoEntity.CREATOR);
            var5.add(Integer.valueOf(3));
            var2 = var10;
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            var5.add(Integer.valueOf(4));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PersonEntity.CoverEntity(var5, var7, var6, var2, var3);
      }
   }

   public PersonEntity.CoverEntity[] zzjN(int var1) {
      return new PersonEntity.CoverEntity[var1];
   }
}
