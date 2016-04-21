package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface IGamesSignInCallbacks extends IInterface {
    // $FF: renamed from: T (com.google.android.gms.common.data.DataHolder) void
    void method_833(DataHolder var1) throws RemoteException;

    // $FF: renamed from: U (com.google.android.gms.common.data.DataHolder) void
    void method_834(DataHolder var1) throws RemoteException;

    // $FF: renamed from: b (int, android.content.Intent) void
    void method_835(int var1, Intent var2) throws RemoteException;

    // $FF: renamed from: dD (int) void
    void method_836(int var1) throws RemoteException;

    // $FF: renamed from: dE (int) void
    void method_837(int var1) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
    void method_838(DataHolder var1) throws RemoteException;

    public abstract static class Stub extends Binder implements IGamesSignInCallbacks {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
        }

        // $FF: renamed from: aC (android.os.IBinder) com.google.android.gms.games.internal.IGamesSignInCallbacks
        public static IGamesSignInCallbacks method_5347(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                return (IGamesSignInCallbacks)(var1 != null && var1 instanceof IGamesSignInCallbacks?(IGamesSignInCallbacks)var1:new IGamesSignInCallbacks.Proxy(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 5001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int var11 = var2.readInt();
                    int var12 = var2.readInt();
                    Intent var13 = null;
                    if(var12 != 0) {
                        var13 = (Intent)Intent.CREATOR.createFromParcel(var2);
                    }

                    this.b(var11, var13);
                    var3.writeNoException();
                    return true;
                case 5002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int var9 = var2.readInt();
                    DataHolder var10 = null;
                    if(var9 != 0) {
                        var10 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.T(var10);
                    var3.writeNoException();
                    return true;
                case 5003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int var7 = var2.readInt();
                    DataHolder var8 = null;
                    if(var7 != 0) {
                        var8 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.U(var8);
                    var3.writeNoException();
                    return true;
                case 5004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    this.dD(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int var5 = var2.readInt();
                    DataHolder var6 = null;
                    if(var5 != 0) {
                        var6 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.g(var6);
                    var3.writeNoException();
                    return true;
                case 5006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    this.dE(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class Proxy implements IGamesSignInCallbacks {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4316;

        Proxy(IBinder var1) {
            this.field_4316 = var1;
        }

        // $FF: renamed from: T (com.google.android.gms.common.data.DataHolder) void
        public void method_833(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: U (com.google.android.gms.common.data.DataHolder) void
        public void method_834(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4316;
        }

        // $FF: renamed from: b (int, android.content.Intent) void
        public void method_835(int param1, Intent param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: dD (int) void
        public void method_836(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                var2.writeInt(var1);
                this.field_4316.transact(5004, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        // $FF: renamed from: dE (int) void
        public void method_837(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                var2.writeInt(var1);
                this.field_4316.transact(5006, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
        public void method_838(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
