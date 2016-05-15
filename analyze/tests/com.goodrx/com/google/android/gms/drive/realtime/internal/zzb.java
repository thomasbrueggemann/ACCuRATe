package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest;

public class zzb implements Creator<EndCompoundOperationRequest> {
   static void zza(EndCompoundOperationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcy(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzet(var1);
   }

   public EndCompoundOperationRequest zzcy(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var4)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new EndCompoundOperationRequest(var3);
      }
   }

   public EndCompoundOperationRequest[] zzet(int var1) {
      return new EndCompoundOperationRequest[var1];
   }
}
