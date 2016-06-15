package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_615;
import com.google.android.gms.tagmanager.class_617;
import com.google.android.gms.tagmanager.class_74;

// $FF: renamed from: com.google.android.gms.tagmanager.bn
class class_612 {
   // $FF: renamed from: pO () com.google.android.gms.tagmanager.bm
   public class_74 method_3488() {
      return (class_74)(this.method_3489() < 8?new class_615():new class_617());
   }

   // $FF: renamed from: pg () int
   int method_3489() {
      return VERSION.SDK_INT;
   }
}
