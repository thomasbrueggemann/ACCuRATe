package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.ProvideContentRequest;
import java.util.ArrayList;

public class zzf implements Creator<ProvideContentRequest> {
   static void zza(ProvideContentRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzbdk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.zzEP(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzbdm, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzbdn);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (IBinder)var0.zzED(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjA(var1);
   }

   public ProvideContentRequest zzgu(Parcel var1) {
      IBinder var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      ArrayList var7 = null;
      IBinder var8 = null;
      IBinder var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10, SharedContent.CREATOR);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ProvideContentRequest(var4, var9, var8, var7, var5, var2);
      }
   }

   public ProvideContentRequest[] zzjA(int var1) {
      return new ProvideContentRequest[var1];
   }
}
