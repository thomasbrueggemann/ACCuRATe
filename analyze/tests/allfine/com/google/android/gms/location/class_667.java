package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.class_664;

// $FF: renamed from: com.google.android.gms.location.c
public class class_667 implements SafeParcelable {
    public static final class_664 CREATOR = new class_664();
    // $FF: renamed from: BR int
    private final int field_3238;
    int aex;
    int aey;
    long aez;

    class_667(int var1, int var2, int var3, long var4) {
        this.field_3238 = var1;
        this.aex = var2;
        this.aey = var3;
        this.aez = var4;
    }

    // $FF: renamed from: ee (int) java.lang.String
    private String method_3729(int var1) {
        switch(var1) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 1:
            default:
                return "STATUS_UNKNOWN";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_667) {
            class_667 var2 = (class_667)var1;
            if(this.aex == var2.aex && this.aey == var2.aey && this.aez == var2.aez) {
                return true;
            }
        }

        return false;
    }

    int getVersionCode() {
        return this.field_3238;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.aex), Integer.valueOf(this.aey), Long.valueOf(this.aez)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("LocationStatus[cell status: ").append(this.method_3729(this.aex));
        var1.append(", wifi status: ").append(this.method_3729(this.aey));
        var1.append(", elapsed realtime ns: ").append(this.aez);
        var1.append(']');
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_664.method_3722(this, var1, var2);
    }
}
