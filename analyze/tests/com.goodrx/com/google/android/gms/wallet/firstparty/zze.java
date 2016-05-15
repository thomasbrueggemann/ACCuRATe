package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;

public class zze implements Creator<GetInstrumentsResponse> {
   static void zza(GetInstrumentsResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String[])var0.zzbpT, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (byte[][])var0.zzbpU, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhJ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlh(var1);
   }

   public GetInstrumentsResponse zzhJ(Parcel var1) {
      String[] var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      byte[][] var5 = (byte[][])null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var4 = zza.zzg(var1, var6);
            break;
         case 2:
            var2 = zza.zzB(var1, var6);
            break;
         case 3:
            var5 = zza.zzt(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GetInstrumentsResponse(var4, var2, var5);
      }
   }

   public GetInstrumentsResponse[] zzlh(int var1) {
      return new GetInstrumentsResponse[var1];
   }
}
