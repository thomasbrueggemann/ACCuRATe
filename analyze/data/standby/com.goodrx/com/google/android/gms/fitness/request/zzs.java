package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;

public class zzs implements Creator<ListSubscriptionsRequest> {
   static void zza(ListSubscriptionsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdx(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfx(var1);
   }

   public ListSubscriptionsRequest zzdx(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;

      DataType var5;
      IBinder var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = zza.zzat(var1);
         DataType var8;
         int var9;
         switch(zza.zzca(var6)) {
         case 1:
            DataType var12 = (DataType)zza.zza(var1, var6, DataType.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = zza.zzq(var1, var6);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = zza.zzg(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ListSubscriptionsRequest(var4, var5, var2);
      }
   }

   public ListSubscriptionsRequest[] zzfx(int var1) {
      return new ListSubscriptionsRequest[var1];
   }
}
