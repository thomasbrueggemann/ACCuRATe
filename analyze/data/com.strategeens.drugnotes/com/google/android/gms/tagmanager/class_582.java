package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_580;
import com.google.android.gms.tagmanager.class_677;
import com.google.android.gms.tagmanager.class_79;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.i
class class_582 extends class_580 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2685;
   private static final String URL;
   private static final String aqf;
   private static final String aqg;
   static final String aqh;
   private static final Set<String> aqi;
   private final class_582.class_1666 aqj;
   private final Context mContext;

   static {
      field_2685 = class_520.field_2259.toString();
      URL = class_519.field_2141.toString();
      aqf = class_519.field_1999.toString();
      aqg = class_519.field_2140.toString();
      aqh = "gtm_" + field_2685 + "_unrepeatable";
      aqi = new HashSet();
   }

   public class_582(final Context var1) {
      this(var1, new class_582.class_1666() {
         // $FF: renamed from: pf () com.google.android.gms.tagmanager.aq
         public class_79 method_932() {
            return class_677.method_3856(var1);
         }
      });
   }

   class_582(Context var1, class_582.class_1666 var2) {
      String var3 = field_2685;
      String[] var4 = new String[]{URL};
      super(var3, var4);
      this.aqj = var2;
      this.mContext = var1;
   }

   // $FF: renamed from: cl (java.lang.String) boolean
   private boolean method_3457(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: D (java.util.Map) void
   public void method_3454(Map<String, class_57.class_1084> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cm (java.lang.String) boolean
   boolean method_3458(String var1) {
      return this.mContext.getSharedPreferences(aqh, 0).contains(var1);
   }

   // $FF: renamed from: cn (java.lang.String) boolean
   boolean method_3459(String var1) {
      return aqi.contains(var1);
   }

   public interface class_1666 {
      // $FF: renamed from: pf () com.google.android.gms.tagmanager.aq
      class_79 method_932();
   }
}
