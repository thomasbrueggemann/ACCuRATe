package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.class_1016;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Creator<ListSubscriptionsResult> CREATOR = new class_1016();
    // $FF: renamed from: BR int
    private final int field_3069;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_3070;
    // $FF: renamed from: UY java.util.List
    private final List<Subscription> field_3071;

    ListSubscriptionsResult(int var1, List<Subscription> var2, Status var3) {
        this.field_3069 = var1;
        this.field_3071 = var2;
        this.field_3070 = var3;
    }

    public ListSubscriptionsResult(List<Subscription> var1, Status var2) {
        this.field_3069 = 3;
        this.field_3071 = Collections.unmodifiableList(var1);
        this.field_3070 = (Status)class_1090.method_5681(var2, "status");
    }

    // $FF: renamed from: G (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.ListSubscriptionsResult
    public static ListSubscriptionsResult method_3409(Status var0) {
        return new ListSubscriptionsResult(Collections.emptyList(), var0);
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.ListSubscriptionsResult) boolean
    private boolean method_3410(ListSubscriptionsResult var1) {
        return this.field_3070.equals(var1.field_3070) && class_1089.equal(this.field_3071, var1.field_3071);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof ListSubscriptionsResult && this.method_3410((ListSubscriptionsResult)var1);
    }

    public Status getStatus() {
        return this.field_3070;
    }

    public List<Subscription> getSubscriptions() {
        return this.field_3071;
    }

    public List<Subscription> getSubscriptions(DataType var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.field_3071.iterator();

        while(var3.hasNext()) {
            Subscription var4 = (Subscription)var3.next();
            if(var1.equals(var4.method_4912())) {
                var2.add(var4);
            }
        }

        return Collections.unmodifiableList(var2);
    }

    int getVersionCode() {
        return this.field_3069;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_3070, this.field_3071};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_3070).method_5425("subscriptions", this.field_3071).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1016.method_5301(this, var1, var2);
    }
}
