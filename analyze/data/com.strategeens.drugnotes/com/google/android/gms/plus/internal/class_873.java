package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_874;
import com.google.android.gms.plus.internal.h;

// $FF: renamed from: com.google.android.gms.plus.internal.i
public class class_873 implements Creator<h> {
   // $FF: renamed from: a (com.google.android.gms.plus.internal.h, android.os.Parcel, int) void
   static void method_4913(class_874 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getAccountName(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4045(var1, 2, var0.method_4924(), false);
      class_704.method_4045(var1, 3, var0.method_4916(), false);
      class_704.method_4045(var1, 4, var0.method_4917(), false);
      class_704.method_4038(var1, 5, var0.method_4918(), false);
      class_704.method_4038(var1, 6, var0.method_4919(), false);
      class_704.method_4038(var1, 7, var0.method_4920(), false);
      class_704.method_4038(var1, 8, var0.method_4921(), false);
      class_704.method_4034(var1, 9, var0.method_4922(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4914(var1);
   }

   // $FF: renamed from: dw (android.os.Parcel) com.google.android.gms.plus.internal.h
   public class_874 method_4914(Parcel var1) {
      PlusCommonExtras var2 = null;
      int var3 = class_705.method_4059(var1);
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
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var12 = class_705.method_4081(var1, var13);
            break;
         case 2:
            var11 = class_705.method_4053(var1, var13);
            break;
         case 3:
            var10 = class_705.method_4053(var1, var13);
            break;
         case 4:
            var9 = class_705.method_4053(var1, var13);
            break;
         case 5:
            var8 = class_705.method_4081(var1, var13);
            break;
         case 6:
            var7 = class_705.method_4081(var1, var13);
            break;
         case 7:
            var6 = class_705.method_4081(var1, var13);
            break;
         case 8:
            var5 = class_705.method_4081(var1, var13);
            break;
         case 9:
            var2 = (PlusCommonExtras)class_705.method_4061(var1, var13, PlusCommonExtras.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_874(var4, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: fu (int) com.google.android.gms.plus.internal.h[]
   public class_874[] method_4915(int var1) {
      return new class_874[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4915(var1);
   }
}
