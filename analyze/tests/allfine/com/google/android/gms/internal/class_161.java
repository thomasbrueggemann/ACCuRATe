package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_160;

// $FF: renamed from: com.google.android.gms.internal.nb
public interface class_161 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.na, android.net.Uri, android.os.Bundle, boolean) void
    void method_794(class_160 var1, Uri var2, Bundle var3, boolean var4) throws RemoteException;

    public abstract static class class_1175 extends Binder implements class_161 {
        // $FF: renamed from: bA (android.os.IBinder) com.google.android.gms.internal.nb
        public static class_161 method_2186(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
                return (class_161)(var1 != null && var1 instanceof class_161?(class_161)var1:new class_161.class_1176(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
                    class_160 var5 = class_160.class_1354.method_3269(var2.readStrongBinder());
                    Uri var6;
                    if(var2.readInt() != 0) {
                        var6 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    Bundle var7;
                    if(var2.readInt() != 0) {
                        var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    boolean var8;
                    if(var2.readInt() != 0) {
                        var8 = true;
                    } else {
                        var8 = false;
                    }

                    this.a(var5, var6, var7, var8);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1176 implements class_161 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3453;

        class_1176(IBinder var1) {
            this.field_3453 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.na, android.net.Uri, android.os.Bundle, boolean) void
        public void method_794(class_160 param1, Uri param2, Bundle param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3453;
        }
    }
}
