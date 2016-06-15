package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.class_178;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_49;

public final class InAppPurchaseActivity extends Activity {
   public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
   public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
   // $FF: renamed from: sY com.google.android.gms.internal.de
   private class_49 field_3825;

   protected void onActivityResult(int var1, int var2, Intent var3) {
      try {
         if(this.field_3825 != null) {
            this.field_3825.onActivityResult(var1, var2, var3);
         }
      } catch (RemoteException var5) {
         class_370.method_2361("Could not forward onActivityResult to in-app purchase manager:", var5);
      }

      super.onActivityResult(var1, var2, var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.field_3825 = class_178.method_1282(this);
      if(this.field_3825 == null) {
         class_370.method_2358("Could not create in-app purchase manager.");
         this.finish();
      } else {
         try {
            this.field_3825.onCreate();
         } catch (RemoteException var3) {
            class_370.method_2361("Could not forward onCreate to in-app purchase manager:", var3);
            this.finish();
         }
      }
   }

   protected void onDestroy() {
      try {
         if(this.field_3825 != null) {
            this.field_3825.onDestroy();
         }
      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward onDestroy to in-app purchase manager:", var2);
      }

      super.onDestroy();
   }
}
