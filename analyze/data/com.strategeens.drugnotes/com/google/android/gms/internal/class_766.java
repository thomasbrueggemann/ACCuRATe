package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.class_147;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_92;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.nj
public class class_766 {
   // $FF: renamed from: Ee com.google.android.gms.internal.np
   private final np<ni> field_3425;
   private ContentProviderClient agS = null;
   private boolean agT = false;
   private HashMap<LocationListener, class_766.class_1264> agU = new HashMap();
   private final Context mContext;

   public class_766(Context var1, np<ni> var2) {
      this.mContext = var1;
      this.field_3425 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationListener, android.os.Looper) com.google.android.gms.internal.nj$b
   private class_766.class_1264 method_4367(LocationListener param1, Looper param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: S (boolean) void
   public void method_4368(boolean var1) throws RemoteException {
      this.field_3425.method_769();
      ((class_147)this.field_3425.method_770()).method_774(var1);
      this.agT = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationListener) void
   public void method_4369(LocationListener param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, com.google.android.gms.location.LocationListener, android.os.Looper) void
   public void method_4370(LocationRequest var1, LocationListener var2, Looper var3) throws RemoteException {
      this.field_3425.method_769();
      class_766.class_1264 var4 = this.method_4367(var2, var3);
      ((class_147)this.field_3425.method_770()).method_791(var1, var4);
   }

   // $FF: renamed from: b (android.location.Location) void
   public void method_4371(Location var1) throws RemoteException {
      this.field_3425.method_769();
      ((class_147)this.field_3425.method_770()).method_803(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.location.LocationRequest, android.app.PendingIntent) void
   public void method_4372(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.field_3425.method_769();
      ((class_147)this.field_3425.method_770()).method_790(var1, var2);
   }

   // $FF: renamed from: c (android.app.PendingIntent) void
   public void method_4373(PendingIntent var1) throws RemoteException {
      this.field_3425.method_769();
      ((class_147)this.field_3425.method_770()).method_802(var1);
   }

   // $FF: renamed from: nl () android.location.Location
   public Location method_4374() {
      this.field_3425.method_769();

      try {
         Location var2 = ((class_147)this.field_3425.method_770()).method_806(this.mContext.getPackageName());
         return var2;
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   // $FF: renamed from: nm () void
   public void method_4375() {
      if(this.agT) {
         try {
            this.method_4368(false);
         } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
         }
      }

   }

   public void removeAllListeners() {
      // $FF: Couldn't be decompiled
   }

   private static class class_1265 extends Handler {
      private final LocationListener agV;

      public class_1265(LocationListener var1) {
         this.agV = var1;
      }

      public class_1265(LocationListener var1, Looper var2) {
         super(var2);
         this.agV = var1;
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Location var2 = new Location((Location)var1.obj);
            this.agV.onLocationChanged(var2);
            return;
         default:
            Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
         }
      }
   }

   private static class class_1264 extends class_92.class_1059 {
      private Handler agW;

      class_1264(LocationListener var1, Looper var2) {
         class_766.class_1265 var3;
         if(var2 == null) {
            var3 = new class_766.class_1265(var1);
         } else {
            var3 = new class_766.class_1265(var1, var2);
         }

         this.agW = var3;
      }

      public void onLocationChanged(Location var1) {
         if(this.agW == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
         } else {
            Message var2 = Message.obtain();
            var2.what = 1;
            var2.obj = var1;
            this.agW.sendMessage(var2);
         }
      }

      public void release() {
         this.agW = null;
      }
   }
}
