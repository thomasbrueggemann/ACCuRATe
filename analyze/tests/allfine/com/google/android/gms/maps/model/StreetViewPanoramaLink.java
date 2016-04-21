package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.class_983;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final class_983 CREATOR = new class_983();
    // $FF: renamed from: BR int
    private final int field_5067;
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(int var1, String var2, float var3) {
        this.field_5067 = var1;
        this.panoId = var2;
        if((double)var3 <= 0.0D) {
            var3 = 360.0F + var3 % 360.0F;
        }

        this.bearing = var3 % 360.0F;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof StreetViewPanoramaLink)) {
                return false;
            }

            StreetViewPanoramaLink var2 = (StreetViewPanoramaLink)var1;
            if(!this.panoId.equals(var2.panoId) || Float.floatToIntBits(this.bearing) != Float.floatToIntBits(var2.bearing)) {
                return false;
            }
        }

        return true;
    }

    int getVersionCode() {
        return this.field_5067;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.panoId, Float.valueOf(this.bearing)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("panoId", this.panoId).method_5425("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_983.method_5171(this, var1, var2);
    }
}
