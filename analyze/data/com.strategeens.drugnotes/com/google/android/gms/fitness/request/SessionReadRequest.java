package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_515;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
   public static final Creator<SessionReadRequest> CREATOR = new class_515();
   // $FF: renamed from: CK int
   private final int field_3940;
   // $FF: renamed from: LW long
   private final long field_3941;
   // $FF: renamed from: TO long
   private final long field_3942;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_3943;
   // $FF: renamed from: VH java.util.List
   private final List<DataSource> field_3944;
   // $FF: renamed from: VR boolean
   private final boolean field_3945;
   // $FF: renamed from: Wj java.lang.String
   private final String field_3946;
   // $FF: renamed from: Wk boolean
   private boolean field_3947;
   // $FF: renamed from: Wl java.util.List
   private final List<String> field_3948;
   // $FF: renamed from: vZ java.lang.String
   private final String field_3949;

   SessionReadRequest(int var1, String var2, String var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, boolean var10, boolean var11, List<String> var12) {
      this.field_3940 = var1;
      this.field_3946 = var2;
      this.field_3949 = var3;
      this.field_3941 = var4;
      this.field_3942 = var6;
      this.field_3943 = Collections.unmodifiableList(var8);
      this.field_3944 = Collections.unmodifiableList(var9);
      this.field_3947 = var10;
      this.field_3945 = var11;
      this.field_3948 = var12;
   }

   private SessionReadRequest(SessionReadRequest.Builder var1) {
      this.field_3940 = 3;
      this.field_3946 = var1.field_1865;
      this.field_3949 = var1.field_1868;
      this.field_3941 = var1.field_1860;
      this.field_3942 = var1.field_1861;
      this.field_3943 = Collections.unmodifiableList(var1.field_1862);
      this.field_3944 = Collections.unmodifiableList(var1.field_1863);
      this.field_3947 = var1.field_1866;
      this.field_3945 = var1.field_1864;
      this.field_3948 = Collections.unmodifiableList(var1.field_1867);
   }

   // $FF: synthetic method
   SessionReadRequest(SessionReadRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest) boolean
   private boolean method_5181(SessionReadRequest var1) {
      return class_336.equal(this.field_3946, var1.field_3946) && this.field_3949.equals(var1.field_3949) && this.field_3941 == var1.field_3941 && this.field_3942 == var1.field_3942 && class_336.equal(this.field_3943, var1.field_3943) && class_336.equal(this.field_3944, var1.field_3944) && this.field_3947 == var1.field_3947 && this.field_3948.equals(var1.field_3948) && this.field_3945 == var1.field_3945;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadRequest && this.method_5181((SessionReadRequest)var1);
   }

   public List<DataSource> getDataSources() {
      return this.field_3944;
   }

   public List<DataType> getDataTypes() {
      return this.field_3943;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_3942, TimeUnit.MILLISECONDS);
   }

   public List<String> getExcludedPackages() {
      return this.field_3948;
   }

   public String getSessionId() {
      return this.field_3949;
   }

   public String getSessionName() {
      return this.field_3946;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_3941, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.field_3940;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3946, this.field_3949, Long.valueOf(this.field_3941), Long.valueOf(this.field_3942)};
      return class_336.hashCode(var1);
   }

   public boolean includeSessionsFromAllApps() {
      return this.field_3947;
   }

   // $FF: renamed from: jV () boolean
   public boolean method_5182() {
      return this.field_3945;
   }

   // $FF: renamed from: jo () long
   public long method_5183() {
      return this.field_3941;
   }

   // $FF: renamed from: jp () long
   public long method_5184() {
      return this.field_3942;
   }

   // $FF: renamed from: kj () boolean
   public boolean method_5185() {
      return this.field_3947;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("sessionName", this.field_3946).method_3424("sessionId", this.field_3949).method_3424("startTimeMillis", Long.valueOf(this.field_3941)).method_3424("endTimeMillis", Long.valueOf(this.field_3942)).method_3424("dataTypes", this.field_3943).method_3424("dataSources", this.field_3944).method_3424("sessionsFromAllApps", Boolean.valueOf(this.field_3947)).method_3424("excludedPackages", this.field_3948).method_3424("useServer", Boolean.valueOf(this.field_3945)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_515.method_3207(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: LW long
      private long field_1860 = 0L;
      // $FF: renamed from: TO long
      private long field_1861 = 0L;
      // $FF: renamed from: TY java.util.List
      private List<DataType> field_1862 = new ArrayList();
      // $FF: renamed from: VH java.util.List
      private List<DataSource> field_1863 = new ArrayList();
      // $FF: renamed from: VR boolean
      private boolean field_1864 = false;
      // $FF: renamed from: Wj java.lang.String
      private String field_1865;
      // $FF: renamed from: Wk boolean
      private boolean field_1866 = false;
      // $FF: renamed from: Wl java.util.List
      private List<String> field_1867 = new ArrayList();
      // $FF: renamed from: vZ java.lang.String
      private String field_1868;

      public SessionReadRequest build() {
         boolean var1;
         if(this.field_1860 > 0L) {
            var1 = true;
         } else {
            var1 = false;
         }

         Object[] var2 = new Object[]{Long.valueOf(this.field_1860)};
         class_335.method_2309(var1, "Invalid start time: %s", var2);
         boolean var3;
         if(this.field_1861 > 0L && this.field_1861 > this.field_1860) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{Long.valueOf(this.field_1861)};
         class_335.method_2309(var3, "Invalid end time: %s", var4);
         return new SessionReadRequest(this);
      }

      public SessionReadRequest.Builder enableServerQueries() {
         this.field_1864 = true;
         return this;
      }

      public SessionReadRequest.Builder excludePackage(String var1) {
         class_335.method_2306(var1, "Attempting to use a null package name");
         if(!this.field_1867.contains(var1)) {
            this.field_1867.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder read(DataSource var1) {
         class_335.method_2306(var1, "Attempting to add a null data source");
         if(!this.field_1863.contains(var1)) {
            this.field_1863.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder read(DataType var1) {
         class_335.method_2306(var1, "Attempting to use a null data type");
         if(!this.field_1862.contains(var1)) {
            this.field_1862.add(var1);
         }

         return this;
      }

      public SessionReadRequest.Builder readSessionsFromAllApps() {
         this.field_1866 = true;
         return this;
      }

      public SessionReadRequest.Builder setSessionId(String var1) {
         this.field_1868 = var1;
         return this;
      }

      public SessionReadRequest.Builder setSessionName(String var1) {
         this.field_1865 = var1;
         return this;
      }

      public SessionReadRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
         this.field_1860 = var5.toMillis(var1);
         this.field_1861 = var5.toMillis(var3);
         return this;
      }
   }
}
