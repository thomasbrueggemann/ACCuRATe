package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

public class zzah implements Creator<UserAttributeParcel> {
   static void zza(UserAttributeParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaZm);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Long)var0.zzaZn, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Float)var0.zzaZo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzamJ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzaVW, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfO(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziK(var1);
   }

   public UserAttributeParcel zzfO(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;
      Float var8 = null;
      Long var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var11);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzj(var1, var11);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzm(var1, var11);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new UserAttributeParcel(var4, var10, var5, var9, var8, var7, var2);
      }
   }

   public UserAttributeParcel[] zziK(int var1) {
      return new UserAttributeParcel[var1];
   }
}
