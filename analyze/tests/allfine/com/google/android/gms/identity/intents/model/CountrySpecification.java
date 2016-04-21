package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.class_943;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new class_943();
    // $FF: renamed from: BR int
    private final int field_3910;
    // $FF: renamed from: uW java.lang.String
    String field_3911;

    CountrySpecification(int var1, String var2) {
        this.field_3910 = var1;
        this.field_3911 = var2;
    }

    public CountrySpecification(String var1) {
        this.field_3910 = 1;
        this.field_3911 = var1;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.field_3911;
    }

    public int getVersionCode() {
        return this.field_3910;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_943.method_4926(this, var1, var2);
    }
}
