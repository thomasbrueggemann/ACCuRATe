package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_637;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.az
class class_590 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2693;
   private static final String arJ;
   private static final String arK;
   private static final String arL;
   private static final String arp;

   static {
      field_2693 = class_520.field_2239.toString();
      arp = class_519.field_2010.toString();
      arJ = class_519.field_2100.toString();
      arK = class_519.field_2104.toString();
      arL = class_519.field_2021.toString();
   }

   public class_590() {
      String var1 = field_2693;
      String[] var2 = new String[]{arp};
      super(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.az$a, java.util.Set) java.lang.String
   private String method_3475(String var1, class_590.class_1667 var2, Set<Character> var3) {
      switch(null.arM[var2.ordinal()]) {
      case 1:
         try {
            String var9 = class_637.method_3615(var1);
            return var9;
         } catch (UnsupportedEncodingException var10) {
            class_613.method_3495("Joiner: unsupported encoding", var10);
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
   private void method_3476(StringBuilder var1, String var2, class_590.class_1667 var3, Set<Character> var4) {
      var1.append(this.method_3475(var2, var3, var4));
   }

   // $FF: renamed from: a (java.util.Set, java.lang.String) void
   private void method_3477(Set<Character> var1, String var2) {
      for(int var3 = 0; var3 < var2.length(); ++var3) {
         var1.add(Character.valueOf(var2.charAt(var3)));
      }

   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(arp);
      if(var2 == null) {
         return class_635.method_3594();
      } else {
         class_57.class_1084 var3 = (class_57.class_1084)var1.get(arJ);
         String var4;
         if(var3 != null) {
            var4 = class_635.method_3579(var3);
         } else {
            var4 = "";
         }

         class_57.class_1084 var5 = (class_57.class_1084)var1.get(arK);
         String var6;
         if(var5 != null) {
            var6 = class_635.method_3579(var5);
         } else {
            var6 = "=";
         }

         class_590.class_1667 var7 = class_590.class_1667.arN;
         class_57.class_1084 var8 = (class_57.class_1084)var1.get(arL);
         class_590.class_1667 var9;
         HashSet var10;
         if(var8 != null) {
            String var23 = class_635.method_3579(var8);
            if("url".equals(var23)) {
               var9 = class_590.class_1667.arO;
               var10 = null;
            } else {
               if(!"backslash".equals(var23)) {
                  class_613.method_3491("Joiner: unsupported escape type: " + var23);
                  return class_635.method_3594();
               }

               var9 = class_590.class_1667.arP;
               var10 = new HashSet();
               this.method_3477(var10, var4);
               this.method_3477(var10, var6);
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
            class_57.class_1084[] var18 = var2.field_734;
            int var19 = var18.length;

            for(int var20 = 0; var20 < var19; var17 = false) {
               class_57.class_1084 var21 = var18[var20];
               if(!var17) {
                  var11.append(var4);
               }

               this.method_3476(var11, class_635.method_3579(var21), var9, var10);
               ++var20;
            }

            return class_635.method_3597(var11.toString());
         case 3:
            for(int var12 = 0; var12 < var2.field_735.length; ++var12) {
               if(var12 > 0) {
                  var11.append(var4);
               }

               String var13 = class_635.method_3579(var2.field_735[var12]);
               String var14 = class_635.method_3579(var2.field_736[var12]);
               this.method_3476(var11, var13, var9, var10);
               var11.append(var6);
               this.method_3476(var11, var14, var9, var10);
            }

            return class_635.method_3597(var11.toString());
         default:
            this.method_3476(var11, class_635.method_3579(var2), var9, var10);
            return class_635.method_3597(var11.toString());
         }
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }

   private static enum class_1667 {
      arN,
      arO,
      arP;

      static {
         class_590.class_1667[] var0 = new class_590.class_1667[]{arN, arO, arP};
      }
   }
}
