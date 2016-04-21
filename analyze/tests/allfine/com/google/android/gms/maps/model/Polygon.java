package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_57;
import java.util.List;

public final class Polygon {
    private final class_57 akk;

    public Polygon(class_57 var1) {
        this.akk = (class_57)class_1090.method_5685(var1);
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof Polygon)) {
            return false;
        } else {
            try {
                boolean var3 = this.akk.method_299(((Polygon)var1).akk);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public int getFillColor() {
        try {
            int var2 = this.akk.getFillColor();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public List<List<LatLng>> getHoles() {
        try {
            List var2 = this.akk.getHoles();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getId() {
        try {
            String var2 = this.akk.getId();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public List<LatLng> getPoints() {
        try {
            List var2 = this.akk.getPoints();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int getStrokeColor() {
        try {
            int var2 = this.akk.getStrokeColor();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getStrokeWidth() {
        try {
            float var2 = this.akk.getStrokeWidth();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getZIndex() {
        try {
            float var2 = this.akk.getZIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.akk.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isGeodesic() {
        try {
            boolean var2 = this.akk.isGeodesic();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isVisible() {
        try {
            boolean var2 = this.akk.isVisible();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void remove() {
        try {
            this.akk.remove();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public void setFillColor(int var1) {
        try {
            this.akk.setFillColor(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setGeodesic(boolean var1) {
        try {
            this.akk.setGeodesic(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setHoles(List<? extends List<LatLng>> var1) {
        try {
            this.akk.setHoles(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setPoints(List<LatLng> var1) {
        try {
            this.akk.setPoints(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setStrokeColor(int var1) {
        try {
            this.akk.setStrokeColor(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setStrokeWidth(float var1) {
        try {
            this.akk.setStrokeWidth(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setVisible(boolean var1) {
        try {
            this.akk.setVisible(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZIndex(float var1) {
        try {
            this.akk.setZIndex(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
