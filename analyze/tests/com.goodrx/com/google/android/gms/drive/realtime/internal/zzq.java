package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

public class zzq implements Creator<ParcelableCollaborator> {
   static void zza(ParcelableCollaborator var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzauI);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaeW);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzLq, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzrG, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzWQ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzauJ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzauK, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzew(var1);
   }

   public ParcelableCollaborator zzcA(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      boolean var9 = false;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableCollaborator(var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   public ParcelableCollaborator[] zzew(int var1) {
      return new ParcelableCollaborator[var1];
   }
}
