package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// $FF: renamed from: com.google.android.gms.maps.model.k
public class class_891 implements Creator<MarkerOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.MarkerOptions, android.os.Parcel, int) void
   static void method_5007(MarkerOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getPosition(), var2, false);
      class_704.method_4038(var1, 3, var0.getTitle(), false);
      class_704.method_4038(var1, 4, var0.getSnippet(), false);
      class_704.method_4032(var1, 5, var0.method_3224(), false);
      class_704.method_4029(var1, 6, var0.getAnchorU());
      class_704.method_4029(var1, 7, var0.getAnchorV());
      class_704.method_4041(var1, 8, var0.isDraggable());
      class_704.method_4041(var1, 9, var0.isVisible());
      class_704.method_4041(var1, 10, var0.isFlat());
      class_704.method_4029(var1, 11, var0.getRotation());
      class_704.method_4029(var1, 12, var0.getInfoWindowAnchorU());
      class_704.method_4029(var1, 13, var0.getInfoWindowAnchorV());
      class_704.method_4029(var1, 14, var0.getAlpha());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5008(var1);
   }

   // $FF: renamed from: df (android.os.Parcel) com.google.android.gms.maps.model.MarkerOptions
   public MarkerOptions method_5008(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      LatLng var4 = null;
      String var5 = null;
      String var6 = null;
      IBinder var7 = null;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      float var13 = 0.0F;
      float var14 = 0.5F;
      float var15 = 0.0F;
      float var16 = 1.0F;

      while(var1.dataPosition() < var2) {
         int var17 = class_705.method_4058(var1);
         switch(class_705.method_4065(var17)) {
         case 1:
            var3 = class_705.method_4073(var1, var17);
            break;
         case 2:
            var4 = (LatLng)class_705.method_4061(var1, var17, LatLng.CREATOR);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var17);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var17);
            break;
         case 5:
            var7 = class_705.method_4082(var1, var17);
            break;
         case 6:
            var8 = class_705.method_4078(var1, var17);
            break;
         case 7:
            var9 = class_705.method_4078(var1, var17);
            break;
         case 8:
            var10 = class_705.method_4069(var1, var17);
            break;
         case 9:
            var11 = class_705.method_4069(var1, var17);
            break;
         case 10:
            var12 = class_705.method_4069(var1, var17);
            break;
         case 11:
            var13 = class_705.method_4078(var1, var17);
            break;
         case 12:
            var14 = class_705.method_4078(var1, var17);
            break;
         case 13:
            var15 = class_705.method_4078(var1, var17);
            break;
         case 14:
            var16 = class_705.method_4078(var1, var17);
            break;
         default:
            class_705.method_4066(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new MarkerOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   // $FF: renamed from: fb (int) com.google.android.gms.maps.model.MarkerOptions[]
   public MarkerOptions[] method_5009(int var1) {
      return new MarkerOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5009(var1);
   }
}
