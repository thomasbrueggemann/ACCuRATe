package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest;

public class zzg implements Creator<ReceiveContentRequest> {
   static void zza(ReceiveContentRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzbdk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzEQ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.packageName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgv(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjB(var1);
   }

   public ReceiveContentRequest zzgv(Parcel var1) {
      IBinder var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ReceiveContentRequest(var4, var7, var6, var5, var2);
      }
   }

   public ReceiveContentRequest[] zzjB(int var1) {
      return new ReceiveContentRequest[var1];
   }
}
