package com.appsflyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebugLogQueue {
   private static DebugLogQueue ourInstance = new DebugLogQueue();
   List<DebugLogQueue.Item> queue = new ArrayList();

   public static DebugLogQueue getInstance() {
      return ourInstance;
   }

   public void push(String var1) {
      this.queue.add(new DebugLogQueue.Item(var1));
   }

   public static class Item {
      private String msg;
      private long timestamp;

      public Item(String var1) {
         this.msg = var1;
         this.timestamp = (new Date()).getTime();
      }
   }
}
