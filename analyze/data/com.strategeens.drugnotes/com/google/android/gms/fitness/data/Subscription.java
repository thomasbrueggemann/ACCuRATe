package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_1045;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

public class Subscription implements SafeParcelable {
   public static final Creator<Subscription> CREATOR = new class_1045();
   // $FF: renamed from: CK int
   private final int field_3577;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_3578;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3579;
   // $FF: renamed from: UQ long
   private final long field_3580;
   // $FF: renamed from: UR int
   private final int field_3581;

   Subscription(int var1, DataSource var2, DataType var3, long var4, int var6) {
      this.field_3577 = var1;
      this.field_3579 = var2;
      this.field_3578 = var3;
      this.field_3580 = var4;
      this.field_3581 = var6;
   }

   private Subscription(Subscription.class_1614 var1) {
      this.field_3577 = 1;
      this.field_3578 = var1.field_3832;
      this.field_3579 = var1.field_3833;
      this.field_3580 = var1.field_3834;
      this.field_3581 = var1.field_3835;
   }

   // $FF: synthetic method
   Subscription(Subscription.class_1614 var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Subscription) boolean
   private boolean method_4753(Subscription var1) {
      return class_336.equal(this.field_3579, var1.field_3579) && class_336.equal(this.field_3578, var1.field_3578) && this.field_3580 == var1.field_3580 && this.field_3581 == var1.field_3581;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Subscription && this.method_4753((Subscription)var1);
   }

   public int getAccuracyMode() {
      return this.field_3581;
   }

   public DataSource getDataSource() {
      return this.field_3579;
   }

   public DataType getDataType() {
      return this.field_3578;
   }

   int getVersionCode() {
      return this.field_3577;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3579, this.field_3579, Long.valueOf(this.field_3580), Integer.valueOf(this.field_3581)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jI () long
   public long method_4754() {
      return this.field_3580;
   }

   // $FF: renamed from: jJ () com.google.android.gms.fitness.data.DataType
   public DataType method_4755() {
      return this.field_3578 == null?this.field_3579.getDataType():this.field_3578;
   }

   public String toDebugString() {
      Object[] var1 = new Object[1];
      String var2;
      if(this.field_3579 == null) {
         var2 = this.field_3578.getName();
      } else {
         var2 = this.field_3579.toDebugString();
      }

      var1[0] = var2;
      return String.format("Subscription{%s}", var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("dataSource", this.field_3579).method_3424("dataType", this.field_3578).method_3424("samplingIntervalMicros", Long.valueOf(this.field_3580)).method_3424("accuracyMode", Integer.valueOf(this.field_3581)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1045.method_5744(this, var1, var2);
   }

   public static class class_1614 {
      // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
      private DataType field_3832;
      // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
      private DataSource field_3833;
      // $FF: renamed from: UQ long
      private long field_3834 = -1L;
      // $FF: renamed from: UR int
      private int field_3835 = 2;

      // $FF: renamed from: b (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.data.Subscription$a
      public Subscription.class_1614 method_5070(DataSource var1) {
         this.field_3833 = var1;
         return this;
      }

      // $FF: renamed from: b (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.data.Subscription$a
      public Subscription.class_1614 method_5071(DataType var1) {
         this.field_3832 = var1;
         return this;
      }

      // $FF: renamed from: jK () com.google.android.gms.fitness.data.Subscription
      public Subscription method_5072() {
         boolean var1;
         if(this.field_3833 == null && this.field_3832 == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         boolean var2;
         label17: {
            class_335.method_2302(var1, "Must call setDataSource() or setDataType()");
            if(this.field_3832 != null && this.field_3833 != null) {
               boolean var3 = this.field_3832.equals(this.field_3833.getDataType());
               var2 = false;
               if(!var3) {
                  break label17;
               }
            }

            var2 = true;
         }

         class_335.method_2302(var2, "Specified data type is incompatible with specified data source");
         return new Subscription(this);
      }
   }
}
