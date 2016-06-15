package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

// $FF: renamed from: com.google.android.gms.maps.model.g
public class class_887 implements Creator<LatLngBounds> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, android.os.Parcel, int) void
   static void method_4999(LatLngBounds var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.southwest, var2, false);
      class_704.method_4034(var1, 3, var0.northeast, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5000(var1);
   }

   // $FF: renamed from: dd (android.os.Parcel) com.google.android.gms.maps.model.LatLngBounds
   public LatLngBounds method_5000(Parcel var1) {
      LatLng var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      LatLng var5;
      LatLng var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         LatLng var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            LatLng var10 = (LatLng)class_705.method_4061(var1, var6, LatLng.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = (LatLng)class_705.method_4061(var1, var6, LatLng.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new LatLngBounds(var4, var5, var2);
      }
   }

   // $FF: renamed from: eZ (int) com.google.android.gms.maps.model.LatLngBounds[]
   public LatLngBounds[] method_5001(int var1) {
      return new LatLngBounds[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5001(var1);
   }
}
