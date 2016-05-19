package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;

public class zzb implements Creator<GetConsentIntentRequest> {
   static void zza(GetConsentIntentRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getCallingPackage(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getCallingUid());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzmt(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.getAccount(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable[])var0.zzVR, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzmu());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzmv());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzmw(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzay(var1);
   }

   public GetConsentIntentRequest zzD(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      ScopeDetail[] var6 = null;
      Account var7 = null;
      String var8 = null;
      int var9 = 0;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 5:
            var7 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, Account.CREATOR);
            break;
         case 6:
            var6 = (ScopeDetail[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12, ScopeDetail.CREATOR);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new GetConsentIntentRequest(var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public GetConsentIntentRequest[] zzay(int var1) {
      return new GetConsentIntentRequest[var1];
   }
}
