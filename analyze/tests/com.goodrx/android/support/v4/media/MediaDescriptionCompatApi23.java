package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.v4.media.MediaDescriptionCompatApi21;

class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
   public static Uri getMediaUri(Object var0) {
      return ((MediaDescription)var0).getMediaUri();
   }

   static class Builder extends MediaDescriptionCompatApi21.Builder {
      public static void setMediaUri(Object var0, Uri var1) {
         ((android.media.MediaDescription.Builder)var0).setMediaUri(var1);
      }
   }
}
