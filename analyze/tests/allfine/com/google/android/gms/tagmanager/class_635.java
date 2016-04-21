package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dh;

// $FF: renamed from: com.google.android.gms.tagmanager.dh
class class_635 extends Number implements Comparable<dh> {
    private double arR;
    private long arS;
    private boolean arT;

    private class_635(double var1) {
        this.arR = var1;
        this.arT = false;
    }

    private class_635(long var1) {
        this.arS = var1;
        this.arT = true;
    }

    // $FF: renamed from: a (java.lang.Double) com.google.android.gms.tagmanager.dh
    public static class_635 method_3565(Double var0) {
        return new class_635(var0.doubleValue());
    }

    // $FF: renamed from: cW (java.lang.String) com.google.android.gms.tagmanager.dh
    public static class_635 method_3566(String var0) throws NumberFormatException {
        try {
            class_635 var1 = new class_635(Long.parseLong(var0));
            return var1;
        } catch (NumberFormatException var6) {
            try {
                class_635 var3 = new class_635(Double.parseDouble(var0));
                return var3;
            } catch (NumberFormatException var5) {
                throw new NumberFormatException(var0 + " is not a valid TypedNumber");
            }
        }
    }

    // $FF: renamed from: z (long) com.google.android.gms.tagmanager.dh
    public static class_635 method_3567(long var0) {
        return new class_635(var0);
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.dh) int
    public int method_3568(class_635 var1) {
        return this.method_3569() && var1.method_3569()?(new Long(this.arS)).compareTo(Long.valueOf(var1.arS)):Double.compare(this.doubleValue(), var1.doubleValue());
    }

    public byte byteValue() {
        return (byte)((int)this.longValue());
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.method_3568((class_635)var1);
    }

    public double doubleValue() {
        return this.method_3569()?(double)this.arS:this.arR;
    }

    public boolean equals(Object var1) {
        return var1 instanceof class_635 && this.method_3568((class_635)var1) == 0;
    }

    public float floatValue() {
        return (float)this.doubleValue();
    }

    public int hashCode() {
        return (new Long(this.longValue())).hashCode();
    }

    public int intValue() {
        return this.method_3571();
    }

    public long longValue() {
        return this.method_3570();
    }

    // $FF: renamed from: pA () boolean
    public boolean method_3569() {
        return this.arT;
    }

    // $FF: renamed from: pB () long
    public long method_3570() {
        return this.method_3569()?this.arS:(long)this.arR;
    }

    // $FF: renamed from: pC () int
    public int method_3571() {
        return (int)this.longValue();
    }

    // $FF: renamed from: pD () short
    public short method_3572() {
        return (short)((int)this.longValue());
    }

    // $FF: renamed from: pz () boolean
    public boolean method_3573() {
        return !this.method_3569();
    }

    public short shortValue() {
        return this.method_3572();
    }

    public String toString() {
        return this.method_3569()?Long.toString(this.arS):Double.toString(this.arR);
    }
}
