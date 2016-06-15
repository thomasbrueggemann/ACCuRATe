package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface IGamesCallbacks extends IInterface {
   // $FF: renamed from: A (com.google.android.gms.common.data.DataHolder) void
   void method_256(DataHolder var1) throws RemoteException;

   // $FF: renamed from: B (com.google.android.gms.common.data.DataHolder) void
   void method_257(DataHolder var1) throws RemoteException;

   // $FF: renamed from: C (com.google.android.gms.common.data.DataHolder) void
   void method_258(DataHolder var1) throws RemoteException;

   // $FF: renamed from: D (com.google.android.gms.common.data.DataHolder) void
   void method_259(DataHolder var1) throws RemoteException;

   // $FF: renamed from: E (com.google.android.gms.common.data.DataHolder) void
   void method_260(DataHolder var1) throws RemoteException;

   // $FF: renamed from: F (com.google.android.gms.common.data.DataHolder) void
   void method_261(DataHolder var1) throws RemoteException;

   // $FF: renamed from: G (com.google.android.gms.common.data.DataHolder) void
   void method_262(DataHolder var1) throws RemoteException;

   // $FF: renamed from: H (com.google.android.gms.common.data.DataHolder) void
   void method_263(DataHolder var1) throws RemoteException;

   // $FF: renamed from: I (com.google.android.gms.common.data.DataHolder) void
   void method_264(DataHolder var1) throws RemoteException;

   // $FF: renamed from: J (com.google.android.gms.common.data.DataHolder) void
   void method_265(DataHolder var1) throws RemoteException;

   // $FF: renamed from: K (com.google.android.gms.common.data.DataHolder) void
   void method_266(DataHolder var1) throws RemoteException;

   // $FF: renamed from: L (com.google.android.gms.common.data.DataHolder) void
   void method_267(DataHolder var1) throws RemoteException;

   // $FF: renamed from: M (com.google.android.gms.common.data.DataHolder) void
   void method_268(DataHolder var1) throws RemoteException;

   // $FF: renamed from: N (com.google.android.gms.common.data.DataHolder) void
   void method_269(DataHolder var1) throws RemoteException;

   // $FF: renamed from: O (com.google.android.gms.common.data.DataHolder) void
   void method_270(DataHolder var1) throws RemoteException;

   // $FF: renamed from: P (com.google.android.gms.common.data.DataHolder) void
   void method_271(DataHolder var1) throws RemoteException;

   // $FF: renamed from: a (int, java.lang.String, boolean) void
   void method_272(int var1, String var2, boolean var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder) void
   void method_273(DataHolder var1, DataHolder var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents) void
   void method_274(DataHolder var1, Contents var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents) void
   void method_275(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_276(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: b (int, int, java.lang.String) void
   void method_277(int var1, int var2, String var3) throws RemoteException;

   // $FF: renamed from: b (int, android.os.Bundle) void
   void method_278(int var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_279(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: c (int, android.os.Bundle) void
   void method_280(int var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder) void
   void method_281(DataHolder var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_282(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: cd (int) void
   void method_283(int var1) throws RemoteException;

   // $FF: renamed from: ce (int) void
   void method_284(int var1) throws RemoteException;

   // $FF: renamed from: d (int, android.os.Bundle) void
   void method_285(int var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: d (int, java.lang.String) void
   void method_286(int var1, String var2) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder) void
   void method_287(DataHolder var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_288(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: dO () void
   void method_289() throws RemoteException;

   // $FF: renamed from: e (int, android.os.Bundle) void
   void method_290(int var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: e (int, java.lang.String) void
   void method_291(int var1, String var2) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder) void
   void method_292(DataHolder var1) throws RemoteException;

   // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_293(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: f (int, android.os.Bundle) void
   void method_294(int var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: f (int, java.lang.String) void
   void method_295(int var1, String var2) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder) void
   void method_296(DataHolder var1) throws RemoteException;

   // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
   void method_297(DataHolder var1, String[] var2) throws RemoteException;

   // $FF: renamed from: g (int, java.lang.String) void
   void method_298(int var1, String var2) throws RemoteException;

   // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
   void method_299(DataHolder var1) throws RemoteException;

   // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder) void
   void method_300(DataHolder var1) throws RemoteException;

   // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder) void
   void method_301(DataHolder var1) throws RemoteException;

   // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder) void
   void method_302(DataHolder var1) throws RemoteException;

   // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder) void
   void method_303(DataHolder var1) throws RemoteException;

   // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder) void
   void method_304(DataHolder var1) throws RemoteException;

   // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder) void
   void method_305(DataHolder var1) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.common.data.DataHolder) void
   void method_306(DataHolder var1) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.common.data.DataHolder) void
   void method_307(DataHolder var1) throws RemoteException;

   void onInvitationRemoved(String var1) throws RemoteException;

   void onLeftRoom(int var1, String var2) throws RemoteException;

   void onP2PConnected(String var1) throws RemoteException;

   void onP2PDisconnected(String var1) throws RemoteException;

   void onRealTimeMessageReceived(RealTimeMessage var1) throws RemoteException;

   void onRequestRemoved(String var1) throws RemoteException;

   void onTurnBasedMatchRemoved(String var1) throws RemoteException;

   // $FF: renamed from: p (com.google.android.gms.common.data.DataHolder) void
   void method_308(DataHolder var1) throws RemoteException;

   // $FF: renamed from: q (com.google.android.gms.common.data.DataHolder) void
   void method_309(DataHolder var1) throws RemoteException;

   // $FF: renamed from: r (com.google.android.gms.common.data.DataHolder) void
   void method_310(DataHolder var1) throws RemoteException;

   // $FF: renamed from: s (com.google.android.gms.common.data.DataHolder) void
   void method_311(DataHolder var1) throws RemoteException;

   // $FF: renamed from: t (com.google.android.gms.common.data.DataHolder) void
   void method_312(DataHolder var1) throws RemoteException;

   // $FF: renamed from: u (com.google.android.gms.common.data.DataHolder) void
   void method_313(DataHolder var1) throws RemoteException;

   // $FF: renamed from: v (com.google.android.gms.common.data.DataHolder) void
   void method_314(DataHolder var1) throws RemoteException;

   // $FF: renamed from: w (com.google.android.gms.common.data.DataHolder) void
   void method_315(DataHolder var1) throws RemoteException;

   // $FF: renamed from: x (com.google.android.gms.common.data.DataHolder) void
   void method_316(DataHolder var1) throws RemoteException;

   // $FF: renamed from: y (com.google.android.gms.common.data.DataHolder) void
   void method_317(DataHolder var1) throws RemoteException;

   // $FF: renamed from: z (com.google.android.gms.common.data.DataHolder) void
   void method_318(DataHolder var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
      }

      // $FF: renamed from: ai (android.os.IBinder) com.google.android.gms.games.internal.IGamesCallbacks
      public static IGamesCallbacks method_2022(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (IGamesCallbacks)(var1 != null && var1 instanceof IGamesCallbacks?(IGamesCallbacks)var1:new IGamesCallbacks.Proxy(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.d(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            DataHolder var120;
            if(var2.readInt() != 0) {
               var120 = DataHolder.CREATOR.method_4283(var2);
            } else {
               var120 = null;
            }

            this.c(var120);
            var3.writeNoException();
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.e(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var118 = var2.readInt();
            DataHolder var119 = null;
            if(var118 != 0) {
               var119 = DataHolder.CREATOR.method_4283(var2);
            }

            this.e(var119);
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            DataHolder var115;
            if(var2.readInt() != 0) {
               var115 = DataHolder.CREATOR.method_4283(var2);
            } else {
               var115 = null;
            }

            int var116 = var2.readInt();
            DataHolder var117 = null;
            if(var116 != 0) {
               var117 = DataHolder.CREATOR.method_4283(var2);
            }

            this.a(var115, var117);
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var113 = var2.readInt();
            DataHolder var114 = null;
            if(var113 != 0) {
               var114 = DataHolder.CREATOR.method_4283(var2);
            }

            this.f(var114);
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var111 = var2.readInt();
            DataHolder var112 = null;
            if(var111 != 0) {
               var112 = DataHolder.CREATOR.method_4283(var2);
            }

            this.g(var112);
            var3.writeNoException();
            return true;
         case 5008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var109 = var2.readInt();
            DataHolder var110 = null;
            if(var109 != 0) {
               var110 = DataHolder.CREATOR.method_4283(var2);
            }

            this.h(var110);
            var3.writeNoException();
            return true;
         case 5009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var107 = var2.readInt();
            DataHolder var108 = null;
            if(var107 != 0) {
               var108 = DataHolder.CREATOR.method_4283(var2);
            }

            this.i(var108);
            var3.writeNoException();
            return true;
         case 5010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var105 = var2.readInt();
            DataHolder var106 = null;
            if(var105 != 0) {
               var106 = DataHolder.CREATOR.method_4283(var2);
            }

            this.j(var106);
            var3.writeNoException();
            return true;
         case 5011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var103 = var2.readInt();
            DataHolder var104 = null;
            if(var103 != 0) {
               var104 = DataHolder.CREATOR.method_4283(var2);
            }

            this.k(var104);
            var3.writeNoException();
            return true;
         case 5016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.dO();
            var3.writeNoException();
            return true;
         case 5017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var101 = var2.readInt();
            DataHolder var102 = null;
            if(var101 != 0) {
               var102 = DataHolder.CREATOR.method_4283(var2);
            }

            this.m(var102);
            var3.writeNoException();
            return true;
         case 5018:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var97 = var2.readInt();
            DataHolder var98 = null;
            if(var97 != 0) {
               var98 = DataHolder.CREATOR.method_4283(var2);
            }

            this.u(var98);
            var3.writeNoException();
            return true;
         case 5019:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var95 = var2.readInt();
            DataHolder var96 = null;
            if(var95 != 0) {
               var96 = DataHolder.CREATOR.method_4283(var2);
            }

            this.v(var96);
            var3.writeNoException();
            return true;
         case 5020:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onLeftRoom(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5021:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var93 = var2.readInt();
            DataHolder var94 = null;
            if(var93 != 0) {
               var94 = DataHolder.CREATOR.method_4283(var2);
            }

            this.w(var94);
            var3.writeNoException();
            return true;
         case 5022:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var91 = var2.readInt();
            DataHolder var92 = null;
            if(var91 != 0) {
               var92 = DataHolder.CREATOR.method_4283(var2);
            }

            this.x(var92);
            var3.writeNoException();
            return true;
         case 5023:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var89 = var2.readInt();
            DataHolder var90 = null;
            if(var89 != 0) {
               var90 = DataHolder.CREATOR.method_4283(var2);
            }

            this.y(var90);
            var3.writeNoException();
            return true;
         case 5024:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var87 = var2.readInt();
            DataHolder var88 = null;
            if(var87 != 0) {
               var88 = DataHolder.CREATOR.method_4283(var2);
            }

            this.z(var88);
            var3.writeNoException();
            return true;
         case 5025:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var85 = var2.readInt();
            DataHolder var86 = null;
            if(var85 != 0) {
               var86 = DataHolder.CREATOR.method_4283(var2);
            }

            this.A(var86);
            var3.writeNoException();
            return true;
         case 5026:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var83 = var2.readInt();
            DataHolder var84 = null;
            if(var83 != 0) {
               var84 = DataHolder.CREATOR.method_4283(var2);
            }

            this.a(var84, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5027:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var81 = var2.readInt();
            DataHolder var82 = null;
            if(var81 != 0) {
               var82 = DataHolder.CREATOR.method_4283(var2);
            }

            this.b(var82, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5028:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var79 = var2.readInt();
            DataHolder var80 = null;
            if(var79 != 0) {
               var80 = DataHolder.CREATOR.method_4283(var2);
            }

            this.c(var80, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5029:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var77 = var2.readInt();
            DataHolder var78 = null;
            if(var77 != 0) {
               var78 = DataHolder.CREATOR.method_4283(var2);
            }

            this.d(var78, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5030:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var75 = var2.readInt();
            DataHolder var76 = null;
            if(var75 != 0) {
               var76 = DataHolder.CREATOR.method_4283(var2);
            }

            this.e(var76, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5031:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var73 = var2.readInt();
            DataHolder var74 = null;
            if(var73 != 0) {
               var74 = DataHolder.CREATOR.method_4283(var2);
            }

            this.f(var74, var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5032:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            RealTimeMessage var72;
            if(var2.readInt() != 0) {
               var72 = (RealTimeMessage)RealTimeMessage.CREATOR.createFromParcel(var2);
            } else {
               var72 = null;
            }

            this.onRealTimeMessageReceived(var72);
            var3.writeNoException();
            return true;
         case 5033:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.b(var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 5034:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var69 = var2.readInt();
            String var70 = var2.readString();
            boolean var71;
            if(var2.readInt() != 0) {
               var71 = true;
            } else {
               var71 = false;
            }

            this.a(var69, var70, var71);
            var3.writeNoException();
            return true;
         case 5035:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var65 = var2.readInt();
            DataHolder var66 = null;
            if(var65 != 0) {
               var66 = DataHolder.CREATOR.method_4283(var2);
            }

            this.C(var66);
            var3.writeNoException();
            return true;
         case 5036:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.cd(var2.readInt());
            var3.writeNoException();
            return true;
         case 5037:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var99 = var2.readInt();
            DataHolder var100 = null;
            if(var99 != 0) {
               var100 = DataHolder.CREATOR.method_4283(var2);
            }

            this.n(var100);
            var3.writeNoException();
            return true;
         case 5038:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var67 = var2.readInt();
            DataHolder var68 = null;
            if(var67 != 0) {
               var68 = DataHolder.CREATOR.method_4283(var2);
            }

            this.B(var68);
            var3.writeNoException();
            return true;
         case 5039:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var63 = var2.readInt();
            DataHolder var64 = null;
            if(var63 != 0) {
               var64 = DataHolder.CREATOR.method_4283(var2);
            }

            this.D(var64);
            var3.writeNoException();
            return true;
         case 5040:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.ce(var2.readInt());
            var3.writeNoException();
            return true;
         case 6001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onP2PConnected(var2.readString());
            var3.writeNoException();
            return true;
         case 6002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onP2PDisconnected(var2.readString());
            var3.writeNoException();
            return true;
         case 8001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var61 = var2.readInt();
            DataHolder var62 = null;
            if(var61 != 0) {
               var62 = DataHolder.CREATOR.method_4283(var2);
            }

            this.E(var62);
            var3.writeNoException();
            return true;
         case 8002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var59 = var2.readInt();
            Bundle var60;
            if(var2.readInt() != 0) {
               var60 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var60 = null;
            }

            this.b(var59, var60);
            var3.writeNoException();
            return true;
         case 8003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var57 = var2.readInt();
            DataHolder var58 = null;
            if(var57 != 0) {
               var58 = DataHolder.CREATOR.method_4283(var2);
            }

            this.p(var58);
            var3.writeNoException();
            return true;
         case 8004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var55 = var2.readInt();
            DataHolder var56 = null;
            if(var55 != 0) {
               var56 = DataHolder.CREATOR.method_4283(var2);
            }

            this.q(var56);
            var3.writeNoException();
            return true;
         case 8005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var53 = var2.readInt();
            DataHolder var54 = null;
            if(var53 != 0) {
               var54 = DataHolder.CREATOR.method_4283(var2);
            }

            this.r(var54);
            var3.writeNoException();
            return true;
         case 8006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var51 = var2.readInt();
            DataHolder var52 = null;
            if(var51 != 0) {
               var52 = DataHolder.CREATOR.method_4283(var2);
            }

            this.s(var52);
            var3.writeNoException();
            return true;
         case 8007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.f(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 8008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var49 = var2.readInt();
            DataHolder var50 = null;
            if(var49 != 0) {
               var50 = DataHolder.CREATOR.method_4283(var2);
            }

            this.t(var50);
            var3.writeNoException();
            return true;
         case 8009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onTurnBasedMatchRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 8010:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onInvitationRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var47 = var2.readInt();
            DataHolder var48 = null;
            if(var47 != 0) {
               var48 = DataHolder.CREATOR.method_4283(var2);
            }

            this.l(var48);
            var3.writeNoException();
            return true;
         case 10001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var45 = var2.readInt();
            DataHolder var46 = null;
            if(var45 != 0) {
               var46 = DataHolder.CREATOR.method_4283(var2);
            }

            this.o(var46);
            var3.writeNoException();
            return true;
         case 10002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onRequestRemoved(var2.readString());
            var3.writeNoException();
            return true;
         case 10003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var43 = var2.readInt();
            DataHolder var44 = null;
            if(var43 != 0) {
               var44 = DataHolder.CREATOR.method_4283(var2);
            }

            this.F(var44);
            var3.writeNoException();
            return true;
         case 10004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var41 = var2.readInt();
            DataHolder var42 = null;
            if(var41 != 0) {
               var42 = DataHolder.CREATOR.method_4283(var2);
            }

            this.G(var42);
            var3.writeNoException();
            return true;
         case 10005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var39 = var2.readInt();
            Bundle var40;
            if(var2.readInt() != 0) {
               var40 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var40 = null;
            }

            this.c(var39, var40);
            var3.writeNoException();
            return true;
         case 10006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var37 = var2.readInt();
            DataHolder var38 = null;
            if(var37 != 0) {
               var38 = DataHolder.CREATOR.method_4283(var2);
            }

            this.H(var38);
            var3.writeNoException();
            return true;
         case 11001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var35 = var2.readInt();
            Bundle var36;
            if(var2.readInt() != 0) {
               var36 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var36 = null;
            }

            this.d(var35, var36);
            var3.writeNoException();
            return true;
         case 12001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var33 = var2.readInt();
            DataHolder var34 = null;
            if(var33 != 0) {
               var34 = DataHolder.CREATOR.method_4283(var2);
            }

            this.I(var34);
            var3.writeNoException();
            return true;
         case 12003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var21 = var2.readInt();
            Bundle var22;
            if(var2.readInt() != 0) {
               var22 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var22 = null;
            }

            this.e(var21, var22);
            var3.writeNoException();
            return true;
         case 12004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            DataHolder var31;
            if(var2.readInt() != 0) {
               var31 = DataHolder.CREATOR.method_4283(var2);
            } else {
               var31 = null;
            }

            Contents var32;
            if(var2.readInt() != 0) {
               var32 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var32 = null;
            }

            this.a(var31, var32);
            var3.writeNoException();
            return true;
         case 12005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var23 = var2.readInt();
            DataHolder var24 = null;
            if(var23 != 0) {
               var24 = DataHolder.CREATOR.method_4283(var2);
            }

            this.J(var24);
            var3.writeNoException();
            return true;
         case 12006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var15 = var2.readInt();
            DataHolder var16 = null;
            if(var15 != 0) {
               var16 = DataHolder.CREATOR.method_4283(var2);
            }

            this.K(var16);
            var3.writeNoException();
            return true;
         case 12007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var13 = var2.readInt();
            DataHolder var14 = null;
            if(var13 != 0) {
               var14 = DataHolder.CREATOR.method_4283(var2);
            }

            this.L(var14);
            var3.writeNoException();
            return true;
         case 12008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var7 = var2.readInt();
            DataHolder var8 = null;
            if(var7 != 0) {
               var8 = DataHolder.CREATOR.method_4283(var2);
            }

            this.O(var8);
            var3.writeNoException();
            return true;
         case 12011:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var17 = var2.readInt();
            DataHolder var18 = null;
            if(var17 != 0) {
               var18 = DataHolder.CREATOR.method_4283(var2);
            }

            this.d(var18);
            var3.writeNoException();
            return true;
         case 12012:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.g(var2.readInt(), var2.readString());
            var3.writeNoException();
            return true;
         case 12013:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var19 = var2.readInt();
            DataHolder var20 = null;
            if(var19 != 0) {
               var20 = DataHolder.CREATOR.method_4283(var2);
            }

            this.P(var20);
            var3.writeNoException();
            return true;
         case 12014:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var11 = var2.readInt();
            DataHolder var12 = null;
            if(var11 != 0) {
               var12 = DataHolder.CREATOR.method_4283(var2);
            }

            this.M(var12);
            var3.writeNoException();
            return true;
         case 12015:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var5 = var2.readInt();
            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.f(var5, var6);
            var3.writeNoException();
            return true;
         case 12016:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            int var9 = var2.readInt();
            DataHolder var10 = null;
            if(var9 != 0) {
               var10 = DataHolder.CREATOR.method_4283(var2);
            }

            this.N(var10);
            var3.writeNoException();
            return true;
         case 12017:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            DataHolder var25;
            if(var2.readInt() != 0) {
               var25 = DataHolder.CREATOR.method_4283(var2);
            } else {
               var25 = null;
            }

            String var26 = var2.readString();
            Contents var27;
            if(var2.readInt() != 0) {
               var27 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var27 = null;
            }

            Contents var28;
            if(var2.readInt() != 0) {
               var28 = (Contents)Contents.CREATOR.createFromParcel(var2);
            } else {
               var28 = null;
            }

            int var29 = var2.readInt();
            Contents var30 = null;
            if(var29 != 0) {
               var30 = (Contents)Contents.CREATOR.createFromParcel(var2);
            }

            this.a(var25, var26, var27, var28, var30);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesCallbacks {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3983;

      Proxy(IBinder var1) {
         this.field_3983 = var1;
      }

      // $FF: renamed from: A (com.google.android.gms.common.data.DataHolder) void
      public void method_256(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: B (com.google.android.gms.common.data.DataHolder) void
      public void method_257(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: C (com.google.android.gms.common.data.DataHolder) void
      public void method_258(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: D (com.google.android.gms.common.data.DataHolder) void
      public void method_259(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: E (com.google.android.gms.common.data.DataHolder) void
      public void method_260(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: F (com.google.android.gms.common.data.DataHolder) void
      public void method_261(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: G (com.google.android.gms.common.data.DataHolder) void
      public void method_262(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: H (com.google.android.gms.common.data.DataHolder) void
      public void method_263(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: I (com.google.android.gms.common.data.DataHolder) void
      public void method_264(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: J (com.google.android.gms.common.data.DataHolder) void
      public void method_265(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: K (com.google.android.gms.common.data.DataHolder) void
      public void method_266(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: L (com.google.android.gms.common.data.DataHolder) void
      public void method_267(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: M (com.google.android.gms.common.data.DataHolder) void
      public void method_268(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: N (com.google.android.gms.common.data.DataHolder) void
      public void method_269(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: O (com.google.android.gms.common.data.DataHolder) void
      public void method_270(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: P (com.google.android.gms.common.data.DataHolder) void
      public void method_271(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (int, java.lang.String, boolean) void
      public void method_272(int param1, String param2, boolean param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder) void
      public void method_273(DataHolder param1, DataHolder param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents) void
      public void method_274(DataHolder param1, Contents param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents) void
      public void method_275(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_276(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3983;
      }

      // $FF: renamed from: b (int, int, java.lang.String) void
      public void method_277(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.field_3983.transact(5033, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      // $FF: renamed from: b (int, android.os.Bundle) void
      public void method_278(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_279(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (int, android.os.Bundle) void
      public void method_280(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder) void
      public void method_281(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_282(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: cd (int) void
      public void method_283(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeInt(var1);
            this.field_3983.transact(5036, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: ce (int) void
      public void method_284(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeInt(var1);
            this.field_3983.transact(5040, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: d (int, android.os.Bundle) void
      public void method_285(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (int, java.lang.String) void
      public void method_286(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.field_3983.transact(5001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder) void
      public void method_287(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_288(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: dO () void
      public void method_289() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            this.field_3983.transact(5016, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      // $FF: renamed from: e (int, android.os.Bundle) void
      public void method_290(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (int, java.lang.String) void
      public void method_291(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.field_3983.transact(5003, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder) void
      public void method_292(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_293(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (int, android.os.Bundle) void
      public void method_294(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (int, java.lang.String) void
      public void method_295(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.field_3983.transact(8007, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder) void
      public void method_296(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_297(DataHolder param1, String[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (int, java.lang.String) void
      public void method_298(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.field_3983.transact(12012, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
      public void method_299(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder) void
      public void method_300(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder) void
      public void method_301(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder) void
      public void method_302(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder) void
      public void method_303(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder) void
      public void method_304(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder) void
      public void method_305(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: n (com.google.android.gms.common.data.DataHolder) void
      public void method_306(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: o (com.google.android.gms.common.data.DataHolder) void
      public void method_307(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onInvitationRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.field_3983.transact(8010, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onLeftRoom(int var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var3.writeInt(var1);
            var3.writeString(var2);
            this.field_3983.transact(5020, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void onP2PConnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.field_3983.transact(6001, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onP2PDisconnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.field_3983.transact(6002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onRealTimeMessageReceived(RealTimeMessage param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onRequestRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.field_3983.transact(10002, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onTurnBasedMatchRemoved(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
            var2.writeString(var1);
            this.field_3983.transact(8009, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: p (com.google.android.gms.common.data.DataHolder) void
      public void method_308(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: q (com.google.android.gms.common.data.DataHolder) void
      public void method_309(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: r (com.google.android.gms.common.data.DataHolder) void
      public void method_310(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: s (com.google.android.gms.common.data.DataHolder) void
      public void method_311(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: t (com.google.android.gms.common.data.DataHolder) void
      public void method_312(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: u (com.google.android.gms.common.data.DataHolder) void
      public void method_313(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: v (com.google.android.gms.common.data.DataHolder) void
      public void method_314(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: w (com.google.android.gms.common.data.DataHolder) void
      public void method_315(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: x (com.google.android.gms.common.data.DataHolder) void
      public void method_316(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: y (com.google.android.gms.common.data.DataHolder) void
      public void method_317(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: z (com.google.android.gms.common.data.DataHolder) void
      public void method_318(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
