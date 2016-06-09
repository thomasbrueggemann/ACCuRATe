package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.mobileapptracker.MobileAppTracker;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

public class MATEventQueue {
   private static long retryTimeout = 0L;
   private SharedPreferences eventQueue;
   private Semaphore queueAvailable;
   private MobileAppTracker tune;

   public MATEventQueue(Context var1, MobileAppTracker var2) {
      this.eventQueue = var1.getSharedPreferences("mat_queue", 0);
      this.queueAvailable = new Semaphore(1, true);
      this.tune = var2;
   }

   // $FF: synthetic method
   static MobileAppTracker access$1(MATEventQueue var0) {
      return var0.tune;
   }

   // $FF: synthetic method
   static void access$2(long var0) {
      retryTimeout = var0;
   }

   // $FF: synthetic method
   static long access$3() {
      return retryTimeout;
   }

   protected String getKeyFromQueue(String var1) {
      synchronized(this){}

      String var3;
      try {
         var3 = this.eventQueue.getString(var1, (String)null);
      } finally {
         ;
      }

      return var3;
   }

   protected int getQueueSize() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.eventQueue.getInt("queuesize", 0);
      } finally {
         ;
      }

      return var2;
   }

   protected void removeKeyFromQueue(String var1) {
      synchronized(this){}

      try {
         this.setQueueSize(-1 + this.getQueueSize());
         Editor var3 = this.eventQueue.edit();
         var3.remove(var1);
         var3.commit();
      } finally {
         ;
      }

   }

   protected void setQueueItemForKey(JSONObject param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   protected void setQueueSize(int param1) {
      // $FF: Couldn't be decompiled
   }

   protected class Add implements Runnable {
      private String data = null;
      private boolean firstSession = false;
      private String link = null;
      private JSONObject postBody = null;

      protected Add(String var2, String var3, JSONObject var4, boolean var5) {
         this.link = var2;
         this.data = var3;
         this.postBody = var4;
         this.firstSession = var5;
      }

      public void run() {
         try {
            MATEventQueue.this.queueAvailable.acquire();
            JSONObject var4 = new JSONObject();

            try {
               var4.put("link", this.link);
               var4.put("data", this.data);
               var4.put("post_body", this.postBody);
               var4.put("first_session", this.firstSession);
            } catch (JSONException var16) {
               Log.w("MobileAppTracker", "Failed creating event for queueing");
               var16.printStackTrace();
               return;
            }

            int var11 = 1 + MATEventQueue.this.getQueueSize();
            MATEventQueue.this.setQueueSize(var11);
            String var12 = Integer.toString(var11);
            MATEventQueue.this.setQueueItemForKey(var4, var12);
         } catch (InterruptedException var17) {
            Log.w("MobileAppTracker", "Interrupted adding event to queue");
            var17.printStackTrace();
         } finally {
            MATEventQueue.this.queueAvailable.release();
         }
      }
   }

   protected class Dump implements Runnable {
      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
