package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.EventEntity;

public class EventEntityCreator implements Creator<EventEntity> {
   static void zza(EventEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getEventId(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String)var0.getName(), false);
      zzb.zza(var1, 3, (String)var0.getDescription(), false);
      zzb.zza(var1, 4, (Parcelable)var0.getIconImageUri(), var2, false);
      zzb.zza(var1, 5, (String)var0.getIconImageUrl(), false);
      zzb.zza(var1, 6, (Parcelable)var0.getPlayer(), var2, false);
      zzb.zza(var1, 7, var0.getValue());
      zzb.zza(var1, 8, (String)var0.getFormattedValue(), false);
      zzb.zza(var1, 9, var0.isVisible());
      zzb.zzI(var1, var3);
   }

   public EventEntity createFromParcel(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = zza.zzau(var1);
      long var5 = 0L;
      PlayerEntity var7 = null;
      String var8 = null;
      Uri var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = zza.zzat(var1);
         switch(zza.zzca(var14)) {
         case 1:
            var12 = zza.zzp(var1, var14);
            break;
         case 2:
            var11 = zza.zzp(var1, var14);
            break;
         case 3:
            var10 = zza.zzp(var1, var14);
            break;
         case 4:
            var9 = (Uri)zza.zza(var1, var14, Uri.CREATOR);
            break;
         case 5:
            var8 = zza.zzp(var1, var14);
            break;
         case 6:
            var7 = (PlayerEntity)zza.zza(var1, var14, PlayerEntity.CREATOR);
            break;
         case 7:
            var5 = zza.zzi(var1, var14);
            break;
         case 8:
            var3 = zza.zzp(var1, var14);
            break;
         case 9:
            var2 = zza.zzc(var1, var14);
            break;
         case 1000:
            var13 = zza.zzg(var1, var14);
            break;
         default:
            zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new EventEntity(var13, var12, var11, var10, var9, var8, var7, var5, var3, var2);
      }
   }

   public EventEntity[] newArray(int var1) {
      return new EventEntity[var1];
   }
}
