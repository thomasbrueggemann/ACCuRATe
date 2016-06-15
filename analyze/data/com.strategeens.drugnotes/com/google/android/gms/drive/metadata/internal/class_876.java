package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.a
public class class_876 implements Creator<AppVisibleCustomProperties> {
   // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties, android.os.Parcel, int) void
   static void method_4940(AppVisibleCustomProperties var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2603);
      class_704.method_4051(var1, 2, var0.field_2604, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aN (android.os.Parcel) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   public AppVisibleCustomProperties method_4941(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4068(var1, var5, CustomProperty.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new AppVisibleCustomProperties(var3, var4);
      }
   }

   // $FF: renamed from: cc (int) com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties[]
   public AppVisibleCustomProperties[] method_4942(int var1) {
      return new AppVisibleCustomProperties[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4941(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4942(var1);
   }
}
