package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventsRequestCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
    // $FF: renamed from: Dd java.lang.String
    String field_4569;
    // $FF: renamed from: Di int
    final int field_4570;
    // $FF: renamed from: Dl int
    int field_4571;

    public AccountChangeEventsRequest() {
        this.field_4570 = 1;
    }

    AccountChangeEventsRequest(int var1, int var2, String var3) {
        this.field_4570 = var1;
        this.field_4571 = var2;
        this.field_4569 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.field_4569;
    }

    public int getEventIndex() {
        return this.field_4571;
    }

    public AccountChangeEventsRequest setAccountName(String var1) {
        this.field_4569 = var1;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int var1) {
        this.field_4571 = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        AccountChangeEventsRequestCreator.method_3075(this, var1, var2);
    }
}
