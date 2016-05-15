package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfv;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class AdActivity extends Activity implements TraceFieldInterface {
   private zzfv zzoA;

   private void zzaD() {
      if(this.zzoA != null) {
         try {
            this.zzoA.zzaD();
         } catch (RemoteException var2) {
            zzb.zzd("Could not forward setContentViewSet to ad overlay:", var2);
            return;
         }
      }

   }

   public void onBackPressed() {
      boolean var1 = true;

      label20: {
         boolean var3;
         try {
            if(this.zzoA == null) {
               break label20;
            }

            var3 = this.zzoA.zzfn();
         } catch (RemoteException var4) {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", var4);
            break label20;
         }

         var1 = var3;
      }

      if(var1) {
         super.onBackPressed();
      }

   }

   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onDestroy() {
      try {
         if(this.zzoA != null) {
            this.zzoA.onDestroy();
         }
      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onDestroy to ad overlay:", var2);
      }

      super.onDestroy();
   }

   protected void onPause() {
      try {
         if(this.zzoA != null) {
            this.zzoA.onPause();
         }
      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onPause to ad overlay:", var2);
         this.finish();
      }

      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();

      try {
         if(this.zzoA != null) {
            this.zzoA.onRestart();
         }

      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onRestart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onResume() {
      super.onResume();

      try {
         if(this.zzoA != null) {
            this.zzoA.onResume();
         }

      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onResume to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      try {
         if(this.zzoA != null) {
            this.zzoA.onSaveInstanceState(var1);
         }
      } catch (RemoteException var3) {
         zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", var3);
         this.finish();
      }

      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      ApplicationStateMonitor.getInstance().activityStarted();
      super.onStart();

      try {
         if(this.zzoA != null) {
            this.zzoA.onStart();
         }

      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onStart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onStop() {
      ApplicationStateMonitor.getInstance().activityStopped();

      try {
         if(this.zzoA != null) {
            this.zzoA.onStop();
         }
      } catch (RemoteException var2) {
         zzb.zzd("Could not forward onStop to ad overlay:", var2);
         this.finish();
      }

      super.onStop();
   }

   public void setContentView(int var1) {
      super.setContentView(var1);
      this.zzaD();
   }

   public void setContentView(View var1) {
      super.setContentView(var1);
      this.zzaD();
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
      this.zzaD();
   }
}
