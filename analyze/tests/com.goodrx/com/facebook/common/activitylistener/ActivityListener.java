package com.facebook.common.activitylistener;

import android.app.Activity;

public interface ActivityListener {
   void onActivityCreate(Activity var1);

   void onDestroy(Activity var1);

   void onPause(Activity var1);

   void onResume(Activity var1);

   void onStart(Activity var1);

   void onStop(Activity var1);
}
