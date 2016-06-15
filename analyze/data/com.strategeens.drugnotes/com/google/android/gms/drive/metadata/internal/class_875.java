package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.c
public class class_875 implements Creator<CustomProperty> {
   // $FF: renamed from: a (com.google.android.gms.drive.metadata.internal.CustomProperty, android.os.Parcel, int) void
   static void method_4937(CustomProperty var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3420);
      class_704.method_4034(var1, 2, var0.field_3421, var2, false);
      class_704.method_4038(var1, 3, var0.mValue, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aO (android.os.Parcel) com.google.android.gms.drive.metadata.internal.CustomProperty
   public CustomProperty method_4938(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      CustomPropertyKey var5;
      String var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         CustomPropertyKey var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            CustomPropertyKey var10 = (CustomPropertyKey)class_705.method_4061(var1, var6, CustomPropertyKey.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_705.method_4081(var1, var6);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new CustomProperty(var4, var5, var2);
      }
   }

   // $FF: renamed from: cd (int) com.google.android.gms.drive.metadata.internal.CustomProperty[]
   public CustomProperty[] method_4939(int var1) {
      return new CustomProperty[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4938(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4939(var1);
   }
}
