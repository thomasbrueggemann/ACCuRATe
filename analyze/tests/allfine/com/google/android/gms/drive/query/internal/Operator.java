package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_1034;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new class_1034();
    // $FF: renamed from: QZ com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4758 = new Operator("=");
    // $FF: renamed from: Ra com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4759 = new Operator("<");
    // $FF: renamed from: Rb com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4760 = new Operator("<=");
    // $FF: renamed from: Rc com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4761 = new Operator(">");
    // $FF: renamed from: Rd com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4762 = new Operator(">=");
    // $FF: renamed from: Re com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4763 = new Operator("and");
    // $FF: renamed from: Rf com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4764 = new Operator("or");
    // $FF: renamed from: Rg com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4765 = new Operator("not");
    // $FF: renamed from: Rh com.google.android.gms.drive.query.internal.Operator
    public static final Operator field_4766 = new Operator("contains");
    // $FF: renamed from: BR int
    final int field_4767;
    final String mTag;

    Operator(int var1, String var2) {
        this.field_4767 = var1;
        this.mTag = var2;
    }

    private Operator(String var1) {
        this(1, var1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(var1 == null) {
                return false;
            }

            if(this.getClass() != var1.getClass()) {
                return false;
            }

            Operator var2 = (Operator)var1;
            if(this.mTag == null) {
                if(var2.mTag != null) {
                    return false;
                }
            } else if(!this.mTag.equals(var2.mTag)) {
                return false;
            }
        }

        return true;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        int var1;
        if(this.mTag == null) {
            var1 = 0;
        } else {
            var1 = this.mTag.hashCode();
        }

        return var1 + 31;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1034.method_5377(this, var1, var2);
    }
}
