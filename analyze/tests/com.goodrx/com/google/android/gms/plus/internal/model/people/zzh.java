package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzh implements Creator<PersonEntity.OrganizationsEntity> {
   static void zza(PersonEntity.OrganizationsEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbgp, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzaxl, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzbfk, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbgq, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.mName, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzbgr);
      }

      if(var4.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzbfA, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzapg, true);
      }

      if(var4.contains(Integer.valueOf(10))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.zzabB);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgL(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjS(var1);
   }

   public PersonEntity.OrganizationsEntity zzgL(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var5 = new HashSet();
      String var6 = null;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(2));
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(3));
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(4));
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(5));
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(6));
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14);
            var5.add(Integer.valueOf(7));
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(8));
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            var5.add(Integer.valueOf(9));
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            var5.add(Integer.valueOf(10));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PersonEntity.OrganizationsEntity(var5, var13, var12, var11, var10, var9, var8, var7, var6, var3, var2);
      }
   }

   public PersonEntity.OrganizationsEntity[] zzjS(int var1) {
      return new PersonEntity.OrganizationsEntity[var1];
   }
}
