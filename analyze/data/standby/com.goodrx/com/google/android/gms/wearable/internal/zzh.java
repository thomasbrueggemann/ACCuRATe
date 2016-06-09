package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;

public class zzh implements Creator<AncsNotificationParcelable> {
   static void zza(AncsNotificationParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zzc(var1, 2, var0.getId());
      zzb.zza(var1, 3, (String)var0.zzwK(), false);
      zzb.zza(var1, 4, (String)var0.zzIB(), false);
      zzb.zza(var1, 5, (String)var0.zzIC(), false);
      zzb.zza(var1, 6, (String)var0.getTitle(), false);
      zzb.zza(var1, 7, (String)var0.zzwc(), false);
      zzb.zza(var1, 8, (String)var0.getDisplayName(), false);
      zzb.zza(var1, 9, (byte)var0.zzID());
      zzb.zza(var1, 10, (byte)var0.zzIE());
      zzb.zza(var1, 11, (byte)var0.zzIF());
      zzb.zza(var1, 12, (byte)var0.zzIG());
      zzb.zza(var1, 13, (String)var0.getPackageName(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzid(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlE(var1);
   }

   public AncsNotificationParcelable zzid(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      byte var11 = 0;
      byte var12 = 0;
      byte var13 = 0;
      byte var14 = 0;
      String var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var3 = zza.zzg(var1, var16);
            break;
         case 2:
            var4 = zza.zzg(var1, var16);
            break;
         case 3:
            var5 = zza.zzp(var1, var16);
            break;
         case 4:
            var6 = zza.zzp(var1, var16);
            break;
         case 5:
            var7 = zza.zzp(var1, var16);
            break;
         case 6:
            var8 = zza.zzp(var1, var16);
            break;
         case 7:
            var9 = zza.zzp(var1, var16);
            break;
         case 8:
            var10 = zza.zzp(var1, var16);
            break;
         case 9:
            var11 = zza.zze(var1, var16);
            break;
         case 10:
            var12 = zza.zze(var1, var16);
            break;
         case 11:
            var13 = zza.zze(var1, var16);
            break;
         case 12:
            var14 = zza.zze(var1, var16);
            break;
         case 13:
            var15 = zza.zzp(var1, var16);
            break;
         default:
            zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AncsNotificationParcelable(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   public AncsNotificationParcelable[] zzlE(int var1) {
      return new AncsNotificationParcelable[var1];
   }
}
