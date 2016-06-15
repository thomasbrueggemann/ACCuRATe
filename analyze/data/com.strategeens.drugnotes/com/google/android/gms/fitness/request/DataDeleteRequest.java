package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_508;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
   public static final Creator<DataDeleteRequest> CREATOR = new class_508();
   // $FF: renamed from: CK int
   private final int field_4035;
   // $FF: renamed from: LW long
   private final long field_4036;
   // $FF: renamed from: TO long
   private final long field_4037;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_4038;
   // $FF: renamed from: VH java.util.List
   private final List<DataSource> field_4039;
   // $FF: renamed from: VI java.util.List
   private final List<Session> field_4040;
   // $FF: renamed from: VJ boolean
   private final boolean field_4041;
   // $FF: renamed from: VK boolean
   private final boolean field_4042;

   DataDeleteRequest(int var1, long var2, long var4, List<DataSource> var6, List<DataType> var7, List<Session> var8, boolean var9, boolean var10) {
      this.field_4035 = var1;
      this.field_4036 = var2;
      this.field_4037 = var4;
      this.field_4039 = Collections.unmodifiableList(var6);
      this.field_4038 = Collections.unmodifiableList(var7);
      this.field_4040 = var8;
      this.field_4041 = var9;
      this.field_4042 = var10;
   }

   private DataDeleteRequest(DataDeleteRequest.Builder var1) {
      this.field_4035 = 1;
      this.field_4036 = var1.field_342;
      this.field_4037 = var1.field_343;
      this.field_4039 = Collections.unmodifiableList(var1.field_345);
      this.field_4038 = Collections.unmodifiableList(var1.field_344);
      this.field_4040 = Collections.unmodifiableList(var1.field_346);
      this.field_4041 = var1.field_347;
      this.field_4042 = var1.field_348;
   }

   // $FF: synthetic method
   DataDeleteRequest(DataDeleteRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest) boolean
   private boolean method_5332(DataDeleteRequest var1) {
      return this.field_4036 == var1.field_4036 && this.field_4037 == var1.field_4037 && class_336.equal(this.field_4039, var1.field_4039) && class_336.equal(this.field_4038, var1.field_4038) && class_336.equal(this.field_4040, var1.field_4040) && this.field_4041 == var1.field_4041 && this.field_4042 == var1.field_4042;
   }

   public boolean deleteAllData() {
      return this.field_4041;
   }

   public boolean deleteAllSessions() {
      return this.field_4042;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataDeleteRequest && this.method_5332((DataDeleteRequest)var1);
   }

   public List<DataSource> getDataSources() {
      return this.field_4039;
   }

   public List<DataType> getDataTypes() {
      return this.field_4038;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_4037, TimeUnit.MILLISECONDS);
   }

   public List<Session> getSessions() {
      return this.field_4040;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_4036, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.field_4035;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_4036), Long.valueOf(this.field_4037)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jR () boolean
   public boolean method_5333() {
      return this.field_4041;
   }

   // $FF: renamed from: jS () boolean
   public boolean method_5334() {
      return this.field_4042;
   }

   // $FF: renamed from: jo () long
   public long method_5335() {
      return this.field_4036;
   }

   // $FF: renamed from: jp () long
   public long method_5336() {
      return this.field_4037;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("startTimeMillis", Long.valueOf(this.field_4036)).method_3424("endTimeMillis", Long.valueOf(this.field_4037)).method_3424("dataSources", this.field_4039).method_3424("dateTypes", this.field_4038).method_3424("sessions", this.field_4040).method_3424("deleteAllData", Boolean.valueOf(this.field_4041)).method_3424("deleteAllSessions", Boolean.valueOf(this.field_4042)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_508.method_3184(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: LW long
      private long field_342;
      // $FF: renamed from: TO long
      private long field_343;
      // $FF: renamed from: TY java.util.List
      private List<DataType> field_344 = new ArrayList();
      // $FF: renamed from: VH java.util.List
      private List<DataSource> field_345 = new ArrayList();
      // $FF: renamed from: VI java.util.List
      private List<Session> field_346 = new ArrayList();
      // $FF: renamed from: VJ boolean
      private boolean field_347 = false;
      // $FF: renamed from: VK boolean
      private boolean field_348 = false;

      // $FF: renamed from: jT () void
      private void method_1503() {
         if(!this.field_346.isEmpty()) {
            Iterator var1 = this.field_346.iterator();

            while(var1.hasNext()) {
               Session var2 = (Session)var1.next();
               boolean var3;
               if(var2.getStartTime(TimeUnit.MILLISECONDS) >= this.field_342 && var2.getEndTime(TimeUnit.MILLISECONDS) <= this.field_343) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               Object[] var4 = new Object[]{var2, Long.valueOf(this.field_342), Long.valueOf(this.field_343)};
               class_335.method_2303(var3, "Session %s is outside the time interval [%d, %d]", var4);
            }
         }

      }

      public DataDeleteRequest.Builder addDataSource(DataSource var1) {
         boolean var2 = true;
         boolean var3;
         if(!this.field_347) {
            var3 = var2;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "All data is already marked for deletion");
         if(var1 == null) {
            var2 = false;
         }

         class_335.method_2308(var2, "Must specify a valid data source");
         if(!this.field_345.contains(var1)) {
            this.field_345.add(var1);
         }

         return this;
      }

      public DataDeleteRequest.Builder addDataType(DataType var1) {
         boolean var2 = true;
         boolean var3;
         if(!this.field_347) {
            var3 = var2;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "All data is already marked for deletion");
         if(var1 == null) {
            var2 = false;
         }

         class_335.method_2308(var2, "Must specify a valid data type");
         if(!this.field_344.contains(var1)) {
            this.field_344.add(var1);
         }

         return this;
      }

      public DataDeleteRequest.Builder addSession(Session var1) {
         boolean var2 = true;
         boolean var3;
         if(!this.field_348) {
            var3 = var2;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "All sessions already marked for deletion");
         boolean var4;
         if(var1 != null) {
            var4 = var2;
         } else {
            var4 = false;
         }

         class_335.method_2308(var4, "Must specify a valid session");
         if(var1.getEndTime(TimeUnit.MILLISECONDS) <= 0L) {
            var2 = false;
         }

         class_335.method_2308(var2, "Must specify a session that has already ended");
         this.field_346.add(var1);
         return this;
      }

      public DataDeleteRequest build() {
         boolean var1;
         if(this.field_342 > 0L && this.field_343 > this.field_342) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2302(var1, "Must specify a valid time interval");
         boolean var2;
         if(!this.field_347 && this.field_345.isEmpty() && this.field_344.isEmpty()) {
            var2 = false;
         } else {
            var2 = true;
         }

         boolean var3;
         if(!this.field_348 && this.field_346.isEmpty()) {
            var3 = false;
         } else {
            var3 = true;
         }

         boolean var4;
         label24: {
            if(!var2) {
               var4 = false;
               if(!var3) {
                  break label24;
               }
            }

            var4 = true;
         }

         class_335.method_2302(var4, "No data or session marked for deletion");
         this.method_1503();
         return new DataDeleteRequest(this);
      }

      public DataDeleteRequest.Builder deleteAllData() {
         boolean var1;
         if(this.field_344.isEmpty() && this.field_345.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         Object[] var2 = new Object[]{this.field_345, this.field_344};
         class_335.method_2309(var1, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", var2);
         this.field_347 = true;
         return this;
      }

      public DataDeleteRequest.Builder deleteAllSessions() {
         boolean var1 = this.field_346.isEmpty();
         Object[] var2 = new Object[]{this.field_346};
         class_335.method_2309(var1, "Specific sessions already added for deletion: %s", var2);
         this.field_348 = true;
         return this;
      }

      public DataDeleteRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
         boolean var6;
         if(var1 > 0L) {
            var6 = true;
         } else {
            var6 = false;
         }

         Object[] var7 = new Object[]{Long.valueOf(var1)};
         class_335.method_2309(var6, "Invalid start time :%d", var7);
         boolean var8;
         if(var3 > var1) {
            var8 = true;
         } else {
            var8 = false;
         }

         Object[] var9 = new Object[]{Long.valueOf(var3)};
         class_335.method_2309(var8, "Invalid end time :%d", var9);
         this.field_342 = var5.toMillis(var1);
         this.field_343 = var5.toMillis(var3);
         return this;
      }
   }
}
