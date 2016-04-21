package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.class_971;
import com.google.android.gms.maps.model.class_974;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final class_974 CREATOR = new class_974();
    public static final float NO_DIMENSION = -1.0F;
    // $FF: renamed from: BR int
    private final int field_3885;
    private float ajE;
    private float ajL;
    private boolean ajM = true;
    private BitmapDescriptor ajO;
    private LatLng ajP;
    private float ajQ;
    private float ajR;
    private LatLngBounds ajS;
    private float ajT = 0.0F;
    private float ajU = 0.5F;
    private float ajV = 0.5F;

    public GroundOverlayOptions() {
        this.field_3885 = 1;
    }

    GroundOverlayOptions(int var1, IBinder var2, LatLng var3, float var4, float var5, LatLngBounds var6, float var7, float var8, boolean var9, float var10, float var11, float var12) {
        this.field_3885 = var1;
        this.ajO = new BitmapDescriptor(class_206.class_1795.method_5435(var2));
        this.ajP = var3;
        this.ajQ = var4;
        this.ajR = var5;
        this.ajS = var6;
        this.ajE = var7;
        this.ajL = var8;
        this.ajM = var9;
        this.ajT = var10;
        this.ajU = var11;
        this.ajV = var12;
    }

    // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, float, float) com.google.android.gms.maps.model.GroundOverlayOptions
    private GroundOverlayOptions method_4201(LatLng var1, float var2, float var3) {
        this.ajP = var1;
        this.ajQ = var2;
        this.ajR = var3;
        return this;
    }

    public GroundOverlayOptions anchor(float var1, float var2) {
        this.ajU = var1;
        this.ajV = var2;
        return this;
    }

    public GroundOverlayOptions bearing(float var1) {
        this.ajE = (360.0F + var1 % 360.0F) % 360.0F;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.ajU;
    }

    public float getAnchorV() {
        return this.ajV;
    }

    public float getBearing() {
        return this.ajE;
    }

    public LatLngBounds getBounds() {
        return this.ajS;
    }

    public float getHeight() {
        return this.ajR;
    }

    public BitmapDescriptor getImage() {
        return this.ajO;
    }

    public LatLng getLocation() {
        return this.ajP;
    }

    public float getTransparency() {
        return this.ajT;
    }

    int getVersionCode() {
        return this.field_3885;
    }

    public float getWidth() {
        return this.ajQ;
    }

    public float getZIndex() {
        return this.ajL;
    }

    public GroundOverlayOptions image(BitmapDescriptor var1) {
        this.ajO = var1;
        return this;
    }

    public boolean isVisible() {
        return this.ajM;
    }

    // $FF: renamed from: mO () android.os.IBinder
    IBinder method_4202() {
        return this.ajO.method_2308().asBinder();
    }

    public GroundOverlayOptions position(LatLng var1, float var2) {
        boolean var3 = true;
        boolean var4;
        if(this.ajS == null) {
            var4 = var3;
        } else {
            var4 = false;
        }

        class_1090.method_5676(var4, "Position has already been set using positionFromBounds");
        boolean var5;
        if(var1 != null) {
            var5 = var3;
        } else {
            var5 = false;
        }

        class_1090.method_5683(var5, "Location must be specified");
        if(var2 < 0.0F) {
            var3 = false;
        }

        class_1090.method_5683(var3, "Width must be non-negative");
        return this.method_4201(var1, var2, -1.0F);
    }

    public GroundOverlayOptions position(LatLng var1, float var2, float var3) {
        boolean var4 = true;
        boolean var5;
        if(this.ajS == null) {
            var5 = var4;
        } else {
            var5 = false;
        }

        class_1090.method_5676(var5, "Position has already been set using positionFromBounds");
        boolean var6;
        if(var1 != null) {
            var6 = var4;
        } else {
            var6 = false;
        }

        class_1090.method_5683(var6, "Location must be specified");
        boolean var7;
        if(var2 >= 0.0F) {
            var7 = var4;
        } else {
            var7 = false;
        }

        class_1090.method_5683(var7, "Width must be non-negative");
        if(var3 < 0.0F) {
            var4 = false;
        }

        class_1090.method_5683(var4, "Height must be non-negative");
        return this.method_4201(var1, var2, var3);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds var1) {
        boolean var2;
        if(this.ajP == null) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5676(var2, "Position has already been set using position: " + this.ajP);
        this.ajS = var1;
        return this;
    }

    public GroundOverlayOptions transparency(float var1) {
        boolean var2;
        if(var1 >= 0.0F && var1 <= 1.0F) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5683(var2, "Transparency must be in the range [0..1]");
        this.ajT = var1;
        return this;
    }

    public GroundOverlayOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_971.method_5147(this, var1, var2);
        } else {
            class_974.method_5152(this, var1, var2);
        }
    }

    public GroundOverlayOptions zIndex(float var1) {
        this.ajL = var1;
        return this;
    }
}
