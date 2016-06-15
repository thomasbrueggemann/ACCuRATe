package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_509;
import com.google.android.gms.fitness.request.y;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.y
public class class_510 implements SafeParcelable {
   public static final Creator<y> CREATOR = new class_509();
   // $FF: renamed from: CK int
   private final int field_1914;
   // $FF: renamed from: UN java.lang.String
   private final String field_1915;
   private final String mName;

   class_510(int var1, String var2, String var3) {
      this.field_1914 = var1;
      this.mName = var2;
      this.field_1915 = var3;
   }

   private class_510(class_510.class_1468 var1) {
      this.field_1914 = 1;
      this.mName = var1.mName;
      this.field_1915 = var1.field_3970;
   }

   // $FF: synthetic method
   class_510(class_510.class_1468 var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.y) boolean
   private boolean method_3197(class_510 var1) {
      return class_336.equal(this.mName, var1.mName) && class_336.equal(this.field_1915, var1.field_1915);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof class_510 && this.method_3197((class_510)var1);
   }

   public String getIdentifier() {
      return this.field_1915;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.field_1914;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.field_1915};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("name", this.mName).method_3424("identifier", this.field_1915).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_509.method_3194(this, var1, var2);
   }

   public static class class_1468 {
      // $FF: renamed from: UN java.lang.String
      private String field_3970;
      private String mName;

      // $FF: renamed from: bx (java.lang.String) com.google.android.gms.fitness.request.y$a
      public class_510.class_1468 method_5277(String var1) {
         this.mName = var1;
         return this;
      }

      // $FF: renamed from: by (java.lang.String) com.google.android.gms.fitness.request.y$a
      public class_510.class_1468 method_5278(String var1) {
         this.field_3970 = var1;
         return this;
      }

      // $FF: renamed from: kl () com.google.android.gms.fitness.request.y
      public class_510 method_5279() {
         return new class_510(this);
      }
   }
}
