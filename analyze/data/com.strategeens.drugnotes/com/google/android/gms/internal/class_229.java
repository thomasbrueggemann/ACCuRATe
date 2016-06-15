package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.class_0;
import com.google.android.gms.internal.class_230;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_374;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gs;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.ai
@ey
public class class_229 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gs, com.google.android.gms.internal.gj) com.google.android.gms.internal.ah
   protected ah method_1578(Context var1, gs var2, final gj<ah> var3) {
      final class_230 var4 = new class_230(var1, var2);
      var4.method_0(new class_0.class_1544() {
         // $FF: renamed from: aR () void
         public void method_734() {
            var3.method_2545(var4);
         }
      });
      return var4;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gs, java.lang.String) java.util.concurrent.Future
   public Future<ah> method_1579(final Context var1, final gs var2, final String var3) {
      final class_374 var4 = new class_374();
      class_367.field_1120.post(new Runnable() {
         public void run() {
            class_229.this.method_1578(var1, var2, var4).method_4(var3);
         }
      });
      return var4;
   }
}
