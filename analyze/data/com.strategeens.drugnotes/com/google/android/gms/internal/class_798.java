package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pq
public class class_798 implements Creator<class_730.class_1702> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$f, android.os.Parcel, int) void
   static void method_4433(class_730.class_1702 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3341);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4038(var1, 2, var0.apP, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4038(var1, 3, var0.field_3344, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4038(var1, 4, var0.aoK, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_704.method_4038(var1, 5, var0.apQ, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_704.method_4038(var1, 6, var0.mName, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_704.method_4041(var1, 7, var0.apR);
      }

      if(var4.contains(Integer.valueOf(8))) {
         class_704.method_4038(var1, 8, var0.apa, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         class_704.method_4038(var1, 9, var0.field_3343, true);
      }

      if(var4.contains(Integer.valueOf(10))) {
         class_704.method_4050(var1, 10, var0.field_3342);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4434(var1);
   }

   // $FF: renamed from: dG (android.os.Parcel) com.google.android.gms.internal.pi$f
   public class_730.class_1702 method_4434(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      HashSet var5 = new HashSet();
      String var6 = null;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = class_705.method_4058(var1);
         switch(class_705.method_4065(var14)) {
         case 1:
            var13 = class_705.method_4073(var1, var14);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            var12 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(2));
            break;
         case 3:
            var11 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(3));
            break;
         case 4:
            var10 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(4));
            break;
         case 5:
            var9 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(5));
            break;
         case 6:
            var8 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(6));
            break;
         case 7:
            var7 = class_705.method_4069(var1, var14);
            var5.add(Integer.valueOf(7));
            break;
         case 8:
            var6 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(8));
            break;
         case 9:
            var3 = class_705.method_4081(var1, var14);
            var5.add(Integer.valueOf(9));
            break;
         case 10:
            var2 = class_705.method_4073(var1, var14);
            var5.add(Integer.valueOf(10));
            break;
         default:
            class_705.method_4066(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_730.class_1702(var5, var13, var12, var11, var10, var9, var8, var7, var6, var3, var2);
      }
   }

   // $FF: renamed from: fE (int) com.google.android.gms.internal.pi$f[]
   public class_730.class_1702[] method_4435(int var1) {
      return new class_730.class_1702[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4435(var1);
   }
}
