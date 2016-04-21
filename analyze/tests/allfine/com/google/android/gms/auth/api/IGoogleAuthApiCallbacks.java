package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.GoogleAuthApiResponse;

public interface IGoogleAuthApiCallbacks extends IInterface {
    void onConnectionSuccess(GoogleAuthApiResponse var1) throws RemoteException;

    void onError(int var1, String var2, PendingIntent var3) throws RemoteException;

    public abstract static class Stub extends Binder implements IGoogleAuthApiCallbacks {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        }

        public static IGoogleAuthApiCallbacks asInterface(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                return (IGoogleAuthApiCallbacks)(var1 != null && var1 instanceof IGoogleAuthApiCallbacks?(IGoogleAuthApiCallbacks)var1:new IGoogleAuthApiCallbacks.class_1200(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    int var9 = var2.readInt();
                    GoogleAuthApiResponse var10 = null;
                    if(var9 != 0) {
                        var10 = GoogleAuthApiResponse.CREATOR.createFromParcel(var2);
                    }

                    this.onConnectionSuccess(var10);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    int var5 = var2.readInt();
                    String var6 = var2.readString();
                    int var7 = var2.readInt();
                    PendingIntent var8 = null;
                    if(var7 != 0) {
                        var8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    }

                    this.onError(var5, var6, var8);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1200 implements IGoogleAuthApiCallbacks {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_1317;

        class_1200(IBinder var1) {
            this.field_1317 = var1;
        }

        public IBinder asBinder() {
            return this.field_1317;
        }

        public void onConnectionSuccess(GoogleAuthApiResponse param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onError(int param1, String param2, PendingIntent param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
