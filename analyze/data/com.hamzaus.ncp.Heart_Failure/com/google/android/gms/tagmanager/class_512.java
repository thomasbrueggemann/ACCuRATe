package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_517;
import com.google.android.gms.tagmanager.class_519;
import com.google.android.gms.tagmanager.class_69;

// $FF: renamed from: com.google.android.gms.tagmanager.bm
class class_512 {
   // $FF: renamed from: lM () com.google.android.gms.tagmanager.bl
   public class_69 method_2912() {
      return (class_69)(this.method_2913() < 8?new class_517():new class_519());
   }

   // $FF: renamed from: le () int
   int method_2913() {
      return VERSION.SDK_INT;
   }
}
