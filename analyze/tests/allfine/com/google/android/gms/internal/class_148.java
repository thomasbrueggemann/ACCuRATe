package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_837;
import com.google.android.gms.internal.class_841;

// $FF: renamed from: com.google.android.gms.internal.lk
public interface class_148 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.internal.kt) void
    void method_754(FitnessSensorServiceRequest var1, class_151 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.lg, com.google.android.gms.internal.kn) void
    void method_755(class_841 var1, class_158 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.li, com.google.android.gms.internal.kt) void
    void method_756(class_837 var1, class_151 var2) throws RemoteException;

    public abstract static class class_1535 extends Binder implements class_148 {
        public class_1535() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    int var9 = var2.readInt();
                    class_841 var10 = null;
                    if(var9 != 0) {
                        var10 = (class_841)class_841.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10, class_158.class_1546.method_4222(var2.readStrongBinder()));
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    int var7 = var2.readInt();
                    FitnessSensorServiceRequest var8 = null;
                    if(var7 != 0) {
                        var8 = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8, class_151.class_1528.method_5440(var2.readStrongBinder()));
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    int var5 = var2.readInt();
                    class_837 var6 = null;
                    if(var5 != 0) {
                        var6 = (class_837)class_837.CREATOR.createFromParcel(var2);
                    }

                    this.a(var6, class_151.class_1528.method_5440(var2.readStrongBinder()));
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }
}
