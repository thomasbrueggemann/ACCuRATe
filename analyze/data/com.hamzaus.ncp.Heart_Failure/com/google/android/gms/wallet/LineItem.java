package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_721;

public final class LineItem implements SafeParcelable {
   public static final Creator<LineItem> CREATOR = new class_721();
   String aiH;
   String aiI;
   String ajb;
   String ajc;
   int ajd;
   String description;
   // $FF: renamed from: xJ int
   private final int field_3672;

   LineItem() {
      this.field_3672 = 1;
      this.ajd = 0;
   }

   LineItem(int var1, String var2, String var3, String var4, String var5, int var6, String var7) {
      this.field_3672 = var1;
      this.description = var2;
      this.ajb = var3;
      this.ajc = var4;
      this.aiH = var5;
      this.ajd = var6;
      this.aiI = var7;
   }

   public static LineItem.Builder newBuilder() {
      LineItem var0 = new LineItem();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getCurrencyCode() {
      return this.aiI;
   }

   public String getDescription() {
      return this.description;
   }

   public String getQuantity() {
      return this.ajb;
   }

   public int getRole() {
      return this.ajd;
   }

   public String getTotalPrice() {
      return this.aiH;
   }

   public String getUnitPrice() {
      return this.ajc;
   }

   public int getVersionCode() {
      return this.field_3672;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_721.method_4094(this, var1, var2);
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
         LineItem.this.aiI = var1;
         return this;
      }

      public LineItem.Builder setDescription(String var1) {
         LineItem.this.description = var1;
         return this;
      }

      public LineItem.Builder setQuantity(String var1) {
         LineItem.this.ajb = var1;
         return this;
      }

      public LineItem.Builder setRole(int var1) {
         LineItem.this.ajd = var1;
         return this;
      }

      public LineItem.Builder setTotalPrice(String var1) {
         LineItem.this.aiH = var1;
         return this;
      }

      public LineItem.Builder setUnitPrice(String var1) {
         LineItem.this.ajc = var1;
         return this;
      }
   }

   public interface Role {
      int REGULAR = 0;
      int SHIPPING = 2;
      int TAX = 1;
   }
}
