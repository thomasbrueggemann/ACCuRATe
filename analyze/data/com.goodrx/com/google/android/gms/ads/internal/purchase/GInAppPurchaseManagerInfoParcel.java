package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.purchase.zza;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
   public static final zza CREATOR = new zza();
   public final int versionCode;
   public final zzgc zzFw;
   public final Context zzFx;
   public final zzj zzFy;
   public final zzk zzrI;

   GInAppPurchaseManagerInfoParcel(int var1, IBinder var2, IBinder var3, IBinder var4, IBinder var5) {
      this.versionCode = var1;
      this.zzrI = (zzk)com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(var2));
      this.zzFw = (zzgc)com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(var3));
      this.zzFx = (Context)com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(var4));
      this.zzFy = (zzj)com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(var5));
   }

   public static GInAppPurchaseManagerInfoParcel zzc(Intent var0) {
      try {
         Bundle var2 = var0.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         var2.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
         GInAppPurchaseManagerInfoParcel var3 = (GInAppPurchaseManagerInfoParcel)var2.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   IBinder zzfS() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzFy).asBinder();
   }

   IBinder zzfT() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzrI).asBinder();
   }

   IBinder zzfU() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzFw).asBinder();
   }

   IBinder zzfV() {
      return com.google.android.gms.dynamic.zze.zzC(this.zzFx).asBinder();
   }
}
