package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;

public class zzae implements Creator<ValidateAccountRequest> {
   static void zza(ValidateAccountRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzre());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzakA, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable[])var0.zzrd(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Bundle)var0.zzrf(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.getCallingPackage(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzas(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbZ(var1);
   }

   public ValidateAccountRequest zzas(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Bundle var5 = null;
      Scope[] var6 = null;
      IBinder var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var9);
            break;
         case 4:
            var6 = (Scope[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9, Scope.CREATOR);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var9);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ValidateAccountRequest(var8, var2, var7, var6, var5, var3);
      }
   }

   public ValidateAccountRequest[] zzbZ(int var1) {
      return new ValidateAccountRequest[var1];
   }
}
