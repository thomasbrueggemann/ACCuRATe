package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;

public class zza implements Creator<ApplicationMetadata> {
   static void zza(ApplicationMetadata var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getApplicationId(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getImages(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 5, var0.getSupportedNamespaces(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.getSenderAppIdentifier(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zznx(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaW(var1);
   }

   public ApplicationMetadata zzZ(Parcel var1) {
      Uri var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      ArrayList var6 = null;
      ArrayList var7 = null;
      String var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10, WebImage.CREATOR);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var10);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 7:
            var2 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Uri.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ApplicationMetadata(var4, var9, var8, var7, var6, var5, var2);
      }
   }

   public ApplicationMetadata[] zzaW(int var1) {
      return new ApplicationMetadata[var1];
   }
}
