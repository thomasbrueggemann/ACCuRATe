package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.ChannelImpl;

public class zzo implements Creator<ChannelImpl> {
   static void zza(ChannelImpl var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (String)var0.getToken(), false);
      zzb.zza(var1, 3, (String)var0.getNodeId(), false);
      zzb.zza(var1, 4, (String)var0.getPath(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzig(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlJ(var1);
   }

   public ChannelImpl zzig(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var4 = zza.zzg(var1, var7);
            break;
         case 2:
            var6 = zza.zzp(var1, var7);
            break;
         case 3:
            var5 = zza.zzp(var1, var7);
            break;
         case 4:
            var2 = zza.zzp(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ChannelImpl(var4, var6, var5, var2);
      }
   }

   public ChannelImpl[] zzlJ(int var1) {
      return new ChannelImpl[var1];
   }
}
