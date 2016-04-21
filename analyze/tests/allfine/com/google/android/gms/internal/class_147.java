package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_146;

// $FF: renamed from: com.google.android.gms.internal.lo
public interface class_147 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.ln, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
    void method_753(class_146 var1, UserAddressRequest var2, Bundle var3) throws RemoteException;

    public abstract static class class_1533 extends Binder implements class_147 {
        // $FF: renamed from: aH (android.os.IBinder) com.google.android.gms.internal.lo
        public static class_147 method_5609(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                return (class_147)(var1 != null && var1 instanceof class_147?(class_147)var1:new class_147.class_1534(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 2:
                    var2.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                    class_146 var5 = class_146.class_1531.method_5188(var2.readStrongBinder());
                    UserAddressRequest var6;
                    if(var2.readInt() != 0) {
                        var6 = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    Bundle var7;
                    if(var2.readInt() != 0) {
                        var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.a(var5, var6, var7);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1534 implements class_147 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4585;

        class_1534(IBinder var1) {
            this.field_4585 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ln, com.google.android.gms.identity.intents.UserAddressRequest, android.os.Bundle) void
        public void method_753(class_146 param1, UserAddressRequest param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4585;
        }
    }
}
