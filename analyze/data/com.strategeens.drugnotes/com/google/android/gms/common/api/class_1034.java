package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;

// $FF: renamed from: com.google.android.gms.common.api.e
public class class_1034 implements Creator<Scope> {
   // $FF: renamed from: a (com.google.android.gms.common.api.Scope, android.os.Parcel, int) void
   static void method_5680(Scope var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_508);
      class_704.method_4038(var1, 2, var0.method_1632(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: am (int) com.google.android.gms.common.api.Scope[]
   public Scope[] method_5681(int var1) {
      return new Scope[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5682(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5681(var1);
   }

   // $FF: renamed from: z (android.os.Parcel) com.google.android.gms.common.api.Scope
   public Scope method_5682(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new Scope(var3, var4);
      }
   }
}
