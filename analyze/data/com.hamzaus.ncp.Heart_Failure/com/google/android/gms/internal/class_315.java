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
import com.google.android.gms.internal.class_22;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jk;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.class_86;
import java.util.HashMap;

// $FF: renamed from: com.google.android.gms.internal.jg
public class class_315 {
   // $FF: renamed from: VG com.google.android.gms.internal.jk
   private final jk<jf> field_1279;
   // $FF: renamed from: VH android.content.ContentProviderClient
   private ContentProviderClient field_1280 = null;
   // $FF: renamed from: VI boolean
   private boolean field_1281 = false;
   // $FF: renamed from: VJ java.util.HashMap
   private HashMap<LocationListener, class_315.class_827> field_1282 = new HashMap();
   private final Context mContext;

   public class_315(Context var1, jk<jf> var2) {
      this.mContext = var1;
      this.field_1279 = var2;
   }

   public Location getLastLocation() {
      this.field_1279.method_75();

      try {
         Location var2 = ((class_22)this.field_1279.method_76()).method_102(this.mContext.getPackageName());
         return var2;
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   // $FF: renamed from: iT () void
   public void method_2042() {
      if(this.field_1281) {
         try {
            this.setMockMode(false);
         } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
         }
      }

   }

   public void removeAllListeners() {
      // $FF: Couldn't be decompiled
   }

   public void removeLocationUpdates(PendingIntent var1) throws RemoteException {
      this.field_1279.method_75();
      ((class_22)this.field_1279.method_76()).method_78(var1);
   }

   public void removeLocationUpdates(LocationListener param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void requestLocationUpdates(LocationRequest var1, PendingIntent var2) throws RemoteException {
      this.field_1279.method_75();
      ((class_22)this.field_1279.method_76()).method_88(var1, var2);
   }

   public void requestLocationUpdates(LocationRequest param1, LocationListener param2, Looper param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void setMockLocation(Location var1) throws RemoteException {
      this.field_1279.method_75();
      ((class_22)this.field_1279.method_76()).setMockLocation(var1);
   }

   public void setMockMode(boolean var1) throws RemoteException {
      this.field_1279.method_75();
      ((class_22)this.field_1279.method_76()).setMockMode(var1);
      this.field_1281 = var1;
   }

   private static class class_828 extends Handler {
      // $FF: renamed from: VK com.google.android.gms.location.LocationListener
      private final LocationListener field_1155;

      public class_828(LocationListener var1) {
         this.field_1155 = var1;
      }

      public class_828(LocationListener var1, Looper var2) {
         super(var2);
         this.field_1155 = var1;
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Location var2 = new Location((Location)var1.obj);
            this.field_1155.onLocationChanged(var2);
            return;
         default:
            Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
         }
      }
   }

   private static class class_827 extends class_86.class_898 {
      // $FF: renamed from: VL android.os.Handler
      private Handler field_1150;

      class_827(LocationListener var1, Looper var2) {
         class_315.class_828 var3;
         if(var2 == null) {
            var3 = new class_315.class_828(var1);
         } else {
            var3 = new class_315.class_828(var1, var2);
         }

         this.field_1150 = var3;
      }

      public void onLocationChanged(Location var1) {
         if(this.field_1150 == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
         } else {
            Message var2 = Message.obtain();
            var2.what = 1;
            var2.obj = var1;
            this.field_1150.sendMessage(var2);
         }
      }

      public void release() {
         this.field_1150 = null;
      }
   }
}
