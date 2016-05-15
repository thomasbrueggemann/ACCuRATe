package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.internal.GetConfigResponse;

public class zzao implements Creator<GetConfigResponse> {
   static void zza(GetConfigResponse var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.statusCode);
      zzb.zza(var1, 3, (Parcelable)var0.zzbsG, var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlY(var1);
   }

   public GetConfigResponse zziu(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      ConnectionConfiguration var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzg(var1, var6);
            break;
         case 2:
            var2 = zza.zzg(var1, var6);
            break;
         case 3:
            var4 = (ConnectionConfiguration)zza.zza(var1, var6, ConnectionConfiguration.CREATOR);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GetConfigResponse(var5, var2, var4);
      }
   }

   public GetConfigResponse[] zzlY(int var1) {
      return new GetConfigResponse[var1];
   }
}
