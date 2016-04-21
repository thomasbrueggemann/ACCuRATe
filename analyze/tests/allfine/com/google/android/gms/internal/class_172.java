package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.or
public interface class_172 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.wallet.fragment.WalletFragmentOptions, android.os.Bundle) void
    void method_817(class_206 var1, WalletFragmentOptions var2, Bundle var3) throws RemoteException;

    int getState() throws RemoteException;

    void initialize(WalletFragmentInitParams var1) throws RemoteException;

    void onActivityResult(int var1, int var2, Intent var3) throws RemoteException;

    void onCreate(Bundle var1) throws RemoteException;

    class_206 onCreateView(class_206 var1, class_206 var2, Bundle var3) throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle var1) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void setEnabled(boolean var1) throws RemoteException;

    void updateMaskedWallet(MaskedWallet var1) throws RemoteException;

    void updateMaskedWalletRequest(MaskedWalletRequest var1) throws RemoteException;

    public abstract static class class_1503 extends Binder implements class_172 {
        // $FF: renamed from: bJ (android.os.IBinder) com.google.android.gms.internal.or
        public static class_172 method_4397(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                return (class_172)(var1 != null && var1 instanceof class_172?(class_172)var1:new class_172.class_1504(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    class_206 var20 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    WalletFragmentOptions var21;
                    if(var2.readInt() != 0) {
                        var21 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
                    } else {
                        var21 = null;
                    }

                    Bundle var22;
                    if(var2.readInt() != 0) {
                        var22 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var22 = null;
                    }

                    this.a(var20, var21, var22);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    Bundle var19;
                    if(var2.readInt() != 0) {
                        var19 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var19 = null;
                    }

                    this.onCreate(var19);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    class_206 var14 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    class_206 var15 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    Bundle var16;
                    if(var2.readInt() != 0) {
                        var16 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var16 = null;
                    }

                    class_206 var17 = this.onCreateView(var14, var15, var16);
                    var3.writeNoException();
                    IBinder var18 = null;
                    if(var17 != null) {
                        var18 = var17.asBinder();
                    }

                    var3.writeStrongBinder(var18);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.onStart();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.onResume();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.onPause();
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.onStop();
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    Bundle var13;
                    if(var2.readInt() != 0) {
                        var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var13 = null;
                    }

                    this.onSaveInstanceState(var13);
                    var3.writeNoException();
                    if(var13 != null) {
                        var3.writeInt(1);
                        var13.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    int var10 = var2.readInt();
                    int var11 = var2.readInt();
                    Intent var12;
                    if(var2.readInt() != 0) {
                        var12 = (Intent)Intent.CREATOR.createFromParcel(var2);
                    } else {
                        var12 = null;
                    }

                    this.onActivityResult(var10, var11, var12);
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    WalletFragmentInitParams var9;
                    if(var2.readInt() != 0) {
                        var9 = (WalletFragmentInitParams)WalletFragmentInitParams.CREATOR.createFromParcel(var2);
                    } else {
                        var9 = null;
                    }

                    this.initialize(var9);
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    MaskedWalletRequest var8;
                    if(var2.readInt() != 0) {
                        var8 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    this.updateMaskedWalletRequest(var8);
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    boolean var7;
                    if(var2.readInt() != 0) {
                        var7 = true;
                    } else {
                        var7 = false;
                    }

                    this.setEnabled(var7);
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    int var6 = this.getState();
                    var3.writeNoException();
                    var3.writeInt(var6);
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    MaskedWallet var5;
                    if(var2.readInt() != 0) {
                        var5 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.updateMaskedWallet(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1504 implements class_172 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3298;

        class_1504(IBinder var1) {
            this.field_3298 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.wallet.fragment.WalletFragmentOptions, android.os.Bundle) void
        public void method_817(class_206 param1, WalletFragmentOptions param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3298;
        }

        public int getState() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                this.field_3298.transact(13, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public void initialize(WalletFragmentInitParams param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onActivityResult(int param1, int param2, Intent param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onCreate(Bundle param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public class_206 onCreateView(class_206 param1, class_206 param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onPause() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                this.field_3298.transact(6, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onResume() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                this.field_3298.transact(5, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onSaveInstanceState(Bundle param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onStart() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                this.field_3298.transact(4, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onStop() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                this.field_3298.transact(7, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void setEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void updateMaskedWallet(MaskedWallet param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void updateMaskedWalletRequest(MaskedWalletRequest param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
