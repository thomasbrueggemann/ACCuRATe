package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

public class zzi implements Creator<GetServiceRequest> {
   static void zza(GetServiceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.version);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzall);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzalm);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzaln, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (IBinder)var0.zzalo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable[])var0.zzalp, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Bundle)var0.zzalq, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.zzalr, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzao(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbR(var1);
   }

   public GetServiceRequest zzao(Parcel var1) {
      int var2 = 0;
      Account var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Bundle var5 = null;
      Scope[] var6 = null;
      IBinder var7 = null;
      String var8 = null;
      int var9 = 0;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var11);
            break;
         case 6:
            var6 = (Scope[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11, Scope.CREATOR);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var11);
            break;
         case 8:
            var3 = (Account)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, Account.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new GetServiceRequest(var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   public GetServiceRequest[] zzbR(int var1) {
      return new GetServiceRequest[var1];
   }
}
