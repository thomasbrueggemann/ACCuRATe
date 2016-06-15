package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.class_427;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_48;

// $FF: renamed from: com.google.android.gms.internal.di
public final class class_441 extends class_48.class_1045 {
   // $FF: renamed from: mz com.google.android.gms.ads.purchase.InAppPurchaseListener
   private final InAppPurchaseListener field_2010;

   public class_441(InAppPurchaseListener var1) {
      this.field_2010 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dc) void
   public void method_208(class_45 var1) {
      this.field_2010.onInAppPurchaseRequested(new class_427(var1));
   }
}
