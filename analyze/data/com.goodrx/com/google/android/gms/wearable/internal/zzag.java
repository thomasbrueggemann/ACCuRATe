package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.DeleteDataItemsResponse;

public class zzag implements Creator<DeleteDataItemsResponse> {
   static void zza(DeleteDataItemsResponse var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.statusCode);
      zzb.zzc(var1, 3, var0.zzbsz);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzim(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlQ(var1);
   }

   public DeleteDataItemsResponse zzim(Parcel var1) {
      int var2 = 0;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var5 = zza.zzg(var1, var6);
            break;
         case 2:
            var4 = zza.zzg(var1, var6);
            break;
         case 3:
            var2 = zza.zzg(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DeleteDataItemsResponse(var5, var4, var2);
      }
   }

   public DeleteDataItemsResponse[] zzlQ(int var1) {
      return new DeleteDataItemsResponse[var1];
   }
}
