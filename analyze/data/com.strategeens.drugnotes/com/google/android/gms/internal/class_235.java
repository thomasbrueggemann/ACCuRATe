package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ba
@ey
public final class class_235 extends class_3.class_1262 {
   // $FF: renamed from: os com.google.android.gms.ads.doubleclick.AppEventListener
   private final AppEventListener field_445;

   public class_235(AppEventListener var1) {
      this.field_445 = var1;
   }

   public void onAppEvent(String var1, String var2) {
      this.field_445.onAppEvent(var1, var2);
   }
}
