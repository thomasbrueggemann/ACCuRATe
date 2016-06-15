package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_23;
import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.class_299;
import com.google.android.gms.internal.class_301;
import com.google.android.gms.internal.class_305;
import com.google.android.gms.internal.class_308;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.class_312;
import com.google.android.gms.internal.class_314;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.jz;
import com.google.android.gms.internal.kb;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_549;
import com.google.android.gms.location.class_86;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jf
public interface class_22 extends IInterface {
   // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
   void method_77(long var1, boolean var3, PendingIntent var4) throws RemoteException;

   // $FF: renamed from: a (android.app.PendingIntent) void
   void method_78(PendingIntent var1) throws RemoteException;

   // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.je, java.lang.String) void
   void method_79(PendingIntent var1, class_23 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (android.location.Location, int) void
   void method_80(Location var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.je, java.lang.String) void
   void method_81(class_23 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.jl, com.google.android.gms.internal.kb, android.app.PendingIntent) void
   void method_82(class_312 var1, class_298 var2, PendingIntent var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_83(class_310 var1, class_298 var2, class_20 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.jp, com.google.android.gms.internal.kb) void
   void method_84(class_308 var1, class_298 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.jr, com.google.android.gms.internal.kb, android.app.PendingIntent) void
   void method_85(class_305 var1, class_298 var2, PendingIntent var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.jv, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_86(class_301 var1, class_298 var2, class_20 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.kb, android.app.PendingIntent) void
   void method_87(class_298 var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
   void method_88(LocationRequest var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a) void
   void method_89(LocationRequest var1, class_86 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a, java.lang.String) void
   void method_90(LocationRequest var1, class_86 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.a) void
   void method_91(class_86 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_92(LatLng var1, class_310 var2, class_298 var3, class_20 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_93(LatLngBounds var1, int var2, class_310 var3, class_298 var4, class_20 var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_94(LatLngBounds var1, int var2, String var3, class_310 var4, class_298 var5, class_20 var6) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_95(String var1, class_298 var2, class_20 var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_96(String var1, LatLngBounds var2, class_310 var3, class_298 var4, class_20 var5) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.util.List, java.util.List, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_97(String var1, List<String> var2, List<jx> var3, kb var4, jz var5) throws RemoteException;

   // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.je, java.lang.String) void
   void method_98(List<ji> var1, PendingIntent var2, je var3, String var4) throws RemoteException;

   // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.je, java.lang.String) void
   void method_99(String[] var1, class_23 var2, String var3) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.kb, android.app.PendingIntent) void
   void method_100(class_298 var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
   void method_101(String var1, class_298 var2, class_20 var3) throws RemoteException;

   // $FF: renamed from: bo (java.lang.String) android.location.Location
   Location method_102(String var1) throws RemoteException;

   // $FF: renamed from: bp (java.lang.String) com.google.android.gms.location.b
   class_549 method_103(String var1) throws RemoteException;

   // $FF: renamed from: iR () android.location.Location
   Location method_104() throws RemoteException;

   // $FF: renamed from: iS () android.os.IBinder
   IBinder method_105() throws RemoteException;

   void removeActivityUpdates(PendingIntent var1) throws RemoteException;

   void setMockLocation(Location var1) throws RemoteException;

   void setMockMode(boolean var1) throws RemoteException;

   public abstract static class class_1015 extends Binder implements class_22 {
      // $FF: renamed from: as (android.os.IBinder) com.google.android.gms.internal.jf
      public static class_22 method_2863(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (class_22)(var1 != null && var1 instanceof class_22?(class_22)var1:new class_22.class_1016(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ArrayList var73 = var2.createTypedArrayList(class_314.CREATOR);
            PendingIntent var74;
            if(var2.readInt() != 0) {
               var74 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var74 = null;
            }

            this.a(var73, var74, class_23.class_1053.method_3477(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var72;
            if(var2.readInt() != 0) {
               var72 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var72 = null;
            }

            this.a(var72, class_23.class_1053.method_3477(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(var2.createStringArray(), class_23.class_1053.method_3477(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(class_23.class_1053.method_3477(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            long var68 = var2.readLong();
            boolean var70;
            if(var2.readInt() != 0) {
               var70 = true;
            } else {
               var70 = false;
            }

            PendingIntent var71;
            if(var2.readInt() != 0) {
               var71 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var71 = null;
            }

            this.a(var68, var70, var71);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var67;
            if(var2.readInt() != 0) {
               var67 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var67 = null;
            }

            this.removeActivityUpdates(var67);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var66 = this.iR();
            var3.writeNoException();
            if(var66 != null) {
               var3.writeInt(1);
               var66.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var64 = var2.readInt();
            LocationRequest var65 = null;
            if(var64 != 0) {
               var65 = LocationRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var65, class_86.class_898.method_2001(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationRequest var62;
            if(var2.readInt() != 0) {
               var62 = LocationRequest.CREATOR.createFromParcel(var2);
            } else {
               var62 = null;
            }

            PendingIntent var63;
            if(var2.readInt() != 0) {
               var63 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var63 = null;
            }

            this.a(var62, var63);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(class_86.class_898.method_2001(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var61;
            if(var2.readInt() != 0) {
               var61 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var61 = null;
            }

            this.a(var61);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var59 = var2.readInt();
            boolean var60 = false;
            if(var59 != 0) {
               var60 = true;
            }

            this.setMockMode(var60);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var58;
            if(var2.readInt() != 0) {
               var58 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var58 = null;
            }

            this.setMockLocation(var58);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLngBounds var54;
            if(var2.readInt() != 0) {
               var54 = LatLngBounds.CREATOR.createFromParcel(var2);
            } else {
               var54 = null;
            }

            int var55 = var2.readInt();
            class_310 var56;
            if(var2.readInt() != 0) {
               var56 = class_310.CREATOR.method_2013(var2);
            } else {
               var56 = null;
            }

            class_298 var57;
            if(var2.readInt() != 0) {
               var57 = class_298.CREATOR.method_3632(var2);
            } else {
               var57 = null;
            }

            this.a(var54, var55, var56, var57, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var45 = var2.readString();
            int var46 = var2.readInt();
            class_298 var47 = null;
            if(var46 != 0) {
               var47 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var45, var47, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLng var41;
            if(var2.readInt() != 0) {
               var41 = LatLng.CREATOR.createFromParcel(var2);
            } else {
               var41 = null;
            }

            class_310 var42;
            if(var2.readInt() != 0) {
               var42 = class_310.CREATOR.method_2013(var2);
            } else {
               var42 = null;
            }

            int var43 = var2.readInt();
            class_298 var44 = null;
            if(var43 != 0) {
               var44 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var41, var42, var44, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_310 var38;
            if(var2.readInt() != 0) {
               var38 = class_310.CREATOR.method_2013(var2);
            } else {
               var38 = null;
            }

            int var39 = var2.readInt();
            class_298 var40 = null;
            if(var39 != 0) {
               var40 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var38, var40, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_305 var28;
            if(var2.readInt() != 0) {
               var28 = class_305.CREATOR.method_2004(var2);
            } else {
               var28 = null;
            }

            class_298 var29;
            if(var2.readInt() != 0) {
               var29 = class_298.CREATOR.method_3632(var2);
            } else {
               var29 = null;
            }

            PendingIntent var30;
            if(var2.readInt() != 0) {
               var30 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var30 = null;
            }

            this.a(var28, var29, var30);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_298 var26;
            if(var2.readInt() != 0) {
               var26 = class_298.CREATOR.method_3632(var2);
            } else {
               var26 = null;
            }

            PendingIntent var27;
            if(var2.readInt() != 0) {
               var27 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var27 = null;
            }

            this.a(var26, var27);
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var12 = var2.readInt();
            LocationRequest var13 = null;
            if(var12 != 0) {
               var13 = LocationRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var13, class_86.class_898.method_2001(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var11 = this.bo(var2.readString());
            var3.writeNoException();
            if(var11 != null) {
               var3.writeInt(1);
               var11.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_308 var8;
            if(var2.readInt() != 0) {
               var8 = class_308.CREATOR.method_2007(var2);
            } else {
               var8 = null;
            }

            int var9 = var2.readInt();
            class_298 var10 = null;
            if(var9 != 0) {
               var10 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var8, var10);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var7;
            if(var2.readInt() != 0) {
               var7 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var7, var2.readInt());
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_549 var6 = this.bp(var2.readString());
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var35 = var2.readString();
            int var36 = var2.readInt();
            class_298 var37 = null;
            if(var36 != 0) {
               var37 = class_298.CREATOR.method_3632(var2);
            }

            this.b(var35, var37, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var17 = var2.readString();
            LatLngBounds var18;
            if(var2.readInt() != 0) {
               var18 = LatLngBounds.CREATOR.createFromParcel(var2);
            } else {
               var18 = null;
            }

            class_310 var19;
            if(var2.readInt() != 0) {
               var19 = class_310.CREATOR.method_2013(var2);
            } else {
               var19 = null;
            }

            class_298 var20;
            if(var2.readInt() != 0) {
               var20 = class_298.CREATOR.method_3632(var2);
            } else {
               var20 = null;
            }

            this.a(var17, var18, var19, var20, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_301 var14;
            if(var2.readInt() != 0) {
               var14 = (class_301)class_301.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            int var15 = var2.readInt();
            class_298 var16 = null;
            if(var15 != 0) {
               var16 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var14, var16, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 47:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLngBounds var48;
            if(var2.readInt() != 0) {
               var48 = LatLngBounds.CREATOR.createFromParcel(var2);
            } else {
               var48 = null;
            }

            int var49 = var2.readInt();
            String var50 = var2.readString();
            class_310 var51;
            if(var2.readInt() != 0) {
               var51 = class_310.CREATOR.method_2013(var2);
            } else {
               var51 = null;
            }

            int var52 = var2.readInt();
            class_298 var53 = null;
            if(var52 != 0) {
               var53 = class_298.CREATOR.method_3632(var2);
            }

            this.a(var48, var49, var50, var51, var53, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 48:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_312 var23;
            if(var2.readInt() != 0) {
               var23 = class_312.CREATOR.method_2020(var2);
            } else {
               var23 = null;
            }

            class_298 var24;
            if(var2.readInt() != 0) {
               var24 = class_298.CREATOR.method_3632(var2);
            } else {
               var24 = null;
            }

            PendingIntent var25;
            if(var2.readInt() != 0) {
               var25 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var25 = null;
            }

            this.a(var23, var24, var25);
            var3.writeNoException();
            return true;
         case 49:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_298 var21;
            if(var2.readInt() != 0) {
               var21 = class_298.CREATOR.method_3632(var2);
            } else {
               var21 = null;
            }

            PendingIntent var22;
            if(var2.readInt() != 0) {
               var22 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var22 = null;
            }

            this.b(var21, var22);
            var3.writeNoException();
            return true;
         case 50:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var31 = var2.readString();
            ArrayList var32 = var2.createStringArrayList();
            ArrayList var33 = var2.createTypedArrayList(class_299.CREATOR);
            class_298 var34;
            if(var2.readInt() != 0) {
               var34 = class_298.CREATOR.method_3632(var2);
            } else {
               var34 = null;
            }

            this.a(var31, var32, var33, var34, class_20.class_1049.method_4250(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 51:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder var5 = this.iS();
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1016 implements class_22 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3666;

      class_1016(IBinder var1) {
         this.field_3666 = var1;
      }

      // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
      public void method_77(long param1, boolean param3, PendingIntent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.app.PendingIntent) void
      public void method_78(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.je, java.lang.String) void
      public void method_79(PendingIntent param1, class_23 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.location.Location, int) void
      public void method_80(Location param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.je, java.lang.String) void
      public void method_81(class_23 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jl, com.google.android.gms.internal.kb, android.app.PendingIntent) void
      public void method_82(class_312 param1, class_298 param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_83(class_310 param1, class_298 param2, class_20 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jp, com.google.android.gms.internal.kb) void
      public void method_84(class_308 param1, class_298 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jr, com.google.android.gms.internal.kb, android.app.PendingIntent) void
      public void method_85(class_305 param1, class_298 param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jv, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_86(class_301 param1, class_298 param2, class_20 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kb, android.app.PendingIntent) void
      public void method_87(class_298 param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
      public void method_88(LocationRequest param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a) void
      public void method_89(LocationRequest param1, class_86 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.a, java.lang.String) void
      public void method_90(LocationRequest param1, class_86 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.a) void
      public void method_91(class_86 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_92(LatLng param1, class_310 param2, class_298 param3, class_20 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_93(LatLngBounds param1, int param2, class_310 param3, class_298 param4, class_20 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_94(LatLngBounds param1, int param2, String param3, class_310 param4, class_298 param5, class_20 param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_95(String param1, class_298 param2, class_20 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.jn, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_96(String param1, LatLngBounds param2, class_310 param3, class_298 param4, class_20 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.util.List, java.util.List, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_97(String param1, List<String> param2, List<jx> param3, kb param4, jz param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.je, java.lang.String) void
      public void method_98(List<ji> param1, PendingIntent param2, je param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.je, java.lang.String) void
      public void method_99(String[] param1, class_23 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3666;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.kb, android.app.PendingIntent) void
      public void method_100(class_298 param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.kb, com.google.android.gms.internal.jz) void
      public void method_101(String param1, class_298 param2, class_20 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: bo (java.lang.String) android.location.Location
      public Location method_102(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Location var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               var2.writeString(var1);
               this.field_3666.transact(21, var2, var3, 0);
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

      // $FF: renamed from: bp (java.lang.String) com.google.android.gms.location.b
      public class_549 method_103(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         class_549 var6;
         label42: {
            class_549 var7;
            label41: {
               try {
                  var9 = true;
                  var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                  var2.writeString(var1);
                  this.field_3666.transact(34, var2, var3, 0);
                  var3.readException();
                  if(var3.readInt() != 0) {
                     var7 = class_549.CREATOR.method_3119(var3);
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

      // $FF: renamed from: iR () android.location.Location
      public Location method_104() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Location var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               this.field_3666.transact(7, var1, var2, 0);
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

      // $FF: renamed from: iS () android.os.IBinder
      public IBinder method_105() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IBinder var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.field_3666.transact(51, var1, var2, 0);
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
