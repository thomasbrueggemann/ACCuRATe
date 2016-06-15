package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
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

// $FF: renamed from: com.google.android.gms.tagmanager.cr
class class_639 {
   // $FF: renamed from: a (int, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], java.util.Set) com.google.android.gms.internal.d$a
   private static class_57.class_1084 method_3624(int var0, class_55.class_1269 var1, class_57.class_1084[] var2, Set<Integer> var3) throws class_639.class_1688 {
      int var4 = 0;
      if(var3.contains(Integer.valueOf(var0))) {
         method_3630("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
      }

      class_57.class_1084 var5 = (class_57.class_1084)method_3627(var1.field_686, var0, "values");
      if(var2[var0] != null) {
         return var2[var0];
      } else {
         class_57.class_1084 var8;
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
            class_55.class_1267 var31 = method_3632(var5);
            var8 = method_3631(var5);
            var8.field_734 = new class_57.class_1084[var31.field_713.length];
            int[] var32 = var31.field_713;
            int var33 = var32.length;
            int var34 = 0;

            while(true) {
               if(var4 >= var33) {
                  break label54;
               }

               int var35 = var32[var4];
               class_57.class_1084[] var36 = var8.field_734;
               int var37 = var34 + 1;
               var36[var34] = method_3624(var35, var1, var2, var3);
               ++var4;
               var34 = var37;
            }
         case 3:
            var8 = method_3631(var5);
            class_55.class_1267 var17 = method_3632(var5);
            if(var17.field_714.length != var17.field_715.length) {
               method_3630("Uneven map keys (" + var17.field_714.length + ") and map values (" + var17.field_715.length + ")");
            }

            var8.field_735 = new class_57.class_1084[var17.field_714.length];
            var8.field_736 = new class_57.class_1084[var17.field_714.length];
            int[] var18 = var17.field_714;
            int var19 = var18.length;
            int var20 = 0;

            int var30;
            for(int var21 = 0; var20 < var19; var21 = var30) {
               int var28 = var18[var20];
               class_57.class_1084[] var29 = var8.field_735;
               var30 = var21 + 1;
               var29[var21] = method_3624(var28, var1, var2, var3);
               ++var20;
            }

            int[] var22 = var17.field_715;
            int var23 = var22.length;
            int var24 = 0;

            while(true) {
               if(var4 >= var23) {
                  break label54;
               }

               int var25 = var22[var4];
               class_57.class_1084[] var26 = var8.field_736;
               int var27 = var24 + 1;
               var26[var24] = method_3624(var25, var1, var2, var3);
               ++var4;
               var24 = var27;
            }
         case 4:
            var8 = method_3631(var5);
            var8.field_737 = class_635.method_3579(method_3624(method_3632(var5).field_718, var1, var2, var3));
            break;
         case 7:
            var8 = method_3631(var5);
            class_55.class_1267 var10 = method_3632(var5);
            var8.field_730 = new class_57.class_1084[var10.field_717.length];
            int[] var11 = var10.field_717;
            int var12 = var11.length;

            int var16;
            for(int var13 = 0; var4 < var12; var13 = var16) {
               int var14 = var11[var4];
               class_57.class_1084[] var15 = var8.field_730;
               var16 = var13 + 1;
               var15[var13] = method_3624(var14, var1, var2, var3);
               ++var4;
            }
         }

         if(var8 == null) {
            method_3630("Invalid value: " + var5);
         }

         var2[var0] = var8;
         var3.remove(Integer.valueOf(var0));
         return var8;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$b, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], int) com.google.android.gms.tagmanager.cr$a
   private static class_639.class_1682 method_3625(class_55.class_1273 var0, class_55.class_1269 var1, class_57.class_1084[] var2, int var3) throws class_639.class_1688 {
      class_639.class_1683 var4 = class_639.class_1682.method_5509();
      int[] var5 = var0.field_670;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Integer var8 = Integer.valueOf(var5[var7]);
         class_55.class_1270 var9 = (class_55.class_1270)method_3627(var1.field_687, var8.intValue(), "properties");
         String var10 = (String)method_3627(var1.field_685, var9.key, "keys");
         class_57.class_1084 var11 = (class_57.class_1084)method_3627(var2, var9.value, "values");
         if(class_519.field_2146.toString().equals(var10)) {
            var4.method_5514(var11);
         } else {
            var4.method_5513(var10, var11);
         }
      }

