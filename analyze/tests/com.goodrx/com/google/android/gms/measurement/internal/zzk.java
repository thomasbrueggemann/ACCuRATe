package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;

public class zzk implements Creator<EventParcel> {
   static void zza(EventParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzaVV, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzaVW, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzaVX);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfN(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziJ(var1);
   }

   public EventParcel zzfN(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      EventParams var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var7 = (EventParams)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, EventParams.CREATOR);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new EventParcel(var4, var8, var7, var2, var5);
      }
   }

   public EventParcel[] zziJ(int var1) {
      return new EventParcel[var1];
   }
}
