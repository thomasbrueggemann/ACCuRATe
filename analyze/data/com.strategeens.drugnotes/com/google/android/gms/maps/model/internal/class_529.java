package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.internal.a;
import com.google.android.gms.maps.model.internal.class_526;

// $FF: renamed from: com.google.android.gms.maps.model.internal.b
public class class_529 implements Creator<a> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.a, android.os.Parcel, int) void
   static void method_3253(class_526 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4027(var1, 2, var0.method_3245());
      class_704.method_4031(var1, 3, var0.method_3246(), false);
      class_704.method_4034(var1, 4, var0.getBitmap(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3254(var1);
   }

   // $FF: renamed from: dp (android.os.Parcel) com.google.android.gms.maps.model.internal.a
   public class_526 method_3254(Parcel var1) {
      Bitmap var2 = null;
      byte var3 = 0;
      int var4 = class_705.method_4059(var1);
      Bundle var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var3 = class_705.method_4071(var1, var7);
            break;
         case 3:
            var5 = class_705.method_4083(var1, var7);
            break;
         case 4:
            var2 = (Bitmap)class_705.method_4061(var1, var7, Bitmap.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_526(var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: fl (int) com.google.android.gms.maps.model.internal.a[]
   public class_526[] method_3255(int var1) {
      return new class_526[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3255(var1);
   }
}
