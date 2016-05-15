package com.goodrx.utils.locations;

import com.goodrx.utils.locations.LocationUpdateListener;

public interface MyLocationInterface {
   void setLocationUpdateListener(LocationUpdateListener var1);

   void startUpdate();

   void stopUpdate();
}
