package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_905;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.pf
public final class class_908 {
    private int awA;
    private int awB;
    private int awC;
    private int awD;
    private int awE = Integer.MAX_VALUE;
    private int awF;
    private int awG = 64;
    private int awH = 67108864;
    private int awz;
    private final byte[] buffer;

    private class_908(byte[] var1, int var2, int var3) {
        this.buffer = var1;
        this.awz = var2;
        this.awA = var2 + var3;
        this.awC = var2;
    }

    // $FF: renamed from: A (long) long
    public static long method_4641(long var0) {
        return var0 >>> 1 ^ -(1L & var0);
    }

    // $FF: renamed from: a (byte[], int, int) com.google.android.gms.internal.pf
    public static class_908 method_4642(byte[] var0, int var1, int var2) {
        return new class_908(var0, var1, var2);
    }

    // $FF: renamed from: go (int) int
    public static int method_4643(int var0) {
        return var0 >>> 1 ^ -(var0 & 1);
    }

    // $FF: renamed from: p (byte[]) com.google.android.gms.internal.pf
    public static class_908 method_4644(byte[] var0) {
        return method_4642(var0, 0, var0.length);
    }

    // $FF: renamed from: qt () void
    private void method_4645() {
        this.awA += this.awB;
        int var1 = this.awA;
        if(var1 > this.awE) {
            this.awB = var1 - this.awE;
            this.awA -= this.awB;
        } else {
            this.awB = 0;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pn) void
    public void method_4646(class_307 var1) throws IOException {
        int var2 = this.method_4662();
        if(this.awF >= this.awG) {
            throw class_899.method_4605();
        } else {
            int var3 = this.method_4650(var2);
            ++this.awF;
            var1.method_2113(this);
            this.method_4648(0);
            this.awF += -1;
            this.method_4651(var3);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pn, int) void
    public void method_4647(class_307 var1, int var2) throws IOException {
        if(this.awF >= this.awG) {
            throw class_899.method_4605();
        } else {
            ++this.awF;
            var1.method_2113(this);
            this.method_4648(class_905.method_4638(var2, 4));
            this.awF += -1;
        }
    }

    public int getPosition() {
        return this.awC - this.awz;
    }

    // $FF: renamed from: gm (int) void
    public void method_4648(int var1) throws class_899 {
        if(this.awD != var1) {
            throw class_899.method_4603();
        }
    }

    // $FF: renamed from: gn (int) boolean
    public boolean method_4649(int var1) throws IOException {
        switch(class_905.method_4636(var1)) {
            case 0:
                this.method_4658();
                return true;
            case 1:
                this.method_4665();
                return true;
            case 2:
                this.method_4654(this.method_4662());
                return true;
            case 3:
                this.method_4656();
                this.method_4648(class_905.method_4638(class_905.method_4637(var1), 4));
                return true;
            case 4:
                return false;
            case 5:
                this.method_4664();
                return true;
            default:
                throw class_899.method_4604();
        }
    }

    // $FF: renamed from: gp (int) int
    public int method_4650(int var1) throws class_899 {
        if(var1 < 0) {
            throw class_899.method_4600();
        } else {
            int var2 = var1 + this.awC;
            int var3 = this.awE;
            if(var2 > var3) {
                throw class_899.method_4599();
            } else {
                this.awE = var2;
                this.method_4645();
                return var3;
            }
        }
    }

    // $FF: renamed from: gq (int) void
    public void method_4651(int var1) {
        this.awE = var1;
        this.method_4645();
    }

    // $FF: renamed from: gr (int) void
    public void method_4652(int var1) {
        if(var1 > this.awC - this.awz) {
            throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.awC - this.awz));
        } else if(var1 < 0) {
            throw new IllegalArgumentException("Bad position " + var1);
        } else {
            this.awC = var1 + this.awz;
        }
    }

    // $FF: renamed from: gs (int) byte[]
    public byte[] method_4653(int var1) throws IOException {
        if(var1 < 0) {
            throw class_899.method_4600();
        } else if(var1 + this.awC > this.awE) {
            this.method_4654(this.awE - this.awC);
            throw class_899.method_4599();
        } else if(var1 <= this.awA - this.awC) {
            byte[] var2 = new byte[var1];
            System.arraycopy(this.buffer, this.awC, var2, 0, var1);
            this.awC += var1;
            return var2;
        } else {
            throw class_899.method_4599();
        }
    }

    // $FF: renamed from: gt (int) void
    public void method_4654(int var1) throws IOException {
        if(var1 < 0) {
            throw class_899.method_4600();
        } else if(var1 + this.awC > this.awE) {
            this.method_4654(this.awE - this.awC);
            throw class_899.method_4599();
        } else if(var1 <= this.awA - this.awC) {
            this.awC += var1;
        } else {
            throw class_899.method_4599();
        }
    }

    // $FF: renamed from: qi () int
    public int method_4655() throws IOException {
        if(this.method_4667()) {
            this.awD = 0;
            return 0;
        } else {
            this.awD = this.method_4662();
            if(this.awD == 0) {
                throw class_899.method_4602();
            } else {
                return this.awD;
            }
        }
    }

