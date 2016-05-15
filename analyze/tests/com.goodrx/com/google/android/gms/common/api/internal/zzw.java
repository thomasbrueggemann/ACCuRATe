package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzn;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@Instrumented
public class zzw extends Fragment implements OnCancelListener, TraceFieldInterface {
   private boolean mStarted;
   private int zzaiA = -1;
   private ConnectionResult zzaiB;
   private final Handler zzaiC = new Handler(Looper.getMainLooper());
   protected zzn zzaiD;
   private final SparseArray<zzw.zza> zzaiE = new SparseArray();
   private boolean zzaiz;

   @Nullable
   public static zzw zza(FragmentActivity var0) {
      com.google.android.gms.common.internal.zzx.zzcD("Must be called from main thread of process");
      FragmentManager var1 = var0.getSupportFragmentManager();

      zzw var3;
      try {
         var3 = (zzw)var1.findFragmentByTag("GmsSupportLifecycleFrag");
      } catch (ClassCastException var4) {
         throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", var4);
      }

      if(var3 == null || var3.isRemoving()) {
         var3 = null;
      }

      return var3;
   }

   private void zza(int var1, ConnectionResult var2) {
      Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
      zzw.zza var4 = (zzw.zza)this.zzaiE.get(var1);
      if(var4 != null) {
         this.zzbD(var1);
         GoogleApiClient.OnConnectionFailedListener var5 = var4.zzaiH;
         if(var5 != null) {
            var5.onConnectionFailed(var2);
         }
      }

      this.zzpP();
   }

   public static zzw zzb(FragmentActivity var0) {
      zzw var1 = zza(var0);
      FragmentManager var2 = var0.getSupportFragmentManager();
      if(var1 == null) {
         var1 = zzpO();
         if(var1 == null) {
            Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
            var1 = new zzw();
         }

         var2.beginTransaction().add(var1, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
         var2.executePendingTransactions();
      }

      return var1;
   }

   private static String zzi(ConnectionResult var0) {
      return var0.getErrorMessage() + " (" + var0.getErrorCode() + ": " + zze.getErrorString(var0.getErrorCode()) + ')';
   }

   @Nullable
   private static zzw zzpO() {
      Class var1;
      label41: {
         Class var6;
         label44: {
            Object var0;
            try {
               var6 = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
               break label44;
            } catch (ClassNotFoundException var11) {
               var0 = var11;
            } catch (LinkageError var12) {
               var0 = var12;
            } catch (SecurityException var13) {
               var0 = var13;
            }

            if(Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
               Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", (Throwable)var0);
            }

            var1 = null;
            break label41;
         }

         var1 = var6;
      }

      if(var1 != null) {
         Object var2;
         try {
            zzw var4 = (zzw)var1.newInstance();
            return var4;
         } catch (IllegalAccessException var7) {
            var2 = var7;
         } catch (InstantiationException var8) {
            var2 = var8;
         } catch (ExceptionInInitializerError var9) {
            var2 = var9;
         } catch (RuntimeException var10) {
            var2 = var10;
         }

         if(Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
            Log.d("GmsSupportLifecycleFrag", "Unable to instantiate SupportLifecycleFragmentImpl class", (Throwable)var2);
         }
      }

      return null;
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);

      for(int var5 = 0; var5 < this.zzaiE.size(); ++var5) {
         ((zzw.zza)this.zzaiE.valueAt(var5)).dump(var1, var2, var3, var4);
      }

   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      boolean var4;
      label24: {
         var4 = true;
         switch(var1) {
         case 1:
            if(var2 == -1) {
               break label24;
            }

            if(var2 == 0) {
               this.zzaiB = new ConnectionResult(13, (PendingIntent)null);
            }
            break;
         case 2:
            if(this.zzpQ().isGooglePlayServicesAvailable(this.getActivity()) == 0) {
               break label24;
            }
         }

         var4 = false;
      }

      if(var4) {
         this.zzpP();
      } else {
         this.zza(this.zzaiA, this.zzaiB);
      }
   }

   public void onCancel(DialogInterface var1) {
      this.zza(this.zzaiA, new ConnectionResult(13, (PendingIntent)null));
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("resolving_error", this.zzaiz);
      if(this.zzaiA >= 0) {
         var1.putInt("failed_client_id", this.zzaiA);
         var1.putInt("failed_status", this.zzaiB.getErrorCode());
         var1.putParcelable("failed_resolution", this.zzaiB.getResolution());
      }

   }

