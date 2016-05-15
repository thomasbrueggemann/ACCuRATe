package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.PopupLocationInfoParcelable;

public class PopupLocationInfoParcelableCreator implements Creator<PopupLocationInfoParcelable> {
   static void zza(PopupLocationInfoParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Bundle)var0.zzxg(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (IBinder)var0.getWindowToken(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzem(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgu(var1);
   }

   public PopupLocationInfoParcelable zzem(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      Bundle var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzr(var1, var6);
            break;
         case 2:
            var2 = zza.zzq(var1, var6);
            break;
         case 1000:
            var4 = zza.zzg(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PopupLocationInfoParcelable(var4, var5, var2);
      }
   }

   public PopupLocationInfoParcelable[] zzgu(int var1) {
      return new PopupLocationInfoParcelable[var1];
   }
}
