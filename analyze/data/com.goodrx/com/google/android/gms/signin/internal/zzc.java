package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.ArrayList;

public class zzc implements Creator<CheckServerAuthResult> {
   static void zza(CheckServerAuthResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzbhf);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzbhg, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjZ(var1);
   }

   public CheckServerAuthResult zzgS(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6, Scope.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CheckServerAuthResult(var5, var2, var4);
      }
   }

   public CheckServerAuthResult[] zzjZ(int var1) {
      return new CheckServerAuthResult[var1];
   }
}
