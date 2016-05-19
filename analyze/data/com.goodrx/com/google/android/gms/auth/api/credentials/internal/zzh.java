package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<GeneratePasswordRequest> {
   static void zza(GeneratePasswordRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.zzmr(), var2, false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzL(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaG(var1);
   }

   public GeneratePasswordRequest zzL(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      PasswordSpecification var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = (PasswordSpecification)zza.zza(var1, var5, PasswordSpecification.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GeneratePasswordRequest(var3, var4);
      }
   }

   public GeneratePasswordRequest[] zzaG(int var1) {
      return new GeneratePasswordRequest[var1];
   }
}
