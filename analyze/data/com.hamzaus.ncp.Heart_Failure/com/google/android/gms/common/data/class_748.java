package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;

// $FF: renamed from: com.google.android.gms.common.data.f
public class class_748 implements Creator<DataHolder> {
   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, android.os.Parcel, int) void
   static void method_4281(DataHolder var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3376(var1, 1, var0.method_4565(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3375(var1, 2, var0.method_4566(), var2, false);
      class_599.method_3381(var1, 3, var0.getStatusCode());
      class_599.method_3362(var1, 4, var0.method_4563(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ag (int) com.google.android.gms.common.data.DataHolder[]
   public DataHolder[] method_4282(int var1) {
      return new DataHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4283(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4282(var1);
   }

   // $FF: renamed from: x (android.os.Parcel) com.google.android.gms.common.data.DataHolder
   public DataHolder method_4283(Parcel var1) {
      int var2 = 0;
      Bundle var3 = null;
      int var4 = class_600.method_3385(var1);
      CursorWindow[] var5 = null;
      String[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var6 = class_600.method_3384(var1, var9);
            break;
         case 2:
            var5 = (CursorWindow[])class_600.method_3396(var1, var9, CursorWindow.CREATOR);
            break;
         case 3:
            var2 = class_600.method_3402(var1, var9);
            break;
         case 4:
            var3 = class_600.method_3412(var1, var9);
            break;
         case 1000:
            var7 = class_600.method_3402(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         DataHolder var8 = new DataHolder(var7, var6, var5, var2, var3);
         var8.method_4564();
         return var8;
      }
   }
}
