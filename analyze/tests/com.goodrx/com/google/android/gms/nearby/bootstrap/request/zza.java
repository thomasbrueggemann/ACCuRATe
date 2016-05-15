package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;

public class zza implements Creator<ConnectRequest> {
   static void zza(ConnectRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzEd(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getDescription(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzEg(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzEh(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (byte)var0.zzEb());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzEe());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.getToken(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (byte)var0.zzEf());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziM(var1);
   }

   public ConnectRequest zzfQ(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      Device var4 = null;
      String var5 = null;
      String var6 = null;
      byte var7 = 0;
      long var8 = 0L;
      String var10 = null;
      byte var11 = 0;
      IBinder var12 = null;
      IBinder var13 = null;
      IBinder var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var4 = (Device)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, Device.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 4:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var15);
            break;
         case 5:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var15);
            break;
         case 6:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var15);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var15);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 9:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 10:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var15);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ConnectRequest(var3, var4, var5, var6, var7, var8, var10, var11, var12, var13, var14);
      }
   }

   public ConnectRequest[] zziM(int var1) {
      return new ConnectRequest[var1];
   }
}
