package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_1042;
import com.google.android.gms.drive.query.internal.f;

public class MatchAllFilter extends AbstractFilter {
    public static final class_1042 CREATOR = new class_1042();
    // $FF: renamed from: BR int
    final int field_2039;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int var1) {
        this.field_2039 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <F> F method_7(f<F> var1) {
        return var1.method_886();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1042.method_5406(this, var1, var2);
    }
}
