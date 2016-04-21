package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.IRoomServiceCallbacks;

public interface IRoomService extends IInterface {
    // $FF: renamed from: Q (boolean) void
    void method_78(boolean var1) throws RemoteException;

    // $FF: renamed from: a (android.os.IBinder, com.google.android.gms.games.internal.IRoomServiceCallbacks) void
    void method_79(IBinder var1, IRoomServiceCallbacks var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, boolean) void
    void method_80(DataHolder var1, boolean var2) throws RemoteException;

    // $FF: renamed from: a (byte[], java.lang.String, int) void
    void method_81(byte[] var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: a (byte[], java.lang.String[]) void
    void method_82(byte[] var1, String[] var2) throws RemoteException;

    // $FF: renamed from: bN (java.lang.String) void
    void method_83(String var1) throws RemoteException;

    // $FF: renamed from: bO (java.lang.String) void
    void method_84(String var1) throws RemoteException;

    // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.String) void
    void method_85(String var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: kG () void
    void method_86() throws RemoteException;

    // $FF: renamed from: kH () void
    void method_87() throws RemoteException;

    // $FF: renamed from: kI () void
    void method_88() throws RemoteException;

    // $FF: renamed from: kJ () void
    void method_89() throws RemoteException;

    // $FF: renamed from: t (java.lang.String, int) void
    void method_90(String var1, int var2) throws RemoteException;

    // $FF: renamed from: u (java.lang.String, int) void
    void method_91(String var1, int var2) throws RemoteException;

    public abstract static class Stub extends Binder implements IRoomService {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.a(var2.readStrongBinder(), IRoomServiceCallbacks.Stub.method_5946(var2.readStrongBinder()));
                    return true;
                case 1002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.kG();
                    return true;
                case 1003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.kH();
                    return true;
                case 1004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.c(var2.readString(), var2.readString(), var2.readString());
                    return true;
                case 1005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.kI();
                    return true;
                case 1006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder var7;
                    if(var2.readInt() != 0) {
                        var7 = DataHolder.CREATOR.method_5521(var2);
                    } else {
                        var7 = null;
                    }

                    int var8 = var2.readInt();
                    boolean var9 = false;
                    if(var8 != 0) {
                        var9 = true;
                    }

                    this.a(var7, var9);
                    return true;
                case 1007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.kJ();
                    return true;
                case 1008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    int var5 = var2.readInt();
                    boolean var6 = false;
                    if(var5 != 0) {
                        var6 = true;
                    }

                    this.Q(var6);
                    return true;
                case 1009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.a(var2.createByteArray(), var2.readString(), var2.readInt());
                    return true;
                case 1010:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.a(var2.createByteArray(), var2.createStringArray());
                    return true;
                case 1011:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.t(var2.readString(), var2.readInt());
                    return true;
                case 1012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.u(var2.readString(), var2.readInt());
                    return true;
                case 1013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.bN(var2.readString());
                    return true;
                case 1014:
                    var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    this.bO(var2.readString());
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class Proxy implements IRoomService {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5069;

        // $FF: renamed from: Q (boolean) void
        public void method_78(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (android.os.IBinder, com.google.android.gms.games.internal.IRoomServiceCallbacks) void
        public void method_79(IBinder param1, IRoomServiceCallbacks param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, boolean) void
        public void method_80(DataHolder param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (byte[], java.lang.String, int) void
        public void method_81(byte[] var1, String var2, int var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var4.writeByteArray(var1);
                var4.writeString(var2);
                var4.writeInt(var3);
                this.field_5069.transact(1009, var4, (Parcel)null, 1);
            } finally {
                var4.recycle();
            }

        }

        // $FF: renamed from: a (byte[], java.lang.String[]) void
        public void method_82(byte[] var1, String[] var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var3.writeByteArray(var1);
                var3.writeStringArray(var2);
                this.field_5069.transact(1010, var3, (Parcel)null, 1);
            } finally {
                var3.recycle();
            }

        }

        public IBinder asBinder() {
            return this.field_5069;
        }

        // $FF: renamed from: bN (java.lang.String) void
        public void method_83(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var2.writeString(var1);
                this.field_5069.transact(1013, var2, (Parcel)null, 1);
            } finally {
                var2.recycle();
            }

        }

        // $FF: renamed from: bO (java.lang.String) void
        public void method_84(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var2.writeString(var1);
                this.field_5069.transact(1014, var2, (Parcel)null, 1);
            } finally {
                var2.recycle();
            }

        }

        // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.String) void
        public void method_85(String var1, String var2, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var4.writeString(var1);
                var4.writeString(var2);
                var4.writeString(var3);
                this.field_5069.transact(1004, var4, (Parcel)null, 1);
            } finally {
                var4.recycle();
            }

        }

        // $FF: renamed from: kG () void
        public void method_86() throws RemoteException {
            Parcel var1 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                this.field_5069.transact(1002, var1, (Parcel)null, 1);
            } finally {
                var1.recycle();
            }

        }

        // $FF: renamed from: kH () void
        public void method_87() throws RemoteException {
            Parcel var1 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                this.field_5069.transact(1003, var1, (Parcel)null, 1);
            } finally {
                var1.recycle();
            }

        }

        // $FF: renamed from: kI () void
        public void method_88() throws RemoteException {
            Parcel var1 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                this.field_5069.transact(1005, var1, (Parcel)null, 1);
            } finally {
                var1.recycle();
            }

        }

        // $FF: renamed from: kJ () void
        public void method_89() throws RemoteException {
            Parcel var1 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                this.field_5069.transact(1007, var1, (Parcel)null, 1);
            } finally {
                var1.recycle();
            }

        }

        // $FF: renamed from: t (java.lang.String, int) void
        public void method_90(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_5069.transact(1011, var3, (Parcel)null, 1);
            } finally {
                var3.recycle();
            }

        }

        // $FF: renamed from: u (java.lang.String, int) void
        public void method_91(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_5069.transact(1012, var3, (Parcel)null, 1);
            } finally {
                var3.recycle();
            }

        }
    }
}
