package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ha;

// $FF: renamed from: com.google.android.gms.internal.ha
public class class_400 implements Parcelable {
   @Deprecated
   public static final Creator<ha> CREATOR = new Creator() {
      // $FF: renamed from: I (int) com.google.android.gms.internal.ha[]
      @Deprecated
      public class_400[] method_4130(int var1) {
         return new class_400[var1];
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_4131(var1);
      }

      // $FF: renamed from: k (android.os.Parcel) com.google.android.gms.internal.ha
      @Deprecated
      public class_400 method_4131(Parcel var1) {
         return new class_400(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.method_4130(var1);
      }
   };
   // $FF: renamed from: CE java.lang.String
   private String field_1244;
   // $FF: renamed from: CF java.lang.String
   private String field_1245;
   private String mValue;

   @Deprecated
   public class_400() {
   }

   @Deprecated
   class_400(Parcel var1) {
      this.readFromParcel(var1);
   }

   public class_400(String var1, String var2, String var3) {
      this.field_1244 = var1;
      this.field_1245 = var2;
      this.mValue = var3;
   }

   @Deprecated
   private void readFromParcel(Parcel var1) {
      this.field_1244 = var1.readString();
      this.field_1245 = var1.readString();
      this.mValue = var1.readString();
   }

   @Deprecated
   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.field_1244;
   }

   public String getValue() {
      return this.mValue;
   }

   @Deprecated
   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.field_1244);
      var1.writeString(this.field_1245);
      var1.writeString(this.mValue);
   }
}
