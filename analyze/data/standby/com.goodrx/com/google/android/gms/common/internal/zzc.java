package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;

public class zzc implements Creator<AuthAccountRequest> {
   static void zza(AuthAccountRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzakA, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable[])var0.zzafT, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Integer)var0.zzakB, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Integer)var0.zzakC, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzam(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbP(var1);
   }

   public AuthAccountRequest zzam(Parcel var1) {
      Integer var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      Integer var5 = null;
      Scope[] var6 = null;
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
            var6 = (Scope[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8, Scope.CREATOR);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzh(var1, var8);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzh(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AuthAccountRequest(var4, var7, var6, var5, var2);
      }
   }

   public AuthAccountRequest[] zzbP(int var1) {
      return new AuthAccountRequest[var1];
   }
}
