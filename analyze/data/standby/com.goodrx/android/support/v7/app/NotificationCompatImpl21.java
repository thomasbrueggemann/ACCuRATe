package android.support.v7.app;

import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;

class NotificationCompatImpl21 {
   public static void addMediaStyle(NotificationBuilderWithBuilderAccessor var0, int[] var1, Object var2) {
      MediaStyle var3 = new MediaStyle(var0.getBuilder());
      if(var1 != null) {
         var3.setShowActionsInCompactView(var1);
      }

      if(var2 != null) {
         var3.setMediaSession((Token)var2);
      }

   }
}
