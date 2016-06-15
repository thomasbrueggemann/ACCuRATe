package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.ps
public class class_800 implements Creator<class_730.class_1706> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$h, android.os.Parcel, int) void
   static void method_4439(class_730.class_1706 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3334);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4050(var1, 3, var0.method_4233());
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4038(var1, 4, var0.mValue, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_704.method_4038(var1, 5, var0.field_3336, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_704.method_4050(var1, 6, var0.field_3335);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4440(var1);
   }

   // $FF: renamed from: dI (android.os.Parcel) com.google.android.gms.internal.pi$h
   public class_730.class_1706 method_4440(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      HashSet var5 = new HashSet();
      int var6 = 0;
      String var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var8 = class_705.method_4073(var1, var9);
            var5.add(Integer.valueOf(1));
            break;
         case 2:
         default:
            class_705.method_4066(var1, var9);
            break;
         case 3:
            var3 = class_705.method_4073(var1, var9);
            var5.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = class_705.method_4081(var1, var9);
            var5.add(Integer.valueOf(4));
            break;
         case 5:
            var7 = class_705.method_4081(var1, var9);
            var5.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = class_705.method_4073(var1, var9);
            var5.add(Integer.valueOf(6));
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_730.class_1706(var5, var8, var7, var6, var2, var3);
      }
   }

   // $FF: renamed from: fG (int) com.google.android.gms.internal.pi$h[]
   public class_730.class_1706[] method_4441(int var1) {
      return new class_730.class_1706[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4441(var1);
   }
}
