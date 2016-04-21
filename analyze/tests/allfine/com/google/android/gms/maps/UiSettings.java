package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings {
    private final IUiSettingsDelegate ajw;

    UiSettings(IUiSettingsDelegate var1) {
        this.ajw = var1;
    }

    public boolean isCompassEnabled() {
        try {
            boolean var2 = this.ajw.isCompassEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            boolean var2 = this.ajw.isIndoorLevelPickerEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            boolean var2 = this.ajw.isMyLocationButtonEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            boolean var2 = this.ajw.isRotateGesturesEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            boolean var2 = this.ajw.isScrollGesturesEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            boolean var2 = this.ajw.isTiltGesturesEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            boolean var2 = this.ajw.isZoomControlsEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            boolean var2 = this.ajw.isZoomGesturesEnabled();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setAllGesturesEnabled(boolean var1) {
        try {
            this.ajw.setAllGesturesEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setCompassEnabled(boolean var1) {
        try {
            this.ajw.setCompassEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean var1) {
        try {
            this.ajw.setIndoorLevelPickerEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setMyLocationButtonEnabled(boolean var1) {
        try {
            this.ajw.setMyLocationButtonEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setRotateGesturesEnabled(boolean var1) {
        try {
            this.ajw.setRotateGesturesEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setScrollGesturesEnabled(boolean var1) {
        try {
            this.ajw.setScrollGesturesEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setTiltGesturesEnabled(boolean var1) {
        try {
            this.ajw.setTiltGesturesEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZoomControlsEnabled(boolean var1) {
        try {
            this.ajw.setZoomControlsEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZoomGesturesEnabled(boolean var1) {
        try {
            this.ajw.setZoomGesturesEnabled(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
