package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_146;
import com.google.android.gms.internal.class_165;
import com.google.android.gms.internal.class_749;
import com.google.android.gms.internal.class_751;
import com.google.android.gms.internal.class_752;
import com.google.android.gms.internal.class_754;
import com.google.android.gms.internal.class_757;
import com.google.android.gms.internal.class_759;
import com.google.android.gms.internal.class_761;
import com.google.android.gms.internal.class_763;
import com.google.android.gms.internal.class_767;
import com.google.android.gms.internal.class_813;
import com.google.android.gms.internal.nh;
import com.google.android.gms.internal.nn;
import com.google.android.gms.internal.oe;
import com.google.android.gms.internal.og;
import com.google.android.gms.internal.oh;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_650;
import com.google.android.gms.location.class_92;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ni
public interface class_147 extends IInterface {
   // $FF: renamed from: S (boolean) void
   void method_774(boolean var1) throws RemoteException;

   // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
   void method_775(long var1, boolean var3, PendingIntent var4) throws RemoteException;

   // $FF: renamed from: a (android.app.PendingIntent) void
   void method_776(PendingIntent var1) throws RemoteException;

   // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.nh, java.lang.String) void
   void method_777(PendingIntent var1, class_146 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (android.location.Location, int) void
   void method_778(Location var1, int var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.nh, java.lang.String) void
   void method_779(class_146 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.nl, android.app.PendingIntent) void
   void method_780(class_767 var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.nl, com.google.android.gms.location.b) void
   void method_781(class_767 var1, class_92 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.ns, com.google.android.gms.internal.oh, android.app.PendingIntent) void
   void method_782(class_761 var1, class_813 var2, PendingIntent var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_783(class_763 var1, class_813 var2, class_165 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.nw, com.google.android.gms.internal.oh) void
   void method_784(class_752 var1, class_813 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.ny, com.google.android.gms.internal.oh, android.app.PendingIntent) void
   void method_785(class_754 var1, class_813 var2, PendingIntent var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.oc, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_786(class_749 var1, class_813 var2, class_165 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.oe, com.google.android.gms.maps.model.LatLngBounds, java.util.List, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_787(oe var1, LatLngBounds var2, List<String> var3, oh var4, og var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.oh, android.app.PendingIntent) void
   void method_788(class_813 var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.GeofencingRequest, android.app.PendingIntent, com.google.android.gms.internal.nh) void
   void method_789(GeofencingRequest var1, PendingIntent var2, class_146 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
   void method_790(LocationRequest var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.b) void
   void method_791(LocationRequest var1, class_92 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.b, java.lang.String) void
   void method_792(LocationRequest var1, class_92 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.location.b) void
   void method_793(class_92 var1) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_794(LatLng var1, class_763 var2, class_813 var3, class_165 var4) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_795(LatLngBounds var1, int var2, class_763 var3, class_813 var4, class_165 var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_796(LatLngBounds var1, int var2, String var3, class_763 var4, class_813 var5, class_165 var6) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_797(String var1, class_813 var2, class_165 var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.nq, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_798(String var1, LatLngBounds var2, class_759 var3, class_813 var4, class_165 var5) throws RemoteException;

   // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.nh, java.lang.String) void
   void method_799(List<nn> var1, PendingIntent var2, nh var3, String var4) throws RemoteException;

   // $FF: renamed from: a (java.util.List, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_800(List<String> var1, oh var2, og var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.nh, java.lang.String) void
   void method_801(String[] var1, class_146 var2, String var3) throws RemoteException;

   // $FF: renamed from: b (android.app.PendingIntent) void
   void method_802(PendingIntent var1) throws RemoteException;

   // $FF: renamed from: b (android.location.Location) void
   void method_803(Location var1) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.oh, android.app.PendingIntent) void
   void method_804(class_813 var1, PendingIntent var2) throws RemoteException;

   // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
   void method_805(String var1, class_813 var2, class_165 var3) throws RemoteException;

   // $FF: renamed from: bZ (java.lang.String) android.location.Location
   Location method_806(String var1) throws RemoteException;

   // $FF: renamed from: ca (java.lang.String) com.google.android.gms.location.e
   class_650 method_807(String var1) throws RemoteException;

   // $FF: renamed from: ni () android.location.Location
   Location method_808() throws RemoteException;

   // $FF: renamed from: nj () android.os.IBinder
   IBinder method_809() throws RemoteException;

   // $FF: renamed from: nk () android.os.IBinder
   IBinder method_810() throws RemoteException;

   public abstract static class class_1065 extends Binder implements class_147 {
      // $FF: renamed from: aO (android.os.IBinder) com.google.android.gms.internal.ni
      public static class_147 method_1608(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (class_147)(var1 != null && var1 instanceof class_147?(class_147)var1:new class_147.class_1066(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ArrayList var83 = var2.createTypedArrayList(class_757.CREATOR);
            PendingIntent var84;
            if(var2.readInt() != 0) {
               var84 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var84 = null;
            }

            this.a(var83, var84, class_146.class_1445.method_3755(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var80;
            if(var2.readInt() != 0) {
               var80 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var80 = null;
            }

            this.a(var80, class_146.class_1445.method_3755(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(var2.createStringArray(), class_146.class_1445.method_3755(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(class_146.class_1445.method_3755(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            long var76 = var2.readLong();
            boolean var78;
            if(var2.readInt() != 0) {
               var78 = true;
            } else {
               var78 = false;
            }

            PendingIntent var79;
            if(var2.readInt() != 0) {
               var79 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var79 = null;
            }

            this.a(var76, var78, var79);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var75;
            if(var2.readInt() != 0) {
               var75 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var75 = null;
            }

            this.a(var75);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var74 = this.ni();
            var3.writeNoException();
            if(var74 != null) {
               var3.writeInt(1);
               var74.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var72 = var2.readInt();
            LocationRequest var73 = null;
            if(var72 != 0) {
               var73 = LocationRequest.CREATOR.method_3719(var2);
            }

            this.a(var73, class_92.class_1059.method_1589(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LocationRequest var68;
            if(var2.readInt() != 0) {
               var68 = LocationRequest.CREATOR.method_3719(var2);
            } else {
               var68 = null;
            }

            PendingIntent var69;
            if(var2.readInt() != 0) {
               var69 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var69 = null;
            }

            this.a(var68, var69);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a(class_92.class_1059.method_1589(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent var63;
            if(var2.readInt() != 0) {
               var63 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var63 = null;
            }

            this.b(var63);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var61 = var2.readInt();
            boolean var62 = false;
            if(var61 != 0) {
               var62 = true;
            }

            this.S(var62);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var60;
            if(var2.readInt() != 0) {
               var60 = (Location)Location.CREATOR.createFromParcel(var2);
            } else {
               var60 = null;
            }

            this.b(var60);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLngBounds var56;
            if(var2.readInt() != 0) {
               var56 = LatLngBounds.CREATOR.method_5000(var2);
            } else {
               var56 = null;
            }

            int var57 = var2.readInt();
            class_763 var58;
            if(var2.readInt() != 0) {
               var58 = class_763.CREATOR.method_4331(var2);
            } else {
               var58 = null;
            }

            class_813 var59;
            if(var2.readInt() != 0) {
               var59 = class_813.CREATOR.method_4460(var2);
            } else {
               var59 = null;
            }

            this.a(var56, var57, var58, var59, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var47 = var2.readString();
            int var48 = var2.readInt();
            class_813 var49 = null;
            if(var48 != 0) {
               var49 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var47, var49, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLng var43;
            if(var2.readInt() != 0) {
               var43 = LatLng.CREATOR.method_5012(var2);
            } else {
               var43 = null;
            }

            class_763 var44;
            if(var2.readInt() != 0) {
               var44 = class_763.CREATOR.method_4331(var2);
            } else {
               var44 = null;
            }

            int var45 = var2.readInt();
            class_813 var46 = null;
            if(var45 != 0) {
               var46 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var43, var44, var46, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_763 var40;
            if(var2.readInt() != 0) {
               var40 = class_763.CREATOR.method_4331(var2);
            } else {
               var40 = null;
            }

            int var41 = var2.readInt();
            class_813 var42 = null;
            if(var41 != 0) {
               var42 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var40, var42, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_754 var27;
            if(var2.readInt() != 0) {
               var27 = class_754.CREATOR.method_4338(var2);
            } else {
               var27 = null;
            }

            class_813 var28;
            if(var2.readInt() != 0) {
               var28 = class_813.CREATOR.method_4460(var2);
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
            class_813 var25;
            if(var2.readInt() != 0) {
               var25 = class_813.CREATOR.method_4460(var2);
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
            int var70 = var2.readInt();
            LocationRequest var71 = null;
            if(var70 != 0) {
               var71 = LocationRequest.CREATOR.method_3719(var2);
            }

            this.a(var71, class_92.class_1059.method_1589(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location var12 = this.bZ(var2.readString());
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
            class_752 var9;
            if(var2.readInt() != 0) {
               var9 = class_752.CREATOR.method_4335(var2);
            } else {
               var9 = null;
            }

            int var10 = var2.readInt();
            class_813 var11 = null;
            if(var10 != 0) {
               var11 = class_813.CREATOR.method_4460(var2);
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
            class_650 var7 = this.ca(var2.readString());
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
            String var37 = var2.readString();
            int var38 = var2.readInt();
            class_813 var39 = null;
            if(var38 != 0) {
               var39 = class_813.CREATOR.method_4460(var2);
            }

            this.b(var37, var39, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_749 var13;
            if(var2.readInt() != 0) {
               var13 = (class_749)class_749.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            int var14 = var2.readInt();
            class_813 var15 = null;
            if(var14 != 0) {
               var15 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var13, var15, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 47:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            LatLngBounds var50;
            if(var2.readInt() != 0) {
               var50 = LatLngBounds.CREATOR.method_5000(var2);
            } else {
               var50 = null;
            }

            int var51 = var2.readInt();
            String var52 = var2.readString();
            class_763 var53;
            if(var2.readInt() != 0) {
               var53 = class_763.CREATOR.method_4331(var2);
            } else {
               var53 = null;
            }

            int var54 = var2.readInt();
            class_813 var55 = null;
            if(var54 != 0) {
               var55 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var50, var51, var52, var53, var55, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 48:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_761 var22;
            if(var2.readInt() != 0) {
               var22 = class_761.CREATOR.method_4362(var2);
            } else {
               var22 = null;
            }

            class_813 var23;
            if(var2.readInt() != 0) {
               var23 = class_813.CREATOR.method_4460(var2);
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
            class_813 var20;
            if(var2.readInt() != 0) {
               var20 = class_813.CREATOR.method_4460(var2);
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
            class_751 var30;
            if(var2.readInt() != 0) {
               var30 = class_751.CREATOR.method_4326(var2);
            } else {
               var30 = null;
            }

            LatLngBounds var31;
            if(var2.readInt() != 0) {
               var31 = LatLngBounds.CREATOR.method_5000(var2);
            } else {
               var31 = null;
            }

            ArrayList var32 = var2.createStringArrayList();
            class_813 var33;
            if(var2.readInt() != 0) {
               var33 = class_813.CREATOR.method_4460(var2);
            } else {
               var33 = null;
            }

            this.a(var30, var31, var32, var33, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 51:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder var6 = this.nj();
            var3.writeNoException();
            var3.writeStrongBinder(var6);
            return true;
         case 52:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int var66 = var2.readInt();
            class_767 var67 = null;
            if(var66 != 0) {
               var67 = class_767.CREATOR.method_4381(var2);
            }

            this.a(var67, class_92.class_1059.method_1589(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            class_767 var64;
            if(var2.readInt() != 0) {
               var64 = class_767.CREATOR.method_4381(var2);
            } else {
               var64 = null;
            }

            PendingIntent var65;
            if(var2.readInt() != 0) {
               var65 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var65 = null;
            }

            this.a(var64, var65);
            var3.writeNoException();
            return true;
         case 54:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder var5 = this.nk();
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 55:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String var16 = var2.readString();
            LatLngBounds var17;
            if(var2.readInt() != 0) {
               var17 = LatLngBounds.CREATOR.method_5000(var2);
            } else {
               var17 = null;
            }

            class_759 var18;
            if(var2.readInt() != 0) {
               var18 = class_759.CREATOR.method_4356(var2);
            } else {
               var18 = null;
            }

            class_813 var19;
            if(var2.readInt() != 0) {
               var19 = class_813.CREATOR.method_4460(var2);
            } else {
               var19 = null;
            }

            this.a(var16, var17, var18, var19, class_165.class_1426.method_4817(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 57:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            GeofencingRequest var81;
            if(var2.readInt() != 0) {
               var81 = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(var2);
            } else {
               var81 = null;
            }

            PendingIntent var82;
            if(var2.readInt() != 0) {
               var82 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            } else {
               var82 = null;
            }

            this.a(var81, var82, class_146.class_1445.method_3755(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 58:
            var2.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            ArrayList var34 = var2.createStringArrayList();
            int var35 = var2.readInt();
            class_813 var36 = null;
            if(var35 != 0) {
               var36 = class_813.CREATOR.method_4460(var2);
            }

            this.a(var34, var36, class_165.class_1426.method_4817(var2.readStrongBinder()));
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

   private static class class_1066 implements class_147 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3206;

      class_1066(IBinder var1) {
         this.field_3206 = var1;
      }

      // $FF: renamed from: S (boolean) void
      public void method_774(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (long, boolean, android.app.PendingIntent) void
      public void method_775(long param1, boolean param3, PendingIntent param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.app.PendingIntent) void
      public void method_776(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.internal.nh, java.lang.String) void
      public void method_777(PendingIntent param1, class_146 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (android.location.Location, int) void
      public void method_778(Location param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.nh, java.lang.String) void
      public void method_779(class_146 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.nl, android.app.PendingIntent) void
      public void method_780(class_767 param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.nl, com.google.android.gms.location.b) void
      public void method_781(class_767 param1, class_92 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ns, com.google.android.gms.internal.oh, android.app.PendingIntent) void
      public void method_782(class_761 param1, class_813 param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_783(class_763 param1, class_813 param2, class_165 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.nw, com.google.android.gms.internal.oh) void
      public void method_784(class_752 param1, class_813 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ny, com.google.android.gms.internal.oh, android.app.PendingIntent) void
      public void method_785(class_754 param1, class_813 param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.oc, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_786(class_749 param1, class_813 param2, class_165 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.oe, com.google.android.gms.maps.model.LatLngBounds, java.util.List, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_787(oe param1, LatLngBounds param2, List<String> param3, oh param4, og param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.oh, android.app.PendingIntent) void
      public void method_788(class_813 param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.GeofencingRequest, android.app.PendingIntent, com.google.android.gms.internal.nh) void
      public void method_789(GeofencingRequest param1, PendingIntent param2, class_146 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
      public void method_790(LocationRequest param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.b) void
      public void method_791(LocationRequest param1, class_92 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.b, java.lang.String) void
      public void method_792(LocationRequest param1, class_92 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.location.b) void
      public void method_793(class_92 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLng, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_794(LatLng param1, class_763 param2, class_813 param3, class_165 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_795(LatLngBounds param1, int param2, class_763 param3, class_813 param4, class_165 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.LatLngBounds, int, java.lang.String, com.google.android.gms.internal.nu, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_796(LatLngBounds param1, int param2, String param3, class_763 param4, class_813 param5, class_165 param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_797(String param1, class_813 param2, class_165 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.maps.model.LatLngBounds, com.google.android.gms.internal.nq, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_798(String param1, LatLngBounds param2, class_759 param3, class_813 param4, class_165 param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.util.List, android.app.PendingIntent, com.google.android.gms.internal.nh, java.lang.String) void
      public void method_799(List<nn> param1, PendingIntent param2, nh param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.util.List, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_800(List<String> param1, oh param2, og param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String[], com.google.android.gms.internal.nh, java.lang.String) void
      public void method_801(String[] param1, class_146 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3206;
      }

      // $FF: renamed from: b (android.app.PendingIntent) void
      public void method_802(PendingIntent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (android.location.Location) void
      public void method_803(Location param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.internal.oh, android.app.PendingIntent) void
      public void method_804(class_813 param1, PendingIntent param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.oh, com.google.android.gms.internal.og) void
      public void method_805(String param1, class_813 param2, class_165 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: bZ (java.lang.String) android.location.Location
      public Location method_806(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         Location var6;
         label36: {
            try {
               var8 = true;
               var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               var2.writeString(var1);
               this.field_3206.transact(21, var2, var3, 0);
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

      // $FF: renamed from: ca (java.lang.String) com.google.android.gms.location.e
      public class_650 method_807(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         class_650 var6;
         label42: {
            class_650 var7;
            label41: {
               try {
                  var9 = true;
                  var2.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                  var2.writeString(var1);
                  this.field_3206.transact(34, var2, var3, 0);
                  var3.readException();
                  if(var3.readInt() != 0) {
                     var7 = class_650.CREATOR.method_3716(var3);
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

      // $FF: renamed from: ni () android.location.Location
      public Location method_808() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Location var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
               this.field_3206.transact(7, var1, var2, 0);
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

      // $FF: renamed from: nj () android.os.IBinder
      public IBinder method_809() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IBinder var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.field_3206.transact(51, var1, var2, 0);
            var2.readException();
            var5 = var2.readStrongBinder();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      // $FF: renamed from: nk () android.os.IBinder
      public IBinder method_810() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IBinder var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.field_3206.transact(54, var1, var2, 0);
            var2.readException();
            var5 = var2.readStrongBinder();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
