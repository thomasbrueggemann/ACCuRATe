package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
   static void zza(ActivityRecognitionResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzaNu, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzaNv);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaNw);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaNx);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Bundle)var0.extras, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   public ActivityRecognitionResult createFromParcel(Parcel var1) {
      long var2 = 0L;
      Bundle var4 = null;
      int var5 = 0;
      int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var7 = var2;
      ArrayList var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var6) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11, DetectedActivity.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var11);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var11);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 5:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var11);
            break;
         case 1000:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new ActivityRecognitionResult(var10, var9, var7, var2, var5, var4);
      }
   }

   public ActivityRecognitionResult[] newArray(int var1) {
      return new ActivityRecognitionResult[var1];
   }
}
