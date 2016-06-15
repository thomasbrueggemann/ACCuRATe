package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_344;
import com.google.android.gms.internal.jj;

// $FF: renamed from: com.google.android.gms.internal.jk
public class class_343 implements Creator<jj> {
   // $FF: renamed from: a (com.google.android.gms.internal.jj, android.os.Parcel, int) void
   static void method_2356(class_344 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.version);
      class_704.method_4050(var1, 2, var0.field_967);
      class_704.method_4050(var1, 3, var0.field_968);
      class_704.method_4038(var1, 4, var0.field_969, false);
      class_704.method_4032(var1, 5, var0.field_970, false);
      class_704.method_4044(var1, 6, var0.field_971, var2, false);
      class_704.method_4031(var1, 7, var0.field_972, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: D (android.os.Parcel) com.google.android.gms.internal.jj
   public class_344 method_2357(Parcel var1) {
      int var2 = 0;
      Bundle var3 = null;
      int var4 = class_705.method_4059(var1);
      Scope[] var5 = null;
      IBinder var6 = null;
      String var7 = null;
      int var8 = 0;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var8 = class_705.method_4073(var1, var10);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var10);
            break;
         case 5:
            var6 = class_705.method_4082(var1, var10);
            break;
         case 6:
            var5 = (Scope[])class_705.method_4067(var1, var10, Scope.CREATOR);
            break;
         case 7:
            var3 = class_705.method_4083(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_344(var9, var8, var2, var7, var6, var5, var3);
      }
   }

   // $FF: renamed from: aC (int) com.google.android.gms.internal.jj[]
   public class_344[] method_2358(int var1) {
      return new class_344[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2357(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2358(var1);
   }
}
