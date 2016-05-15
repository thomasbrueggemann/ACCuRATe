package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzj implements Creator<PersonEntity.UrlsEntity> {
   static void zza(PersonEntity.UrlsEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzFy());
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.mValue, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzaUO, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzabB);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgN(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjU(var1);
   }

   public PersonEntity.UrlsEntity zzgN(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var5 = new HashSet();
      int var6 = 0;
      String var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            var5.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            var5.add(Integer.valueOf(4));
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            var5.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            var5.add(Integer.valueOf(6));
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PersonEntity.UrlsEntity(var5, var8, var7, var6, var2, var3);
      }
   }

   public PersonEntity.UrlsEntity[] zzjU(int var1) {
      return new PersonEntity.UrlsEntity[var1];
   }
}