      return var4.method_5515();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$g, java.util.List, java.util.List, java.util.List, com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cr$e
   private static class_639.class_1686 method_3626(class_55.class_1268 var0, List<class_639.class_1682> var1, List<class_639.class_1682> var2, List<class_639.class_1682> var3, class_55.class_1269 var4) {
      class_639.class_1687 var5 = class_639.class_1686.method_5539();
      int[] var6 = var0.field_701;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         var5.method_5528((class_639.class_1682)var3.get(Integer.valueOf(var6[var8]).intValue()));
      }

      int[] var9 = var0.field_702;
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         var5.method_5529((class_639.class_1682)var3.get(Integer.valueOf(var9[var11]).intValue()));
      }

      int[] var12 = var0.field_703;
      int var13 = var12.length;

      for(int var14 = 0; var14 < var13; ++var14) {
         var5.method_5534((class_639.class_1682)var1.get(Integer.valueOf(var12[var14]).intValue()));
      }

      int[] var15 = var0.field_705;
      int var16 = var15.length;

      for(int var17 = 0; var17 < var16; ++var17) {
         Integer var45 = Integer.valueOf(var15[var17]);
         var5.method_5530(var4.field_686[var45.intValue()].field_733);
      }

      int[] var18 = var0.field_704;
      int var19 = var18.length;

      for(int var20 = 0; var20 < var19; ++var20) {
         var5.method_5535((class_639.class_1682)var1.get(Integer.valueOf(var18[var20]).intValue()));
      }

      int[] var21 = var0.field_706;
      int var22 = var21.length;

      for(int var23 = 0; var23 < var22; ++var23) {
         Integer var42 = Integer.valueOf(var21[var23]);
         var5.method_5531(var4.field_686[var42.intValue()].field_733);
      }

      int[] var24 = var0.field_707;
      int var25 = var24.length;

      for(int var26 = 0; var26 < var25; ++var26) {
         var5.method_5536((class_639.class_1682)var2.get(Integer.valueOf(var24[var26]).intValue()));
      }

      int[] var27 = var0.field_709;
      int var28 = var27.length;

      for(int var29 = 0; var29 < var28; ++var29) {
         Integer var39 = Integer.valueOf(var27[var29]);
         var5.method_5532(var4.field_686[var39.intValue()].field_733);
      }

      int[] var30 = var0.field_708;
      int var31 = var30.length;

      for(int var32 = 0; var32 < var31; ++var32) {
         var5.method_5537((class_639.class_1682)var2.get(Integer.valueOf(var30[var32]).intValue()));
      }

      int[] var33 = var0.field_710;
      int var34 = var33.length;

      for(int var35 = 0; var35 < var34; ++var35) {
         Integer var36 = Integer.valueOf(var33[var35]);
         var5.method_5533(var4.field_686[var36.intValue()].field_733);
      }

      return var5.method_5538();
   }

   // $FF: renamed from: a (java.lang.Object[], int, java.lang.String) java.lang.Object
   private static <T> T method_3627(T[] var0, int var1, String var2) throws class_639.class_1688 {
      if(var1 < 0 || var1 >= var0.length) {
         method_3630("Index out of bounds detected: " + var1 + " in " + var2);
      }

      return var0[var1];
   }

   // $FF: renamed from: b (com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cr$c
   public static class_639.class_1684 method_3628(class_55.class_1269 var0) throws class_639.class_1688 {
      int var1 = 0;
      class_57.class_1084[] var2 = new class_57.class_1084[var0.field_686.length];

      for(int var3 = 0; var3 < var0.field_686.length; ++var3) {
         method_3624(var3, var0, var2, new HashSet(0));
      }

      class_639.class_1685 var4 = class_639.class_1684.method_5555();
      ArrayList var5 = new ArrayList();

      for(int var6 = 0; var6 < var0.field_689.length; ++var6) {
         var5.add(method_3625(var0.field_689[var6], var0, var2, var6));
      }

      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < var0.field_690.length; ++var8) {
         var7.add(method_3625(var0.field_690[var8], var0, var2, var8));
      }

      ArrayList var9 = new ArrayList();

      for(int var10 = 0; var10 < var0.field_688.length; ++var10) {
         class_639.class_1682 var16 = method_3625(var0.field_688[var10], var0, var2, var10);
         var4.method_5550(var16);
         var9.add(var16);
      }

      class_55.class_1268[] var11 = var0.field_691;

      for(int var12 = var11.length; var1 < var12; ++var1) {
         var4.method_5551(method_3626(var11[var1], var5, var9, var7, var0));
      }

      var4.method_5552(var0.version);
      var4.method_5553(var0.field_699);
      return var4.method_5554();
   }

   // $FF: renamed from: b (java.io.InputStream, java.io.OutputStream) void
   public static void method_3629(InputStream var0, OutputStream var1) throws IOException {
      byte[] var2 = new byte[1024];

      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return;
         }

         var1.write(var2, 0, var3);
      }
   }

   // $FF: renamed from: cN (java.lang.String) void
   private static void method_3630(String var0) throws class_639.class_1688 {
      class_613.method_3491(var0);
      throw new class_639.class_1688(var0);
   }

   // $FF: renamed from: g (com.google.android.gms.internal.d$a) com.google.android.gms.internal.d$a
   public static class_57.class_1084 method_3631(class_57.class_1084 var0) {
      class_57.class_1084 var1 = new class_57.class_1084();
      var1.type = var0.type;
      var1.field_731 = (int[])var0.field_731.clone();
      if(var0.field_732) {
         var1.field_732 = var0.field_732;
      }

      return var1;
   }

   // $FF: renamed from: h (com.google.android.gms.internal.d$a) com.google.android.gms.internal.c$h
   private static class_55.class_1267 method_3632(class_57.class_1084 var0) throws class_639.class_1688 {
      if((class_55.class_1267)var0.a(class_55.class_1267.field_711) == null) {
         method_3630("Expected a ServingValue and didn\'t get one. Value is: " + var0);
      }

      return (class_55.class_1267)var0.a(class_55.class_1267.field_711);
   }

   public static class class_1682 {
      private final Map<String, class_57.class_1084> asM;
      private final class_57.class_1084 asN;

      private class_1682(Map<String, class_57.class_1084> var1, class_57.class_1084 var2) {
         this.asM = var1;
         this.asN = var2;
      }

      // $FF: synthetic method
      class_1682(Map var1, class_57.class_1084 var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: qk () com.google.android.gms.tagmanager.cr$b
      public static class_639.class_1683 method_5509() {
         return new class_639.class_1683();
      }

      // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.d$a) void
      public void method_5510(String var1, class_57.class_1084 var2) {
         this.asM.put(var1, var2);
      }

      // $FF: renamed from: ql () java.util.Map
      public Map<String, class_57.class_1084> method_5511() {
         return Collections.unmodifiableMap(this.asM);
      }

      // $FF: renamed from: qm () com.google.android.gms.internal.d$a
      public class_57.class_1084 method_5512() {
         return this.asN;
      }

      public String toString() {
         return "Properties: " + this.method_5511() + " pushAfterEvaluate: " + this.asN;
      }
   }

   public static class class_1683 {
      private final Map<String, class_57.class_1084> asM;
      private class_57.class_1084 asN;

      private class_1683() {
         this.asM = new HashMap();
      }

      // $FF: synthetic method
      class_1683(Object var1) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cr$b
      public class_639.class_1683 method_5513(String var1, class_57.class_1084 var2) {
         this.asM.put(var1, var2);
         return this;
      }

      // $FF: renamed from: i (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cr$b
      public class_639.class_1683 method_5514(class_57.class_1084 var1) {
         this.asN = var1;
         return this;
      }

      // $FF: renamed from: qn () com.google.android.gms.tagmanager.cr$a
      public class_639.class_1682 method_5515() {
         return new class_639.class_1682(this.asM, this.asN);
      }
   }

   public static class class_1684 {
      // $FF: renamed from: TU java.lang.String
      private final String field_4286;
      private final List<class_639.class_1686> asO;
      private final Map<String, List<class_639.class_1682>> asP;
      private final int asQ;

      private class_1684(List<class_639.class_1686> var1, Map<String, List<class_639.class_1682>> var2, String var3, int var4) {
         this.asO = Collections.unmodifiableList(var1);
         this.asP = Collections.unmodifiableMap(var2);
         this.field_4286 = var3;
         this.asQ = var4;
      }

      // $FF: synthetic method
      class_1684(List var1, Map var2, String var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      // $FF: renamed from: qo () com.google.android.gms.tagmanager.cr$d
      public static class_639.class_1685 method_5555() {
         return new class_639.class_1685();
      }

      public String getVersion() {
         return this.field_4286;
      }

      // $FF: renamed from: qp () java.util.List
      public List<class_639.class_1686> method_5556() {
         return this.asO;
      }

      // $FF: renamed from: qq () java.util.Map
      public Map<String, List<class_639.class_1682>> method_5557() {
         return this.asP;
      }

      public String toString() {
         return "Rules: " + this.method_5556() + "  Macros: " + this.asP;
      }
   }

   public static class class_1685 {
      // $FF: renamed from: TU java.lang.String
      private String field_4284;
      private final List<class_639.class_1686> asO;
      private final Map<String, List<class_639.class_1682>> asP;
      private int asQ;

      private class_1685() {
         this.asO = new ArrayList();
         this.asP = new HashMap();
         this.field_4284 = "";
         this.asQ = 0;
      }

      // $FF: synthetic method
      class_1685(Object var1) {
         this();
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$d
      public class_639.class_1685 method_5550(class_639.class_1682 var1) {
         String var2 = class_635.method_3579((class_57.class_1084)var1.method_5511().get(class_519.field_2097.toString()));
         Object var3 = (List)this.asP.get(var2);
         if(var3 == null) {
            var3 = new ArrayList();
            this.asP.put(var2, var3);
         }

         ((List)var3).add(var1);
         return this;
      }

      // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e) com.google.android.gms.tagmanager.cr$d
      public class_639.class_1685 method_5551(class_639.class_1686 var1) {
         this.asO.add(var1);
         return this;
      }

      // $FF: renamed from: cO (java.lang.String) com.google.android.gms.tagmanager.cr$d
      public class_639.class_1685 method_5552(String var1) {
         this.field_4284 = var1;
         return this;
      }

      // $FF: renamed from: fO (int) com.google.android.gms.tagmanager.cr$d
      public class_639.class_1685 method_5553(int var1) {
         this.asQ = var1;
         return this;
      }

      // $FF: renamed from: qr () com.google.android.gms.tagmanager.cr$c
      public class_639.class_1684 method_5554() {
         return new class_639.class_1684(this.asO, this.asP, this.field_4284, this.asQ);
      }
   }

   public static class class_1686 {
      private final List<class_639.class_1682> asR;
      private final List<class_639.class_1682> asS;
      private final List<class_639.class_1682> asT;
      private final List<class_639.class_1682> asU;
      private final List<class_639.class_1682> asV;
      private final List<class_639.class_1682> asW;
      private final List<String> asX;
      private final List<String> asY;
      private final List<String> asZ;
      private final List<String> ata;

      private class_1686(List<class_639.class_1682> var1, List<class_639.class_1682> var2, List<class_639.class_1682> var3, List<class_639.class_1682> var4, List<class_639.class_1682> var5, List<class_639.class_1682> var6, List<String> var7, List<String> var8, List<String> var9, List<String> var10) {
         this.asR = Collections.unmodifiableList(var1);
         this.asS = Collections.unmodifiableList(var2);
         this.asT = Collections.unmodifiableList(var3);
         this.asU = Collections.unmodifiableList(var4);
         this.asV = Collections.unmodifiableList(var5);
         this.asW = Collections.unmodifiableList(var6);
         this.asX = Collections.unmodifiableList(var7);
         this.asY = Collections.unmodifiableList(var8);
         this.asZ = Collections.unmodifiableList(var9);
         this.ata = Collections.unmodifiableList(var10);
      }

      // $FF: synthetic method
      class_1686(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      // $FF: renamed from: qs () com.google.android.gms.tagmanager.cr$f
      public static class_639.class_1687 method_5539() {
         return new class_639.class_1687();
      }

      // $FF: renamed from: qA () java.util.List
      public List<String> method_5540() {
         return this.asZ;
      }

      // $FF: renamed from: qB () java.util.List
      public List<String> method_5541() {
         return this.ata;
      }

      // $FF: renamed from: qC () java.util.List
      public List<class_639.class_1682> method_5542() {
         return this.asW;
      }

      // $FF: renamed from: qt () java.util.List
      public List<class_639.class_1682> method_5543() {
         return this.asR;
      }

      // $FF: renamed from: qu () java.util.List
      public List<class_639.class_1682> method_5544() {
         return this.asS;
      }

      // $FF: renamed from: qv () java.util.List
      public List<class_639.class_1682> method_5545() {
         return this.asT;
      }

      // $FF: renamed from: qw () java.util.List
      public List<class_639.class_1682> method_5546() {
         return this.asU;
      }

      // $FF: renamed from: qx () java.util.List
      public List<class_639.class_1682> method_5547() {
         return this.asV;
      }

      // $FF: renamed from: qy () java.util.List
      public List<String> method_5548() {
         return this.asX;
      }

      // $FF: renamed from: qz () java.util.List
      public List<String> method_5549() {
         return this.asY;
      }

      public String toString() {
         return "Positive predicates: " + this.method_5543() + "  Negative predicates: " + this.method_5544() + "  Add tags: " + this.method_5545() + "  Remove tags: " + this.method_5546() + "  Add macros: " + this.method_5547() + "  Remove macros: " + this.method_5542();
      }
   }

   public static class class_1687 {
      private final List<class_639.class_1682> asR;
      private final List<class_639.class_1682> asS;
      private final List<class_639.class_1682> asT;
      private final List<class_639.class_1682> asU;
      private final List<class_639.class_1682> asV;
      private final List<class_639.class_1682> asW;
      private final List<String> asX;
      private final List<String> asY;
      private final List<String> asZ;
      private final List<String> ata;

      private class_1687() {
         this.asR = new ArrayList();
         this.asS = new ArrayList();
         this.asT = new ArrayList();
         this.asU = new ArrayList();
         this.asV = new ArrayList();
         this.asW = new ArrayList();
         this.asX = new ArrayList();
         this.asY = new ArrayList();
         this.asZ = new ArrayList();
         this.ata = new ArrayList();
      }

      // $FF: synthetic method
      class_1687(Object var1) {
         this();
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5528(class_639.class_1682 var1) {
         this.asR.add(var1);
         return this;
      }

      // $FF: renamed from: c (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5529(class_639.class_1682 var1) {
         this.asS.add(var1);
         return this;
      }

      // $FF: renamed from: cP (java.lang.String) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5530(String var1) {
         this.asZ.add(var1);
         return this;
      }

      // $FF: renamed from: cQ (java.lang.String) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5531(String var1) {
         this.ata.add(var1);
         return this;
      }

      // $FF: renamed from: cR (java.lang.String) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5532(String var1) {
         this.asX.add(var1);
         return this;
      }

      // $FF: renamed from: cS (java.lang.String) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5533(String var1) {
         this.asY.add(var1);
         return this;
      }

      // $FF: renamed from: d (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5534(class_639.class_1682 var1) {
         this.asT.add(var1);
         return this;
      }

      // $FF: renamed from: e (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5535(class_639.class_1682 var1) {
         this.asU.add(var1);
         return this;
      }

      // $FF: renamed from: f (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5536(class_639.class_1682 var1) {
         this.asV.add(var1);
         return this;
      }

      // $FF: renamed from: g (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
      public class_639.class_1687 method_5537(class_639.class_1682 var1) {
         this.asW.add(var1);
         return this;
      }

      // $FF: renamed from: qD () com.google.android.gms.tagmanager.cr$e
      public class_639.class_1686 method_5538() {
         return new class_639.class_1686(this.asR, this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata);
      }
   }

   public static class class_1688 extends Exception {
      public class_1688(String var1) {
         super(var1);
      }
   }
}
