package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.search.GoogleNowAuthState;

public class zza implements Creator<GoogleNowAuthState> {
   static void zza(GoogleNowAuthState var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getAuthCode(), false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zza(var1, 2, (String)var0.getAccessToken(), false);
      zzb.zza(var1, 3, var0.getNextAllowedTimeMillis());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjX(var1);
   }

   public GoogleNowAuthState zzgQ(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var8);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GoogleNowAuthState(var4, var7, var2, var5);
      }
   }

   public GoogleNowAuthState[] zzjX(int var1) {
      return new GoogleNowAuthState[var1];
   }
}
