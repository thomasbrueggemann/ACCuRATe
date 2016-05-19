package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class zzb implements Creator<AddPlaceRequest> {
   static void zza(AddPlaceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getLatLng(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getAddress(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (List)var0.getPlaceTypes(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.getPhoneNumber(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.getWebsiteUri(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfa(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzhI(var1);
   }

   public AddPlaceRequest zzfa(Parcel var1) {
      Uri var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      LatLng var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 2:
            var8 = (LatLng)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var10);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var2 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Uri.CREATOR);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new AddPlaceRequest(var4, var9, var8, var7, var6, var5, var2);
      }
   }

   public AddPlaceRequest[] zzhI(int var1) {
      return new AddPlaceRequest[var1];
   }
}
