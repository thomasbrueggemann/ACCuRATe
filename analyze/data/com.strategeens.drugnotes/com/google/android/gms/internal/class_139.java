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
import com.google.android.gms.fitness.request.class_483;
import com.google.android.gms.fitness.request.class_486;
import com.google.android.gms.fitness.request.class_488;
import com.google.android.gms.fitness.request.class_490;
import com.google.android.gms.fitness.request.class_494;
import com.google.android.gms.fitness.request.class_495;
import com.google.android.gms.fitness.request.class_497;
import com.google.android.gms.fitness.request.class_500;
import com.google.android.gms.fitness.request.class_502;
import com.google.android.gms.fitness.request.class_506;
import com.google.android.gms.fitness.request.class_510;
import com.google.android.gms.fitness.request.class_512;
import com.google.android.gms.fitness.request.class_514;
import com.google.android.gms.fitness.request.class_518;
import com.google.android.gms.internal.class_133;
import com.google.android.gms.internal.class_134;
import com.google.android.gms.internal.class_135;
import com.google.android.gms.internal.class_136;
import com.google.android.gms.internal.class_137;
import com.google.android.gms.internal.class_138;
import com.google.android.gms.internal.class_140;
import com.google.android.gms.internal.class_153;

// $FF: renamed from: com.google.android.gms.internal.lz
public interface class_139 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.internal.md, java.lang.String) void
   void method_741(DataDeleteRequest var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, com.google.android.gms.internal.lw, java.lang.String) void
   void method_742(DataReadRequest var1, class_140 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, com.google.android.gms.internal.lx, java.lang.String) void
   void method_743(DataSourcesRequest var1, class_138 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest, com.google.android.gms.internal.ly, java.lang.String) void
   void method_744(DataTypeCreateRequest var1, class_137 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.internal.md, java.lang.String) void
   void method_745(SessionInsertRequest var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.internal.mb, java.lang.String) void
   void method_746(SessionReadRequest var1, class_133 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.StartBleScanRequest, com.google.android.gms.internal.md, java.lang.String) void
   void method_747(StartBleScanRequest var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.aa, com.google.android.gms.internal.md, java.lang.String) void
   void method_748(class_494 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.ad, com.google.android.gms.internal.md, java.lang.String) void
   void method_749(class_490 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.af, com.google.android.gms.internal.md, java.lang.String) void
   void method_750(class_488 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.ah, com.google.android.gms.internal.md, java.lang.String) void
   void method_751(class_486 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, com.google.android.gms.internal.md, java.lang.String) void
   void method_752(class_483 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.b, com.google.android.gms.internal.md, java.lang.String) void
   void method_753(class_506 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.e, com.google.android.gms.internal.md, java.lang.String) void
   void method_754(class_502 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.j, com.google.android.gms.internal.ly, java.lang.String) void
   void method_755(class_500 var1, class_137 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.m, com.google.android.gms.internal.ma, java.lang.String) void
   void method_756(class_495 var1, class_134 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.o, com.google.android.gms.internal.md, java.lang.String) void
   void method_757(class_497 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.q, com.google.android.gms.internal.md, java.lang.String) void
   void method_758(class_518 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.u, com.google.android.gms.internal.md, java.lang.String) void
   void method_759(class_514 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.w, com.google.android.gms.internal.md, java.lang.String) void
   void method_760(class_512 var1, class_135 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.fitness.request.y, com.google.android.gms.internal.mc, java.lang.String) void
   void method_761(class_510 var1, class_136 var2, String var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.md, java.lang.String) void
   void method_762(class_135 var1, String var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.mp, java.lang.String) void
   void method_763(class_153 var1, String var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.internal.md, java.lang.String) void
   void method_764(class_135 var1, String var2) throws RemoteException;

   public abstract static class class_1087 extends Binder implements class_139 {
      // $FF: renamed from: av (android.os.IBinder) com.google.android.gms.internal.lz
      public static class_139 method_5623(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (class_139)(var1 != null && var1 instanceof class_139?(class_139)var1:new class_139.class_1088(var0));
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

            this.a(var46, class_138.class_1198.method_3071(var2.readStrongBinder()), var2.readString());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var43 = var2.readInt();
            class_497 var44 = null;
            if(var43 != 0) {
               var44 = (class_497)class_497.CREATOR.createFromParcel(var2);
            }

            this.a(var44, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var41 = var2.readInt();
            class_518 var42 = null;
            if(var41 != 0) {
               var42 = (class_518)class_518.CREATOR.createFromParcel(var2);
            }

            this.a(var42, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var39 = var2.readInt();
            class_488 var40 = null;
            if(var39 != 0) {
               var40 = (class_488)class_488.CREATOR.createFromParcel(var2);
            }

            this.a(var40, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var37 = var2.readInt();
            class_483 var38 = null;
            if(var37 != 0) {
               var38 = (class_483)class_483.CREATOR.createFromParcel(var2);
            }

            this.a(var38, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var35 = var2.readInt();
            class_495 var36 = null;
            if(var35 != 0) {
               var36 = (class_495)class_495.CREATOR.createFromParcel(var2);
            }

            this.a(var36, class_134.class_1181.method_3049(var2.readStrongBinder()), var2.readString());
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var33 = var2.readInt();
            class_502 var34 = null;
            if(var33 != 0) {
               var34 = (class_502)class_502.CREATOR.createFromParcel(var2);
            }

            this.a(var34, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var25 = var2.readInt();
            DataReadRequest var26 = null;
            if(var25 != 0) {
               var26 = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var26, class_140.class_1105.method_2336(var2.readStrongBinder()), var2.readString());
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var23 = var2.readInt();
            SessionInsertRequest var24 = null;
            if(var23 != 0) {
               var24 = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var24, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var21 = var2.readInt();
            SessionReadRequest var22 = null;
            if(var21 != 0) {
               var22 = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var22, class_133.class_1407.method_5281(var2.readStrongBinder()), var2.readString());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var19 = var2.readInt();
            class_512 var20 = null;
            if(var19 != 0) {
               var20 = (class_512)class_512.CREATOR.createFromParcel(var2);
            }

            this.a(var20, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var17 = var2.readInt();
            class_510 var18 = null;
            if(var17 != 0) {
               var18 = (class_510)class_510.CREATOR.createFromParcel(var2);
            }

            this.a(var18, class_136.class_1413.method_5280(var2.readStrongBinder()), var2.readString());
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var29 = var2.readInt();
            DataTypeCreateRequest var30 = null;
            if(var29 != 0) {
               var30 = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var30, class_137.class_1316.method_3412(var2.readStrongBinder()), var2.readString());
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var27 = var2.readInt();
            class_500 var28 = null;
            if(var27 != 0) {
               var28 = (class_500)class_500.CREATOR.createFromParcel(var2);
            }

            this.a(var28, class_137.class_1316.method_3412(var2.readStrongBinder()), var2.readString());
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var15 = var2.readInt();
            StartBleScanRequest var16 = null;
            if(var15 != 0) {
               var16 = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var16, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var13 = var2.readInt();
            class_490 var14 = null;
            if(var13 != 0) {
               var14 = (class_490)class_490.CREATOR.createFromParcel(var2);
            }

            this.a(var14, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var11 = var2.readInt();
            class_506 var12 = null;
            if(var11 != 0) {
               var12 = (class_506)class_506.CREATOR.createFromParcel(var2);
            }

            this.a(var12, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var9 = var2.readInt();
            class_486 var10 = null;
            if(var9 != 0) {
               var10 = (class_486)class_486.CREATOR.createFromParcel(var2);
            }

            this.a(var10, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var31 = var2.readInt();
            DataDeleteRequest var32 = null;
            if(var31 != 0) {
               var32 = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var32, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var7 = var2.readInt();
            class_514 var8 = null;
            if(var7 != 0) {
               var8 = (class_514)class_514.CREATOR.createFromParcel(var2);
            }

            this.a(var8, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            int var5 = var2.readInt();
            class_494 var6 = null;
            if(var5 != 0) {
               var6 = (class_494)class_494.CREATOR.createFromParcel(var2);
            }

            this.a(var6, class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.a(class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.b(class_135.class_1365.method_3888(var2.readStrongBinder()), var2.readString());
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            this.a(class_153.class_1451.method_2713(var2.readStrongBinder()), var2.readString());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1088 implements class_139 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_738;

      class_1088(IBinder var1) {
         this.field_738 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.internal.md, java.lang.String) void
      public void method_741(DataDeleteRequest param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest, com.google.android.gms.internal.lw, java.lang.String) void
      public void method_742(DataReadRequest param1, class_140 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.DataSourcesRequest, com.google.android.gms.internal.lx, java.lang.String) void
      public void method_743(DataSourcesRequest param1, class_138 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest, com.google.android.gms.internal.ly, java.lang.String) void
      public void method_744(DataTypeCreateRequest param1, class_137 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.internal.md, java.lang.String) void
      public void method_745(SessionInsertRequest param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.internal.mb, java.lang.String) void
      public void method_746(SessionReadRequest param1, class_133 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.StartBleScanRequest, com.google.android.gms.internal.md, java.lang.String) void
      public void method_747(StartBleScanRequest param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.aa, com.google.android.gms.internal.md, java.lang.String) void
      public void method_748(class_494 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.ad, com.google.android.gms.internal.md, java.lang.String) void
      public void method_749(class_490 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.af, com.google.android.gms.internal.md, java.lang.String) void
      public void method_750(class_488 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.ah, com.google.android.gms.internal.md, java.lang.String) void
      public void method_751(class_486 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.aj, com.google.android.gms.internal.md, java.lang.String) void
      public void method_752(class_483 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.b, com.google.android.gms.internal.md, java.lang.String) void
      public void method_753(class_506 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.e, com.google.android.gms.internal.md, java.lang.String) void
      public void method_754(class_502 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.j, com.google.android.gms.internal.ly, java.lang.String) void
      public void method_755(class_500 param1, class_137 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.m, com.google.android.gms.internal.ma, java.lang.String) void
      public void method_756(class_495 param1, class_134 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.o, com.google.android.gms.internal.md, java.lang.String) void
      public void method_757(class_497 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.q, com.google.android.gms.internal.md, java.lang.String) void
      public void method_758(class_518 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.u, com.google.android.gms.internal.md, java.lang.String) void
      public void method_759(class_514 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.w, com.google.android.gms.internal.md, java.lang.String) void
      public void method_760(class_512 param1, class_135 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.y, com.google.android.gms.internal.mc, java.lang.String) void
      public void method_761(class_510 param1, class_136 param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.md, java.lang.String) void
      public void method_762(class_135 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.mp, java.lang.String) void
      public void method_763(class_153 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_738;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.md, java.lang.String) void
      public void method_764(class_135 param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
