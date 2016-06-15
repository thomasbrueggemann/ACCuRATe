package com.google.android.gms.internal;

import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dk
@ey
public class class_477 {
   // $FF: renamed from: rs boolean
   private final boolean field_1636;
   // $FF: renamed from: rt boolean
   private final boolean field_1637;
   // $FF: renamed from: ru boolean
   private final boolean field_1638;
   // $FF: renamed from: rv boolean
   private final boolean field_1639;
   // $FF: renamed from: rw boolean
   private final boolean field_1640;

   private class_477(class_477.class_1508 var1) {
      this.field_1636 = var1.field_3046;
      this.field_1637 = var1.field_3047;
      this.field_1638 = var1.field_3048;
      this.field_1639 = var1.field_3049;
      this.field_1640 = var1.field_3050;
   }

   // $FF: synthetic method
   class_477(class_477.class_1508 var1, Object var2) {
      this(var1);
   }

   public JSONObject toJson() {
      try {
         JSONObject var2 = (new JSONObject()).put("sms", this.field_1636).put("tel", this.field_1637).put("calendar", this.field_1638).put("storePicture", this.field_1639).put("inlineVideo", this.field_1640);
         return var2;
      } catch (JSONException var3) {
         class_368.method_2508("Error occured while obtaining the MRAID capabilities.", var3);
         return null;
      }
   }

   public static final class class_1508 {
      // $FF: renamed from: rs boolean
      private boolean field_3046;
      // $FF: renamed from: rt boolean
      private boolean field_3047;
      // $FF: renamed from: ru boolean
      private boolean field_3048;
      // $FF: renamed from: rv boolean
      private boolean field_3049;
      // $FF: renamed from: rw boolean
      private boolean field_3050;

      // $FF: renamed from: bU () com.google.android.gms.internal.dk
      public class_477 method_3915() {
         return new class_477(this);
      }

      // $FF: renamed from: k (boolean) com.google.android.gms.internal.dk$a
      public class_477.class_1508 method_3916(boolean var1) {
         this.field_3046 = var1;
         return this;
      }

      // $FF: renamed from: l (boolean) com.google.android.gms.internal.dk$a
      public class_477.class_1508 method_3917(boolean var1) {
         this.field_3047 = var1;
         return this;
      }

      // $FF: renamed from: m (boolean) com.google.android.gms.internal.dk$a
      public class_477.class_1508 method_3918(boolean var1) {
         this.field_3048 = var1;
         return this;
      }

      // $FF: renamed from: n (boolean) com.google.android.gms.internal.dk$a
      public class_477.class_1508 method_3919(boolean var1) {
         this.field_3049 = var1;
         return this;
      }

      // $FF: renamed from: o (boolean) com.google.android.gms.internal.dk$a
      public class_477.class_1508 method_3920(boolean var1) {
         this.field_3050 = var1;
         return this;
      }
   }
}
