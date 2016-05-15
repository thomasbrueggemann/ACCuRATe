package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;
import com.google.android.gms.drive.internal.AddEventListenerRequest;

public class zza implements Creator<AddEventListenerRequest> {
   static void zza(AddEventListenerRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzanf);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzapy, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzapY, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzapZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcP(var1);
   }

   public AddEventListenerRequest zzaZ(Parcel var1) {
      int var2 = 0;
      TransferProgressOptions var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      TransferStateOptions var5 = null;
      ChangesAvailableOptions var6 = null;
      DriveId var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DriveId.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 4:
            var6 = (ChangesAvailableOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, ChangesAvailableOptions.CREATOR);
            break;
         case 5:
            var5 = (TransferStateOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, TransferStateOptions.CREATOR);
            break;
         case 6:
            var3 = (TransferProgressOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, TransferProgressOptions.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AddEventListenerRequest(var8, var7, var2, var6, var5, var3);
      }
   }

   public AddEventListenerRequest[] zzcP(int var1) {
      return new AddEventListenerRequest[var1];
   }
}
