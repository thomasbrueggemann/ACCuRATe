package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.class_499;

// $FF: renamed from: com.google.android.gms.fitness.request.af
public class class_498 implements SafeParcelable {
    public static final Creator<af> CREATOR = new class_499();
    // $FF: renamed from: BR int
    private final int field_2137;
    // $FF: renamed from: US com.google.android.gms.fitness.data.Subscription
    private final Subscription field_2138;
    // $FF: renamed from: UT boolean
    private final boolean field_2139;

    class_498(int var1, Subscription var2, boolean var3) {
        this.field_2137 = var1;
        this.field_2138 = var2;
        this.field_2139 = var3;
    }

    private class_498(class_498.class_1609 var1) {
        this.field_2137 = 1;
        this.field_2138 = var1.field_3843;
        this.field_2139 = var1.field_3844;
    }

    // $FF: synthetic method
    class_498(class_498.class_1609 var1, Object var2) {
        this(var1);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.field_2137;
    }

    // $FF: renamed from: jD () com.google.android.gms.fitness.data.Subscription
    public Subscription method_3045() {
        return this.field_2138;
    }

    // $FF: renamed from: jE () boolean
    public boolean method_3046() {
        return this.field_2139;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("subscription", this.field_2138).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_499.method_3047(this, var1, var2);
    }

    public static class class_1609 {
        // $FF: renamed from: US com.google.android.gms.fitness.data.Subscription
        private Subscription field_3843;
        // $FF: renamed from: UT boolean
        private boolean field_3844 = false;

        // $FF: renamed from: b (com.google.android.gms.fitness.data.Subscription) com.google.android.gms.fitness.request.af$a
        public class_498.class_1609 method_4190(Subscription var1) {
            this.field_3843 = var1;
            return this;
        }

        // $FF: renamed from: jF () com.google.android.gms.fitness.request.af
        public class_498 method_4191() {
            boolean var1;
            if(this.field_3843 != null) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must call setSubscription()");
            return new class_498(this);
        }
    }
}
