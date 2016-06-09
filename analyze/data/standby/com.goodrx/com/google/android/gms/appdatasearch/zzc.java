package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentId;

public class zzc implements Creator<DocumentId> {
   static void zza(DocumentId var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.zzTJ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzTK, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzTL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzs(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaj(var1);
   }

   public DocumentId[] zzaj(int var1) {
      return new DocumentId[var1];
   }

   public DocumentId zzs(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DocumentId(var4, var6, var5, var2);
      }
   }
}
