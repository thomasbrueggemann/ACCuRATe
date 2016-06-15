package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_47;

// $FF: renamed from: com.google.android.gms.internal.dk
public class class_440 implements InAppPurchaseResult {
   // $FF: renamed from: pu com.google.android.gms.internal.dg
   private final class_47 field_2007;

   public class_440(class_47 var1) {
      this.field_2007 = var1;
   }

   public void finishPurchase() {
      try {
         this.field_2007.finishPurchase();
      } catch (RemoteException var2) {
         class_370.method_2361("Could not forward finishPurchase to InAppPurchaseResult", var2);
      }
   }

   public String getProductId() {
      try {
         String var2 = this.field_2007.getProductId();
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward getProductId to InAppPurchaseResult", var3);
         return null;
      }
   }

   public Intent getPurchaseData() {
      try {
         Intent var2 = this.field_2007.getPurchaseData();
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward getPurchaseData to InAppPurchaseResult", var3);
         return null;
      }
   }

   public int getResultCode() {
      try {
         int var2 = this.field_2007.getResultCode();
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward getPurchaseData to InAppPurchaseResult", var3);
         return 0;
      }
   }

   public boolean isVerified() {
      try {
         boolean var2 = this.field_2007.isVerified();
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2361("Could not forward isVerified to InAppPurchaseResult", var3);
         return false;
      }
   }
}
