package com.criteo.events;

import com.criteo.events.ExtraData;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract class Event {
   private ConcurrentHashMap<String, ExtraData> extraDataMap = new ConcurrentHashMap();
   private Date timestamp = new Date();

   Map<String, ExtraData> getExtraDataMap() {
      return new ConcurrentHashMap(this.extraDataMap);
   }

   protected Date getTimestamp() {
      return this.timestamp;
   }

   protected void setTimestamp(Date var1) {
      this.timestamp = var1;
   }
}
