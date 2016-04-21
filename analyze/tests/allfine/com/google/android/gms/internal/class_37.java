package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;

// $FF: renamed from: com.google.android.gms.internal.fm
public interface class_37 extends IInterface {
    // $FF: renamed from: b (com.google.android.gms.internal.fi) com.google.android.gms.internal.fk
    class_447 method_166(class_448 var1) throws RemoteException;

    public abstract static class class_1335 extends Binder implements class_37 {
        public class_1335() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        // $FF: renamed from: D (android.os.IBinder) com.google.android.gms.internal.fm
        public static class_37 method_2757(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                return (class_37)(var1 != null && var1 instanceof class_37?(class_37)var1:new class_37.class_1336(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    class_448 var5;
                    if(var2.readInt() != 0) {
                        var5 = class_448.CREATOR.method_2802(var2);
                    } else {
                        var5 = null;
                    }

                    class_447 var6 = this.b(var5);
                    var3.writeNoException();
                    if(var6 != null) {
                        var3.writeInt(1);
                        var6.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1336 implements class_37 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2238;

        class_1336(IBinder var1) {
            this.field_2238 = var1;
        }

        public IBinder asBinder() {
            return this.field_2238;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.fi) com.google.android.gms.internal.fk
        public class_447 method_166(class_448 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
