package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.class_722;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
   public static final Creator<Cart> CREATOR = new class_722();
   String aiH;
   String aiI;
   ArrayList<LineItem> aiJ;
   // $FF: renamed from: xJ int
   private final int field_2732;

   Cart() {
      this.field_2732 = 1;
      this.aiJ = new ArrayList();
   }

   Cart(int var1, String var2, String var3, ArrayList<LineItem> var4) {
      this.field_2732 = var1;
      this.aiH = var2;
      this.aiI = var3;
      this.aiJ = var4;
   }

   public static Cart.Builder newBuilder() {
      Cart var0 = new Cart();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getCurrencyCode() {
      return this.aiI;
   }

   public ArrayList<LineItem> getLineItems() {
      return this.aiJ;
   }

   public String getTotalPrice() {
      return this.aiH;
   }

   public int getVersionCode() {
      return this.field_2732;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_722.method_4097(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public Cart.Builder addLineItem(LineItem var1) {
         Cart.this.aiJ.add(var1);
         return this;
      }

      public Cart build() {
         return Cart.this;
      }

      public Cart.Builder setCurrencyCode(String var1) {
         Cart.this.aiI = var1;
         return this;
      }

      public Cart.Builder setLineItems(List<LineItem> var1) {
         Cart.this.aiJ.clear();
         Cart.this.aiJ.addAll(var1);
         return this;
      }

      public Cart.Builder setTotalPrice(String var1) {
         Cart.this.aiH = var1;
         return this;
      }
   }
}
