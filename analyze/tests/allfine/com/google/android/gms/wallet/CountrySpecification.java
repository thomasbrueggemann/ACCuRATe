package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1027;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new class_1027();
    // $FF: renamed from: BR int
    private final int field_5315;
    // $FF: renamed from: uW java.lang.String
    String field_5316;

    CountrySpecification(int var1, String var2) {
        this.field_5315 = var1;
        this.field_5316 = var2;
    }

    public CountrySpecification(String var1) {
        this.field_5315 = 1;
        this.field_5316 = var1;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.field_5316;
    }

    public int getVersionCode() {
        return this.field_5315;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1027.method_5354(this, var1, var2);
    }
}
