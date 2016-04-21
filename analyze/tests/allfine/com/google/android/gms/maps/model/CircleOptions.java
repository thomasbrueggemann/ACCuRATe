package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_973;
import com.google.android.gms.maps.model.class_987;

public final class CircleOptions implements SafeParcelable {
    public static final class_987 CREATOR = new class_987();
    // $FF: renamed from: BR int
    private final int field_4896;
    private LatLng ajG = null;
    private double ajH = 0.0D;
    private float ajI = 10.0F;
    private int ajJ = -16777216;
    private int ajK = 0;
    private float ajL = 0.0F;
    private boolean ajM = true;

    public CircleOptions() {
        this.field_4896 = 1;
    }

    CircleOptions(int var1, LatLng var2, double var3, float var5, int var6, int var7, float var8, boolean var9) {
        this.field_4896 = var1;
        this.ajG = var2;
        this.ajH = var3;
        this.ajI = var5;
        this.ajJ = var6;
        this.ajK = var7;
        this.ajL = var8;
        this.ajM = var9;
    }

    public CircleOptions center(LatLng var1) {
        this.ajG = var1;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int var1) {
        this.ajK = var1;
        return this;
    }

    public LatLng getCenter() {
        return this.ajG;
    }

    public int getFillColor() {
        return this.ajK;
    }

    public double getRadius() {
        return this.ajH;
    }

    public int getStrokeColor() {
        return this.ajJ;
    }

    public float getStrokeWidth() {
        return this.ajI;
    }

    int getVersionCode() {
        return this.field_4896;
    }

    public float getZIndex() {
        return this.ajL;
    }

    public boolean isVisible() {
        return this.ajM;
    }

    public CircleOptions radius(double var1) {
        this.ajH = var1;
        return this;
    }

    public CircleOptions strokeColor(int var1) {
        this.ajJ = var1;
        return this;
    }

    public CircleOptions strokeWidth(float var1) {
        this.ajI = var1;
        return this;
    }

    public CircleOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_973.method_5151(this, var1, var2);
        } else {
            class_987.method_5181(this, var1, var2);
        }
    }

    public CircleOptions zIndex(float var1) {
        this.ajL = var1;
        return this;
    }
}
