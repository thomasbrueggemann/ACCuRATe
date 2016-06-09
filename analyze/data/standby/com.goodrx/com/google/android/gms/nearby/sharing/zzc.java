package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.sharing.LocalContent;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.ViewableItem;

public class zzc implements Creator<SharedContent> {
   static void zza(SharedContent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.getUri(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable[])var0.zzEL(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable[])var0.zzEM(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgs(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjy(var1);
   }

   public SharedContent zzgs(Parcel var1) {
      LocalContent[] var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ViewableItem[] var5 = null;

      String var6;
      LocalContent[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         ViewableItem[] var9;
         String var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
         case 4:
         case 5:
         case 6:
         case 7:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 3:
            String var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var7);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 8:
            ViewableItem[] var12 = (ViewableItem[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7, ViewableItem.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 9:
            var8 = (LocalContent[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7, LocalContent.CREATOR);
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SharedContent(var4, var6, var5, var2);
      }
   }

   public SharedContent[] zzjy(int var1) {
      return new SharedContent[var1];
   }
}
