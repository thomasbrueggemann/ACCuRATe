package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// $FF: renamed from: com.google.android.gms.maps.model.t
public class class_883 implements Creator<StreetViewPanoramaOrientation> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaOrientation, android.os.Parcel, int) void
   static void method_4973(StreetViewPanoramaOrientation var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4029(var1, 2, var0.tilt);
      class_704.method_4029(var1, 3, var0.bearing);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4974(var1);
   }

   // $FF: renamed from: dl (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaOrientation
   public StreetViewPanoramaOrientation method_4974(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      float var5 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var5 = class_705.method_4078(var1, var6);
            break;
         case 3:
            var2 = class_705.method_4078(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaOrientation(var4, var5, var2);
      }
   }

   // $FF: renamed from: fh (int) com.google.android.gms.maps.model.StreetViewPanoramaOrientation[]
   public StreetViewPanoramaOrientation[] method_4975(int var1) {
      return new StreetViewPanoramaOrientation[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4975(var1);
   }
}
