package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.a
public class class_754 implements Creator<ApplicationMetadata> {
   // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, android.os.Parcel, int) void
   static void method_4311(ApplicationMetadata var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.getApplicationId(), false);
      class_599.method_3369(var1, 3, var0.getName(), false);
      class_599.method_3380(var1, 4, var0.getImages(), false);
      class_599.method_3370(var1, 5, var0.field_3526, false);
      class_599.method_3369(var1, 6, var0.getSenderAppIdentifier(), false);
      class_599.method_3365(var1, 7, var0.method_3855(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: M (int) com.google.android.gms.cast.ApplicationMetadata[]
   public ApplicationMetadata[] method_4312(int var1) {
      return new ApplicationMetadata[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4313(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4312(var1);
   }

   // $FF: renamed from: r (android.os.Parcel) com.google.android.gms.cast.ApplicationMetadata
   public ApplicationMetadata method_4313(Parcel var1) {
      Uri var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;
      ArrayList var6 = null;
      ArrayList var7 = null;
      String var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var4 = class_600.method_3402(var1, var10);
            break;
         case 2:
            var9 = class_600.method_3410(var1, var10);
            break;
         case 3:
            var8 = class_600.method_3410(var1, var10);
            break;
         case 4:
            var7 = class_600.method_3397(var1, var10, WebImage.CREATOR);
            break;
         case 5:
            var6 = class_600.method_3386(var1, var10);
            break;
         case 6:
            var5 = class_600.method_3410(var1, var10);
            break;
         case 7:
            var2 = (Uri)class_600.method_3390(var1, var10, Uri.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ApplicationMetadata(var4, var9, var8, var7, var6, var5, var2);
      }
   }
}
