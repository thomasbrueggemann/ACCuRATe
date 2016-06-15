package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.class_773;

// $FF: renamed from: com.google.android.gms.wearable.internal.ag
public class class_768 implements Creator<af> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.af, android.os.Parcel, int) void
   static void method_4347(class_773 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4117);
      class_599.method_3381(var1, 2, var0.getRequestId());
      class_599.method_3369(var1, 3, var0.getPath(), false);
      class_599.method_3373(var1, 4, var0.getData(), false);
      class_599.method_3369(var1, 5, var0.getSourceNodeId(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cE (android.os.Parcel) com.google.android.gms.wearable.internal.af
   public class_773 method_4348(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      byte[] var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var2 = class_600.method_3402(var1, var8);
            break;
         case 3:
            var6 = class_600.method_3410(var1, var8);
            break;
         case 4:
            var5 = class_600.method_3413(var1, var8);
            break;
         case 5:
            var3 = class_600.method_3410(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_773(var7, var2, var6, var5, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4348(var1);
   }

   // $FF: renamed from: en (int) com.google.android.gms.wearable.internal.af[]
   public class_773[] method_4349(int var1) {
      return new class_773[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4349(var1);
   }
}
