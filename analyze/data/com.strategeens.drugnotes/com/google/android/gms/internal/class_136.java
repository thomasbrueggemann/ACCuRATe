package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

// $FF: renamed from: com.google.android.gms.internal.mc
public interface class_136 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult) void
   void method_738(SessionStopResult var1) throws RemoteException;

   public abstract static class class_1413 extends Binder implements class_136 {
      public class_1413() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
      }

      // $FF: renamed from: ay (android.os.IBinder) com.google.android.gms.internal.mc
      public static class_136 method_5280(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return (class_136)(var1 != null && var1 instanceof class_136?(class_136)var1:new class_136.class_1414(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            SessionStopResult var5;
            if(var2.readInt() != 0) {
               var5 = (SessionStopResult)SessionStopResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1414 implements class_136 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4279;

      class_1414(IBinder var1) {
         this.field_4279 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult) void
      public void method_738(SessionStopResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4279;
      }
   }
}
