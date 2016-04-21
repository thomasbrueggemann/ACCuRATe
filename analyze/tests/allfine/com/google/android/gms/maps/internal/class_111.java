package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_56;

// $FF: renamed from: com.google.android.gms.maps.internal.l
public interface class_111 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.maps.model.internal.f) boolean
    boolean method_636(class_56 var1) throws RemoteException;

    public abstract static class class_1550 extends Binder implements class_111 {
        public class_1550() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        // $FF: renamed from: bc (android.os.IBinder) com.google.android.gms.maps.internal.l
        public static class_111 method_3705(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                return (class_111)(var1 != null && var1 instanceof class_111?(class_111)var1:new class_111.class_1551(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean var5 = this.a(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    byte var6;
                    if(var5) {
                        var6 = 1;
                    } else {
                        var6 = 0;
                    }

                    var3.writeInt(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1551 implements class_111 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3417;

        class_1551(IBinder var1) {
            this.field_3417 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.internal.f) boolean
        public boolean method_636(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3417;
        }
    }
}
