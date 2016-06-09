package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;

public class zzb implements Creator<AccountChangeEventsRequest> {
   static void zza(AccountChangeEventsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersion);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzVc);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzVa, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzTI, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzav(var1);
   }

   public AccountChangeEventsRequest zzA(Parcel var1) {
      Account var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 4:
            var2 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Account.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AccountChangeEventsRequest(var6, var3, var5, var2);
      }
   }

   public AccountChangeEventsRequest[] zzav(int var1) {
      return new AccountChangeEventsRequest[var1];
   }
}
