package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Application;
import com.google.android.gms.fitness.data.Session;

public class zzq implements Creator<Session> {
   static void zza(Session var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getIdentifier(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getDescription(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzub());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.zzum(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Long)var0.zzuw(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfb(var1);
   }

   public Session zzdb(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      Long var5 = null;
      int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Application var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      long var11 = var2;
      int var13 = 0;

      while(var1.dataPosition() < var6) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var14);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var14);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 7:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 8:
            var7 = (Application)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var14, Application.CREATOR);
            break;
         case 9:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzj(var1, var14);
            break;
         case 1000:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new Session(var13, var11, var2, var10, var9, var8, var4, var7, var5);
      }
   }

   public Session[] zzfb(int var1) {
      return new Session[var1];
   }
}
