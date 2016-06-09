package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import java.util.ArrayList;

public class zzh implements Creator<ListSubscriptionsResult> {
   static void zza(ListSubscriptionsResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getSubscriptions(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdU(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfV(var1);
   }

   public ListSubscriptionsResult zzdU(Parcel var1) {
      Status var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6, Subscription.CREATOR);
            break;
         case 2:
            var2 = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, Status.CREATOR);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ListSubscriptionsResult(var4, var5, var2);
      }
   }

   public ListSubscriptionsResult[] zzfV(int var1) {
      return new ListSubscriptionsResult[var1];
   }
}
