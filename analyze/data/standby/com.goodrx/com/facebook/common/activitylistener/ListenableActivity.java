package com.facebook.common.activitylistener;

import com.facebook.common.activitylistener.ActivityListener;

public interface ListenableActivity {
   void addActivityListener(ActivityListener var1);

   void removeActivityListener(ActivityListener var1);
}
