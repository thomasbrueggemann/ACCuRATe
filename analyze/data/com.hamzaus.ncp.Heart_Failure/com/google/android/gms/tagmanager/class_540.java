package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bj;
import com.google.android.gms.tagmanager.by;
import com.google.android.gms.tagmanager.cj;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_465;
import com.google.android.gms.tagmanager.class_466;
import com.google.android.gms.tagmanager.class_467;
import com.google.android.gms.tagmanager.class_468;
import com.google.android.gms.tagmanager.class_469;
import com.google.android.gms.tagmanager.class_470;
import com.google.android.gms.tagmanager.class_471;
import com.google.android.gms.tagmanager.class_472;
import com.google.android.gms.tagmanager.class_473;
import com.google.android.gms.tagmanager.class_474;
import com.google.android.gms.tagmanager.class_475;
import com.google.android.gms.tagmanager.class_476;
import com.google.android.gms.tagmanager.class_477;
import com.google.android.gms.tagmanager.class_478;
import com.google.android.gms.tagmanager.class_479;
import com.google.android.gms.tagmanager.class_480;
import com.google.android.gms.tagmanager.class_481;
import com.google.android.gms.tagmanager.class_483;
import com.google.android.gms.tagmanager.class_484;
import com.google.android.gms.tagmanager.class_485;
import com.google.android.gms.tagmanager.class_486;
import com.google.android.gms.tagmanager.class_487;
import com.google.android.gms.tagmanager.class_488;
import com.google.android.gms.tagmanager.class_489;
import com.google.android.gms.tagmanager.class_490;
import com.google.android.gms.tagmanager.class_491;
import com.google.android.gms.tagmanager.class_492;
import com.google.android.gms.tagmanager.class_493;
import com.google.android.gms.tagmanager.class_494;
import com.google.android.gms.tagmanager.class_495;
import com.google.android.gms.tagmanager.class_496;
import com.google.android.gms.tagmanager.class_499;
import com.google.android.gms.tagmanager.class_500;
import com.google.android.gms.tagmanager.class_501;
import com.google.android.gms.tagmanager.class_502;
import com.google.android.gms.tagmanager.class_503;
import com.google.android.gms.tagmanager.class_505;
import com.google.android.gms.tagmanager.class_506;
import com.google.android.gms.tagmanager.class_507;
import com.google.android.gms.tagmanager.class_508;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_527;
import com.google.android.gms.tagmanager.class_534;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_538;
import com.google.android.gms.tagmanager.class_539;
import com.google.android.gms.tagmanager.class_572;
import com.google.android.gms.tagmanager.class_77;
import com.google.android.gms.tagmanager.class_78;
import com.google.android.gms.tagmanager.class_83;
import com.google.android.gms.tagmanager.class_85;
import com.google.android.gms.tagmanager.cm;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.dj;
import com.google.android.gms.tagmanager.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.cs
class class_540 {
   private static final by<class_52.class_816> ahj = new class_534(class_537.method_3020(), true);
   private final DataLayer aer;
   private final class_539.class_1301 ahk;
   private final class_83 ahl;
   private final Map<String, aj> ahm;
   private final Map<String, aj> ahn;
   private final Map<String, aj> aho;
   private final k<class_539.class_1299, by<class_52.class_816>> ahp;
   private final k<String, class_540.class_1297> ahq;
   private final Set<class_539.class_1303> ahr;
   private final Map<String, class_540.class_1298> ahs;
   private volatile String aht;
   private int ahu;

