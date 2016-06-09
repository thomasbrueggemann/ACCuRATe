package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzd implements Creator<PersonEntity.CoverInfoEntity> {
   static void zza(PersonEntity.CoverInfoEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzbgj);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzbgk);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgH(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjO(var1);
   }

   public PersonEntity.CoverInfoEntity zzgH(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var4.add(Integer.valueOf(3));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PersonEntity.CoverInfoEntity(var4, var6, var5, var2);
      }
   }

   public PersonEntity.CoverInfoEntity[] zzjO(int var1) {
      return new PersonEntity.CoverInfoEntity[var1];
   }
}
