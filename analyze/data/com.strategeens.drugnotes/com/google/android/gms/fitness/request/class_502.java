package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.class_503;
import com.google.android.gms.fitness.request.e;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.e
public class class_502 implements SafeParcelable {
   public static final Creator<e> CREATOR = new class_503();
   // $FF: renamed from: CK int
   private final int field_1907;
   // $FF: renamed from: UP com.google.android.gms.fitness.data.DataSet
   private final DataSet field_1908;

   class_502(int var1, DataSet var2) {
      this.field_1907 = var1;
      this.field_1908 = var2;
   }

   private class_502(class_502.class_1289 var1) {
      this.field_1907 = 1;
      this.field_1908 = var1.field_2504;
   }

   // $FF: synthetic method
   class_502(class_502.class_1289 var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.e) boolean
   private boolean method_3169(class_502 var1) {
      return class_336.equal(this.field_1908, var1.field_1908);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof class_502 && this.method_3169((class_502)var1);
   }

   int getVersionCode() {
      return this.field_1907;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1908};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jH () com.google.android.gms.fitness.data.DataSet
   public DataSet method_3170() {
      return this.field_1908;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("dataSet", this.field_1908).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_503.method_3171(this, var1, var2);
   }

   public static class class_1289 {
      // $FF: renamed from: UP com.google.android.gms.fitness.data.DataSet
      private DataSet field_2504;

      // $FF: renamed from: b (com.google.android.gms.fitness.data.DataSet) com.google.android.gms.fitness.request.e$a
      public class_502.class_1289 method_3264(DataSet var1) {
         this.field_2504 = var1;
         return this;
      }

      // $FF: renamed from: jU () com.google.android.gms.fitness.request.e
      public class_502 method_3265() {
         boolean var1 = true;
         boolean var2;
         if(this.field_2504 != null) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "Must set the data set");
         boolean var3;
         if(!this.field_2504.getDataPoints().isEmpty()) {
            var3 = var1;
         } else {
            var3 = false;
         }

         class_335.method_2302(var3, "Cannot use an empty data set");
         if(this.field_2504.getDataSource().method_3133() == null) {
            var1 = false;
         }

         class_335.method_2302(var1, "Must set the app package name for the data source");
         return new class_502(this);
      }
   }
}
