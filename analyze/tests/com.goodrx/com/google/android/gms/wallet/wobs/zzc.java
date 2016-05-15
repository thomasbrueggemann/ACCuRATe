package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wallet.wobs.LabelValue;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import java.util.ArrayList;

public class zzc implements Creator<LabelValueRow> {
   static void zza(LabelValueRow var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbqF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzbqG, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzbqH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlr(var1);
   }

   public LabelValueRow zzhQ(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = zzmn.zzsa();
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, LabelValue.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new LabelValueRow(var4, var6, var2, var5);
      }
   }

   public LabelValueRow[] zzlr(int var1) {
      return new LabelValueRow[var1];
   }
}
