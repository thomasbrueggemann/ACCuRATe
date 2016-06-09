package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.internal.PartialDriveId;

public class zzn implements Creator<PartialDriveId> {
   static void zza(PartialDriveId var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzaoL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaoM);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaoN);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzci(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzed(var1);
   }

   public PartialDriveId zzci(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      long var5 = 0L;
      int var7 = -1;

      while(var1.dataPosition() < var2) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var8);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new PartialDriveId(var3, var4, var5, var7);
      }
   }

   public PartialDriveId[] zzed(int var1) {
      return new PartialDriveId[var1];
   }
}
