package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;

public class zzc implements Creator<FieldWithSortOrder> {
   static void zza(FieldWithSortOrder var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.zzasF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzauj);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzei(var1);
   }

   public FieldWithSortOrder zzcn(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6);
            break;
         case 1000:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FieldWithSortOrder(var5, var4, var2);
      }
   }

   public FieldWithSortOrder[] zzei(int var1) {
      return new FieldWithSortOrder[var1];
   }
}
