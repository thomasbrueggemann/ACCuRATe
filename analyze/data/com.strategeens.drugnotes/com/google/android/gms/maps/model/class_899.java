package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

// $FF: renamed from: com.google.android.gms.maps.model.s
public class class_899 implements Creator<StreetViewPanoramaLocation> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaLocation, android.os.Parcel, int) void
   static void method_5025(StreetViewPanoramaLocation var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4044(var1, 2, var0.links, var2, false);
      class_704.method_4034(var1, 3, var0.position, var2, false);
      class_704.method_4038(var1, 4, var0.panoId, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5026(var1);
   }

   // $FF: renamed from: dk (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaLocation
   public StreetViewPanoramaLocation method_5026(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      LatLng var5 = null;

      StreetViewPanoramaLink[] var6;
      String var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_705.method_4058(var1);
         LatLng var9;
         StreetViewPanoramaLink[] var10;
         int var11;
         switch(class_705.method_4065(var7)) {
         case 1:
            int var16 = class_705.method_4073(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            StreetViewPanoramaLink[] var14 = (StreetViewPanoramaLink[])class_705.method_4067(var1, var7, StreetViewPanoramaLink.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            LatLng var12 = (LatLng)class_705.method_4061(var1, var7, LatLng.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = class_705.method_4081(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         default:
            class_705.method_4066(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaLocation(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: fg (int) com.google.android.gms.maps.model.StreetViewPanoramaLocation[]
   public StreetViewPanoramaLocation[] method_5027(int var1) {
      return new StreetViewPanoramaLocation[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5027(var1);
   }
}
