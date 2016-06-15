package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.class_287;
import com.google.android.gms.internal.kq;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kr
public class class_624 implements Creator<kq> {
   // $FF: renamed from: a (com.google.android.gms.internal.kq, android.os.Parcel, int) void
   static void method_3620(class_287 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1927();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3369(var1, 2, var0.getId(), true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3365(var1, 4, var0.method_1928(), var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_599.method_3369(var1, 5, var0.getStartDate(), true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_599.method_3365(var1, 6, var0.method_1929(), var2, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_599.method_3369(var1, 7, var0.getType(), true);
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bF (android.os.Parcel) com.google.android.gms.internal.kq
   public class_287 method_3621(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      class_286 var6 = null;
      String var7 = null;
      class_286 var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var5 = class_600.method_3402(var1, var10);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var9 = class_600.method_3410(var1, var10);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
         default:
            class_600.method_3395(var1, var10);
            break;
         case 4:
            class_286 var15 = (class_286)class_600.method_3390(var1, var10, class_286.CREATOR);
            var4.add(Integer.valueOf(4));
            var8 = var15;
            break;
         case 5:
            var7 = class_600.method_3410(var1, var10);
            var4.add(Integer.valueOf(5));
            break;
         case 6:
            class_286 var12 = (class_286)class_600.method_3390(var1, var10, class_286.CREATOR);
            var4.add(Integer.valueOf(6));
            var6 = var12;
            break;
         case 7:
            var2 = class_600.method_3410(var1, var10);
            var4.add(Integer.valueOf(7));
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_287(var4, var5, var9, var8, var7, var6, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3621(var1);
   }

   // $FF: renamed from: dc (int) com.google.android.gms.internal.kq[]
   public class_287[] method_3622(int var1) {
      return new class_287[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3622(var1);
   }
}
