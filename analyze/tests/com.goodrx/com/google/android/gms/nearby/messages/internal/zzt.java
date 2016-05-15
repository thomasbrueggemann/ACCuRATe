package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.MessageWrapper;
import com.google.android.gms.nearby.messages.internal.UnpublishRequest;

public class zzt implements Creator<UnpublishRequest> {
   static void zza(UnpublishRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzbcT, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzbbF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbco, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzbbH);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzbcs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgo(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzju(var1);
   }

   public UnpublishRequest zzgo(Parcel var1) {
      boolean var2 = false;
      ClientAppContext var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      IBinder var7 = null;
      MessageWrapper var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = (MessageWrapper)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, MessageWrapper.CREATOR);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 7:
            var3 = (ClientAppContext)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, ClientAppContext.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new UnpublishRequest(var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public UnpublishRequest[] zzju(int var1) {
      return new UnpublishRequest[var1];
   }
}
