package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;

public class zzb implements Creator<MessageFilter> {
   static void zza(MessageFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzEo(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzEq(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzEp());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjc(var1);
   }

   public MessageFilter zzgb(Parcel var1) {
      ArrayList var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, MessageType.CREATOR);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, NearbyDeviceFilter.CREATOR);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7);
            break;
         case 1000:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new MessageFilter(var6, var5, var2, var3);
      }
   }

   public MessageFilter[] zzjc(int var1) {
      return new MessageFilter[var1];
   }
}
