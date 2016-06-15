package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.kt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.ku
public class class_623 implements Creator<kt> {
   // $FF: renamed from: a (com.google.android.gms.internal.kt, android.os.Parcel, int) void
   static void method_3617(class_288 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1940();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3369(var1, 2, var0.getAboutMe(), true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3365(var1, 3, var0.method_1932(), var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3369(var1, 4, var0.getBirthday(), true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_599.method_3369(var1, 5, var0.getBraggingRights(), true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_599.method_3381(var1, 6, var0.getCircledByCount());
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_599.method_3365(var1, 7, var0.method_1933(), var2, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         class_599.method_3369(var1, 8, var0.getCurrentLocation(), true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         class_599.method_3369(var1, 9, var0.getDisplayName(), true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         class_599.method_3381(var1, 12, var0.getGender());
      }

      if(var4.contains(Integer.valueOf(14))) {
         class_599.method_3369(var1, 14, var0.getId(), true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         class_599.method_3365(var1, 15, var0.method_1934(), var2, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         class_599.method_3372(var1, 16, var0.isPlusUser());
      }

      if(var4.contains(Integer.valueOf(19))) {
         class_599.method_3365(var1, 19, var0.method_1935(), var2, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         class_599.method_3369(var1, 18, var0.getLanguage(), true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         class_599.method_3381(var1, 21, var0.getObjectType());
      }

      if(var4.contains(Integer.valueOf(20))) {
         class_599.method_3369(var1, 20, var0.getNickname(), true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         class_599.method_3380(var1, 23, var0.method_1937(), true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         class_599.method_3380(var1, 22, var0.method_1936(), true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         class_599.method_3381(var1, 25, var0.getRelationshipStatus());
      }

      if(var4.contains(Integer.valueOf(24))) {
         class_599.method_3381(var1, 24, var0.getPlusOneCount());
      }

      if(var4.contains(Integer.valueOf(27))) {
         class_599.method_3369(var1, 27, var0.getUrl(), true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         class_599.method_3369(var1, 26, var0.getTagline(), true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         class_599.method_3372(var1, 29, var0.isVerified());
      }

      if(var4.contains(Integer.valueOf(28))) {
         class_599.method_3380(var1, 28, var0.method_1938(), true);
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bG (android.os.Parcel) com.google.android.gms.internal.kt
   public class_288 method_3618(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      String var5 = null;
      class_288.class_946 var6 = null;
      String var7 = null;
      String var8 = null;
      int var9 = 0;
      class_288.class_947 var10 = null;
      String var11 = null;
      String var12 = null;
      int var13 = 0;
      String var14 = null;
      class_288.class_950 var15 = null;
      boolean var16 = false;
      String var17 = null;
      class_288.class_951 var18 = null;
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
         int var29 = class_600.method_3383(var1);
         switch(class_600.method_3394(var29)) {
         case 1:
            var4 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(2));
            break;
         case 3:
            class_288.class_946 var55 = (class_288.class_946)class_600.method_3390(var1, var29, class_288.class_946.CREATOR);
            var3.add(Integer.valueOf(3));
            var6 = var55;
            break;
         case 4:
            var7 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(4));
            break;
         case 5:
            var8 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(6));
            break;
         case 7:
            class_288.class_947 var50 = (class_288.class_947)class_600.method_3390(var1, var29, class_288.class_947.CREATOR);
            var3.add(Integer.valueOf(7));
            var10 = var50;
            break;
         case 8:
            var11 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(8));
            break;
         case 9:
            var12 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(9));
            break;
         case 10:
         case 11:
         case 13:
         case 17:
         default:
            class_600.method_3395(var1, var29);
            break;
         case 12:
            var13 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(12));
            break;
         case 14:
            var14 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(14));
            break;
         case 15:
            class_288.class_950 var44 = (class_288.class_950)class_600.method_3390(var1, var29, class_288.class_950.CREATOR);
            var3.add(Integer.valueOf(15));
            var15 = var44;
            break;
         case 16:
            var16 = class_600.method_3398(var1, var29);
            var3.add(Integer.valueOf(16));
            break;
         case 18:
            var17 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(18));
            break;
         case 19:
            class_288.class_951 var41 = (class_288.class_951)class_600.method_3390(var1, var29, class_288.class_951.CREATOR);
            var3.add(Integer.valueOf(19));
            var18 = var41;
            break;
         case 20:
            var19 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(20));
            break;
         case 21:
            var20 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(21));
            break;
         case 22:
            var21 = class_600.method_3397(var1, var29, class_288.class_953.CREATOR);
            var3.add(Integer.valueOf(22));
            break;
         case 23:
            var22 = class_600.method_3397(var1, var29, class_288.class_954.CREATOR);
            var3.add(Integer.valueOf(23));
            break;
         case 24:
            var23 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(24));
            break;
         case 25:
            var24 = class_600.method_3402(var1, var29);
            var3.add(Integer.valueOf(25));
            break;
         case 26:
            var25 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(26));
            break;
         case 27:
            var26 = class_600.method_3410(var1, var29);
            var3.add(Integer.valueOf(27));
            break;
         case 28:
            var27 = class_600.method_3397(var1, var29, class_288.class_955.CREATOR);
            var3.add(Integer.valueOf(28));
            break;
         case 29:
            var28 = class_600.method_3398(var1, var29);
            var3.add(Integer.valueOf(29));
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_288(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3618(var1);
   }

   // $FF: renamed from: dd (int) com.google.android.gms.internal.kt[]
   public class_288[] method_3619(int var1) {
      return new class_288[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3619(var1);
   }
}
