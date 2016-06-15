package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import com.google.android.gms.internal.pi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pj
public class class_796 implements Creator<pi> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi, android.os.Parcel, int) void
   static void method_4430(class_730 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3362);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4038(var1, 2, var0.apl, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4034(var1, 3, var0.apm, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_704.method_4038(var1, 4, var0.apn, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_704.method_4038(var1, 5, var0.apo, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_704.method_4050(var1, 6, var0.app);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_704.method_4034(var1, 7, var0.apq, var2, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         class_704.method_4038(var1, 8, var0.apr, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         class_704.method_4038(var1, 9, var0.field_3364, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         class_704.method_4050(var1, 12, var0.field_3365);
      }

      if(var4.contains(Integer.valueOf(14))) {
         class_704.method_4038(var1, 14, var0.field_3361, true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         class_704.method_4034(var1, 15, var0.aps, var2, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         class_704.method_4041(var1, 16, var0.apt);
      }

      if(var4.contains(Integer.valueOf(19))) {
         class_704.method_4034(var1, 19, var0.apu, var2, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         class_704.method_4038(var1, 18, var0.field_3363, true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         class_704.method_4050(var1, 21, var0.apw);
      }

      if(var4.contains(Integer.valueOf(20))) {
         class_704.method_4038(var1, 20, var0.apv, true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         class_704.method_4051(var1, 23, var0.apy, true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         class_704.method_4051(var1, 22, var0.apx, true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         class_704.method_4050(var1, 25, var0.apA);
      }

      if(var4.contains(Integer.valueOf(24))) {
         class_704.method_4050(var1, 24, var0.apz);
      }

      if(var4.contains(Integer.valueOf(27))) {
         class_704.method_4038(var1, 27, var0.field_3366, true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         class_704.method_4038(var1, 26, var0.apB, true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         class_704.method_4041(var1, 29, var0.apD);
      }

      if(var4.contains(Integer.valueOf(28))) {
         class_704.method_4051(var1, 28, var0.apC, true);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4431(var1);
   }

   // $FF: renamed from: dz (android.os.Parcel) com.google.android.gms.internal.pi
   public class_730 method_4431(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      String var5 = null;
      class_730.class_1700 var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;
      class_730.class_1663 var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      class_730.class_1703 var15 = null;
      boolean var16 = false;
      String var17 = null;
      class_730.class_1704 var18 = null;
      String var19 = null;
      int var20 = 0;
      ArrayList var21 = null;
      ArrayList var22 = null;
      int var23 = 0;
      int var24 = 0;
      String var25 = null;
      String var26 = null;
      ArrayList var27 = null;
      boolean var28 = false;

      while(var1.dataPosition() < var2) {
         int var29 = class_705.method_4058(var1);
         switch(class_705.method_4065(var29)) {
         case 1:
            var4 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(2));
            break;
         case 3:
            class_730.class_1700 var55 = (class_730.class_1700)class_705.method_4061(var1, var29, class_730.class_1700.CREATOR);
            var3.add(Integer.valueOf(3));
            var6 = var55;
            break;
         case 4:
            var7 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(4));
            break;
         case 5:
            var8 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(6));
            break;
         case 7:
            class_730.class_1663 var50 = (class_730.class_1663)class_705.method_4061(var1, var29, class_730.class_1663.CREATOR);
            var3.add(Integer.valueOf(7));
            var10 = var50;
            break;
         case 8:
            var11 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(8));
            break;
         case 9:
            var12 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(9));
            break;
         case 10:
         case 11:
         case 13:
         case 17:
         default:
            class_705.method_4066(var1, var29);
            break;
         case 12:
            var13 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(12));
            break;
         case 14:
            var14 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(14));
            break;
         case 15:
            class_730.class_1703 var44 = (class_730.class_1703)class_705.method_4061(var1, var29, class_730.class_1703.CREATOR);
            var3.add(Integer.valueOf(15));
            var15 = var44;
            break;
         case 16:
            var16 = class_705.method_4069(var1, var29);
            var3.add(Integer.valueOf(16));
            break;
         case 18:
            var17 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(18));
            break;
         case 19:
            class_730.class_1704 var41 = (class_730.class_1704)class_705.method_4061(var1, var29, class_730.class_1704.CREATOR);
            var3.add(Integer.valueOf(19));
            var18 = var41;
            break;
         case 20:
            var19 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(20));
            break;
         case 21:
            var20 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(21));
            break;
         case 22:
            var21 = class_705.method_4068(var1, var29, class_730.class_1702.CREATOR);
            var3.add(Integer.valueOf(22));
            break;
         case 23:
            var22 = class_705.method_4068(var1, var29, class_730.class_1705.CREATOR);
            var3.add(Integer.valueOf(23));
            break;
         case 24:
            var23 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(24));
            break;
         case 25:
            var24 = class_705.method_4073(var1, var29);
            var3.add(Integer.valueOf(25));
            break;
         case 26:
            var25 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(26));
            break;
         case 27:
            var26 = class_705.method_4081(var1, var29);
            var3.add(Integer.valueOf(27));
            break;
         case 28:
            var27 = class_705.method_4068(var1, var29, class_730.class_1706.CREATOR);
            var3.add(Integer.valueOf(28));
            break;
         case 29:
            var28 = class_705.method_4069(var1, var29);
            var3.add(Integer.valueOf(29));
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_730(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
      }
   }

   // $FF: renamed from: fx (int) com.google.android.gms.internal.pi[]
   public class_730[] method_4432(int var1) {
      return new class_730[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4432(var1);
   }
}
