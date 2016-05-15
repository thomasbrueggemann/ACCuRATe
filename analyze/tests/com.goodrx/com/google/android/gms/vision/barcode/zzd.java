package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<Barcode.CalendarEvent> {
   static void zza(Barcode.CalendarEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.summary, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.description, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.location, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.organizer, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.status, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.start, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.end, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkw(var1);
   }

   public Barcode.CalendarEvent zzgZ(Parcel var1) {
      Barcode.CalendarDateTime var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      Barcode.CalendarDateTime var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 7:
            var5 = (Barcode.CalendarDateTime)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, Barcode.CalendarDateTime.CREATOR);
            break;
         case 8:
            var2 = (Barcode.CalendarDateTime)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, Barcode.CalendarDateTime.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Barcode.CalendarEvent(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public Barcode.CalendarEvent[] zzkw(int var1) {
      return new Barcode.CalendarEvent[var1];
   }
}
