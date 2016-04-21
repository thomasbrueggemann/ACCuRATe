package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_54;

public final class TileOverlay {
    private final class_54 akq;

    public TileOverlay(class_54 var1) {
        this.akq = (class_54)class_1090.method_5685(var1);
    }

    public void clearTileCache() {
        try {
            this.akq.clearTileCache();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof TileOverlay)) {
            return false;
        } else {
            try {
                boolean var3 = this.akq.method_231(((TileOverlay)var1).akq);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public boolean getFadeIn() {
        try {
            boolean var2 = this.akq.getFadeIn();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getId() {
        try {
            String var2 = this.akq.getId();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public float getZIndex() {
        try {
            float var2 = this.akq.getZIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.akq.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isVisible() {
        try {
            boolean var2 = this.akq.isVisible();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void remove() {
        try {
            this.akq.remove();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public void setFadeIn(boolean var1) {
        try {
            this.akq.setFadeIn(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setVisible(boolean var1) {
        try {
            this.akq.setVisible(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public void setZIndex(float var1) {
        try {
            this.akq.setZIndex(var1);
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
