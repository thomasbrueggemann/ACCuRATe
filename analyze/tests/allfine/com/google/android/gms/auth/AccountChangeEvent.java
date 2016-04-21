package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventCreator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
    // $FF: renamed from: Dd java.lang.String
    final String field_5109;
    // $FF: renamed from: Di int
    final int field_5110;
    // $FF: renamed from: Dj long
    final long field_5111;
    // $FF: renamed from: Dk int
    final int field_5112;
    // $FF: renamed from: Dl int
    final int field_5113;
    // $FF: renamed from: Dm java.lang.String
    final String field_5114;

    AccountChangeEvent(int var1, long var2, String var4, int var5, int var6, String var7) {
        this.field_5110 = var1;
        this.field_5111 = var2;
        this.field_5109 = (String)class_1090.method_5685(var4);
        this.field_5112 = var5;
        this.field_5113 = var6;
        this.field_5114 = var7;
    }

    public AccountChangeEvent(long var1, String var3, int var4, int var5, String var6) {
        this.field_5110 = 1;
        this.field_5111 = var1;
        this.field_5109 = (String)class_1090.method_5685(var3);
        this.field_5112 = var4;
        this.field_5113 = var5;
        this.field_5114 = var6;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof AccountChangeEvent)) {
                return false;
            }

            AccountChangeEvent var2 = (AccountChangeEvent)var1;
            if(this.field_5110 != var2.field_5110 || this.field_5111 != var2.field_5111 || !class_1089.equal(this.field_5109, var2.field_5109) || this.field_5112 != var2.field_5112 || this.field_5113 != var2.field_5113 || !class_1089.equal(this.field_5114, var2.field_5114)) {
                return false;
            }
        }

        return true;
    }

    public String getAccountName() {
        return this.field_5109;
    }

    public String getChangeData() {
        return this.field_5114;
    }

    public int getChangeType() {
        return this.field_5112;
    }

    public int getEventIndex() {
        return this.field_5113;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_5110), Long.valueOf(this.field_5111), this.field_5109, Integer.valueOf(this.field_5112), Integer.valueOf(this.field_5113), this.field_5114};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        String var1 = "UNKNOWN";
        switch(this.field_5112) {
            case 1:
                var1 = "ADDED";
                break;
            case 2:
                var1 = "REMOVED";
                break;
            case 3:
                var1 = "RENAMED_FROM";
                break;
            case 4:
                var1 = "RENAMED_TO";
        }

        return "AccountChangeEvent {accountName = " + this.field_5109 + ", changeType = " + var1 + ", changeData = " + this.field_5114 + ", eventIndex = " + this.field_5113 + "}";
    }

    public void writeToParcel(Parcel var1, int var2) {
        AccountChangeEventCreator.method_1491(this, var1, var2);
    }
}
