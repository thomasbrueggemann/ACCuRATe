package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_1142;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR = new class_1142();
    // $FF: renamed from: BR int
    private final int field_2864;
    // $FF: renamed from: Th int
    private final int field_2865;
    // $FF: renamed from: Tv boolean
    private boolean field_2866;
    // $FF: renamed from: Tw float
    private float field_2867;

    Value(int var1) {
        this(1, var1, false, 0.0F);
    }

    Value(int var1, int var2, boolean var3, float var4) {
        this.field_2864 = var1;
        this.field_2865 = var2;
        this.field_2866 = var3;
        this.field_2867 = var4;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Value) boolean
    private boolean method_3265(Value var1) {
        if(this.field_2865 == var1.field_2865 && this.field_2866 == var1.field_2866) {
            switch(this.field_2865) {
                case 1:
                    if(this.asInt() != var1.asInt()) {
                        return false;
                    }
                    break;
                case 2:
                    if(this.asFloat() != var1.asFloat()) {
                        return false;
                    }
                    break;
                default:
                    if(this.field_2867 != var1.field_2867) {
                        return false;
                    }
            }

            return true;
        } else {
            return false;
        }
    }

    public float asFloat() {
        boolean var1;
        if(this.field_2865 == 2) {
            var1 = true;
        } else {
            var1 = false;
        }

        class_1090.method_5676(var1, "Value is not in float format");
        return this.field_2867;
    }

    public int asInt() {
        byte var1 = 1;
        if(this.field_2865 != var1) {
            var1 = 0;
        }

        class_1090.method_5676((boolean)var1, "Value is not in int format");
        return Float.floatToRawIntBits(this.field_2867);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof Value && this.method_3265((Value)var1);
    }

    public int getFormat() {
        return this.field_2865;
    }

    int getVersionCode() {
        return this.field_2864;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Float.valueOf(this.field_2867), Integer.valueOf(this.field_2865), Boolean.valueOf(this.field_2866)};
        return class_1089.hashCode(var1);
    }

    public boolean isSet() {
        return this.field_2866;
    }

    // $FF: renamed from: ja () float
    float method_3266() {
        return this.field_2867;
    }

    public void setFloat(float var1) {
        boolean var2;
        if(this.field_2865 == 2) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5676(var2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.field_2866 = true;
        this.field_2867 = var1;
    }

    public void setInt(int var1) {
        boolean var2;
        if(this.field_2865 == 1) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5676(var2, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.field_2866 = true;
        this.field_2867 = Float.intBitsToFloat(var1);
    }

    public String toString() {
        if(!this.field_2866) {
            return "unset";
        } else {
            switch(this.field_2865) {
                case 1:
                    return Integer.toString(this.asInt());
                case 2:
                    return Float.toString(this.asFloat());
                default:
                    return "unknown";
            }
        }
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1142.method_5941(this, var1, var2);
    }
}
