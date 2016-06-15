package com.google.android.gms.internal;

import com.google.android.gms.internal.class_224;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ak
@ey
public class class_227 {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_390 = new Object();
   // $FF: renamed from: np int
   private final int field_391;
   // $FF: renamed from: nq int
   private final int field_392;
   // $FF: renamed from: nr int
   private final int field_393;
   // $FF: renamed from: ns com.google.android.gms.internal.ap
   private final class_224 field_394;
   // $FF: renamed from: nt java.util.ArrayList
   private ArrayList<String> field_395 = new ArrayList();
   // $FF: renamed from: nu int
   private int field_396 = 0;
   // $FF: renamed from: nv int
   private int field_397 = 0;
   // $FF: renamed from: nw int
   private int field_398 = 0;
   // $FF: renamed from: nx int
   private int field_399;
   // $FF: renamed from: ny java.lang.String
   private String field_400 = "";

   public class_227(int var1, int var2, int var3, int var4) {
      this.field_391 = var1;
      this.field_392 = var2;
      this.field_393 = var3;
      this.field_394 = new class_224(var4);
   }

   // $FF: renamed from: a (java.util.ArrayList, int) java.lang.String
   private String method_1561(ArrayList<String> var1, int var2) {
      String var6;
      if(var1.isEmpty()) {
         var6 = "";
      } else {
         StringBuffer var3 = new StringBuffer();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            var3.append((String)var4.next());
            var3.append(' ');
            if(var3.length() > var2) {
               break;
            }
         }

         var3.deleteCharAt(-1 + var3.length());
         var6 = var3.toString();
         if(var6.length() >= var2) {
            return var6.substring(0, var2);
         }
      }

      return var6;
   }

   // $FF: renamed from: j (java.lang.String) void
   private void method_1562(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (int, int) int
   int method_1563(int var1, int var2) {
      return var1 * this.field_391 + var2 * this.field_392;
   }

   // $FF: renamed from: aS () boolean
   public boolean method_1564() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aT () java.lang.String
   public String method_1565() {
      return this.field_400;
   }

   // $FF: renamed from: aU () void
   public void method_1566() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aV () void
   public void method_1567() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aW () void
   public void method_1568() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aX () void
   public void method_1569() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aY () int
   int method_1570() {
      return this.field_396;
   }

   // $FF: renamed from: c (int) void
   public void method_1571(int var1) {
      this.field_397 = var1;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_227) {
         if(var1 == this) {
            return true;
         }

         class_227 var2 = (class_227)var1;
         if(var2.method_1565() != null && var2.method_1565().equals(this.method_1565())) {
            return true;
         }
      }

      return false;
   }

   public int getScore() {
      return this.field_399;
   }

   // $FF: renamed from: h (java.lang.String) void
   public void method_1572(String param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      return this.method_1565().hashCode();
   }

   // $FF: renamed from: i (java.lang.String) void
   public void method_1573(String var1) {
      this.method_1562(var1);
   }

   public String toString() {
      return "ActivityContent fetchId: " + this.field_397 + " score:" + this.field_399 + " total_length:" + this.field_396 + "\n text: " + this.method_1561(this.field_395, 200) + "\n signture: " + this.field_400;
   }
}
