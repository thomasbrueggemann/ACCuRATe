package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsResponseCreator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final AccountChangeEventsResponseCreator CREATOR = new AccountChangeEventsResponseCreator();
    // $FF: renamed from: Di int
    final int field_4861;
    // $FF: renamed from: me java.util.List
    final List<AccountChangeEvent> field_4862;

    AccountChangeEventsResponse(int var1, List<AccountChangeEvent> var2) {
        this.field_4861 = var1;
        this.field_4862 = (List)class_1090.method_5685(var2);
    }

    public AccountChangeEventsResponse(List<AccountChangeEvent> var1) {
        this.field_4861 = 1;
        this.field_4862 = (List)class_1090.method_5685(var1);
    }

    public int describeContents() {
        return 0;
    }

    public List<AccountChangeEvent> getEvents() {
        return this.field_4862;
    }

    public void writeToParcel(Parcel var1, int var2) {
        AccountChangeEventsResponseCreator.method_2679(this, var1, var2);
    }
}
