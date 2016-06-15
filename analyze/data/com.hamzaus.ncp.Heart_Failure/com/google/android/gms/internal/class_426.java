package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_50;

// $FF: renamed from: com.google.android.gms.internal.dm
public final class class_426 extends class_50.class_1011 {
   // $FF: renamed from: mA com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private final PlayStorePurchaseListener field_1874;

   public class_426(PlayStorePurchaseListener var1) {
      this.field_1874 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dg) void
   public void method_209(class_47 var1) {
      this.field_1874.onInAppPurchaseFinished(new class_440(var1));
   }

   public boolean isValidPurchase(String var1) {
      return this.field_1874.isValidPurchase(var1);
   }
}
