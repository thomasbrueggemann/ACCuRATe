package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public class zzb implements Creator<GoogleSignInAccount> {
   static void zza(GoogleSignInAccount var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getIdToken(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.getEmail(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getDisplayName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.getPhotoUrl(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.getServerAuthCode(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzmK());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzmL(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.zzVs, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzR(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaM(var1);
   }

   public GoogleSignInAccount zzR(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;
      String var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      String var13 = null;

      while(var1.dataPosition() < var3) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 2:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 6:
            var9 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var14, Uri.CREATOR);
            break;
         case 7:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var14);
            break;
         case 9:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14, Scope.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GoogleSignInAccount(var4, var13, var12, var11, var10, var9, var8, var5, var7, var2);
      }
   }

   public GoogleSignInAccount[] zzaM(int var1) {
      return new GoogleSignInAccount[var1];
   }
}
