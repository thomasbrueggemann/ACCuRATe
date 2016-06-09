package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;

public class zze implements Creator<DriveId> {
   static void zza(DriveId var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzaoL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaoM);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaou);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzaoN);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaK(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzct(var1);
   }

   public DriveId zzaK(Parcel var1) {
      long var2 = 0L;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = -1;
      long var8 = var2;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DriveId(var5, var6, var8, var2, var7);
      }
   }

   public DriveId[] zzct(int var1) {
      return new DriveId[var1];
   }
}
