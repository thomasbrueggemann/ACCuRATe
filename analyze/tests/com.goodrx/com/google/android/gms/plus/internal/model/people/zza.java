package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Creator<PersonEntity> {
   static void zza(PersonEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbfL, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzbfM, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzbfN, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbfO, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzbfP);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzbfQ, var2, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzbfR, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzWQ, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 12, var0.zztT);
      }

      if(var4.contains(Integer.valueOf(14))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (String)var0.zzyv, true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (Parcelable)var0.zzbfS, var2, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, var0.zzbfT);
      }

      if(var4.contains(Integer.valueOf(19))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 19, (Parcelable)var0.zzbfU, var2, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 18, (String)var0.zzaaL, true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 21, var0.zzbfW);
      }

      if(var4.contains(Integer.valueOf(20))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 20, (String)var0.zzbfV, true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 23, var0.zzbfY, true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 22, var0.zzbfX, true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 25, var0.zzbga);
      }

      if(var4.contains(Integer.valueOf(24))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 24, var0.zzbfZ);
      }

      if(var4.contains(Integer.valueOf(27))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 27, (String)var0.zzF, true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 26, (String)var0.zzbgb, true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 29, var0.zzbgd);
      }

      if(var4.contains(Integer.valueOf(28))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 28, var0.zzbgc, true);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjL(var1);
   }

   public PersonEntity zzgE(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      String var5 = null;
      PersonEntity.AgeRangeEntity var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;
      PersonEntity.CoverEntity var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      PersonEntity.ImageEntity var15 = null;
      boolean var16 = false;
      String var17 = null;
      PersonEntity.NameEntity var18 = null;
      String var19 = null;
      int var20 = 0;
      ArrayList var21 = null;
      ArrayList var22 = null;
      int var23 = 0;
      int var24 = 0;
      String var25 = null;
      String var26 = null;
      ArrayList var27 = null;
      boolean var28 = false;

      while(var1.dataPosition() < var2) {
         int var29 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var29)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(2));
            break;
         case 3:
            PersonEntity.AgeRangeEntity var55 = (PersonEntity.AgeRangeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var29, PersonEntity.AgeRangeEntity.CREATOR);
            var3.add(Integer.valueOf(3));
            var6 = var55;
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(4));
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(6));
            break;
         case 7:
            PersonEntity.CoverEntity var50 = (PersonEntity.CoverEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var29, PersonEntity.CoverEntity.CREATOR);
            var3.add(Integer.valueOf(7));
            var10 = var50;
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(8));
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(9));
            break;
         case 10:
         case 11:
         case 13:
         case 17:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var29);
            break;
         case 12:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(12));
            break;
         case 14:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(14));
            break;
         case 15:
            PersonEntity.ImageEntity var44 = (PersonEntity.ImageEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var29, PersonEntity.ImageEntity.CREATOR);
            var3.add(Integer.valueOf(15));
            var15 = var44;
            break;
         case 16:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var29);
            var3.add(Integer.valueOf(16));
            break;
         case 18:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(18));
            break;
         case 19:
            PersonEntity.NameEntity var41 = (PersonEntity.NameEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var29, PersonEntity.NameEntity.CREATOR);
            var3.add(Integer.valueOf(19));
            var18 = var41;
            break;
         case 20:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(20));
            break;
         case 21:
            var20 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(21));
            break;
         case 22:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var29, PersonEntity.OrganizationsEntity.CREATOR);
            var3.add(Integer.valueOf(22));
            break;
         case 23:
            var22 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var29, PersonEntity.PlacesLivedEntity.CREATOR);
            var3.add(Integer.valueOf(23));
            break;
         case 24:
            var23 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(24));
            break;
         case 25:
            var24 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var29);
            var3.add(Integer.valueOf(25));
            break;
         case 26:
            var25 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(26));
            break;
         case 27:
            var26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var29);
            var3.add(Integer.valueOf(27));
            break;
         case 28:
            var27 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var29, PersonEntity.UrlsEntity.CREATOR);
            var3.add(Integer.valueOf(28));
            break;
         case 29:
            var28 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var29);
            var3.add(Integer.valueOf(29));
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new PersonEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
      }
   }

   public PersonEntity[] zzjL(int var1) {
      return new PersonEntity[var1];
   }
}
