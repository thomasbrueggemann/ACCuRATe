package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pr
public class class_801 implements Creator<class_730.class_1705> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$g, android.os.Parcel, int) void
   static void method_4442(class_730.class_1705 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3337);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4041(var1, 2, var0.apR);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4038(var1, 3, var0.mValue, true);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4443(var1);
   }

   // $FF: renamed from: dH (android.os.Parcel) com.google.android.gms.internal.pi$g
   public class_730.class_1705 method_4443(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      HashSet var4 = new HashSet();
      String var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var2 = class_705.method_4069(var1, var7);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var5 = class_705.method_4081(var1, var7);
            var4.add(Integer.valueOf(3));
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_730.class_1705(var4, var6, var2, var5);
      }
   }

   // $FF: renamed from: fF (int) com.google.android.gms.internal.pi$g[]
   public class_730.class_1705[] method_4444(int var1) {
      return new class_730.class_1705[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4444(var1);
   }
}
