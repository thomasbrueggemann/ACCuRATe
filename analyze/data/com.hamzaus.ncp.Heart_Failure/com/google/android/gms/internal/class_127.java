package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_123;
import com.google.android.gms.internal.class_124;
import com.google.android.gms.internal.class_610;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.class_716;

// $FF: renamed from: com.google.android.gms.internal.ln
public interface class_127 extends IInterface {
   // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_686(Bundle var1, class_124 var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.internal.lh, android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_687(class_610 var1, Bundle var2, class_124 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_688(FullWalletRequest var1, Bundle var2, class_124 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.lp) void
   void method_689(MaskedWalletRequest var1, Bundle var2, class_123 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_690(MaskedWalletRequest var1, Bundle var2, class_124 var3) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
   void method_691(NotifyTransactionStatusRequest var1, Bundle var2) throws RemoteException;

   // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_692(class_716 var1, Bundle var2, class_124 var3) throws RemoteException;

   // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.lq) void
   void method_693(String var1, String var2, Bundle var3, class_124 var4) throws RemoteException;

   // $FF: renamed from: o (android.os.Bundle) void
   void method_694(Bundle var1) throws RemoteException;

   public abstract static class class_1083 extends Binder implements class_127 {
      // $FF: renamed from: bq (android.os.IBinder) com.google.android.gms.internal.ln
      public static class_127 method_4547(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (class_127)(var1 != null && var1 instanceof class_127?(class_127)var1:new class_127.class_1084(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            MaskedWalletRequest var20;
            if(var2.readInt() != 0) {
               var20 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var20 = null;
            }

            Bundle var21;
            if(var2.readInt() != 0) {
               var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var21 = null;
            }

            this.a(var20, var21, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            FullWalletRequest var18;
            if(var2.readInt() != 0) {
               var18 = (FullWalletRequest)FullWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var18 = null;
            }

            Bundle var19;
            if(var2.readInt() != 0) {
               var19 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var19 = null;
            }

            this.a(var18, var19, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            String var15 = var2.readString();
            String var16 = var2.readString();
            Bundle var17;
            if(var2.readInt() != 0) {
               var17 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            this.a(var15, var16, var17, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            NotifyTransactionStatusRequest var13;
            if(var2.readInt() != 0) {
               var13 = (NotifyTransactionStatusRequest)NotifyTransactionStatusRequest.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            Bundle var14;
            if(var2.readInt() != 0) {
               var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            this.a(var13, var14);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            Bundle var12;
            if(var2.readInt() != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.a(var12, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            class_716 var10;
            if(var2.readInt() != 0) {
               var10 = (class_716)class_716.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            Bundle var11;
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.a(var10, var11, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            MaskedWalletRequest var8;
            if(var2.readInt() != 0) {
               var8 = (MaskedWalletRequest)MaskedWalletRequest.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            Bundle var9;
            if(var2.readInt() != 0) {
               var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.a(var8, var9, class_123.class_985.method_2793(var2.readStrongBinder()));
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            class_610 var6;
            if(var2.readInt() != 0) {
               var6 = (class_610)class_610.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.a(var6, var7, class_124.class_823.method_1818(var2.readStrongBinder()));
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
            Bundle var5;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.o(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wallet.internal.IOwService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1084 implements class_127 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3125;

      class_1084(IBinder var1) {
         this.field_3125 = var1;
      }

      // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_686(Bundle param1, class_124 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.lh, android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_687(class_610 param1, Bundle param2, class_124 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_688(FullWalletRequest param1, Bundle param2, class_124 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.lp) void
      public void method_689(MaskedWalletRequest param1, Bundle param2, class_123 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_690(MaskedWalletRequest param1, Bundle param2, class_124 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest, android.os.Bundle) void
      public void method_691(NotifyTransactionStatusRequest param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.wallet.d, android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_692(class_716 param1, Bundle param2, class_124 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, java.lang.String, android.os.Bundle, com.google.android.gms.internal.lq) void
      public void method_693(String param1, String param2, Bundle param3, class_124 param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3125;
      }

      // $FF: renamed from: o (android.os.Bundle) void
      public void method_694(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
