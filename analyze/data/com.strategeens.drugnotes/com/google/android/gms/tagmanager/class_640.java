package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bk;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.ck;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_562;
import com.google.android.gms.tagmanager.class_563;
import com.google.android.gms.tagmanager.class_564;
import com.google.android.gms.tagmanager.class_565;
import com.google.android.gms.tagmanager.class_566;
import com.google.android.gms.tagmanager.class_567;
import com.google.android.gms.tagmanager.class_568;
import com.google.android.gms.tagmanager.class_569;
import com.google.android.gms.tagmanager.class_570;
import com.google.android.gms.tagmanager.class_571;
import com.google.android.gms.tagmanager.class_572;
import com.google.android.gms.tagmanager.class_573;
import com.google.android.gms.tagmanager.class_574;
import com.google.android.gms.tagmanager.class_575;
import com.google.android.gms.tagmanager.class_576;
import com.google.android.gms.tagmanager.class_577;
import com.google.android.gms.tagmanager.class_578;
import com.google.android.gms.tagmanager.class_579;
import com.google.android.gms.tagmanager.class_581;
import com.google.android.gms.tagmanager.class_582;
import com.google.android.gms.tagmanager.class_583;
import com.google.android.gms.tagmanager.class_584;
import com.google.android.gms.tagmanager.class_585;
import com.google.android.gms.tagmanager.class_586;
import com.google.android.gms.tagmanager.class_587;
import com.google.android.gms.tagmanager.class_588;
import com.google.android.gms.tagmanager.class_589;
import com.google.android.gms.tagmanager.class_590;
import com.google.android.gms.tagmanager.class_591;
import com.google.android.gms.tagmanager.class_592;
import com.google.android.gms.tagmanager.class_593;
import com.google.android.gms.tagmanager.class_594;
import com.google.android.gms.tagmanager.class_595;
import com.google.android.gms.tagmanager.class_598;
import com.google.android.gms.tagmanager.class_599;
import com.google.android.gms.tagmanager.class_600;
import com.google.android.gms.tagmanager.class_601;
import com.google.android.gms.tagmanager.class_602;
import com.google.android.gms.tagmanager.class_604;
import com.google.android.gms.tagmanager.class_605;
import com.google.android.gms.tagmanager.class_606;
import com.google.android.gms.tagmanager.class_607;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_631;
import com.google.android.gms.tagmanager.class_632;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_637;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_673;
import com.google.android.gms.tagmanager.class_82;
import com.google.android.gms.tagmanager.class_83;
import com.google.android.gms.tagmanager.class_88;
import com.google.android.gms.tagmanager.class_90;
import com.google.android.gms.tagmanager.cn;
import com.google.android.gms.tagmanager.cs;
import com.google.android.gms.tagmanager.dl;
import com.google.android.gms.tagmanager.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.ct
class class_640 {
   private static final bz<class_57.class_1084> atb = new class_631(class_635.method_3594(), true);
   private final DataLayer aqn;
   private final class_639.class_1684 atc;
   private final class_88 atd;
   private final Map<String, aj> ate;
   private final Map<String, aj> atf;
   private final Map<String, aj> atg;
   private final k<class_639.class_1682, bz<class_57.class_1084>> ath;
   private final k<String, class_640.class_1120> ati;
   private final Set<class_639.class_1686> atj;
   private final Map<String, class_640.class_1122> atk;
   private volatile String atl;
   private int atm;

