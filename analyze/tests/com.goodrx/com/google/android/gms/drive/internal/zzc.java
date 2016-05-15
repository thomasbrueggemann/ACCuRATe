package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;

public class zzc implements Creator<AuthorizeAccessRequest> {
   static void zza(AuthorizeAccessRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzaqe);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcR(var1);
   }

   public AuthorizeAccessRequest zzbb(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      DriveId var6 = null;

      while(var1.dataPosition() < var2) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var7);
            break;
         case 3:
            var6 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, DriveId.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new AuthorizeAccessRequest(var3, var4, var6);
      }
   }

   public AuthorizeAccessRequest[] zzcR(int var1) {
      return new AuthorizeAccessRequest[var1];
   }
}
