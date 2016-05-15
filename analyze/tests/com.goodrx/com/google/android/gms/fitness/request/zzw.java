package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

public class zzw implements Creator<SensorUnregistrationRequest> {
   static void zza(SensorUnregistrationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (IBinder)var0.zzvb(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getIntent(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfC(var1);
   }

   public SensorUnregistrationRequest zzdB(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      PendingIntent var5 = null;

      IBinder var6;
      IBinder var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = zza.zzat(var1);
         PendingIntent var9;
         IBinder var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            IBinder var16 = zza.zzq(var1, var7);
            var11 = var4;
            var10 = var16;
            var8 = var2;
            var9 = var5;
            break;
         case 2:
            PendingIntent var12 = (PendingIntent)zza.zza(var1, var7, PendingIntent.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = zza.zzq(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var14;
            var8 = var2;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SensorUnregistrationRequest(var4, var6, var5, var2);
      }
   }

   public SensorUnregistrationRequest[] zzfC(int var1) {
      return new SensorUnregistrationRequest[var1];
   }
}
