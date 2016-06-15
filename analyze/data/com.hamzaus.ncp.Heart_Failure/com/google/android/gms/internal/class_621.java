package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kw
public class class_621 implements Creator<class_288.class_947> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$b, android.os.Parcel, int) void
   static void method_3611(class_288.class_947 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1894();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3365(var1, 2, var0.method_1891(), var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3365(var1, 3, var0.method_1892(), var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3381(var1, 4, var0.getLayout());
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bI (android.os.Parcel) com.google.android.gms.internal.kt$b
   public class_288.class_947 method_3612(Parcel var1) {
      class_288.class_949 var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      HashSet var5 = new HashSet();
      class_288.class_948 var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            class_288.class_948 var12 = (class_288.class_948)class_600.method_3390(var1, var8, class_288.class_948.CREATOR);
            var5.add(Integer.valueOf(2));
            var6 = var12;
            break;
         case 3:
            class_288.class_949 var10 = (class_288.class_949)class_600.method_3390(var1, var8, class_288.class_949.CREATOR);
            var5.add(Integer.valueOf(3));
            var2 = var10;
            break;
         case 4:
            var3 = class_600.method_3402(var1, var8);
            var5.add(Integer.valueOf(4));
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_288.class_947(var5, var7, var6, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3612(var1);
   }

   // $FF: renamed from: df (int) com.google.android.gms.internal.kt$b[]
   public class_288.class_947[] method_3613(int var1) {
      return new class_288.class_947[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3613(var1);
   }
}
