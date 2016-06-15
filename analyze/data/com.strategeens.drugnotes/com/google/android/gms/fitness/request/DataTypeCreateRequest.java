package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.class_499;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
   public static final Creator<DataTypeCreateRequest> CREATOR = new class_499();
   // $FF: renamed from: CK int
   private final int field_2827;
   // $FF: renamed from: Uv java.util.List
   private final List<Field> field_2828;
   private final String mName;

   DataTypeCreateRequest(int var1, String var2, List<Field> var3) {
      this.field_2827 = var1;
      this.mName = var2;
      this.field_2828 = Collections.unmodifiableList(var3);
   }

   private DataTypeCreateRequest(DataTypeCreateRequest.Builder var1) {
      this.field_2827 = 1;
      this.mName = var1.mName;
      this.field_2828 = Collections.unmodifiableList(var1.field_4412);
   }

   // $FF: synthetic method
   DataTypeCreateRequest(DataTypeCreateRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest) boolean
   private boolean method_3730(DataTypeCreateRequest var1) {
      return class_336.equal(this.mName, var1.mName) && class_336.equal(this.field_2828, var1.field_2828);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataTypeCreateRequest && this.method_3730((DataTypeCreateRequest)var1);
   }

   public List<Field> getFields() {
      return this.field_2828;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.field_2827;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.field_2828};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("name", this.mName).method_3424("fields", this.field_2828).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_499.method_3160(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: Uv java.util.List
      private List<Field> field_4412 = new ArrayList();
      private String mName;

      public DataTypeCreateRequest.Builder addField(Field var1) {
         if(!this.field_4412.contains(var1)) {
            this.field_4412.add(var1);
         }

         return this;
      }

      public DataTypeCreateRequest.Builder addField(String var1, int var2) {
         boolean var3;
         if(var1 == null && var1.isEmpty()) {
            var3 = false;
         } else {
            var3 = true;
         }

         class_335.method_2308(var3, "Invalid name specified");
         return this.addField(new Field(var1, var2));
      }

      public DataTypeCreateRequest build() {
         boolean var1 = true;
         boolean var2;
         if(this.mName != null) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "Must set the name");
         if(this.field_4412.isEmpty()) {
            var1 = false;
         }

         class_335.method_2302(var1, "Must specify the data fields");
         return new DataTypeCreateRequest(this);
      }

      public DataTypeCreateRequest.Builder setName(String var1) {
         this.mName = var1;
         return this;
      }
   }
}
