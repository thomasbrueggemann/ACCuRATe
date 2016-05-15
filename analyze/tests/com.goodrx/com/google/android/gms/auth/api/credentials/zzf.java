package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<PasswordSpecification> {
   static void zza(PasswordSpecification var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.zzWn, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 2, var0.zzWo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (List)var0.zzWp, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzWq);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzWr);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzJ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaE(var1);
   }

   public PasswordSpecification zzJ(Parcel var1) {
      ArrayList var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      ArrayList var6 = null;
      String var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var9);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 1000:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PasswordSpecification(var8, var7, var6, var2, var5, var3);
      }
   }

   public PasswordSpecification[] zzaE(int var1) {
      return new PasswordSpecification[var1];
   }
}
