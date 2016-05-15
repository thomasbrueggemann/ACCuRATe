package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzg implements Creator<ConnectionConfiguration> {
   static void zza(ConnectionConfiguration var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (String)var0.getName(), false);
      zzb.zza(var1, 3, (String)var0.getAddress(), false);
      zzb.zzc(var1, 4, var0.getType());
      zzb.zzc(var1, 5, var0.getRole());
      zzb.zza(var1, 6, var0.isEnabled());
      zzb.zza(var1, 7, var0.isConnected());
      zzb.zza(var1, 8, (String)var0.zzIt(), false);
      zzb.zza(var1, 9, var0.zzIu());
      zzb.zza(var1, 10, (String)var0.getNodeId(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlz(var1);
   }

   public ConnectionConfiguration zzhY(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      String var5 = null;
      boolean var6 = false;
      boolean var7 = false;
      int var8 = 0;
      int var9 = 0;
      String var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var12 = zza.zzg(var1, var13);
            break;
         case 2:
            var11 = zza.zzp(var1, var13);
            break;
         case 3:
            var10 = zza.zzp(var1, var13);
            break;
         case 4:
            var9 = zza.zzg(var1, var13);
            break;
         case 5:
            var8 = zza.zzg(var1, var13);
            break;
         case 6:
            var7 = zza.zzc(var1, var13);
            break;
         case 7:
            var6 = zza.zzc(var1, var13);
            break;
         case 8:
            var5 = zza.zzp(var1, var13);
            break;
         case 9:
            var3 = zza.zzc(var1, var13);
            break;
         case 10:
            var2 = zza.zzp(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ConnectionConfiguration(var12, var11, var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }

   public ConnectionConfiguration[] zzlz(int var1) {
      return new ConnectionConfiguration[var1];
   }
}
