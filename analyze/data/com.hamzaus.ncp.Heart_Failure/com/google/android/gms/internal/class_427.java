package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_45;

// $FF: renamed from: com.google.android.gms.internal.dl
public class class_427 implements InAppPurchase {
   // $FF: renamed from: pg com.google.android.gms.internal.dc
   private final class_45 field_1875;

   public class_427(class_45 var1) {
      this.field_1875 = var1;
   }

   public String getProductId() {
      try {
         String var2 = this.field_1875.getProductId();
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward getProductId to InAppPurchase", var3);
         return null;
      }
   }

   public void recordPlayBillingResolution(int var1) {
      try {
         this.field_1875.recordPlayBillingResolution(var1);
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward recordPlayBillingResolution to InAppPurchase", var3);
      }
   }

   public void recordResolution(int var1) {
      try {
         this.field_1875.recordResolution(var1);
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward recordResolution to InAppPurchase", var3);
      }
   }
}
