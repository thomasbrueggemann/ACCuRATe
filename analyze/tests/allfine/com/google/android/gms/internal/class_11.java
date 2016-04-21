package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.internal.bs
public interface class_11 extends IInterface {
    // $FF: renamed from: as () void
    void method_34() throws RemoteException;

    // $FF: renamed from: bA () com.google.android.gms.dynamic.d
    class_206 method_35() throws RemoteException;

    // $FF: renamed from: bB () java.lang.String
    String method_36() throws RemoteException;

    // $FF: renamed from: bt () java.lang.String
    String method_37() throws RemoteException;

    // $FF: renamed from: bu () com.google.android.gms.dynamic.d
    class_206 method_38() throws RemoteException;

    // $FF: renamed from: bw () java.lang.String
    String method_39() throws RemoteException;

    String getBody() throws RemoteException;

    // $FF: renamed from: i (int) void
    void method_40(int var1) throws RemoteException;

    public abstract static class class_1494 extends Binder implements class_11 {
        public class_1494() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.i(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.as();
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String var12 = this.bt();
                    var3.writeNoException();
                    var3.writeString(var12);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    class_206 var10 = this.bu();
                    var3.writeNoException();
                    IBinder var11 = null;
                    if(var10 != null) {
                        var11 = var10.asBinder();
                    }

                    var3.writeStrongBinder(var11);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String var9 = this.getBody();
                    var3.writeNoException();
                    var3.writeString(var9);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    class_206 var7 = this.bA();
                    var3.writeNoException();
                    IBinder var8 = null;
                    if(var7 != null) {
                        var8 = var7.asBinder();
                    }

                    var3.writeStrongBinder(var8);
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String var6 = this.bw();
                    var3.writeNoException();
                    var3.writeString(var6);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String var5 = this.bB();
                    var3.writeNoException();
                    var3.writeString(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }
}
