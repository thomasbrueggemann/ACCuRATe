package com.comscore.applications;

import java.util.Locale;

public enum EventType {
   AGGREGATE,
   CLOSE,
   HIDDEN,
   KEEPALIVE,
   START,
   VIEW;

   static {
      EventType[] var0 = new EventType[]{START, VIEW, CLOSE, AGGREGATE, HIDDEN, KEEPALIVE};
   }

   public String toString() {
      return this == KEEPALIVE?"keep-alive":super.toString().toLowerCase(new Locale("en", "US"));
   }
}
