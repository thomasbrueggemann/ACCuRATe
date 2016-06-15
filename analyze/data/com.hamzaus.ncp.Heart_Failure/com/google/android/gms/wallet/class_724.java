package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.Address;

// $FF: renamed from: com.google.android.gms.wallet.a
public class class_724 implements Creator<Address> {
   // $FF: renamed from: a (com.google.android.gms.wallet.Address, android.os.Parcel, int) void
   static void method_4104(Address var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.name, false);
      class_599.method_3369(var1, 3, var0.field_3229, false);
      class_599.method_3369(var1, 4, var0.field_3230, false);
      class_599.method_3369(var1, 5, var0.field_3231, false);
      class_599.method_3369(var1, 6, var0.field_3236, false);
      class_599.method_3369(var1, 7, var0.aiF, false);
      class_599.method_3369(var1, 8, var0.aiG, false);
      class_599.method_3369(var1, 9, var0.field_3232, false);
      class_599.method_3369(var1, 10, var0.field_3233, false);
      class_599.method_3372(var1, 11, var0.field_3234);
      class_599.method_3369(var1, 12, var0.field_3235, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bQ (android.os.Parcel) com.google.android.gms.wallet.Address
   public Address method_4105(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      boolean var13 = false;
      String var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = class_600.method_3383(var1);
         switch(class_600.method_3394(var15)) {
         case 1:
            var3 = class_600.method_3402(var1, var15);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var15);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var15);
            break;
         case 4:
            var6 = class_600.method_3410(var1, var15);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var15);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var15);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var15);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var15);
            break;
         case 9:
            var11 = class_600.method_3410(var1, var15);
            break;
         case 10:
            var12 = class_600.method_3410(var1, var15);
            break;
         case 11:
            var13 = class_600.method_3398(var1, var15);
            break;
         case 12:
            var14 = class_600.method_3410(var1, var15);
            break;
         default:
            class_600.method_3395(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new Address(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4105(var1);
   }

   // $FF: renamed from: dw (int) com.google.android.gms.wallet.Address[]
   public Address[] method_4106(int var1) {
      return new Address[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4106(var1);
   }
}
