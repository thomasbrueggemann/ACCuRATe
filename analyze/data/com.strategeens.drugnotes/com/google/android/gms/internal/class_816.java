package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_818;
import com.google.android.gms.internal.or;

// $FF: renamed from: com.google.android.gms.internal.ot
public class class_816 implements Creator<or> {
   // $FF: renamed from: a (com.google.android.gms.internal.or, android.os.Parcel, int) void
   static void method_4466(class_818 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4030(var1, 2, var0.amW);
      class_704.method_4038(var1, 3, var0.tag, false);
      class_704.method_4042(var1, 4, var0.amX, false);
      class_704.method_4031(var1, 5, var0.amY, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4467(var1);
   }

   // $FF: renamed from: dt (android.os.Parcel) com.google.android.gms.internal.or
   public class_818 method_4467(Parcel var1) {
      Bundle var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      long var5 = 0L;
      byte[] var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var4 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var5 = class_705.method_4075(var1, var9);
            break;
         case 3:
            var8 = class_705.method_4081(var1, var9);
            break;
         case 4:
            var7 = class_705.method_4084(var1, var9);
            break;
         case 5:
            var2 = class_705.method_4083(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_818(var4, var5, var8, var7, var2);
      }
   }

   // $FF: renamed from: fq (int) com.google.android.gms.internal.or[]
   public class_818[] method_4468(int var1) {
      return new class_818[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4468(var1);
   }
}
