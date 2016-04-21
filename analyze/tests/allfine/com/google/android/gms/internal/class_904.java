package com.google.android.gms.internal;

import com.google.android.gms.internal.class_903;

// $FF: renamed from: com.google.android.gms.internal.pj
class class_904 {
    private static final class_903 awM = new class_903();
    private boolean awN;
    private int[] awO;
    private class_903[] awP;
    private int mSize;

    public class_904() {
        this(10);
    }

    public class_904(int var1) {
        this.awN = false;
        int var2 = this.idealIntArraySize(var1);
        this.awO = new int[var2];
        this.awP = new class_903[var2];
        this.mSize = 0;
    }

    // $FF: renamed from: a (int[], int[], int) boolean
    private boolean method_4628(int[] var1, int[] var2, int var3) {
        for(int var4 = 0; var4 < var3; ++var4) {
            if(var1[var4] != var2[var4]) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pk[], com.google.android.gms.internal.pk[], int) boolean
    private boolean method_4629(class_903[] var1, class_903[] var2, int var3) {
        for(int var4 = 0; var4 < var3; ++var4) {
            if(!var1[var4].equals(var2[var4])) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: gG (int) int
    private int method_4630(int var1) {
        int var2 = 0;
        int var3 = -1 + this.mSize;

        while(var2 <= var3) {
            int var4 = var2 + var3 >>> 1;
            int var5 = this.awO[var4];
            if(var5 < var1) {
                var2 = var4 + 1;
            } else {
                if(var5 <= var1) {
                    return var4;
                }

                var3 = var4 - 1;
            }
        }

        return ~var2;
    }

    // $FF: renamed from: gc () void
    private void method_4631() {
        int var1 = this.mSize;
        int[] var2 = this.awO;
        class_903[] var3 = this.awP;
        int var4 = 0;

        int var5;
        for(var5 = 0; var4 < var1; ++var4) {
            class_903 var6 = var3[var4];
            if(var6 != awM) {
                if(var4 != var5) {
                    var2[var5] = var2[var4];
                    var3[var5] = var6;
                    var3[var4] = null;
                }

                ++var5;
            }
        }

        this.awN = false;
        this.mSize = var5;
    }

    private int idealByteArraySize(int var1) {
        for(int var2 = 4; var2 < 32; ++var2) {
            if(var1 <= -12 + (1 << var2)) {
                var1 = -12 + (1 << var2);
                break;
            }
        }

        return var1;
    }

    private int idealIntArraySize(int var1) {
        return this.idealByteArraySize(var1 * 4) / 4;
    }

    // $FF: renamed from: a (int, com.google.android.gms.internal.pk) void
    public void method_4632(int var1, class_903 var2) {
        int var3 = this.method_4630(var1);
        if(var3 >= 0) {
            this.awP[var3] = var2;
        } else {
            int var4 = ~var3;
            if(var4 < this.mSize && this.awP[var4] == awM) {
                this.awO[var4] = var1;
                this.awP[var4] = var2;
            } else {
                if(this.awN && this.mSize >= this.awO.length) {
                    this.method_4631();
                    var4 = ~this.method_4630(var1);
                }

                if(this.mSize >= this.awO.length) {
                    int var5 = this.idealIntArraySize(1 + this.mSize);
                    int[] var6 = new int[var5];
                    class_903[] var7 = new class_903[var5];
                    System.arraycopy(this.awO, 0, var6, 0, this.awO.length);
                    System.arraycopy(this.awP, 0, var7, 0, this.awP.length);
                    this.awO = var6;
                    this.awP = var7;
                }

                if(this.mSize - var4 != 0) {
                    System.arraycopy(this.awO, var4, this.awO, var4 + 1, this.mSize - var4);
                    System.arraycopy(this.awP, var4, this.awP, var4 + 1, this.mSize - var4);
                }

                this.awO[var4] = var1;
                this.awP[var4] = var2;
                ++this.mSize;
            }
        }
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof class_904)) {
                return false;
            }

            class_904 var2 = (class_904)var1;
            if(this.size() != var2.size()) {
                return false;
            }

            if(!this.method_4628(this.awO, var2.awO, this.mSize) || !this.method_4629(this.awP, var2.awP, this.mSize)) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: gE (int) com.google.android.gms.internal.pk
    public class_903 method_4633(int var1) {
        int var2 = this.method_4630(var1);
        return var2 >= 0 && this.awP[var2] != awM?this.awP[var2]:null;
    }

    // $FF: renamed from: gF (int) com.google.android.gms.internal.pk
    public class_903 method_4634(int var1) {
        if(this.awN) {
            this.method_4631();
        }

        return this.awP[var1];
    }

    public int hashCode() {
        if(this.awN) {
            this.method_4631();
        }

        int var1 = 17;

        for(int var2 = 0; var2 < this.mSize; ++var2) {
            var1 = 31 * (var1 * 31 + this.awO[var2]) + this.awP[var2].hashCode();
        }

        return var1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        if(this.awN) {
            this.method_4631();
        }

        return this.mSize;
    }
}
