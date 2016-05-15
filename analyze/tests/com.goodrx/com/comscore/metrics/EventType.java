package com.comscore.metrics;

public enum EventType {
   HIDDEN,
   VIEW;

   static {
      EventType[] var0 = new EventType[]{VIEW, HIDDEN};
   }

   public String toString() {
      return super.toString().toLowerCase();
   }
}
