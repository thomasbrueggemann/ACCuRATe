package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.class_172;

// $FF: renamed from: com.google.android.gms.internal.an
public class class_173 implements Creator<am> {
   // $FF: renamed from: a (com.google.android.gms.internal.am, android.os.Parcel, int) void
   static void method_1268(class_172 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3369(var1, 2, var0.field_569, false);
      class_599.method_3381(var1, 3, var0.height);
      class_599.method_3381(var1, 4, var0.heightPixels);
      class_599.method_3372(var1, 5, var0.field_570);
      class_599.method_3381(var1, 6, var0.width);
      class_599.method_3381(var1, 7, var0.widthPixels);
      class_599.method_3375(var1, 8, var0.field_571, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: c (android.os.Parcel) com.google.android.gms.internal.am
   public class_172 method_1269(Parcel var1) {
      class_172[] var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      boolean var6 = false;
      int var7 = 0;
      int var8 = 0;
      String var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var10 = class_600.method_3402(var1, var11);
            break;
         case 2:
            var9 = class_600.method_3410(var1, var11);
            break;
         case 3:
            var8 = class_600.method_3402(var1, var11);
            break;
         case 4:
            var7 = class_600.method_3402(var1, var11);
            break;
         case 5:
            var6 = class_600.method_3398(var1, var11);
            break;
         case 6:
            var5 = class_600.method_3402(var1, var11);
            break;
         case 7:
            var3 = class_600.method_3402(var1, var11);
            break;
         case 8:
            var2 = (class_172[])class_600.method_3396(var1, var11, class_172.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new class_172(var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1269(var1);
   }

   // $FF: renamed from: d (int) com.google.android.gms.internal.am[]
   public class_172[] method_1270(int var1) {
      return new class_172[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1270(var1);
   }
}
