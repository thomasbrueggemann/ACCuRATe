package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;
import com.google.android.gms.drive.realtime.internal.class_129;
import com.google.android.gms.drive.realtime.internal.class_130;
import com.google.android.gms.drive.realtime.internal.class_131;
import com.google.android.gms.drive.realtime.internal.class_132;
import com.google.android.gms.drive.realtime.internal.class_133;
import com.google.android.gms.drive.realtime.internal.class_134;
import com.google.android.gms.drive.realtime.internal.class_135;
import com.google.android.gms.drive.realtime.internal.class_136;
import com.google.android.gms.drive.realtime.internal.class_137;
import com.google.android.gms.drive.realtime.internal.class_138;
import com.google.android.gms.drive.realtime.internal.class_139;
import com.google.android.gms.drive.realtime.internal.class_141;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.m
public interface class_140 extends IInterface {
    // $FF: renamed from: a (int, com.google.android.gms.drive.realtime.internal.j) void
    void method_675(int var1, class_134 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.o) void
    void method_676(BeginCompoundOperationRequest var1, class_141 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.j) void
    void method_677(EndCompoundOperationRequest var1, class_134 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.o) void
    void method_678(EndCompoundOperationRequest var1, class_141 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, com.google.android.gms.drive.realtime.internal.n) void
    void method_679(ParcelableIndexReference var1, class_139 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.c) void
    void method_680(class_137 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.d) void
    void method_681(class_138 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.e) void
    void method_682(class_129 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.h) void
    void method_683(class_132 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.i) void
    void method_684(class_133 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.j) void
    void method_685(class_134 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.l) void
    void method_686(class_136 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.o) void
    void method_687(class_141 var1) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, int, com.google.android.gms.drive.realtime.internal.g) void
    void method_688(String var1, int var2, int var3, class_131 var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, int, com.google.android.gms.drive.realtime.internal.j) void
    void method_689(String var1, int var2, int var3, class_134 var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.g) void
    void method_690(String var1, int var2, DataHolder var3, class_131 var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.j) void
    void method_691(String var1, int var2, DataHolder var3, class_134 var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.drive.realtime.internal.o) void
    void method_692(String var1, int var2, class_141 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, java.lang.String, int, com.google.android.gms.drive.realtime.internal.j) void
    void method_693(String var1, int var2, String var3, int var4, class_134 var5) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, int, java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
    void method_694(String var1, int var2, String var3, class_134 var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.j) void
    void method_695(String var1, DataHolder var2, class_134 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
    void method_696(String var1, class_130 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
    void method_697(String var1, class_134 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.k) void
    void method_698(String var1, class_135 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
    void method_699(String var1, class_136 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.n) void
    void method_700(String var1, class_139 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.o) void
    void method_701(String var1, class_141 var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
    void method_702(String var1, String var2, class_130 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.g) void
    void method_703(String var1, String var2, class_131 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
    void method_704(String var1, String var2, class_134 var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.c) void
    void method_705(class_137 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.j) void
    void method_706(class_134 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.l) void
    void method_707(class_136 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.o) void
    void method_708(class_141 var1) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
    void method_709(String var1, class_130 var2) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
    void method_710(String var1, class_136 var2) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.n) void
    void method_711(String var1, class_139 var2) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.o) void
    void method_712(String var1, class_141 var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.drive.realtime.internal.c) void
    void method_713(class_137 var1) throws RemoteException;

    // $FF: renamed from: c (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
    void method_714(String var1, class_136 var2) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.drive.realtime.internal.c) void
    void method_715(class_137 var1) throws RemoteException;

    public abstract static class class_1562 extends Binder implements class_140 {
        // $FF: renamed from: ai (android.os.IBinder) com.google.android.gms.drive.realtime.internal.m
        public static class_140 method_3892(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                return (class_140)(var1 != null && var1 instanceof class_140?(class_140)var1:new class_140.class_1563(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_139.class_1454.method_4418(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_137.class_1154.method_1618(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readString(), class_130.class_1688.method_4424(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_136.class_1341.method_3248(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    String var21 = var2.readString();
                    int var22 = var2.readInt();
                    DataHolder var23 = null;
                    if(var22 != 0) {
                        var23 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.a(var21, var23, class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(var2.readString(), class_136.class_1341.method_3248(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(var2.readString(), class_139.class_1454.method_4418(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readInt(), var2.readString(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readInt(), var2.readInt(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readString(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(var2.readString(), class_130.class_1688.method_4424(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.c(var2.readString(), class_136.class_1341.method_3248(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    String var17 = var2.readString();
                    int var18 = var2.readInt();
                    int var19 = var2.readInt();
                    DataHolder var20 = null;
                    if(var19 != 0) {
                        var20 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.a(var17, var18, var20, class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    String var13 = var2.readString();
                    int var14 = var2.readInt();
                    int var15 = var2.readInt();
                    DataHolder var16 = null;
                    if(var15 != 0) {
                        var16 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.a(var13, var14, var16, class_131.class_1765.method_5078(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readInt(), var2.readInt(), class_131.class_1765.method_5078(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    int var11 = var2.readInt();
                    BeginCompoundOperationRequest var12 = null;
                    if(var11 != 0) {
                        var12 = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var12, class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    int var5 = var2.readInt();
                    EndCompoundOperationRequest var6 = null;
                    if(var5 != 0) {
                        var6 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var6, class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_130.class_1688.method_4424(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readString(), class_131.class_1765.method_5078(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.c(class_137.class_1154.method_1618(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 25:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.d(class_137.class_1154.method_1618(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 26:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    int var7 = var2.readInt();
                    ParcelableIndexReference var8 = null;
                    if(var7 != 0) {
                        var8 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8, class_139.class_1454.method_4418(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 27:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_135.class_1148.method_1582(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 28:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readInt(), class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 29:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(class_136.class_1341.method_3248(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 30:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readInt(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 31:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_129.class_1408.method_3893(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 32:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_138.class_1349.method_3259(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 33:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(class_137.class_1154.method_1618(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 34:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_133.class_1247.method_5566(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 35:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 36:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_132.class_1229.method_5434(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 37:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), var2.readInt(), var2.readString(), var2.readInt(), class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 38:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(var2.readString(), class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 39:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.b(var2.readString(), class_141.class_1607.method_4425(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 40:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.a(class_136.class_1341.method_3248(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 41:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    int var9 = var2.readInt();
                    EndCompoundOperationRequest var10 = null;
                    if(var9 != 0) {
                        var10 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10, class_134.class_1383.method_5938(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1563 implements class_140 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4224;

        class_1563(IBinder var1) {
            this.field_4224 = var1;
        }

        // $FF: renamed from: a (int, com.google.android.gms.drive.realtime.internal.j) void
        public void method_675(int param1, class_134 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.o) void
        public void method_676(BeginCompoundOperationRequest param1, class_141 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.j) void
        public void method_677(EndCompoundOperationRequest param1, class_134 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.drive.realtime.internal.o) void
        public void method_678(EndCompoundOperationRequest param1, class_141 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, com.google.android.gms.drive.realtime.internal.n) void
        public void method_679(ParcelableIndexReference param1, class_139 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.c) void
        public void method_680(class_137 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.d) void
        public void method_681(class_138 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.e) void
        public void method_682(class_129 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.h) void
        public void method_683(class_132 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.i) void
        public void method_684(class_133 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.j) void
        public void method_685(class_134 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.l) void
        public void method_686(class_136 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.o) void
        public void method_687(class_141 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, int, com.google.android.gms.drive.realtime.internal.g) void
        public void method_688(String param1, int param2, int param3, class_131 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, int, com.google.android.gms.drive.realtime.internal.j) void
        public void method_689(String param1, int param2, int param3, class_134 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.g) void
        public void method_690(String param1, int param2, DataHolder param3, class_131 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.j) void
        public void method_691(String param1, int param2, DataHolder param3, class_134 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.drive.realtime.internal.o) void
        public void method_692(String param1, int param2, class_141 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, java.lang.String, int, com.google.android.gms.drive.realtime.internal.j) void
        public void method_693(String param1, int param2, String param3, int param4, class_134 param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, int, java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
        public void method_694(String param1, int param2, String param3, class_134 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.j) void
        public void method_695(String param1, DataHolder param2, class_134 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
        public void method_696(String param1, class_130 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
        public void method_697(String param1, class_134 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.k) void
        public void method_698(String param1, class_135 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
        public void method_699(String param1, class_136 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.n) void
        public void method_700(String param1, class_139 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.drive.realtime.internal.o) void
        public void method_701(String param1, class_141 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
        public void method_702(String param1, String param2, class_130 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.g) void
        public void method_703(String param1, String param2, class_131 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.drive.realtime.internal.j) void
        public void method_704(String param1, String param2, class_134 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4224;
        }

        // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.c) void
        public void method_705(class_137 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.j) void
        public void method_706(class_134 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.l) void
        public void method_707(class_136 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.o) void
        public void method_708(class_141 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.f) void
        public void method_709(String param1, class_130 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
        public void method_710(String param1, class_136 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.n) void
        public void method_711(String param1, class_139 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.drive.realtime.internal.o) void
        public void method_712(String param1, class_141 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.drive.realtime.internal.c) void
        public void method_713(class_137 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (java.lang.String, com.google.android.gms.drive.realtime.internal.l) void
        public void method_714(String param1, class_136 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.drive.realtime.internal.c) void
        public void method_715(class_137 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
