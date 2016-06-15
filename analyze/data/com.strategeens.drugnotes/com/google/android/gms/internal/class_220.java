package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.at
@ey
public final class class_220 extends class_4.class_1169 {
   // $FF: renamed from: ob com.google.android.gms.ads.AdListener
   private final AdListener field_368;

   public class_220(AdListener var1) {
      this.field_368 = var1;
   }

   public void onAdClosed() {
      this.field_368.onAdClosed();
   }

   public void onAdFailedToLoad(int var1) {
      this.field_368.onAdFailedToLoad(var1);
   }

   public void onAdLeftApplication() {
      this.field_368.onAdLeftApplication();
   }

   public void onAdLoaded() {
      this.field_368.onAdLoaded();
   }

   public void onAdOpened() {
      this.field_368.onAdOpened();
   }
}
