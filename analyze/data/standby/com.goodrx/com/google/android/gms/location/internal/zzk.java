package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzi;
import com.google.android.gms.location.internal.zzp;
import java.util.HashMap;
import java.util.Map;

public class zzk {
   private final Context mContext;
   private ContentProviderClient zzaOG = null;
   private boolean zzaOH = false;
   private Map<Object, zzk.zza> zzaOI = new HashMap();
   private final zzp<zzi> zzaOt;
   private Map<LocationListener, zzk.zzc> zzaxd = new HashMap();

   public zzk(Context var1, zzp<zzi> var2) {
      this.mContext = var1;
      this.zzaOt = var2;
   }

   private zzk.zzc zza(LocationListener param1, Looper param2) {
      // $FF: Couldn't be decompiled
   }

   public Location getLastLocation() {
      this.zzaOt.zzqI();

      try {
         Location var2 = ((zzi)this.zzaOt.zzqJ()).zzei(this.mContext.getPackageName());
         return var2;
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public void removeAllListeners() {
      // $FF: Couldn't be decompiled
   }

   public void zza(LocationListener param1, zzg param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void zza(LocationRequest var1, LocationListener var2, Looper var3, zzg var4) throws RemoteException {
      this.zzaOt.zzqI();
      zzk.zzc var5 = this.zza(var2, var3);
      ((zzi)this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(var1), var5, var4));
   }

   public void zzam(boolean var1) throws RemoteException {
      this.zzaOt.zzqI();
      ((zzi)this.zzaOt.zzqJ()).zzam(var1);
      this.zzaOH = var1;
   }

   public void zzyP() {
      if(this.zzaOH) {
         try {
            this.zzam(false);
         } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
         }
      }

   }

   private static class zza extends com.google.android.gms.location.zzc.zza {
      private Handler zzaOJ;

      private void zzb(int var1, Object var2) {
         if(this.zzaOJ == null) {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
         } else {
            Message var3 = Message.obtain();
            var3.what = var1;
            var3.obj = var2;
            this.zzaOJ.sendMessage(var3);
         }
      }

      public void onLocationAvailability(LocationAvailability var1) {
         this.zzb(1, var1);
      }

      public void onLocationResult(LocationResult var1) {
         this.zzb(0, var1);
      }
   }

   private static class zzb extends Handler {
      private final LocationListener zzaOL;

      public zzb(LocationListener var1) {
         this.zzaOL = var1;
      }

      public zzb(LocationListener var1, Looper var2) {
         super(var2);
         this.zzaOL = var1;
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Location var2 = new Location((Location)var1.obj);
            this.zzaOL.onLocationChanged(var2);
            return;
         default:
            Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
         }
      }
   }

   private static class zzc extends com.google.android.gms.location.zzd.zza {
      private Handler zzaOJ;

      zzc(LocationListener var1, Looper var2) {
         if(var2 == null) {
            boolean var4;
            if(Looper.myLooper() != null) {
               var4 = true;
            } else {
               var4 = false;
            }

            zzx.zza(var4, "Can\'t create handler inside thread that has not called Looper.prepare()");
         }

         zzk.zzb var3;
         if(var2 == null) {
            var3 = new zzk.zzb(var1);
         } else {
            var3 = new zzk.zzb(var1, var2);
         }

         this.zzaOJ = var3;
      }

      public void onLocationChanged(Location var1) {
         if(this.zzaOJ == null) {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
         } else {
            Message var2 = Message.obtain();
            var2.what = 1;
            var2.obj = var1;
            this.zzaOJ.sendMessage(var2);
         }
      }

      public void release() {
         this.zzaOJ = null;
      }
   }
}
