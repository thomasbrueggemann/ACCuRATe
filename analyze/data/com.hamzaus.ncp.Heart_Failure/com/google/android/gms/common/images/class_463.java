package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;

// $FF: renamed from: com.google.android.gms.common.images.b
public class class_463 implements Creator<WebImage> {
   // $FF: renamed from: a (com.google.android.gms.common.images.WebImage, android.os.Parcel, int) void
   static void method_2874(WebImage var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getUrl(), var2, false);
      class_599.method_3381(var1, 3, var0.getWidth());
      class_599.method_3381(var1, 4, var0.getHeight());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ak (int) com.google.android.gms.common.images.WebImage[]
   public WebImage[] method_2875(int var1) {
      return new WebImage[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2876(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2875(var1);
   }

   // $FF: renamed from: y (android.os.Parcel) com.google.android.gms.common.images.WebImage
   public WebImage method_2876(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      Uri var4 = null;
      int var5 = 0;

      int var6;
      int var8;
      for(var6 = 0; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         int var9;
         Uri var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Uri var14 = (Uri)class_600.method_3390(var1, var7, Uri.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            int var12 = class_600.method_3402(var1, var7);
            var10 = var4;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var6;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var4;
            var11 = var6;
         }

         var6 = var11;
         var4 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new WebImage(var6, var4, var5, var2);
      }
   }
}
