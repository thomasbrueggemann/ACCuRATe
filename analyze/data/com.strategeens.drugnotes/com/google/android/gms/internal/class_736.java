package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_740;

// $FF: renamed from: com.google.android.gms.internal.kt
public class class_736 implements Creator<class_726.class_1680> {
   // $FF: renamed from: a (com.google.android.gms.internal.kr$a, android.os.Parcel, int) void
   static void method_4278(class_726.class_1680 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.method_5319());
      class_704.method_4041(var1, 3, var0.method_5322());
      class_704.method_4050(var1, 4, var0.method_5320());
      class_704.method_4041(var1, 5, var0.method_5323());
      class_704.method_4038(var1, 6, var0.method_5324(), false);
      class_704.method_4050(var1, 7, var0.method_5325());
      class_704.method_4038(var1, 8, var0.method_5327(), false);
      class_704.method_4034(var1, 9, var0.method_5329(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: M (android.os.Parcel) com.google.android.gms.internal.kr$a
   public class_726.class_1680 method_4279(Parcel var1) {
      class_740 var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      int var8 = 0;
      boolean var9 = false;
      int var10 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4073(var1, var12);
            break;
         case 2:
            var10 = class_705.method_4073(var1, var12);
            break;
         case 3:
            var9 = class_705.method_4069(var1, var12);
            break;
         case 4:
            var8 = class_705.method_4073(var1, var12);
            break;
         case 5:
            var7 = class_705.method_4069(var1, var12);
            break;
         case 6:
            var6 = class_705.method_4081(var1, var12);
            break;
         case 7:
            var3 = class_705.method_4073(var1, var12);
            break;
         case 8:
            var5 = class_705.method_4081(var1, var12);
            break;
         case 9:
            var2 = (class_740)class_705.method_4061(var1, var12, class_740.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_726.class_1680(var11, var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: aN (int) com.google.android.gms.internal.kr$a[]
   public class_726.class_1680[] method_4280(int var1) {
      return new class_726.class_1680[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4279(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4280(var1);
   }
}
