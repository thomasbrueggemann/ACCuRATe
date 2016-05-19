package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public class zzp implements Creator<SignInConfiguration> {
   static void zza(SignInConfiguration var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zznk(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzmR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zznl(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zznm(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zznn(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzV(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaQ(var1);
   }

   public SignInConfiguration zzV(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      GoogleSignInOptions var5 = null;
      EmailSignInOptions var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 4:
            var6 = (EmailSignInOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, EmailSignInOptions.CREATOR);
            break;
         case 5:
            var5 = (GoogleSignInOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, GoogleSignInOptions.CREATOR);
            break;
         case 6:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SignInConfiguration(var4, var8, var7, var6, var5, var2);
      }
   }

   public SignInConfiguration[] zzaQ(int var1) {
      return new SignInConfiguration[var1];
   }
}
