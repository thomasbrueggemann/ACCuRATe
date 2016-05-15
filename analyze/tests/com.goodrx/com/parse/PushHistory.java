package com.parse;

import com.parse.PLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.json.JSONException;
import org.json.JSONObject;

class PushHistory {
   private static final String TAG = "com.parse.PushHistory";
   private final PriorityQueue<PushHistory.Entry> entries;
   private String lastTime;
   private final int maxHistoryLength;
   private final HashSet<String> pushIds;

   public PushHistory(int var1, JSONObject var2) {
      this.maxHistoryLength = var1;
      this.entries = new PriorityQueue(var1 + 1);
      this.pushIds = new HashSet(var1 + 1);
      this.lastTime = null;
      if(var2 != null) {
         JSONObject var3 = var2.optJSONObject("seen");
         if(var3 != null) {
            Iterator var4 = var3.keys();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               String var6 = var3.optString(var5, (String)null);
               if(var5 != null && var6 != null) {
                  this.tryInsertPush(var5, var6);
               }
            }
         }

         this.setLastReceivedTimestamp(var2.optString("lastTime", (String)null));
      }

   }

   public String getLastReceivedTimestamp() {
      return this.lastTime;
   }

   public void setLastReceivedTimestamp(String var1) {
      this.lastTime = var1;
   }

   public JSONObject toJSON() throws JSONException {
      JSONObject var1 = new JSONObject();
      if(this.entries.size() > 0) {
         JSONObject var2 = new JSONObject();
         Iterator var3 = this.entries.iterator();

         while(var3.hasNext()) {
            PushHistory.Entry var6 = (PushHistory.Entry)var3.next();
            var2.put(var6.pushId, var6.timestamp);
         }

         var1.put("seen", var2);
      }

      var1.putOpt("lastTime", this.lastTime);
      return var1;
   }

   public boolean tryInsertPush(String var1, String var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Can\'t insert null pushId or timestamp into history");
      } else {
         if(this.lastTime == null || var2.compareTo(this.lastTime) > 0) {
            this.lastTime = var2;
         }

         if(this.pushIds.contains(var1)) {
            PLog.method_361("com.parse.PushHistory", "Ignored duplicate push " + var1);
            return false;
         } else {
            this.entries.add(new PushHistory.Entry(var1, var2));
            this.pushIds.add(var1);

            while(this.entries.size() > this.maxHistoryLength) {
               PushHistory.Entry var5 = (PushHistory.Entry)this.entries.remove();
               this.pushIds.remove(var5.pushId);
            }

            return true;
         }
      }
   }

   private static class Entry implements Comparable<PushHistory.Entry> {
      public String pushId;
      public String timestamp;

      public Entry(String var1, String var2) {
         this.pushId = var1;
         this.timestamp = var2;
      }

      public int compareTo(PushHistory.Entry var1) {
         return this.timestamp.compareTo(var1.timestamp);
      }
   }
}
