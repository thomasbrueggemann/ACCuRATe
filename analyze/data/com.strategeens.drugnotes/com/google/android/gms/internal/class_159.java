package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_155;
import com.google.android.gms.internal.class_156;
import com.google.android.gms.internal.class_797;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.class_935;

// $FF: renamed from: com.google.android.gms.internal.qc
public interface class_159 extends IInterface {
   // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_825(Bundle var1, class_156 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.pw, android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_826(class_797 var1, Bundle var2, class_156 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_827(FullWalletRequest var1, Bundle var2, class_156 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.qe) void
   void method_828(MaskedWalletRequest var1, Bundle var2, class_155 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_829(MaskedWalletRequest var1, Bundle var2, class_156 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
   void method_830(NotifyTransactionStatusRequest var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_831(class_935 var1, Bundle var2, class_156 var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.qf) void
   void method_832(String var1, String var2, Bundle var3, class_156 var4) throws RemoteException;

   // $FF: renamed from: r (android.os.Bundle) void
   void method_833(Bundle var1) throws RemoteException;

   // $FF: renamed from: s (android.os.Bundle) void
   void method_834(Bundle var1) throws RemoteException;

   public abstract static class class_1405 extends Binder implements class_159 {
      // $FF: renamed from: bR (android.os.IBinder) com.google.android.gms.internal.qc
      public static class_159 method_3698(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (class_159)(var1 != null && var1 instanceof class_159?(class_159)var1:new class_159.class_1406(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            MaskedWalletRequest var21;
            if(var2.readInt() != 0) {
               var21 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var21 = null;
            }

            Bundle var22;
            if(var2.readInt() != 0) {
               var22 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var22 = null;
            }

            this.a(var21, var22, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            FullWalletRequest var19;
            if(var2.readInt() != 0) {
               var19 = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var19 = null;
            }

            Bundle var20;
            if(var2.readInt() != 0) {
               var20 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            this.a(var19, var20, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            String var16 = var2.readString();
            String var17 = var2.readString();
            Bundle var18;
            if(var2.readInt() != 0) {
               var18 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var18 = null;
            }

            this.a(var16, var17, var18, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            NotifyTransactionStatusRequest var14;
            if(var2.readInt() != 0) {
               var14 = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            Bundle var15;
            if(var2.readInt() != 0) {
               var15 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            this.a(var14, var15);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            Bundle var13;
            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.a(var13, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            class_935 var11;
            if(var2.readInt() != 0) {
               var11 = (class_935)class_935.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            Bundle var12;
            if(var2.readInt() != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.a(var11, var12, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            MaskedWalletRequest var9;
            if(var2.readInt() != 0) {
               var9 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            Bundle var10;
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            this.a(var9, var10, class_155.class_1447.method_4676(var2.readStrongBinder()));
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            class_797 var7;
            if(var2.readInt() != 0) {
               var7 = (class_797)class_797.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            Bundle var8;
            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var7, var8, class_156.class_1449.method_4936(var2.readStrongBinder()));
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.r(var6);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            Bundle var5;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.s(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IOwService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1406 implements class_159 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3889;

      class_1406(IBinder var1) {
         this.field_3889 = var1;
      }

      // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_825(Bundle param1, class_156 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.pw, android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_826(class_797 param1, Bundle param2, class_156 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_827(FullWalletRequest param1, Bundle param2, class_156 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.qe) void
      public void method_828(MaskedWalletRequest param1, Bundle param2, class_155 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_829(MaskedWalletRequest param1, Bundle param2, class_156 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
      public void method_830(NotifyTransactionStatusRequest param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_831(class_935 param1, Bundle param2, class_156 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.qf) void
      public void method_832(String param1, String param2, Bundle param3, class_156 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3889;
      }

      // $FF: renamed from: r (android.os.Bundle) void
      public void method_833(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: s (android.os.Bundle) void
      public void method_834(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
