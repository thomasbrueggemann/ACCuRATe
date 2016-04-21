package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_165;
import com.google.android.gms.internal.class_168;
import com.google.android.gms.internal.class_914;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.class_1020;

// $FF: renamed from: com.google.android.gms.internal.ot
public interface class_170 extends IInterface {
    // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_807(Bundle var1, class_165 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.on, android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_808(class_914 var1, Bundle var2, class_165 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_809(FullWalletRequest var1, Bundle var2, class_165 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.ov) void
    void method_810(MaskedWalletRequest var1, Bundle var2, class_168 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_811(MaskedWalletRequest var1, Bundle var2, class_165 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
    void method_812(NotifyTransactionStatusRequest var1, Bundle var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_813(class_1020 var1, Bundle var2, class_165 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.ow) void
    void method_814(String var1, String var2, Bundle var3, class_165 var4) throws RemoteException;

    // $FF: renamed from: p (android.os.Bundle) void
    void method_815(Bundle var1) throws RemoteException;

    public abstract static class class_1237 extends Binder implements class_170 {
        // $FF: renamed from: bL (android.os.IBinder) com.google.android.gms.internal.ot
        public static class_170 method_3247(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
                return (class_170)(var1 != null && var1 instanceof class_170?(class_170)var1:new class_170.class_1238(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    MaskedWalletRequest var20;
                    if(var2.readInt() != 0) {
                        var20 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var20 = null;
                    }

                    Bundle var21;
                    if(var2.readInt() != 0) {
                        var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var21 = null;
                    }

                    this.a(var20, var21, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    FullWalletRequest var18;
                    if(var2.readInt() != 0) {
                        var18 = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var18 = null;
                    }

                    Bundle var19;
                    if(var2.readInt() != 0) {
                        var19 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var19 = null;
                    }

                    this.a(var18, var19, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    String var15 = var2.readString();
                    String var16 = var2.readString();
                    Bundle var17;
                    if(var2.readInt() != 0) {
                        var17 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var17 = null;
                    }

                    this.a(var15, var16, var17, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    NotifyTransactionStatusRequest var13;
                    if(var2.readInt() != 0) {
                        var13 = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var13 = null;
                    }

                    Bundle var14;
                    if(var2.readInt() != 0) {
                        var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var14 = null;
                    }

                    this.a(var13, var14);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    Bundle var12;
                    if(var2.readInt() != 0) {
                        var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var12 = null;
                    }

                    this.a(var12, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    class_1020 var10;
                    if(var2.readInt() != 0) {
                        var10 = (class_1020)class_1020.CREATOR.createFromParcel(var2);
                    } else {
                        var10 = null;
                    }

                    Bundle var11;
                    if(var2.readInt() != 0) {
                        var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var11 = null;
                    }

                    this.a(var10, var11, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    MaskedWalletRequest var8;
                    if(var2.readInt() != 0) {
                        var8 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    Bundle var9;
                    if(var2.readInt() != 0) {
                        var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var9 = null;
                    }

                    this.a(var8, var9, class_168.class_1514.method_5852(var2.readStrongBinder()));
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    class_914 var6;
                    if(var2.readInt() != 0) {
                        var6 = (class_914)class_914.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    Bundle var7;
                    if(var2.readInt() != 0) {
                        var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.a(var6, var7, class_165.class_1511.method_3927(var2.readStrongBinder()));
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    Bundle var5;
                    if(var2.readInt() != 0) {
                        var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.p(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1238 implements class_170 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_1984;

        class_1238(IBinder var1) {
            this.field_1984 = var1;
        }

        // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_807(Bundle param1, class_165 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.on, android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_808(class_914 param1, Bundle param2, class_165 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_809(FullWalletRequest param1, Bundle param2, class_165 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.ov) void
        public void method_810(MaskedWalletRequest param1, Bundle param2, class_168 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_811(MaskedWalletRequest param1, Bundle param2, class_165 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
        public void method_812(NotifyTransactionStatusRequest param1, Bundle param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_813(class_1020 param1, Bundle param2, class_165 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.ow) void
        public void method_814(String param1, String param2, Bundle param3, class_165 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_1984;
        }

        // $FF: renamed from: p (android.os.Bundle) void
        public void method_815(Bundle param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
