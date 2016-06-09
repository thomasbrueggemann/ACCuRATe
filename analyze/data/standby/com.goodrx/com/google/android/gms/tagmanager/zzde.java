package com.google.android.gms.tagmanager;

class zzde extends Number implements Comparable<zzde> {
   private double zzblB;
   private long zzblC;
   private boolean zzblD;

   private zzde(double var1) {
      this.zzblB = var1;
      this.zzblD = false;
   }

   private zzde(long var1) {
      this.zzblC = var1;
      this.zzblD = true;
   }

   public static zzde zza(Double var0) {
      return new zzde(var0.doubleValue());
   }

   public static zzde zzam(long var0) {
      return new zzde(var0);
   }

   public static zzde zzgs(String var0) throws NumberFormatException {
      try {
         zzde var1 = new zzde(Long.parseLong(var0));
         return var1;
      } catch (NumberFormatException var6) {
         try {
            zzde var3 = new zzde(Double.parseDouble(var0));
            return var3;
         } catch (NumberFormatException var5) {
            throw new NumberFormatException(var0 + " is not a valid TypedNumber");
         }
      }
   }

   public byte byteValue() {
      return (byte)((int)this.longValue());
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.zza((zzde)var1);
   }

   public double doubleValue() {
      return this.zzHv()?(double)this.zzblC:this.zzblB;
   }

   public boolean equals(Object var1) {
      return var1 instanceof zzde && this.zza((zzde)var1) == 0;
   }

   public float floatValue() {
      return (float)this.doubleValue();
   }

   public int hashCode() {
      return (new Long(this.longValue())).hashCode();
   }

   public int intValue() {
      return this.zzHx();
   }

   public long longValue() {
      return this.zzHw();
   }

   public short shortValue() {
      return this.zzHy();
   }

   public String toString() {
      return this.zzHv()?Long.toString(this.zzblC):Double.toString(this.zzblB);
   }

   public boolean zzHu() {
      return !this.zzHv();
   }

   public boolean zzHv() {
      return this.zzblD;
   }

   public long zzHw() {
      return this.zzHv()?this.zzblC:(long)this.zzblB;
   }

   public int zzHx() {
      return (int)this.longValue();
   }

   public short zzHy() {
      return (short)((int)this.longValue());
   }

   public int zza(zzde var1) {
      return this.zzHv() && var1.zzHv()?(new Long(this.zzblC)).compareTo(Long.valueOf(var1.zzblC)):Double.compare(this.doubleValue(), var1.doubleValue());
   }
}
