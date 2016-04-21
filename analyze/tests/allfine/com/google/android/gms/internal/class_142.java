package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_143;
import com.google.android.gms.internal.class_162;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_828;
import com.google.android.gms.internal.class_880;
import com.google.android.gms.internal.class_887;
import com.google.android.gms.internal.class_889;
import com.google.android.gms.internal.class_891;
import com.google.android.gms.internal.class_893;
import com.google.android.gms.internal.class_894;
import com.google.android.gms.internal.class_896;
import com.google.android.gms.internal.class_898;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.mt;
import com.google.android.gms.internal.mv;
import com.google.android.gms.internal.mx;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_667;
import com.google.android.gms.location.class_88;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lx
public interface class_142 extends IInterface {
    // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
    void method_720(long var1, boolean var3, PendingIntent var4) throws RemoteException;

    // $FF: renamed from: a (android.app.PendingIntent) void
    void method_721(PendingIntent var1) throws RemoteException;

    // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.lw, java.lang.String) void
    void method_722(PendingIntent var1, class_143 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (android.location.Location, int) void
    void method_723(Location var1, int var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.lw, java.lang.String) void
    void method_724(class_143 var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ma, android.app.PendingIntent) void
    void method_725(class_826 var1, PendingIntent var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ma, com.google.android.gms.location.a) void
    void method_726(class_826 var1, class_88 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mh, com.google.android.gms.internal.mx, android.app.PendingIntent) void
    void method_727(class_893 var1, class_880 var2, PendingIntent var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_728(class_898 var1, class_880 var2, class_162 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ml, com.google.android.gms.internal.mx) void
    void method_729(class_896 var1, class_880 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mn, com.google.android.gms.internal.mx, android.app.PendingIntent) void
    void method_730(class_887 var1, class_880 var2, PendingIntent var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mr, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_731(class_891 var1, class_880 var2, class_162 var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mt, com.google.android.gms.maps.model.LatLngBounds, java.util.List, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_732(mt var1, LatLngBounds var2, List<String> var3, mx var4, mv var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.mx, android.app.PendingIntent) void
    void method_733(class_880 var1, PendingIntent var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
    void method_734(LocationRequest var1, PendingIntent var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a) void
    void method_735(LocationRequest var1, class_88 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a, java.lang.String) void
    void method_736(LocationRequest var1, class_88 var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.location.a) void
    void method_737(class_88 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_738(LatLng var1, class_898 var2, class_880 var3, class_162 var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_739(LatLngBounds var1, int var2, class_898 var3, class_880 var4, class_162 var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_740(LatLngBounds var1, int var2, String var3, class_898 var4, class_880 var5, class_162 var6) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_741(String var1, class_880 var2, class_162 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.mf, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_742(String var1, LatLngBounds var2, class_894 var3, class_880 var4, class_162 var5) throws RemoteException;

    // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.lw, java.lang.String) void
    void method_743(List<mc> var1, PendingIntent var2, lw var3, String var4) throws RemoteException;

    // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.lw, java.lang.String) void
    void method_744(String[] var1, class_143 var2, String var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.internal.mx, android.app.PendingIntent) void
    void method_745(class_880 var1, PendingIntent var2) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
    void method_746(String var1, class_880 var2, class_162 var3) throws RemoteException;

    // $FF: renamed from: bW (java.lang.String) android.location.Location
    Location method_747(String var1) throws RemoteException;

    // $FF: renamed from: bX (java.lang.String) com.google.android.gms.location.c
    class_667 method_748(String var1) throws RemoteException;

    // $FF: renamed from: lV () android.location.Location
    Location method_749() throws RemoteException;

    // $FF: renamed from: lW () android.os.IBinder
    IBinder method_750() throws RemoteException;

    // $FF: renamed from: lX () android.os.IBinder
    IBinder method_751() throws RemoteException;

    void removeActivityUpdates(PendingIntent var1) throws RemoteException;

    void setMockLocation(Location var1) throws RemoteException;

    void setMockMode(boolean var1) throws RemoteException;

    public abstract static class class_1276 extends Binder implements class_142 {
        // $FF: renamed from: aK (android.os.IBinder) com.google.android.gms.internal.lx
        public static class_142 method_3030(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return (class_142)(var1 != null && var1 instanceof class_142?(class_142)var1:new class_142.class_1277(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ArrayList var78 = var2.createTypedArrayList(class_828.CREATOR);
                    PendingIntent var79;
                    if(var2.readInt() != 0) {
                        var79 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var79 = null;
                    }

                    this.a(var78, var79, class_143.class_1197.method_2352(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    PendingIntent var77;
                    if(var2.readInt() != 0) {
                        var77 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var77 = null;
                    }

                    this.a(var77, class_143.class_1197.method_2352(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(var2.createStringArray(), class_143.class_1197.method_2352(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(class_143.class_1197.method_2352(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long var73 = var2.readLong();
                    boolean var75;
                    if(var2.readInt() != 0) {
                        var75 = true;
                    } else {
                        var75 = false;
                    }

                    PendingIntent var76;
                    if(var2.readInt() != 0) {
                        var76 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var76 = null;
                    }

                    this.a(var73, var75, var76);
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    PendingIntent var72;
                    if(var2.readInt() != 0) {
                        var72 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var72 = null;
                    }

                    this.removeActivityUpdates(var72);
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location var71 = this.lV();
                    var3.writeNoException();
                    if(var71 != null) {
                        var3.writeInt(1);
                        var71.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    int var69 = var2.readInt();
                    LocationRequest var70 = null;
                    if(var69 != 0) {
                        var70 = LocationRequest.CREATOR.method_3726(var2);
                    }

                    this.a(var70, class_88.class_1281.method_3144(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationRequest var65;
                    if(var2.readInt() != 0) {
                        var65 = LocationRequest.CREATOR.method_3726(var2);
                    } else {
                        var65 = null;
                    }

                    PendingIntent var66;
                    if(var2.readInt() != 0) {
                        var66 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var66 = null;
                    }

                    this.a(var65, var66);
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.a(class_88.class_1281.method_3144(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    PendingIntent var60;
                    if(var2.readInt() != 0) {
                        var60 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var60 = null;
                    }

                    this.a(var60);
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    int var58 = var2.readInt();
                    boolean var59 = false;
                    if(var58 != 0) {
                        var59 = true;
                    }

                    this.setMockMode(var59);
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location var57;
                    if(var2.readInt() != 0) {
                        var57 = (Location)Location.CREATOR.createFromParcel(var2);
                    } else {
                        var57 = null;
                    }

                    this.setMockLocation(var57);
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLngBounds var53;
                    if(var2.readInt() != 0) {
                        var53 = LatLngBounds.CREATOR.method_5149(var2);
                    } else {
                        var53 = null;
                    }

                    int var54 = var2.readInt();
                    class_898 var55;
                    if(var2.readInt() != 0) {
                        var55 = class_898.CREATOR.method_4588(var2);
                    } else {
                        var55 = null;
                    }

                    class_880 var56;
                    if(var2.readInt() != 0) {
                        var56 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var56 = null;
                    }

                    this.a(var53, var54, var55, var56, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    String var44 = var2.readString();
                    int var45 = var2.readInt();
                    class_880 var46 = null;
                    if(var45 != 0) {
                        var46 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var44, var46, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng var40;
                    if(var2.readInt() != 0) {
                        var40 = LatLng.CREATOR.method_5161(var2);
                    } else {
                        var40 = null;
                    }

                    class_898 var41;
                    if(var2.readInt() != 0) {
                        var41 = class_898.CREATOR.method_4588(var2);
                    } else {
                        var41 = null;
                    }

                    int var42 = var2.readInt();
                    class_880 var43 = null;
                    if(var42 != 0) {
                        var43 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var40, var41, var43, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_898 var37;
                    if(var2.readInt() != 0) {
                        var37 = class_898.CREATOR.method_4588(var2);
                    } else {
                        var37 = null;
                    }

                    int var38 = var2.readInt();
                    class_880 var39 = null;
                    if(var38 != 0) {
                        var39 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var37, var39, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_887 var27;
                    if(var2.readInt() != 0) {
                        var27 = class_887.CREATOR.method_4562(var2);
                    } else {
                        var27 = null;
                    }

                    class_880 var28;
                    if(var2.readInt() != 0) {
                        var28 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var28 = null;
                    }

                    PendingIntent var29;
                    if(var2.readInt() != 0) {
                        var29 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var29 = null;
                    }

                    this.a(var27, var28, var29);
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_880 var25;
                    if(var2.readInt() != 0) {
                        var25 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var25 = null;
                    }

                    PendingIntent var26;
                    if(var2.readInt() != 0) {
                        var26 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var26 = null;
                    }

                    this.a(var25, var26);
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    int var67 = var2.readInt();
                    LocationRequest var68 = null;
                    if(var67 != 0) {
                        var68 = LocationRequest.CREATOR.method_3726(var2);
                    }

                    this.a(var68, class_88.class_1281.method_3144(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location var12 = this.bW(var2.readString());
                    var3.writeNoException();
                    if(var12 != null) {
                        var3.writeInt(1);
                        var12.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 25:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_896 var9;
                    if(var2.readInt() != 0) {
                        var9 = class_896.CREATOR.method_4566(var2);
                    } else {
                        var9 = null;
                    }

                    int var10 = var2.readInt();
                    class_880 var11 = null;
                    if(var10 != 0) {
                        var11 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var9, var11);
                    return true;
                case 26:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location var8;
                    if(var2.readInt() != 0) {
                        var8 = (Location)Location.CREATOR.createFromParcel(var2);
                    } else {
                        var8 = null;
                    }

                    this.a(var8, var2.readInt());
                    var3.writeNoException();
                    return true;
                case 34:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_667 var7 = this.bX(var2.readString());
                    var3.writeNoException();
                    if(var7 != null) {
                        var3.writeInt(1);
                        var7.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 42:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    String var34 = var2.readString();
                    int var35 = var2.readInt();
                    class_880 var36 = null;
                    if(var35 != 0) {
                        var36 = class_880.CREATOR.method_4559(var2);
                    }

                    this.b(var34, var36, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 46:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_891 var13;
                    if(var2.readInt() != 0) {
                        var13 = (class_891)class_891.CREATOR.createFromParcel(var2);
                    } else {
                        var13 = null;
                    }

                    int var14 = var2.readInt();
                    class_880 var15 = null;
                    if(var14 != 0) {
                        var15 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var13, var15, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 47:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLngBounds var47;
                    if(var2.readInt() != 0) {
                        var47 = LatLngBounds.CREATOR.method_5149(var2);
                    } else {
                        var47 = null;
                    }

                    int var48 = var2.readInt();
                    String var49 = var2.readString();
                    class_898 var50;
                    if(var2.readInt() != 0) {
                        var50 = class_898.CREATOR.method_4588(var2);
                    } else {
                        var50 = null;
                    }

                    int var51 = var2.readInt();
                    class_880 var52 = null;
                    if(var51 != 0) {
                        var52 = class_880.CREATOR.method_4559(var2);
                    }

                    this.a(var47, var48, var49, var50, var52, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 48:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_893 var22;
                    if(var2.readInt() != 0) {
                        var22 = class_893.CREATOR.method_4592(var2);
                    } else {
                        var22 = null;
                    }

                    class_880 var23;
                    if(var2.readInt() != 0) {
                        var23 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var23 = null;
                    }

                    PendingIntent var24;
                    if(var2.readInt() != 0) {
                        var24 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var24 = null;
                    }

                    this.a(var22, var23, var24);
                    var3.writeNoException();
                    return true;
                case 49:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_880 var20;
                    if(var2.readInt() != 0) {
                        var20 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var20 = null;
                    }

                    PendingIntent var21;
                    if(var2.readInt() != 0) {
                        var21 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var21 = null;
                    }

                    this.b(var20, var21);
                    var3.writeNoException();
                    return true;
                case 50:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_889 var30;
                    if(var2.readInt() != 0) {
                        var30 = class_889.CREATOR.method_4556(var2);
                    } else {
                        var30 = null;
                    }

                    LatLngBounds var31;
                    if(var2.readInt() != 0) {
                        var31 = LatLngBounds.CREATOR.method_5149(var2);
                    } else {
                        var31 = null;
                    }

                    ArrayList var32 = var2.createStringArrayList();
                    class_880 var33;
                    if(var2.readInt() != 0) {
                        var33 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var33 = null;
                    }

                    this.a(var30, var31, var32, var33, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 51:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    IBinder var6 = this.lW();
                    var3.writeNoException();
                    var3.writeStrongBinder(var6);
                    return true;
                case 52:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    int var63 = var2.readInt();
                    class_826 var64 = null;
                    if(var63 != 0) {
                        var64 = class_826.CREATOR.method_4432(var2);
                    }

                    this.a(var64, class_88.class_1281.method_3144(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 53:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    class_826 var61;
                    if(var2.readInt() != 0) {
                        var61 = class_826.CREATOR.method_4432(var2);
                    } else {
                        var61 = null;
                    }

                    PendingIntent var62;
                    if(var2.readInt() != 0) {
                        var62 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
                    } else {
                        var62 = null;
                    }

                    this.a(var61, var62);
                    var3.writeNoException();
                    return true;
                case 54:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    IBinder var5 = this.lX();
                    var3.writeNoException();
                    var3.writeStrongBinder(var5);
                    return true;
                case 55:
                    var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    String var16 = var2.readString();
                    LatLngBounds var17;
                    if(var2.readInt() != 0) {
                        var17 = LatLngBounds.CREATOR.method_5149(var2);
                    } else {
                        var17 = null;
                    }

                    class_894 var18;
                    if(var2.readInt() != 0) {
                        var18 = class_894.CREATOR.method_4580(var2);
                    } else {
                        var18 = null;
                    }

                    class_880 var19;
                    if(var2.readInt() != 0) {
                        var19 = class_880.CREATOR.method_4559(var2);
                    } else {
                        var19 = null;
                    }

                    this.a(var16, var17, var18, var19, class_162.class_1540.method_5416(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1277 implements class_142 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3221;

        class_1277(IBinder var1) {
            this.field_3221 = var1;
        }

        // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
        public void method_720(long param1, boolean param3, PendingIntent param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (android.app.PendingIntent) void
        public void method_721(PendingIntent param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.lw, java.lang.String) void
        public void method_722(PendingIntent param1, class_143 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (android.location.Location, int) void
        public void method_723(Location param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.lw, java.lang.String) void
        public void method_724(class_143 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ma, android.app.PendingIntent) void
        public void method_725(class_826 param1, PendingIntent param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ma, com.google.android.gms.location.a) void
        public void method_726(class_826 param1, class_88 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mh, com.google.android.gms.internal.mx, android.app.PendingIntent) void
        public void method_727(class_893 param1, class_880 param2, PendingIntent param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_728(class_898 param1, class_880 param2, class_162 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ml, com.google.android.gms.internal.mx) void
        public void method_729(class_896 param1, class_880 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mn, com.google.android.gms.internal.mx, android.app.PendingIntent) void
        public void method_730(class_887 param1, class_880 param2, PendingIntent param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mr, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_731(class_891 param1, class_880 param2, class_162 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mt, com.google.android.gms.maps.model.LatLngBounds, java.util.List, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_732(mt param1, LatLngBounds param2, List<String> param3, mx param4, mv param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.mx, android.app.PendingIntent) void
        public void method_733(class_880 param1, PendingIntent param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
        public void method_734(LocationRequest param1, PendingIntent param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a) void
        public void method_735(LocationRequest param1, class_88 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a, java.lang.String) void
        public void method_736(LocationRequest param1, class_88 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.location.a) void
        public void method_737(class_88 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_738(LatLng param1, class_898 param2, class_880 param3, class_162 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_739(LatLngBounds param1, int param2, class_898 param3, class_880 param4, class_162 param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.mj, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_740(LatLngBounds param1, int param2, String param3, class_898 param4, class_880 param5, class_162 param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_741(String param1, class_880 param2, class_162 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.mf, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_742(String param1, LatLngBounds param2, class_894 param3, class_880 param4, class_162 param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.lw, java.lang.String) void
        public void method_743(List<mc> param1, PendingIntent param2, lw param3, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.lw, java.lang.String) void
        public void method_744(String[] param1, class_143 param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3221;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.mx, android.app.PendingIntent) void
        public void method_745(class_880 param1, PendingIntent param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.mx, com.google.android.gms.internal.mv) void
        public void method_746(String param1, class_880 param2, class_162 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: bW (java.lang.String) android.location.Location
        public Location method_747(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            Location var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    var2.writeString(var1);
                    this.field_3221.transact(21, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (Location)Location.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: bX (java.lang.String) com.google.android.gms.location.c
        public class_667 method_748(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var9 = false;

            class_667 var6;
            label42: {
                class_667 var7;
                label41: {
                    try {
                        var9 = true;
                        var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                        var2.writeString(var1);
                        this.field_3221.transact(34, var2, var3, 0);
                        var3.readException();
                        if(var3.readInt() != 0) {
                            var7 = class_667.CREATOR.method_3723(var3);
                            var9 = false;
                            break label41;
                        }

                        var9 = false;
                    } finally {
                        if(var9) {
                            var3.recycle();
                            var2.recycle();
                        }
                    }

                    var6 = null;
                    break label42;
                }

                var6 = var7;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: lV () android.location.Location
        public Location method_749() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Location var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.field_3221.transact(7, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Location)Location.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: lW () android.os.IBinder
        public IBinder method_750() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            IBinder var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.field_3221.transact(51, var1, var2, 0);
                var2.readException();
                var5 = var2.readStrongBinder();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: lX () android.os.IBinder
        public IBinder method_751() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            IBinder var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.field_3221.transact(54, var1, var2, 0);
                var2.readException();
                var5 = var2.readStrongBinder();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public void removeActivityUpdates(PendingIntent param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setMockLocation(Location param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setMockMode(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
