package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.model.a
public class class_904 implements Creator<CameraPosition> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.CameraPosition, android.os.Parcel, int) void
   static void method_5037(CameraPosition var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.target, var2, false);
      class_704.method_4029(var1, 3, var0.zoom);
      class_704.method_4029(var1, 4, var0.tilt);
      class_704.method_4029(var1, 5, var0.bearing);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5038(var1);
   }

   // $FF: renamed from: da (android.os.Parcel) com.google.android.gms.maps.model.CameraPosition
   public CameraPosition method_5038(Parcel var1) {
      float var2 = 0.0F;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      LatLng var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var5 = (LatLng)class_705.method_4061(var1, var8, LatLng.CREATOR);
            break;
         case 3:
            var7 = class_705.method_4078(var1, var8);
            break;
         case 4:
            var6 = class_705.method_4078(var1, var8);
            break;
         case 5:
            var2 = class_705.method_4078(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new CameraPosition(var4, var5, var7, var6, var2);
      }
   }

   // $FF: renamed from: eW (int) com.google.android.gms.maps.model.CameraPosition[]
   public CameraPosition[] method_5039(int var1) {
      return new CameraPosition[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5039(var1);
   }
}
