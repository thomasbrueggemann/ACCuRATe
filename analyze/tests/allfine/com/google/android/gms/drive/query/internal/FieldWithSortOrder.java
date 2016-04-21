package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_1035;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final class_1035 CREATOR = new class_1035();
    // $FF: renamed from: BR int
    final int field_3184;
    // $FF: renamed from: PB java.lang.String
    final String field_3185;
    // $FF: renamed from: QN boolean
    final boolean field_3186;

    FieldWithSortOrder(int var1, String var2, boolean var3) {
        this.field_3184 = var1;
        this.field_3185 = var2;
        this.field_3186 = var3;
    }

    public FieldWithSortOrder(String var1, boolean var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale var1 = Locale.US;
        Object[] var2 = new Object[] {this.field_3185, null};
        String var3;
        if(this.field_3186) {
            var3 = "ASC";
        } else {
            var3 = "DESC";
        }

        var2[1] = var3;
        return String.format(var1, "FieldWithSortOrder[%s %s]", var2);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1035.method_5387(this, var1, var2);
    }
}
