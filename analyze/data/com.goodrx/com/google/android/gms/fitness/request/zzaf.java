package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.SubscribeRequest;

public class zzaf implements Creator<SubscribeRequest> {
   static void zza(SubscribeRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzvh(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzvi());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdK(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfL(var1);
   }

   public SubscribeRequest zzdK(Parcel var1) {
      IBinder var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      Subscription var5 = null;

      int var6;
      IBinder var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = zza.zzat(var1);
         boolean var9;
         Subscription var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            Subscription var16 = (Subscription)zza.zza(var1, var7, Subscription.CREATOR);
            var11 = var6;
            var10 = var16;
            var8 = var2;
            var9 = var3;
            break;
         case 2:
            boolean var12 = zza.zzc(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = zza.zzq(var1, var7);
            var9 = var3;
            var10 = var5;
            var11 = var6;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var3;
            var10 = var5;
            var11 = var14;
            var8 = var2;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var2;
            var9 = var3;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var3 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new SubscribeRequest(var6, var5, var3, var2);
      }
   }

   public SubscribeRequest[] zzfL(int var1) {
      return new SubscribeRequest[var1];
   }
}
