package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompatHoneycomb;
import android.support.v4.app.ActivityCompatJB;
import android.support.v4.content.ContextCompat;

public class ActivityCompat extends ContextCompat {
   public static void finishAffinity(Activity var0) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.finishAffinity(var0);
      } else {
         var0.finish();
      }
   }

   public static boolean invalidateOptionsMenu(Activity var0) {
      if(VERSION.SDK_INT >= 11) {
         ActivityCompatHoneycomb.invalidateOptionsMenu(var0);
         return true;
      } else {
         return false;
      }
   }

   public static void startActivity(Activity var0, Intent var1, Bundle var2) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivity(var0, var1, var2);
      } else {
         var0.startActivity(var1);
      }
   }

   public static void startActivityForResult(Activity var0, Intent var1, int var2, Bundle var3) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivityForResult(var0, var1, var2, var3);
      } else {
         var0.startActivityForResult(var1, var2);
      }
   }
}
