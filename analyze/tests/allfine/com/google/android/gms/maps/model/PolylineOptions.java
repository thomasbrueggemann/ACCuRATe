package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_980;
import com.google.android.gms.maps.model.class_985;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final class_980 CREATOR = new class_980();
    // $FF: renamed from: BR int
    private final int field_2894;
    private float ajL = 0.0F;
    private boolean ajM = true;
    private float ajQ = 10.0F;
    private final List<LatLng> akl;
    private boolean akn = false;
    private int mColor = -16777216;

    public PolylineOptions() {
        this.field_2894 = 1;
        this.akl = new ArrayList();
    }

    PolylineOptions(int var1, List var2, float var3, int var4, float var5, boolean var6, boolean var7) {
        this.field_2894 = var1;
        this.akl = var2;
        this.ajQ = var3;
        this.mColor = var4;
        this.ajL = var5;
        this.ajM = var6;
        this.akn = var7;
    }

    public PolylineOptions add(LatLng var1) {
        this.akl.add(var1);
        return this;
    }

    public PolylineOptions add(LatLng... var1) {
        this.akl.addAll(Arrays.asList(var1));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            LatLng var3 = (LatLng)var2.next();
            this.akl.add(var3);
        }

        return this;
    }

    public PolylineOptions color(int var1) {
        this.mColor = var1;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean var1) {
        this.akn = var1;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.akl;
    }

    int getVersionCode() {
        return this.field_2894;
    }

    public float getWidth() {
        return this.ajQ;
    }

    public float getZIndex() {
        return this.ajL;
    }

    public boolean isGeodesic() {
        return this.akn;
    }

    public boolean isVisible() {
        return this.ajM;
    }

    public PolylineOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public PolylineOptions width(float var1) {
        this.ajQ = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_985.method_5177(this, var1, var2);
        } else {
            class_980.method_5164(this, var1, var2);
        }
    }

    public PolylineOptions zIndex(float var1) {
        this.ajL = var1;
        return this;
    }
}
