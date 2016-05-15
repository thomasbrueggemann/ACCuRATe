package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public class zzf implements Creator<RecordConsentRequest> {
   static void zza(RecordConsentRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getAccount(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable[])var0.zzFM(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzmR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgT(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkb(var1);
   }

   public RecordConsentRequest zzgT(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      Scope[] var5 = null;

      Account var6;
      String var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         Scope[] var9;
         Account var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Account var14 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Account.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            Scope[] var12 = (Scope[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7, Scope.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new RecordConsentRequest(var4, var6, var5, var2);
      }
   }

   public RecordConsentRequest[] zzkb(int var1) {
      return new RecordConsentRequest[var1];
   }
}
