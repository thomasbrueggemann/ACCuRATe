package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.request.DisableFitRequest;

public class zzo implements Creator<DisableFitRequest> {
   static void zza(DisableFitRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfu(var1);
   }

   public DisableFitRequest zzdu(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      IBinder var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = zza.zzq(var1, var5);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new DisableFitRequest(var3, var4);
      }
   }

   public DisableFitRequest[] zzfu(int var1) {
      return new DisableFitRequest[var1];
   }
}
