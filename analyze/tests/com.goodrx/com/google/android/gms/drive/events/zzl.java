package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzl implements Creator<QueryResultEventParcelable> {
   static void zza(QueryResultEventParcelable var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzahi, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzapQ);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzapR);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaT(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcI(var1);
   }

   public QueryResultEventParcelable zzaT(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DataHolder var4 = null;
      boolean var5 = false;

      int var6;
      int var8;
      for(var6 = 0; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         boolean var9;
         DataHolder var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            DataHolder var14 = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, DataHolder.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            boolean var12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            var10 = var4;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var4;
            var11 = var6;
         }

         var6 = var11;
         var4 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new QueryResultEventParcelable(var6, var4, var5, var2);
      }
   }

   public QueryResultEventParcelable[] zzcI(int var1) {
      return new QueryResultEventParcelable[var1];
   }
}
