package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzl;

public final class RevocationBoundService extends Service {
   public IBinder onBind(Intent var1) {
      if("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(var1.getAction())) {
         if(Log.isLoggable("RevocationService", 2)) {
            Log.v("RevocationService", "RevocationBoundService handling disconnect.");
         }

         return new zzl(this);
      } else {
         Log.w("RevocationService", "Unknown action sent to RevocationBoundService: " + var1.getAction());
         return null;
      }
   }
}
