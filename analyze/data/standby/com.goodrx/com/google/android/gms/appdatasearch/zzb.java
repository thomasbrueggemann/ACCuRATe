package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;

public class zzb implements Creator<DocumentContents> {
   static void zza(DocumentContents var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable[])var0.zzTC, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzTD, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzTE);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.account, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzr(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzai(var1);
   }

   public DocumentContents[] zzai(int var1) {
      return new DocumentContents[var1];
   }

   public DocumentContents zzr(Parcel var1) {
      boolean var2 = false;
      Account var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      DocumentSection[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var6 = (DocumentSection[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8, DocumentSection.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 4:
            var3 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, Account.CREATOR);
            break;
         case 1000:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DocumentContents(var7, var6, var5, var2, var3);
      }
   }
}
