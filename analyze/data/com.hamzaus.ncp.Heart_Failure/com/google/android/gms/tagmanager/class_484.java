package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_482;
import com.google.android.gms.tagmanager.class_576;
import com.google.android.gms.tagmanager.class_74;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.i
class class_484 extends class_482 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2842;
   private static final String URL;
   private static final String aej;
   private static final String aek;
   static final String ael;
   private static final Set<String> aem;
   private final class_484.class_1278 aen;
   private final Context mContext;

   static {
      field_2842 = class_445.field_2448.toString();
      URL = class_444.field_2373.toString();
      aej = class_444.field_2197.toString();
      aek = class_444.field_2372.toString();
      ael = "gtm_" + field_2842 + "_unrepeatable";
      aem = new HashSet();
   }

   public class_484(final Context var1) {
      this(var1, new class_484.class_1278() {
         // $FF: renamed from: ld () com.google.android.gms.tagmanager.aq
         public class_74 method_761() {
            return class_576.method_3252(var1);
         }
      });
   }

   class_484(Context var1, class_484.class_1278 var2) {
      String var3 = field_2842;
      String[] var4 = new String[]{URL};
      super(var3, var4);
      this.aen = var2;
      this.mContext = var1;
   }

   // $FF: renamed from: bB (java.lang.String) boolean
   private boolean method_2889(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bC (java.lang.String) boolean
   boolean method_2890(String var1) {
      return this.mContext.getSharedPreferences(ael, 0).contains(var1);
   }

   // $FF: renamed from: bD (java.lang.String) boolean
   boolean method_2891(String var1) {
      return aem.contains(var1);
   }

   // $FF: renamed from: y (java.util.Map) void
   public void method_2886(Map<String, class_52.class_816> param1) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1278 {
      // $FF: renamed from: ld () com.google.android.gms.tagmanager.aq
      class_74 method_761();
   }
}
