package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_677;
import com.google.android.gms.plus.internal.h;

// $FF: renamed from: com.google.android.gms.plus.internal.j
public class class_675 implements Creator<h> {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.h, android.os.Parcel, int) void
   static void method_3932(class_677 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getAccountName(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3376(var1, 2, var0.method_3937(), false);
      class_599.method_3376(var1, 3, var0.method_3938(), false);
      class_599.method_3376(var1, 4, var0.method_3939(), false);
      class_599.method_3369(var1, 5, var0.method_3940(), false);
      class_599.method_3369(var1, 6, var0.method_3941(), false);
      class_599.method_3369(var1, 7, var0.method_3942(), false);
      class_599.method_3369(var1, 8, var0.method_3943(), false);
      class_599.method_3365(var1, 9, var0.method_3944(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bD (android.os.Parcel) com.google.android.gms.plus.internal.h
   public class_677 method_3933(Parcel var1) {
      PlusCommonExtras var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String[] var9 = null;
      String[] var10 = null;
      String[] var11 = null;
      String var12 = null;

      while(var1.dataPosition() < var3) {
         int var13 = class_600.method_3383(var1);
         switch(class_600.method_3394(var13)) {
         case 1:
            var12 = class_600.method_3410(var1, var13);
            break;
         case 2:
            var11 = class_600.method_3384(var1, var13);
            break;
         case 3:
            var10 = class_600.method_3384(var1, var13);
            break;
         case 4:
            var9 = class_600.method_3384(var1, var13);
            break;
         case 5:
            var8 = class_600.method_3410(var1, var13);
            break;
         case 6:
            var7 = class_600.method_3410(var1, var13);
            break;
         case 7:
            var6 = class_600.method_3410(var1, var13);
            break;
         case 8:
            var5 = class_600.method_3410(var1, var13);
            break;
         case 9:
            var2 = (PlusCommonExtras)class_600.method_3390(var1, var13, PlusCommonExtras.CREATOR);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var13);
            break;
         default:
            class_600.method_3395(var1, var13);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_677(var4, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3933(var1);
   }

   // $FF: renamed from: da (int) com.google.android.gms.plus.internal.h[]
   public class_677[] method_3934(int var1) {
      return new class_677[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3934(var1);
   }
}
