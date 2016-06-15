package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_22;
import com.google.android.gms.internal.class_23;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_260;
import com.google.android.gms.internal.class_297;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_315;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jk;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jh
public class class_243 extends hc<jf> {
   // $FF: renamed from: VG com.google.android.gms.internal.jk
   private final jk<jf> field_799;
   // $FF: renamed from: VM com.google.android.gms.internal.jg
   private final class_315 field_800;
   // $FF: renamed from: VN com.google.android.gms.internal.ka
   private final class_297 field_801;
   // $FF: renamed from: VO com.google.android.gms.internal.ja
   private final class_260 field_802;
   // $FF: renamed from: VP java.lang.String
   private final String field_803;

   public class_243(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5) {
      this(var1, var2, var1.getPackageName(), var3, var4, var5, (String)null);
   }

   public class_243(Context var1, Looper var2, String var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String var7) {
      super(var1, var2, var4, var5, new String[0]);
      this.field_799 = new class_243.class_929();
      this.field_800 = new class_315(var1, this.field_799);
      this.field_803 = var6;
      this.field_801 = new class_297(var3, this.field_799);
      this.field_802 = class_260.method_1819(var1, var7, this.field_799);
   }

   public class_243(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String var4) {
      super(var1, var2, var3, new String[0]);
      this.field_799 = new class_243.class_929();
      this.field_800 = new class_315(var1, this.field_799);
      this.field_803 = var4;
      this.field_801 = new class_297(var1.getPackageName(), this.field_799);
      this.field_802 = class_260.method_1819(var1, (String)null, this.field_799);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var3.putString("client_name", this.field_803);
      var1.method_171(var2, 5077000, this.getContext().getPackageName(), var3);
   }

