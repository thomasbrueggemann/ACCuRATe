package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

public class zzz implements Creator<ResolveAccountResponse> {
   static void zza(ResolveAccountResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (IBinder)var0.zzakA, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzqY(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzqZ());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzra());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaq(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbX(var1);
   }

   public ResolveAccountResponse zzaq(Parcel var1) {
      ConnectionResult var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      IBinder var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var8);
            break;
         case 3:
            var2 = (ConnectionResult)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, ConnectionResult.CREATOR);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ResolveAccountResponse(var7, var6, var2, var5, var3);
      }
   }

   public ResolveAccountResponse[] zzbX(int var1) {
      return new ResolveAccountResponse[var1];
   }
}
