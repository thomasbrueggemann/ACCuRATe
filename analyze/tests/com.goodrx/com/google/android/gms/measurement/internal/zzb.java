package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.AppMetadata;

public class zzb implements Creator<AppMetadata> {
   static void zza(AppMetadata var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.packageName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzaVt, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzaMV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzaVu, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzaVv);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzaVw);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzaVx, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.zzaVy);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.zzaVz);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfL(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziH(var1);
   }

   public AppMetadata zzfL(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      long var8 = 0L;
      long var10 = 0L;
      String var12 = null;
      boolean var13 = false;
      boolean var14 = false;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 8:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 9:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var15);
            break;
         case 10:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AppMetadata(var3, var4, var5, var6, var7, var8, var10, var12, var13, var14);
      }
   }

   public AppMetadata[] zziH(int var1) {
      return new AppMetadata[var1];
   }
}
