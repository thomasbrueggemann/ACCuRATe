package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.model.c
public class class_902 implements Creator<CircleOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.CircleOptions, android.os.Parcel, int) void
   static void method_5032(CircleOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getCenter(), var2, false);
      class_704.method_4028(var1, 3, var0.getRadius());
      class_704.method_4029(var1, 4, var0.getStrokeWidth());
      class_704.method_4050(var1, 5, var0.getStrokeColor());
      class_704.method_4050(var1, 6, var0.getFillColor());
      class_704.method_4029(var1, 7, var0.getZIndex());
      class_704.method_4041(var1, 8, var0.isVisible());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5033(var1);
   }

   // $FF: renamed from: db (android.os.Parcel) com.google.android.gms.maps.model.CircleOptions
   public CircleOptions method_5033(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = class_705.method_4059(var1);
      LatLng var5 = null;
      double var6 = 0.0D;
      int var8 = 0;
      int var9 = 0;
      float var10 = 0.0F;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4073(var1, var12);
            break;
         case 2:
            var5 = (LatLng)class_705.method_4061(var1, var12, LatLng.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4079(var1, var12);
            break;
         case 4:
            var10 = class_705.method_4078(var1, var12);
            break;
         case 5:
            var9 = class_705.method_4073(var1, var12);
            break;
         case 6:
            var8 = class_705.method_4073(var1, var12);
            break;
         case 7:
            var2 = class_705.method_4078(var1, var12);
            break;
         case 8:
            var3 = class_705.method_4069(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CircleOptions(var11, var5, var6, var10, var9, var8, var2, var3);
      }
   }

   // $FF: renamed from: eX (int) com.google.android.gms.maps.model.CircleOptions[]
   public CircleOptions[] method_5034(int var1) {
      return new CircleOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5034(var1);
   }
}
