package com.google.android.gms.internal;

import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jk;
import com.google.android.gms.internal.ka;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.ka
public class class_297 {
   private static final String TAG = ka.class.getSimpleName();
   // $FF: renamed from: VG com.google.android.gms.internal.jk
   private final jk<jf> field_1005;
   // $FF: renamed from: YQ com.google.android.gms.internal.kb
   private final class_298 field_1006;
   // $FF: renamed from: YR java.util.Locale
   private final Locale field_1007;

   public class_297(String var1, jk<jf> var2) {
      this.field_1005 = var2;
      this.field_1007 = Locale.getDefault();
      this.field_1006 = new class_298(var1, this.field_1007);
   }
}
