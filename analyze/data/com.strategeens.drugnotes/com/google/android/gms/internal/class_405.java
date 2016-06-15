package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_407;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.es
@ey
public final class class_405 extends class_31.class_1093 {
   // $FF: renamed from: oM com.google.android.gms.ads.purchase.InAppPurchaseListener
   private final InAppPurchaseListener field_1262;

   public class_405(InAppPurchaseListener var1) {
      this.field_1262 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.em) void
   public void method_190(class_32 var1) {
      this.field_1262.onInAppPurchaseRequested(new class_407(var1));
   }
}
