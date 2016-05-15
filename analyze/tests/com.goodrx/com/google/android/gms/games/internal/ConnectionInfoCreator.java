package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.ConnectionInfo;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
   static void zza(ConnectionInfo var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.zzwt(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzc(var1, 2, var0.zzwu());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzel(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgr(var1);
   }

   public ConnectionInfo zzel(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var4 = zza.zzp(var1, var6);
            break;
         case 2:
            var2 = zza.zzg(var1, var6);
            break;
         case 1000:
            var5 = zza.zzg(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ConnectionInfo(var5, var4, var2);
      }
   }

   public ConnectionInfo[] zzgr(int var1) {
      return new ConnectionInfo[var1];
   }
}
