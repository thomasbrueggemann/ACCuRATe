package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.class_5;

// $FF: renamed from: com.google.android.gms.internal.ah
public final class class_158 extends class_5.class_1137 {
   // $FF: renamed from: lO com.google.android.gms.ads.AdListener
   private final AdListener field_34;

   public class_158(AdListener var1) {
      this.field_34 = var1;
   }

   public void onAdClosed() {
      this.field_34.onAdClosed();
   }

   public void onAdFailedToLoad(int var1) {
      this.field_34.onAdFailedToLoad(var1);
   }

   public void onAdLeftApplication() {
      this.field_34.onAdLeftApplication();
   }

   public void onAdLoaded() {
      this.field_34.onAdLoaded();
   }

   public void onAdOpened() {
      this.field_34.onAdOpened();
   }
}
