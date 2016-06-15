package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dh;

// $FF: renamed from: com.google.android.gms.tagmanager.dh
class class_636 extends Number implements Comparable<dh> {
   private double atZ;
   private long aua;
   private boolean aub;

   private class_636(double var1) {
      this.atZ = var1;
      this.aub = false;
   }

   private class_636(long var1) {
      this.aua = var1;
      this.aub = true;
   }

   // $FF: renamed from: a (java.lang.Double) com.google.android.gms.tagmanager.dh
   public static class_636 method_3601(Double var0) {
      return new class_636(var0.doubleValue());
   }

   // $FF: renamed from: cY (java.lang.String) com.google.android.gms.tagmanager.dh
   public static class_636 method_3602(String var0) throws NumberFormatException {
      try {
         class_636 var1 = new class_636(Long.parseLong(var0));
         return var1;
      } catch (NumberFormatException var6) {
         try {
            class_636 var3 = new class_636(Double.parseDouble(var0));
            return var3;
         } catch (NumberFormatException var5) {
            throw new NumberFormatException(var0 + " is not a valid TypedNumber");
         }
      }
   }

   // $FF: renamed from: z (long) com.google.android.gms.tagmanager.dh
   public static class_636 method_3603(long var0) {
      return new class_636(var0);
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dh) int
   public int method_3604(class_636 var1) {
      return this.method_3606() && var1.method_3606()?(new Long(this.aua)).compareTo(Long.valueOf(var1.aua)):Double.compare(this.doubleValue(), var1.doubleValue());
   }

   public byte byteValue() {
      return (byte)((int)this.longValue());
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.method_3604((class_636)var1);
   }

   public double doubleValue() {
      return this.method_3606()?(double)this.aua:this.atZ;
   }

   public boolean equals(Object var1) {
      return var1 instanceof class_636 && this.method_3604((class_636)var1) == 0;
   }

   public float floatValue() {
      return (float)this.doubleValue();
   }

   public int hashCode() {
      return (new Long(this.longValue())).hashCode();
   }

   public int intValue() {
      return this.method_3608();
   }

   public long longValue() {
      return this.method_3607();
   }

   // $FF: renamed from: qQ () boolean
   public boolean method_3605() {
      return !this.method_3606();
   }

   // $FF: renamed from: qR () boolean
   public boolean method_3606() {
      return this.aub;
   }

   // $FF: renamed from: qS () long
   public long method_3607() {
      return this.method_3606()?this.aua:(long)this.atZ;
   }

   // $FF: renamed from: qT () int
   public int method_3608() {
      return (int)this.longValue();
   }

   // $FF: renamed from: qU () short
   public short method_3609() {
      return (short)((int)this.longValue());
   }

   public short shortValue() {
      return this.method_3609();
   }

   public String toString() {
      return this.method_3606()?Long.toString(this.aua):Double.toString(this.atZ);
   }
}
