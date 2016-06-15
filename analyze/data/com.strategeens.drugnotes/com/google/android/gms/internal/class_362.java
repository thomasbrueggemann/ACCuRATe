package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_229;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_430;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_437;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fy;
import java.util.List;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.fm
@ey
public class class_362 extends class_360 {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1085;
   // $FF: renamed from: tA com.google.android.gms.internal.fc$a
   private final class_437.class_1183 field_1086;
   // $FF: renamed from: tB com.google.android.gms.internal.fy$a
   private final class_432.class_1521 field_1087;
   // $FF: renamed from: tn com.google.android.gms.internal.fj
   private final class_438 field_1088;
   // $FF: renamed from: ui com.google.android.gms.internal.fn
   private final class_430 field_1089;
   // $FF: renamed from: uj java.util.concurrent.Future
   private Future<fy> field_1090;

   public class_362(Context var1, class_548 var2, class_229 var3, class_432.class_1521 var4, class_437.class_1183 var5) {
      this(var4, var5, new class_430(var1, var2, var3, new class_378(), var4));
   }

   class_362(class_432.class_1521 var1, class_437.class_1183 var2, class_430 var3) {
      this.field_1085 = new Object();
      this.field_1087 = var1;
      this.field_1088 = var1.field_4105;
      this.field_1086 = var2;
      this.field_1089 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fm) com.google.android.gms.internal.fc$a
   // $FF: synthetic method
   static class_437.class_1183 method_2468(class_362 var0) {
      return var0.field_1086;
   }

   // $FF: renamed from: s (int) com.google.android.gms.internal.fy
   private class_432 method_2469(int var1) {
      return new class_432(this.field_1087.field_4104.field_1464, (class_371)null, (List)null, var1, (List)null, (List)null, this.field_1088.orientation, this.field_1088.field_1440, this.field_1087.field_4104.field_1467, false, (class_447)null, (class_42)null, (String)null, (class_446)null, (class_445)null, this.field_1088.field_1448, this.field_1087.field_4099, this.field_1088.field_1446, this.field_1087.field_4102, this.field_1088.field_1451, this.field_1088.field_1452, this.field_1087.field_4100, (class_238.class_1220)null);
   }

   // $FF: renamed from: cx () void
   public void method_2464() {
      // $FF: Couldn't be decompiled
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }
}
