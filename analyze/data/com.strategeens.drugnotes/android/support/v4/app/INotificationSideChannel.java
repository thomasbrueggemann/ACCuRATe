package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface INotificationSideChannel extends IInterface {
   void cancel(String var1, int var2, String var3) throws RemoteException;

   void cancelAll(String var1) throws RemoteException;

   void notify(String var1, int var2, String var3, Notification var4) throws RemoteException;

   public abstract static class Stub extends Binder implements INotificationSideChannel {
      private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
      static final int TRANSACTION_cancel = 2;
      static final int TRANSACTION_cancelAll = 3;
      static final int TRANSACTION_notify = 1;

      public Stub() {
         this.attachInterface(this, "android.support.v4.app.INotificationSideChannel");
      }

      public static INotificationSideChannel asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            return (INotificationSideChannel)(var1 != null && var1 instanceof INotificationSideChannel?(INotificationSideChannel)var1:new INotificationSideChannel.Proxy(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
            String var5 = var2.readString();
            int var6 = var2.readInt();
            String var7 = var2.readString();
            Notification var8;
            if(var2.readInt() != 0) {
               var8 = (Notification)Notification.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.notify(var5, var6, var7, var8);
            return true;
         case 2:
            var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
            this.cancel(var2.readString(), var2.readInt(), var2.readString());
            return true;
         case 3:
            var2.enforceInterface("android.support.v4.app.INotificationSideChannel");
            this.cancelAll(var2.readString());
            return true;
         case 1598968902:
            var3.writeString("android.support.v4.app.INotificationSideChannel");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements INotificationSideChannel {
      private IBinder mRemote;

      Proxy(IBinder var1) {
         this.mRemote = var1;
      }

      public IBinder asBinder() {
         return this.mRemote;
      }

      public void cancel(String var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            var4.writeString(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.mRemote.transact(2, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      public void cancelAll(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            var2.writeString(var1);
            this.mRemote.transact(3, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public String getInterfaceDescriptor() {
         return "android.support.v4.app.INotificationSideChannel";
      }

      public void notify(String param1, int param2, String param3, Notification param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
