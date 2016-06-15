package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.a
public class class_679 implements Creator<AppVisibleCustomProperties> {
   // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties, android.os.Parcel, int) void
   static void method_3955(AppVisibleCustomProperties var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2787);
      class_599.method_3380(var1, 2, var0.field_2786, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aA (android.os.Parcel) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   public AppVisibleCustomProperties method_3956(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = class_600.method_3397(var1, var5, CustomProperty.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new AppVisibleCustomProperties(var3, var4);
      }
   }

   // $FF: renamed from: bw (int) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties[]
   public AppVisibleCustomProperties[] method_3957(int var1) {
      return new AppVisibleCustomProperties[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3956(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3957(var1);
   }
}
