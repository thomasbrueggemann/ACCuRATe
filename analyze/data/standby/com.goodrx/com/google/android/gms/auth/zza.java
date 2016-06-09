package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;

public class zza implements Creator<AccountChangeEvent> {
   static void zza(AccountChangeEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersion);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzUZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzVa, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzVb);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzVc);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzVd, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzz(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzau(var1);
   }

   public AccountChangeEvent[] zzau(int var1) {
      return new AccountChangeEvent[var1];
   }

   public AccountChangeEvent zzz(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var5 = 0L;
      int var7 = 0;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AccountChangeEvent(var9, var5, var8, var7, var3, var2);
      }
   }
}
