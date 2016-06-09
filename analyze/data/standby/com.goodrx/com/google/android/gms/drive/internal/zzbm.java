package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm implements Creator<OpenFileIntentSenderRequest> {
   static void zza(OpenFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzapg, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String[])var0.zzaph, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzapj, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzasz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbO(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdJ(var1);
   }

   public OpenFileIntentSenderRequest zzbO(Parcel var1) {
      FilterHolder var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      DriveId var5 = null;
      String[] var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var8);
            break;
         case 4:
            var5 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, DriveId.CREATOR);
            break;
         case 5:
            var2 = (FilterHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, FilterHolder.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new OpenFileIntentSenderRequest(var4, var7, var6, var5, var2);
      }
   }

   public OpenFileIntentSenderRequest[] zzdJ(int var1) {
      return new OpenFileIntentSenderRequest[var1];
   }
}