   public void onStart() {
      ApplicationStateMonitor.getInstance().activityStarted();
      super.onStart();
      this.mStarted = true;
      if(!this.zzaiz) {
         for(int var1 = 0; var1 < this.zzaiE.size(); ++var1) {
            ((zzw.zza)this.zzaiE.valueAt(var1)).zzaiG.connect();
         }
      }

   }

   public void onStop() {
      ApplicationStateMonitor.getInstance().activityStopped();
      super.onStop();
      this.mStarted = false;

      for(int var1 = 0; var1 < this.zzaiE.size(); ++var1) {
         ((zzw.zza)this.zzaiE.valueAt(var1)).zzaiG.disconnect();
      }

   }

   public void zza(int var1, GoogleApiClient var2, GoogleApiClient.OnConnectionFailedListener var3) {
      com.google.android.gms.common.internal.zzx.zzb(var2, "GoogleApiClient instance cannot be null");
      boolean var5;
      if(this.zzaiE.indexOfKey(var1) < 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      com.google.android.gms.common.internal.zzx.zza(var5, "Already managing a GoogleApiClient with id " + var1);
      zzw.zza var6 = new zzw.zza(var1, var2, var3);
      this.zzaiE.put(var1, var6);
      if(this.mStarted && !this.zzaiz) {
         var2.connect();
      }

   }

   protected void zzb(int var1, ConnectionResult var2) {
      Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + zzi(var2));
      this.zza(var1, var2);
   }

   public void zzbD(int var1) {
      zzw.zza var2 = (zzw.zza)this.zzaiE.get(var1);
      this.zzaiE.remove(var1);
      if(var2 != null) {
         var2.zzpR();
      }

   }

   protected void zzc(int var1, ConnectionResult var2) {
      Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
      this.zza(var1, var2);
   }

   protected void zzpP() {
      this.zzaiz = false;
      this.zzaiA = -1;
      this.zzaiB = null;
      if(this.zzaiD != null) {
         this.zzaiD.unregister();
         this.zzaiD = null;
      }

      for(int var1 = 0; var1 < this.zzaiE.size(); ++var1) {
         ((zzw.zza)this.zzaiE.valueAt(var1)).zzaiG.connect();
      }

   }

   protected com.google.android.gms.common.zzc zzpQ() {
      return com.google.android.gms.common.zzc.zzoK();
   }

   private class zza implements GoogleApiClient.OnConnectionFailedListener {
      public final int zzaiF;
      public final GoogleApiClient zzaiG;
      public final GoogleApiClient.OnConnectionFailedListener zzaiH;

      public zza(int var2, GoogleApiClient var3, GoogleApiClient.OnConnectionFailedListener var4) {
         this.zzaiF = var2;
         this.zzaiG = var3;
         this.zzaiH = var4;
         var3.registerConnectionFailedListener(this);
      }

      public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
         var3.append(var1).append("GoogleApiClient #").print(this.zzaiF);
         var3.println(":");
         this.zzaiG.dump(var1 + "  ", var2, var3, var4);
      }

      public void onConnectionFailed(@NonNull ConnectionResult var1) {
         zzw.this.zzaiC.post(zzw.this.new zzb(this.zzaiF, var1));
      }

      public void zzpR() {
         this.zzaiG.unregisterConnectionFailedListener(this);
         this.zzaiG.disconnect();
      }
   }

   private class zzb implements Runnable {
      private final int zzaiJ;
      private final ConnectionResult zzaiK;

      public zzb(int var2, ConnectionResult var3) {
         this.zzaiJ = var2;
         this.zzaiK = var3;
      }

      @MainThread
      public void run() {
         if(zzw.this.mStarted && !zzw.this.zzaiz) {
            zzw.this.zzaiz = true;
            zzw.this.zzaiA = this.zzaiJ;
            zzw.this.zzaiB = this.zzaiK;
            if(this.zzaiK.hasResolution()) {
               try {
                  int var5 = 1 + (1 + zzw.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzw.this) << 16);
                  this.zzaiK.startResolutionForResult(zzw.this.getActivity(), var5);
               } catch (SendIntentException var6) {
                  zzw.this.zzpP();
               }
            } else if(zzw.this.zzpQ().isUserResolvableError(this.zzaiK.getErrorCode())) {
               zzw.this.zzb(this.zzaiJ, this.zzaiK);
            } else if(this.zzaiK.getErrorCode() == 18) {
               zzw.this.zzc(this.zzaiJ, this.zzaiK);
            } else {
               zzw.this.zza(this.zzaiJ, this.zzaiK);
            }
         }
      }
   }
}
