package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.SessionReadRequest;
import java.util.ArrayList;

public class zzy implements Creator<SessionReadRequest> {
   static void zza(SessionReadRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getSessionName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getSessionId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzve());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzuP());
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 9, var0.getExcludedPackages(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfE(var1);
   }

   public SessionReadRequest zzdD(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      long var6 = 0L;
      long var8 = 0L;
      ArrayList var10 = null;
      ArrayList var11 = null;
      boolean var12 = false;
      boolean var13 = false;
      ArrayList var14 = null;
      IBinder var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = zza.zzat(var1);
         switch(zza.zzca(var16)) {
         case 1:
            var4 = zza.zzp(var1, var16);
            break;
         case 2:
            var5 = zza.zzp(var1, var16);
            break;
         case 3:
            var6 = zza.zzi(var1, var16);
            break;
         case 4:
            var8 = zza.zzi(var1, var16);
            break;
         case 5:
            var10 = zza.zzc(var1, var16, DataType.CREATOR);
            break;
         case 6:
            var11 = zza.zzc(var1, var16, DataSource.CREATOR);
            break;
         case 7:
            var12 = zza.zzc(var1, var16);
            break;
         case 8:
            var13 = zza.zzc(var1, var16);
            break;
         case 9:
            var14 = zza.zzD(var1, var16);
            break;
         case 10:
            var15 = zza.zzq(var1, var16);
            break;
         case 1000:
            var3 = zza.zzg(var1, var16);
            break;
         default:
            zza.zzb(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SessionReadRequest(var3, var4, var5, var6, var8, var10, var11, var12, var13, var14, var15);
      }
   }

   public SessionReadRequest[] zzfE(int var1) {
      return new SessionReadRequest[var1];
   }
}
