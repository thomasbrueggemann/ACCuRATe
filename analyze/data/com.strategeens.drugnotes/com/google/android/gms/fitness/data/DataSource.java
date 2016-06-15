package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_703;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.class_1035;
import com.google.android.gms.fitness.data.class_1051;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_780;

public class DataSource implements SafeParcelable {
   public static final Creator<DataSource> CREATOR = new class_1035();
   public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
   public static final int TYPE_DERIVED = 1;
   public static final int TYPE_RAW;
   // $FF: renamed from: CK int
   private final int field_1869;
   // $FF: renamed from: Gt int
   private final int field_1870;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_1871;
   // $FF: renamed from: Ul com.google.android.gms.fitness.data.Device
   private final Device field_1872;
   // $FF: renamed from: Um com.google.android.gms.fitness.data.a
   private final class_1051 field_1873;
   // $FF: renamed from: Un java.lang.String
   private final String field_1874;
   // $FF: renamed from: Uo boolean
   private final boolean field_1875;
   // $FF: renamed from: Up java.lang.String
   private final String field_1876;
   private final String mName;

   DataSource(int var1, DataType var2, String var3, int var4, Device var5, class_1051 var6, String var7, boolean var8) {
      this.field_1869 = var1;
      this.field_1871 = var2;
      this.field_1870 = var4;
      this.mName = var3;
      this.field_1872 = var5;
      this.field_1873 = var6;
      this.field_1874 = var7;
      this.field_1875 = var8;
      this.field_1876 = this.method_3131();
   }

   private DataSource(DataSource.Builder var1) {
      this.field_1869 = 3;
      this.field_1871 = var1.field_3922;
      this.field_1870 = var1.field_3921;
      this.mName = var1.mName;
      this.field_1872 = var1.field_3923;
      this.field_1873 = var1.field_3924;
      this.field_1874 = var1.field_3925;
      this.field_1875 = var1.field_3926;
      this.field_1876 = this.method_3131();
   }

   // $FF: synthetic method
   DataSource(DataSource.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSource) boolean
   private boolean method_3130(DataSource var1) {
      return this.field_1876.equals(var1.field_1876);
   }

   public static DataSource extract(Intent var0) {
      return var0 == null?null:(DataSource)class_703.method_4019(var0, "vnd.google.fitness.data_source", CREATOR);
   }

   private String getTypeString() {
      switch(this.field_1870) {
      case 0:
         return "raw";
      case 1:
         return "derived";
      default:
         throw new IllegalArgumentException("invalid type value");
      }
   }

