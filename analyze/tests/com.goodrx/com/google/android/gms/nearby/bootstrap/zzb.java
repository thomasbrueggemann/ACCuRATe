package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzb implements Creator<Device> {
   static void zza(Device var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getDescription(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getDeviceId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (byte)var0.zzEb());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfP(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziL(var1);
   }

   public Device zzfP(Parcel var1) {
      byte var2 = 0;
      String var3 = null;
      int var4 = zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var6 = zza.zzp(var1, var8);
            break;
         case 2:
            var5 = zza.zzp(var1, var8);
            break;
         case 3:
            var3 = zza.zzp(var1, var8);
            break;
         case 4:
            var2 = zza.zze(var1, var8);
            break;
         case 1000:
            var7 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Device(var7, var6, var5, var3, var2);
      }
   }

   public Device[] zziL(int var1) {
      return new Device[var1];
   }
}
