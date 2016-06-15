package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.identity.intents.model.UserAddress;

// $FF: renamed from: com.google.android.gms.identity.intents.model.b
public class class_662 implements Creator<UserAddress> {
   // $FF: renamed from: a (com.google.android.gms.identity.intents.model.UserAddress, android.os.Parcel, int) void
   static void method_3810(UserAddress var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.name, false);
      class_599.method_3369(var1, 3, var0.field_3637, false);
      class_599.method_3369(var1, 4, var0.field_3638, false);
      class_599.method_3369(var1, 5, var0.field_3639, false);
      class_599.method_3369(var1, 6, var0.field_3640, false);
      class_599.method_3369(var1, 7, var0.field_3641, false);
      class_599.method_3369(var1, 8, var0.field_3642, false);
      class_599.method_3369(var1, 9, var0.field_3643, false);
      class_599.method_3369(var1, 10, var0.field_3650, false);
      class_599.method_3369(var1, 11, var0.field_3644, false);
      class_599.method_3369(var1, 12, var0.field_3645, false);
      class_599.method_3369(var1, 13, var0.field_3646, false);
      class_599.method_3372(var1, 14, var0.field_3647);
      class_599.method_3369(var1, 15, var0.field_3648, false);
      class_599.method_3369(var1, 16, var0.field_3649, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: br (android.os.Parcel) com.google.android.gms.identity.intents.model.UserAddress
   public UserAddress method_3811(Parcel var1) {
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
      String var13 = null;
      String var14 = null;
      String var15 = null;
      boolean var16 = false;
      String var17 = null;
      String var18 = null;

      while(var1.dataPosition() < var2) {
         int var19 = class_600.method_3383(var1);
         switch(class_600.method_3394(var19)) {
         case 1:
            var3 = class_600.method_3402(var1, var19);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var19);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var19);
            break;
         case 4:
            var6 = class_600.method_3410(var1, var19);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var19);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var19);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var19);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var19);
            break;
         case 9:
            var11 = class_600.method_3410(var1, var19);
            break;
         case 10:
            var12 = class_600.method_3410(var1, var19);
            break;
         case 11:
            var13 = class_600.method_3410(var1, var19);
            break;
         case 12:
            var14 = class_600.method_3410(var1, var19);
            break;
         case 13:
            var15 = class_600.method_3410(var1, var19);
            break;
         case 14:
            var16 = class_600.method_3398(var1, var19);
            break;
         case 15:
            var17 = class_600.method_3410(var1, var19);
            break;
         case 16:
            var18 = class_600.method_3410(var1, var19);
            break;
         default:
            class_600.method_3395(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new UserAddress(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
      }
   }

   // $FF: renamed from: cE (int) com.google.android.gms.identity.intents.model.UserAddress[]
   public UserAddress[] method_3812(int var1) {
      return new UserAddress[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3811(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3812(var1);
   }
}
