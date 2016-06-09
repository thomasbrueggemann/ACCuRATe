package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;

public class zzl implements Creator<MessageWrapper> {
   static void zza(MessageWrapper var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzbcu, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjp(var1);
   }

   public MessageWrapper zzgk(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      Message var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var5)) {
         case 1:
            var4 = (Message)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var5, Message.CREATOR);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new MessageWrapper(var3, var4);
      }
   }

   public MessageWrapper[] zzjp(int var1) {
      return new MessageWrapper[var1];
   }
}
