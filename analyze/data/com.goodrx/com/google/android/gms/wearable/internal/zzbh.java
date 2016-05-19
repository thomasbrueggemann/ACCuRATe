package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse;

public class zzbh implements Creator<RemoveLocalCapabilityResponse> {
   static void zza(RemoveLocalCapabilityResponse var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.statusCode);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmk(var1);
   }

   public RemoveLocalCapabilityResponse zziG(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      int var4 = 0;

      while(var1.dataPosition() < var3) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = zza.zzg(var1, var5);
            break;
         case 2:
            var2 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new RemoveLocalCapabilityResponse(var4, var2);
      }
   }

   public RemoveLocalCapabilityResponse[] zzmk(int var1) {
      return new RemoveLocalCapabilityResponse[var1];
   }
}
