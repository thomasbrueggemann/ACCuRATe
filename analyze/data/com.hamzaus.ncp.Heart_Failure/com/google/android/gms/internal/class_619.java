package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.ky
public class class_619 implements Creator<class_288.class_949> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$b$b, android.os.Parcel, int) void
   static void method_3605(class_288.class_949 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1909();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3381(var1, 2, var0.getHeight());
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3369(var1, 3, var0.getUrl(), true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3381(var1, 4, var0.getWidth());
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bK (android.os.Parcel) com.google.android.gms.internal.kt$b$b
   public class_288.class_949 method_3606(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      HashSet var4 = new HashSet();
      String var5 = null;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var6 = class_600.method_3402(var1, var8);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var5 = class_600.method_3410(var1, var8);
            var4.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = class_600.method_3402(var1, var8);
            var4.add(Integer.valueOf(4));
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_288.class_949(var4, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3606(var1);
   }

   // $FF: renamed from: dh (int) com.google.android.gms.internal.kt$b$b[]
   public class_288.class_949[] method_3607(int var1) {
      return new class_288.class_949[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3607(var1);
   }
}
