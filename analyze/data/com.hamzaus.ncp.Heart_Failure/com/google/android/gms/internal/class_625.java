package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.ko;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.kp
public class class_625 implements Creator<ko> {
   // $FF: renamed from: a (com.google.android.gms.internal.ko, android.os.Parcel, int) void
   static void method_3623(class_286 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      Set var4 = var0.method_1910();
      if(var4.contains(Integer.valueOf(1))) {
         class_599.method_3381(var1, 1, var0.getVersionCode());
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_599.method_3365(var1, 2, var0.method_1911(), var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_599.method_3370(var1, 3, var0.getAdditionalName(), true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         class_599.method_3365(var1, 4, var0.method_1912(), var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         class_599.method_3369(var1, 5, var0.getAddressCountry(), true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         class_599.method_3369(var1, 6, var0.getAddressLocality(), true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         class_599.method_3369(var1, 7, var0.getAddressRegion(), true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         class_599.method_3380(var1, 8, var0.method_1913(), true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         class_599.method_3381(var1, 9, var0.getAttendeeCount());
      }

      if(var4.contains(Integer.valueOf(10))) {
         class_599.method_3380(var1, 10, var0.method_1914(), true);
      }

      if(var4.contains(Integer.valueOf(11))) {
         class_599.method_3365(var1, 11, var0.method_1915(), var2, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         class_599.method_3380(var1, 12, var0.method_1916(), true);
      }

      if(var4.contains(Integer.valueOf(13))) {
         class_599.method_3369(var1, 13, var0.getBestRating(), true);
      }

      if(var4.contains(Integer.valueOf(14))) {
         class_599.method_3369(var1, 14, var0.getBirthDate(), true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         class_599.method_3365(var1, 15, var0.method_1917(), var2, true);
      }

      if(var4.contains(Integer.valueOf(17))) {
         class_599.method_3369(var1, 17, var0.getContentSize(), true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         class_599.method_3369(var1, 16, var0.getCaption(), true);
      }

      if(var4.contains(Integer.valueOf(19))) {
         class_599.method_3380(var1, 19, var0.method_1918(), true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         class_599.method_3369(var1, 18, var0.getContentUrl(), true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         class_599.method_3369(var1, 21, var0.getDateModified(), true);
      }

      if(var4.contains(Integer.valueOf(20))) {
         class_599.method_3369(var1, 20, var0.getDateCreated(), true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         class_599.method_3369(var1, 23, var0.getDescription(), true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         class_599.method_3369(var1, 22, var0.getDatePublished(), true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         class_599.method_3369(var1, 25, var0.getEmbedUrl(), true);
      }

      if(var4.contains(Integer.valueOf(24))) {
         class_599.method_3369(var1, 24, var0.getDuration(), true);
      }

      if(var4.contains(Integer.valueOf(27))) {
         class_599.method_3369(var1, 27, var0.getFamilyName(), true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         class_599.method_3369(var1, 26, var0.getEndDate(), true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         class_599.method_3365(var1, 29, var0.method_1919(), var2, true);
      }

      if(var4.contains(Integer.valueOf(28))) {
         class_599.method_3369(var1, 28, var0.getGender(), true);
      }

      if(var4.contains(Integer.valueOf(31))) {
         class_599.method_3369(var1, 31, var0.getHeight(), true);
      }

      if(var4.contains(Integer.valueOf(30))) {
         class_599.method_3369(var1, 30, var0.getGivenName(), true);
      }

      if(var4.contains(Integer.valueOf(34))) {
         class_599.method_3365(var1, 34, var0.method_1920(), var2, true);
      }

      if(var4.contains(Integer.valueOf(32))) {
         class_599.method_3369(var1, 32, var0.getId(), true);
      }

      if(var4.contains(Integer.valueOf(33))) {
         class_599.method_3369(var1, 33, var0.getImage(), true);
      }

      if(var4.contains(Integer.valueOf(38))) {
         class_599.method_3359(var1, 38, var0.getLongitude());
      }

      if(var4.contains(Integer.valueOf(39))) {
         class_599.method_3369(var1, 39, var0.getName(), true);
      }

      if(var4.contains(Integer.valueOf(36))) {
         class_599.method_3359(var1, 36, var0.getLatitude());
      }

      if(var4.contains(Integer.valueOf(37))) {
         class_599.method_3365(var1, 37, var0.method_1921(), var2, true);
      }

      if(var4.contains(Integer.valueOf(42))) {
         class_599.method_3369(var1, 42, var0.getPlayerType(), true);
      }

      if(var4.contains(Integer.valueOf(43))) {
         class_599.method_3369(var1, 43, var0.getPostOfficeBoxNumber(), true);
      }

      if(var4.contains(Integer.valueOf(40))) {
         class_599.method_3365(var1, 40, var0.method_1922(), var2, true);
      }

      if(var4.contains(Integer.valueOf(41))) {
         class_599.method_3380(var1, 41, var0.method_1923(), true);
      }

      if(var4.contains(Integer.valueOf(46))) {
         class_599.method_3365(var1, 46, var0.method_1924(), var2, true);
      }

      if(var4.contains(Integer.valueOf(47))) {
         class_599.method_3369(var1, 47, var0.getStartDate(), true);
      }

      if(var4.contains(Integer.valueOf(44))) {
         class_599.method_3369(var1, 44, var0.getPostalCode(), true);
      }

      if(var4.contains(Integer.valueOf(45))) {
         class_599.method_3369(var1, 45, var0.getRatingValue(), true);
      }

      if(var4.contains(Integer.valueOf(51))) {
         class_599.method_3369(var1, 51, var0.getThumbnailUrl(), true);
      }

      if(var4.contains(Integer.valueOf(50))) {
         class_599.method_3365(var1, 50, var0.method_1925(), var2, true);
      }

      if(var4.contains(Integer.valueOf(49))) {
         class_599.method_3369(var1, 49, var0.getText(), true);
      }

      if(var4.contains(Integer.valueOf(48))) {
         class_599.method_3369(var1, 48, var0.getStreetAddress(), true);
      }

      if(var4.contains(Integer.valueOf(55))) {
         class_599.method_3369(var1, 55, var0.getWidth(), true);
      }

      if(var4.contains(Integer.valueOf(54))) {
         class_599.method_3369(var1, 54, var0.getUrl(), true);
      }

      if(var4.contains(Integer.valueOf(53))) {
         class_599.method_3369(var1, 53, var0.getType(), true);
      }

      if(var4.contains(Integer.valueOf(52))) {
         class_599.method_3369(var1, 52, var0.getTickerSymbol(), true);
      }

      if(var4.contains(Integer.valueOf(56))) {
         class_599.method_3369(var1, 56, var0.getWorstRating(), true);
      }

      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bE (android.os.Parcel) com.google.android.gms.internal.ko
   public class_286 method_3624(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      HashSet var3 = new HashSet();
      int var4 = 0;
      class_286 var5 = null;
      ArrayList var6 = null;
      class_286 var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      ArrayList var11 = null;
      int var12 = 0;
      ArrayList var13 = null;
      class_286 var14 = null;
      ArrayList var15 = null;
      String var16 = null;
      String var17 = null;
      class_286 var18 = null;
      String var19 = null;
      String var20 = null;
      String var21 = null;
      ArrayList var22 = null;
      String var23 = null;
      String var24 = null;
      String var25 = null;
      String var26 = null;
      String var27 = null;
      String var28 = null;
      String var29 = null;
      String var30 = null;
      String var31 = null;
      class_286 var32 = null;
      String var33 = null;
      String var34 = null;
      String var35 = null;
      String var36 = null;
      class_286 var37 = null;
      double var38 = 0.0D;
      class_286 var40 = null;
      double var41 = 0.0D;
      String var43 = null;
      class_286 var44 = null;
      ArrayList var45 = null;
      String var46 = null;
      String var47 = null;
      String var48 = null;
      String var49 = null;
      class_286 var50 = null;
      String var51 = null;
      String var52 = null;
      String var53 = null;
      class_286 var54 = null;
      String var55 = null;
      String var56 = null;
      String var57 = null;
      String var58 = null;
      String var59 = null;
      String var60 = null;

      while(var1.dataPosition() < var2) {
         int var61 = class_600.method_3383(var1);
         switch(class_600.method_3394(var61)) {
         case 1:
            var4 = class_600.method_3402(var1, var61);
            var3.add(Integer.valueOf(1));
            break;
         case 2:
            class_286 var124 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(2));
            var5 = var124;
            break;
         case 3:
            var6 = class_600.method_3386(var1, var61);
            var3.add(Integer.valueOf(3));
            break;
         case 4:
            class_286 var121 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(4));
            var7 = var121;
            break;
         case 5:
            var8 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(6));
            break;
         case 7:
            var10 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(7));
            break;
         case 8:
            var11 = class_600.method_3397(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(8));
            break;
         case 9:
            var12 = class_600.method_3402(var1, var61);
            var3.add(Integer.valueOf(9));
            break;
         case 10:
            var13 = class_600.method_3397(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(10));
            break;
         case 11:
            class_286 var113 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(11));
            var14 = var113;
            break;
         case 12:
            var15 = class_600.method_3397(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(12));
            break;
         case 13:
            var16 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(13));
            break;
         case 14:
            var17 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(14));
            break;
         case 15:
            class_286 var108 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(15));
            var18 = var108;
            break;
         case 16:
            var19 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(16));
            break;
         case 17:
            var20 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(17));
            break;
         case 18:
            var21 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(18));
            break;
         case 19:
            var22 = class_600.method_3397(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(19));
            break;
         case 20:
            var23 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(20));
            break;
         case 21:
            var24 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(21));
            break;
         case 22:
            var25 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(22));
            break;
         case 23:
            var26 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(23));
            break;
         case 24:
            var27 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(24));
            break;
         case 25:
            var28 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(25));
            break;
         case 26:
            var29 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(26));
            break;
         case 27:
            var30 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(27));
            break;
         case 28:
            var31 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(28));
            break;
         case 29:
            class_286 var94 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(29));
            var32 = var94;
            break;
         case 30:
            var33 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(30));
            break;
         case 31:
            var34 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(31));
            break;
         case 32:
            var35 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(32));
            break;
         case 33:
            var36 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(33));
            break;
         case 34:
            class_286 var89 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(34));
            var37 = var89;
            break;
         case 35:
         default:
            class_600.method_3395(var1, var61);
            break;
         case 36:
            var38 = class_600.method_3408(var1, var61);
            var3.add(Integer.valueOf(36));
            break;
         case 37:
            class_286 var82 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(37));
            var40 = var82;
            break;
         case 38:
            var41 = class_600.method_3408(var1, var61);
            var3.add(Integer.valueOf(38));
            break;
         case 39:
            var43 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(39));
            break;
         case 40:
            class_286 var78 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(40));
            var44 = var78;
            break;
         case 41:
            var45 = class_600.method_3397(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(41));
            break;
         case 42:
            var46 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(42));
            break;
         case 43:
            var47 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(43));
            break;
         case 44:
            var48 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(44));
            break;
         case 45:
            var49 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(45));
            break;
         case 46:
            class_286 var75 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(46));
            var50 = var75;
            break;
         case 47:
            var51 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(47));
            break;
         case 48:
            var52 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(48));
            break;
         case 49:
            var53 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(49));
            break;
         case 50:
            class_286 var69 = (class_286)class_600.method_3390(var1, var61, class_286.CREATOR);
            var3.add(Integer.valueOf(50));
            var54 = var69;
            break;
         case 51:
            var55 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(51));
            break;
         case 52:
            var56 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(52));
            break;
         case 53:
            var57 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(53));
            break;
         case 54:
            var58 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(54));
            break;
         case 55:
            var59 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(55));
            break;
         case 56:
            var60 = class_600.method_3410(var1, var61);
            var3.add(Integer.valueOf(56));
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_286(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var40, var41, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3624(var1);
   }

   // $FF: renamed from: db (int) com.google.android.gms.internal.ko[]
   public class_286[] method_3625(int var1) {
      return new class_286[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3625(var1);
   }
}
