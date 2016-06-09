package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

public class zzg implements Creator<GetRecentContextCall.Response> {
   static void zza(GetRecentContextCall.Response var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzTY, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzTZ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String[])var0.zzUa, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzw(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzan(var1);
   }

   public GetRecentContextCall.Response[] zzan(int var1) {
      return new GetRecentContextCall.Response[var1];
   }

   public GetRecentContextCall.Response zzw(Parcel var1) {
      String[] var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;

      Status var6;
      String[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         ArrayList var9;
         Status var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            Status var14 = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Status.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 2:
            ArrayList var12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, UsageInfo.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GetRecentContextCall.Response(var4, var6, var5, var2);
      }
   }
}
