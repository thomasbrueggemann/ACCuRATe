package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.eu
@ey
public class class_408 implements InAppPurchaseResult {
   // $FF: renamed from: te com.google.android.gms.internal.eq
   private final class_30 field_1271;

   public class_408(class_30 var1) {
      this.field_1271 = var1;
   }

   public void finishPurchase() {
      try {
         this.field_1271.finishPurchase();
      } catch (RemoteException var2) {
         class_368.method_2510("Could not forward finishPurchase to InAppPurchaseResult", var2);
      }
   }

   public String getProductId() {
      try {
         String var2 = this.field_1271.getProductId();
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward getProductId to InAppPurchaseResult", var3);
         return null;
      }
   }

   public Intent getPurchaseData() {
      try {
         Intent var2 = this.field_1271.getPurchaseData();
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward getPurchaseData to InAppPurchaseResult", var3);
         return null;
      }
   }

   public int getResultCode() {
      try {
         int var2 = this.field_1271.getResultCode();
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward getPurchaseData to InAppPurchaseResult", var3);
         return 0;
      }
   }

   public boolean isVerified() {
      try {
         boolean var2 = this.field_1271.isVerified();
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2510("Could not forward isVerified to InAppPurchaseResult", var3);
         return false;
      }
   }
}
