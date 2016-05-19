package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;

public class zze implements Creator<EnableTargetRequest> {
   static void zza(EnableTargetRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getDescription(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzEg(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzEh(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (byte)var0.zzEb());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfU(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziQ(var1);
   }

   public EnableTargetRequest zzfU(Parcel var1) {
      byte var2 = 0;
      IBinder var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      IBinder var5 = null;
      IBinder var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zze(var1, var10);
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
         return new EnableTargetRequest(var9, var8, var7, var2, var6, var5, var3);
      }
   }

   public EnableTargetRequest[] zziQ(int var1) {
      return new EnableTargetRequest[var1];
   }
}
