package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public class zzc implements Creator<GoogleSignInOptions> {
   static void zza(GoogleSignInOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzmN(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getAccount(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzmO());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzmP());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzmQ());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzmR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzmS(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaN(var1);
   }

   public GoogleSignInOptions zzS(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      boolean var6 = false;
      boolean var7 = false;
      Account var8 = null;
      ArrayList var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11, Scope.CREATOR);
            break;
         case 3:
            var8 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, Account.CREATOR);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new GoogleSignInOptions(var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }

   public GoogleSignInOptions[] zzaN(int var1) {
      return new GoogleSignInOptions[var1];
   }
}