   // $FF: renamed from: jy () java.lang.String
   private String method_3131() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getTypeString());
      var1.append(":").append(this.field_1871.getName());
      if(this.field_1873 != null) {
         var1.append(":").append(this.field_1873.getPackageName());
      }

      if(this.field_1872 != null) {
         var1.append(":").append(this.field_1872.getStreamIdentifier());
      }

      if(this.field_1874 != null) {
         var1.append(":").append(this.field_1874);
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSource && this.method_3130((DataSource)var1);
   }

   public String getAppPackageName() {
      return this.field_1873 == null?null:this.field_1873.getPackageName();
   }

   public DataType getDataType() {
      return this.field_1871;
   }

   public Device getDevice() {
      return this.field_1872;
   }

   public String getName() {
      return this.mName;
   }

   public String getStreamIdentifier() {
      return this.field_1876;
   }

   public String getStreamName() {
      return this.field_1874;
   }

   public int getType() {
      return this.field_1870;
   }

   int getVersionCode() {
      return this.field_1869;
   }

   public int hashCode() {
      return this.field_1876.hashCode();
   }

   // $FF: renamed from: jA () com.google.android.gms.fitness.data.DataSource
   public DataSource method_3132() {
      Device var1;
      if(this.field_1872 == null) {
         var1 = null;
      } else {
         var1 = this.field_1872.method_2650();
      }

      class_1051 var2;
      if(this.field_1873 == null) {
         var2 = null;
      } else {
         var2 = this.field_1873.method_5763();
      }

      return new DataSource(3, this.field_1871, this.mName, this.field_1870, var1, var2, class_780.method_4401(this.field_1874), this.field_1875);
   }

   // $FF: renamed from: jx () com.google.android.gms.fitness.data.a
   public class_1051 method_3133() {
      return this.field_1873;
   }

   // $FF: renamed from: jz () boolean
   public boolean method_3134() {
      return this.field_1875;
   }

   public String toDebugString() {
      StringBuilder var1 = new StringBuilder();
      String var2;
      if(this.field_1870 == 0) {
         var2 = "r";
      } else {
         var2 = "d";
      }

      StringBuilder var3 = var1.append(var2).append(":").append(this.field_1871.method_5487());
      String var4;
      if(this.field_1873 == null) {
         var4 = "";
      } else if(this.field_1873.equals(class_1051.field_4398)) {
         var4 = ":gms";
      } else {
         var4 = ":" + this.field_1873.getPackageName();
      }

      StringBuilder var5 = var3.append(var4);
      String var6;
      if(this.field_1872 != null) {
         var6 = ":" + this.field_1872.getModel() + ":" + this.field_1872.getUid();
      } else {
         var6 = "";
      }

      StringBuilder var7 = var5.append(var6);
      String var8;
      if(this.field_1874 != null) {
         var8 = ":" + this.field_1874;
      } else {
         var8 = "";
      }

      return var7.append(var8).toString();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DataSource{");
      var1.append(this.getTypeString());
      if(this.mName != null) {
         var1.append(":").append(this.mName);
      }

      if(this.field_1873 != null) {
         var1.append(":").append(this.field_1873);
      }

      if(this.field_1872 != null) {
         var1.append(":").append(this.field_1872);
      }

      if(this.field_1874 != null) {
         var1.append(":").append(this.field_1874);
      }

      var1.append(":").append(this.field_1871);
      return var1.append("}").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1035.method_5714(class_780.method_4402(this), var1, var2);
   }

   public static final class Builder {
      // $FF: renamed from: Gt int
      private int field_3921 = -1;
      // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
      private DataType field_3922;
      // $FF: renamed from: Ul com.google.android.gms.fitness.data.Device
      private Device field_3923;
      // $FF: renamed from: Um com.google.android.gms.fitness.data.a
      private class_1051 field_3924;
      // $FF: renamed from: Un java.lang.String
      private String field_3925 = "";
      // $FF: renamed from: Uo boolean
      private boolean field_3926 = false;
      private String mName;

      public DataSource build() {
         boolean var1 = true;
         boolean var2;
         if(this.field_3922 != null) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "Must set data type");
         if(this.field_3921 < 0) {
            var1 = false;
         }

         class_335.method_2302(var1, "Must set data source type");
         return new DataSource(this);
      }

      public DataSource.Builder setAppPackageName(Context var1) {
         return this.setAppPackageName(var1.getPackageName());
      }

      public DataSource.Builder setAppPackageName(String var1) {
         this.field_3924 = new class_1051(var1, (String)null, (String)null);
         return this;
      }

      public DataSource.Builder setDataType(DataType var1) {
         this.field_3922 = var1;
         return this;
      }

      public DataSource.Builder setDevice(Device var1) {
         this.field_3923 = var1;
         return this;
      }

      public DataSource.Builder setName(String var1) {
         this.mName = var1;
         return this;
      }

      public DataSource.Builder setObfuscated(boolean var1) {
         this.field_3926 = var1;
         return this;
      }

      public DataSource.Builder setStreamName(String var1) {
         boolean var2;
         if(var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2308(var2, "Must specify a valid stream name");
         this.field_3925 = var1;
         return this;
      }

      public DataSource.Builder setType(int var1) {
         this.field_3921 = var1;
         return this;
      }
   }
}
