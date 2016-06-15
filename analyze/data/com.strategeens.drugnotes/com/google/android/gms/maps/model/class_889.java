package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// $FF: renamed from: com.google.android.gms.maps.model.e
public class class_889 implements Creator<GroundOverlayOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.GroundOverlayOptions, android.os.Parcel, int) void
   static void method_5003(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4032(var1, 2, var0.method_3955(), false);
      class_704.method_4034(var1, 3, var0.getLocation(), var2, false);
      class_704.method_4029(var1, 4, var0.getWidth());
      class_704.method_4029(var1, 5, var0.getHeight());
      class_704.method_4034(var1, 6, var0.getBounds(), var2, false);
      class_704.method_4029(var1, 7, var0.getBearing());
      class_704.method_4029(var1, 8, var0.getZIndex());
      class_704.method_4041(var1, 9, var0.isVisible());
      class_704.method_4029(var1, 10, var0.getTransparency());
      class_704.method_4029(var1, 11, var0.getAnchorU());
      class_704.method_4029(var1, 12, var0.getAnchorV());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5004(var1);
   }

   // $FF: renamed from: dc (android.os.Parcel) com.google.android.gms.maps.model.GroundOverlayOptions
   public GroundOverlayOptions method_5004(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      IBinder var4 = null;
      LatLng var5 = null;
      float var6 = 0.0F;
      float var7 = 0.0F;
      LatLngBounds var8 = null;
      float var9 = 0.0F;
      float var10 = 0.0F;
      boolean var11 = false;
      float var12 = 0.0F;
      float var13 = 0.0F;
      float var14 = 0.0F;

      while(var1.dataPosition() < var2) {
         int var15 = class_705.method_4058(var1);
         switch(class_705.method_4065(var15)) {
         case 1:
            var3 = class_705.method_4073(var1, var15);
            break;
         case 2:
            var4 = class_705.method_4082(var1, var15);
            break;
         case 3:
            var5 = (LatLng)class_705.method_4061(var1, var15, LatLng.CREATOR);
            break;
         case 4:
            var6 = class_705.method_4078(var1, var15);
            break;
         case 5:
            var7 = class_705.method_4078(var1, var15);
            break;
         case 6:
            var8 = (LatLngBounds)class_705.method_4061(var1, var15, LatLngBounds.CREATOR);
            break;
         case 7:
            var9 = class_705.method_4078(var1, var15);
            break;
         case 8:
            var10 = class_705.method_4078(var1, var15);
            break;
         case 9:
            var11 = class_705.method_4069(var1, var15);
            break;
         case 10:
            var12 = class_705.method_4078(var1, var15);
            break;
         case 11:
            var13 = class_705.method_4078(var1, var15);
            break;
         case 12:
            var14 = class_705.method_4078(var1, var15);
            break;
         default:
            class_705.method_4066(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new GroundOverlayOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: renamed from: eY (int) com.google.android.gms.maps.model.GroundOverlayOptions[]
   public GroundOverlayOptions[] method_5005(int var1) {
      return new GroundOverlayOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5005(var1);
   }
}
