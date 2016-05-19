package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.ArrayList;

public class zzd implements Creator<ParcelableEventList> {
   static void zza(ParcelableEventList var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzpH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzavf, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzavg);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 5, var0.zzavh, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzavi, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeB(var1);
   }

   public ParcelableEventList zzcF(Parcel var1) {
      boolean var2 = false;
      ParcelableChangeInfo var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      DataHolder var6 = null;
      ArrayList var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9, ParcelableEvent.CREATOR);
            break;
         case 3:
            var6 = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DataHolder.CREATOR);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var9);
            break;
         case 6:
            var3 = (ParcelableChangeInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, ParcelableChangeInfo.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableEventList(var8, var7, var6, var2, var5, var3);
      }
   }

   public ParcelableEventList[] zzeB(int var1) {
      return new ParcelableEventList[var1];
   }
}
