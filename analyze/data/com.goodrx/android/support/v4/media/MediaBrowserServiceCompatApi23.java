package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserServiceCompatApi21;
import android.util.Log;

class MediaBrowserServiceCompatApi23 extends MediaBrowserServiceCompatApi21 {
   private static final String TAG = "MediaBrowserServiceCompatApi21";

   public static Object createService() {
      return new MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptorApi23();
   }

   public static void onCreate(Object var0, MediaBrowserServiceCompatApi23.ServiceImplApi23 var1) {
      ((MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptorApi23)var0).onCreate(var1);
   }

   public interface ItemCallback {
      void onItemLoaded(int var1, Bundle var2, Parcel var3);
   }

   static class MediaBrowserServiceAdaptorApi23 extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptorApi21 {
      public void onCreate(MediaBrowserServiceCompatApi23.ServiceImplApi23 var1) {
         this.mBinder = new MediaBrowserServiceCompatApi23.ServiceBinderProxyApi23(var1);
      }
   }

   private static class ServiceBinderProxyApi23 extends MediaBrowserServiceCompatApi21.ServiceBinderProxyApi21 {
      MediaBrowserServiceCompatApi23.ServiceImplApi23 mServiceImpl;

      ServiceBinderProxyApi23(MediaBrowserServiceCompatApi23.ServiceImplApi23 var1) {
         super(var1);
         this.mServiceImpl = var1;
      }

      public void getMediaItem(String var1, final ResultReceiver var2) {
         final String var5;
         label14: {
            Object var3;
            try {
               var5 = (String)MediaBrowserService.class.getDeclaredField("KEY_MEDIA_ITEM").get((Object)null);
               break label14;
            } catch (IllegalAccessException var6) {
               var3 = var6;
            } catch (NoSuchFieldException var7) {
               var3 = var7;
            }

            Log.i("MediaBrowserServiceCompatApi21", "Failed to get KEY_MEDIA_ITEM via reflection", (Throwable)var3);
            return;
         }

         this.mServiceImpl.getMediaItem(var1, new MediaBrowserServiceCompatApi23.ItemCallback() {
            public void onItemLoaded(int var1, Bundle var2x, Parcel var3) {
               if(var3 != null) {
                  var3.setDataPosition(0);
                  MediaItem var4 = (MediaItem)MediaItem.CREATOR.createFromParcel(var3);
                  var2x.putParcelable(var5, var4);
                  var3.recycle();
               }

               var2.send(var1, var2x);
            }
         });
      }
   }

   public interface ServiceImplApi23 extends MediaBrowserServiceCompatApi21.ServiceImplApi21 {
      void getMediaItem(String var1, MediaBrowserServiceCompatApi23.ItemCallback var2);
   }
}
