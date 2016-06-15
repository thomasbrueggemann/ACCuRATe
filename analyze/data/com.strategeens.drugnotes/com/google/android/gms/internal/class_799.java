package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pp
public class class_799 implements Creator<class_730.class_1704> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$d, android.os.Parcel, int) void
   static void method_4436(class_730.class_1704 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3338);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4038(var1, 2, var0.aoL, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4038(var1, 3, var0.apL, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4038(var1, 4, var0.aoO, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_704.method_4038(var1, 5, var0.apM, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_704.method_4038(var1, 6, var0.apN, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_704.method_4038(var1, 7, var0.apO, true);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4437(var1);
   }

   // $FF: renamed from: dF (android.os.Parcel) com.google.android.gms.internal.pi$d
   public class_730.class_1704 method_4437(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var5 = class_705.method_4073(var1, var11);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var10 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var9 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(3));
            break;
         case 4:
            var8 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(4));
            break;
         case 5:
            var7 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(6));
            break;
         case 7:
            var2 = class_705.method_4081(var1, var11);
            var4.add(Integer.valueOf(7));
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_730.class_1704(var4, var5, var10, var9, var8, var7, var6, var2);
      }
   }

   // $FF: renamed from: fD (int) com.google.android.gms.internal.pi$d[]
   public class_730.class_1704[] method_4438(int var1) {
      return new class_730.class_1704[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4438(var1);
   }
}
