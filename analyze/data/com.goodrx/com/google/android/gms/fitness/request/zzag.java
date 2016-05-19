package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

public class zzag implements Creator<UnclaimBleDeviceRequest> {
   static void zza(UnclaimBleDeviceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getDeviceAddress(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdL(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfM(var1);
   }

   public UnclaimBleDeviceRequest zzdL(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 2:
            var5 = zza.zzp(var1, var6);
            break;
         case 3:
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
         return new UnclaimBleDeviceRequest(var4, var5, var2);
      }
   }

   public UnclaimBleDeviceRequest[] zzfM(int var1) {
      return new UnclaimBleDeviceRequest[var1];
   }
}
