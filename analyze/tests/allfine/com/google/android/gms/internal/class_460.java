package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.ez;
import java.util.Date;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.cw
@ez
public final class class_460 implements MediationAdRequest {
    // $FF: renamed from: d java.util.Date
    private final Date field_1778;
    // $FF: renamed from: f java.util.Set
    private final Set<String> field_1779;
    // $FF: renamed from: g boolean
    private final boolean field_1780;
    // $FF: renamed from: h android.location.Location
    private final Location field_1781;
    // $FF: renamed from: om int
    private final int field_1782;
    // $FF: renamed from: qD int
    private final int field_1783;

    public class_460(Date var1, int var2, Set<String> var3, Location var4, boolean var5, int var6) {
        this.field_1778 = var1;
        this.field_1782 = var2;
        this.field_1779 = var3;
        this.field_1781 = var4;
        this.field_1780 = var5;
        this.field_1783 = var6;
    }

    public Date getBirthday() {
        return this.field_1778;
    }

    public int getGender() {
        return this.field_1782;
    }

    public Set<String> getKeywords() {
        return this.field_1779;
    }

    public Location getLocation() {
        return this.field_1781;
    }

    public boolean isTesting() {
        return this.field_1780;
    }

    public int taggedForChildDirectedTreatment() {
        return this.field_1783;
    }
}
