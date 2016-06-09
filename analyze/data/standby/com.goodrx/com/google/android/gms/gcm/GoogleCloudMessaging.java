package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
   public static int zzaLM = 5000000;
   public static int zzaLN = 6500000;
   public static int zzaLO = 7000000;
   static GoogleCloudMessaging zzaLP;
   private static final AtomicInteger zzaLS = new AtomicInteger(1);
   private Context context;
   private PendingIntent zzaLQ;
   private Map<String, Handler> zzaLR = Collections.synchronizedMap(new HashMap());
   private final BlockingQueue<Intent> zzaLT = new LinkedBlockingQueue();
   final Messenger zzaLU = new Messenger(new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message var1) {
         if(var1 == null || !(var1.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
         }

         Intent var3 = (Intent)var1.obj;
         if("com.google.android.c2dm.intent.REGISTRATION".equals(var3.getAction())) {
            GoogleCloudMessaging.this.zzaLT.add(var3);
         } else if(!GoogleCloudMessaging.this.zzr(var3)) {
            var3.setPackage(GoogleCloudMessaging.this.context.getPackageName());
            GoogleCloudMessaging.this.context.sendBroadcast(var3);
            return;
         }

      }
   });

   public static GoogleCloudMessaging getInstance(Context var0) {
      synchronized(GoogleCloudMessaging.class){}

      GoogleCloudMessaging var2;
      try {
         if(zzaLP == null) {
            zzaLP = new GoogleCloudMessaging();
            zzaLP.context = var0.getApplicationContext();
         }

         var2 = zzaLP;
      } finally {
         ;
      }

      return var2;
   }

   private void zza(String var1, String var2, long var3, int var5, Bundle var6) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("Missing \'to\'");
      } else {
         Intent var7 = new Intent("com.google.android.gcm.intent.SEND");
         if(var6 != null) {
            var7.putExtras(var6);
         }

         this.zzs(var7);
         var7.setPackage(zzaJ(this.context));
         var7.putExtra("google.to", var1);
         var7.putExtra("google.message_id", var2);
         var7.putExtra("google.ttl", Long.toString(var3));
         var7.putExtra("google.delay", Integer.toString(var5));
         var7.putExtra("google.from", this.zzdZ(var1));
         if(zzaJ(this.context).contains(".gsf")) {
            Bundle var14 = new Bundle();
            Iterator var15 = var6.keySet().iterator();

            while(var15.hasNext()) {
               String var17 = (String)var15.next();
               Object var18 = var6.get(var17);
               if(var18 instanceof String) {
                  var14.putString("gcm." + var17, (String)var18);
               }
            }

            var14.putString("google.to", var1);
            var14.putString("google.message_id", var2);
            InstanceID.getInstance(this.context).zzc("GCM", "upstream", var14);
         } else {
            this.context.sendOrderedBroadcast(var7, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
         }
      }
   }

   public static String zzaJ(Context var0) {
      return zzc.zzaN(var0);
   }

   public static int zzaK(Context var0) {
      PackageManager var1 = var0.getPackageManager();

      try {
         int var3 = var1.getPackageInfo(zzaJ(var0), 0).versionCode;
         return var3;
      } catch (NameNotFoundException var4) {
         return -1;
      }
   }

   private String zzdZ(String var1) {
      int var2 = var1.indexOf(64);
      if(var2 > 0) {
         var1 = var1.substring(0, var2);
      }

      return InstanceID.getInstance(this.context).zzyB().zzi("", var1, "GCM");
   }

   private boolean zzr(Intent var1) {
      String var2 = var1.getStringExtra("In-Reply-To");
      if(var2 == null && var1.hasExtra("error")) {
         var2 = var1.getStringExtra("google.message_id");
      }

      if(var2 != null) {
         Handler var3 = (Handler)this.zzaLR.remove(var2);
         if(var3 != null) {
            Message var4 = Message.obtain();
            var4.obj = var1;
            return var3.sendMessage(var4);
         }
      }

      return false;
   }

   @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
   public void send(String var1, String var2, long var3, Bundle var5) throws IOException {
      this.zza(var1, var2, var3, -1, var5);
   }

   void zzs(Intent var1) {
      synchronized(this){}

      try {
         if(this.zzaLQ == null) {
            Intent var3 = new Intent();
            var3.setPackage("com.google.example.invalidpackage");
            this.zzaLQ = PendingIntent.getBroadcast(this.context, 0, var3, 0);
         }

         var1.putExtra("app", this.zzaLQ);
      } finally {
         ;
      }

   }
}
