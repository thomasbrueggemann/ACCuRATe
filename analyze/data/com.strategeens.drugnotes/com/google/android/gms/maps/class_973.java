package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.c
public class class_973 implements Creator<StreetViewPanoramaOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.StreetViewPanoramaOptions, android.os.Parcel, int) void
   static void method_5413(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getStreetViewPanoramaCamera(), var2, false);
      class_704.method_4038(var1, 3, var0.getPanoramaId(), false);
      class_704.method_4034(var1, 4, var0.getPosition(), var2, false);
      class_704.method_4036(var1, 5, var0.getRadius(), false);
      class_704.method_4027(var1, 6, var0.method_5381());
      class_704.method_4027(var1, 7, var0.method_5380());
      class_704.method_4027(var1, 8, var0.method_5382());
      class_704.method_4027(var1, 9, var0.method_5383());
      class_704.method_4027(var1, 10, var0.method_5379());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cY (android.os.Parcel) com.google.android.gms.maps.StreetViewPanoramaOptions
   public StreetViewPanoramaOptions method_5414(Parcel var1) {
      Integer var2 = null;
      byte var3 = 0;
      int var4 = class_705.method_4059(var1);
      byte var5 = 0;
      byte var6 = 0;
      byte var7 = 0;
      byte var8 = 0;
      LatLng var9 = null;
      String var10 = null;
      StreetViewPanoramaCamera var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var12 = class_705.method_4073(var1, var13);
            break;
         case 2:
            var11 = (StreetViewPanoramaCamera)class_705.method_4061(var1, var13, StreetViewPanoramaCamera.CREATOR);
            break;
         case 3:
            var10 = class_705.method_4081(var1, var13);
            break;
         case 4:
            var9 = (LatLng)class_705.method_4061(var1, var13, LatLng.CREATOR);
            break;
         case 5:
            var2 = class_705.method_4074(var1, var13);
            break;
         case 6:
            var8 = class_705.method_4071(var1, var13);
            break;
         case 7:
            var7 = class_705.method_4071(var1, var13);
            break;
         case 8:
            var6 = class_705.method_4071(var1, var13);
            break;
         case 9:
            var5 = class_705.method_4071(var1, var13);
            break;
         case 10:
            var3 = class_705.method_4071(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new StreetViewPanoramaOptions(var12, var11, var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5414(var1);
   }

   // $FF: renamed from: eU (int) com.google.android.gms.maps.StreetViewPanoramaOptions[]
   public StreetViewPanoramaOptions[] method_5415(int var1) {
      return new StreetViewPanoramaOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5415(var1);
   }
}
