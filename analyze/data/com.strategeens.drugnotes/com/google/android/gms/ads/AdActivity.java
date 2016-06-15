package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.class_214;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_52;

public final class AdActivity extends Activity {
   public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
   public static final String SIMPLE_CLASS_NAME = "AdActivity";
   // $FF: renamed from: lf com.google.android.gms.internal.dx
   private class_52 field_3271;

   // $FF: renamed from: X () void
   private void method_4167() {
      if(this.field_3271 != null) {
         try {
            this.field_3271.method_220();
         } catch (RemoteException var2) {
            class_368.method_2510("Could not forward setContentViewSet to ad overlay:", var2);
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.field_3271 = class_214.method_1517(this);
      if(this.field_3271 == null) {
         class_368.method_2506("Could not create ad overlay.");
         this.finish();
      } else {
         try {
            this.field_3271.onCreate(var1);
         } catch (RemoteException var3) {
            class_368.method_2510("Could not forward onCreate to ad overlay:", var3);
            this.finish();
         }
      }
   }

   protected void onDestroy() {
      try {
         if(this.field_3271 != null) {
            this.field_3271.onDestroy();
         }
      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onDestroy to ad overlay:", var2);
      }

      super.onDestroy();
   }

   protected void onPause() {
      try {
         if(this.field_3271 != null) {
            this.field_3271.onPause();
         }
      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onPause to ad overlay:", var2);
         this.finish();
      }

      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();

      try {
         if(this.field_3271 != null) {
            this.field_3271.onRestart();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onRestart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onResume() {
      super.onResume();

      try {
         if(this.field_3271 != null) {
            this.field_3271.onResume();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onResume to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      try {
         if(this.field_3271 != null) {
            this.field_3271.onSaveInstanceState(var1);
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward onSaveInstanceState to ad overlay:", var3);
         this.finish();
      }

      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      super.onStart();

      try {
         if(this.field_3271 != null) {
            this.field_3271.onStart();
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onStart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onStop() {
      try {
         if(this.field_3271 != null) {
            this.field_3271.onStop();
         }
      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward onStop to ad overlay:", var2);
         this.finish();
      }

      super.onStop();
   }

   public void setContentView(int var1) {
      super.setContentView(var1);
      this.method_4167();
   }

   public void setContentView(View var1) {
      super.setContentView(var1);
      this.method_4167();
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
      this.method_4167();
   }
}
