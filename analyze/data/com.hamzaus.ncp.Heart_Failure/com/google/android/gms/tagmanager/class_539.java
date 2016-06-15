package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.cq
class class_539 {
   // $FF: renamed from: a (int, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], java.util.Set) com.google.android.gms.internal.d$a
   private static class_52.class_816 method_3037(int var0, class_51.class_965 var1, class_52.class_816[] var2, Set<Integer> var3) throws class_539.class_1305 {
      int var4 = 0;
      if(var3.contains(Integer.valueOf(var0))) {
         method_3043("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
      }

      class_52.class_816 var5 = (class_52.class_816)method_3040(var1.field_843, var0, "values");
      if(var2[var0] != null) {
         return var2[var0];
      } else {
         class_52.class_816 var8;
         var3.add(Integer.valueOf(var0));
         int var7 = var5.type;
         var8 = null;
         label54:
         switch(var7) {
         case 1:
         case 5:
         case 6:
         case 8:
            var8 = var5;
            break;
         case 2:
            class_51.class_963 var31 = method_3045(var5);
            var8 = method_3044(var5);
            var8.field_886 = new class_52.class_816[var31.field_877.length];
            int[] var32 = var31.field_877;
            int var33 = var32.length;
            int var34 = 0;

            while(true) {
               if(var4 >= var33) {
                  break label54;
               }

               int var35 = var32[var4];
               class_52.class_816[] var36 = var8.field_886;
               int var37 = var34 + 1;
               var36[var34] = method_3037(var35, var1, var2, var3);
               ++var4;
               var34 = var37;
            }
         case 3:
            var8 = method_3044(var5);
            class_51.class_963 var17 = method_3045(var5);
            if(var17.field_871.length != var17.field_872.length) {
               method_3043("Uneven map keys (" + var17.field_871.length + ") and map values (" + var17.field_872.length + ")");
            }

            var8.field_887 = new class_52.class_816[var17.field_871.length];
            var8.field_888 = new class_52.class_816[var17.field_871.length];
            int[] var18 = var17.field_871;
            int var19 = var18.length;
            int var20 = 0;

            int var30;
            for(int var21 = 0; var20 < var19; var21 = var30) {
               int var28 = var18[var20];
               class_52.class_816[] var29 = var8.field_887;
               var30 = var21 + 1;
               var29[var21] = method_3037(var28, var1, var2, var3);
               ++var20;
            }

            int[] var22 = var17.field_872;
            int var23 = var22.length;
            int var24 = 0;

            while(true) {
               if(var4 >= var23) {
                  break label54;
               }

               int var25 = var22[var4];
               class_52.class_816[] var26 = var8.field_888;
               int var27 = var24 + 1;
               var26[var24] = method_3037(var25, var1, var2, var3);
               ++var4;
               var24 = var27;
            }
         case 4:
            var8 = method_3044(var5);
            var8.field_889 = class_537.method_3009(method_3037(method_3045(var5).field_875, var1, var2, var3));
            break;
         case 7:
            var8 = method_3044(var5);
            class_51.class_963 var10 = method_3045(var5);
            var8.field_893 = new class_52.class_816[var10.field_874.length];
            int[] var11 = var10.field_874;
            int var12 = var11.length;

            int var16;
            for(int var13 = 0; var4 < var12; var13 = var16) {
               int var14 = var11[var4];
               class_52.class_816[] var15 = var8.field_893;
               var16 = var13 + 1;
               var15[var13] = method_3037(var14, var1, var2, var3);
               ++var4;
            }
         }

         if(var8 == null) {
            method_3043("Invalid value: " + var5);
         }

         var2[var0] = var8;
         var3.remove(Integer.valueOf(var0));
         return var8;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$b, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], int) com.google.android.gms.tagmanager.cq$a
   private static class_539.class_1299 method_3038(class_51.class_969 var0, class_51.class_965 var1, class_52.class_816[] var2, int var3) throws class_539.class_1305 {
      class_539.class_1300 var4 = class_539.class_1299.method_4212();
      int[] var5 = var0.field_827;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Integer var8 = Integer.valueOf(var5[var7]);
         class_51.class_966 var9 = (class_51.class_966)method_3040(var1.field_844, var8.intValue(), "properties");
         String var10 = (String)method_3040(var1.field_842, var9.key, "keys");
         class_52.class_816 var11 = (class_52.class_816)method_3040(var2, var9.value, "values");
         if(class_444.field_2305.toString().equals(var10)) {
            var4.method_4217(var11);
         } else {
            var4.method_4216(var10, var11);
         }
      }

      return var4.method_4218();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$g, java.util.List, java.util.List, java.util.List, com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cq$e
   private static class_539.class_1303 method_3039(class_51.class_964 var0, List<class_539.class_1299> var1, List<class_539.class_1299> var2, List<class_539.class_1299> var3, class_51.class_965 var4) {
      class_539.class_1304 var5 = class_539.class_1303.method_4199();
      int[] var6 = var0.field_859;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         var5.method_4183((class_539.class_1299)var3.get(Integer.valueOf(var6[var8]).intValue()));
      }

      int[] var9 = var0.field_860;
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         var5.method_4184((class_539.class_1299)var3.get(Integer.valueOf(var9[var11]).intValue()));
      }

