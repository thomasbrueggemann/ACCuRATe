package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_979;
import com.google.android.gms.maps.model.class_982;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final class_982 CREATOR = new class_982();
    // $FF: renamed from: BR int
    private final int field_4390;
    private float ajI = 10.0F;
    private int ajJ = -16777216;
    private int ajK = 0;
    private float ajL = 0.0F;
    private boolean ajM = true;
    private final List<LatLng> akl;
    private final List<List<LatLng>> akm;
    private boolean akn = false;

    public PolygonOptions() {
        this.field_4390 = 1;
        this.akl = new ArrayList();
        this.akm = new ArrayList();
    }

    PolygonOptions(int var1, List<LatLng> var2, List var3, float var4, int var5, int var6, float var7, boolean var8, boolean var9) {
        this.field_4390 = var1;
        this.akl = var2;
        this.akm = var3;
        this.ajI = var4;
        this.ajJ = var5;
        this.ajK = var6;
        this.ajL = var7;
        this.ajM = var8;
        this.akn = var9;
    }

    public PolygonOptions add(LatLng var1) {
        this.akl.add(var1);
        return this;
    }

    public PolygonOptions add(LatLng... var1) {
        this.akl.addAll(Arrays.asList(var1));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            LatLng var3 = (LatLng)var2.next();
            this.akl.add(var3);
        }

        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            var2.add((LatLng)var3.next());
        }

        this.akm.add(var2);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int var1) {
        this.ajK = var1;
        return this;
    }

    public PolygonOptions geodesic(boolean var1) {
        this.akn = var1;
        return this;
    }

    public int getFillColor() {
        return this.ajK;
    }

    public List<List<LatLng>> getHoles() {
        return this.akm;
    }

    public List<LatLng> getPoints() {
        return this.akl;
    }

    public int getStrokeColor() {
        return this.ajJ;
    }

    public float getStrokeWidth() {
        return this.ajI;
    }

    int getVersionCode() {
        return this.field_4390;
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

    // $FF: renamed from: mQ () java.util.List
    List method_4976() {
        return this.akm;
    }

    public PolygonOptions strokeColor(int var1) {
        this.ajJ = var1;
        return this;
    }

    public PolygonOptions strokeWidth(float var1) {
        this.ajI = var1;
        return this;
    }

    public PolygonOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_979.method_5163(this, var1, var2);
        } else {
            class_982.method_5168(this, var1, var2);
        }
    }

    public PolygonOptions zIndex(float var1) {
        this.ajL = var1;
        return this;
    }
}
