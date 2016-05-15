package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;

public class zzb implements Creator<ConnectionResult> {
   static void zza(ConnectionResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getErrorCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getResolution(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getErrorMessage(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzag(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbt(var1);
   }

   public ConnectionResult zzag(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      PendingIntent var5 = null;

      int var6;
      String var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         PendingIntent var9;
         int var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var3;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            PendingIntent var12 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, PendingIntent.CREATOR);
            var10 = var3;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            var9 = var5;
            var10 = var3;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var3;
            var11 = var6;
         }

         var6 = var11;
         var3 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ConnectionResult(var6, var3, var5, var2);
      }
   }

   public ConnectionResult[] zzbt(int var1) {
      return new ConnectionResult[var1];
   }
}
