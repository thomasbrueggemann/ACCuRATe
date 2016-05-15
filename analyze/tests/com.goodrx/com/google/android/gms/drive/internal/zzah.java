package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.internal.GetChangesRequest;
import java.util.ArrayList;

public class zzah implements Creator<GetChangesRequest> {
   static void zza(GetChangesRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzarJ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzarK);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzapB, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzarL);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbr(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdm(var1);
   }

   public GetChangesRequest zzbr(Parcel var1) {
      ArrayList var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      ChangeSequenceNumber var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = (ChangeSequenceNumber)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, ChangeSequenceNumber.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8, DriveSpace.CREATOR);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new GetChangesRequest(var7, var6, var5, var2, var3);
      }
   }

   public GetChangesRequest[] zzdm(int var1) {
      return new GetChangesRequest[var1];
   }
}