      int[] var12 = var0.field_861;
      int var13 = var12.length;

      for(int var14 = 0; var14 < var13; ++var14) {
         var5.method_4189((class_539.class_1299)var1.get(Integer.valueOf(var12[var14]).intValue()));
      }

      int[] var15 = var0.field_863;
      int var16 = var15.length;

      for(int var17 = 0; var17 < var16; ++var17) {
         Integer var45 = Integer.valueOf(var15[var17]);
         var5.method_4185(var4.field_843[var45.intValue()].field_885);
      }

      int[] var18 = var0.field_862;
      int var19 = var18.length;

      for(int var20 = 0; var20 < var19; ++var20) {
         var5.method_4190((class_539.class_1299)var1.get(Integer.valueOf(var18[var20]).intValue()));
      }

      int[] var21 = var0.field_864;
      int var22 = var21.length;

      for(int var23 = 0; var23 < var22; ++var23) {
         Integer var42 = Integer.valueOf(var21[var23]);
         var5.method_4186(var4.field_843[var42.intValue()].field_885);
      }

      int[] var24 = var0.field_865;
      int var25 = var24.length;

      for(int var26 = 0; var26 < var25; ++var26) {
         var5.method_4191((class_539.class_1299)var2.get(Integer.valueOf(var24[var26]).intValue()));
      }

      int[] var27 = var0.field_867;
      int var28 = var27.length;

      for(int var29 = 0; var29 < var28; ++var29) {
         Integer var39 = Integer.valueOf(var27[var29]);
         var5.method_4187(var4.field_843[var39.intValue()].field_885);
      }

      int[] var30 = var0.field_866;
      int var31 = var30.length;

      for(int var32 = 0; var32 < var31; ++var32) {
         var5.method_4192((class_539.class_1299)var2.get(Integer.valueOf(var30[var32]).intValue()));
      }

      int[] var33 = var0.field_868;
      int var34 = var33.length;

      for(int var35 = 0; var35 < var34; ++var35) {
         Integer var36 = Integer.valueOf(var33[var35]);
         var5.method_4188(var4.field_843[var36.intValue()].field_885);
      }

