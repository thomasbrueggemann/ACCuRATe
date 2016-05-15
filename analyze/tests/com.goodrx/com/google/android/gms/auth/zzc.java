package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import java.util.ArrayList;

public class zzc implements Creator<AccountChangeEventsResponse> {
   static void zza(AccountChangeEventsResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersion);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzpH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaw(var1);
   }

   public AccountChangeEventsResponse zzB(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var5);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var5, AccountChangeEvent.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AccountChangeEventsResponse(var3, var4);
      }
   }

   public AccountChangeEventsResponse[] zzaw(int var1) {
      return new AccountChangeEventsResponse[var1];
   }
}
