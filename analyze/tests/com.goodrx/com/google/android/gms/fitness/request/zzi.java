package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import java.util.ArrayList;

public class zzi implements Creator<DataTypeCreateRequest> {
   static void zza(DataTypeCreateRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getFields(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdo(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfo(var1);
   }

   public DataTypeCreateRequest zzdo(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = zza.zzat(var1);
         switch(zza.zzca(var7)) {
         case 1:
            var6 = zza.zzp(var1, var7);
            break;
         case 2:
            var5 = zza.zzc(var1, var7, Field.CREATOR);
            break;
         case 3:
            var2 = zza.zzq(var1, var7);
            break;
         case 1000:
            var4 = zza.zzg(var1, var7);
            break;
         default:
            zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DataTypeCreateRequest(var4, var6, var5, var2);
      }
   }

   public DataTypeCreateRequest[] zzfo(int var1) {
      return new DataTypeCreateRequest[var1];
   }
}
