package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Field;

public class zzj implements Creator<Field> {
   static void zza(Field var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getFormat());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Boolean)var0.isOptional(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcW(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeV(var1);
   }

   public Field zzcW(Parcel var1) {
      Boolean var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzd(var1, var7);
            break;
         case 1000:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Field(var6, var5, var3, var2);
      }
   }

   public Field[] zzeV(int var1) {
      return new Field[var1];
   }
}
