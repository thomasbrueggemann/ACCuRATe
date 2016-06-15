package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequestCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
   public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
   // $FF: renamed from: DZ java.lang.String
   String field_3822;
   // $FF: renamed from: Ef int
   final int field_3823;
   // $FF: renamed from: Ei int
   int field_3824;

   public AccountChangeEventsRequest() {
      this.field_3823 = 1;
   }

   AccountChangeEventsRequest(int var1, int var2, String var3) {
      this.field_3823 = var1;
      this.field_3824 = var2;
      this.field_3822 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccountName() {
      return this.field_3822;
   }

   public int getEventIndex() {
      return this.field_3824;
   }

   public AccountChangeEventsRequest setAccountName(String var1) {
      this.field_3822 = var1;
      return this;
   }

   public AccountChangeEventsRequest setEventIndex(int var1) {
      this.field_3824 = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventsRequestCreator.method_3117(this, var1, var2);
   }
}
