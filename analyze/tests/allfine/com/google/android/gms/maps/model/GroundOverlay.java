package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_62;

public final class GroundOverlay {
    private final class_62 ajN;

    public GroundOverlay(class_62 var1) {
        this.ajN = (class_62)class_1090.method_5685(var1);
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof GroundOverlay)) {
            return false;
        } else {
            try {
                boolean var3 = this.ajN.method_311(((GroundOverlay)var1).ajN);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public float getBearing() {
        try {
            float var2 = this.ajN.getBearing();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public LatLngBounds getBounds() {
        try {
            LatLngBounds var2 = this.ajN.getBounds();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getHeight() {
        try {
            float var2 = this.ajN.getHeight();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getId() {
        try {
            String var2 = this.ajN.getId();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public LatLng getPosition() {
        try {
            LatLng var2 = this.ajN.getPosition();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getTransparency() {
        try {
            float var2 = this.ajN.getTransparency();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getWidth() {
        try {
            float var2 = this.ajN.getWidth();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getZIndex() {
        try {
            float var2 = this.ajN.getZIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.ajN.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isVisible() {
        try {
            boolean var2 = this.ajN.isVisible();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void remove() {
        try {
            this.ajN.remove();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public void setBearing(float var1) {
        try {
            this.ajN.setBearing(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setDimensions(float var1) {
        try {
            this.ajN.setDimensions(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setDimensions(float var1, float var2) {
        try {
            this.ajN.method_310(var1, var2);
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public void setImage(BitmapDescriptor var1) {
        try {
            this.ajN.method_312(var1.method_2308());
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setPosition(LatLng var1) {
        try {
            this.ajN.setPosition(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setPositionFromBounds(LatLngBounds var1) {
        try {
            this.ajN.setPositionFromBounds(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setTransparency(float var1) {
        try {
            this.ajN.setTransparency(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setVisible(boolean var1) {
        try {
            this.ajN.setVisible(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZIndex(float var1) {
        try {
            this.ajN.setZIndex(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
