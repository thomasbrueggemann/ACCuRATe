package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Creator<ItemScopeEntity> {
   static void zza(ItemScopeEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzbeO, var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 3, var0.zzbeP, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzbeQ, var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbeR, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzbeS, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzbeT, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzbeU, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 9, var0.zzbeV);
      }

      if(var4.contains(Integer.valueOf(10))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.zzbeW, true);
      }

      if(var4.contains(Integer.valueOf(11))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (Parcelable)var0.zzbeX, var2, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 12, var0.zzbeY, true);
      }

      if(var4.contains(Integer.valueOf(13))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (String)var0.zzbeZ, true);
      }

      if(var4.contains(Integer.valueOf(14))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (String)var0.zzbfa, true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (Parcelable)var0.zzbfb, var2, true);
      }

      if(var4.contains(Integer.valueOf(17))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 17, (String)var0.zzbfd, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, (String)var0.zzbfc, true);
      }

      if(var4.contains(Integer.valueOf(19))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 19, var0.zzbfe, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 18, (String)var0.zztZ, true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 21, (String)var0.zzbfg, true);
      }

      if(var4.contains(Integer.valueOf(20))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 20, (String)var0.zzbff, true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 23, (String)var0.zzaxl, true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 22, (String)var0.zzbfh, true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 25, (String)var0.zzbfj, true);
      }

      if(var4.contains(Integer.valueOf(24))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 24, (String)var0.zzbfi, true);
      }

      if(var4.contains(Integer.valueOf(27))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 27, (String)var0.zzbfl, true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 26, (String)var0.zzbfk, true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 29, (Parcelable)var0.zzbfn, var2, true);
      }

      if(var4.contains(Integer.valueOf(28))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 28, (String)var0.zzbfm, true);
      }

      if(var4.contains(Integer.valueOf(31))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 31, (String)var0.zzbfp, true);
      }

      if(var4.contains(Integer.valueOf(30))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 30, (String)var0.zzbfo, true);
      }

      if(var4.contains(Integer.valueOf(34))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 34, (Parcelable)var0.zzbfr, var2, true);
      }

      if(var4.contains(Integer.valueOf(32))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 32, (String)var0.zzyv, true);
      }

      if(var4.contains(Integer.valueOf(33))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 33, (String)var0.zzbfq, true);
      }

      if(var4.contains(Integer.valueOf(38))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 38, var0.zzaNG);
      }

      if(var4.contains(Integer.valueOf(39))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 39, (String)var0.mName, true);
      }

      if(var4.contains(Integer.valueOf(36))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 36, var0.zzaNF);
      }

      if(var4.contains(Integer.valueOf(37))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 37, (Parcelable)var0.zzbfs, var2, true);
      }

      if(var4.contains(Integer.valueOf(42))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 42, (String)var0.zzbfv, true);
      }

      if(var4.contains(Integer.valueOf(43))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 43, (String)var0.zzbfw, true);
      }

      if(var4.contains(Integer.valueOf(40))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 40, (Parcelable)var0.zzbft, var2, true);
      }

      if(var4.contains(Integer.valueOf(41))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 41, var0.zzbfu, true);
      }

      if(var4.contains(Integer.valueOf(46))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 46, (Parcelable)var0.zzbfz, var2, true);
      }

      if(var4.contains(Integer.valueOf(47))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 47, (String)var0.zzbfA, true);
      }

      if(var4.contains(Integer.valueOf(44))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 44, (String)var0.zzbfx, true);
      }

      if(var4.contains(Integer.valueOf(45))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 45, (String)var0.zzbfy, true);
      }

      if(var4.contains(Integer.valueOf(51))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 51, (String)var0.zzbfE, true);
      }

      if(var4.contains(Integer.valueOf(50))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 50, (Parcelable)var0.zzbfD, var2, true);
      }

      if(var4.contains(Integer.valueOf(49))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 49, (String)var0.zzbfC, true);
      }

      if(var4.contains(Integer.valueOf(48))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 48, (String)var0.zzbfB, true);
      }

      if(var4.contains(Integer.valueOf(55))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 55, (String)var0.zzbfG, true);
      }

      if(var4.contains(Integer.valueOf(54))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 54, (String)var0.zzF, true);
      }

      if(var4.contains(Integer.valueOf(53))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 53, (String)var0.zzJN, true);
      }

      if(var4.contains(Integer.valueOf(52))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 52, (String)var0.zzbfF, true);
      }

      if(var4.contains(Integer.valueOf(56))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 56, (String)var0.zzbfH, true);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjJ(var1);
   }

   public ItemScopeEntity zzgC(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      ItemScopeEntity var5 = null;
      ArrayList var6 = null;
      ItemScopeEntity var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      ArrayList var11 = null;
      int var12 = 0;
      ArrayList var13 = null;
      ItemScopeEntity var14 = null;
      ArrayList var15 = null;
      String var16 = null;
      String var17 = null;
      ItemScopeEntity var18 = null;
      String var19 = null;
      String var20 = null;
      String var21 = null;
      ArrayList var22 = null;
      String var23 = null;
      String var24 = null;
      String var25 = null;
      String var26 = null;
      String var27 = null;
      String var28 = null;
      String var29 = null;
      String var30 = null;
      String var31 = null;
      ItemScopeEntity var32 = null;
      String var33 = null;
      String var34 = null;
      String var35 = null;
      String var36 = null;
      ItemScopeEntity var37 = null;
      double var38 = 0.0D;
      ItemScopeEntity var40 = null;
      double var41 = 0.0D;
      String var43 = null;
      ItemScopeEntity var44 = null;
      ArrayList var45 = null;
      String var46 = null;
      String var47 = null;
      String var48 = null;
      String var49 = null;
      ItemScopeEntity var50 = null;
      String var51 = null;
      String var52 = null;
      String var53 = null;
      ItemScopeEntity var54 = null;
      String var55 = null;
      String var56 = null;
      String var57 = null;
      String var58 = null;
      String var59 = null;
      String var60 = null;

      while(var1.dataPosition() < var2) {
         int var61 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var61)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var61);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            ItemScopeEntity var124 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(2));
            var5 = var124;
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var61);
            var3.add(Integer.valueOf(3));
            break;
         case 4:
            ItemScopeEntity var121 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(4));
            var7 = var121;
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(6));
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(7));
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(8));
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var61);
            var3.add(Integer.valueOf(9));
            break;
         case 10:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(10));
            break;
         case 11:
            ItemScopeEntity var113 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(11));
            var14 = var113;
            break;
         case 12:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(12));
            break;
         case 13:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(13));
            break;
         case 14:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(14));
            break;
         case 15:
            ItemScopeEntity var108 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(15));
            var18 = var108;
            break;
         case 16:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(16));
            break;
         case 17:
            var20 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(17));
            break;
         case 18:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(18));
            break;
         case 19:
            var22 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(19));
            break;
         case 20:
            var23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(20));
            break;
         case 21:
            var24 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(21));
            break;
         case 22:
            var25 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(22));
            break;
         case 23:
            var26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(23));
            break;
         case 24:
            var27 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(24));
            break;
         case 25:
            var28 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(25));
            break;
         case 26:
            var29 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(26));
            break;
         case 27:
            var30 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(27));
            break;
         case 28:
            var31 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(28));
            break;
         case 29:
            ItemScopeEntity var94 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(29));
            var32 = var94;
            break;
         case 30:
            var33 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(30));
            break;
         case 31:
            var34 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(31));
            break;
         case 32:
            var35 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(32));
            break;
         case 33:
            var36 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(33));
            break;
         case 34:
            ItemScopeEntity var89 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(34));
            var37 = var89;
            break;
         case 35:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var61);
            break;
         case 36:
            var38 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var61);
            var3.add(Integer.valueOf(36));
            break;
         case 37:
            ItemScopeEntity var82 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(37));
            var40 = var82;
            break;
         case 38:
            var41 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var61);
            var3.add(Integer.valueOf(38));
            break;
         case 39:
            var43 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(39));
            break;
         case 40:
            ItemScopeEntity var78 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(40));
            var44 = var78;
            break;
         case 41:
            var45 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(41));
            break;
         case 42:
            var46 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(42));
            break;
         case 43:
            var47 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(43));
            break;
         case 44:
            var48 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(44));
            break;
         case 45:
            var49 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(45));
            break;
         case 46:
            ItemScopeEntity var75 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(46));
            var50 = var75;
            break;
         case 47:
            var51 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(47));
            break;
         case 48:
            var52 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(48));
            break;
         case 49:
            var53 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(49));
            break;
         case 50:
            ItemScopeEntity var69 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var61, ItemScopeEntity.CREATOR);
            var3.add(Integer.valueOf(50));
            var54 = var69;
            break;
         case 51:
            var55 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(51));
            break;
         case 52:
            var56 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(52));
            break;
         case 53:
            var57 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(53));
            break;
         case 54:
            var58 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(54));
            break;
         case 55:
            var59 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(55));
            break;
         case 56:
            var60 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var61);
            var3.add(Integer.valueOf(56));
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ItemScopeEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var40, var41, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60);
      }
   }

   public ItemScopeEntity[] zzjJ(int var1) {
      return new ItemScopeEntity[var1];
   }
}
