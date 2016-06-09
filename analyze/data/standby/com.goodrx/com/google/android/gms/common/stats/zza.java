package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.stats.ConnectionEvent;

public class zza implements Creator<ConnectionEvent> {
   static void zza(ConnectionEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.getTimeMillis());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzrF(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzrG(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzrH(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzrI(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzrJ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.zzrN());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzrM());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 12, var0.getEventType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (String)var0.zzrK(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcl(var1);
   }

   public ConnectionEvent zzaF(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      int var6 = 0;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      long var13 = 0L;
      long var15 = 0L;

      while(var1.dataPosition() < var2) {
         int var17 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var17)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var17);
            break;
         case 3:
         case 9:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var17);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
            break;
         case 10:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var17);
            break;
         case 11:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var17);
            break;
         case 12:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var17);
            break;
         case 13:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ConnectionEvent(var3, var4, var6, var7, var8, var9, var10, var11, var12, var13, var15);
      }
   }

   public ConnectionEvent[] zzcl(int var1) {
      return new ConnectionEvent[var1];
   }
}
