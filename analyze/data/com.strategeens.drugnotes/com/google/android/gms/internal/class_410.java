package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_408;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ew
@ey
public final class class_410 extends class_29.class_1384 {
   // $FF: renamed from: oN com.google.android.gms.ads.purchase.PlayStorePurchaseListener
   private final PlayStorePurchaseListener field_1275;

   public class_410(PlayStorePurchaseListener var1) {
      this.field_1275 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.eq) void
   public void method_189(class_30 var1) {
      this.field_1275.onInAppPurchaseFinished(new class_408(var1));
   }

   public boolean isValidPurchase(String var1) {
      return this.field_1275.isValidPurchase(var1);
   }
}
