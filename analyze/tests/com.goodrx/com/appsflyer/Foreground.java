package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import com.appsflyer.AFLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Foreground implements ActivityLifecycleCallbacks {
   private static Foreground instance;
   private Runnable check;
   private boolean foreground = false;
   private Handler handler = new Handler();
   private List<Foreground.Listener> listeners = new CopyOnWriteArrayList();
   private boolean paused = true;

   public static Foreground getInstance() {
      if(instance == null) {
         throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
      } else {
         return instance;
      }
   }

   public static Foreground init(Application var0) {
      if(instance == null) {
         instance = new Foreground();
         if(VERSION.SDK_INT >= 14) {
            var0.registerActivityLifecycleCallbacks(instance);
         }
      }

      return instance;
   }

   public void addListener(Foreground.Listener var1) {
      this.listeners.add(var1);
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity var1) {
   }

   public void onActivityPaused(final Activity var1) {
      this.paused = true;
      if(this.check != null) {
         this.handler.removeCallbacks(this.check);
      }

      Handler var2 = this.handler;
      Runnable var3 = new Runnable() {
         public void run() {
            if(Foreground.this.foreground && Foreground.this.paused) {
               Foreground.this.foreground = false;
               Iterator var2 = Foreground.this.listeners.iterator();

               while(var2.hasNext()) {
                  Foreground.Listener var3 = (Foreground.Listener)var2.next();

                  try {
                     var3.onBecameBackground(var1);
                  } catch (Exception var5) {
                     AFLogger.afLogE("Listener threw exception! ", var5);
                  }
               }
            }

         }
      };
      this.check = var3;
      var2.postDelayed(var3, 500L);
   }

   public void onActivityResumed(Activity var1) {
      this.paused = false;
      boolean var2 = this.foreground;
      boolean var3 = false;
      if(!var2) {
         var3 = true;
      }

      this.foreground = true;
      if(this.check != null) {
         this.handler.removeCallbacks(this.check);
      }

      if(var3) {
         Iterator var4 = this.listeners.iterator();

         while(var4.hasNext()) {
            Foreground.Listener var5 = (Foreground.Listener)var4.next();

            try {
               var5.onBecameForeground(var1);
            } catch (Exception var7) {
               AFLogger.afLogE("Listener threw exception! ", var7);
            }
         }
      }

   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
   }

   public void onActivityStopped(Activity var1) {
   }

   public interface Listener {
      void onBecameBackground(Activity var1);

      void onBecameForeground(Activity var1);
   }
}
