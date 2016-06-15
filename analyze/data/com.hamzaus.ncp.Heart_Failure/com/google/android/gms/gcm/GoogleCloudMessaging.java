package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GoogleCloudMessaging {
   public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
   public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
   public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
   public static final String MESSAGE_TYPE_MESSAGE = "gcm";
   public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
   // $FF: renamed from: Up com.google.android.gms.gcm.GoogleCloudMessaging
   static GoogleCloudMessaging field_2170;
   // $FF: renamed from: Uq android.app.PendingIntent
   private PendingIntent field_2171;
   // $FF: renamed from: Ur java.util.concurrent.BlockingQueue
   final BlockingQueue<Intent> field_2172 = new LinkedBlockingQueue();
   // $FF: renamed from: Us android.os.Handler
   private Handler field_2173 = new Handler(Looper.getMainLooper()) {
      public void handleMessage(Message var1) {
         Intent var2 = (Intent)var1.obj;
         GoogleCloudMessaging.this.field_2172.add(var2);
      }
   };
   // $FF: renamed from: Ut android.os.Messenger
   private Messenger field_2174;
   // $FF: renamed from: kM android.content.Context
   private Context field_2175;

   public GoogleCloudMessaging() {
      this.field_2174 = new Messenger(this.field_2173);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, long, int, android.os.Bundle) void
   private void method_2734(String var1, String var2, long var3, int var5, Bundle var6) throws IOException {
      if(Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Missing \'to\'");
      } else {
         Intent var7 = new Intent("com.google.android.gcm.intent.SEND");
         var7.putExtras(var6);
         this.method_2738(var7);
         var7.setPackage("com.google.android.gms");
         var7.putExtra("google.to", var1);
         var7.putExtra("google.message_id", var2);
         var7.putExtra("google.ttl", Long.toString(var3));
         var7.putExtra("google.delay", Integer.toString(var5));
         this.field_2175.sendOrderedBroadcast(var7, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      }
   }

   // $FF: renamed from: c (java.lang.String[]) void
   private void method_2735(String... var1) {
      String var2 = this.method_2737(var1);
      Intent var3 = new Intent("com.google.android.c2dm.intent.REGISTER");
      var3.setPackage("com.google.android.gms");
      var3.putExtra("google.messenger", this.field_2174);
      this.method_2738(var3);
      var3.putExtra("sender", var2);
      this.field_2175.startService(var3);
   }

   public static GoogleCloudMessaging getInstance(Context var0) {
      synchronized(GoogleCloudMessaging.class){}

      GoogleCloudMessaging var2;
      try {
         if(field_2170 == null) {
            field_2170 = new GoogleCloudMessaging();
            field_2170.field_2175 = var0;
         }

         var2 = field_2170;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: iJ () void
   private void method_2736() {
      Intent var1 = new Intent("com.google.android.c2dm.intent.UNREGISTER");
      var1.setPackage("com.google.android.gms");
      this.field_2172.clear();
      var1.putExtra("google.messenger", this.field_2174);
      this.method_2738(var1);
      this.field_2175.startService(var1);
   }

   public void close() {
      this.method_2739();
   }

   // $FF: renamed from: d (java.lang.String[]) java.lang.String
   String method_2737(String... var1) {
      if(var1 != null && var1.length != 0) {
         StringBuilder var2 = new StringBuilder(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(',').append(var1[var3]);
         }

         return var2.toString();
      } else {
         throw new IllegalArgumentException("No senderIds");
      }
   }

   public String getMessageType(Intent var1) {
      String var2;
      if(!"com.google.android.c2dm.intent.RECEIVE".equals(var1.getAction())) {
         var2 = null;
      } else {
         var2 = var1.getStringExtra("message_type");
         if(var2 == null) {
            return "gcm";
         }
      }

      return var2;
   }

   // $FF: renamed from: h (android.content.Intent) void
   void method_2738(Intent var1) {
      synchronized(this){}

      try {
         if(this.field_2171 == null) {
            Intent var3 = new Intent();
            var3.setPackage("com.google.example.invalidpackage");
            this.field_2171 = PendingIntent.getBroadcast(this.field_2175, 0, var3, 0);
         }

         var1.putExtra("app", this.field_2171);
      } finally {
         ;
      }

   }

   // $FF: renamed from: iK () void
   void method_2739() {
      synchronized(this){}

      try {
         if(this.field_2171 != null) {
            this.field_2171.cancel();
            this.field_2171 = null;
         }
      } finally {
         ;
      }

   }

   public String register(String... param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void send(String var1, String var2, long var3, Bundle var5) throws IOException {
      this.method_2734(var1, var2, var3, -1, var5);
   }

   public void send(String var1, String var2, Bundle var3) throws IOException {
      this.send(var1, var2, -1L, var3);
   }

   public void unregister() throws IOException {
      // $FF: Couldn't be decompiled
   }
}
