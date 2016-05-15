package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<Barcode.ContactInfo> {
   static void zza(Barcode.ContactInfo var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.name, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.organization, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.title, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable[])var0.phones, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable[])var0.emails, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String[])var0.urls, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable[])var0.addresses, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzha(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkx(var1);
   }

   public Barcode.ContactInfo zzha(Parcel var1) {
      Barcode.Address[] var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String[] var5 = null;
      Barcode.Email[] var6 = null;
      Barcode.Phone[] var7 = null;
      String var8 = null;
      String var9 = null;
      Barcode.PersonName var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var10 = (Barcode.PersonName)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, Barcode.PersonName.CREATOR);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = (Barcode.Phone[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11, Barcode.Phone.CREATOR);
            break;
         case 6:
            var6 = (Barcode.Email[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11, Barcode.Email.CREATOR);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var11);
            break;
         case 8:
            var2 = (Barcode.Address[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11, Barcode.Address.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Barcode.ContactInfo(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public Barcode.ContactInfo[] zzkx(int var1) {
      return new Barcode.ContactInfo[var1];
   }
}
