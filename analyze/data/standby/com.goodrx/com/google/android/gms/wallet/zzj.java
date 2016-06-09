package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.LineItem;

public class zzj implements Creator<LineItem> {
   static void zza(LineItem var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.description, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzboL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzboM, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzboh, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzboN);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzboi, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhx(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkV(var1);
   }

   public LineItem zzhx(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new LineItem(var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public LineItem[] zzkV(int var1) {
      return new LineItem[var1];
   }
}
