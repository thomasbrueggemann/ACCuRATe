package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.class_762;

// $FF: renamed from: com.google.android.gms.wearable.internal.al
public class class_761 implements Creator<ak> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ak, android.os.Parcel, int) void
   static void method_4334(class_762 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3369(var1, 2, var0.packageName, false);
      class_599.method_3369(var1, 3, var0.label, false);
      class_599.method_3361(var1, 4, var0.alY);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cG (android.os.Parcel) com.google.android.gms.wearable.internal.ak
   public class_762 method_4335(Parcel var1) {
      String var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var4 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var7 = class_600.method_3410(var1, var8);
            break;
         case 3:
            var2 = class_600.method_3410(var1, var8);
            break;
         case 4:
            var5 = class_600.method_3404(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_762(var4, var7, var2, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4335(var1);
   }

   // $FF: renamed from: ep (int) com.google.android.gms.wearable.internal.ak[]
   public class_762[] method_4336(int var1) {
      return new class_762[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4336(var1);
   }
}
