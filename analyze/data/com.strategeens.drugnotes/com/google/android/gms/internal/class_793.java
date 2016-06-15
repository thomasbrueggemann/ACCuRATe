package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.po
public class class_793 implements Creator<class_730.class_1703> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$c, android.os.Parcel, int) void
   static void method_4421(class_730.class_1703 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3339);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4038(var1, 2, var0.field_3340, true);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4422(var1);
   }

   // $FF: renamed from: dE (android.os.Parcel) com.google.android.gms.internal.pi$c
   public class_730.class_1703 method_4422(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var2) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_705.method_4081(var1, var6);
            var3.add(Integer.valueOf(2));
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_730.class_1703(var3, var4, var5);
      }
   }

   // $FF: renamed from: fC (int) com.google.android.gms.internal.pi$c[]
   public class_730.class_1703[] method_4423(int var1) {
      return new class_730.class_1703[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4423(var1);
   }
}
