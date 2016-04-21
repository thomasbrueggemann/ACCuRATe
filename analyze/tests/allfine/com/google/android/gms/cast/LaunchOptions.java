package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_1061;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_334;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new class_1061();
    // $FF: renamed from: BR int
    private final int field_5278;
    // $FF: renamed from: Fb boolean
    private boolean field_5279;
    // $FF: renamed from: Fc java.lang.String
    private String field_5280;

    public LaunchOptions() {
        this(1, false, class_334.method_2304(Locale.getDefault()));
    }

    LaunchOptions(int var1, boolean var2, String var3) {
        this.field_5278 = var1;
        this.field_5279 = var2;
        this.field_5280 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof LaunchOptions)) {
                return false;
            }

            LaunchOptions var2 = (LaunchOptions)var1;
            if(this.field_5279 != var2.field_5279 || !class_334.method_2300(this.field_5280, var2.field_5280)) {
                return false;
            }
        }

        return true;
    }

    public String getLanguage() {
        return this.field_5280;
    }

    public boolean getRelaunchIfRunning() {
        return this.field_5279;
    }

    int getVersionCode() {
        return this.field_5278;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Boolean.valueOf(this.field_5279), this.field_5280};
        return class_1089.hashCode(var1);
    }

    public void setLanguage(String var1) {
        this.field_5280 = var1;
    }

    public void setRelaunchIfRunning(boolean var1) {
        this.field_5279 = var1;
    }

    public String toString() {
        Object[] var1 = new Object[] {Boolean.valueOf(this.field_5279), this.field_5280};
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1061.method_5553(this, var1, var2);
    }

    public static final class Builder {
        // $FF: renamed from: Fd com.google.android.gms.cast.LaunchOptions
        private LaunchOptions field_4450 = new LaunchOptions();

        public LaunchOptions build() {
            return this.field_4450;
        }

        public LaunchOptions.Builder setLocale(Locale var1) {
            this.field_4450.setLanguage(class_334.method_2304(var1));
            return this;
        }

        public LaunchOptions.Builder setRelaunchIfRunning(boolean var1) {
            this.field_4450.setRelaunchIfRunning(var1);
            return this;
        }
    }
}
