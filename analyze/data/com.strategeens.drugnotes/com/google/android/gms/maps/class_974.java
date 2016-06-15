package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

// $FF: renamed from: com.google.android.gms.maps.a
public class class_974 implements Creator<GoogleMapOptions> {
   // $FF: renamed from: a (com.google.android.gms.maps.GoogleMapOptions, android.os.Parcel, int) void
   static void method_5416(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4027(var1, 2, var0.method_1770());
      class_704.method_4027(var1, 3, var0.method_1771());
      class_704.method_4050(var1, 4, var0.getMapType());
      class_704.method_4034(var1, 5, var0.getCamera(), var2, false);
      class_704.method_4027(var1, 6, var0.method_1772());
      class_704.method_4027(var1, 7, var0.method_1773());
      class_704.method_4027(var1, 8, var0.method_1774());
      class_704.method_4027(var1, 9, var0.method_1775());
      class_704.method_4027(var1, 10, var0.method_1776());
      class_704.method_4027(var1, 11, var0.method_1777());
      class_704.method_4027(var1, 12, var0.method_1778());
      class_704.method_4027(var1, 14, var0.method_1779());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cX (android.os.Parcel) com.google.android.gms.maps.GoogleMapOptions
   public GoogleMapOptions method_5417(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      int var6 = 0;
      CameraPosition var7 = null;
      byte var8 = 0;
      byte var9 = 0;
      byte var10 = 0;
      byte var11 = 0;
      byte var12 = 0;
      byte var13 = 0;
      byte var14 = 0;
      byte var15 = 0;

      while(var1.dataPosition() < var2) {
         int var16 = class_705.method_4058(var1);
         switch(class_705.method_4065(var16)) {
         case 1:
            var3 = class_705.method_4073(var1, var16);
            break;
         case 2:
            var4 = class_705.method_4071(var1, var16);
            break;
         case 3:
            var5 = class_705.method_4071(var1, var16);
            break;
         case 4:
            var6 = class_705.method_4073(var1, var16);
            break;
         case 5:
            var7 = (CameraPosition)class_705.method_4061(var1, var16, CameraPosition.CREATOR);
            break;
         case 6:
            var8 = class_705.method_4071(var1, var16);
            break;
         case 7:
            var9 = class_705.method_4071(var1, var16);
            break;
         case 8:
            var10 = class_705.method_4071(var1, var16);
            break;
         case 9:
            var11 = class_705.method_4071(var1, var16);
            break;
         case 10:
            var12 = class_705.method_4071(var1, var16);
            break;
         case 11:
            var13 = class_705.method_4071(var1, var16);
            break;
         case 12:
            var14 = class_705.method_4071(var1, var16);
            break;
         case 13:
         default:
            class_705.method_4066(var1, var16);
            break;
         case 14:
            var15 = class_705.method_4071(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new GoogleMapOptions(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5417(var1);
   }

   // $FF: renamed from: eT (int) com.google.android.gms.maps.GoogleMapOptions[]
   public GoogleMapOptions[] method_5418(int var1) {
      return new GoogleMapOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5418(var1);
   }
}
