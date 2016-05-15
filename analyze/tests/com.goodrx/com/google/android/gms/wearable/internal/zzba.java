package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.MessageEventParcelable;

public class zzba implements Creator<MessageEventParcelable> {
   static void zza(MessageEventParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zzc(var1, 2, var0.getRequestId());
      zzb.zza(var1, 3, (String)var0.getPath(), false);
      zzb.zza(var1, 4, (byte[])var0.getData(), false);
      zzb.zza(var1, 5, (String)var0.getSourceNodeId(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zziA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzme(var1);
   }

   public MessageEventParcelable zziA(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = zza.zzau(var1);
      byte[] var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var7 = zza.zzg(var1, var8);
            break;
         case 2:
            var2 = zza.zzg(var1, var8);
            break;
         case 3:
            var6 = zza.zzp(var1, var8);
            break;
         case 4:
            var5 = zza.zzs(var1, var8);
            break;
         case 5:
            var3 = zza.zzp(var1, var8);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new MessageEventParcelable(var7, var2, var6, var5, var3);
      }
   }

   public MessageEventParcelable[] zzme(int var1) {
      return new MessageEventParcelable[var1];
   }
}
