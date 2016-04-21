package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_60;

public final class IndoorLevel {
    private final class_60 ajX;

    public IndoorLevel(class_60 var1) {
        this.ajX = (class_60)class_1090.method_5685(var1);
    }

    public void activate() {
        try {
            this.ajX.activate();
        } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
        }
    }

    public boolean equals(Object var1) {
        if(!(var1 instanceof IndoorLevel)) {
            return false;
        } else {
            try {
                boolean var3 = this.ajX.method_308(((IndoorLevel)var1).ajX);
                return var3;
            } catch (RemoteException var4) {
                throw new RuntimeRemoteException(var4);
            }
        }
    }

    public String getName() {
        try {
            String var2 = this.ajX.getName();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public String getShortName() {
        try {
            String var2 = this.ajX.getShortName();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }

    public int hashCode() {
        try {
            int var2 = this.ajX.hashCodeRemote();
            return var2;
        } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
        }
    }
}
