package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hb;

// $FF: renamed from: com.google.android.gms.internal.hb
public class class_409 implements Parcelable {
    @Deprecated
    public static final Creator<hb> CREATOR = new Creator() {
        // $FF: renamed from: H (int) com.google.android.gms.internal.hb[]
        @Deprecated
        public class_409[] method_2221(int var1) {
            return new class_409[var1];
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_2222(var1);
        }

        // $FF: renamed from: k (android.os.Parcel) com.google.android.gms.internal.hb
        @Deprecated
        public class_409 method_2222(Parcel var1) {
            return new class_409(var1);
        }

        // $FF: synthetic method
        public Object[] newArray(int var1) {
            return this.method_2221(var1);
        }
    };
    // $FF: renamed from: BL java.lang.String
    private String field_1510;
    // $FF: renamed from: BM java.lang.String
    private String field_1511;
    private String mValue;

    @Deprecated
    public class_409() {
    }

    @Deprecated
    class_409(Parcel var1) {
        this.readFromParcel(var1);
    }

    public class_409(String var1, String var2, String var3) {
        this.field_1510 = var1;
        this.field_1511 = var2;
        this.mValue = var3;
    }

    @Deprecated
    private void readFromParcel(Parcel var1) {
        this.field_1510 = var1.readString();
        this.field_1511 = var1.readString();
        this.mValue = var1.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.field_1510;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel var1, int var2) {
        var1.writeString(this.field_1510);
        var1.writeString(this.field_1511);
        var1.writeString(this.mValue);
    }
}
