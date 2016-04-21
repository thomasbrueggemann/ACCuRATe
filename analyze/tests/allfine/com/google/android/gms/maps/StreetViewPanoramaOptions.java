package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.class_1059;
import com.google.android.gms.maps.internal.class_817;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final class_1059 CREATOR = new class_1059();
    // $FF: renamed from: BR int
    private final int field_4962;
    private Boolean aiH;
    private Boolean aiN = Boolean.valueOf(true);
    private StreetViewPanoramaCamera ajj;
    private String ajk;
    private LatLng ajl;
    private Integer ajm;
    private Boolean ajn = Boolean.valueOf(true);
    private Boolean ajo = Boolean.valueOf(true);
    private Boolean ajp = Boolean.valueOf(true);

    public StreetViewPanoramaOptions() {
        this.field_4962 = 1;
    }

    StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
        this.field_4962 = var1;
        this.ajj = var2;
        this.ajl = var4;
        this.ajm = var5;
        this.ajk = var3;
        this.ajn = class_817.method_4242(var6);
        this.aiN = class_817.method_4242(var7);
        this.ajo = class_817.method_4242(var8);
        this.ajp = class_817.method_4242(var9);
        this.aiH = class_817.method_4242(var10);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.ajo;
    }

    public String getPanoramaId() {
        return this.ajk;
    }

    public LatLng getPosition() {
        return this.ajl;
    }

    public Integer getRadius() {
        return this.ajm;
    }

    public Boolean getStreetNamesEnabled() {
        return this.ajp;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.ajj;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.aiH;
    }

    public Boolean getUserNavigationEnabled() {
        return this.ajn;
    }

    int getVersionCode() {
        return this.field_4962;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.aiN;
    }

    // $FF: renamed from: mE () byte
    byte method_5496() {
        return class_817.method_4243(this.ajn);
    }

    // $FF: renamed from: mF () byte
    byte method_5497() {
        return class_817.method_4243(this.ajo);
    }

    // $FF: renamed from: mG () byte
    byte method_5498() {
        return class_817.method_4243(this.ajp);
    }

    // $FF: renamed from: ms () byte
    byte method_5499() {
        return class_817.method_4243(this.aiH);
    }

    // $FF: renamed from: mw () byte
    byte method_5500() {
        return class_817.method_4243(this.aiN);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean var1) {
        this.ajo = Boolean.valueOf(var1);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera var1) {
        this.ajj = var1;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String var1) {
        this.ajk = var1;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng var1) {
        this.ajl = var1;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng var1, Integer var2) {
        this.ajl = var1;
        this.ajm = var2;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean var1) {
        this.ajp = Boolean.valueOf(var1);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean var1) {
        this.aiH = Boolean.valueOf(var1);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean var1) {
        this.ajn = Boolean.valueOf(var1);
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1059.method_5539(this, var1, var2);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean var1) {
        this.aiN = Boolean.valueOf(var1);
        return this;
    }
}
