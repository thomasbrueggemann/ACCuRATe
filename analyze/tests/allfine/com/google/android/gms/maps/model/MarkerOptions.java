package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.class_976;
import com.google.android.gms.maps.model.class_981;

public final class MarkerOptions implements SafeParcelable {
    public static final class_976 CREATOR = new class_976();
    // $FF: renamed from: BR int
    private final int field_2235;
    // $FF: renamed from: Nw java.lang.String
    private String field_2236;
    private boolean ajM = true;
    private float ajU = 0.5F;
    private float ajV = 1.0F;
    private LatLng ajl;
    private String akd;
    private BitmapDescriptor ake;
    private boolean akf;
    private boolean akg = false;
    private float akh = 0.0F;
    private float aki = 0.5F;
    private float akj = 0.0F;
    private float mAlpha = 1.0F;

    public MarkerOptions() {
        this.field_2235 = 1;
    }

    MarkerOptions(int var1, LatLng var2, String var3, String var4, IBinder var5, float var6, float var7, boolean var8, boolean var9, boolean var10, float var11, float var12, float var13, float var14) {
        this.field_2235 = var1;
        this.ajl = var2;
        this.field_2236 = var3;
        this.akd = var4;
        BitmapDescriptor var15;
        if(var5 == null) {
            var15 = null;
        } else {
            var15 = new BitmapDescriptor(class_206.class_1795.method_5435(var5));
        }

        this.ake = var15;
        this.ajU = var6;
        this.ajV = var7;
        this.akf = var8;
        this.ajM = var9;
        this.akg = var10;
        this.akh = var11;
        this.aki = var12;
        this.akj = var13;
        this.mAlpha = var14;
    }

    public MarkerOptions alpha(float var1) {
        this.mAlpha = var1;
        return this;
    }

    public MarkerOptions anchor(float var1, float var2) {
        this.ajU = var1;
        this.ajV = var2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean var1) {
        this.akf = var1;
        return this;
    }

    public MarkerOptions flat(boolean var1) {
        this.akg = var1;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.ajU;
    }

    public float getAnchorV() {
        return this.ajV;
    }

    public BitmapDescriptor getIcon() {
        return this.ake;
    }

    public float getInfoWindowAnchorU() {
        return this.aki;
    }

    public float getInfoWindowAnchorV() {
        return this.akj;
    }

    public LatLng getPosition() {
        return this.ajl;
    }

    public float getRotation() {
        return this.akh;
    }

    public String getSnippet() {
        return this.akd;
    }

    public String getTitle() {
        return this.field_2236;
    }

    int getVersionCode() {
        return this.field_2235;
    }

    public MarkerOptions icon(BitmapDescriptor var1) {
        this.ake = var1;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float var1, float var2) {
        this.aki = var1;
        this.akj = var2;
        return this;
    }

    public boolean isDraggable() {
        return this.akf;
    }

    public boolean isFlat() {
        return this.akg;
    }

    public boolean isVisible() {
        return this.ajM;
    }

    // $FF: renamed from: mP () android.os.IBinder
    IBinder method_3184() {
        return this.ake == null?null:this.ake.method_2308().asBinder();
    }

    public MarkerOptions position(LatLng var1) {
        this.ajl = var1;
        return this;
    }

    public MarkerOptions rotation(float var1) {
        this.akh = var1;
        return this;
    }

    public MarkerOptions snippet(String var1) {
        this.akd = var1;
        return this;
    }

    public MarkerOptions title(String var1) {
        this.field_2236 = var1;
        return this;
    }

    public MarkerOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_981.method_5167(this, var1, var2);
        } else {
            class_976.method_5156(this, var1, var2);
        }
    }
}
