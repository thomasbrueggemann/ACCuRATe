package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.model.q
public class class_901 implements Creator<StreetViewPanoramaCamera> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.StreetViewPanoramaCamera, android.os.Parcel, int) void
   static void method_5029(StreetViewPanoramaCamera var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4029(var1, 2, var0.zoom);
      class_704.method_4029(var1, 3, var0.tilt);
      class_704.method_4029(var1, 4, var0.bearing);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5030(var1);
   }

   // $FF: renamed from: di (android.os.Parcel) com.google.android.gms.maps.model.StreetViewPanoramaCamera
   public StreetViewPanoramaCamera method_5030(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_705.method_4059(var1);
      float var4 = 0.0F;
      int var5 = 0;
      float var6 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var4 = class_705.method_4078(var1, var7);
            break;
         case 3:
            var6 = class_705.method_4078(var1, var7);
            break;
         case 4:
            var2 = class_705.method_4078(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaCamera(var5, var4, var6, var2);
      }
   }

   // $FF: renamed from: fe (int) com.google.android.gms.maps.model.StreetViewPanoramaCamera[]
   public StreetViewPanoramaCamera[] method_5031(int var1) {
      return new StreetViewPanoramaCamera[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5031(var1);
   }
}
