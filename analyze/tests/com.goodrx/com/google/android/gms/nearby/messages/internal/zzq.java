package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;
import com.google.android.gms.nearby.messages.internal.PublishRequest;

public class zzq implements Creator<PublishRequest> {
   static void zza(PublishRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzbcT, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzbcU, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbbF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzbco, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzbbG);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (IBinder)var0.zzEF(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.zzbbH);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.zzbcs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjr(var1);
   }

   public PublishRequest zzgl(Parcel var1) {
      boolean var2 = false;
      ClientAppContext var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      IBinder var5 = null;
      boolean var6 = false;
      String var7 = null;
      String var8 = null;
      IBinder var9 = null;
      Strategy var10 = null;
      MessageWrapper var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 2:
            var11 = (MessageWrapper)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, MessageWrapper.CREATOR);
            break;
         case 3:
            var10 = (Strategy)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, Strategy.CREATOR);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var13);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var13);
            break;
         case 9:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 10:
            var3 = (ClientAppContext)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, ClientAppContext.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PublishRequest(var12, var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public PublishRequest[] zzjr(int var1) {
      return new PublishRequest[var1];
   }
}
