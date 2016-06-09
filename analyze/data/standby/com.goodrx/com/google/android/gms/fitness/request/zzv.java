package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public class zzv implements Creator<SensorRegistrationRequest> {
   static void zza(SensorRegistrationRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzvb(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaBi);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzaBj);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzux());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzuY());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.getIntent(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.zzuX());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 10, var0.getAccuracyMode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 11, var0.zzuZ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, var0.zzva());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfA(var1);
   }

   public SensorRegistrationRequest zzdA(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      DataSource var4 = null;
      DataType var5 = null;
      IBinder var6 = null;
      int var7 = 0;
      int var8 = 0;
      long var9 = 0L;
      long var11 = 0L;
      PendingIntent var13 = null;
      long var14 = 0L;
      int var16 = 0;
      ArrayList var17 = null;
      long var18 = 0L;
      IBinder var20 = null;

      while(var1.dataPosition() < var2) {
         int var21 = zza.zzat(var1);
         switch(zza.zzca(var21)) {
         case 1:
            var4 = (DataSource)zza.zza(var1, var21, DataSource.CREATOR);
            break;
         case 2:
            var5 = (DataType)zza.zza(var1, var21, DataType.CREATOR);
            break;
         case 3:
            var6 = zza.zzq(var1, var21);
            break;
         case 4:
            var7 = zza.zzg(var1, var21);
            break;
         case 5:
            var8 = zza.zzg(var1, var21);
            break;
         case 6:
            var9 = zza.zzi(var1, var21);
            break;
         case 7:
            var11 = zza.zzi(var1, var21);
            break;
         case 8:
            var13 = (PendingIntent)zza.zza(var1, var21, PendingIntent.CREATOR);
            break;
         case 9:
            var14 = zza.zzi(var1, var21);
            break;
         case 10:
            var16 = zza.zzg(var1, var21);
            break;
         case 11:
            var17 = zza.zzc(var1, var21, LocationRequest.CREATOR);
            break;
         case 12:
            var18 = zza.zzi(var1, var21);
            break;
         case 13:
            var20 = zza.zzq(var1, var21);
            break;
         case 1000:
            var3 = zza.zzg(var1, var21);
            break;
         default:
            zza.zzb(var1, var21);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SensorRegistrationRequest(var3, var4, var5, var6, var7, var8, var9, var11, var13, var14, var16, var17, var18, var20);
      }
   }

   public SensorRegistrationRequest[] zzfA(int var1) {
      return new SensorRegistrationRequest[var1];
   }
}
