package com.criteo.events;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.criteo.events.Event;
import com.criteo.events.EventService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class AppLaunchEvent extends Event {
   private AtomicBoolean firstLaunch = new AtomicBoolean(false);
   private AtomicReference<String> googleReferrer = new AtomicReference();

   public AppLaunchEvent() {
      this.isFirstLaunch();
   }

   private void isFirstLaunch() {
      SharedPreferences var1 = EventService.context.getSharedPreferences(EventService.sharedPrefs, 0);
      if(var1.getInt("first_launch", 0) == 0) {
         this.firstLaunch.set(true);
         Editor var2 = var1.edit();
         var2.putInt("first_launch", 1);
         var2.apply();
      } else {
         this.firstLaunch.set(false);
      }
   }

   boolean getFirstLaunch() {
      return this.firstLaunch.get();
   }

   public String getGoogleReferrer() {
      return (String)this.googleReferrer.get();
   }
}
