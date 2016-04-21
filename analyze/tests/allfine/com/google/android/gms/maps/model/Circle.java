package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_61;

public final class Circle {
    private final class_61 ajF;

    public Circle(class_61 var1) {
        this.ajF = (class_61)class_1090.method_5685(var1);
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof Circle)) {
            return false;
        } else {
            try {
                boolean var3 = this.ajF.method_309(((Circle)var1).ajF);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public LatLng getCenter() {
        try {
            LatLng var2 = this.ajF.getCenter();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int getFillColor() {
        try {
            int var2 = this.ajF.getFillColor();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getId() {
        try {
            String var2 = this.ajF.getId();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public double getRadius() {
        try {
            double var2 = this.ajF.getRadius();
            return var2;
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public int getStrokeColor() {
        try {
            int var2 = this.ajF.getStrokeColor();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getStrokeWidth() {
        try {
            float var2 = this.ajF.getStrokeWidth();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getZIndex() {
        try {
            float var2 = this.ajF.getZIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.ajF.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isVisible() {
        try {
            boolean var2 = this.ajF.isVisible();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void remove() {
        try {
            this.ajF.remove();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public void setCenter(LatLng var1) {
        try {
            this.ajF.setCenter(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setFillColor(int var1) {
        try {
            this.ajF.setFillColor(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setRadius(double var1) {
        try {
            this.ajF.setRadius(var1);
        } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
        }
    }

    public void setStrokeColor(int var1) {
        try {
            this.ajF.setStrokeColor(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setStrokeWidth(float var1) {
        try {
            this.ajF.setStrokeWidth(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setVisible(boolean var1) {
        try {
            this.ajF.setVisible(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZIndex(float var1) {
        try {
            this.ajF.setZIndex(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
