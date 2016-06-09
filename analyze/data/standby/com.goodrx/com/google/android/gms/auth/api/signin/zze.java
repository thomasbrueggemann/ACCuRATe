package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

public class zze implements Creator<SignInAccount> {
   static void zza(SignInAccount var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzmT(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getIdToken(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getEmail(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getDisplayName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.getPhotoUrl(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzmV(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.getUserId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzmW(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzT(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaO(var1);
   }

   public SignInAccount zzT(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = "";
      GoogleSignInAccount var6 = null;
      Uri var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;

      while(var1.dataPosition() < var3) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 6:
            var7 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, Uri.CREATOR);
            break;
         case 7:
            var6 = (GoogleSignInAccount)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, GoogleSignInAccount.CREATOR);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 9:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SignInAccount(var4, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public SignInAccount[] zzaO(int var1) {
      return new SignInAccount[var1];
   }
}
