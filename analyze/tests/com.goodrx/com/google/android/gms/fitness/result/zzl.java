package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.result.SyncInfoResult;

public class zzl implements Creator<SyncInfoResult> {
   static void zza(SyncInfoResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzvq());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfZ(var1);
   }

   public SyncInfoResult zzdY(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      Status var4 = null;

      long var5;
      long var8;
      for(var5 = 0L; var1.dataPosition() < var2; var5 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         Status var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            Status var15 = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Status.CREATOR);
            var10 = var15;
            var11 = var3;
            var8 = var5;
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var7);
            var10 = var4;
            var11 = var3;
            break;
         case 1000:
            int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var10 = var4;
            var11 = var12;
            var8 = var5;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var5;
            var10 = var4;
            var11 = var3;
         }

         var4 = var10;
         var3 = var11;
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SyncInfoResult(var3, var4, var5);
      }
   }

   public SyncInfoResult[] zzfZ(int var1) {
      return new SyncInfoResult[var1];
   }
}
