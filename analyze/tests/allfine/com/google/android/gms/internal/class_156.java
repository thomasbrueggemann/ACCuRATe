package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.class_493;
import com.google.android.gms.fitness.request.class_496;
import com.google.android.gms.fitness.request.class_498;
import com.google.android.gms.fitness.request.class_500;
import com.google.android.gms.fitness.request.class_504;
import com.google.android.gms.fitness.request.class_505;
import com.google.android.gms.fitness.request.class_507;
import com.google.android.gms.fitness.request.class_510;
import com.google.android.gms.fitness.request.class_512;
import com.google.android.gms.fitness.request.class_516;
import com.google.android.gms.fitness.request.class_520;
import com.google.android.gms.fitness.request.class_522;
import com.google.android.gms.fitness.request.class_524;
import com.google.android.gms.fitness.request.class_528;
import com.google.android.gms.internal.class_149;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_152;
import com.google.android.gms.internal.class_153;
import com.google.android.gms.internal.class_154;
import com.google.android.gms.internal.class_155;
import com.google.android.gms.internal.class_157;
import com.google.android.gms.internal.class_158;

// $FF: renamed from: com.google.android.gms.internal.kp
public interface class_156 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.internal.kt, java.lang.String) void
    void method_764(DataDeleteRequest var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, com.google.android.gms.internal.km, java.lang.String) void
    void method_765(DataReadRequest var1, class_157 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, com.google.android.gms.internal.kn, java.lang.String) void
    void method_766(DataSourcesRequest var1, class_158 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest, com.google.android.gms.internal.ko, java.lang.String) void
    void method_767(DataTypeCreateRequest var1, class_155 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.internal.kt, java.lang.String) void
    void method_768(SessionInsertRequest var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.internal.kr, java.lang.String) void
    void method_769(SessionReadRequest var1, class_154 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.StartBleScanRequest, com.google.android.gms.internal.kt, java.lang.String) void
    void method_770(StartBleScanRequest var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.aa, com.google.android.gms.internal.kt, java.lang.String) void
    void method_771(class_504 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.ad, com.google.android.gms.internal.kt, java.lang.String) void
    void method_772(class_500 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.af, com.google.android.gms.internal.kt, java.lang.String) void
    void method_773(class_498 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.ah, com.google.android.gms.internal.kt, java.lang.String) void
    void method_774(class_496 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, com.google.android.gms.internal.kt, java.lang.String) void
    void method_775(class_493 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.b, com.google.android.gms.internal.kt, java.lang.String) void
    void method_776(class_516 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.e, com.google.android.gms.internal.kt, java.lang.String) void
    void method_777(class_512 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.j, com.google.android.gms.internal.ko, java.lang.String) void
    void method_778(class_510 var1, class_155 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.m, com.google.android.gms.internal.kq, java.lang.String) void
    void method_779(class_505 var1, class_153 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.o, com.google.android.gms.internal.kt, java.lang.String) void
    void method_780(class_507 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.q, com.google.android.gms.internal.kt, java.lang.String) void
    void method_781(class_528 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.u, com.google.android.gms.internal.kt, java.lang.String) void
    void method_782(class_524 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.w, com.google.android.gms.internal.kt, java.lang.String) void
    void method_783(class_522 var1, class_151 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.fitness.request.y, com.google.android.gms.internal.ks, java.lang.String) void
    void method_784(class_520 var1, class_152 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.kt, java.lang.String) void
    void method_785(class_151 var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.lf, java.lang.String) void
    void method_786(class_149 var1, String var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.internal.kt, java.lang.String) void
    void method_787(class_151 var1, String var2) throws RemoteException;

    public abstract static class class_1201 extends Binder implements class_156 {
        // $FF: renamed from: as (android.os.IBinder) com.google.android.gms.internal.kp
        public static class_156 method_2415(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                return (class_156)(var1 != null && var1 instanceof class_156?(class_156)var1:new class_156.class_1202(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var45 = var2.readInt();
                    DataSourcesRequest var46 = null;
                    if(var45 != 0) {
                        var46 = (DataSourcesRequest)DataSourcesRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var46, class_158.class_1546.method_4222(var2.readStrongBinder()), var2.readString());
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var43 = var2.readInt();
                    class_507 var44 = null;
                    if(var43 != 0) {
                        var44 = (class_507)class_507.CREATOR.createFromParcel(var2);
                    }

                    this.a(var44, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var41 = var2.readInt();
                    class_528 var42 = null;
                    if(var41 != 0) {
                        var42 = (class_528)class_528.CREATOR.createFromParcel(var2);
                    }

                    this.a(var42, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var39 = var2.readInt();
                    class_498 var40 = null;
                    if(var39 != 0) {
                        var40 = (class_498)class_498.CREATOR.createFromParcel(var2);
                    }

                    this.a(var40, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var37 = var2.readInt();
                    class_493 var38 = null;
                    if(var37 != 0) {
                        var38 = (class_493)class_493.CREATOR.createFromParcel(var2);
                    }

                    this.a(var38, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var35 = var2.readInt();
                    class_505 var36 = null;
                    if(var35 != 0) {
                        var36 = (class_505)class_505.CREATOR.createFromParcel(var2);
                    }

                    this.a(var36, class_153.class_1548.method_4392(var2.readStrongBinder()), var2.readString());
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var33 = var2.readInt();
                    class_512 var34 = null;
                    if(var33 != 0) {
                        var34 = (class_512)class_512.CREATOR.createFromParcel(var2);
                    }

                    this.a(var34, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var25 = var2.readInt();
                    DataReadRequest var26 = null;
                    if(var25 != 0) {
                        var26 = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var26, class_157.class_1544.method_4554(var2.readStrongBinder()), var2.readString());
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var23 = var2.readInt();
                    SessionInsertRequest var24 = null;
                    if(var23 != 0) {
                        var24 = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var24, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var21 = var2.readInt();
                    SessionReadRequest var22 = null;
                    if(var21 != 0) {
                        var22 = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var22, class_154.class_1250.method_5199(var2.readStrongBinder()), var2.readString());
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var19 = var2.readInt();
                    class_522 var20 = null;
                    if(var19 != 0) {
                        var20 = (class_522)class_522.CREATOR.createFromParcel(var2);
                    }

                    this.a(var20, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var17 = var2.readInt();
                    class_520 var18 = null;
                    if(var17 != 0) {
                        var18 = (class_520)class_520.CREATOR.createFromParcel(var2);
                    }

                    this.a(var18, class_152.class_1525.method_5198(var2.readStrongBinder()), var2.readString());
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var29 = var2.readInt();
                    DataTypeCreateRequest var30 = null;
                    if(var29 != 0) {
                        var30 = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var30, class_155.class_1365.method_3365(var2.readStrongBinder()), var2.readString());
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var27 = var2.readInt();
                    class_510 var28 = null;
                    if(var27 != 0) {
                        var28 = (class_510)class_510.CREATOR.createFromParcel(var2);
                    }

                    this.a(var28, class_155.class_1365.method_3365(var2.readStrongBinder()), var2.readString());
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var15 = var2.readInt();
                    StartBleScanRequest var16 = null;
                    if(var15 != 0) {
                        var16 = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var16, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var13 = var2.readInt();
                    class_500 var14 = null;
                    if(var13 != 0) {
                        var14 = (class_500)class_500.CREATOR.createFromParcel(var2);
                    }

                    this.a(var14, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var11 = var2.readInt();
                    class_516 var12 = null;
                    if(var11 != 0) {
                        var12 = (class_516)class_516.CREATOR.createFromParcel(var2);
                    }

                    this.a(var12, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var9 = var2.readInt();
                    class_496 var10 = null;
                    if(var9 != 0) {
                        var10 = (class_496)class_496.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var31 = var2.readInt();
                    DataDeleteRequest var32 = null;
                    if(var31 != 0) {
                        var32 = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var32, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var7 = var2.readInt();
                    class_524 var8 = null;
                    if(var7 != 0) {
                        var8 = (class_524)class_524.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    int var5 = var2.readInt();
                    class_504 var6 = null;
                    if(var5 != 0) {
                        var6 = (class_504)class_504.CREATOR.createFromParcel(var2);
                    }

                    this.a(var6, class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    this.a(class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    this.b(class_151.class_1528.method_5440(var2.readStrongBinder()), var2.readString());
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    this.a(class_149.class_1536.method_3952(var2.readStrongBinder()), var2.readString());
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1202 implements class_156 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3173;

        class_1202(IBinder var1) {
            this.field_3173 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_764(DataDeleteRequest param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, com.google.android.gms.internal.km, java.lang.String) void
        public void method_765(DataReadRequest param1, class_157 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, com.google.android.gms.internal.kn, java.lang.String) void
        public void method_766(DataSourcesRequest param1, class_158 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest, com.google.android.gms.internal.ko, java.lang.String) void
        public void method_767(DataTypeCreateRequest param1, class_155 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_768(SessionInsertRequest param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.internal.kr, java.lang.String) void
        public void method_769(SessionReadRequest param1, class_154 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.StartBleScanRequest, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_770(StartBleScanRequest param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.aa, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_771(class_504 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.ad, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_772(class_500 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.af, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_773(class_498 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.ah, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_774(class_496 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_775(class_493 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.b, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_776(class_516 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.e, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_777(class_512 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.j, com.google.android.gms.internal.ko, java.lang.String) void
        public void method_778(class_510 param1, class_155 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.m, com.google.android.gms.internal.kq, java.lang.String) void
        public void method_779(class_505 param1, class_153 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.o, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_780(class_507 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.q, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_781(class_528 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.u, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_782(class_524 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.w, com.google.android.gms.internal.kt, java.lang.String) void
        public void method_783(class_522 param1, class_151 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.request.y, com.google.android.gms.internal.ks, java.lang.String) void
        public void method_784(class_520 param1, class_152 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.kt, java.lang.String) void
        public void method_785(class_151 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.lf, java.lang.String) void
        public void method_786(class_149 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3173;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.kt, java.lang.String) void
        public void method_787(class_151 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
