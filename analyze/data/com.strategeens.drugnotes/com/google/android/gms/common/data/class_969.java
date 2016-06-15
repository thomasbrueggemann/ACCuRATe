package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;

// $FF: renamed from: com.google.android.gms.common.data.f
public class class_969 implements Creator<DataHolder> {
   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, android.os.Parcel, int) void
   static void method_5393(DataHolder var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4045(var1, 1, var0.method_5839(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4044(var1, 2, var0.method_5840(), var2, false);
      class_704.method_4050(var1, 3, var0.getStatusCode());
      class_704.method_4031(var1, 4, var0.method_5837(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: B (android.os.Parcel) com.google.android.gms.common.data.DataHolder
   public DataHolder method_5394(Parcel var1) {
      int var2 = 0;
      Bundle var3 = null;
      int var4 = class_705.method_4059(var1);
      CursorWindow[] var5 = null;
      String[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var6 = class_705.method_4053(var1, var9);
            break;
         case 2:
            var5 = (CursorWindow[])class_705.method_4067(var1, var9, CursorWindow.CREATOR);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var9);
            break;
         case 4:
            var3 = class_705.method_4083(var1, var9);
            break;
         case 1000:
            var7 = class_705.method_4073(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         DataHolder var8 = new DataHolder(var7, var6, var5, var2, var3);
         var8.method_5838();
         return var8;
      }
   }

   // $FF: renamed from: aw (int) com.google.android.gms.common.data.DataHolder[]
   public DataHolder[] method_5395(int var1) {
      return new DataHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5394(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5395(var1);
   }
}
