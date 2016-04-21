package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.na
public interface class_160 extends IInterface {
    // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
    void method_793(int var1, Bundle var2, int var3, Intent var4) throws RemoteException;

    public abstract static class class_1354 extends Binder implements class_160 {
        public class_1354() {
            this.attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        }

        // $FF: renamed from: bz (android.os.IBinder) com.google.android.gms.internal.na
        public static class_160 method_3269(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                return (class_160)(var1 != null && var1 instanceof class_160?(class_160)var1:new class_160.class_1355(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    int var5 = var2.readInt();
                    Bundle var6;
                    if(var2.readInt() != 0) {
                        var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    int var7 = var2.readInt();
                    Intent var8;
                    if(var2.readInt() != 0) {
                        var8 = (Intent)Intent.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    this.a(var5, var6, var7, var8);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1355 implements class_160 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5082;

        class_1355(IBinder var1) {
            this.field_5082 = var1;
        }

        // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
        public void method_793(int param1, Bundle param2, int param3, Intent param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5082;
        }
    }
}