   public void addGeofences(List<ji> var1, PendingIntent var2, LocationClient.OnAddGeofencesResultListener var3) throws RemoteException {
      this.ci();
      boolean var4;
      if(var1 != null && var1.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      class_347.method_2168(var4, "At least one geofence must be specified.");
      class_347.method_2166(var2, "PendingIntent must be specified.");
      class_347.method_2166(var3, "OnAddGeofencesResultListener not provided.");
      class_243.class_928 var7;
      if(var3 == null) {
         var7 = null;
      } else {
         var7 = new class_243.class_928(var3, this);
      }

      ((class_22)this.fo()).method_98(var1, var2, var7, this.getContext().getPackageName());
   }

   // $FF: renamed from: at (android.os.IBinder) com.google.android.gms.internal.jf
   protected class_22 method_1700(IBinder var1) {
      return class_22.class_1015.method_2863(var1);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.location.internal.GoogleLocationManagerService.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public Location getLastLocation() {
      return this.field_800.getLastLocation();
   }

   public void removeActivityUpdates(PendingIntent var1) throws RemoteException {
      this.ci();
      class_347.method_2170(var1);
      ((class_22)this.fo()).removeActivityUpdates(var1);
   }

   public void removeGeofences(PendingIntent var1, LocationClient.OnRemoveGeofencesResultListener var2) throws RemoteException {
      this.ci();
      class_347.method_2166(var1, "PendingIntent must be specified.");
      class_347.method_2166(var2, "OnRemoveGeofencesResultListener not provided.");
      class_243.class_928 var5;
      if(var2 == null) {
         var5 = null;
      } else {
         var5 = new class_243.class_928(var2, this);
      }

      ((class_22)this.fo()).method_79(var1, var5, this.getContext().getPackageName());
   }

   public void removeGeofences(List<String> var1, LocationClient.OnRemoveGeofencesResultListener var2) throws RemoteException {
      this.ci();
      boolean var3;
      if(var1 != null && var1.size() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_347.method_2168(var3, "geofenceRequestIds can\'t be null nor empty.");
      class_347.method_2166(var2, "OnRemoveGeofencesResultListener not provided.");
      String[] var5 = (String[])var1.toArray(new String[0]);
      class_243.class_928 var6;
      if(var2 == null) {
         var6 = null;
      } else {
         var6 = new class_243.class_928(var2, this);
      }

      ((class_22)this.fo()).method_99(var5, var6, this.getContext().getPackageName());
   }

   public void removeLocationUpdates(PendingIntent var1) throws RemoteException {
      this.field_800.removeLocationUpdates(var1);
   }

   public void removeLocationUpdates(LocationListener var1) throws RemoteException {
      this.field_800.removeLocationUpdates(var1);
   }

   public void requestActivityUpdates(long var1, PendingIntent var3) throws RemoteException {
      this.ci();
      class_347.method_2170(var3);
      boolean var5;
      if(var1 >= 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      class_347.method_2168(var5, "detectionIntervalMillis must be >= 0");
      ((class_22)this.fo()).method_77(var1, true, var3);
   }

   public void requestLocationUpdates(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.field_800.requestLocationUpdates(var1, var2);
   }

   public void requestLocationUpdates(LocationRequest var1, LocationListener var2) throws RemoteException {
      this.requestLocationUpdates(var1, var2, (Looper)null);
   }

   public void requestLocationUpdates(LocationRequest param1, LocationListener param2, Looper param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void setMockLocation(Location var1) throws RemoteException {
      this.field_800.setMockLocation(var1);
   }

   public void setMockMode(boolean var1) throws RemoteException {
      this.field_800.setMockMode(var1);
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1700(var1);
   }

   private final class class_927 extends com/google/android/gms/internal/hc<jf>.b<LocationClient.OnAddGeofencesResultListener> {
      // $FF: renamed from: CQ int
      private final int field_1955;
      // $FF: renamed from: VQ java.lang.String[]
      private final String[] field_1956;

      public class_927(LocationClient.OnAddGeofencesResultListener var2, int var3, String[] var4) {
         super();
         this.field_1955 = LocationStatusCodes.method_2024(var3);
         this.field_1956 = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationClient$OnAddGeofencesResultListener) void
      protected void method_2652(LocationClient.OnAddGeofencesResultListener var1) {
         if(var1 != null) {
            var1.onAddGeofencesResult(this.field_1955, this.field_1956);
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2652((LocationClient.OnAddGeofencesResultListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private static final class class_928 extends class_23.class_1053 {
      // $FF: renamed from: VS com.google.android.gms.location.LocationClient$OnAddGeofencesResultListener
      private LocationClient.OnAddGeofencesResultListener field_3310;
      // $FF: renamed from: VT com.google.android.gms.location.LocationClient$OnRemoveGeofencesResultListener
      private LocationClient.OnRemoveGeofencesResultListener field_3311;
      // $FF: renamed from: VU com.google.android.gms.internal.jh
      private class_243 field_3312;

      public class_928(LocationClient.OnAddGeofencesResultListener var1, class_243 var2) {
         this.field_3310 = var1;
         this.field_3311 = null;
         this.field_3312 = var2;
      }

      public class_928(LocationClient.OnRemoveGeofencesResultListener var1, class_243 var2) {
         this.field_3311 = var1;
         this.field_3310 = null;
         this.field_3312 = var2;
      }

      public void onAddGeofencesResult(int var1, String[] var2) throws RemoteException {
         if(this.field_3312 == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
         } else {
            class_243 var3 = this.field_3312;
            class_243 var4 = this.field_3312;
            var3.a(var4.new class_927(this.field_3310, var1, var2));
            this.field_3312 = null;
            this.field_3310 = null;
            this.field_3311 = null;
         }
      }

      public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2) {
         if(this.field_3312 == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
         } else {
            class_243 var3 = this.field_3312;
            class_243 var4 = this.field_3312;
            var3.a(var4.new class_930(1, this.field_3311, var1, var2));
            this.field_3312 = null;
            this.field_3310 = null;
            this.field_3311 = null;
         }
      }

      public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2) {
         if(this.field_3312 == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
         } else {
            class_243 var3 = this.field_3312;
            class_243 var4 = this.field_3312;
            var3.a(var4.new class_930(2, this.field_3311, var1, var2));
            this.field_3312 = null;
            this.field_3310 = null;
            this.field_3311 = null;
         }
      }
   }

   private final class class_929 implements jk<jf> {
      private class_929() {
      }

      // $FF: synthetic method
      class_929(Object var2) {
         this();
      }

      // $FF: renamed from: ci () void
      public void method_75() {
         class_243.this.ci();
      }

      // $FF: renamed from: fo () android.os.IInterface
      // $FF: synthetic method
      public IInterface method_76() {
         return this.method_3476();
      }

      // $FF: renamed from: iU () com.google.android.gms.internal.jf
      public class_22 method_3476() {
         return (class_22)class_243.this.fo();
      }
   }

   private final class class_930 extends com/google/android/gms/internal/hc<jf>.b<LocationClient.OnRemoveGeofencesResultListener> {
      // $FF: renamed from: CQ int
      private final int field_1951;
      // $FF: renamed from: VQ java.lang.String[]
      private final String[] field_1952;
      // $FF: renamed from: VV int
      private final int field_1954;
      private final PendingIntent mPendingIntent;

      public class_930(int var2, LocationClient.OnRemoveGeofencesResultListener var3, int var4, PendingIntent var5) {
         byte var6 = 1;
         super();
         if(var2 != var6) {
            var6 = 0;
         }

         class_322.method_2050((boolean)var6);
         this.field_1954 = var2;
         this.field_1951 = LocationStatusCodes.method_2024(var4);
         this.mPendingIntent = var5;
         this.field_1952 = null;
      }

      public class_930(int var2, LocationClient.OnRemoveGeofencesResultListener var3, int var4, String[] var5) {
         super();
         boolean var6;
         if(var2 == 2) {
            var6 = true;
         } else {
            var6 = false;
         }

         class_322.method_2050(var6);
         this.field_1954 = var2;
         this.field_1951 = LocationStatusCodes.method_2024(var4);
         this.field_1952 = var5;
         this.mPendingIntent = null;
      }

      // $FF: renamed from: a (com.google.android.gms.location.LocationClient$OnRemoveGeofencesResultListener) void
      protected void method_2651(LocationClient.OnRemoveGeofencesResultListener var1) {
         if(var1 != null) {
            switch(this.field_1954) {
            case 1:
               var1.onRemoveGeofencesByPendingIntentResult(this.field_1951, this.mPendingIntent);
               return;
            case 2:
               var1.onRemoveGeofencesByRequestIdsResult(this.field_1951, this.field_1952);
               return;
            default:
               Log.wtf("LocationClientImpl", "Unsupported action: " + this.field_1954);
            }
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2651((LocationClient.OnRemoveGeofencesResultListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }
}
