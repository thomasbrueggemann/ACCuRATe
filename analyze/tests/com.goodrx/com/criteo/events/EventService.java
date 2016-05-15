package com.criteo.events;

import android.content.Context;
import com.criteo.events.AppLaunchEvent;
import com.criteo.events.DeviceInfo;
import com.criteo.events.EventQueue;
import com.criteo.events.EventQueueItem;
import com.criteo.events.HomeViewEvent;
import com.criteo.events.JSONEventSerializer;
import com.criteo.events.ProductViewEvent;
import com.criteo.events.TransactionConfirmationEvent;
import java.util.Date;

public class EventService {
   static Context context;
   static String sharedPrefs = "CriteoTracker";
   private String country;
   private String customerId;
   private String email;
   private EventQueue eventQueue = new EventQueue(this);
   private String language;

   public EventService(Context var1) {
      context = var1;
      this.country = this.getDefaultCountry();
      this.language = this.getDefaultLanguage();
   }

   private String getDefaultCountry() {
      return DeviceInfo.getCountry();
   }

   private String getDefaultLanguage() {
      return DeviceInfo.getLanguage();
   }

   public String getCountry() {
      return this.country;
   }

   public String getCustomerId() {
      return this.customerId;
   }

   public String getEmail() {
      return this.email;
   }

   public String getLanguage() {
      return this.language;
   }

   public void send(AppLaunchEvent var1) {
      var1.setTimestamp(new Date());
      this.eventQueue.add(new EventQueueItem(var1, JSONEventSerializer.serializeToJSON(var1)));
      this.eventQueue.sendAll();
   }

   public void send(HomeViewEvent var1) {
      var1.setTimestamp(new Date());
      this.eventQueue.add(new EventQueueItem(var1, JSONEventSerializer.serializeToJSON(var1)));
      this.eventQueue.sendAll();
   }

   public void send(ProductViewEvent var1) {
      var1.setTimestamp(new Date());
      this.eventQueue.add(new EventQueueItem(var1, JSONEventSerializer.serializeToJSON(var1)));
      this.eventQueue.sendAll();
   }

   public void send(TransactionConfirmationEvent var1) {
      var1.setTimestamp(new Date());
      this.eventQueue.add(new EventQueueItem(var1, JSONEventSerializer.serializeToJSON(var1)));
      this.eventQueue.sendAll();
   }
}
