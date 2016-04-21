package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.internal.IGamesSignInCallbacks;

public interface IGamesSignInService extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String) void
    void method_901(IGamesSignInCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String) void
    void method_902(IGamesSignInCallbacks var1, String var2, String var3, String var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]) void
    void method_903(IGamesSignInCallbacks var1, String var2, String var3, String var4, String[] var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
    void method_904(IGamesSignInCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String[], java.lang.String) void
    void method_905(IGamesSignInCallbacks var1, String var2, String var3, String[] var4, String var5) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String) void
    void method_906(IGamesSignInCallbacks var1, String var2, String var3, String var4) throws RemoteException;

    // $FF: renamed from: bL (java.lang.String) java.lang.String
    String method_907(String var1) throws RemoteException;

    // $FF: renamed from: bM (java.lang.String) java.lang.String
    String method_908(String var1) throws RemoteException;

    // $FF: renamed from: h (java.lang.String, boolean) java.lang.String
    String method_909(String var1, boolean var2) throws RemoteException;

    // $FF: renamed from: w (java.lang.String, java.lang.String) void
    void method_910(String var1, String var2) throws RemoteException;

    public abstract static class Stub extends Binder implements IGamesSignInService {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 5001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String var9 = this.bL(var2.readString());
                    var3.writeNoException();
                    var3.writeString(var9);
                    return true;
                case 5002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String var8 = this.bM(var2.readString());
                    var3.writeNoException();
                    var3.writeString(var8);
                    return true;
                case 5003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.a(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.a(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 5005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.a(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.a(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.b(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.a(IGamesSignInCallbacks.Stub.method_5347(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString(), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 5009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String var5 = var2.readString();
                    boolean var6;
                    if(var2.readInt() != 0) {
                        var6 = true;
                    } else {
                        var6 = false;
                    }

                    String var7 = this.h(var5, var6);
                    var3.writeNoException();
                    var3.writeString(var7);
                    return true;
                case 9001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    this.w(var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.games.internal.IGamesSignInService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class Proxy implements IGamesSignInService {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_1671;

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String) void
        public void method_901(IGamesSignInCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String) void
        public void method_902(IGamesSignInCallbacks param1, String param2, String param3, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]) void
        public void method_903(IGamesSignInCallbacks param1, String param2, String param3, String param4, String[] param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
        public void method_904(IGamesSignInCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String[], java.lang.String) void
        public void method_905(IGamesSignInCallbacks param1, String param2, String param3, String[] param4, String param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_1671;
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesSignInCallbacks, java.lang.String, java.lang.String, java.lang.String) void
        public void method_906(IGamesSignInCallbacks param1, String param2, String param3, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: bL (java.lang.String) java.lang.String
        public String method_907(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            String var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                var2.writeString(var1);
                this.field_1671.transact(5001, var2, var3, 0);
                var3.readException();
                var6 = var3.readString();
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: bM (java.lang.String) java.lang.String
        public String method_908(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            String var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                var2.writeString(var1);
                this.field_1671.transact(5002, var2, var3, 0);
                var3.readException();
                var6 = var3.readString();
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: h (java.lang.String, boolean) java.lang.String
        public String method_909(String param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: w (java.lang.String, java.lang.String) void
        public void method_910(String var1, String var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                var3.writeString(var1);
                var3.writeString(var2);
                this.field_1671.transact(9001, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }
    }
}
