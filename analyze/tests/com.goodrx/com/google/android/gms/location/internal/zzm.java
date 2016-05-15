package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import com.google.android.gms.location.internal.LocationRequestInternal;
import java.util.List;

public class zzm implements Creator<LocationRequestInternal> {
   static void zza(LocationRequestInternal var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzaBp, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzaOP);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzaOQ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaOR);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzaOS, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.mTag, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzaOT);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeX(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhD(var1);
   }

   public LocationRequestInternal zzeX(Parcel var1) {
      String var2 = null;
      boolean var3 = true;
      boolean var4 = false;
      int var5 = zza.zzau(var1);
      Object var6 = LocationRequestInternal.zzaOO;
      boolean var7 = var3;
      boolean var8 = false;
      LocationRequest var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var5) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var9 = (LocationRequest)zza.zza(var1, var11, LocationRequest.CREATOR);
            break;
         case 2:
            var8 = zza.zzc(var1, var11);
            break;
         case 3:
            var7 = zza.zzc(var1, var11);
            break;
         case 4:
            var3 = zza.zzc(var1, var11);
            break;
         case 5:
            var6 = zza.zzc(var1, var11, ClientIdentity.CREATOR);
            break;
         case 6:
            var2 = zza.zzp(var1, var11);
            break;
         case 7:
            var4 = zza.zzc(var1, var11);
            break;
         case 1000:
            var10 = zza.zzg(var1, var11);
            break;
         default:
            zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new LocationRequestInternal(var10, var9, var8, var7, var3, (List)var6, var2, var4);
      }
   }

   public LocationRequestInternal[] zzhD(int var1) {
      return new LocationRequestInternal[var1];
   }
}
