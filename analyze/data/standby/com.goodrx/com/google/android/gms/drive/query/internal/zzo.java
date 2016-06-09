package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

public class zzo implements Creator<OwnedByMeFilter> {
   static void zza(OwnedByMeFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcw(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzer(var1);
   }

   public OwnedByMeFilter zzcw(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var4)) {
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new OwnedByMeFilter(var3);
      }
   }

   public OwnedByMeFilter[] zzer(int var1) {
      return new OwnedByMeFilter[var1];
   }
}
