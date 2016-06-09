package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

public class zzp implements Creator<ParcelableChangeInfo> {
   static void zza(ParcelableChangeInfo var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzaez);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzpH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcz(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzev(var1);
   }

   public ParcelableChangeInfo zzcz(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      ArrayList var6 = null;

      while(var1.dataPosition() < var2) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var7);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, ParcelableEvent.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ParcelableChangeInfo(var3, var4, var6);
      }
   }

   public ParcelableChangeInfo[] zzev(int var1) {
      return new ParcelableChangeInfo[var1];
   }
}
