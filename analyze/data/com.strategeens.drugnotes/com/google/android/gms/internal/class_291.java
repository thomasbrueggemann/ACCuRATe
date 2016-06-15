package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_146;
import com.google.android.gms.internal.class_147;
import com.google.android.gms.internal.class_290;
import com.google.android.gms.internal.class_329;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_766;
import com.google.android.gms.internal.class_772;
import com.google.android.gms.internal.ni;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.class_651;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.nk
public class class_291 extends class_290 {
   private final class_766 agX;
   private final class_772 agY;
   private final class_329 agZ;

   public class_291(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6) {
      this(var1, var2, var3, var4, var5, var6, (String)null);
   }

   public class_291(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7) {
      this(var1, var2, var3, var4, var5, var6, var7, (String)null);
   }

   public class_291(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7, String var8) {
      super(var1, var2, var4, var5, var6);
      this.agX = new class_766(var1, this.Ee);
      this.agY = class_772.method_4391(var1, var7, var8, this.Ee);
      this.agZ = class_329.method_2287(var1, this.Ee);
   }

   // $FF: renamed from: S (boolean) void
   public void method_1852(boolean var1) throws RemoteException {
      this.agX.method_4368(var1);
   }

   // $FF: renamed from: a (long, android.app.PendingIntent) void
   public void method_1853(long var1, PendingIntent var3) throws RemoteException {
      this.dS();
      class_335.method_2311(var3);
      boolean var5;
      if(var1 >= 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      class_335.method_2308(var5, "detectionIntervalMillis must be >= 0");
      ((class_147)this.hw()).method_775(var1, true, var3);
   }

   // $FF: renamed from: a (android.app.PendingIntent) void
   public void method_1854(PendingIntent var1) throws RemoteException {
      this.dS();
      class_335.method_2311(var1);
      ((class_147)this.hw()).method_776(var1);
   }

   // $FF: renamed from: a (android.app.PendingIntent, com.google.android.gms.location.c$b) void
   public void method_1855(PendingIntent var1, class_651.class_1261 var2) throws RemoteException {
      this.dS();
      class_335.method_2306(var1, "PendingIntent must be specified.");
      class_335.method_2306(var2, "OnRemoveGeofencesResultListener not provided.");
      class_291.class_1235 var5;
      if(var2 == null) {
         var5 = null;
      } else {
         var5 = new class_291.class_1235(var2, this);
      }

      ((class_147)this.hw()).method_777(var1, var5, this.getContext().getPackageName());
   }

   // $FF: renamed from: a (com.google.android.gms.location.GeofencingRequest, android.app.PendingIntent, com.google.android.gms.location.c$a) void
   public void method_1856(GeofencingRequest var1, PendingIntent var2, class_651.class_1259 var3) throws RemoteException {
      this.dS();
      class_335.method_2306(var1, "geofencingRequest can\'t be null.");
      class_335.method_2306(var2, "PendingIntent must be specified.");
      class_335.method_2306(var3, "OnAddGeofencesResultListener not provided.");
      class_291.class_1235 var7;
      if(var3 == null) {
         var7 = null;
      } else {
         var7 = new class_291.class_1235(var3, this);
      }

      ((class_147)this.hw()).method_789(var1, var2, var7);
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationListener) void
   public void method_1857(LocationListener var1) throws RemoteException {
      this.agX.method_4369(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.LocationListener, android.os.Looper) void
   public void method_1858(LocationRequest param1, LocationListener param2, Looper param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.location.c$b) void
   public void method_1859(List<String> var1, class_651.class_1261 var2) throws RemoteException {
      this.dS();
      boolean var3;
      if(var1 != null && var1.size() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2308(var3, "geofenceRequestIds can\'t be null nor empty.");
      class_335.method_2306(var2, "OnRemoveGeofencesResultListener not provided.");
      String[] var5 = (String[])var1.toArray(new String[0]);
      class_291.class_1235 var6;
      if(var2 == null) {
         var6 = null;
      } else {
         var6 = new class_291.class_1235(var2, this);
      }

      ((class_147)this.hw()).method_801(var5, var6, this.getContext().getPackageName());
   }

   // $FF: renamed from: b (android.location.Location) void
   public void method_1860(Location var1) throws RemoteException {
      this.agX.method_4371(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
   public void method_1861(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.agX.method_4372(var1, var2);
   }

   // $FF: renamed from: c (android.app.PendingIntent) void
   public void method_1862(PendingIntent var1) throws RemoteException {
      this.agX.method_4373(var1);
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: nl () android.location.Location
   public Location method_1863() {
      return this.agX.method_4374();
   }

   private final class class_1234 extends com/google/android/gms/internal/jl<ni>.b<class_651.class_1259> {
      // $FF: renamed from: Iv int
      private final int field_2855;
      private final String[] aha;

      public class_1234(class_651.class_1259 var2, int var3, String[] var4) {
         super();
         this.field_2855 = LocationStatusCodes.method_2354(var3);
         this.aha = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.location.c$a) void
      protected void method_3753(class_651.class_1259 var1) {
         if(var1 != null) {
            var1.method_283(this.field_2855, this.aha);
         }

      }

      // $FF: renamed from: g (java.lang.Object) void
      // $FF: synthetic method
      protected void method_3743(Object var1) {
         this.method_3753((class_651.class_1259)var1);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
      }
   }

   private static final class class_1235 extends class_146.class_1445 {
      private class_651.class_1259 ahc;
      private class_651.class_1261 ahd;
      private class_291 ahe;

      public class_1235(class_651.class_1259 var1, class_291 var2) {
         this.ahc = var1;
         this.ahd = null;
         this.ahe = var2;
      }

      public class_1235(class_651.class_1261 var1, class_291 var2) {
         this.ahd = var1;
         this.ahc = null;
         this.ahe = var2;
      }

      // $FF: renamed from: a (int, android.app.PendingIntent) void
      public void method_771(int var1, PendingIntent var2) {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
         } else {
            class_291 var3 = this.ahe;
            class_291 var4 = this.ahe;
            var3.a(var4.new class_1236(1, this.ahd, var1, var2));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }

      // $FF: renamed from: a (int, java.lang.String[]) void
      public void method_772(int var1, String[] var2) throws RemoteException {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
         } else {
            class_291 var3 = this.ahe;
            class_291 var4 = this.ahe;
            var3.a(var4.new class_1234(this.ahc, var1, var2));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }

      // $FF: renamed from: b (int, java.lang.String[]) void
      public void method_773(int var1, String[] var2) {
         if(this.ahe == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
         } else {
            class_291 var3 = this.ahe;
            class_291 var4 = this.ahe;
            var3.a(var4.new class_1236(2, this.ahd, var1, var2));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
         }
      }
   }

   private final class class_1236 extends com/google/android/gms/internal/jl<ni>.b<class_651.class_1261> {
      // $FF: renamed from: Iv int
      private final int field_2856;
      private final String[] aha;
      private final int ahf;
      private final PendingIntent mPendingIntent;

      public class_1236(int var2, class_651.class_1261 var3, int var4, PendingIntent var5) {
         byte var6 = 1;
         super();
         if(var2 != var6) {
            var6 = 0;
         }

         class_349.method_2425((boolean)var6);
         this.ahf = var2;
         this.field_2856 = LocationStatusCodes.method_2354(var4);
         this.mPendingIntent = var5;
         this.aha = null;
      }

      public class_1236(int var2, class_651.class_1261 var3, int var4, String[] var5) {
         super();
         boolean var6;
         if(var2 == 2) {
            var6 = true;
         } else {
            var6 = false;
         }

         class_349.method_2425(var6);
         this.ahf = var2;
         this.field_2856 = LocationStatusCodes.method_2354(var4);
         this.aha = var5;
         this.mPendingIntent = null;
      }

      // $FF: renamed from: a (com.google.android.gms.location.c$b) void
      protected void method_3754(class_651.class_1261 var1) {
         if(var1 != null) {
            switch(this.ahf) {
            case 1:
               var1.method_284(this.field_2856, this.mPendingIntent);
               return;
            case 2:
               var1.method_285(this.field_2856, this.aha);
               return;
            default:
               Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
            }
         }

      }

      // $FF: renamed from: g (java.lang.Object) void
      // $FF: synthetic method
      protected void method_3743(Object var1) {
         this.method_3754((class_651.class_1261)var1);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
      }
   }
}
