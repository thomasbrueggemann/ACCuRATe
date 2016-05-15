package com.facebook.drawee.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DraweeEventTracker {
   private static final int MAX_EVENTS_TO_TRACK = 20;
   private final Queue<DraweeEventTracker.Event> mEventQueue = new ArrayBlockingQueue(20);

   public void recordEvent(DraweeEventTracker.Event var1) {
      if(1 + this.mEventQueue.size() > 20) {
         this.mEventQueue.poll();
      }

      this.mEventQueue.add(var1);
   }

   public String toString() {
      return this.mEventQueue.toString();
   }

   public static enum Event {
      ON_ACTIVITY_START,
      ON_ACTIVITY_STOP,
      ON_ATTACH_CONTROLLER,
      ON_CLEAR_CONTROLLER,
      ON_CLEAR_HIERARCHY,
      ON_CLEAR_OLD_CONTROLLER,
      ON_DATASOURCE_FAILURE,
      ON_DATASOURCE_FAILURE_INT,
      ON_DATASOURCE_RESULT,
      ON_DATASOURCE_RESULT_INT,
      ON_DATASOURCE_SUBMIT,
      ON_DETACH_CONTROLLER,
      ON_DRAWABLE_HIDE,
      ON_DRAWABLE_SHOW,
      ON_HOLDER_ATTACH,
      ON_HOLDER_DETACH,
      ON_INIT_CONTROLLER,
      ON_RELEASE_CONTROLLER,
      ON_SET_CONTROLLER,
      ON_SET_HIERARCHY;

      static {
         DraweeEventTracker.Event[] var0 = new DraweeEventTracker.Event[]{ON_SET_HIERARCHY, ON_CLEAR_HIERARCHY, ON_SET_CONTROLLER, ON_CLEAR_OLD_CONTROLLER, ON_CLEAR_CONTROLLER, ON_INIT_CONTROLLER, ON_ATTACH_CONTROLLER, ON_DETACH_CONTROLLER, ON_RELEASE_CONTROLLER, ON_DATASOURCE_SUBMIT, ON_DATASOURCE_RESULT, ON_DATASOURCE_RESULT_INT, ON_DATASOURCE_FAILURE, ON_DATASOURCE_FAILURE_INT, ON_HOLDER_ATTACH, ON_HOLDER_DETACH, ON_DRAWABLE_SHOW, ON_DRAWABLE_HIDE, ON_ACTIVITY_START, ON_ACTIVITY_STOP};
      }
   }
}
