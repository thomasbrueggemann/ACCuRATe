package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Permission;

public class zzj implements Creator<Permission> {
   static void zza(Permission var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzsO(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzsP());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzsQ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzsR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getRole());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzsS());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaM(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcB(var1);
   }

   public Permission zzaM(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = 0;
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
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Permission(var9, var8, var7, var6, var2, var5, var3);
      }
   }

   public Permission[] zzcB(int var1) {
      return new Permission[var1];
   }
}
