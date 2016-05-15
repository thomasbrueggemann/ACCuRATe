package com.parse;

import android.content.Intent;
import android.os.IBinder;

interface ProxyService {
   IBinder onBind(Intent var1);

   void onCreate();

   void onDestroy();

   int onStartCommand(Intent var1, int var2, int var3);
}
