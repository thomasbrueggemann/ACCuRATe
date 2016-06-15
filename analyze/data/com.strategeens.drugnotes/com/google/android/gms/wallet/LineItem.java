package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_940;

public final class LineItem implements SafeParcelable {
   public static final Creator<LineItem> CREATOR = new class_940();
   // $FF: renamed from: CK int
   private final int field_3805;
   String auF;
   String auG;
   String auZ;
   String ava;
   int avb;
   String description;

   LineItem() {
      this.field_3805 = 1;
      this.avb = 0;
   }

   LineItem(int var1, String var2, String var3, String var4, String var5, int var6, String var7) {
      this.field_3805 = var1;
      this.description = var2;
      this.auZ = var3;
      this.ava = var4;
      this.auF = var5;
      this.avb = var6;
      this.auG = var7;
   }

   public static LineItem.Builder newBuilder() {
      LineItem var0 = new LineItem();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getCurrencyCode() {
      return this.auG;
   }

   public String getDescription() {
      return this.description;
   }

   public String getQuantity() {
      return this.auZ;
   }

   public int getRole() {
      return this.avb;
   }

   public String getTotalPrice() {
      return this.auF;
   }

   public String getUnitPrice() {
      return this.ava;
   }

   public int getVersionCode() {
      return this.field_3805;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_940.method_5205(this, var1, var2);
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
         LineItem.this.auG = var1;
         return this;
      }

      public LineItem.Builder setDescription(String var1) {
         LineItem.this.description = var1;
         return this;
      }

      public LineItem.Builder setQuantity(String var1) {
         LineItem.this.auZ = var1;
         return this;
      }

      public LineItem.Builder setRole(int var1) {
         LineItem.this.avb = var1;
         return this;
      }

      public LineItem.Builder setTotalPrice(String var1) {
         LineItem.this.auF = var1;
         return this;
      }

      public LineItem.Builder setUnitPrice(String var1) {
         LineItem.this.ava = var1;
         return this;
      }
   }

   public interface Role {
      int REGULAR = 0;
      int SHIPPING = 2;
      int TAX = 1;
   }
}
