package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.class_179;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_42;

public final class AdActivity extends Activity {
   public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
   public static final String SIMPLE_CLASS_NAME = "AdActivity";
   // $FF: renamed from: kp com.google.android.gms.internal.co
   private class_42 field_3313;

   // $FF: renamed from: N () void
   private void method_3481() {
      if(this.field_3313 != null) {
         try {
            this.field_3313.method_203();
         } catch (RemoteException var2) {
            class_370.method_2361("Could not forward setContentViewSet to ad overlay:", var2);
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.field_3313 = class_179.method_1285(this);
      if(this.field_3313 == null) {
         class_370.method_2358("Could not create ad overlay.");
         this.finish();
      } else {
         try {
            this.field_3313.onCreate(var1);
         } catch (RemoteException var3) {
            class_370.method_2361("Could not forward onCreate to ad overlay:", var3);
            this.finish();
         }
      }
   }

   protected void onDestroy() {
      try {
         if(this.field_3313 != null) {
            this.field_3313.onDestroy();
         }
      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onDestroy to ad overlay:", var2);
      }

      super.onDestroy();
   }

   protected void onPause() {
      try {
         if(this.field_3313 != null) {
            this.field_3313.onPause();
         }
      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onPause to ad overlay:", var2);
         this.finish();
      }

      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();

      try {
         if(this.field_3313 != null) {
            this.field_3313.onRestart();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onRestart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onResume() {
      super.onResume();

      try {
         if(this.field_3313 != null) {
            this.field_3313.onResume();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onResume to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      try {
         if(this.field_3313 != null) {
            this.field_3313.onSaveInstanceState(var1);
         }
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward onSaveInstanceState to ad overlay:", var3);
         this.finish();
      }

      super.onSaveInstanceState(var1);
   }

   protected void onStart() {
      super.onStart();

      try {
         if(this.field_3313 != null) {
            this.field_3313.onStart();
         }

      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onStart to ad overlay:", var2);
         this.finish();
      }
   }

   protected void onStop() {
      try {
         if(this.field_3313 != null) {
            this.field_3313.onStop();
         }
      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onStop to ad overlay:", var2);
         this.finish();
      }

      super.onStop();
   }

   public void setContentView(int var1) {
      super.setContentView(var1);
      this.method_3481();
   }

   public void setContentView(View var1) {
      super.setContentView(var1);
      this.method_3481();
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
      this.method_3481();
   }
}
