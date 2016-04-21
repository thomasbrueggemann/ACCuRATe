package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_521;
import com.google.android.gms.fitness.request.w;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.fitness.request.w
public class class_522 implements SafeParcelable {
    public static final Creator<w> CREATOR = new class_521();
    // $FF: renamed from: BR int
    private final int field_2216;
    // $FF: renamed from: St com.google.android.gms.fitness.data.Session
    private final Session field_2217;

    class_522(int var1, Session var2) {
        this.field_2216 = var1;
        this.field_2217 = var2;
    }

    private class_522(class_522.class_1567 var1) {
        this.field_2216 = 1;
        this.field_2217 = var1.field_4006;
    }

    // $FF: synthetic method
    class_522(class_522.class_1567 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.w) boolean
    private boolean method_3160(class_522 var1) {
        return class_1089.equal(this.field_2217, var1.field_2217);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof class_522 && this.method_3160((class_522)var1);
    }

    public Session getSession() {
        return this.field_2217;
    }

    int getVersionCode() {
        return this.field_2216;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_2217};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("session", this.field_2217).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_521.method_3157(this, var1, var2);
    }

    public static class class_1567 {
        // $FF: renamed from: St com.google.android.gms.fitness.data.Session
        private Session field_4006;

        // $FF: renamed from: b (com.google.android.gms.fitness.data.Session) com.google.android.gms.fitness.request.w$a
        public class_522.class_1567 method_4395(Session var1) {
            boolean var2;
            if(var1.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
                var2 = true;
            } else {
                var2 = false;
            }

            class_1090.method_5683(var2, "Cannot start a session which has already ended");
            this.field_4006 = var1;
            return this;
        }

        // $FF: renamed from: jA () com.google.android.gms.fitness.request.w
        public class_522 method_4396() {
            return new class_522(this);
        }
    }
}
