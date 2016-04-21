package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.class_1026;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new class_1026();
    // $FF: renamed from: BR int
    private final int field_2886;
    String asv;
    String asw;
    ArrayList<LineItem> asx;

    Cart() {
        this.field_2886 = 1;
        this.asx = new ArrayList();
    }

    Cart(int var1, String var2, String var3, ArrayList<LineItem> var4) {
        this.field_2886 = var1;
        this.asv = var2;
        this.asw = var3;
        this.asx = var4;
    }

    public static Cart.Builder newBuilder() {
        Cart var0 = new Cart();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.asw;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.asx;
    }

    public String getTotalPrice() {
        return this.asv;
    }

    public int getVersionCode() {
        return this.field_2886;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1026.method_5351(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public Cart.Builder addLineItem(LineItem var1) {
            Cart.this.asx.add(var1);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Cart.Builder setCurrencyCode(String var1) {
            Cart.this.asw = var1;
            return this;
        }

        public Cart.Builder setLineItems(List<LineItem> var1) {
            Cart.this.asx.clear();
            Cart.this.asx.addAll(var1);
            return this;
        }

        public Cart.Builder setTotalPrice(String var1) {
            Cart.this.asv = var1;
            return this;
        }
    }
}
