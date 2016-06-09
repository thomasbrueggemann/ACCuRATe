package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<MomentEntity> {
   static void zza(MomentEntity var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      Set var4 = var0.zzbeN;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzyv, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzbfI, var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbfA, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzbfJ, var2, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzJN, true);
      }

      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjK(var1);
   }

   public MomentEntity zzgD(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      ItemScopeEntity var6 = null;
      String var7 = null;
      ItemScopeEntity var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
            break;
         case 4:
            ItemScopeEntity var15 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, ItemScopeEntity.CREATOR);
            var4.add(Integer.valueOf(4));
            var8 = var15;
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            var4.add(Integer.valueOf(5));
            break;
         case 6:
            ItemScopeEntity var12 = (ItemScopeEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, ItemScopeEntity.CREATOR);
            var4.add(Integer.valueOf(6));
            var6 = var12;
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            var4.add(Integer.valueOf(7));
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new MomentEntity(var4, var5, var9, var8, var7, var6, var2);
      }
   }

   public MomentEntity[] zzjK(int var1) {
      return new MomentEntity[var1];
   }
}
