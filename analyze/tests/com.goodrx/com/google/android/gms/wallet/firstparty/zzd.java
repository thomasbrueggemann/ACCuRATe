package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.firstparty.GetInstrumentsRequest;

public class zzd implements Creator<GetInstrumentsRequest> {
   static void zza(GetInstrumentsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (int[])var0.zzbpS, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhI(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlg(var1);
   }

   public GetInstrumentsRequest zzhI(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      int[] var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var3 = zza.zzg(var1, var5);
            break;
         case 2:
            var4 = zza.zzv(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GetInstrumentsRequest(var3, var4);
      }
   }

   public GetInstrumentsRequest[] zzlg(int var1) {
      return new GetInstrumentsRequest[var1];
   }
}