   public class_640(Context var1, class_639.class_1684 var2, DataLayer var3, class_564.class_1657 var4, class_564.class_1657 var5, class_88 var6) {
      if(var2 == null) {
         throw new NullPointerException("resource cannot be null");
      } else {
         this.atc = var2;
         this.atj = new HashSet(var2.method_5556());
         this.aqn = var3;
         this.atd = var6;
         class_673.class_1689 var7 = new class_673.class_1689() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a, com.google.android.gms.tagmanager.bz) int
            public int method_2316(class_639.class_1682 var1, bz<class_57.class_1084> var2) {
               return ((class_57.class_1084)var2.getObject()).rY();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.method_2316((class_639.class_1682)var1, (class_631)var2);
            }
         };
         this.ath = (new class_673()).method_3825(1048576, var7);
         class_673.class_1689 var8 = new class_673.class_1689() {
            // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.ct$b) int
            public int method_2317(String var1, class_640.class_1120 var2) {
               return var1.length() + var2.getSize();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.method_2317((String)var1, (class_640.class_1120)var2);
            }
         };
         this.ati = (new class_673()).method_3825(1048576, var8);
         this.ate = new HashMap();
         this.method_3648(new class_582(var1));
         this.method_3648(new class_564(var5));
         this.method_3648(new class_581(var3));
         this.method_3648(new class_583(var1, var3));
         this.atf = new HashMap();
         this.method_3649(new class_598());
         this.method_3649(new class_599());
         this.method_3649(new class_600());
         this.method_3649(new class_604());
         this.method_3649(new class_605());
         this.method_3649(new class_606());
         this.method_3649(new class_607());
         this.method_3649(new class_602());
         this.method_3649(new class_601());
         this.atg = new HashMap();
         this.method_3647(new class_568(var1));
         this.method_3647(new class_567(var1));
         this.method_3647(new class_569(var1));
         this.method_3647(new class_571(var1));
         this.method_3647(new class_570(var1));
         this.method_3647(new class_572(var1));
         this.method_3647(new class_565());
         this.method_3647(new class_566(this.atc.getVersion()));
         this.method_3647(new class_564(var4));
         this.method_3647(new class_563(var3));
         this.method_3647(new class_562(var1));
         this.method_3647(new class_574());
         this.method_3647(new class_573());
         this.method_3647(new class_576(this));
         this.method_3647(new class_575());
         this.method_3647(new class_592());
         this.method_3647(new class_591(var1));
         this.method_3647(new class_590());
         this.method_3647(new class_595());
         this.method_3647(new class_593());
         this.method_3647(new class_594(var1));
         this.method_3647(new class_586());
         this.method_3647(new class_587());
         this.method_3647(new class_588());
         this.method_3647(new class_589());
         this.method_3647(new class_585(var1));
         this.method_3647(new class_578());
         this.method_3647(new class_577());
         this.method_3647(new class_584());
         this.method_3647(new class_579());
         this.atk = new HashMap();
         Iterator var9 = this.atj.iterator();

         while(var9.hasNext()) {
            class_639.class_1686 var14 = (class_639.class_1686)var9.next();
            if(var6.method_435()) {
               method_3638(var14.method_5547(), var14.method_5548(), "add macro");
               method_3638(var14.method_5542(), var14.method_5549(), "remove macro");
               method_3638(var14.method_5545(), var14.method_5540(), "add tag");
               method_3638(var14.method_5546(), var14.method_5541(), "remove tag");
            }

            for(int var15 = 0; var15 < var14.method_5547().size(); ++var15) {
               class_639.class_1682 var20 = (class_639.class_1682)var14.method_5547().get(var15);
               String var21 = "Unknown";
               if(var6.method_435() && var15 < var14.method_5548().size()) {
                  var21 = (String)var14.method_5548().get(var15);
               }

               class_640.class_1122 var22 = method_3640(this.atk, method_3641(var20));
               var22.method_2695(var14);
               var22.method_2693(var14, var20);
               var22.method_2694(var14, var21);
            }

            for(int var16 = 0; var16 < var14.method_5542().size(); ++var16) {
               class_639.class_1682 var17 = (class_639.class_1682)var14.method_5542().get(var16);
               String var18 = "Unknown";
               if(var6.method_435() && var16 < var14.method_5549().size()) {
                  var18 = (String)var14.method_5549().get(var16);
               }

               class_640.class_1122 var19 = method_3640(this.atk, method_3641(var17));
               var19.method_2695(var14);
               var19.method_2696(var14, var17);
               var19.method_2697(var14, var18);
            }
         }

