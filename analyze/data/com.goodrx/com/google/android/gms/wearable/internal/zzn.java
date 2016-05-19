package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.ChannelImpl;

public class zzn implements Creator<ChannelEventParcelable> {
   static void zza(ChannelEventParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (Parcelable)var0.zzbsc, var2, false);
      zzb.zzc(var1, 3, var0.type);
      zzb.zzc(var1, 4, var0.zzbsa);
      zzb.zzc(var1, 5, var0.zzbsb);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzif(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlI(var1);
   }

   public ChannelEventParcelable zzif(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      ChannelImpl var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = zza.zzg(var1, var8);
            break;
         case 2:
            var4 = (ChannelImpl)zza.zza(var1, var8, ChannelImpl.CREATOR);
            break;
         case 3:
            var6 = zza.zzg(var1, var8);
            break;
         case 4:
            var5 = zza.zzg(var1, var8);
            break;
         case 5:
            var2 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ChannelEventParcelable(var7, var4, var6, var5, var2);
      }
   }

   public ChannelEventParcelable[] zzlI(int var1) {
      return new ChannelEventParcelable[var1];
   }
}
