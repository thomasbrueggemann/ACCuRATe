package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;

public class AccountChangeEventCreator implements Creator<AccountChangeEvent> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEvent, android.os.Parcel, int) void
   static void method_1504(AccountChangeEvent var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4271);
      class_704.method_4030(var1, 2, var0.field_4272);
      class_704.method_4038(var1, 3, var0.field_4270, false);
      class_704.method_4050(var1, 4, var0.field_4273);
      class_704.method_4050(var1, 5, var0.field_4274);
      class_704.method_4038(var1, 6, var0.field_4275, false);
      class_704.method_4026(var1, var3);
   }

   public AccountChangeEvent createFromParcel(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      int var7 = 0;
      String var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var5 = class_705.method_4075(var1, var10);
            break;
         case 3:
            var8 = class_705.method_4081(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var10);
            break;
         case 5:
            var3 = class_705.method_4073(var1, var10);
            break;
         case 6:
            var2 = class_705.method_4081(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new AccountChangeEvent(var9, var5, var8, var7, var3, var2);
      }
   }

   public AccountChangeEvent[] newArray(int var1) {
      return new AccountChangeEvent[var1];
   }
}
