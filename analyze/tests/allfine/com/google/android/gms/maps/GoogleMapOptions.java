package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.class_492;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.class_1058;
import com.google.android.gms.maps.class_1060;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.internal.class_817;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final class_1060 CREATOR = new class_1060();
    // $FF: renamed from: BR int
    private final int field_879;
    private Boolean aiG;
    private Boolean aiH;
    private int aiI = -1;
    private CameraPosition aiJ;
    private Boolean aiK;
    private Boolean aiL;
    private Boolean aiM;
    private Boolean aiN;
    private Boolean aiO;
    private Boolean aiP;

    public GoogleMapOptions() {
        this.field_879 = 1;
    }

    GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11) {
        this.field_879 = var1;
        this.aiG = class_817.method_4242(var2);
        this.aiH = class_817.method_4242(var3);
        this.aiI = var4;
        this.aiJ = var5;
        this.aiK = class_817.method_4242(var6);
        this.aiL = class_817.method_4242(var7);
        this.aiM = class_817.method_4242(var8);
        this.aiN = class_817.method_4242(var9);
        this.aiO = class_817.method_4242(var10);
        this.aiP = class_817.method_4242(var11);
    }

    public static GoogleMapOptions createFromAttributes(Context var0, AttributeSet var1) {
        if(var1 == null) {
            return null;
        } else {
            TypedArray var2 = var0.getResources().obtainAttributes(var1, class_492.styleable.MapAttrs);
            GoogleMapOptions var3 = new GoogleMapOptions();
            if(var2.hasValue(class_492.styleable.MapAttrs_mapType)) {
                var3.mapType(var2.getInt(class_492.styleable.MapAttrs_mapType, -1));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_zOrderOnTop)) {
                var3.zOrderOnTop(var2.getBoolean(class_492.styleable.MapAttrs_zOrderOnTop, false));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_useViewLifecycle)) {
                var3.useViewLifecycleInFragment(var2.getBoolean(class_492.styleable.MapAttrs_useViewLifecycle, false));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiCompass)) {
                var3.compassEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiCompass, true));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiRotateGestures)) {
                var3.rotateGesturesEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiRotateGestures, true));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiScrollGestures)) {
                var3.scrollGesturesEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiScrollGestures, true));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiTiltGestures)) {
                var3.tiltGesturesEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiTiltGestures, true));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiZoomGestures)) {
                var3.zoomGesturesEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiZoomGestures, true));
            }

            if(var2.hasValue(class_492.styleable.MapAttrs_uiZoomControls)) {
                var3.zoomControlsEnabled(var2.getBoolean(class_492.styleable.MapAttrs_uiZoomControls, true));
            }

            var3.camera(CameraPosition.createFromAttributes(var0, var1));
            var2.recycle();
            return var3;
        }
    }

    public GoogleMapOptions camera(CameraPosition var1) {
        this.aiJ = var1;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean var1) {
        this.aiL = Boolean.valueOf(var1);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.aiJ;
    }

    public Boolean getCompassEnabled() {
        return this.aiL;
    }

    public int getMapType() {
        return this.aiI;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.aiP;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.aiM;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.aiO;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.aiH;
    }

    int getVersionCode() {
        return this.field_879;
    }

    public Boolean getZOrderOnTop() {
        return this.aiG;
    }

    public Boolean getZoomControlsEnabled() {
        return this.aiK;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.aiN;
    }

    public GoogleMapOptions mapType(int var1) {
        this.aiI = var1;
        return this;
    }

    // $FF: renamed from: mr () byte
    byte method_1794() {
        return class_817.method_4243(this.aiG);
    }

    // $FF: renamed from: ms () byte
    byte method_1795() {
        return class_817.method_4243(this.aiH);
    }

    // $FF: renamed from: mt () byte
    byte method_1796() {
        return class_817.method_4243(this.aiK);
    }

    // $FF: renamed from: mu () byte
    byte method_1797() {
        return class_817.method_4243(this.aiL);
    }

    // $FF: renamed from: mv () byte
    byte method_1798() {
        return class_817.method_4243(this.aiM);
    }

    // $FF: renamed from: mw () byte
    byte method_1799() {
        return class_817.method_4243(this.aiN);
    }

    // $FF: renamed from: mx () byte
    byte method_1800() {
        return class_817.method_4243(this.aiO);
    }

    // $FF: renamed from: my () byte
    byte method_1801() {
        return class_817.method_4243(this.aiP);
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean var1) {
        this.aiP = Boolean.valueOf(var1);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean var1) {
        this.aiM = Boolean.valueOf(var1);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean var1) {
        this.aiO = Boolean.valueOf(var1);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean var1) {
        this.aiH = Boolean.valueOf(var1);
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_1058.method_5538(this, var1, var2);
        } else {
            class_1060.method_5542(this, var1, var2);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean var1) {
        this.aiG = Boolean.valueOf(var1);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean var1) {
        this.aiK = Boolean.valueOf(var1);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean var1) {
        this.aiN = Boolean.valueOf(var1);
        return this;
    }
}
