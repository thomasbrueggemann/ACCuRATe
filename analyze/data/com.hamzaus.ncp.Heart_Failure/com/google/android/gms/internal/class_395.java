package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.fe;

// $FF: renamed from: com.google.android.gms.internal.fe
public class class_395 implements Parcelable {
   @Deprecated
   public static final Creator<fe> CREATOR = new Creator() {
      // $FF: renamed from: C (int) com.google.android.gms.internal.fe[]
      @Deprecated
      public class_395[] method_3347(int var1) {
         return new class_395[var1];
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3348(var1);
      }

      // $FF: renamed from: k (android.os.Parcel) com.google.android.gms.internal.fe
      @Deprecated
      public class_395 method_3348(Parcel var1) {
         return new class_395(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.method_3347(var1);
      }
   };
   private String mValue;
   // $FF: renamed from: xD java.lang.String
   private String field_1768;
   // $FF: renamed from: xE java.lang.String
   private String field_1769;

   @Deprecated
   public class_395() {
   }

   @Deprecated
   class_395(Parcel var1) {
      this.readFromParcel(var1);
   }

   public class_395(String var1, String var2, String var3) {
      this.field_1768 = var1;
      this.field_1769 = var2;
      this.mValue = var3;
   }

   @Deprecated
   private void readFromParcel(Parcel var1) {
      this.field_1768 = var1.readString();
      this.field_1769 = var1.readString();
      this.mValue = var1.readString();
   }

   @Deprecated
   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.field_1768;
   }

   public String getValue() {
      return this.mValue;
   }

   @Deprecated
   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.field_1768);
      var1.writeString(this.field_1769);
      var1.writeString(this.mValue);
   }
}
