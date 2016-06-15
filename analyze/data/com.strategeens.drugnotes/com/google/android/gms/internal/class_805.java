package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_728;
import com.google.android.gms.internal.class_729;
import com.google.android.gms.internal.pf;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pg
public class class_805 implements Creator<pf> {
   // $FF: renamed from: a (com.google.android.gms.internal.pf, android.os.Parcel, int) void
   static void method_4449(class_729 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3359);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4038(var1, 2, var0.field_3358, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4034(var1, 4, var0.api, var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_704.method_4038(var1, 5, var0.apa, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_704.method_4034(var1, 6, var0.apj, var2, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_704.method_4038(var1, 7, var0.field_3360, true);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4450(var1);
   }

   // $FF: renamed from: dy (android.os.Parcel) com.google.android.gms.internal.pf
   public class_729 method_4450(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      class_728 var6 = null;
      String var7 = null;
      class_728 var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var5 = class_705.method_4073(var1, var10);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var9 = class_705.method_4081(var1, var10);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
         default:
            class_705.method_4066(var1, var10);
            break;
         case 4:
            class_728 var15 = (class_728)class_705.method_4061(var1, var10, class_728.CREATOR);
            var4.add(Integer.valueOf(4));
            var8 = var15;
            break;
         case 5:
            var7 = class_705.method_4081(var1, var10);
            var4.add(Integer.valueOf(5));
            break;
         case 6:
            class_728 var12 = (class_728)class_705.method_4061(var1, var10, class_728.CREATOR);
            var4.add(Integer.valueOf(6));
            var6 = var12;
            break;
         case 7:
            var2 = class_705.method_4081(var1, var10);
            var4.add(Integer.valueOf(7));
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_729(var4, var5, var9, var8, var7, var6, var2);
      }
   }

   // $FF: renamed from: fw (int) com.google.android.gms.internal.pf[]
   public class_729[] method_4451(int var1) {
      return new class_729[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4451(var1);
   }
}
