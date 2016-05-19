package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.UnsubscribeRequest;

public class zzu implements Creator<UnsubscribeRequest> {
   static void zza(UnsubscribeRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzEH(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzbda, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzbdb);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzbbF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzbco, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzbbH);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzbcs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgp(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjv(var1);
   }

   public UnsubscribeRequest zzgp(Parcel var1) {
      boolean var2 = false;
      ClientAppContext var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      int var7 = 0;
      PendingIntent var8 = null;
      IBinder var9 = null;
      IBinder var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var12);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var12);
            break;
         case 4:
            var8 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, PendingIntent.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 9:
            var3 = (ClientAppContext)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, ClientAppContext.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new UnsubscribeRequest(var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public UnsubscribeRequest[] zzjv(int var1) {
      return new UnsubscribeRequest[var1];
   }
}
