package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import java.util.ArrayList;

public class zzd implements Creator<ChangesAvailableOptions> {
   static void zza(ChangesAvailableOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzapz);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzapA);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzapB, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaR(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcG(var1);
   }

   public ChangesAvailableOptions zzaR(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, DriveSpace.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ChangesAvailableOptions(var6, var5, var2, var4);
      }
   }

   public ChangesAvailableOptions[] zzcG(int var1) {
      return new ChangesAvailableOptions[var1];
   }
}
