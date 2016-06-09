package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzi implements Creator<PersonEntity.PlacesLivedEntity> {
   static void zza(PersonEntity.PlacesLivedEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzbgr);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.mValue, true);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgM(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjT(var1);
   }

   public PersonEntity.PlacesLivedEntity zzgM(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var4 = new HashSet();
      String var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            var4.add(Integer.valueOf(3));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PersonEntity.PlacesLivedEntity(var4, var6, var2, var5);
      }
   }

   public PersonEntity.PlacesLivedEntity[] zzjT(int var1) {
      return new PersonEntity.PlacesLivedEntity[var1];
   }
}
