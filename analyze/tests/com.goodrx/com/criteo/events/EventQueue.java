package com.criteo.events;

import com.criteo.events.CRTOLog;
import com.criteo.events.Event;
import com.criteo.events.EventQueueItem;
import com.criteo.events.EventService;
import com.criteo.events.PostInBackground;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class EventQueue {
   private static String address = "https://widget.criteo.com";
   static URL url;
   final String criteoEnvironmentCheck = "CRITEO_WIDGET_BASEURL";
   private EventService eventService;
   private Set<EventQueueItem> inFlightEvents = Collections.newSetFromMap(new ConcurrentHashMap());
   private ConcurrentLinkedQueue<EventQueueItem> queue = new ConcurrentLinkedQueue();

   EventQueue(EventService var1) {
      String var2 = System.getenv("CRITEO_WIDGET_BASEURL");
      if(var2 != null) {
         address = var2 + ":8050";
      }

      address = address.concat("/m/event/");
      this.eventService = var1;

      try {
         url = new URL(address);
      } catch (Exception var4) {
         CRTOLog.method_474("Error creating Criteo url", var4);
      }
   }

   private boolean eventExpired(Event var1) {
      long var4;
      int var2 = (var4 = (new Date()).getTime() - var1.getTimestamp().getTime() - 3600000L) == 0L?0:(var4 < 0L?-1:1);
      boolean var3 = false;
      if(var2 > 0) {
         var3 = true;
      }

      return var3;
   }

   void add(EventQueueItem var1) {
      this.queue.add(var1);
      if(this.queue.size() > 15) {
         EventQueueItem var6 = (EventQueueItem)this.queue.remove();
         CRTOLog.method_475("Max queue length reached, dropping oldest event: " + var6.getEvent().getClass());
      }

      Iterator var3 = this.queue.iterator();

      while(var3.hasNext()) {
         EventQueueItem var4 = (EventQueueItem)var3.next();
         if(this.eventExpired(var4.getEvent())) {
            this.queue.remove(var4);
         }
      }

   }

   EventService getEventService() {
      return this.eventService;
   }

   ArrayList<EventQueueItem> getEventsToSend() {
      // $FF: Couldn't be decompiled
   }

   boolean isInFlightEmtpy() {
      return this.inFlightEvents.isEmpty();
   }

   void resolveResponse(String var1, int var2, boolean var3, ArrayList<EventQueueItem> var4) {
      if(!var1.isEmpty() && var1.contains("errors")) {
         CRTOLog.method_476("Response code : " + var2 + " Body: " + var1);
      }

      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         EventQueueItem var9 = (EventQueueItem)var5.next();
         this.inFlightEvents.remove(var9);
      }

      if(!var3) {
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            EventQueueItem var7 = (EventQueueItem)var6.next();
            this.queue.remove(var7);
         }

         this.sendAll();
      }

   }

   void sendAll() {
      ArrayList var1 = this.getEventsToSend();
      if(!var1.isEmpty()) {
         (new Thread(new PostInBackground(this, var1, url))).start();
      }

   }
}
