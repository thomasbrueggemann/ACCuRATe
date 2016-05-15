package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import java.util.ArrayList;

public class zzo implements Creator<PlaceLocalization> {
   static void zza(PlaceLocalization var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.name, false);
      zzb.zzc(var1, 1000, var0.versionCode);
      zzb.zza(var1, 2, (String)var0.address, false);
      zzb.zza(var1, 3, (String)var0.zzaQO, false);
      zzb.zza(var1, 4, (String)var0.zzaQP, false);
      zzb.zzb(var1, 5, var0.zzaQQ, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzia(var1);
   }

   public PlaceLocalization zzfn(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var9);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PlaceLocalization(var4, var8, var7, var6, var5, var2);
      }
   }

   public PlaceLocalization[] zzia(int var1) {
      return new PlaceLocalization[var1];
   }
}
