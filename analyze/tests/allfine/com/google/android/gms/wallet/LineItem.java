package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1025;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new class_1025();
    // $FF: renamed from: BR int
    private final int field_4551;
    String asP;
    String asQ;
    int asR;
    String asv;
    String asw;
    String description;

    LineItem() {
        this.field_4551 = 1;
        this.asR = 0;
    }

    LineItem(int var1, String var2, String var3, String var4, String var5, int var6, String var7) {
        this.field_4551 = var1;
        this.description = var2;
        this.asP = var3;
        this.asQ = var4;
        this.asv = var5;
        this.asR = var6;
        this.asw = var7;
    }

    public static LineItem.Builder newBuilder() {
        LineItem var0 = new LineItem();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.asw;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.asP;
    }

    public int getRole() {
        return this.asR;
    }

    public String getTotalPrice() {
        return this.asv;
    }

    public String getUnitPrice() {
        return this.asQ;
    }

    public int getVersionCode() {
        return this.field_4551;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1025.method_5348(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public LineItem build() {
            return LineItem.this;
        }

        public LineItem.Builder setCurrencyCode(String var1) {
            LineItem.this.asw = var1;
            return this;
        }

        public LineItem.Builder setDescription(String var1) {
            LineItem.this.description = var1;
            return this;
        }

        public LineItem.Builder setQuantity(String var1) {
            LineItem.this.asP = var1;
            return this;
        }

        public LineItem.Builder setRole(int var1) {
            LineItem.this.asR = var1;
            return this;
        }

        public LineItem.Builder setTotalPrice(String var1) {
            LineItem.this.asv = var1;
            return this;
        }

        public LineItem.Builder setUnitPrice(String var1) {
            LineItem.this.asQ = var1;
            return this;
        }
    }

    public interface Role {
        int REGULAR = 0;
        int SHIPPING = 2;
        int TAX = 1;
    }
}
