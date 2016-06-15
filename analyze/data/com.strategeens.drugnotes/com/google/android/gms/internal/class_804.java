package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_814;
import com.google.android.gms.internal.ov;

// $FF: renamed from: com.google.android.gms.internal.ow
public class class_804 implements Creator<ov> {
   // $FF: renamed from: a (com.google.android.gms.internal.ov, android.os.Parcel, int) void
   static void method_4446(class_814 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4038(var1, 2, var0.packageName, false);
      class_704.method_4050(var1, 3, var0.ang);
      class_704.method_4050(var1, 4, var0.anh);
      class_704.method_4038(var1, 5, var0.ani, false);
      class_704.method_4038(var1, 6, var0.anj, false);
      class_704.method_4041(var1, 7, var0.ank);
      class_704.method_4038(var1, 8, var0.anl, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4447(var1);
   }

   // $FF: renamed from: du (android.os.Parcel) com.google.android.gms.internal.ov
   public class_814 method_4447(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      boolean var5 = true;
      String var6 = null;
      String var7 = null;
      int var8 = 0;
      String var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var10 = class_705.method_4073(var1, var11);
            break;
         case 2:
            var9 = class_705.method_4081(var1, var11);
            break;
         case 3:
            var8 = class_705.method_4073(var1, var11);
            break;
         case 4:
            var2 = class_705.method_4073(var1, var11);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var11);
            break;
         case 6:
            var6 = class_705.method_4081(var1, var11);
            break;
         case 7:
            var5 = class_705.method_4069(var1, var11);
            break;
         case 8:
            var3 = class_705.method_4081(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_814(var10, var9, var8, var2, var7, var6, var5, var3);
      }
   }

   // $FF: renamed from: fr (int) com.google.android.gms.internal.ov[]
   public class_814[] method_4448(int var1) {
      return new class_814[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4448(var1);
   }
}
