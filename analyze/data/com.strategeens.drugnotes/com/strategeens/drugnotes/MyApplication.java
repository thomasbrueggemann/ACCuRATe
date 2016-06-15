package com.strategeens.drugnotes;

import android.app.Application;
import com.google.android.gms.analytics.Tracker;
import java.util.HashMap;

public class MyApplication extends Application {
   public static int GENERAL_TRACKER = 0;
   private static final String PROPERTY_ID = "UA-54435857-1";
   private static final String TAG = "MyApp";
   HashMap<MyApplication.TrackerName, Tracker> mTrackers = new HashMap();

   Tracker getTracker(MyApplication.TrackerName param1) {
      // $FF: Couldn't be decompiled
   }

   public static enum TrackerName {
      APP_TRACKER,
      ECOMMERCE_TRACKER,
      GLOBAL_TRACKER;

      static {
         MyApplication.TrackerName[] var0 = new MyApplication.TrackerName[]{APP_TRACKER, GLOBAL_TRACKER, ECOMMERCE_TRACKER};
      }
   }
}
