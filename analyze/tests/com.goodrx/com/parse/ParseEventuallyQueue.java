package com.parse;

import android.util.SparseArray;
import bolts.Task;
import com.parse.EventuallyPin;
import com.parse.ParseObject;
import com.parse.ParseOperationSet;
import com.parse.ParseRESTCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseEventuallyQueue {
   private boolean isConnected;
   private ParseEventuallyQueue.TestHelper testHelper;

   public abstract void clear();

   protected ParseRESTCommand commandFromJSON(JSONObject var1) throws JSONException {
      ParseRESTCommand var3;
      if(ParseRESTCommand.isValidCommandJSONObject(var1)) {
         var3 = ParseRESTCommand.fromJSONObject(var1);
      } else {
         boolean var2 = ParseRESTCommand.isValidOldFormatCommandJSONObject(var1);
         var3 = null;
         if(!var2) {
            throw new JSONException("Failed to load command from JSON.");
         }
      }

      return var3;
   }

   public abstract Task<JSONObject> enqueueEventuallyAsync(ParseRESTCommand var1, ParseObject var2);

   void fakeObjectUpdate() {
      if(this.testHelper != null) {
         this.testHelper.notify(3);
         this.testHelper.notify(1);
         this.testHelper.notify(5);
      }

   }

   public ParseEventuallyQueue.TestHelper getTestHelper() {
      if(this.testHelper == null) {
         this.testHelper = new ParseEventuallyQueue.TestHelper();
      }

      return this.testHelper;
   }

   public boolean isConnected() {
      return this.isConnected;
   }

   protected void notifyTestHelper(int var1) {
      this.notifyTestHelper(var1, (Throwable)null);
   }

   protected void notifyTestHelper(int var1, Throwable var2) {
      if(this.testHelper != null) {
         this.testHelper.notify(var1, var2);
      }

   }

   public abstract void onDestroy();

   public abstract void pause();

   public abstract int pendingCount();

   public abstract void resume();

   public void setConnected(boolean var1) {
      this.isConnected = var1;
   }

   public void setMaxCacheSizeBytes(int var1) {
   }

   public void setTimeoutRetryWaitSeconds(double var1) {
   }

   abstract void simulateReboot();

   Task<JSONObject> waitForOperationSetAndEventuallyPin(ParseOperationSet var1, EventuallyPin var2) {
      return Task.forResult((Object)null);
   }

   public static class TestHelper {
      public static final int COMMAND_ENQUEUED = 3;
      public static final int COMMAND_FAILED = 2;
      public static final int COMMAND_NOT_ENQUEUED = 4;
      public static final int COMMAND_OLD_FORMAT_DISCARDED = 8;
      public static final int COMMAND_SUCCESSFUL = 1;
      private static final int MAX_EVENTS = 1000;
      public static final int NETWORK_DOWN = 7;
      public static final int OBJECT_REMOVED = 6;
      public static final int OBJECT_UPDATED = 5;
      private SparseArray<Semaphore> events;

      private TestHelper() {
         this.events = new SparseArray();
         this.clear();
      }

      // $FF: synthetic method
      TestHelper(Object var1) {
         this();
      }

      public static String getEventString(int var0) {
         switch(var0) {
         case 1:
            return "COMMAND_SUCCESSFUL";
         case 2:
            return "COMMAND_FAILED";
         case 3:
            return "COMMAND_ENQUEUED";
         case 4:
            return "COMMAND_NOT_ENQUEUED";
         case 5:
            return "OBJECT_UPDATED";
         case 6:
            return "OBJECT_REMOVED";
         case 7:
            return "NETWORK_DOWN";
         case 8:
            return "COMMAND_OLD_FORMAT_DISCARDED";
         default:
            throw new IllegalStateException("Encountered unknown event: " + var0);
         }
      }

      public void clear() {
         this.events.clear();
         this.events.put(1, new Semaphore(1000));
         this.events.put(2, new Semaphore(1000));
         this.events.put(3, new Semaphore(1000));
         this.events.put(4, new Semaphore(1000));
         this.events.put(5, new Semaphore(1000));
         this.events.put(6, new Semaphore(1000));
         this.events.put(7, new Semaphore(1000));
         this.events.put(8, new Semaphore(1000));

         for(int var1 = 0; var1 < this.events.size(); ++var1) {
            int var2 = this.events.keyAt(var1);
            ((Semaphore)this.events.get(var2)).acquireUninterruptibly(1000);
         }

      }

      public List<String> getUnexpectedEvents() {
         ArrayList var1 = new ArrayList();

         for(int var2 = 0; var2 < this.events.size(); ++var2) {
            int var3 = this.events.keyAt(var2);
            if(((Semaphore)this.events.get(var3)).availablePermits() > 0) {
               var1.add(getEventString(var3));
            }
         }

         return var1;
      }

      public void notify(int var1) {
         this.notify(var1, (Throwable)null);
      }

      public void notify(int var1, Throwable var2) {
         ((Semaphore)this.events.get(var1)).release();
      }

      public int unexpectedEvents() {
         int var1 = 0;

         for(int var2 = 0; var2 < this.events.size(); ++var2) {
            int var3 = this.events.keyAt(var2);
            var1 += ((Semaphore)this.events.get(var3)).availablePermits();
         }

         return var1;
      }

      public boolean waitFor(int var1) {
         return this.waitFor(var1, 1);
      }

      public boolean waitFor(int var1, int var2) {
         try {
            boolean var4 = ((Semaphore)this.events.get(var1)).tryAcquire(var2, 10L, TimeUnit.SECONDS);
            return var4;
         } catch (InterruptedException var5) {
            var5.printStackTrace();
            return false;
         }
      }
   }
}
