package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;

public class zzz implements Creator<SessionRegistrationRequest> {
   static void zza(SessionRegistrationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getIntent(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzvf());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfF(var1);
   }

   public SessionRegistrationRequest zzdE(Parcel var1) {
      IBinder var2 = null;
      int var3 = 0;
      int var4 = zza.zzau(var1);
      PendingIntent var5 = null;

      int var6;
      int var8;
      for(var6 = 0; var1.dataPosition() < var4; var3 = var8) {
         int var7 = zza.zzat(var1);
         IBinder var9;
         PendingIntent var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            PendingIntent var16 = (PendingIntent)zza.zza(var1, var7, PendingIntent.CREATOR);
            var11 = var6;
            var10 = var16;
            var8 = var3;
            var9 = var2;
            break;
         case 2:
            IBinder var12 = zza.zzq(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var3;
            break;
         case 4:
            var8 = zza.zzg(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var6;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var14;
            var8 = var3;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var3;
            var9 = var2;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var2 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new SessionRegistrationRequest(var6, var5, var2, var3);
      }
   }

   public SessionRegistrationRequest[] zzfF(int var1) {
      return new SessionRegistrationRequest[var1];
   }
}
