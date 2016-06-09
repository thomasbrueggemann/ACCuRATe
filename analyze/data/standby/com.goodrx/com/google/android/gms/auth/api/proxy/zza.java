package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;

public class zza implements Creator<ProxyGrpcRequest> {
   static void zza(ProxyGrpcRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.hostname, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.port);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.timeoutMillis);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (byte[])var0.body, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.method, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzN(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaI(var1);
   }

   public ProxyGrpcRequest zzN(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var5 = 0L;
      byte[] var7 = null;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var10);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 1000:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ProxyGrpcRequest(var9, var8, var2, var5, var7, var3);
      }
   }

   public ProxyGrpcRequest[] zzaI(int var1) {
      return new ProxyGrpcRequest[var1];
   }
}
