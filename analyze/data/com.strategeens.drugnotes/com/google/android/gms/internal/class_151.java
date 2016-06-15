package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.class_135;
import com.google.android.gms.internal.class_138;
import com.google.android.gms.internal.class_776;
import com.google.android.gms.internal.class_778;

// $FF: renamed from: com.google.android.gms.internal.mu
public interface class_151 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.internal.md) void
   void method_812(FitnessSensorServiceRequest var1, class_135 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.mq, com.google.android.gms.internal.lx) void
   void method_813(class_778 var1, class_138 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.ms, com.google.android.gms.internal.md) void
   void method_814(class_776 var1, class_135 var2) throws RemoteException;

   public abstract static class class_1443 extends Binder implements class_151 {
      public class_1443() {
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
            class_778 var10 = null;
            if(var9 != 0) {
               var10 = (class_778)class_778.CREATOR.createFromParcel(var2);
            }

            this.a(var10, class_138.class_1198.method_3071(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            int var7 = var2.readInt();
            FitnessSensorServiceRequest var8 = null;
            if(var7 != 0) {
               var8 = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var8, class_135.class_1365.method_3888(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            int var5 = var2.readInt();
            class_776 var6 = null;
            if(var5 != 0) {
               var6 = (class_776)class_776.CREATOR.createFromParcel(var2);
            }

            this.a(var6, class_135.class_1365.method_3888(var2.readStrongBinder()));
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
