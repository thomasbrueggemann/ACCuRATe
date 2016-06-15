package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.maps.model.Tile;

public class TileCreator implements Creator<Tile> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.maps.model.Tile, android.os.Parcel, int) void
   static void method_2685(Tile var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.width);
      class_599.method_3381(var1, 3, var0.height);
      class_599.method_3373(var1, 4, var0.data, false);
      class_599.method_3357(var1, var3);
   }

   public Tile createFromParcel(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      byte[] var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var6 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var5 = class_600.method_3402(var1, var7);
            break;
         case 3:
            var2 = class_600.method_3402(var1, var7);
            break;
         case 4:
            var4 = class_600.method_3413(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new Tile(var6, var5, var2, var4);
      }
   }

   public Tile[] newArray(int var1) {
      return new Tile[var1];
   }
}
