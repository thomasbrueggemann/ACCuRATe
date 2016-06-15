package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.class_404;
import com.google.android.gms.internal.hr;

// $FF: renamed from: com.google.android.gms.internal.hs
public class class_387 implements Creator<hr> {
   // $FF: renamed from: a (com.google.android.gms.internal.hr, android.os.Parcel, int) void
   static void method_2664(class_386 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.field_1205, var2, false);
      class_704.method_4050(var1, 1000, var0.field_1204);
      class_704.method_4030(var1, 2, var0.field_1206);
      class_704.method_4050(var1, 3, var0.field_1207);
      class_704.method_4038(var1, 4, var0.field_1209, false);
      class_704.method_4034(var1, 5, var0.field_1208, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: S (int) com.google.android.gms.internal.hr[]
   public class_386[] method_2665(int var1) {
      return new class_386[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2666(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2665(var1);
   }

   // $FF: renamed from: s (android.os.Parcel) com.google.android.gms.internal.hr
   public class_386 method_2666(Parcel var1) {
      int var2 = 0;
      class_404 var3 = null;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      String var7 = null;
      class_402 var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var8 = (class_402)class_705.method_4061(var1, var10, class_402.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4075(var1, var10);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var10);
            break;
         case 5:
            var3 = (class_404)class_705.method_4061(var1, var10, class_404.CREATOR);
            break;
         case 1000:
            var9 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_386(var9, var8, var5, var2, var7, var3);
      }
   }
}
