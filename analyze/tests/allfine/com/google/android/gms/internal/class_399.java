package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_396;
import com.google.android.gms.internal.class_401;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hq
public class class_399 implements SafeParcelable {
    public static final class_396 CREATOR = new class_396();
    // $FF: renamed from: BR int
    final int field_1487;
    // $FF: renamed from: Co java.lang.String
    public final String field_1488;
    // $FF: renamed from: Cp boolean
    public final boolean field_1489;
    // $FF: renamed from: Cq boolean
    public final boolean field_1490;
    // $FF: renamed from: Cr java.lang.String
    public final String field_1491;
    // $FF: renamed from: Cs com.google.android.gms.internal.hk[]
    public final class_401[] field_1492;
    // $FF: renamed from: Ct int[]
    final int[] field_1493;
    // $FF: renamed from: Cu java.lang.String
    public final String field_1494;
    public final String name;
    public final int weight;

    class_399(int var1, String var2, String var3, boolean var4, int var5, boolean var6, String var7, class_401[] var8, int[] var9, String var10) {
        this.field_1487 = var1;
        this.name = var2;
        this.field_1488 = var3;
        this.field_1489 = var4;
        this.weight = var5;
        this.field_1490 = var6;
        this.field_1491 = var7;
        this.field_1492 = var8;
        this.field_1493 = var9;
        this.field_1494 = var10;
    }

    class_399(String var1, String var2, boolean var3, int var4, boolean var5, String var6, class_401[] var7, int[] var8, String var9) {
        this(2, var1, var2, var3, var4, var5, var6, var7, var8, var9);
    }

    public int describeContents() {
        class_396 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        boolean var2 = var1 instanceof class_399;
        boolean var3 = false;
        if(var2) {
            class_399 var4 = (class_399)var1;
            boolean var5 = this.name.equals(var4.name);
            var3 = false;
            if(var5) {
                boolean var6 = this.field_1488.equals(var4.field_1488);
                var3 = false;
                if(var6) {
                    boolean var7 = this.field_1489;
                    boolean var8 = var4.field_1489;
                    var3 = false;
                    if(var7 == var8) {
                        var3 = true;
                    }
                }
            }
        }

        return var3;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_396 var10000 = CREATOR;
        class_396.method_2612(this, var1, var2);
    }

    public static final class class_1737 {
        // $FF: renamed from: CA java.util.List
        private final List<hk> field_4342;
        // $FF: renamed from: CB java.util.BitSet
        private BitSet field_4343;
        // $FF: renamed from: CC java.lang.String
        private String field_4344;
        // $FF: renamed from: Cv java.lang.String
        private String field_4345;
        // $FF: renamed from: Cw boolean
        private boolean field_4346;
        // $FF: renamed from: Cx int
        private int field_4347;
        // $FF: renamed from: Cy boolean
        private boolean field_4348;
        // $FF: renamed from: Cz java.lang.String
        private String field_4349;
        private final String mName;

        public class_1737(String var1) {
            this.mName = var1;
            this.field_4347 = 1;
            this.field_4342 = new ArrayList();
        }

        // $FF: renamed from: E (boolean) com.google.android.gms.internal.hq$a
        public class_399.class_1737 method_4919(boolean var1) {
            this.field_4346 = var1;
            return this;
        }

        // $FF: renamed from: F (boolean) com.google.android.gms.internal.hq$a
        public class_399.class_1737 method_4920(boolean var1) {
            this.field_4348 = var1;
            return this;
        }

        // $FF: renamed from: P (int) com.google.android.gms.internal.hq$a
        public class_399.class_1737 method_4921(int var1) {
            if(this.field_4343 == null) {
                this.field_4343 = new BitSet();
            }

            this.field_4343.set(var1);
            return this;
        }

        // $FF: renamed from: at (java.lang.String) com.google.android.gms.internal.hq$a
        public class_399.class_1737 method_4922(String var1) {
            this.field_4345 = var1;
            return this;
        }

        // $FF: renamed from: au (java.lang.String) com.google.android.gms.internal.hq$a
        public class_399.class_1737 method_4923(String var1) {
            this.field_4344 = var1;
            return this;
        }

        // $FF: renamed from: fm () com.google.android.gms.internal.hq
        public class_399 method_4924() {
            int var1 = 0;
            BitSet var2 = this.field_4343;
            int[] var3 = null;
            if(var2 != null) {
                var3 = new int[this.field_4343.cardinality()];

                int var5;
                for(int var4 = this.field_4343.nextSetBit(0); var4 >= 0; var1 = var5) {
                    var5 = var1 + 1;
                    var3[var1] = var4;
                    var4 = this.field_4343.nextSetBit(var4 + 1);
                }
            }

            return new class_399(this.mName, this.field_4345, this.field_4346, this.field_4347, this.field_4348, this.field_4349, (class_401[])this.field_4342.toArray(new class_401[this.field_4342.size()]), var3, this.field_4344);
        }
    }
}
