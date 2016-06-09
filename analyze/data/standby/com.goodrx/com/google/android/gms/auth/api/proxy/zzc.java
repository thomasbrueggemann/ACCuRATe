package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public class zzc implements Creator<ProxyResponse> {
   static void zza(ProxyResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.googlePlayServicesStatusCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.recoveryAction, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.statusCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Bundle)var0.zzWB, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (byte[])var0.body, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzP(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaK(var1);
   }

   public ProxyResponse zzP(Parcel var1) {
      byte[] var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Bundle var5 = null;
      PendingIntent var6 = null;
      int var7 = 0;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var6 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, PendingIntent.CREATOR);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var9);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var9);
            break;
         case 1000:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ProxyResponse(var8, var7, var6, var3, var5, var2);
      }
   }

   public ProxyResponse[] zzaK(int var1) {
      return new ProxyResponse[var1];
   }
}
