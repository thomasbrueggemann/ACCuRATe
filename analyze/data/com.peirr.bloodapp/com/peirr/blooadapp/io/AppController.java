package com.peirr.blooadapp.io;

import android.app.Application;

public class AppController extends Application {
   public static final String END_POINT = "http://indigostorage.co.za/bloodapp/index.php/firehose/";
   public static final String TAG = AppController.class.getSimpleName();

   public void onCreate() {
      super.onCreate();
   }
}
