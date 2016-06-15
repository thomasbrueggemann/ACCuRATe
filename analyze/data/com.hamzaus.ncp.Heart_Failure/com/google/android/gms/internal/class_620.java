package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kx
public class class_620 implements Creator<class_288.class_948> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$b$a, android.os.Parcel, int) void
   static void method_3608(class_288.class_948 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1907();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3381(var1, 2, var0.getLeftImageOffset());
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3381(var1, 3, var0.getTopImageOffset());
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bJ (android.os.Parcel) com.google.android.gms.internal.kt$b$a
   public class_288.class_948 method_3609(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var6 = class_600.method_3402(var1, var7);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_600.method_3402(var1, var7);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var2 = class_600.method_3402(var1, var7);
            var4.add(Integer.valueOf(3));
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_288.class_948(var4, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3609(var1);
   }

   // $FF: renamed from: dg (int) com.google.android.gms.internal.kt$b$a[]
   public class_288.class_948[] method_3610(int var1) {
      return new class_288.class_948[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3610(var1);
   }
}
