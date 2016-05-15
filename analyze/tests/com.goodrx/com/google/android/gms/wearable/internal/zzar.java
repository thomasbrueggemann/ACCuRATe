package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.DataItemParcelable;
import com.google.android.gms.wearable.internal.GetDataItemResponse;

public class zzar implements Creator<GetDataItemResponse> {
   static void zza(GetDataItemResponse var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.statusCode);
      zzb.zza(var1, 3, (Parcelable)var0.zzbsJ, var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzix(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmb(var1);
   }

   public GetDataItemResponse zzix(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      DataItemParcelable var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzg(var1, var6);
            break;
         case 2:
            var2 = zza.zzg(var1, var6);
            break;
         case 3:
            var4 = (DataItemParcelable)zza.zza(var1, var6, DataItemParcelable.CREATOR);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GetDataItemResponse(var5, var2, var4);
      }
   }

   public GetDataItemResponse[] zzmb(int var1) {
      return new GetDataItemResponse[var1];
   }
}
