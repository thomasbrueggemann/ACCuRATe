package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_19;

// $FF: renamed from: com.google.android.gms.internal.id
public interface class_18 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.ic) void
    void method_121(class_19 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ic, int) void
    void method_122(class_19 var1, int var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ic, int, java.lang.String, byte[]) void
    void method_123(class_19 var1, int var2, String var3, byte[] var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ic, int, byte[]) void
    void method_124(class_19 var1, int var2, byte[] var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.internal.ic) void
    void method_125(class_19 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.internal.ic, int) void
    void method_126(class_19 var1, int var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.internal.ic) void
    void method_127(class_19 var1) throws RemoteException;

    // $FF: renamed from: fq () int
    int method_128() throws RemoteException;

    // $FF: renamed from: fr () int
    int method_129() throws RemoteException;

    public abstract static class class_1488 extends Binder implements class_18 {
        // $FF: renamed from: K (android.os.IBinder) com.google.android.gms.internal.id
        public static class_18 method_3902(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
                return (class_18)(var1 != null && var1 instanceof class_18?(class_18)var1:new class_18.class_1489(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 5001:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int var6 = this.fq();
                    var3.writeNoException();
                    var3.writeInt(var6);
                    return true;
                case 5002:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int var5 = this.fr();
                    var3.writeNoException();
                    var3.writeInt(var5);
                    return true;
                case 5003:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(class_19.class_1490.method_2313(var2.readStrongBinder()), var2.readInt(), var2.createByteArray());
                    var3.writeNoException();
                    return true;
                case 5004:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(class_19.class_1490.method_2313(var2.readStrongBinder()), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5005:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(class_19.class_1490.method_2313(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5006:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.a(class_19.class_1490.method_2313(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.createByteArray());
                    var3.writeNoException();
                    return true;
                case 5007:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.b(class_19.class_1490.method_2313(var2.readStrongBinder()), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5008:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.b(class_19.class_1490.method_2313(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5009:
                    var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    this.c(class_19.class_1490.method_2313(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1489 implements class_18 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3955;

        class_1489(IBinder var1) {
            this.field_3955 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ic) void
        public void method_121(class_19 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ic, int) void
        public void method_122(class_19 param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ic, int, java.lang.String, byte[]) void
        public void method_123(class_19 param1, int param2, String param3, byte[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ic, int, byte[]) void
        public void method_124(class_19 param1, int param2, byte[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3955;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ic) void
        public void method_125(class_19 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.internal.ic, int) void
        public void method_126(class_19 param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.internal.ic) void
        public void method_127(class_19 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: fq () int
        public int method_128() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                this.field_3955.transact(5001, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: fr () int
        public int method_129() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                this.field_3955.transact(5002, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }
    }
}
