package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

public class zzr implements Creator<ParcelableIndexReference> {
   static void zza(ParcelableIndexReference var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzauL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzauM);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzauN);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzex(var1);
   }

   public ParcelableIndexReference zzcB(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      int var5 = -1;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableIndexReference(var7, var4, var6, var2, var5);
      }
   }

   public ParcelableIndexReference[] zzex(int var1) {
      return new ParcelableIndexReference[var1];
   }
}
