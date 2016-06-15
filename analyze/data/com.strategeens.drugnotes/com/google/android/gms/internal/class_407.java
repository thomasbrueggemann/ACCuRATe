package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ev
@ey
public class class_407 implements InAppPurchase {
   // $FF: renamed from: sP com.google.android.gms.internal.em
   private final class_32 field_1270;

   public class_407(class_32 var1) {
      this.field_1270 = var1;
   }

   public String getProductId() {
      try {
         String var2 = this.field_1270.getProductId();
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward getProductId to InAppPurchase", var3);
         return null;
      }
   }

   public void recordPlayBillingResolution(int var1) {
      try {
         this.field_1270.recordPlayBillingResolution(var1);
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward recordPlayBillingResolution to InAppPurchase", var3);
      }
   }

   public void recordResolution(int var1) {
      try {
         this.field_1270.recordResolution(var1);
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward recordResolution to InAppPurchase", var3);
      }
   }
}
