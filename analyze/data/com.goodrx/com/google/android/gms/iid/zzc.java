package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class zzc {
   static String zzaNg = null;
   static int zzaNh = 0;
   static int zzaNi = 0;
   static int zzaNj = 0;
   Context context;
   PendingIntent zzaLQ;
   Messenger zzaLU;
   Map<String, Object> zzaNk = new HashMap();
   Messenger zzaNl;
   MessengerCompat zzaNm;
   long zzaNn;
   long zzaNo;
   int zzaNp;
   int zzaNq;
   long zzaNr;

   public zzc(Context var1) {
      this.context = var1;
   }

   private void zzE(Object param1) {
      // $FF: Couldn't be decompiled
   }

   static String zza(KeyPair param0, String... param1) {
      // $FF: Couldn't be decompiled
   }

   public static String zzaN(Context var0) {
      if(zzaNg != null) {
         return zzaNg;
      } else {
         zzaNh = Process.myUid();
         PackageManager var1 = var0.getPackageManager();
         Iterator var2 = var1.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();

         while(true) {
            while(var2.hasNext()) {
               ResolveInfo var11 = (ResolveInfo)var2.next();
               if(var1.checkPermission("com.google.android.c2dm.permission.RECEIVE", var11.serviceInfo.packageName) == 0) {
                  try {
                     ApplicationInfo var14 = var1.getApplicationInfo(var11.serviceInfo.packageName, 0);
                     Log.w("InstanceID/Rpc", "Found " + var14.uid);
                     zzaNi = var14.uid;
                     zzaNg = var11.serviceInfo.packageName;
                     String var16 = zzaNg;
                     return var16;
                  } catch (NameNotFoundException var19) {
                     ;
                  }
               } else {
                  Log.w("InstanceID/Rpc", "Possible malicious package " + var11.serviceInfo.packageName + " declares " + "com.google.android.c2dm.intent.REGISTER" + " without permission");
               }
            }

            Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");

            try {
               ApplicationInfo var9 = var1.getApplicationInfo("com.google.android.gms", 0);
               zzaNg = var9.packageName;
               zzaNi = var9.uid;
               String var10 = zzaNg;
               return var10;
            } catch (NameNotFoundException var18) {
               try {
                  ApplicationInfo var7 = var1.getApplicationInfo("com.google.android.gsf", 0);
                  zzaNg = var7.packageName;
                  zzaNi = var7.uid;
                  String var8 = zzaNg;
                  return var8;
               } catch (NameNotFoundException var17) {
                  Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                  return null;
               }
            }
         }
      }
   }

   private Intent zzb(Bundle param1, KeyPair param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void zzea(String var1) {
      if("com.google.android.gsf".equals(zzaNg)) {
         ++this.zzaNp;
         if(this.zzaNp >= 3) {
            if(this.zzaNp == 3) {
               this.zzaNq = 1000 + (new Random()).nextInt(1000);
            }

            this.zzaNq = 2 * this.zzaNq;
            this.zzaNr = SystemClock.elapsedRealtime() + (long)this.zzaNq;
            Log.w("InstanceID/Rpc", "Backoff due to " + var1 + " for " + this.zzaNq);
            return;
         }
      }

   }

   private void zzg(Object var1, Object var2) {
      if(var1 instanceof ConditionVariable) {
         ((ConditionVariable)var1).open();
      }

      if(var1 instanceof Messenger) {
         Messenger var3 = (Messenger)var1;
         Message var4 = Message.obtain();
         var4.obj = var2;

         try {
            var3.send(var4);
         } catch (RemoteException var6) {
            Log.w("InstanceID/Rpc", "Failed to send response " + var6);
            return;
         }
      }

   }

   private void zzi(String param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public static String zzyF() {
      synchronized(zzc.class){}

      String var2;
      try {
         int var1 = zzaNj;
         zzaNj = var1 + 1;
         var2 = Integer.toString(var1);
      } finally {
         ;
      }

      return var2;
   }

   Intent zza(Bundle var1, KeyPair var2) throws IOException {
      Intent var3 = this.zzb(var1, var2);
      if(var3 != null && var3.hasExtra("google.messenger")) {
         var3 = this.zzb(var1, var2);
      }

      return var3;
   }

   void zza(Bundle var1, KeyPair var2, String var3) throws IOException {
      long var4 = SystemClock.elapsedRealtime();
      if(this.zzaNr != 0L && var4 <= this.zzaNr) {
         Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.zzaNr - var4) + " interval: " + this.zzaNq);
         throw new IOException("RETRY_LATER");
      } else {
         this.zzyE();
         if(zzaNg == null) {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
         } else {
            this.zzaNn = SystemClock.elapsedRealtime();
            Intent var6 = new Intent("com.google.android.c2dm.intent.REGISTER");
            var6.setPackage(zzaNg);
            var1.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaK(this.context)));
            var1.putString("osv", Integer.toString(VERSION.SDK_INT));
            var1.putString("app_ver", Integer.toString(InstanceID.zzaL(this.context)));
            var1.putString("cliv", "1");
            var1.putString("appid", InstanceID.zza(var2));
            String var8 = InstanceID.zzn(var2.getPublic().getEncoded());
            var1.putString("pub2", var8);
            String[] var9 = new String[]{this.context.getPackageName(), var8};
            var1.putString("sig", zza(var2, var9));
            var6.putExtras(var1);
            this.zzt(var6);
            this.zzb(var6, var3);
         }
      }
   }

   protected void zzb(Intent var1, String var2) {
      this.zzaNn = SystemClock.elapsedRealtime();
      var1.putExtra("kid", "|ID|" + var2 + "|");
      var1.putExtra("X-kid", "|ID|" + var2 + "|");
      boolean var5 = "com.google.android.gsf".equals(zzaNg);
      String var6 = var1.getStringExtra("useGsf");
      if(var6 != null) {
         var5 = "1".equals(var6);
      }

      if(Log.isLoggable("InstanceID/Rpc", 3)) {
         Log.d("InstanceID/Rpc", "Sending " + var1.getExtras());
      }

      if(this.zzaNl != null) {
         var1.putExtra("google.messenger", this.zzaLU);
         Message var18 = Message.obtain();
         var18.obj = var1;

         try {
            this.zzaNl.send(var18);
            return;
         } catch (RemoteException var21) {
            if(Log.isLoggable("InstanceID/Rpc", 3)) {
               Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
            }
         }
      }

      if(var5) {
         Intent var7 = new Intent("com.google.android.gms.iid.InstanceID");
         var7.setPackage(this.context.getPackageName());
         var7.putExtra("GSF", var1);
         this.context.startService(var7);
      } else {
         var1.putExtra("google.messenger", this.zzaLU);
         var1.putExtra("messenger2", "1");
         if(this.zzaNm != null) {
            Message var14 = Message.obtain();
            var14.obj = var1;

            try {
               this.zzaNm.send(var14);
               return;
            } catch (RemoteException var20) {
               if(Log.isLoggable("InstanceID/Rpc", 3)) {
                  Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
               }
            }
         }

         this.context.startService(var1);
      }
   }

   public void zze(Message var1) {
      if(var1 != null) {
         if(var1.obj instanceof Intent) {
            Intent var3 = (Intent)var1.obj;
            var3.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if(var3.hasExtra("google.messenger")) {
               Parcelable var4 = var3.getParcelableExtra("google.messenger");
               if(var4 instanceof MessengerCompat) {
                  this.zzaNm = (MessengerCompat)var4;
               }

               if(var4 instanceof Messenger) {
                  this.zzaNl = (Messenger)var4;
               }
            }

            this.zzw((Intent)var1.obj);
         } else {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
         }
      }
   }

   void zzt(Intent var1) {
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

   String zzu(Intent var1) throws IOException {
      if(var1 == null) {
         throw new IOException("SERVICE_NOT_AVAILABLE");
      } else {
         String var2 = var1.getStringExtra("registration_id");
         if(var2 == null) {
            var2 = var1.getStringExtra("unregistered");
         }

         var1.getLongExtra("Retry-After", 0L);
         if(var2 != null) {
            ;
         }

         if(var2 == null) {
            String var5 = var1.getStringExtra("error");
            if(var5 != null) {
               throw new IOException(var5);
            } else {
               Log.w("InstanceID/Rpc", "Unexpected response from GCM " + var1.getExtras(), new Throwable());
               throw new IOException("SERVICE_NOT_AVAILABLE");
            }
         } else {
            return var2;
         }
      }
   }

   void zzv(Intent var1) {
      String var2 = var1.getStringExtra("error");
      if(var2 == null) {
         Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + var1.getExtras());
      } else {
         if(Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + var2);
         }

         boolean var3 = var2.startsWith("|");
         String var4 = null;
         if(var3) {
            String[] var8 = var2.split("\\|");
            if(!"ID".equals(var8[1])) {
               Log.w("InstanceID/Rpc", "Unexpected structured response " + var2);
            }

            if(var8.length > 2) {
               var4 = var8[2];
               var2 = var8[3];
               if(var2.startsWith(":")) {
                  var2 = var2.substring(1);
               }
            } else {
               var2 = "UNKNOWN";
               var4 = null;
            }

            var1.putExtra("error", var2);
         }

         if(var4 == null) {
            this.zzE(var2);
         } else {
            this.zzi(var4, var2);
         }

         long var5 = var1.getLongExtra("Retry-After", 0L);
         if(var5 > 0L) {
            this.zzaNo = SystemClock.elapsedRealtime();
            this.zzaNq = 1000 * (int)var5;
            this.zzaNr = SystemClock.elapsedRealtime() + (long)this.zzaNq;
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.zzaNq);
            return;
         }

         if("SERVICE_NOT_AVAILABLE".equals(var2) || "AUTHENTICATION_FAILED".equals(var2)) {
            this.zzea(var2);
            return;
         }
      }

   }

   void zzw(Intent var1) {
      if(var1 == null) {
         if(Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
         }
      } else {
         String var2 = var1.getAction();
         if("com.google.android.c2dm.intent.REGISTRATION".equals(var2) || "com.google.android.gms.iid.InstanceID".equals(var2)) {
            String var3 = var1.getStringExtra("registration_id");
            String var4;
            if(var3 == null) {
               var4 = var1.getStringExtra("unregistered");
            } else {
               var4 = var3;
            }

            if(var4 == null) {
               this.zzv(var1);
               return;
            }

            this.zzaNn = SystemClock.elapsedRealtime();
            this.zzaNr = 0L;
            this.zzaNp = 0;
            this.zzaNq = 0;
            if(Log.isLoggable("InstanceID/Rpc", 3)) {
               Log.d("InstanceID/Rpc", "AppIDResponse: " + var4 + " " + var1.getExtras());
            }

            boolean var5 = var4.startsWith("|");
            String var6 = null;
            if(var5) {
               String[] var7 = var4.split("\\|");
               if(!"ID".equals(var7[1])) {
                  Log.w("InstanceID/Rpc", "Unexpected structured response " + var4);
               }

               String var8 = var7[2];
               if(var7.length > 4) {
                  if("SYNC".equals(var7[3])) {
                     InstanceIDListenerService.zzaM(this.context);
                  } else if("RST".equals(var7[3])) {
                     InstanceIDListenerService.zza(this.context, InstanceID.getInstance(this.context).zzyB());
                     var1.removeExtra("registration_id");
                     this.zzi(var8, var1);
                     return;
                  }
               }

               String var9 = var7[-1 + var7.length];
               if(var9.startsWith(":")) {
                  var9 = var9.substring(1);
               }

               var1.putExtra("registration_id", var9);
               var6 = var8;
            }

            if(var6 == null) {
               this.zzE(var1);
               return;
            }

            this.zzi(var6, var1);
            return;
         }

         if(Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response " + var1.getAction());
            return;
         }
      }

   }

   void zzyE() {
      if(this.zzaLU == null) {
         zzaN(this.context);
         this.zzaLU = new Messenger(new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message var1) {
               zzc.this.zze(var1);
            }
         });
      }
   }
}
