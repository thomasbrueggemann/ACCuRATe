package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;

public class zzf implements Creator<AmsEntityUpdateParcelable> {
   static void zza(AmsEntityUpdateParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (byte)var0.zzIz());
      zzb.zza(var1, 3, (byte)var0.zzIA());
      zzb.zza(var1, 4, (String)var0.getValue(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzic(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlD(var1);
   }

   public AmsEntityUpdateParcelable zzic(Parcel var1) {
      byte var2 = 0;
      int var3 = zza.zzau(var1);
      String var4 = null;
      byte var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var6 = zza.zzg(var1, var7);
            break;
         case 2:
            var5 = zza.zze(var1, var7);
            break;
         case 3:
            var2 = zza.zze(var1, var7);
            break;
         case 4:
            var4 = zza.zzp(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AmsEntityUpdateParcelable(var6, var5, var2, var4);
      }
   }

   public AmsEntityUpdateParcelable[] zzlD(int var1) {
      return new AmsEntityUpdateParcelable[var1];
   }
}
