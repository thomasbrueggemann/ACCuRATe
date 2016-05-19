package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaBrowserCompatApi21 {
   static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

   public static void connect(Object var0) {
      ((MediaBrowser)var0).connect();
   }

   public static Object createBrowser(Context var0, ComponentName var1, Object var2, Bundle var3) {
      return new MediaBrowser(var0, var1, (android.media.browse.MediaBrowser.ConnectionCallback)var2, var3);
   }

   public static Object createConnectionCallback(MediaBrowserCompatApi21.ConnectionCallback var0) {
      return new MediaBrowserCompatApi21.ConnectionCallbackProxy(var0);
   }

   public static Object createSubscriptionCallback(MediaBrowserCompatApi21.SubscriptionCallback var0) {
      return new MediaBrowserCompatApi21.SubscriptionCallbackProxy(var0);
   }

   public static void disconnect(Object var0) {
      ((MediaBrowser)var0).disconnect();
   }

   public static Bundle getExtras(Object var0) {
      return ((MediaBrowser)var0).getExtras();
   }

   public static String getRoot(Object var0) {
      return ((MediaBrowser)var0).getRoot();
   }

   public static ComponentName getServiceComponent(Object var0) {
      return ((MediaBrowser)var0).getServiceComponent();
   }

   public static Object getSessionToken(Object var0) {
      return ((MediaBrowser)var0).getSessionToken();
   }

   public static boolean isConnected(Object var0) {
      return ((MediaBrowser)var0).isConnected();
   }

   public static void subscribe(Object var0, String var1, Object var2) {
      ((MediaBrowser)var0).subscribe(var1, (android.media.browse.MediaBrowser.SubscriptionCallback)var2);
   }

   public static void unsubscribe(Object var0, String var1) {
      ((MediaBrowser)var0).unsubscribe(var1);
   }

   interface ConnectionCallback {
      void onConnected();

      void onConnectionFailed();

      void onConnectionSuspended();
   }

   static class ConnectionCallbackProxy<T extends MediaBrowserCompatApi21.ConnectionCallback> extends android.media.browse.MediaBrowser.ConnectionCallback {
      protected final T mConnectionCallback;

      public ConnectionCallbackProxy(T var1) {
         this.mConnectionCallback = var1;
      }

      public void onConnected() {
         this.mConnectionCallback.onConnected();
      }

      public void onConnectionFailed() {
         this.mConnectionCallback.onConnectionFailed();
      }

      public void onConnectionSuspended() {
         this.mConnectionCallback.onConnectionSuspended();
      }
   }

   interface SubscriptionCallback {
      void onChildrenLoaded(@NonNull String var1, List<Parcel> var2);

      void onError(@NonNull String var1);
   }

   static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21.SubscriptionCallback> extends android.media.browse.MediaBrowser.SubscriptionCallback {
      protected final T mSubscriptionCallback;

      public SubscriptionCallbackProxy(T var1) {
         this.mSubscriptionCallback = var1;
      }

      public void onChildrenLoaded(@NonNull String var1, List<MediaItem> var2) {
         if(var2 != null && var2.size() == 1 && ((MediaItem)var2.get(0)).getMediaId().equals("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM")) {
            var2 = null;
         }

         ArrayList var3 = null;
         if(var2 != null) {
            var3 = new ArrayList();
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               MediaItem var5 = (MediaItem)var4.next();
               Parcel var6 = Parcel.obtain();
               var5.writeToParcel(var6, 0);
               var3.add(var6);
            }
         }

         this.mSubscriptionCallback.onChildrenLoaded(var1, var3);
      }

      public void onError(@NonNull String var1) {
         this.mSubscriptionCallback.onError(var1);
      }
   }
}
