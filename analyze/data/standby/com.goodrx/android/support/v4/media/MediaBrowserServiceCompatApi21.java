package android.support.v4.media;

import android.content.Intent;
import android.media.MediaDescription.Builder;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.support.v4.media.IMediaBrowserServiceAdapterApi21;
import android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21;
import android.support.v4.media.ParceledListSliceAdapterApi21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompatApi21 {
   public static Object createService() {
      return new MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21();
   }

   public static IBinder onBind(Object var0, Intent var1) {
      return ((MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21)var0).onBind(var1);
   }

   public static void onCreate(Object var0, MediaBrowserServiceCompatApi21.ServiceImplApi21 var1) {
      ((MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21)var0).onCreate(var1);
   }

   static class MediaBrowserServiceAdaptorApi21 {
      MediaBrowserServiceCompatApi21.ServiceBinderProxyApi21 mBinder;

      public IBinder onBind(Intent var1) {
         return "android.media.browse.MediaBrowserService".equals(var1.getAction())?this.mBinder:null;
      }

      public void onCreate(MediaBrowserServiceCompatApi21.ServiceImplApi21 var1) {
         this.mBinder = new MediaBrowserServiceCompatApi21.ServiceBinderProxyApi21(var1);
      }
   }

   static class ServiceBinderProxyApi21 extends IMediaBrowserServiceAdapterApi21.Stub {
      final MediaBrowserServiceCompatApi21.ServiceImplApi21 mServiceImpl;

      ServiceBinderProxyApi21(MediaBrowserServiceCompatApi21.ServiceImplApi21 var1) {
         this.mServiceImpl = var1;
      }

      public void addSubscription(String var1, Object var2) {
         this.mServiceImpl.addSubscription(var1, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(var2));
      }

      public void connect(String var1, Bundle var2, Object var3) {
         this.mServiceImpl.connect(var1, var2, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(var3));
      }

      public void disconnect(Object var1) {
         this.mServiceImpl.disconnect(new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(var1));
      }

      public void getMediaItem(String var1, ResultReceiver var2) {
      }

      public void removeSubscription(String var1, Object var2) {
         this.mServiceImpl.removeSubscription(var1, new MediaBrowserServiceCompatApi21.ServiceCallbacksApi21(var2));
      }
   }

   public interface ServiceCallbacks {
      IBinder asBinder();

      void onConnect(String var1, Object var2, Bundle var3) throws RemoteException;

      void onConnectFailed() throws RemoteException;

      void onLoadChildren(String var1, List<Parcel> var2) throws RemoteException;
   }

   public static class ServiceCallbacksApi21 implements MediaBrowserServiceCompatApi21.ServiceCallbacks {
      private static Object sNullParceledListSliceObj;
      private final IMediaBrowserServiceCallbacksAdapterApi21 mCallbacks;

      static {
         MediaItem var0 = new MediaItem((new Builder()).setMediaId("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM").build(), 0);
         ArrayList var1 = new ArrayList();
         var1.add(var0);
         sNullParceledListSliceObj = ParceledListSliceAdapterApi21.newInstance(var1);
      }

      ServiceCallbacksApi21(Object var1) {
         this.mCallbacks = new IMediaBrowserServiceCallbacksAdapterApi21(var1);
      }

      public IBinder asBinder() {
         return this.mCallbacks.asBinder();
      }

      public void onConnect(String var1, Object var2, Bundle var3) throws RemoteException {
         this.mCallbacks.onConnect(var1, var2, var3);
      }

      public void onConnectFailed() throws RemoteException {
         this.mCallbacks.onConnectFailed();
      }

      public void onLoadChildren(String var1, List<Parcel> var2) throws RemoteException {
         ArrayList var3 = null;
         if(var2 != null) {
            var3 = new ArrayList();
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               Parcel var6 = (Parcel)var4.next();
               var6.setDataPosition(0);
               var3.add(MediaItem.CREATOR.createFromParcel(var6));
               var6.recycle();
            }
         }

         Object var5;
         if(VERSION.SDK_INT > 23) {
            if(var3 == null) {
               var5 = null;
            } else {
               var5 = ParceledListSliceAdapterApi21.newInstance(var3);
            }
         } else if(var3 == null) {
            var5 = sNullParceledListSliceObj;
         } else {
            var5 = ParceledListSliceAdapterApi21.newInstance(var3);
         }

         this.mCallbacks.onLoadChildren(var1, var5);
      }
   }

   public interface ServiceImplApi21 {
      void addSubscription(String var1, MediaBrowserServiceCompatApi21.ServiceCallbacks var2);

      void connect(String var1, Bundle var2, MediaBrowserServiceCompatApi21.ServiceCallbacks var3);

      void disconnect(MediaBrowserServiceCompatApi21.ServiceCallbacks var1);

      void removeSubscription(String var1, MediaBrowserServiceCompatApi21.ServiceCallbacks var2);
   }
}
