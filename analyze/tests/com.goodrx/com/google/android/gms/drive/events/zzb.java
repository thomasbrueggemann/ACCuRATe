package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zzb implements Creator<ChangesAvailableEvent> {
   static void zza(ChangesAvailableEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzVa, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzapy, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcF(var1);
   }

   public ChangesAvailableEvent zzaQ(Parcel var1) {
      ChangesAvailableOptions var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         case 3:
            var2 = (ChangesAvailableOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, ChangesAvailableOptions.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ChangesAvailableEvent(var4, var5, var2);
      }
   }

   public ChangesAvailableEvent[] zzcF(int var1) {
      return new ChangesAvailableEvent[var1];
   }
}
