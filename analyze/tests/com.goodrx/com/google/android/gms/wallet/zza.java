package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.Address;

public class zza implements Creator<Address> {
   static void zza(Address var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzaMD, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzaME, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzaMF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzJU, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzbof, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzbog, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzaMK, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (String)var0.phoneNumber, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzaMM);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (String)var0.zzaMN, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzho(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkM(var1);
   }

   public Address zzho(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      boolean var13 = false;
      String var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var15);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new Address(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   public Address[] zzkM(int var1) {
      return new Address[var1];
   }
}
