package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.maps.model.o
public class class_895 implements Creator<PolylineOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.PolylineOptions, android.os.Parcel, int) void
   static void method_5015(PolylineOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.getPoints(), false);
      class_704.method_4029(var1, 3, var0.getWidth());
      class_704.method_4050(var1, 4, var0.getColor());
      class_704.method_4029(var1, 5, var0.getZIndex());
      class_704.method_4041(var1, 6, var0.isVisible());
      class_704.method_4041(var1, 7, var0.isGeodesic());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5016(var1);
   }

   // $FF: renamed from: dh (android.os.Parcel) com.google.android.gms.maps.model.PolylineOptions
   public PolylineOptions method_5016(Parcel var1) {
      float var2 = 0.0F;
      boolean var3 = false;
      int var4 = class_705.method_4059(var1);
      ArrayList var5 = null;
      boolean var6 = false;
      int var7 = 0;
      float var8 = 0.0F;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var5 = class_705.method_4068(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var8 = class_705.method_4078(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var10);
            break;
         case 5:
            var2 = class_705.method_4078(var1, var10);
            break;
         case 6:
            var6 = class_705.method_4069(var1, var10);
            break;
         case 7:
            var3 = class_705.method_4069(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new PolylineOptions(var9, var5, var8, var7, var2, var6, var3);
      }
   }

   // $FF: renamed from: fd (int) com.google.android.gms.maps.model.PolylineOptions[]
   public PolylineOptions[] method_5017(int var1) {
      return new PolylineOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5017(var1);
   }
}
