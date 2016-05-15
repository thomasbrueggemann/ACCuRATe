package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.AsyncPoster;
import org.greenrobot.eventbus.BackgroundPoster;
import org.greenrobot.eventbus.EventBusBuilder;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.HandlerPoster;
import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.PendingPost;
import org.greenrobot.eventbus.SubscriberExceptionEvent;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.Subscription;
import org.greenrobot.eventbus.EventBus.1;
import org.greenrobot.eventbus.EventBus.2;
import org.greenrobot.eventbus.EventBus.PostingThreadState;

public class EventBus {
   private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
   public static String TAG = "EventBus";
   static volatile EventBus defaultInstance;
   private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
   private final AsyncPoster asyncPoster;
   private final BackgroundPoster backgroundPoster;
   private final ThreadLocal<PostingThreadState> currentPostingThreadState;
   private final boolean eventInheritance;
   private final ExecutorService executorService;
   private final int indexCount;
   private final boolean logNoSubscriberMessages;
   private final boolean logSubscriberExceptions;
   private final HandlerPoster mainThreadPoster;
   private final boolean sendNoSubscriberEvent;
   private final boolean sendSubscriberExceptionEvent;
   private final Map<Class<?>, Object> stickyEvents;
   private final SubscriberMethodFinder subscriberMethodFinder;
   private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
   private final boolean throwSubscriberException;
   private final Map<Object, List<Class<?>>> typesBySubscriber;

   public EventBus() {
      this(DEFAULT_BUILDER);
   }

   EventBus(EventBusBuilder var1) {
      this.currentPostingThreadState = new 1(this);
      this.subscriptionsByEventType = new HashMap();
      this.typesBySubscriber = new HashMap();
      this.stickyEvents = new ConcurrentHashMap();
      this.mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
      this.backgroundPoster = new BackgroundPoster(this);
      this.asyncPoster = new AsyncPoster(this);
      int var2;
      if(var1.subscriberInfoIndexes != null) {
         var2 = var1.subscriberInfoIndexes.size();
      } else {
         var2 = 0;
      }

      this.indexCount = var2;
      this.subscriberMethodFinder = new SubscriberMethodFinder(var1.subscriberInfoIndexes, var1.strictMethodVerification, var1.ignoreGeneratedIndex);
      this.logSubscriberExceptions = var1.logSubscriberExceptions;
      this.logNoSubscriberMessages = var1.logNoSubscriberMessages;
      this.sendSubscriberExceptionEvent = var1.sendSubscriberExceptionEvent;
      this.sendNoSubscriberEvent = var1.sendNoSubscriberEvent;
      this.throwSubscriberException = var1.throwSubscriberException;
      this.eventInheritance = var1.eventInheritance;
      this.executorService = var1.executorService;
   }

   static void addInterfaces(List<Class<?>> var0, Class<?>[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Class var4 = var1[var3];
         if(!var0.contains(var4)) {
            var0.add(var4);
            addInterfaces(var0, var4.getInterfaces());
         }
      }

   }

   private void checkPostStickyEventToSubscription(Subscription var1, Object var2) {
      if(var2 != null) {
         boolean var3;
         if(Looper.getMainLooper() == Looper.myLooper()) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.postToSubscription(var1, var2, var3);
      }

   }

   public static EventBus getDefault() {
      // $FF: Couldn't be decompiled
   }

   private void handleSubscriberException(Subscription var1, Object var2, Throwable var3) {
      if(var2 instanceof SubscriberExceptionEvent) {
         if(this.logSubscriberExceptions) {
            Log.e(TAG, "SubscriberExceptionEvent subscriber " + var1.subscriber.getClass() + " threw an exception", var3);
            SubscriberExceptionEvent var6 = (SubscriberExceptionEvent)var2;
            Log.e(TAG, "Initial event " + var6.causingEvent + " caused exception in " + var6.causingSubscriber, var6.throwable);
         }
      } else {
         if(this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", var3);
         }

         if(this.logSubscriberExceptions) {
            Log.e(TAG, "Could not dispatch event: " + var2.getClass() + " to subscribing class " + var1.subscriber.getClass(), var3);
         }

         if(this.sendSubscriberExceptionEvent) {
            this.post(new SubscriberExceptionEvent(this, var3, var2, var1.subscriber));
            return;
         }
      }

   }

   private static List<Class<?>> lookupAllEventTypes(Class<?> param0) {
      // $FF: Couldn't be decompiled
   }

   private void postSingleEvent(Object var1, PostingThreadState var2) throws Error {
      Class var3 = var1.getClass();
      boolean var4 = false;
      if(this.eventInheritance) {
         List var6 = lookupAllEventTypes(var3);
         int var7 = var6.size();

         for(int var8 = 0; var8 < var7; ++var8) {
            var4 |= this.postSingleEventForEventType(var1, var2, (Class)var6.get(var8));
         }
      } else {
         var4 = this.postSingleEventForEventType(var1, var2, var3);
      }

      if(!var4) {
         if(this.logNoSubscriberMessages) {
            Log.d(TAG, "No subscribers registered for event " + var3);
         }

         if(this.sendNoSubscriberEvent && var3 != NoSubscriberEvent.class && var3 != SubscriberExceptionEvent.class) {
            this.post(new NoSubscriberEvent(this, var1));
         }
      }

   }

