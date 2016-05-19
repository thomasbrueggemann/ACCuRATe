package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public class zzl implements Creator<PlaceImpl> {
   static void zza(PlaceImpl var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getId(), false);
      zzb.zza(var1, 2, (Bundle)var0.zzzt(), false);
      zzb.zza(var1, 3, (Parcelable)var0.zzzv(), var2, false);
      zzb.zza(var1, 4, (Parcelable)var0.getLatLng(), var2, false);
      zzb.zza(var1, 5, var0.zzzo());
      zzb.zza(var1, 6, (Parcelable)var0.getViewport(), var2, false);
      zzb.zza(var1, 7, (String)var0.zzzu(), false);
      zzb.zza(var1, 8, (Parcelable)var0.getWebsiteUri(), var2, false);
      zzb.zza(var1, 9, var0.zzzr());
      zzb.zza(var1, 10, var0.getRating());
      zzb.zzc(var1, 11, var0.getPriceLevel());
      zzb.zza(var1, 12, var0.zzzs());
      zzb.zza(var1, 13, (List)var0.zzzn(), false);
      zzb.zza(var1, 14, (String)var0.getAddress(), false);
      zzb.zza(var1, 15, (String)var0.getPhoneNumber(), false);
      zzb.zzb(var1, 17, var0.zzzq(), false);
      zzb.zza(var1, 16, (String)var0.zzzp(), false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zza(var1, 19, (String)var0.getName(), false);
      zzb.zza(var1, 20, (List)var0.getPlaceTypes(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhY(var1);
   }

   public PlaceImpl zzfl(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      ArrayList var5 = null;
      ArrayList var6 = null;
      Bundle var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      ArrayList var12 = null;
      LatLng var13 = null;
      float var14 = 0.0F;
      LatLngBounds var15 = null;
      String var16 = null;
      Uri var17 = null;
      boolean var18 = false;
      float var19 = 0.0F;
      int var20 = 0;
      long var21 = 0L;
      PlaceLocalization var23 = null;

      while(var1.dataPosition() < var2) {
         int var24 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var24)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var24);
            break;
         case 3:
            var23 = (PlaceLocalization)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var24, PlaceLocalization.CREATOR);
            break;
         case 4:
            var13 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var24, LatLng.CREATOR);
            break;
         case 5:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var24);
            break;
         case 6:
            var15 = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var24, LatLngBounds.CREATOR);
            break;
         case 7:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 8:
            var17 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var24, Uri.CREATOR);
            break;
         case 9:
            var18 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var24);
            break;
         case 10:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var24);
            break;
         case 11:
            var20 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var24);
            break;
         case 12:
            var21 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var24);
            break;
         case 13:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var24);
            break;
         case 14:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 15:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 16:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 17:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var24);
            break;
         case 19:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var24);
            break;
         case 20:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var24);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var24);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var24);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new PlaceImpl(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var23);
      }
   }

   public PlaceImpl[] zzhY(int var1) {
      return new PlaceImpl[var1];
   }
}