   public class_540(Context var1, class_539.class_1301 var2, DataLayer var3, class_467.class_1273 var4, class_467.class_1273 var5, class_83 var6) {
      if(var2 == null) {
         throw new NullPointerException("resource cannot be null");
      } else {
         this.ahk = var2;
         this.ahr = new HashSet(var2.method_4220());
         this.aer = var3;
         this.ahl = var6;
         class_572.class_1292 var7 = new class_572.class_1292() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$a, com.google.android.gms.tagmanager.by) int
            public int method_4474(class_539.class_1299 var1, by<class_52.class_816> var2) {
               return ((class_52.class_816)var2.getObject()).nU();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.method_4474((class_539.class_1299)var1, (class_534)var2);
            }
         };
         this.ahp = (new class_572()).method_3193(1048576, var7);
         class_572.class_1292 var8 = new class_572.class_1292() {
            // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.cs$b) int
            public int method_4475(String var1, class_540.class_1297 var2) {
               return var1.length() + var2.getSize();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.method_4475((String)var1, (class_540.class_1297)var2);
            }
         };
         this.ahq = (new class_572()).method_3193(1048576, var8);
         this.ahm = new HashMap();
         this.method_3061(new class_484(var1));
         this.method_3061(new class_467(var5));
         this.method_3061(new class_483(var3));
         this.method_3061(new class_485(var1, var3));
         this.ahn = new HashMap();
         this.method_3063(new class_499());
         this.method_3063(new class_500());
         this.method_3063(new class_501());
         this.method_3063(new class_505());
         this.method_3063(new class_506());
         this.method_3063(new class_507());
         this.method_3063(new class_508());
         this.method_3063(new class_503());
         this.method_3063(new class_502());
         this.aho = new HashMap();
         this.method_3060(new class_471(var1));
         this.method_3060(new class_470(var1));
         this.method_3060(new class_472(var1));
         this.method_3060(new class_474(var1));
         this.method_3060(new class_473(var1));
         this.method_3060(new class_475(var1));
         this.method_3060(new class_468());
         this.method_3060(new class_469(this.ahk.getVersion()));
         this.method_3060(new class_467(var4));
         this.method_3060(new class_466(var3));
         this.method_3060(new class_465(var1));
         this.method_3060(new class_477());
         this.method_3060(new class_476());
         this.method_3060(new class_479(this));
         this.method_3060(new class_478());
         this.method_3060(new class_494());
         this.method_3060(new class_493(var1));
         this.method_3060(new class_492());
         this.method_3060(new class_496());
         this.method_3060(new class_495(var1));
         this.method_3060(new class_487());
         this.method_3060(new class_489());
         this.method_3060(new class_490());
         this.method_3060(new class_491());
         this.method_3060(new class_488(var1));
         this.method_3060(new class_481());
         this.method_3060(new class_480());
         this.method_3060(new class_486());
         this.ahs = new HashMap();
         Iterator var9 = this.ahr.iterator();

         while(var9.hasNext()) {
            class_539.class_1303 var14 = (class_539.class_1303)var9.next();
            if(var6.method_394()) {
               method_3051(var14.method_4205(), var14.method_4206(), "add macro");
               method_3051(var14.method_4200(), var14.method_4207(), "remove macro");
               method_3051(var14.method_4203(), var14.method_4208(), "add tag");
               method_3051(var14.method_4204(), var14.method_4209(), "remove tag");
            }

            for(int var15 = 0; var15 < var14.method_4205().size(); ++var15) {
               class_539.class_1299 var20 = (class_539.class_1299)var14.method_4205().get(var15);
               String var21 = "Unknown";
               if(var6.method_394() && var15 < var14.method_4206().size()) {
                  var21 = (String)var14.method_4206().get(var15);
               }

               class_540.class_1298 var22 = method_3053(this.ahs, method_3054(var20));
               var22.method_4577(var14);
               var22.method_4575(var14, var20);
               var22.method_4576(var14, var21);
            }

            for(int var16 = 0; var16 < var14.method_4200().size(); ++var16) {
               class_539.class_1299 var17 = (class_539.class_1299)var14.method_4200().get(var16);
               String var18 = "Unknown";
               if(var6.method_394() && var16 < var14.method_4207().size()) {
                  var18 = (String)var14.method_4207().get(var16);
               }

               class_540.class_1298 var19 = method_3053(this.ahs, method_3054(var17));
               var19.method_4577(var14);
               var19.method_4578(var14, var17);
               var19.method_4579(var14, var18);
            }
         }

