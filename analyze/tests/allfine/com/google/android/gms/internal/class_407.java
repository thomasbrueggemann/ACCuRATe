package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_405;
import com.google.android.gms.internal.class_406;
import com.google.android.gms.internal.hs;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hm
public class class_407 {
    public static class class_1640 implements SafeParcelable {
        public static final class_406 CREATOR = new class_406();
        // $FF: renamed from: BR int
        final int field_5288;
        // $FF: renamed from: Cj android.accounts.Account
        public final Account field_5289;

        public class_1640() {
            this((Account)null);
        }

        class_1640(int var1, Account var2) {
            this.field_5288 = var1;
            this.field_5289 = var2;
        }

        public class_1640(Account var1) {
            this(1, var1);
        }

        public int describeContents() {
            class_406 var10000 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_406 var10000 = CREATOR;
            class_406.method_2642(this, var1, var2);
        }
    }

    public static class class_1641 implements Result, SafeParcelable {
        public static final class_405 CREATOR = new class_405();
        // $FF: renamed from: BR int
        final int field_5290;
        // $FF: renamed from: Ck com.google.android.gms.common.api.Status
        public Status field_5291;
        // $FF: renamed from: Cl java.util.List
        public List<hs> field_5292;

        public class_1641() {
            this.field_5290 = 1;
        }

        class_1641(int var1, Status var2, List<hs> var3) {
            this.field_5290 = var1;
            this.field_5291 = var2;
            this.field_5292 = var3;
        }

        public int describeContents() {
            class_405 var10000 = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.field_5291;
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_405 var10000 = CREATOR;
            class_405.method_2639(this, var1, var2);
        }
    }
}
