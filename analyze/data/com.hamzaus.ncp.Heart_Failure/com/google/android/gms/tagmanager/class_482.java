package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.df
abstract class class_482 extends class_464 {
   public class_482(String var1, String... var2) {
      super(var1, var2);
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      this.method_2886(var1);
      return class_537.method_3020();
   }

   // $FF: renamed from: y (java.util.Map) void
   public abstract void method_2886(Map<String, class_52.class_816> var1);
}
