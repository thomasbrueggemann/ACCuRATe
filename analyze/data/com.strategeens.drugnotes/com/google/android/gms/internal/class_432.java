package com.google.android.gms.internal;

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fy
@ey
public final class class_432 {
   public final int errorCode;
   public final int orientation;
   // $FF: renamed from: qA long
   public final long field_1386;
   // $FF: renamed from: qP com.google.android.gms.internal.cq
   public final class_447 field_1387;
   // $FF: renamed from: qQ com.google.android.gms.internal.cz
   public final class_42 field_1388;
   // $FF: renamed from: qR java.lang.String
   public final String field_1389;
   // $FF: renamed from: qS com.google.android.gms.internal.ct
   public final class_445 field_1390;
   // $FF: renamed from: qw java.util.List
   public final List<String> field_1391;
   // $FF: renamed from: qx java.util.List
   public final List<String> field_1392;
   // $FF: renamed from: se com.google.android.gms.internal.gu
   public final class_371 field_1393;
   // $FF: renamed from: tL com.google.android.gms.internal.av
   public final class_218 field_1394;
   // $FF: renamed from: tO java.lang.String
   public final String field_1395;
   // $FF: renamed from: tV long
   public final long field_1396;
   // $FF: renamed from: tW boolean
   public final boolean field_1397;
   // $FF: renamed from: tX long
   public final long field_1398;
   // $FF: renamed from: tY java.util.List
   public final List<String> field_1399;
   // $FF: renamed from: ub java.lang.String
   public final String field_1400;
   // $FF: renamed from: vD org.json.JSONObject
   public final JSONObject field_1401;
   // $FF: renamed from: vE com.google.android.gms.internal.cr
   public final class_446 field_1402;
   // $FF: renamed from: vF com.google.android.gms.internal.ay
   public final class_237 field_1403;
   // $FF: renamed from: vG long
   public final long field_1404;
   // $FF: renamed from: vH long
   public final long field_1405;
   // $FF: renamed from: vI com.google.android.gms.internal.bv$a
   public final class_238.class_1220 field_1406;

   public class_432(av var1, gu var2, List<String> var3, int var4, List<String> var5, List<String> var6, int var7, long var8, String var10, boolean var11, cq var12, cz var13, String var14, cr var15, ct var16, long var17, ay var19, long var20, long var22, long var24, String var26, JSONObject var27, class_238.class_1220 var28) {
      this.field_1394 = var1;
      this.field_1393 = var2;
      List var29;
      if(var3 != null) {
         var29 = Collections.unmodifiableList(var3);
      } else {
         var29 = null;
      }

      this.field_1391 = var29;
      this.errorCode = var4;
      List var30;
      if(var5 != null) {
         var30 = Collections.unmodifiableList(var5);
      } else {
         var30 = null;
      }

      this.field_1392 = var30;
      List var31;
      if(var6 != null) {
         var31 = Collections.unmodifiableList(var6);
      } else {
         var31 = null;
      }

      this.field_1399 = var31;
      this.orientation = var7;
      this.field_1386 = var8;
      this.field_1395 = var10;
      this.field_1397 = var11;
      this.field_1387 = var12;
      this.field_1388 = var13;
      this.field_1389 = var14;
      this.field_1402 = var15;
      this.field_1390 = var16;
      this.field_1398 = var17;
      this.field_1403 = var19;
      this.field_1396 = var20;
      this.field_1404 = var22;
      this.field_1405 = var24;
      this.field_1400 = var26;
      this.field_1401 = var27;
      this.field_1406 = var28;
   }

   public class_432(class_432.class_1521 var1, class_371 var2, class_447 var3, class_42 var4, String var5, class_445 var6, class_238.class_1220 var7) {
      this(var1.field_4104.field_1464, var2, var1.field_4105.field_1441, var1.errorCode, var1.field_4105.field_1442, var1.field_4105.field_1449, var1.field_4105.orientation, var1.field_4105.field_1440, var1.field_4104.field_1467, var1.field_4105.field_1447, var3, var4, var5, var1.field_4101, var6, var1.field_4105.field_1448, var1.field_4099, var1.field_4105.field_1446, var1.field_4102, var1.field_4103, var1.field_4105.field_1452, var1.field_4100, var7);
   }

   @ey
   public static final class class_1521 {
      public final int errorCode;
      // $FF: renamed from: lS com.google.android.gms.internal.ay
      public final class_237 field_4099;
      // $FF: renamed from: vD org.json.JSONObject
      public final JSONObject field_4100;
      // $FF: renamed from: vE com.google.android.gms.internal.cr
      public final class_446 field_4101;
      // $FF: renamed from: vG long
      public final long field_4102;
      // $FF: renamed from: vH long
      public final long field_4103;
      // $FF: renamed from: vJ com.google.android.gms.internal.fh
      public final class_440 field_4104;
      // $FF: renamed from: vK com.google.android.gms.internal.fj
      public final class_438 field_4105;

      public class_1521(class_440 var1, class_438 var2, class_446 var3, class_237 var4, int var5, long var6, long var8, JSONObject var10) {
         this.field_4104 = var1;
         this.field_4105 = var2;
         this.field_4101 = var3;
         this.field_4099 = var4;
         this.errorCode = var5;
         this.field_4102 = var6;
         this.field_4103 = var8;
         this.field_4100 = var10;
      }
   }
}
