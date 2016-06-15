package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.p
public class class_596 implements Creator<ParcelableCollaborator> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator, android.os.Parcel, int) void
   static void method_3344(ParcelableCollaborator var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3245);
      class_599.method_3372(var1, 2, var0.field_3238);
      class_599.method_3372(var1, 3, var0.field_3239);
      class_599.method_3369(var1, 4, var0.field_3244, false);
      class_599.method_3369(var1, 5, var0.field_3240, false);
      class_599.method_3369(var1, 6, var0.field_3241, false);
      class_599.method_3369(var1, 7, var0.field_3242, false);
      class_599.method_3369(var1, 8, var0.field_3243, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aR (android.os.Parcel) com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
   public ParcelableCollaborator method_3345(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = class_600.method_3385(var1);
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      boolean var9 = false;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var10 = class_600.method_3402(var1, var11);
            break;
         case 2:
            var9 = class_600.method_3398(var1, var11);
            break;
         case 3:
            var2 = class_600.method_3398(var1, var11);
            break;
         case 4:
            var8 = class_600.method_3410(var1, var11);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var11);
            break;
         case 6:
            var6 = class_600.method_3410(var1, var11);
            break;
         case 7:
            var5 = class_600.method_3410(var1, var11);
            break;
         case 8:
            var3 = class_600.method_3410(var1, var11);
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableCollaborator(var10, var9, var2, var8, var7, var6, var5, var3);
      }
   }

   // $FF: renamed from: bO (int) com.google.android.gms.drive.realtime.internal.ParcelableCollaborator[]
   public ParcelableCollaborator[] method_3346(int var1) {
      return new ParcelableCollaborator[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3345(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3346(var1);
   }
}
