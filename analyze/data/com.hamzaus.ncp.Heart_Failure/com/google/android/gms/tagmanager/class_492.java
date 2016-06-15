package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_538;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.az
class class_492 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2850;
   private static final String afR;
   private static final String afS;
   private static final String afT;
   private static final String afv;

   static {
      field_2850 = class_445.field_2435.toString();
      afv = class_444.field_2234.toString();
      afR = class_444.field_2263.toString();
      afS = class_444.field_2266.toString();
      afT = class_444.field_2292.toString();
   }

   public class_492() {
      String var1 = field_2850;
      String[] var2 = new String[]{afv};
      super(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.az$a, java.util.Set) java.lang.String
   private String method_2901(String var1, class_492.class_1279 var2, Set<Character> var3) {
      switch(null.afU[var2.ordinal()]) {
      case 1:
         try {
            String var9 = class_538.method_3034(var1);
            return var9;
         } catch (UnsupportedEncodingException var10) {
            class_515.method_2920("Joiner: unsupported encoding", var10);
            return var1;
         }
      case 2:
         String var4 = var1.replace("\\", "\\\\");
         Iterator var5 = var3.iterator();

         String var6;
         String var7;
         for(var6 = var4; var5.hasNext(); var6 = var6.replace(var7, "\\" + var7)) {
            var7 = ((Character)var5.next()).toString();
         }

         return var6;
      default:
         return var1;
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, com.google.android.gms.tagmanager.az$a, java.util.Set) void
   private void method_2902(StringBuilder var1, String var2, class_492.class_1279 var3, Set<Character> var4) {
      var1.append(this.method_2901(var2, var3, var4));
   }

   // $FF: renamed from: a (java.util.Set, java.lang.String) void
   private void method_2903(Set<Character> var1, String var2) {
      for(int var3 = 0; var3 < var2.length(); ++var3) {
         var1.add(Character.valueOf(var2.charAt(var3)));
      }

   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(afv);
      if(var2 == null) {
         return class_537.method_3020();
      } else {
         class_52.class_816 var3 = (class_52.class_816)var1.get(afR);
         String var4;
         if(var3 != null) {
            var4 = class_537.method_3009(var3);
         } else {
            var4 = "";
         }

         class_52.class_816 var5 = (class_52.class_816)var1.get(afS);
         String var6;
         if(var5 != null) {
            var6 = class_537.method_3009(var5);
         } else {
            var6 = "=";
         }

         class_492.class_1279 var7 = class_492.class_1279.afV;
         class_52.class_816 var8 = (class_52.class_816)var1.get(afT);
         class_492.class_1279 var9;
         HashSet var10;
         if(var8 != null) {
            String var23 = class_537.method_3009(var8);
            if("url".equals(var23)) {
               var9 = class_492.class_1279.afW;
               var10 = null;
            } else {
               if(!"backslash".equals(var23)) {
                  class_515.method_2916("Joiner: unsupported escape type: " + var23);
                  return class_537.method_3020();
               }

               var9 = class_492.class_1279.afX;
               var10 = new HashSet();
               this.method_2903(var10, var4);
               this.method_2903(var10, var6);
               var10.remove(Character.valueOf('\\'));
            }
         } else {
            var9 = var7;
            var10 = null;
         }

         StringBuilder var11 = new StringBuilder();
         switch(var2.type) {
         case 2:
            boolean var17 = true;
            class_52.class_816[] var18 = var2.field_886;
            int var19 = var18.length;

            for(int var20 = 0; var20 < var19; var17 = false) {
               class_52.class_816 var21 = var18[var20];
               if(!var17) {
                  var11.append(var4);
               }

               this.method_2902(var11, class_537.method_3009(var21), var9, var10);
               ++var20;
            }

            return class_537.method_3027(var11.toString());
         case 3:
            for(int var12 = 0; var12 < var2.field_887.length; ++var12) {
               if(var12 > 0) {
                  var11.append(var4);
               }

               String var13 = class_537.method_3009(var2.field_887[var12]);
               String var14 = class_537.method_3009(var2.field_888[var12]);
               this.method_2902(var11, var13, var9, var10);
               var11.append(var6);
               this.method_2902(var11, var14, var9, var10);
            }

            return class_537.method_3027(var11.toString());
         default:
            this.method_2902(var11, class_537.method_3009(var2), var9, var10);
            return class_537.method_3027(var11.toString());
         }
      }
   }

   private static enum class_1279 {
      afV,
      afW,
      afX;

      static {
         class_492.class_1279[] var0 = new class_492.class_1279[]{afV, afW, afX};
      }
   }
}
