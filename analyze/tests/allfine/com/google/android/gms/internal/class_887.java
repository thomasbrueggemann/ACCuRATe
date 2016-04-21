package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_884;
import com.google.android.gms.internal.class_898;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.mn
public final class class_887 implements SafeParcelable {
    public static final class_884 CREATOR = new class_884();
    static final long afA;
    // $FF: renamed from: BR int
    final int field_4206;
    private final long aes;
    private final class_898 afB;
    private final int mPriority;

    static {
        afA = TimeUnit.HOURS.toMillis(1L);
    }

    public class_887(int var1, class_898 var2, long var3, int var5) {
        this.field_4206 = var1;
        this.afB = var2;
        this.aes = var3;
        this.mPriority = var5;
    }

    public int describeContents() {
        class_884 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof class_887)) {
                return false;
            }

            class_887 var2 = (class_887)var1;
            if(!class_1089.equal(this.afB, var2.afB) || this.aes != var2.aes || this.mPriority != var2.mPriority) {
                return false;
            }
        }

        return true;
    }

    public long getInterval() {
        return this.aes;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.afB, Long.valueOf(this.aes), Integer.valueOf(this.mPriority)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: mh () com.google.android.gms.internal.mj
    public class_898 method_4568() {
        return this.afB;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("filter", this.afB).method_5425("interval", Long.valueOf(this.aes)).method_5425("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_884 var10000 = CREATOR;
        class_884.method_4561(this, var1, var2);
    }
}
