package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.Tile;

// $FF: renamed from: com.google.android.gms.maps.model.u
public class class_882 implements Creator<Tile> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.Tile, android.os.Parcel, int) void
   static void method_4970(Tile var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.width);
      class_704.method_4050(var1, 3, var0.height);
      class_704.method_4042(var1, 4, var0.data, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4971(var1);
   }

   // $FF: renamed from: dm (android.os.Parcel) com.google.android.gms.maps.model.Tile
   public Tile method_4971(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      byte[] var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var7);
            break;
         case 4:
            var4 = class_705.method_4084(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new Tile(var6, var5, var2, var4);
      }
   }

   // $FF: renamed from: fi (int) com.google.android.gms.maps.model.Tile[]
   public Tile[] method_4972(int var1) {
      return new Tile[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4972(var1);
   }
}
