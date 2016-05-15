package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
   public static KeyEvent handleIntent(MediaSessionCompat var0, Intent var1) {
      if(var0 != null && var1 != null && "android.intent.action.MEDIA_BUTTON".equals(var1.getAction()) && var1.hasExtra("android.intent.extra.KEY_EVENT")) {
         KeyEvent var2 = (KeyEvent)var1.getParcelableExtra("android.intent.extra.KEY_EVENT");
         var0.getController().dispatchMediaButtonEvent(var2);
         return var2;
      } else {
         return null;
      }
   }

   public void onReceive(Context var1, Intent var2) {
      Intent var3 = new Intent("android.intent.action.MEDIA_BUTTON");
      var3.setPackage(var1.getPackageName());
      PackageManager var5 = var1.getPackageManager();
      List var6 = var5.queryIntentServices(var3, 0);
      if(var6.isEmpty()) {
         var3.setAction("android.media.browse.MediaBrowserService");
         var6 = var5.queryIntentServices(var3, 0);
      }

      if(var6.isEmpty()) {
         throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
      } else if(var6.size() != 1) {
         throw new IllegalStateException("Expected 1 Service that handles " + var3.getAction() + ", found " + var6.size());
      } else {
         ResolveInfo var7 = (ResolveInfo)var6.get(0);
         var2.setComponent(new ComponentName(var7.serviceInfo.packageName, var7.serviceInfo.name));
         var1.startService(var2);
      }
   }
}
