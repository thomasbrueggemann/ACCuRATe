package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponseCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
   public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();
   // $FF: renamed from: Ef int
   final int field_4076;
   // $FF: renamed from: mp java.util.List
   final List<AccountChangeEvent> field_4077;

   AccountChangeEventsResponse(int var1, List<AccountChangeEvent> var2) {
      this.field_4076 = var1;
      this.field_4077 = (List)class_335.method_2311(var2);
   }

   public AccountChangeEventsResponse(List<AccountChangeEvent> var1) {
      this.field_4076 = 1;
      this.field_4077 = (List)class_335.method_2311(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List<AccountChangeEvent> getEvents() {
      return this.field_4077;
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventsResponseCreator.method_2714(this, var1, var2);
   }
}
