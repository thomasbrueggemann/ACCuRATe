package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dg;

// $FF: renamed from: com.google.android.gms.tagmanager.dg
class class_536 extends Number implements Comparable<dg> {
   private double aih;
   private long aii;
   private boolean aij;

   private class_536(double var1) {
      this.aih = var1;
      this.aij = false;
   }

   private class_536(long var1) {
      this.aii = var1;
      this.aij = true;
   }

   // $FF: renamed from: a (java.lang.Double) com.google.android.gms.tagmanager.dg
   public static class_536 method_2995(Double var0) {
      return new class_536(var0.doubleValue());
   }

   // $FF: renamed from: co (java.lang.String) com.google.android.gms.tagmanager.dg
   public static class_536 method_2996(String var0) throws NumberFormatException {
      try {
         class_536 var1 = new class_536(Long.parseLong(var0));
         return var1;
      } catch (NumberFormatException var6) {
         try {
            class_536 var3 = new class_536(Double.parseDouble(var0));
            return var3;
         } catch (NumberFormatException var5) {
            throw new NumberFormatException(var0 + " is not a valid TypedNumber");
         }
      }
   }

   // $FF: renamed from: z (long) com.google.android.gms.tagmanager.dg
   public static class_536 method_2997(long var0) {
      return new class_536(var0);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dg) int
   public int method_2998(class_536 var1) {
      return this.method_3000() && var1.method_3000()?(new Long(this.aii)).compareTo(Long.valueOf(var1.aii)):Double.compare(this.doubleValue(), var1.doubleValue());
   }

   public byte byteValue() {
      return (byte)((int)this.longValue());
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.method_2998((class_536)var1);
   }

   public double doubleValue() {
      return this.method_3000()?(double)this.aii:this.aih;
   }

   public boolean equals(Object var1) {
      return var1 instanceof class_536 && this.method_2998((class_536)var1) == 0;
   }

   public float floatValue() {
      return (float)this.doubleValue();
   }

   public int hashCode() {
      return (new Long(this.longValue())).hashCode();
   }

   public int intValue() {
      return this.method_3002();
   }

   public long longValue() {
      return this.method_3001();
   }

   // $FF: renamed from: mN () boolean
   public boolean method_2999() {
      return !this.method_3000();
   }

   // $FF: renamed from: mO () boolean
   public boolean method_3000() {
      return this.aij;
   }

   // $FF: renamed from: mP () long
   public long method_3001() {
      return this.method_3000()?this.aii:(long)this.aih;
   }

   // $FF: renamed from: mQ () int
   public int method_3002() {
      return (int)this.longValue();
   }

   // $FF: renamed from: mR () short
   public short method_3003() {
      return (short)((int)this.longValue());
   }

   public short shortValue() {
      return this.method_3003();
   }

   public String toString() {
      return this.method_3000()?Long.toString(this.aii):Double.toString(this.aih);
   }
}
