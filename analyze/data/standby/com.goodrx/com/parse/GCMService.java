package com.parse;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.GcmRegistrar;
import com.parse.PLog;
import com.parse.ProxyService;
import com.parse.PushRouter;
import com.parse.ServiceUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

class GCMService implements ProxyService {
   public static final String RECEIVE_PUSH_ACTION = "com.google.android.c2dm.intent.RECEIVE";
   public static final String REGISTER_RESPONSE_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
   private static final String TAG = "GCMService";
   private ExecutorService executor;
   private final WeakReference<Service> parent;

   GCMService(Service var1) {
      this.parent = new WeakReference(var1);
   }

   private void handleGcmPushIntent(Intent var1) {
      String var2 = var1.getStringExtra("message_type");
      if(var2 != null) {
         PLog.method_363("GCMService", "Ignored special message type " + var2 + " from GCM via intent " + var1);
      } else {
         String var3 = var1.getStringExtra("push_id");
         String var4 = var1.getStringExtra("time");
         String var5 = var1.getStringExtra("data");
         String var6 = var1.getStringExtra("channel");
         JSONObject var7 = null;
         if(var5 != null) {
            JSONObject var11;
            try {
               new JSONObject;
               var11 = JSONObjectInstrumentation.init(var5);
            } catch (JSONException var12) {
               PLog.method_362("GCMService", "Ignoring push because of JSON exception while processing: " + var5, var12);
               return;
            }

            var7 = var11;
         }

         PushRouter.getInstance().handlePush(var3, var4, var6, var7);
      }
   }

   private void handleGcmRegistrationIntent(Intent var1) {
      try {
         GcmRegistrar.getInstance().handleRegistrationIntentAsync(var1).waitForCompletion();
      } catch (InterruptedException var3) {
         ;
      }
   }

   private void onHandleIntent(Intent var1) {
      if(var1 != null) {
         String var2 = var1.getAction();
         if(!"com.google.android.c2dm.intent.REGISTRATION".equals(var2)) {
            if("com.google.android.c2dm.intent.RECEIVE".equals(var2)) {
               this.handleGcmPushIntent(var1);
               return;
            }

            PLog.method_361("GCMService", "PushService got unknown intent in GCM mode: " + var1);
            return;
         }

         this.handleGcmRegistrationIntent(var1);
      }

   }

   private void stopParent(int var1) {
      Service var2 = (Service)this.parent.get();
      if(var2 != null) {
         var2.stopSelf(var1);
      }

   }

   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      this.executor = Executors.newSingleThreadExecutor();
   }

   public void onDestroy() {
      if(this.executor != null) {
         this.executor.shutdown();
         this.executor = null;
      }

   }

   public int onStartCommand(final Intent var1, int var2, final int var3) {
      this.executor.execute(new Runnable() {
         public void run() {
            try {
               GCMService.this.onHandleIntent(var1);
            } finally {
               ServiceUtils.completeWakefulIntent(var1);
               GCMService.this.stopParent(var3);
            }

         }
      });
      return 2;
   }
}
