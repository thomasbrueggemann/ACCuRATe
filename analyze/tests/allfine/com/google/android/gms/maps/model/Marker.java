package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_56;

public final class Marker {
    private final class_56 akc;

    public Marker(class_56 var1) {
        this.akc = (class_56)class_1090.method_5685(var1);
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof Marker)) {
            return false;
        } else {
            try {
                boolean var3 = this.akc.method_232(((Marker)var1).akc);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public float getAlpha() {
        try {
            float var2 = this.akc.getAlpha();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getId() {
        try {
            String var2 = this.akc.getId();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public LatLng getPosition() {
        try {
            LatLng var2 = this.akc.getPosition();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getRotation() {
        try {
            float var2 = this.akc.getRotation();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getSnippet() {
        try {
            String var2 = this.akc.getSnippet();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getTitle() {
        try {
            String var2 = this.akc.getTitle();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.akc.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void hideInfoWindow() {
        try {
            this.akc.hideInfoWindow();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public boolean isDraggable() {
        try {
            boolean var2 = this.akc.isDraggable();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isFlat() {
        try {
            boolean var2 = this.akc.isFlat();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            boolean var2 = this.akc.isInfoWindowShown();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isVisible() {
        try {
            boolean var2 = this.akc.isVisible();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void remove() {
        try {
            this.akc.remove();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public void setAlpha(float var1) {
        try {
            this.akc.setAlpha(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setAnchor(float var1, float var2) {
        try {
            this.akc.setAnchor(var1, var2);
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public void setDraggable(boolean var1) {
        try {
            this.akc.setDraggable(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setFlat(boolean var1) {
        try {
            this.akc.setFlat(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setIcon(BitmapDescriptor var1) {
        try {
            this.akc.method_233(var1.method_2308());
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setInfoWindowAnchor(float var1, float var2) {
        try {
            this.akc.setInfoWindowAnchor(var1, var2);
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public void setPosition(LatLng var1) {
        try {
            this.akc.setPosition(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setRotation(float var1) {
        try {
            this.akc.setRotation(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setSnippet(String var1) {
        try {
            this.akc.setSnippet(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setTitle(String var1) {
        try {
            this.akc.setTitle(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setVisible(boolean var1) {
        try {
            this.akc.setVisible(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void showInfoWindow() {
        try {
            this.akc.showInfoWindow();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }
}
