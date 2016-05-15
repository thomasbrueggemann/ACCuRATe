package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.ArrayList;

public class zza implements Creator<Credential> {
   static void zza(Credential var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getProfilePictureUri(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getIdTokens(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getPassword(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.getAccountType(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.getGeneratedPassword(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzmx(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaz(var1);
   }

   public Credential zzE(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      ArrayList var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;

      while(var1.dataPosition() < var3) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 3:
            var9 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, Uri.CREATOR);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12, IdToken.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Credential(var4, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public Credential[] zzaz(int var1) {
      return new Credential[var1];
   }
}
