package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.lb
public class class_616 implements Creator<class_288.class_953> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$f, android.os.Parcel, int) void
   static void method_3596(class_288.class_953 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1905();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3369(var1, 2, var0.getDepartment(), true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3369(var1, 3, var0.getDescription(), true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3369(var1, 4, var0.getEndDate(), true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_599.method_3369(var1, 5, var0.getLocation(), true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_599.method_3369(var1, 6, var0.getName(), true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_599.method_3372(var1, 7, var0.isPrimary());
      }

      if(var4.contains(Integer.valueOf(8))) {
         class_599.method_3369(var1, 8, var0.getStartDate(), true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         class_599.method_3369(var1, 9, var0.getTitle(), true);
      }

      if(var4.contains(Integer.valueOf(10))) {
         class_599.method_3381(var1, 10, var0.getType());
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bN (android.os.Parcel) com.google.android.gms.internal.kt$f
   public class_288.class_953 method_3597(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      HashSet var5 = new HashSet();
      String var6 = null;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = class_600.method_3383(var1);
         switch(class_600.method_3394(var14)) {
         case 1:
            var13 = class_600.method_3402(var1, var14);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            var12 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(2));
            break;
         case 3:
            var11 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(3));
            break;
         case 4:
            var10 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(4));
            break;
         case 5:
            var9 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(5));
            break;
         case 6:
            var8 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(6));
            break;
         case 7:
            var7 = class_600.method_3398(var1, var14);
            var5.add(Integer.valueOf(7));
            break;
         case 8:
            var6 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(8));
            break;
         case 9:
            var3 = class_600.method_3410(var1, var14);
            var5.add(Integer.valueOf(9));
            break;
         case 10:
            var2 = class_600.method_3402(var1, var14);
            var5.add(Integer.valueOf(10));
            break;
         default:
            class_600.method_3395(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_288.class_953(var5, var13, var12, var11, var10, var9, var8, var7, var6, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3597(var1);
   }

   // $FF: renamed from: dk (int) com.google.android.gms.internal.kt$f[]
   public class_288.class_953[] method_3598(int var1) {
      return new class_288.class_953[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3598(var1);
   }
}
