package com.google.tagmanager;

class TypedNumber extends Number implements Comparable<TypedNumber> {
    private double mDouble;
    private long mInt64;
    private boolean mIsInt64;

    private TypedNumber(double var1) {
        this.mDouble = var1;
        this.mIsInt64 = false;
    }

    private TypedNumber(long var1) {
        this.mInt64 = var1;
        this.mIsInt64 = true;
    }

    public static TypedNumber numberWithDouble(Double var0) {
        return new TypedNumber(var0.doubleValue());
    }

    public static TypedNumber numberWithInt64(long var0) {
        return new TypedNumber(var0);
    }

    public static TypedNumber numberWithString(String var0) throws NumberFormatException {
        try {
            TypedNumber var1 = new TypedNumber(Long.parseLong(var0));
            return var1;
        } catch (NumberFormatException var6) {
            try {
                TypedNumber var3 = new TypedNumber(Double.parseDouble(var0));
                return var3;
            } catch (NumberFormatException var5) {
                throw new NumberFormatException(var0 + " is not a valid TypedNumber");
            }
        }
    }

    public byte byteValue() {
        return (byte)((int)this.longValue());
    }

    public int compareTo(TypedNumber var1) {
        return this.isInt64() && var1.isInt64()?(new Long(this.mInt64)).compareTo(Long.valueOf(var1.mInt64)):Double.compare(this.doubleValue(), var1.doubleValue());
    }

    public double doubleValue() {
        return this.isInt64()?(double)this.mInt64:this.mDouble;
    }

    public boolean equals(Object var1) {
        return var1 instanceof TypedNumber && this.compareTo((TypedNumber)var1) == 0;
    }

    public float floatValue() {
        return (float)this.doubleValue();
    }

    public int hashCode() {
        return (new Long(this.longValue())).hashCode();
    }

    public short int16Value() {
        return (short)((int)this.longValue());
    }

    public int int32Value() {
        return (int)this.longValue();
    }

    public long int64Value() {
        return this.isInt64()?this.mInt64:(long)this.mDouble;
    }

    public int intValue() {
        return this.int32Value();
    }

    public boolean isDouble() {
        return !this.isInt64();
    }

    public boolean isInt64() {
        return this.mIsInt64;
    }

    public long longValue() {
        return this.int64Value();
    }

    public short shortValue() {
        return this.int16Value();
    }

    public String toString() {
        return this.isInt64()?Long.toString(this.mInt64):Double.toString(this.mDouble);
    }
}
