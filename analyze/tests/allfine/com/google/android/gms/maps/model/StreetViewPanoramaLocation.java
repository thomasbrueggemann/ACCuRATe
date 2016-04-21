package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.class_984;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final class_984 CREATOR = new class_984();
    // $FF: renamed from: BR int
    private final int field_3439;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(int var1, StreetViewPanoramaLink[] var2, LatLng var3, String var4) {
        this.field_3439 = var1;
        this.links = var2;
        this.position = var3;
        this.panoId = var4;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] var1, LatLng var2, String var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof StreetViewPanoramaLocation)) {
                return false;
            }

            StreetViewPanoramaLocation var2 = (StreetViewPanoramaLocation)var1;
            if(!this.panoId.equals(var2.panoId) || !this.position.equals(var2.position)) {
                return false;
            }
        }

        return true;
    }

    int getVersionCode() {
        return this.field_3439;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.position, this.panoId};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("panoId", this.panoId).method_5425("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_984.method_5174(this, var1, var2);
    }
}
