package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kz
public class class_618 implements Creator<class_288.class_950> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt$c, android.os.Parcel, int) void
   static void method_3602(class_288.class_950 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1903();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3369(var1, 2, var0.getUrl(), true);
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bL (android.os.Parcel) com.google.android.gms.internal.kt$c
   public class_288.class_950 method_3603(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var2) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var4 = class_600.method_3402(var1, var6);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_600.method_3410(var1, var6);
            var3.add(Integer.valueOf(2));
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_288.class_950(var3, var4, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3603(var1);
   }

   // $FF: renamed from: di (int) com.google.android.gms.internal.kt$c[]
   public class_288.class_950[] method_3604(int var1) {
      return new class_288.class_950[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3604(var1);
   }
}
