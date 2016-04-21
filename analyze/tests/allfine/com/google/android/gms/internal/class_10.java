package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.internal.br
public interface class_10 extends IInterface {
    // $FF: renamed from: as () void
    void method_25() throws RemoteException;

    // $FF: renamed from: bt () java.lang.String
    String method_26() throws RemoteException;

    // $FF: renamed from: bu () com.google.android.gms.dynamic.d
    class_206 method_27() throws RemoteException;

    // $FF: renamed from: bv () com.google.android.gms.dynamic.d
    class_206 method_28() throws RemoteException;

    // $FF: renamed from: bw () java.lang.String
    String method_29() throws RemoteException;

    // $FF: renamed from: bx () double
    double method_30() throws RemoteException;

    // $FF: renamed from: by () java.lang.String
    String method_31() throws RemoteException;

    // $FF: renamed from: bz () java.lang.String
    String method_32() throws RemoteException;

    String getBody() throws RemoteException;

    // $FF: renamed from: i (int) void
    void method_33(int var1) throws RemoteException;

    public abstract static class class_1495 extends Binder implements class_10 {
        public class_1495() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.i(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.as();
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String var15 = this.bt();
                    var3.writeNoException();
                    var3.writeString(var15);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    class_206 var13 = this.bu();
                    var3.writeNoException();
                    IBinder var14 = null;
                    if(var13 != null) {
                        var14 = var13.asBinder();
                    }

                    var3.writeStrongBinder(var14);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String var12 = this.getBody();
                    var3.writeNoException();
                    var3.writeString(var12);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    class_206 var10 = this.bv();
                    var3.writeNoException();
                    IBinder var11 = null;
                    if(var10 != null) {
                        var11 = var10.asBinder();
                    }

                    var3.writeStrongBinder(var11);
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String var9 = this.bw();
                    var3.writeNoException();
                    var3.writeString(var9);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double var7 = this.bx();
                    var3.writeNoException();
                    var3.writeDouble(var7);
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String var6 = this.by();
                    var3.writeNoException();
                    var3.writeString(var6);
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String var5 = this.bz();
                    var3.writeNoException();
                    var3.writeString(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }
}
