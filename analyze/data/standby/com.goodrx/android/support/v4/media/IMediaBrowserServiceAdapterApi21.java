package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21;

class IMediaBrowserServiceAdapterApi21 {
   abstract static class Stub extends Binder implements IInterface {
      private static final String DESCRIPTOR = "android.service.media.IMediaBrowserService";
      private static final int TRANSACTION_addSubscription = 3;
      private static final int TRANSACTION_connect = 1;
      private static final int TRANSACTION_disconnect = 2;
      private static final int TRANSACTION_getMediaItem = 5;
      private static final int TRANSACTION_removeSubscription = 4;

      public Stub() {
         this.attachInterface(this, "android.service.media.IMediaBrowserService");
      }

      public abstract void addSubscription(String var1, Object var2);

      public IBinder asBinder() {
         return this;
      }

      public abstract void connect(String var1, Bundle var2, Object var3);

      public abstract void disconnect(Object var1);

      public abstract void getMediaItem(String var1, ResultReceiver var2);

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("android.service.media.IMediaBrowserService");
            String var7 = var2.readString();
            Bundle var8;
            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.connect(var7, var8, IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("android.service.media.IMediaBrowserService");
            this.disconnect(IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("android.service.media.IMediaBrowserService");
            this.addSubscription(var2.readString(), IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(var2.readStrongBinder()));
            return true;
         case 4:
            var2.enforceInterface("android.service.media.IMediaBrowserService");
            this.removeSubscription(var2.readString(), IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(var2.readStrongBinder()));
            return true;
         case 5:
            var2.enforceInterface("android.service.media.IMediaBrowserService");
            String var5 = var2.readString();
            ResultReceiver var6;
            if(var2.readInt() != 0) {
               var6 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.getMediaItem(var5, var6);
            return true;
         case 1598968902:
            var3.writeString("android.service.media.IMediaBrowserService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }

      public abstract void removeSubscription(String var1, Object var2);
   }
}
