package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.NodeParcelable;

public class zzbc implements Creator<NodeParcelable> {
   static void zza(NodeParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (String)var0.getId(), false);
      zzb.zza(var1, 3, (String)var0.getDisplayName(), false);
      zzb.zzc(var1, 4, var0.getHopCount());
      zzb.zza(var1, 5, var0.isNearby());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmf(var1);
   }

   public NodeParcelable zziB(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = zza.zzg(var1, var8);
            break;
         case 2:
            var6 = zza.zzp(var1, var8);
            break;
         case 3:
            var2 = zza.zzp(var1, var8);
            break;
         case 4:
            var5 = zza.zzg(var1, var8);
            break;
         case 5:
            var3 = zza.zzc(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new NodeParcelable(var7, var6, var2, var5, var3);
      }
   }

   public NodeParcelable[] zzmf(int var1) {
      return new NodeParcelable[var1];
   }
}
