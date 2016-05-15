package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OnChangesResponse;
import java.util.ArrayList;

public class zzav implements Creator<OnChangesResponse> {
   static void zza(OnChangesResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzasb, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzasc, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzasd, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzase);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzby(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdt(var1);
   }

   public OnChangesResponse zzby(Parcel var1) {
      boolean var2 = false;
      ChangeSequenceNumber var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      DataHolder var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, DataHolder.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8, DriveId.CREATOR);
            break;
         case 4:
            var3 = (ChangeSequenceNumber)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, ChangeSequenceNumber.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new OnChangesResponse(var7, var6, var5, var3, var2);
      }
   }

   public OnChangesResponse[] zzdt(int var1) {
      return new OnChangesResponse[var1];
   }
}
