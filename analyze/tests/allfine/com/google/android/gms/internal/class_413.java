package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_398;
import com.google.android.gms.internal.class_403;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.hi;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.he
public class class_413 implements SafeParcelable {
    public static final class_412 CREATOR = new class_412();
    // $FF: renamed from: BR int
    final int field_1531;
    // $FF: renamed from: BS com.google.android.gms.internal.hi[]
    final class_403[] field_1532;
    // $FF: renamed from: BT java.lang.String
    public final String field_1533;
    // $FF: renamed from: BU boolean
    public final boolean field_1534;
    public final Account account;

    class_413(int var1, class_403[] var2, String var3, boolean var4, Account var5) {
        this.field_1531 = var1;
        this.field_1532 = var2;
        this.field_1533 = var3;
        this.field_1534 = var4;
        this.account = var5;
    }

    class_413(String var1, boolean var2, Account var3, class_403... var4) {
        this(1, var4, var1, var2, var3);
        BitSet var5 = new BitSet(class_398.method_2625());

        for(int var6 = 0; var6 < var4.length; ++var6) {
            int var7 = var4[var6].field_1503;
            if(var7 != -1) {
                if(var5.get(var7)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + class_398.method_2623(var7));
                }

                var5.set(var7);
            }
        }

    }

    public int describeContents() {
        class_412 var10000 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_412 var10000 = CREATOR;
        class_412.method_2664(this, var1, var2);
    }

    public static class class_1646 {
        // $FF: renamed from: BV java.util.List
        private List<hi> field_5274;
        // $FF: renamed from: BW java.lang.String
        private String field_5275;
        // $FF: renamed from: BX boolean
        private boolean field_5276;
        // $FF: renamed from: BY android.accounts.Account
        private Account field_5277;

        // $FF: renamed from: D (boolean) com.google.android.gms.internal.he$a
        public class_413.class_1646 method_5932(boolean var1) {
            this.field_5276 = var1;
            return this;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hi) com.google.android.gms.internal.he$a
        public class_413.class_1646 method_5933(class_403 var1) {
            if(this.field_5274 == null) {
                this.field_5274 = new ArrayList();
            }

            this.field_5274.add(var1);
            return this;
        }

        // $FF: renamed from: ar (java.lang.String) com.google.android.gms.internal.he$a
        public class_413.class_1646 method_5934(String var1) {
            this.field_5275 = var1;
            return this;
        }

        // $FF: renamed from: fj () com.google.android.gms.internal.he
        public class_413 method_5935() {
            String var1 = this.field_5275;
            boolean var2 = this.field_5276;
            Account var3 = this.field_5277;
            class_403[] var4;
            if(this.field_5274 != null) {
                var4 = (class_403[])this.field_5274.toArray(new class_403[this.field_5274.size()]);
            } else {
                var4 = null;
            }

            return new class_413(var1, var2, var3, var4);
        }
    }
}
