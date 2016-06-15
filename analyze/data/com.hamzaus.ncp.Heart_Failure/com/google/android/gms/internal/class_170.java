package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.class_4;

// $FF: renamed from: com.google.android.gms.internal.ao
public final class class_170 extends class_4.class_814 {
   // $FF: renamed from: mf com.google.android.gms.ads.doubleclick.AppEventListener
   private final AppEventListener field_566;

   public class_170(AppEventListener var1) {
      this.field_566 = var1;
   }

   public void onAppEvent(String var1, String var2) {
      this.field_566.onAppEvent(var1, var2);
   }
}
