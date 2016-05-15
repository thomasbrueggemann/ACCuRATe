package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
   static void zza(GInAppPurchaseManagerInfoParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzfT(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.zzfU(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzfV(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (IBinder)var0.zzfS(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzh(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzA(var1);
   }

   public GInAppPurchaseManagerInfoParcel[] zzA(int var1) {
      return new GInAppPurchaseManagerInfoParcel[var1];
   }

   public GInAppPurchaseManagerInfoParcel zzh(Parcel var1) {
      IBinder var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      IBinder var5 = null;
      IBinder var6 = null;
      IBinder var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GInAppPurchaseManagerInfoParcel(var4, var7, var6, var5, var2);
      }
   }
}