         Iterator var10 = this.ahk.method_4221().entrySet().iterator();

         while(var10.hasNext()) {
            Entry var11 = (Entry)var10.next();
            Iterator var12 = ((List)var11.getValue()).iterator();

            while(var12.hasNext()) {
               class_539.class_1299 var13 = (class_539.class_1299)var12.next();
               if(!class_537.method_3022((class_52.class_816)var13.method_4214().get(class_444.field_2337.toString())).booleanValue()) {
                  method_3053(this.ahs, (String)var11.getKey()).method_4580(var13);
               }
            }
         }

      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set, com.google.android.gms.tagmanager.dj) com.google.android.gms.tagmanager.by
   private by<class_52.class_816> method_3046(class_52.class_816 var1, Set<String> var2, dj var3) {
      if(!var1.field_895) {
         return new class_534(var1, true);
      } else {
         switch(var1.type) {
         case 2:
            class_52.class_816 var14 = class_539.method_3044(var1);
            var14.field_886 = new class_52.class_816[var1.field_886.length];

            for(int var15 = 0; var15 < var1.field_886.length; ++var15) {
               class_534 var16 = this.method_3046(var1.field_886[var15], var2, var3.method_385(var15));
               if(var16 == ahj) {
                  return ahj;
               }

               var14.field_886[var15] = (class_52.class_816)var16.getObject();
            }

            return new class_534(var14, false);
         case 3:
            class_52.class_816 var10 = class_539.method_3044(var1);
            if(var1.field_887.length != var1.field_888.length) {
               class_515.method_2916("Invalid serving value: " + var1.toString());
               return ahj;
            } else {
               var10.field_887 = new class_52.class_816[var1.field_887.length];
               var10.field_888 = new class_52.class_816[var1.field_887.length];

               for(int var11 = 0; var11 < var1.field_887.length; ++var11) {
                  class_534 var12 = this.method_3046(var1.field_887[var11], var2, var3.method_386(var11));
                  class_534 var13 = this.method_3046(var1.field_888[var11], var2, var3.method_387(var11));
                  if(var12 == ahj || var13 == ahj) {
                     return ahj;
                  }

                  var10.field_887[var11] = (class_52.class_816)var12.getObject();
                  var10.field_888[var11] = (class_52.class_816)var13.getObject();
               }

               return new class_534(var10, false);
            }
         case 4:
            if(var2.contains(var1.field_889)) {
               class_515.method_2916("Macro cycle detected.  Current macro reference: " + var1.field_889 + "." + "  Previous macro references: " + var2.toString() + ".");
               return ahj;
            }

            var2.add(var1.field_889);
            class_534 var8 = class_538.method_3033(this.method_3047(var1.field_889, var2, var3.method_389()), var1.field_894);
            var2.remove(var1.field_889);
            return var8;
         case 5:
         case 6:
         default:
            class_515.method_2916("Unknown type: " + var1.type);
            return ahj;
         case 7:
            class_52.class_816 var4 = class_539.method_3044(var1);
            var4.field_893 = new class_52.class_816[var1.field_893.length];

            for(int var5 = 0; var5 < var1.field_893.length; ++var5) {
               class_534 var6 = this.method_3046(var1.field_893[var5], var2, var3.method_388(var5));
               if(var6 == ahj) {
                  return ahj;
               }

               var4.field_893[var5] = (class_52.class_816)var6.getObject();
            }

            return new class_534(var4, false);
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, java.util.Set, com.google.android.gms.tagmanager.bj) com.google.android.gms.tagmanager.by
   private by<class_52.class_816> method_3047(String var1, Set<String> var2, bj var3) {
      ++this.ahu;
      class_540.class_1297 var4 = (class_540.class_1297)this.ahq.get(var1);
      if(var4 != null && !this.ahl.method_394()) {
         this.method_3050(var4.method_4588(), var2);
         this.ahu += -1;
         return var4.method_4587();
      } else {
         class_540.class_1298 var5 = (class_540.class_1298)this.ahs.get(var1);
         if(var5 == null) {
            class_515.method_2916(this.method_3055() + "Invalid macro: " + var1);
            this.ahu += -1;
            return ahj;
         } else {
            class_534 var6 = this.method_3058(var1, var5.method_4581(), var5.method_4582(), var5.method_4583(), var5.method_4585(), var5.method_4584(), var2, var3.method_365());
            class_539.class_1299 var7;
            if(((Set)var6.getObject()).isEmpty()) {
               var7 = var5.method_4586();
            } else {
               if(((Set)var6.getObject()).size() > 1) {
                  class_515.method_2919(this.method_3055() + "Multiple macros active for macroName " + var1);
               }

               var7 = (class_539.class_1299)((Set)var6.getObject()).iterator().next();
            }

            if(var7 == null) {
               this.ahu += -1;
               return ahj;
            } else {
               class_534 var8 = this.method_3048(this.aho, var7, var2, var3.method_364());
               boolean var9;
               if(var6.method_2990() && var8.method_2990()) {
                  var9 = true;
               } else {
                  var9 = false;
               }

               class_534 var10;
               if(var8 == ahj) {
                  var10 = ahj;
               } else {
                  var10 = new class_534(var8.getObject(), var9);
               }

               class_52.class_816 var11 = var7.method_4215();
               if(var10.method_2990()) {
                  this.ahq.method_401(var1, new class_540.class_1297(var10, var11));
               }

               this.method_3050(var11, var2);
               this.ahu += -1;
               return var10;
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.cq$a, java.util.Set, com.google.android.gms.tagmanager.cj) com.google.android.gms.tagmanager.by
   private by<class_52.class_816> method_3048(Map<String, aj> var1, class_539.class_1299 var2, Set<String> var3, cj var4) {
      boolean var5 = true;
      class_52.class_816 var6 = (class_52.class_816)var2.method_4214().get(class_444.field_2301.toString());
      class_534 var9;
      if(var6 == null) {
         class_515.method_2916("No function id in properties");
         var9 = ahj;
      } else {
         String var7 = var6.field_890;
         class_464 var8 = (class_464)var1.get(var7);
         if(var8 == null) {
            class_515.method_2916(var7 + " has no backing implementation.");
            return ahj;
         }

         var9 = (class_534)this.ahp.get(var2);
         if(var9 == null || this.ahl.method_394()) {
            HashMap var10 = new HashMap();
            Iterator var11 = var2.method_4214().entrySet().iterator();

            boolean var12;
            boolean var17;
            for(var12 = var5; var11.hasNext(); var12 = var17) {
               Entry var14 = (Entry)var11.next();
               class_78 var15 = var4.method_383((String)var14.getKey());
               class_534 var16 = this.method_3046((class_52.class_816)var14.getValue(), var3, var15.method_381((class_52.class_816)var14.getValue()));
               if(var16 == ahj) {
                  return ahj;
               }

               if(var16.method_2990()) {
                  var2.method_4213((String)var14.getKey(), (class_52.class_816)var16.getObject());
                  var17 = var12;
               } else {
                  var17 = false;
               }

               var10.put(var14.getKey(), var16.getObject());
            }

            if(!var8.method_2878(var10.keySet())) {
               class_515.method_2916("Incorrect keys for function " + var7 + " required " + var8.method_2880() + " had " + var10.keySet());
               return ahj;
            }

            if(!var12 || !var8.method_2881()) {
               var5 = false;
            }

            class_534 var13 = new class_534(var8.method_2882(var10), var5);
            if(var5) {
               this.ahp.method_401(var2, var13);
            }

            var4.method_384((class_52.class_816)var13.getObject());
            return var13;
         }
      }

      return var9;
   }

   // $FF: renamed from: a (java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cs$a, com.google.android.gms.tagmanager.cr) com.google.android.gms.tagmanager.by
   private by<Set<class_539.class_1299>> method_3049(Set<class_539.class_1303> var1, Set<String> var2, class_540.class_1296 var3, cr var4) {
      HashSet var5 = new HashSet();
      HashSet var6 = new HashSet();
      Iterator var7 = var1.iterator();

      boolean var8;
      boolean var13;
      for(var8 = true; var7.hasNext(); var8 = var13) {
         class_539.class_1303 var10 = (class_539.class_1303)var7.next();
         class_77 var11 = var4.method_391();
         class_534 var12 = this.method_3057(var10, var2, var11);
         if(((Boolean)var12.getObject()).booleanValue()) {
            var3.method_866(var10, var5, var6, var11);
         }

         if(var8 && var12.method_2990()) {
            var13 = true;
         } else {
            var13 = false;
         }
      }

      var5.removeAll(var6);
      var4.method_390(var5);
      return new class_534(var5, var8);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set) void
   private void method_3050(class_52.class_816 var1, Set<String> var2) {
      if(var1 != null) {
         class_534 var3 = this.method_3046(var1, var2, new class_527());
         if(var3 != ahj) {
            Object var4 = class_537.method_3024((class_52.class_816)var3.getObject());
            if(var4 instanceof Map) {
               Map var8 = (Map)var4;
               this.aer.push(var8);
               return;
            }

            if(!(var4 instanceof List)) {
               class_515.method_2919("pushAfterEvaluate: value not a Map or List");
               return;
            }

            Iterator var5 = ((List)var4).iterator();

            while(var5.hasNext()) {
               Object var6 = var5.next();
               if(var6 instanceof Map) {
                  Map var7 = (Map)var6;
                  this.aer.push(var7);
               } else {
                  class_515.method_2919("pushAfterEvaluate: value not a Map");
               }
            }
         }
      }

   }

   // $FF: renamed from: a (java.util.List, java.util.List, java.lang.String) void
   private static void method_3051(List<class_539.class_1299> var0, List<String> var1, String var2) {
      if(var0.size() != var1.size()) {
         class_515.method_2917("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
      }

   }

   // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.aj) void
   private static void method_3052(Map<String, aj> var0, aj var1) {
      if(var0.containsKey(var1.method_2879())) {
         throw new IllegalArgumentException("Duplicate function type name: " + var1.method_2879());
      } else {
         var0.put(var1.method_2879(), var1);
      }
   }

   // $FF: renamed from: d (java.util.Map, java.lang.String) com.google.android.gms.tagmanager.cs$c
   private static class_540.class_1298 method_3053(Map<String, class_540.class_1298> var0, String var1) {
      class_540.class_1298 var2 = (class_540.class_1298)var0.get(var1);
      if(var2 == null) {
         var2 = new class_540.class_1298();
         var0.put(var1, var2);
      }

      return var2;
   }

   // $FF: renamed from: h (com.google.android.gms.tagmanager.cq$a) java.lang.String
   private static String method_3054(class_539.class_1299 var0) {
      return class_537.method_3009((class_52.class_816)var0.method_4214().get(class_444.field_2260.toString()));
   }

   // $FF: renamed from: mD () java.lang.String
   private String method_3055() {
      if(this.ahu <= 1) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(Integer.toString(this.ahu));

         for(int var3 = 2; var3 < this.ahu; ++var3) {
            var1.append(' ');
         }

         var1.append(": ");
         return var1.toString();
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$a, java.util.Set, com.google.android.gms.tagmanager.cj) com.google.android.gms.tagmanager.by
   by<Boolean> method_3056(class_539.class_1299 var1, Set<String> var2, cj var3) {
      class_534 var4 = this.method_3048(this.ahn, var1, var2, var3);
      Boolean var5 = class_537.method_3022((class_52.class_816)var4.getObject());
      var3.method_384(class_537.method_3027(var5));
      return new class_534(var5, var4.method_2990());
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, java.util.Set, com.google.android.gms.tagmanager.cm) com.google.android.gms.tagmanager.by
   by<Boolean> method_3057(class_539.class_1303 var1, Set<String> var2, cm var3) {
      Iterator var4 = var1.method_4202().iterator();

      boolean var5;
      boolean var9;
      for(var5 = true; var4.hasNext(); var5 = var9) {
         class_534 var8 = this.method_3056((class_539.class_1299)var4.next(), var2, var3.method_375());
         if(((Boolean)var8.getObject()).booleanValue()) {
            var3.method_374(class_537.method_3027(Boolean.valueOf(false)));
            return new class_534(Boolean.valueOf(false), var8.method_2990());
         }

         if(var5 && var8.method_2990()) {
            var9 = true;
         } else {
            var9 = false;
         }
      }

      Iterator var6 = var1.method_4201().iterator();

      while(true) {
         while(var6.hasNext()) {
            class_534 var7 = this.method_3056((class_539.class_1299)var6.next(), var2, var3.method_376());
            if(!((Boolean)var7.getObject()).booleanValue()) {
               var3.method_374(class_537.method_3027(Boolean.valueOf(false)));
               return new class_534(Boolean.valueOf(false), var7.method_2990());
            }

            if(var5 && var7.method_2990()) {
               var5 = true;
            } else {
               var5 = false;
            }
         }

         var3.method_374(class_537.method_3027(Boolean.valueOf(true)));
         return new class_534(Boolean.valueOf(true), var5);
      }
   }

   // $FF: renamed from: a (java.lang.String, java.util.Set, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Set, com.google.android.gms.tagmanager.cr) com.google.android.gms.tagmanager.by
   by<Set<class_539.class_1299>> method_3058(String var1, Set<class_539.class_1303> var2, final Map<class_539.class_1303, List<class_539.class_1299>> var3, final Map<class_539.class_1303, List<String>> var4, final Map<class_539.class_1303, List<class_539.class_1299>> var5, final Map<class_539.class_1303, List<String>> var6, Set<String> var7, cr var8) {
      return this.method_3049(var2, var7, new class_540.class_1296() {
         // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cm) void
         public void method_866(class_539.class_1303 var1, Set<class_539.class_1299> var2, Set<class_539.class_1299> var3x, cm var4x) {
            List var5x = (List)var3.get(var1);
            List var6x = (List)var4.get(var1);
            if(var5x != null) {
               var2.addAll(var5x);
               var4x.method_377().method_382(var5x, var6x);
            }

            List var7 = (List)var5.get(var1);
            List var8 = (List)var6.get(var1);
            if(var7 != null) {
               var3x.addAll(var7);
               var4x.method_378().method_382(var7, var8);
            }

         }
      }, var8);
   }

   // $FF: renamed from: a (java.util.Set, com.google.android.gms.tagmanager.cr) com.google.android.gms.tagmanager.by
   by<Set<class_539.class_1299>> method_3059(Set<class_539.class_1303> var1, cr var2) {
      return this.method_3049(var1, new HashSet(), new class_540.class_1296() {
         // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cm) void
         public void method_866(class_539.class_1303 var1, Set<class_539.class_1299> var2, Set<class_539.class_1299> var3, cm var4) {
            var2.addAll(var1.method_4203());
            var3.addAll(var1.method_4204());
            var4.method_379().method_382(var1.method_4203(), var1.method_4208());
            var4.method_380().method_382(var1.method_4204(), var1.method_4209());
         }
      }, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.aj) void
   void method_3060(class_464 var1) {
      method_3052(this.aho, var1);
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.aj) void
   void method_3061(class_464 var1) {
      method_3052(this.ahm, var1);
   }

   // $FF: renamed from: bH (java.lang.String) void
   public void method_3062(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (com.google.android.gms.tagmanager.aj) void
   void method_3063(class_464 var1) {
      method_3052(this.ahn, var1);
   }

   // $FF: renamed from: cj (java.lang.String) com.google.android.gms.tagmanager.by
   public by<class_52.class_816> method_3064(String var1) {
      this.ahu = 0;
      class_85 var2 = this.ahl.method_392(var1);
      class_534 var3 = this.method_3047(var1, new HashSet(), var2.method_397());
      var2.method_399();
      return var3;
   }

   // $FF: renamed from: ck (java.lang.String) void
   void method_3065(String var1) {
      synchronized(this){}

      try {
         this.aht = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: h (java.util.List) void
   public void method_3066(List<class_51.class_960> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: mC () java.lang.String
   String method_3067() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.aht;
      } finally {
         ;
      }

      return var2;
   }

   interface class_1296 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cm) void
      void method_866(class_539.class_1303 var1, Set<class_539.class_1299> var2, Set<class_539.class_1299> var3, cm var4);
   }

   private static class class_1297 {
      private class_52.class_816 agV;
      private by<class_52.class_816> ahA;

      public class_1297(by<class_52.class_816> var1, class_52.class_816 var2) {
         this.ahA = var1;
         this.agV = var2;
      }

      public int getSize() {
         int var1 = ((class_52.class_816)this.ahA.getObject()).nU();
         int var2;
         if(this.agV == null) {
            var2 = 0;
         } else {
            var2 = this.agV.nU();
         }

         return var2 + var1;
      }

      // $FF: renamed from: mE () com.google.android.gms.tagmanager.by
      public by<class_52.class_816> method_4587() {
         return this.ahA;
      }

      // $FF: renamed from: mk () com.google.android.gms.internal.d$a
      public class_52.class_816 method_4588() {
         return this.agV;
      }
   }

   private static class class_1298 {
      private final Map<class_539.class_1303, List<class_539.class_1299>> ahB = new HashMap();
      private final Map<class_539.class_1303, List<class_539.class_1299>> ahC = new HashMap();
      private final Map<class_539.class_1303, List<String>> ahD = new HashMap();
      private final Map<class_539.class_1303, List<String>> ahE = new HashMap();
      private class_539.class_1299 ahF;
      private final Set<class_539.class_1303> ahr = new HashSet();

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, com.google.android.gms.tagmanager.cq$a) void
      public void method_4575(class_539.class_1303 var1, class_539.class_1299 var2) {
         Object var3 = (List)this.ahB.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.ahB.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e, java.lang.String) void
      public void method_4576(class_539.class_1303 var1, String var2) {
         Object var3 = (List)this.ahD.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.ahD.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cq$e) void
      public void method_4577(class_539.class_1303 var1) {
         this.ahr.add(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cq$e, com.google.android.gms.tagmanager.cq$a) void
      public void method_4578(class_539.class_1303 var1, class_539.class_1299 var2) {
         Object var3 = (List)this.ahC.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.ahC.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cq$e, java.lang.String) void
      public void method_4579(class_539.class_1303 var1, String var2) {
         Object var3 = (List)this.ahE.get(var1);
         if(var3 == null) {
            var3 = new ArrayList();
            this.ahE.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      // $FF: renamed from: i (com.google.android.gms.tagmanager.cq$a) void
      public void method_4580(class_539.class_1299 var1) {
         this.ahF = var1;
      }

      // $FF: renamed from: mF () java.util.Set
      public Set<class_539.class_1303> method_4581() {
         return this.ahr;
      }

      // $FF: renamed from: mG () java.util.Map
      public Map<class_539.class_1303, List<class_539.class_1299>> method_4582() {
         return this.ahB;
      }

      // $FF: renamed from: mH () java.util.Map
      public Map<class_539.class_1303, List<String>> method_4583() {
         return this.ahD;
      }

      // $FF: renamed from: mI () java.util.Map
      public Map<class_539.class_1303, List<String>> method_4584() {
         return this.ahE;
      }

      // $FF: renamed from: mJ () java.util.Map
      public Map<class_539.class_1303, List<class_539.class_1299>> method_4585() {
         return this.ahC;
      }

      // $FF: renamed from: mK () com.google.android.gms.tagmanager.cq$a
      public class_539.class_1299 method_4586() {
         return this.ahF;
      }
   }
}
