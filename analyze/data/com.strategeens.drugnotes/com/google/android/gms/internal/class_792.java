package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pl
public class class_792 implements Creator<class_730.class_1663> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$b, android.os.Parcel, int) void
   static void method_4418(class_730.class_1663 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3346);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4034(var1, 2, var0.apG, var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4034(var1, 3, var0.apH, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4050(var1, 4, var0.apI);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4419(var1);
   }

   // $FF: renamed from: dB (android.os.Parcel) com.google.android.gms.internal.pi$b
   public class_730.class_1663 method_4419(Parcel var1) {
      class_730.class_1665 var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      HashSet var5 = new HashSet();
      class_730.class_1664 var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
            class_730.class_1664 var12 = (class_730.class_1664)class_705.method_4061(var1, var8, class_730.class_1664.CREATOR);
            var5.add(Integer.valueOf(2));
            var6 = var12;
            break;
         case 3:
            class_730.class_1665 var10 = (class_730.class_1665)class_705.method_4061(var1, var8, class_730.class_1665.CREATOR);
            var5.add(Integer.valueOf(3));
            var2 = var10;
            break;
         case 4:
            var3 = class_705.method_4073(var1, var8);
            var5.add(Integer.valueOf(4));
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_730.class_1663(var5, var7, var6, var2, var3);
      }
   }

   // $FF: renamed from: fz (int) com.google.android.gms.internal.pi$b[]
   public class_730.class_1663[] method_4420(int var1) {
      return new class_730.class_1663[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4420(var1);
   }
}
