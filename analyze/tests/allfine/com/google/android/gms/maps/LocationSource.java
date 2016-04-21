package com.google.android.gms.maps;

import android.location.Location;

public interface LocationSource {
    void activate(LocationSource.OnLocationChangedListener var1);

    void deactivate();

    public interface OnLocationChangedListener {
        void onLocationChanged(Location var1);
    }
}
