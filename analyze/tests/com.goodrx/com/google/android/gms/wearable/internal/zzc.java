package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.AddListenerRequest;

public class zzc implements Creator<AddListenerRequest> {
   static void zza(AddListenerRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (IBinder)var0.zzIy(), false);
      zzb.zza(var1, 3, (Parcelable[])var0.zzbrC, var2, false);
      zzb.zza(var1, 4, (String)var0.zzbrD, false);
      zzb.zza(var1, 5, (String)var0.zzbrE, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzia(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlB(var1);
   }

   public AddListenerRequest zzia(Parcel var1) {
      String var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      IntentFilter[] var6 = null;
      IBinder var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var4 = zza.zzg(var1, var8);
            break;
         case 2:
            var7 = zza.zzq(var1, var8);
            break;
         case 3:
            var6 = (IntentFilter[])zza.zzb(var1, var8, IntentFilter.CREATOR);
            break;
         case 4:
            var5 = zza.zzp(var1, var8);
            break;
         case 5:
            var2 = zza.zzp(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AddListenerRequest(var4, var7, var6, var5, var2);
      }
   }

   public AddListenerRequest[] zzlB(int var1) {
      return new AddListenerRequest[var1];
   }
}