      return var5.method_4193();
   }

   // $FF: renamed from: a (java.lang.Object[], int, java.lang.String) java.lang.Object
   private static <T> T method_3040(T[] var0, int var1, String var2) throws class_539.class_1305 {
      if(var1 < 0 || var1 >= var0.length) {
         method_3043("Index out of bounds detected: " + var1 + " in " + var2);
      }

      return var0[var1];
   }

   // $FF: renamed from: b (com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cq$c
   public static class_539.class_1301 method_3041(class_51.class_965 var0) throws class_539.class_1305 {
      int var1 = 0;
      class_52.class_816[] var2 = new class_52.class_816[var0.field_843.length];

      for(int var3 = 0; var3 < var0.field_843.length; ++var3) {
         method_3037(var3, var0, var2, new HashSet(0));
      }

      class_539.class_1302 var4 = class_539.class_1301.method_4219();
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var0.field_846.length; ++var6) {
         var5.add(method_3038(var0.field_846[var6], var0, var2, var6));
      }

      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < var0.field_847.length; ++var8) {
         var7.add(method_3038(var0.field_847[var8], var0, var2, var8));
      }

      ArrayList var9 = new ArrayList();

      for(int var10 = 0; var10 < var0.field_845.length; ++var10) {
         class_539.class_1299 var16 = method_3038(var0.field_845[var10], var0, var2, var10);
         var4.method_4194(var16);
         var9.add(var16);
      }

      class_51.class_964[] var11 = var0.field_848;

      for(int var12 = var11.length; var1 < var12; ++var1) {
         var4.method_4195(method_3039(var11[var1], var5, var9, var7, var0));
      }

      var4.method_4196(var0.field_852);
      var4.method_4197(var0.field_857);
      return var4.method_4198();
   }

   // $FF: renamed from: b (java.io.InputStream, java.io.OutputStream) void
   public static void method_3042(InputStream var0, OutputStream var1) throws IOException {
      byte[] var2 = new byte[1024];

      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   // $FF: renamed from: cd (java.lang.String) void
   private static void method_3043(String var0) throws class_539.class_1305 {
      class_515.method_2916(var0);
      throw new class_539.class_1305(var0);
   }

   // $FF: renamed from: g (com.google.android.gms.internal.d$a) com.google.android.gms.internal.d$a
   public static class_52.class_816 method_3044(class_52.class_816 var0) {
      class_52.class_816 var1 = new class_52.class_816();
      var1.type = var0.type;
      var1.field_894 = (int[])var0.field_894.clone();
      if(var0.field_895) {
         var1.field_895 = var0.field_895;
      }

      return var1;
   }

   // $FF: renamed from: h (com.google.android.gms.internal.d$a) com.google.android.gms.internal.c$h
   private static class_51.class_963 method_3045(class_52.class_816 var0) throws class_539.class_1305 {
      if((class_51.class_963)var0.a(class_51.class_963.field_869) == null) {
         method_3043("Expected a ServingValue and didn\'t get one. Value is: " + var0);
      }

      return (class_51.class_963)var0.a(class_51.class_963.field_869);
   }

   public static class class_1299 {
      private final Map<String, class_52.class_816> agU;
      private final class_52.class_816 agV;

      private class_1299(Map<String, class_52.class_816> var1, class_52.class_816 var2) {
         this.agU = var1;
         this.agV = var2;
      }

      // $FF: synthetic method
      class_1299(Map var1, class_52.class_816 var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: mi () com.google.android.gms.tagmanager.cq$b
      public static class_539.class_1300 method_4212() {
         return new class_539.class_1300();
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.d$a) void
      public void method_4213(String var1, class_52.class_816 var2) {
         this.agU.put(var1, var2);
      }

      // $FF: renamed from: mj () java.util.Map
      public Map<String, class_52.class_816> method_4214() {
         return Collections.unmodifiableMap(this.agU);
      }

      // $FF: renamed from: mk () com.google.android.gms.internal.d$a
      public class_52.class_816 method_4215() {
         return this.agV;
      }

      public String toString() {
         return "Properties: " + this.method_4214() + " pushAfterEvaluate: " + this.agV;
      }
   }

   public static class class_1300 {
      private final Map<String, class_52.class_816> agU;
      private class_52.class_816 agV;

      private class_1300() {
         this.agU = new HashMap();
      }

      // $FF: synthetic method
      class_1300(Object var1) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cq$b
      public class_539.class_1300 method_4216(String var1, class_52.class_816 var2) {
         this.agU.put(var1, var2);
         return this;
      }

      // $FF: renamed from: i (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cq$b
      public class_539.class_1300 method_4217(class_52.class_816 var1) {
         this.agV = var1;
         return this;
      }

      // $FF: renamed from: ml () com.google.android.gms.tagmanager.cq$a
      public class_539.class_1299 method_4218() {
         return new class_539.class_1299(this.agU, this.agV);
      }
   }

   public static class class_1301 {
      private final String aeR;
      private final List<class_539.class_1303> agW;
      private final Map<String, List<class_539.class_1299>> agX;
      private final int agY;

      private class_1301(List<class_539.class_1303> var1, Map<String, List<class_539.class_1299>> var2, String var3, int var4) {
         this.agW = Collections.unmodifiableList(var1);
         this.agX = Collections.unmodifiableMap(var2);
         this.aeR = var3;
         this.agY = var4;
      }

      // $FF: synthetic method
      class_1301(List var1, Map var2, String var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      // $FF: renamed from: mm () com.google.android.gms.tagmanager.cq$d
      public static class_539.class_1302 method_4219() {
         return new class_539.class_1302();
      }

      public String getVersion() {
         return this.aeR;
      }

      // $FF: renamed from: mn () java.util.List
      public List<class_539.class_1303> method_4220() {
         return this.agW;
      }

      // $FF: renamed from: mo () java.util.Map
      public Map<String, List<class_539.class_1299>> method_4221() {
         return this.agX;
      }

      public String toString() {
         return "Rules: " + this.method_4220() + "  Macros: " + this.agX;
      }
   }

   public static class class_1302 {
      private String aeR;
      private final List<class_539.class_1303> agW;
      private final Map<String, List<class_539.class_1299>> agX;
      private int agY;

      private class_1302() {
         this.agW = new ArrayList();
         this.agX = new HashMap();
         this.aeR = "";
         this.agY = 0;
      }

      // $FF: synthetic method
      class_1302(Object var1) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$d
      public class_539.class_1302 method_4194(class_539.class_1299 var1) {
         String var2 = class_537.method_3009((class_52.class_816)var1.method_4214().get(class_444.field_2260.toString()));
         Object var3 = (List)this.agX.get(var2);
         if(var3 == null) {
            var3 = new ArrayList();
            this.agX.put(var2, var3);
         }

         ((List)var3).add(var1);
         return this;
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$e) com.google.android.gms.tagmanager.cq$d
      public class_539.class_1302 method_4195(class_539.class_1303 var1) {
         this.agW.add(var1);
         return this;
      }

      // $FF: renamed from: ce (java.lang.String) com.google.android.gms.tagmanager.cq$d
      public class_539.class_1302 method_4196(String var1) {
         this.aeR = var1;
         return this;
      }

      // $FF: renamed from: du (int) com.google.android.gms.tagmanager.cq$d
      public class_539.class_1302 method_4197(int var1) {
         this.agY = var1;
         return this;
      }

      // $FF: renamed from: mp () com.google.android.gms.tagmanager.cq$c
      public class_539.class_1301 method_4198() {
         return new class_539.class_1301(this.agW, this.agX, this.aeR, this.agY);
      }
   }

   public static class class_1303 {
      private final List<class_539.class_1299> agZ;
      private final List<class_539.class_1299> aha;
      private final List<class_539.class_1299> ahb;
      private final List<class_539.class_1299> ahc;
      private final List<class_539.class_1299> ahd;
      private final List<class_539.class_1299> ahe;
      private final List<String> ahf;
      private final List<String> ahg;
      private final List<String> ahh;
      private final List<String> ahi;

      private class_1303(List<class_539.class_1299> var1, List<class_539.class_1299> var2, List<class_539.class_1299> var3, List<class_539.class_1299> var4, List<class_539.class_1299> var5, List<class_539.class_1299> var6, List<String> var7, List<String> var8, List<String> var9, List<String> var10) {
         this.agZ = Collections.unmodifiableList(var1);
         this.aha = Collections.unmodifiableList(var2);
         this.ahb = Collections.unmodifiableList(var3);
         this.ahc = Collections.unmodifiableList(var4);
         this.ahd = Collections.unmodifiableList(var5);
         this.ahe = Collections.unmodifiableList(var6);
         this.ahf = Collections.unmodifiableList(var7);
         this.ahg = Collections.unmodifiableList(var8);
         this.ahh = Collections.unmodifiableList(var9);
         this.ahi = Collections.unmodifiableList(var10);
      }

      // $FF: synthetic method
      class_1303(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      // $FF: renamed from: mq () com.google.android.gms.tagmanager.cq$f
      public static class_539.class_1304 method_4199() {
         return new class_539.class_1304();
      }

      // $FF: renamed from: mA () java.util.List
      public List<class_539.class_1299> method_4200() {
         return this.ahe;
      }

      // $FF: renamed from: mr () java.util.List
      public List<class_539.class_1299> method_4201() {
         return this.agZ;
      }

      // $FF: renamed from: ms () java.util.List
      public List<class_539.class_1299> method_4202() {
         return this.aha;
      }

      // $FF: renamed from: mt () java.util.List
      public List<class_539.class_1299> method_4203() {
         return this.ahb;
      }

      // $FF: renamed from: mu () java.util.List
      public List<class_539.class_1299> method_4204() {
         return this.ahc;
      }

      // $FF: renamed from: mv () java.util.List
      public List<class_539.class_1299> method_4205() {
         return this.ahd;
      }

      // $FF: renamed from: mw () java.util.List
      public List<String> method_4206() {
         return this.ahf;
      }

      // $FF: renamed from: mx () java.util.List
      public List<String> method_4207() {
         return this.ahg;
      }

      // $FF: renamed from: my () java.util.List
      public List<String> method_4208() {
         return this.ahh;
      }

      // $FF: renamed from: mz () java.util.List
      public List<String> method_4209() {
         return this.ahi;
      }

      public String toString() {
         return "Positive predicates: " + this.method_4201() + "  Negative predicates: " + this.method_4202() + "  Add tags: " + this.method_4203() + "  Remove tags: " + this.method_4204() + "  Add macros: " + this.method_4205() + "  Remove macros: " + this.method_4200();
      }
   }

   public static class class_1304 {
      private final List<class_539.class_1299> agZ;
      private final List<class_539.class_1299> aha;
      private final List<class_539.class_1299> ahb;
      private final List<class_539.class_1299> ahc;
      private final List<class_539.class_1299> ahd;
      private final List<class_539.class_1299> ahe;
      private final List<String> ahf;
      private final List<String> ahg;
      private final List<String> ahh;
      private final List<String> ahi;

      private class_1304() {
         this.agZ = new ArrayList();
         this.aha = new ArrayList();
         this.ahb = new ArrayList();
         this.ahc = new ArrayList();
         this.ahd = new ArrayList();
         this.ahe = new ArrayList();
         this.ahf = new ArrayList();
         this.ahg = new ArrayList();
         this.ahh = new ArrayList();
         this.ahi = new ArrayList();
      }

      // $FF: synthetic method
      class_1304(Object var1) {
         this();
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4183(class_539.class_1299 var1) {
         this.agZ.add(var1);
         return this;
      }

      // $FF: renamed from: c (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4184(class_539.class_1299 var1) {
         this.aha.add(var1);
         return this;
      }

      // $FF: renamed from: cf (java.lang.String) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4185(String var1) {
         this.ahh.add(var1);
         return this;
      }

      // $FF: renamed from: cg (java.lang.String) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4186(String var1) {
         this.ahi.add(var1);
         return this;
      }

      // $FF: renamed from: ch (java.lang.String) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4187(String var1) {
         this.ahf.add(var1);
         return this;
      }

      // $FF: renamed from: ci (java.lang.String) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4188(String var1) {
         this.ahg.add(var1);
         return this;
      }

      // $FF: renamed from: d (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4189(class_539.class_1299 var1) {
         this.ahb.add(var1);
         return this;
      }

      // $FF: renamed from: e (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4190(class_539.class_1299 var1) {
         this.ahc.add(var1);
         return this;
      }

      // $FF: renamed from: f (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4191(class_539.class_1299 var1) {
         this.ahd.add(var1);
         return this;
      }

      // $FF: renamed from: g (com.google.android.gms.tagmanager.cq$a) com.google.android.gms.tagmanager.cq$f
      public class_539.class_1304 method_4192(class_539.class_1299 var1) {
         this.ahe.add(var1);
         return this;
      }

      // $FF: renamed from: mB () com.google.android.gms.tagmanager.cq$e
      public class_539.class_1303 method_4193() {
         return new class_539.class_1303(this.agZ, this.aha, this.ahb, this.ahc, this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi);
      }
   }

   public static class class_1305 extends Exception {
      public class_1305(String var1) {
         super(var1);
      }
   }
}
