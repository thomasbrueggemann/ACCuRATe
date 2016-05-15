package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import java.util.ArrayList;

public class zzx implements Creator<SessionInsertRequest> {
   static void zza(SessionInsertRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getSession(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getDataSets(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getAggregateDataPoints(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfD(var1);
   }

   public SessionInsertRequest zzdC(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;
      ArrayList var6 = null;
      Session var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = (Session)zza.zza(var1, var8, Session.CREATOR);
            break;
         case 2:
            var6 = zza.zzc(var1, var8, DataSet.CREATOR);
            break;
         case 3:
            var5 = zza.zzc(var1, var8, DataPoint.CREATOR);
            break;
         case 4:
            var2 = zza.zzq(var1, var8);
            break;
         case 1000:
            var4 = zza.zzg(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionInsertRequest(var4, var7, var6, var5, var2);
      }
   }

   public SessionInsertRequest[] zzfD(int var1) {
      return new SessionInsertRequest[var1];
   }
}
