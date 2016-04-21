package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_59;
import java.util.List;

public final class IndoorBuilding {
    private final class_59 ajW;

    public IndoorBuilding(class_59 var1) {
        this.ajW = (class_59)class_1090.method_5685(var1);
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof IndoorBuilding)) {
            return false;
        } else {
            try {
                boolean var3 = this.ajW.method_307(((IndoorBuilding)var1).ajW);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public int getActiveLevelIndex() {
        try {
            int var2 = this.ajW.getActiveLevelIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            int var2 = this.ajW.getActiveLevelIndex();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public List<IndoorLevel> getLevels() {
        // $FF: Couldn't be decompiled
    }

    public int hashCode() {
        try {
            int var2 = this.ajW.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public boolean isUnderground() {
        try {
            boolean var2 = this.ajW.isUnderground();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
