package com.parse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.parse.PLog;
import com.parse.ParseWakeLock;

final class ServiceUtils {
   private static final String TAG = "com.parse.ServiceUtils";
   private static final String WAKE_LOCK_EXTRA = "parseWakeLockId";
   private static int wakeLockId = 0;
   private static final SparseArray<ParseWakeLock> wakeLocks = new SparseArray();

   public static void completeWakefulIntent(Intent param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean runIntentInService(Context var0, Intent var1, Class<? extends Service> var2) {
      boolean var3 = false;
      if(var1 != null) {
         if(var2 != null) {
            var1.setClass(var0, var2);
         }

         if(var0.startService(var1) != null) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(!var3) {
            PLog.method_361("com.parse.ServiceUtils", "Could not start the service. Make sure that the XML tag <service android:name=\"" + var2 + "\" /> is in your " + "AndroidManifest.xml as a child of the <application> element.");
         }
      }

      return var3;
   }

   public static boolean runWakefulIntentInService(Context param0, Intent param1, Class<? extends Service> param2) {
      // $FF: Couldn't be decompiled
   }
}