   private boolean postSingleEventForEventType(Object param1, PostingThreadState param2, Class<?> param3) {
      // $FF: Couldn't be decompiled
   }

   private void postToSubscription(Subscription var1, Object var2, boolean var3) {
      switch(2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[var1.subscriberMethod.threadMode.ordinal()]) {
      case 1:
         this.invokeSubscriber(var1, var2);
         return;
      case 2:
         if(var3) {
            this.invokeSubscriber(var1, var2);
            return;
         }

         this.mainThreadPoster.enqueue(var1, var2);
         return;
      case 3:
         if(var3) {
            this.backgroundPoster.enqueue(var1, var2);
            return;
         }

         this.invokeSubscriber(var1, var2);
         return;
      case 4:
         this.asyncPoster.enqueue(var1, var2);
         return;
      default:
         throw new IllegalStateException("Unknown thread mode: " + var1.subscriberMethod.threadMode);
      }
   }

   private void subscribe(Object var1, SubscriberMethod var2) {
      Class var3 = var2.eventType;
      Subscription var4 = new Subscription(var1, var2);
      CopyOnWriteArrayList var5 = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(var3);
      if(var5 == null) {
         var5 = new CopyOnWriteArrayList();
         this.subscriptionsByEventType.put(var3, var5);
      } else if(var5.contains(var4)) {
         throw new EventBusException("Subscriber " + var1.getClass() + " already registered to event " + var3);
      }

      int var7 = var5.size();

      for(int var8 = 0; var8 <= var7; ++var8) {
         if(var8 == var7 || var2.priority > ((Subscription)var5.get(var8)).subscriberMethod.priority) {
            var5.add(var8, var4);
            break;
         }
      }

      Object var9 = (List)this.typesBySubscriber.get(var1);
      if(var9 == null) {
         var9 = new ArrayList();
         this.typesBySubscriber.put(var1, var9);
      }

      ((List)var9).add(var3);
      if(var2.sticky) {
         if(this.eventInheritance) {
            Iterator var12 = this.stickyEvents.entrySet().iterator();

            while(var12.hasNext()) {
               Entry var13 = (Entry)var12.next();
               if(var3.isAssignableFrom((Class)var13.getKey())) {
                  this.checkPostStickyEventToSubscription(var4, var13.getValue());
               }
            }
         } else {
            this.checkPostStickyEventToSubscription(var4, this.stickyEvents.get(var3));
         }
      }

   }

   private void unsubscribeByEventType(Object var1, Class<?> var2) {
      List var3 = (List)this.subscriptionsByEventType.get(var2);
      if(var3 != null) {
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            Subscription var6 = (Subscription)var3.get(var5);
            if(var6.subscriber == var1) {
               var6.active = false;
               var3.remove(var5);
               --var5;
               --var4;
            }
         }
      }

   }

   ExecutorService getExecutorService() {
      return this.executorService;
   }

   void invokeSubscriber(PendingPost var1) {
      Object var2 = var1.event;
      Subscription var3 = var1.subscription;
      PendingPost.releasePendingPost(var1);
      if(var3.active) {
         this.invokeSubscriber(var3, var2);
      }

   }

   void invokeSubscriber(Subscription var1, Object var2) {
      try {
         var1.subscriberMethod.method.invoke(var1.subscriber, new Object[]{var2});
      } catch (InvocationTargetException var5) {
         this.handleSubscriberException(var1, var2, var5.getCause());
      } catch (IllegalAccessException var6) {
         throw new IllegalStateException("Unexpected exception", var6);
      }
   }

   public boolean isRegistered(Object var1) {
      synchronized(this){}

      boolean var3;
      try {
         var3 = this.typesBySubscriber.containsKey(var1);
      } finally {
         ;
      }

      return var3;
   }

   public void post(Object var1) {
      PostingThreadState var2 = (PostingThreadState)this.currentPostingThreadState.get();
      List var3 = var2.eventQueue;
      var3.add(var1);
      if(!var2.isPosting) {
         boolean var5;
         if(Looper.getMainLooper() == Looper.myLooper()) {
            var5 = true;
         } else {
            var5 = false;
         }

         var2.isMainThread = var5;
         var2.isPosting = true;
         if(var2.canceled) {
            throw new EventBusException("Internal error. Abort state was not reset");
         }

         while(true) {
            boolean var8 = false;

            try {
               var8 = true;
               if(var3.isEmpty()) {
                  var8 = false;
                  break;
               }

               this.postSingleEvent(var3.remove(0), var2);
               var8 = false;
            } finally {
               if(var8) {
                  var2.isPosting = false;
                  var2.isMainThread = false;
               }
            }
         }

         var2.isPosting = false;
         var2.isMainThread = false;
      }

   }

   public void register(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
   }

   public void unregister(Object param1) {
      // $FF: Couldn't be decompiled
   }
}
