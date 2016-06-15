package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.la
public class class_617 implements Creator<class_288.class_951> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$d, android.os.Parcel, int) void
   static void method_3599(class_288.class_951 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1901();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3369(var1, 2, var0.getFamilyName(), true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3369(var1, 3, var0.getFormatted(), true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3369(var1, 4, var0.getGivenName(), true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_599.method_3369(var1, 5, var0.getHonorificPrefix(), true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_599.method_3369(var1, 6, var0.getHonorificSuffix(), true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_599.method_3369(var1, 7, var0.getMiddleName(), true);
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bM (android.os.Parcel) com.google.android.gms.internal.kt$d
   public class_288.class_951 method_3600(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var5 = class_600.method_3402(var1, var11);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var10 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var9 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(3));
            break;
         case 4:
            var8 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(4));
            break;
         case 5:
            var7 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(6));
            break;
         case 7:
            var2 = class_600.method_3410(var1, var11);
            var4.add(Integer.valueOf(7));
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_288.class_951(var4, var5, var10, var9, var8, var7, var6, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3600(var1);
   }

   // $FF: renamed from: dj (int) com.google.android.gms.internal.kt$d[]
   public class_288.class_951[] method_3601(int var1) {
      return new class_288.class_951[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3601(var1);
   }
}
