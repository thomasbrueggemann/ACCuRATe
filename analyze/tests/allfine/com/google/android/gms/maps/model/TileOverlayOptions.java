package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.class_965;
import com.google.android.gms.maps.model.class_969;
import com.google.android.gms.maps.model.internal.class_55;

public final class TileOverlayOptions implements SafeParcelable {
    public static final class_969 CREATOR = new class_969();
    // $FF: renamed from: BR int
    private final int field_4029;
    private float ajL;
    private boolean ajM = true;
    private class_55 akr;
    private TileProvider aks;
    private boolean akt = true;

    public TileOverlayOptions() {
        this.field_4029 = 1;
    }

    TileOverlayOptions(int var1, IBinder var2, boolean var3, float var4, boolean var5) {
        this.field_4029 = var1;
        this.akr = class_55.class_1801.method_3051(var2);
        TileProvider var6;
        if(this.akr == null) {
            var6 = null;
        } else {
            var6 = new TileProvider() {
                private final class_55 aku;

                {
                    this.aku = TileOverlayOptions.this.akr;
                }

                public Tile getTile(int var1, int var2, int var3) {
                    try {
                        Tile var5 = this.aku.getTile(var1, var2, var3);
                        return var5;
                    } catch (RemoteException var6) {
                        return null;
                    }
                }
            };
        }

        this.aks = var6;
        this.ajM = var3;
        this.ajL = var4;
        this.akt = var5;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean var1) {
        this.akt = var1;
        return this;
    }

    public boolean getFadeIn() {
        return this.akt;
    }

    public TileProvider getTileProvider() {
        return this.aks;
    }

    int getVersionCode() {
        return this.field_4029;
    }

    public float getZIndex() {
        return this.ajL;
    }

    public boolean isVisible() {
        return this.ajM;
    }

    // $FF: renamed from: mR () android.os.IBinder
    IBinder method_4401() {
        return this.akr.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider var1) {
        this.aks = var1;
        class_55.class_1801 var2;
        if(this.aks == null) {
            var2 = null;
        } else {
            var2 = new class_55.class_1801() {
                public Tile getTile(int var1x, int var2, int var3) {
                    return var1.getTile(var1x, var2, var3);
                }
            };
        }

        this.akr = var2;
        return this;
    }

    public TileOverlayOptions visible(boolean var1) {
        this.ajM = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_965.method_5117(this, var1, var2);
        } else {
            class_969.method_5125(this, var1, var2);
        }
    }

    public TileOverlayOptions zIndex(float var1) {
        this.ajL = var1;
        return this;
    }
}
