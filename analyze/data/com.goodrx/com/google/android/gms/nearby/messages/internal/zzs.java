package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;

public class zzs implements Creator<SubscribeRequest> {
   static void zza(SubscribeRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzEH(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzbcU, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzbcZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzbda, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzbdb);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzbbF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzbco, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (byte[])var0.zzbdc, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzbbG);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (IBinder)var0.zzEI(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, var0.zzbbH);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (Parcelable)var0.zzbcs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjt(var1);
   }

   public SubscribeRequest zzgn(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      IBinder var4 = null;
      Strategy var5 = null;
      IBinder var6 = null;
      MessageFilter var7 = null;
      PendingIntent var8 = null;
      int var9 = 0;
      String var10 = null;
      String var11 = null;
      byte[] var12 = null;
      boolean var13 = false;
      IBinder var14 = null;
      boolean var15 = false;
      ClientAppContext var16 = null;

      while(var1.dataPosition() < var2) {
         int var17 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var17)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var17);
            break;
         case 3:
            var5 = (Strategy)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, Strategy.CREATOR);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var17);
            break;
         case 5:
            var7 = (MessageFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, MessageFilter.CREATOR);
            break;
         case 6:
            var8 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, PendingIntent.CREATOR);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var17);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var17);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var17);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var17);
            break;
         case 14:
            var16 = (ClientAppContext)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var17, ClientAppContext.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SubscribeRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   public SubscribeRequest[] zzjt(int var1) {
      return new SubscribeRequest[var1];
   }
}
