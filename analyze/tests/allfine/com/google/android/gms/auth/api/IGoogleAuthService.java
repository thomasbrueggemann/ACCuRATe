package com.google.android.gms.auth.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.GoogleAuthApiRequest;
import com.google.android.gms.auth.api.IGoogleAuthApiCallbacks;

public interface IGoogleAuthService extends IInterface {
    void sendConnection(IGoogleAuthApiCallbacks var1, GoogleAuthApiRequest var2) throws RemoteException;

    public abstract static class Stub extends Binder implements IGoogleAuthService {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthService");
        }

        public static IGoogleAuthService asInterface(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthService");
                return (IGoogleAuthService)(var1 != null && var1 instanceof IGoogleAuthService?(IGoogleAuthService)var1:new IGoogleAuthService.class_1254(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthService");
                    IGoogleAuthApiCallbacks var5 = IGoogleAuthApiCallbacks.Stub.asInterface(var2.readStrongBinder());
                    GoogleAuthApiRequest var6;
                    if(var2.readInt() != 0) {
                        var6 = GoogleAuthApiRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    this.sendConnection(var5, var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.auth.api.IGoogleAuthService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1254 implements IGoogleAuthService {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4751;

        class_1254(IBinder var1) {
            this.field_4751 = var1;
        }

        public IBinder asBinder() {
            return this.field_4751;
        }

        public void sendConnection(IGoogleAuthApiCallbacks param1, GoogleAuthApiRequest param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
