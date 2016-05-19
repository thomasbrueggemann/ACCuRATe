package com.criteo.events;

import com.criteo.events.Event;
import org.json.JSONObject;

final class EventQueueItem {
   final Event event;
   final JSONObject serializedEvent;

   EventQueueItem(Event var1, JSONObject var2) {
      this.event = var1;
      this.serializedEvent = var2;
   }

   Event getEvent() {
      return this.event;
   }

   JSONObject getSerializedEvent() {
      return this.serializedEvent;
   }
}