    // $FF: renamed from: qj () void
    public void method_4656() throws IOException {
        int var1;
        do {
            var1 = this.method_4655();
        } while(var1 != 0 && this.method_4649(var1));

    }

    // $FF: renamed from: qk () long
    public long method_4657() throws IOException {
        return this.method_4663();
    }

    // $FF: renamed from: ql () int
    public int method_4658() throws IOException {
        return this.method_4662();
    }

    // $FF: renamed from: qm () boolean
    public boolean method_4659() throws IOException {
        return this.method_4662() != 0;
    }

    // $FF: renamed from: qn () int
    public int method_4660() throws IOException {
        return method_4643(this.method_4662());
    }

    // $FF: renamed from: qo () long
    public long method_4661() throws IOException {
        return method_4641(this.method_4663());
    }

    // $FF: renamed from: qp () int
    public int method_4662() throws IOException {
        int var1 = this.method_4668();
        if(var1 < 0) {
            int var2 = var1 & 127;
            byte var3 = this.method_4668();
            if(var3 >= 0) {
                return var2 | var3 << 7;
            }

            int var4 = var2 | (var3 & 127) << 7;
            byte var5 = this.method_4668();
            if(var5 >= 0) {
                return var4 | var5 << 14;
            }

            int var6 = var4 | (var5 & 127) << 14;
            byte var7 = this.method_4668();
            if(var7 >= 0) {
                return var6 | var7 << 21;
            }

            int var8 = var6 | (var7 & 127) << 21;
            byte var9 = this.method_4668();
            var1 = var8 | var9 << 28;
            if(var9 < 0) {
                int var10 = 0;

                while(true) {
                    if(var10 >= 5) {
                        throw class_899.method_4601();
                    }

                    if(this.method_4668() >= 0) {
                        break;
                    }

                    ++var10;
                }
            }
        }

        return var1;
    }

    // $FF: renamed from: qq () long
    public long method_4663() throws IOException {
        int var1 = 0;

        for(long var2 = 0L; var1 < 64; var1 += 7) {
            byte var4 = this.method_4668();
            var2 |= (long)(var4 & 127) << var1;
            if((var4 & 128) == 0) {
                return var2;
            }
        }

        throw class_899.method_4601();
    }

    // $FF: renamed from: qr () int
    public int method_4664() throws IOException {
        byte var1 = this.method_4668();
        byte var2 = this.method_4668();
        byte var3 = this.method_4668();
        byte var4 = this.method_4668();
        return var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24;
    }

    // $FF: renamed from: qs () long
    public long method_4665() throws IOException {
        byte var1 = this.method_4668();
        byte var2 = this.method_4668();
        byte var3 = this.method_4668();
        byte var4 = this.method_4668();
        byte var5 = this.method_4668();
        byte var6 = this.method_4668();
        byte var7 = this.method_4668();
        byte var8 = this.method_4668();
        return 255L & (long)var1 | (255L & (long)var2) << 8 | (255L & (long)var3) << 16 | (255L & (long)var4) << 24 | (255L & (long)var5) << 32 | (255L & (long)var6) << 40 | (255L & (long)var7) << 48 | (255L & (long)var8) << 56;
    }

    // $FF: renamed from: qu () int
    public int method_4666() {
        if(this.awE == Integer.MAX_VALUE) {
            return -1;
        } else {
            int var1 = this.awC;
            return this.awE - var1;
        }
    }

    // $FF: renamed from: qv () boolean
    public boolean method_4667() {
        return this.awC == this.awA;
    }

    // $FF: renamed from: qw () byte
    public byte method_4668() throws IOException {
        if(this.awC == this.awA) {
            throw class_899.method_4599();
        } else {
            byte[] var1 = this.buffer;
            int var2 = this.awC;
            this.awC = var2 + 1;
            return var1[var2];
        }
    }

    // $FF: renamed from: r (int, int) byte[]
    public byte[] method_4669(int var1, int var2) {
        if(var2 == 0) {
            return class_905.axd;
        } else {
            byte[] var3 = new byte[var2];
            int var4 = var1 + this.awz;
            System.arraycopy(this.buffer, var4, var3, 0, var2);
            return var3;
        }
    }

    public byte[] readBytes() throws IOException {
        int var1 = this.method_4662();
        if(var1 <= this.awA - this.awC && var1 > 0) {
            byte[] var2 = new byte[var1];
            System.arraycopy(this.buffer, this.awC, var2, 0, var1);
            this.awC += var1;
            return var2;
        } else {
            return this.method_4653(var1);
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.method_4665());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.method_4664());
    }

    public String readString() throws IOException {
        int var1 = this.method_4662();
        if(var1 <= this.awA - this.awC && var1 > 0) {
            String var2 = new String(this.buffer, this.awC, var1, "UTF-8");
            this.awC += var1;
            return var2;
        } else {
            return new String(this.method_4653(var1), "UTF-8");
        }
    }
}
