package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.RemoveListenerRequest;

public class zzbg implements Creator<RemoveListenerRequest> {
   static void zza(RemoveListenerRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (IBinder)var0.zzIy(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzmj(var1);
   }

   public RemoveListenerRequest zziF(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      IBinder var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var3 = zza.zzg(var1, var5);
            break;
         case 2:
            var4 = zza.zzq(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new RemoveListenerRequest(var3, var4);
      }
   }

   public RemoveListenerRequest[] zzmj(int var1) {
      return new RemoveListenerRequest[var1];
   }
}
