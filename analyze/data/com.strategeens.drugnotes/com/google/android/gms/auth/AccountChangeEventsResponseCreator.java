package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import java.util.ArrayList;

public class AccountChangeEventsResponseCreator implements Creator<AccountChangeEventsResponse> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEventsResponse, android.os.Parcel, int) void
   static void method_2714(AccountChangeEventsResponse var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4076);
      class_704.method_4051(var1, 2, var0.field_4077, false);
      class_704.method_4026(var1, var3);
   }

   public AccountChangeEventsResponse createFromParcel(Parcel var1) {
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
            var4 = class_705.method_4068(var1, var5, AccountChangeEvent.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new AccountChangeEventsResponse(var3, var4);
      }
   }

   public AccountChangeEventsResponse[] newArray(int var1) {
      return new AccountChangeEventsResponse[var1];
   }
}
