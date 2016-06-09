package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import java.util.ArrayList;

public class zzk implements Creator<RealtimeDocumentSyncRequest> {
   static void zza(RealtimeDocumentSyncRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 2, var0.zzapq, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 3, var0.zzapr, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaN(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcC(var1);
   }

   public RealtimeDocumentSyncRequest zzaN(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new RealtimeDocumentSyncRequest(var4, var5, var2);
      }
   }

   public RealtimeDocumentSyncRequest[] zzcC(int var1) {
      return new RealtimeDocumentSyncRequest[var1];
   }
}
