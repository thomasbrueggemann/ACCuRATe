package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

// $FF: renamed from: com.google.android.gms.internal.r
public interface class_64 extends IInterface {
    // $FF: renamed from: a (java.lang.String, android.os.Bundle) android.os.Bundle
    Bundle method_313(String var1, Bundle var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle) android.os.Bundle
    Bundle method_314(String var1, String var2, Bundle var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEventsRequest) com.google.android.gms.auth.AccountChangeEventsResponse
    AccountChangeEventsResponse method_315(AccountChangeEventsRequest var1) throws RemoteException;

    public abstract static class class_1411 extends Binder implements class_64 {
        // $FF: renamed from: a (android.os.IBinder) com.google.android.gms.internal.r
        public static class_64 method_5515(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.auth.IAuthManagerService");
                return (class_64)(var1 != null && var1 instanceof class_64?(class_64)var1:new class_64.class_1412(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.auth.IAuthManagerService");
                    String var12 = var2.readString();
                    String var13 = var2.readString();
                    int var14 = var2.readInt();
                    Bundle var15 = null;
                    if(var14 != 0) {
                        var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    Bundle var16 = this.a(var12, var13, var15);
                    var3.writeNoException();
                    if(var16 != null) {
                        var3.writeInt(1);
                        var16.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.auth.IAuthManagerService");
                    String var8 = var2.readString();
                    int var9 = var2.readInt();
                    Bundle var10 = null;
                    if(var9 != 0) {
                        var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    Bundle var11 = this.a(var8, var10);
                    var3.writeNoException();
                    if(var11 != null) {
                        var3.writeInt(1);
                        var11.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.auth.IAuthManagerService");
                    int var5 = var2.readInt();
                    AccountChangeEventsRequest var6 = null;
                    if(var5 != 0) {
                        var6 = AccountChangeEventsRequest.CREATOR.createFromParcel(var2);
                    }

                    AccountChangeEventsResponse var7 = this.a(var6);
                    var3.writeNoException();
                    if(var7 != null) {
                        var3.writeInt(1);
                        var7.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.auth.IAuthManagerService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1412 implements class_64 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4355;

        class_1412(IBinder var1) {
            this.field_4355 = var1;
        }

        // $FF: renamed from: a (java.lang.String, android.os.Bundle) android.os.Bundle
        public Bundle method_313(String param1, Bundle param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle) android.os.Bundle
        public Bundle method_314(String param1, String param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.auth.AccountChangeEventsRequest) com.google.android.gms.auth.AccountChangeEventsResponse
        public AccountChangeEventsResponse method_315(AccountChangeEventsRequest param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4355;
        }
    }
}