         Iterator var10 = this.atc.method_5557().entrySet().iterator();

         while(var10.hasNext()) {
            Entry var11 = (Entry)var10.next();
            Iterator var12 = ((List)var11.getValue()).iterator();

            while(var12.hasNext()) {
               class_639.class_1682 var13 = (class_639.class_1682)var12.next();
               if(!class_635.method_3583((class_57.class_1084)var13.method_5511().get(class_519.field_2072.toString())).booleanValue()) {
                  method_3640(this.atk, (String)var11.getKey()).method_2698(var13);
               }
            }
         }

      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set, com.google.android.gms.tagmanager.dl) com.google.android.gms.tagmanager.bz
   private bz<class_57.class_1084> method_3633(class_57.class_1084 var1, Set<String> var2, dl var3) {
      if(!var1.field_732) {
         return new class_631(var1, true);
      } else {
         switch(var1.type) {
         case 2:
            class_57.class_1084 var14 = class_639.method_3631(var1);
            var14.field_734 = new class_57.class_1084[var1.field_734.length];

            for(int var15 = 0; var15 < var1.field_734.length; ++var15) {
               class_631 var16 = this.method_3633(var1.field_734[var15], var2, var3.method_426(var15));
               if(var16 == atb) {
                  return atb;
               }

               var14.field_734[var15] = (class_57.class_1084)var16.getObject();
            }

            return new class_631(var14, false);
         case 3:
            class_57.class_1084 var10 = class_639.method_3631(var1);
            if(var1.field_735.length != var1.field_736.length) {
               class_613.method_3491("Invalid serving value: " + var1.toString());
               return atb;
            } else {
               var10.field_735 = new class_57.class_1084[var1.field_735.length];
               var10.field_736 = new class_57.class_1084[var1.field_735.length];

               for(int var11 = 0; var11 < var1.field_735.length; ++var11) {
                  class_631 var12 = this.method_3633(var1.field_735[var11], var2, var3.method_427(var11));
                  class_631 var13 = this.method_3633(var1.field_736[var11], var2, var3.method_428(var11));
                  if(var12 == atb || var13 == atb) {
                     return atb;
                  }

                  var10.field_735[var11] = (class_57.class_1084)var12.getObject();
                  var10.field_736[var11] = (class_57.class_1084)var13.getObject();
               }

               return new class_631(var10, false);
            }
         case 4:
            if(var2.contains(var1.field_737)) {
               class_613.method_3491("Macro cycle detected.  Current macro reference: " + var1.field_737 + "." + "  Previous macro references: " + var2.toString() + ".");
               return atb;
            }

            var2.add(var1.field_737);
            class_631 var8 = class_637.method_3614(this.method_3634(var1.field_737, var2, var3.method_430()), var1.field_731);
            var2.remove(var1.field_737);
            return var8;
         case 5:
         case 6:
         default:
            class_613.method_3491("Unknown type: " + var1.type);
            return atb;
         case 7:
            class_57.class_1084 var4 = class_639.method_3631(var1);
            var4.field_730 = new class_57.class_1084[var1.field_730.length];

            for(int var5 = 0; var5 < var1.field_730.length; ++var5) {
               class_631 var6 = this.method_3633(var1.field_730[var5], var2, var3.method_429(var5));
               if(var6 == atb) {
                  return atb;
               }

               var4.field_730[var5] = (class_57.class_1084)var6.getObject();
            }

            return new class_631(var4, false);
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, java.util.Set, com.google.android.gms.tagmanager.bk) com.google.android.gms.tagmanager.bz
   private bz<class_57.class_1084> method_3634(String var1, Set<String> var2, bk var3) {
      ++this.atm;
      class_640.class_1120 var4 = (class_640.class_1120)this.ati.get(var1);
      if(var4 != null && !this.atd.method_435()) {
         this.method_3637(var4.method_2692(), var2);
         this.atm += -1;
         return var4.method_2691();
      } else {
         class_640.class_1122 var5 = (class_640.class_1122)this.atk.get(var1);
         if(var5 == null) {
            class_613.method_3491(this.method_3642() + "Invalid macro: " + var1);
            this.atm += -1;
            return atb;
         } else {
            class_631 var6 = this.method_3645(var1, var5.method_2699(), var5.method_2700(), var5.method_2701(), var5.method_2703(), var5.method_2702(), var2, var3.method_407());
            class_639.class_1682 var7;
            if(((Set)var6.getObject()).isEmpty()) {
               var7 = var5.method_2704();
            } else {
               if(((Set)var6.getObject()).size() > 1) {
                  class_613.method_3494(this.method_3642() + "Multiple macros active for macroName " + var1);
               }

               var7 = (class_639.class_1682)((Set)var6.getObject()).iterator().next();
            }

            if(var7 == null) {
               this.atm += -1;
               return atb;
            } else {
               class_631 var8 = this.method_3635(this.atg, var7, var2, var3.method_406());
               boolean var9;
               if(var6.method_3564() && var8.method_3564()) {
                  var9 = true;
               } else {
                  var9 = false;
               }

               class_631 var10;
               if(var8 == atb) {
                  var10 = atb;
               } else {
                  var10 = new class_631(var8.getObject(), var9);
               }

               class_57.class_1084 var11 = var7.method_5512();
               if(var10.method_3564()) {
                  this.ati.method_443(var1, new class_640.class_1120(var10, var11));
               }

               this.method_3637(var11, var2);
               this.atm += -1;
               return var10;
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.cr$a, java.util.Set, com.google.android.gms.tagmanager.ck) com.google.android.gms.tagmanager.bz
   private bz<class_57.class_1084> method_3635(Map<String, aj> var1, class_639.class_1682 var2, Set<String> var3, ck var4) {
      boolean var5 = true;
      class_57.class_1084 var6 = (class_57.class_1084)var2.method_5511().get(class_519.field_2034.toString());
      class_631 var9;
      if(var6 == null) {
         class_613.method_3491("No function id in properties");
         var9 = atb;
      } else {
         String var7 = var6.field_727;
         class_561 var8 = (class_561)var1.get(var7);
         if(var8 == null) {
            class_613.method_3491(var7 + " has no backing implementation.");
            return atb;
         }

         var9 = (class_631)this.ath.get(var2);
         if(var9 == null || this.atd.method_435()) {
            HashMap var10 = new HashMap();
            Iterator var11 = var2.method_5511().entrySet().iterator();

            boolean var12;
            boolean var17;
            for(var12 = var5; var11.hasNext(); var12 = var17) {
               Entry var14 = (Entry)var11.next();
               class_83 var15 = var4.method_424((String)var14.getKey());
               class_631 var16 = this.method_3633((class_57.class_1084)var14.getValue(), var3, var15.method_422((class_57.class_1084)var14.getValue()));
               if(var16 == atb) {
                  return atb;
               }

               if(var16.method_3564()) {
                  var2.method_5510((String)var14.getKey(), (class_57.class_1084)var16.getObject());
                  var17 = var12;
               } else {
                  var17 = false;
               }

               var10.put(var14.getKey(), var16.getObject());
            }

            if(!var8.method_3447(var10.keySet())) {
               class_613.method_3491("Incorrect keys for function " + var7 + " required " + var8.method_3449() + " had " + var10.keySet());
               return atb;
            }

            if(!var12 || !var8.method_3450()) {
               var5 = false;
            }

            class_631 var13 = new class_631(var8.method_3446(var10), var5);
            if(var5) {
               this.ath.method_443(var2, var13);
            }

            var4.method_425((class_57.class_1084)var13.getObject());
            return var13;
         }
      }

      return var9;
   }

   // $FF: renamed from: a (java.util.Set, java.util.Set, com.google.android.gms.tagmanager.ct$a, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
   private bz<Set<class_639.class_1682>> method_3636(Set<class_639.class_1686> var1, Set<String> var2, class_640.class_1121 var3, cs var4) {
      HashSet var5 = new HashSet();
      HashSet var6 = new HashSet();
      Iterator var7 = var1.iterator();

      boolean var8;
      boolean var13;
      for(var8 = true; var7.hasNext(); var8 = var13) {
         class_639.class_1686 var10 = (class_639.class_1686)var7.next();
         class_82 var11 = var4.method_432();
         class_631 var12 = this.method_3644(var10, var2, var11);
         if(((Boolean)var12.getObject()).booleanValue()) {
            var3.method_188(var10, var5, var6, var11);
         }

         if(var8 && var12.method_3564()) {
            var13 = true;
         } else {
            var13 = false;
         }
      }

      var5.removeAll(var6);
      var4.method_431(var5);
      return new class_631(var5, var8);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set) void
   private void method_3637(class_57.class_1084 var1, Set<String> var2) {
      if(var1 != null) {
         class_631 var3 = this.method_3633(var1, var2, new class_632());
         if(var3 != atb) {
            Object var4 = class_635.method_3584((class_57.class_1084)var3.getObject());
            if(var4 instanceof Map) {
               Map var8 = (Map)var4;
               this.aqn.push(var8);
               return;
            }

            if(!(var4 instanceof List)) {
               class_613.method_3494("pushAfterEvaluate: value not a Map or List");
               return;
            }

            Iterator var5 = ((List)var4).iterator();

            while(var5.hasNext()) {
               Object var6 = var5.next();
               if(var6 instanceof Map) {
                  Map var7 = (Map)var6;
                  this.aqn.push(var7);
               } else {
                  class_613.method_3494("pushAfterEvaluate: value not a Map");
               }
            }
         }
      }

   }

   // $FF: renamed from: a (java.util.List, java.util.List, java.lang.String) void
   private static void method_3638(List<class_639.class_1682> var0, List<String> var1, String var2) {
      if(var0.size() != var1.size()) {
         class_613.method_3492("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
      }

   }

   // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.aj) void
   private static void method_3639(Map<String, aj> var0, aj var1) {
      if(var0.containsKey(var1.method_3448())) {
         throw new IllegalArgumentException("Duplicate function type name: " + var1.method_3448());
      } else {
         var0.put(var1.method_3448(), var1);
      }
   }

   // $FF: renamed from: e (java.util.Map, java.lang.String) com.google.android.gms.tagmanager.ct$c
   private static class_640.class_1122 method_3640(Map<String, class_640.class_1122> var0, String var1) {
      class_640.class_1122 var2 = (class_640.class_1122)var0.get(var1);
      if(var2 == null) {
         var2 = new class_640.class_1122();
         var0.put(var1, var2);
      }

      return var2;
   }

   // $FF: renamed from: h (com.google.android.gms.tagmanager.cr$a) java.lang.String
   private static String method_3641(class_639.class_1682 var0) {
      return class_635.method_3579((class_57.class_1084)var0.method_5511().get(class_519.field_2097.toString()));
   }

   // $FF: renamed from: qF () java.lang.String
   private String method_3642() {
      if(this.atm <= 1) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(Integer.toString(this.atm));

         for(int var3 = 2; var3 < this.atm; ++var3) {
            var1.append(' ');
         }

         var1.append(": ");
         return var1.toString();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a, java.util.Set, com.google.android.gms.tagmanager.ck) com.google.android.gms.tagmanager.bz
   bz<Boolean> method_3643(class_639.class_1682 var1, Set<String> var2, ck var3) {
      class_631 var4 = this.method_3635(this.atf, var1, var2, var3);
      Boolean var5 = class_635.method_3583((class_57.class_1084)var4.getObject());
      var3.method_425(class_635.method_3597(var5));
      return new class_631(var5, var4.method_3564());
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, com.google.android.gms.tagmanager.cn) com.google.android.gms.tagmanager.bz
   bz<Boolean> method_3644(class_639.class_1686 var1, Set<String> var2, cn var3) {
      Iterator var4 = var1.method_5544().iterator();

      boolean var5;
      boolean var9;
      for(var5 = true; var4.hasNext(); var5 = var9) {
         class_631 var8 = this.method_3643((class_639.class_1682)var4.next(), var2, var3.method_416());
         if(((Boolean)var8.getObject()).booleanValue()) {
            var3.method_415(class_635.method_3597(Boolean.valueOf(false)));
            return new class_631(Boolean.valueOf(false), var8.method_3564());
         }

         if(var5 && var8.method_3564()) {
            var9 = true;
         } else {
            var9 = false;
         }
      }

      Iterator var6 = var1.method_5543().iterator();

      while(true) {
         while(var6.hasNext()) {
            class_631 var7 = this.method_3643((class_639.class_1682)var6.next(), var2, var3.method_417());
            if(!((Boolean)var7.getObject()).booleanValue()) {
               var3.method_415(class_635.method_3597(Boolean.valueOf(false)));
               return new class_631(Boolean.valueOf(false), var7.method_3564());
            }

            if(var5 && var7.method_3564()) {
               var5 = true;
            } else {
               var5 = false;
            }
         }

         var3.method_415(class_635.method_3597(Boolean.valueOf(true)));
         return new class_631(Boolean.valueOf(true), var5);
      }
   }

   // $FF: renamed from: a (java.lang.String, java.util.Set, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Set, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
   bz<Set<class_639.class_1682>> method_3645(String var1, Set<class_639.class_1686> var2, final Map<class_639.class_1686, List<class_639.class_1682>> var3, final Map<class_639.class_1686, List<String>> var4, final Map<class_639.class_1686, List<class_639.class_1682>> var5, final Map<class_639.class_1686, List<String>> var6, Set<String> var7, cs var8) {
      return this.method_3636(var2, var7, new class_640.class_1121() {
         // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
         public void method_188(class_639.class_1686 var1, Set<class_639.class_1682> var2, Set<class_639.class_1682> var3x, cn var4x) {
            List var5x = (List)var3.get(var1);
            List var6x = (List)var4.get(var1);
            if(var5x != null) {
               var2.addAll(var5x);
               var4x.method_418().method_423(var5x, var6x);
            }

            List var7 = (List)var5.get(var1);
            List var8 = (List)var6.get(var1);
            if(var7 != null) {
               var3x.addAll(var7);
               var4x.method_419().method_423(var7, var8);
            }

         }
      }, var8);
   }

   // $FF: renamed from: a (java.util.Set, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
   bz<Set<class_639.class_1682>> method_3646(Set<class_639.class_1686> var1, cs var2) {
      return this.method_3636(var1, new HashSet(), new class_640.class_1121() {
         // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
         public void method_188(class_639.class_1686 var1, Set<class_639.class_1682> var2, Set<class_639.class_1682> var3, cn var4) {
            var2.addAll(var1.method_5545());
            var3.addAll(var1.method_5546());
            var4.method_420().method_423(var1.method_5545(), var1.method_5540());
            var4.method_421().method_423(var1.method_5546(), var1.method_5541());
         }
      }, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.aj) void
   void method_3647(class_561 var1) {
      method_3639(this.atg, var1);
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.aj) void
   void method_3648(class_561 var1) {
      method_3639(this.ate, var1);
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.aj) void
   void method_3649(class_561 var1) {
      method_3639(this.atf, var1);
   }

   // $FF: renamed from: cT (java.lang.String) com.google.android.gms.tagmanager.bz
   public bz<class_57.class_1084> method_3650(String var1) {
      this.atm = 0;
      class_90 var2 = this.atd.method_433(var1);
      class_631 var3 = this.method_3634(var1, new HashSet(), var2.method_438());
      var2.method_440();
      return var3;
   }

   // $FF: renamed from: cU (java.lang.String) void
   void method_3651(String var1) {
      synchronized(this){}

      try {
         this.atl = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: cr (java.lang.String) void
   public void method_3652(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: l (java.util.List) void
   public void method_3653(List<class_55.class_1258> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: qE () java.lang.String
   String method_3654() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.atl;
      } finally {
         ;
      }

      return var2;
   }

   interface class_1121 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
      void method_188(class_639.class_1686 var1, Set<class_639.class_1682> var2, Set<class_639.class_1682> var3, cn var4);
   }

   private static class class_1120 {
      private class_57.class_1084 asN;
      private bz<class_57.class_1084> ats;

      public class_1120(bz<class_57.class_1084> var1, class_57.class_1084 var2) {
         this.ats = var1;
         this.asN = var2;
      }

      public int getSize() {
         int var1 = ((class_57.class_1084)this.ats.getObject()).rY();
         int var2;
         if(this.asN == null) {
            var2 = 0;
         } else {
            var2 = this.asN.rY();
         }

         return var2 + var1;
      }

      // $FF: renamed from: qG () com.google.android.gms.tagmanager.bz
      public bz<class_57.class_1084> method_2691() {
         return this.ats;
      }

      // $FF: renamed from: qm () com.google.android.gms.internal.d$a
      public class_57.class_1084 method_2692() {
         return this.asN;
      }
   }

   private static class class_1122 {
      private final Set<class_639.class_1686> atj = new HashSet();
      private final Map<class_639.class_1686, List<class_639.class_1682>> att = new HashMap();
      private final Map<class_639.class_1686, List<class_639.class_1682>> atu = new HashMap();
      private final Map<class_639.class_1686, List<String>> atv = new HashMap();
      private final Map<class_639.class_1686, List<String>> atw = new HashMap();
      private class_639.class_1682 atx;

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, com.google.android.gms.tagmanager.cr$a) void
      public void method_2693(class_639.class_1686 var1, class_639.class_1682 var2) {
         Object var3 = (List)this.att.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.att.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.lang.String) void
      public void method_2694(class_639.class_1686 var1, String var2) {
         Object var3 = (List)this.atv.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.atv.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e) void
      public void method_2695(class_639.class_1686 var1) {
         this.atj.add(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e, com.google.android.gms.tagmanager.cr$a) void
      public void method_2696(class_639.class_1686 var1, class_639.class_1682 var2) {
         Object var3 = (List)this.atu.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.atu.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e, java.lang.String) void
      public void method_2697(class_639.class_1686 var1, String var2) {
         Object var3 = (List)this.atw.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.atw.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: i (com.google.android.gms.tagmanager.cr$a) void
      public void method_2698(class_639.class_1682 var1) {
         this.atx = var1;
      }

      // $FF: renamed from: qH () java.util.Set
      public Set<class_639.class_1686> method_2699() {
         return this.atj;
      }

      // $FF: renamed from: qI () java.util.Map
      public Map<class_639.class_1686, List<class_639.class_1682>> method_2700() {
         return this.att;
      }

      // $FF: renamed from: qJ () java.util.Map
      public Map<class_639.class_1686, List<String>> method_2701() {
         return this.atv;
      }

      // $FF: renamed from: qK () java.util.Map
      public Map<class_639.class_1686, List<String>> method_2702() {
         return this.atw;
      }

      // $FF: renamed from: qL () java.util.Map
      public Map<class_639.class_1686, List<class_639.class_1682>> method_2703() {
         return this.atu;
      }

      // $FF: renamed from: qM () com.google.android.gms.tagmanager.cr$a
      public class_639.class_1682 method_2704() {
         return this.atx;
      }
   }
}
