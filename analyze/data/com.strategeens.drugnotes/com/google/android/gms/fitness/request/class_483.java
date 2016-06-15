package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_484;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.aj
public class class_483 implements SafeParcelable {
   public static final Creator<aj> CREATOR = new class_484();
   // $FF: renamed from: CK int
   private final int field_1827;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_1828;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_1829;

   class_483(int var1, DataType var2, DataSource var3) {
      this.field_1827 = var1;
      this.field_1828 = var2;
      this.field_1829 = var3;
   }

   private class_483(class_483.class_1517 var1) {
      this.field_1827 = 1;
      this.field_1828 = var1.field_3075;
      this.field_1829 = var1.field_3076;
   }

   // $FF: synthetic method
   class_483(class_483.class_1517 var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.aj) boolean
   private boolean method_3078(class_483 var1) {
      return class_336.equal(this.field_1829, var1.field_1829) && class_336.equal(this.field_1828, var1.field_1828);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_483 && this.method_3078((class_483)var1);
   }

   public DataSource getDataSource() {
      return this.field_1829;
   }

   public DataType getDataType() {
      return this.field_1828;
   }

   int getVersionCode() {
      return this.field_1827;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1829, this.field_1828};
      return class_336.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_484.method_3079(this, var1, var2);
   }

   public static class class_1517 {
      // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
      private DataType field_3075;
      // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
      private DataSource field_3076;

      // $FF: renamed from: d (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.request.aj$a
      public class_483.class_1517 method_3973(DataSource var1) {
         this.field_3076 = var1;
         return this;
      }

      // $FF: renamed from: d (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.request.aj$a
      public class_483.class_1517 method_3974(DataType var1) {
         this.field_3075 = var1;
         return this;
      }

      // $FF: renamed from: kq () com.google.android.gms.fitness.request.aj
      public class_483 method_3975() {
         if(this.field_3075 != null && this.field_3076 != null) {
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
         } else {
            return new class_483(this);
         }
      }
   }
}
