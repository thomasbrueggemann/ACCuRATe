package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1038;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
   public static final Creator<Bucket> CREATOR = new class_1038();
   public static final int TYPE_ACTIVITY_SEGMENT = 4;
   public static final int TYPE_ACTIVITY_TYPE = 3;
   public static final int TYPE_SESSION = 2;
   public static final int TYPE_TIME = 1;
   // $FF: renamed from: CK int
   private final int field_3797;
   // $FF: renamed from: LW long
   private final long field_3798;
   // $FF: renamed from: TO long
   private final long field_3799;
   // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
   private final Session field_3800;
   // $FF: renamed from: TZ int
   private final int field_3801;
   // $FF: renamed from: Ua java.util.List
   private final List<DataSet> field_3802;
   // $FF: renamed from: Ub int
   private final int field_3803;
   // $FF: renamed from: Uc boolean
   private boolean field_3804;

   Bucket(int var1, long var2, long var4, Session var6, int var7, List<DataSet> var8, int var9, boolean var10) {
      this.field_3804 = false;
      this.field_3797 = var1;
      this.field_3798 = var2;
      this.field_3799 = var4;
      this.field_3800 = var6;
      this.field_3801 = var7;
      this.field_3802 = var8;
      this.field_3803 = var9;
      this.field_3804 = var10;
   }

   public Bucket(RawBucket var1, List<DataSource> var2, List<DataType> var3) {
      this(2, var1.field_753, var1.field_754, var1.field_755, var1.field_756, method_5040(var1.field_757, var2, var3), var1.field_758, var1.field_759);
   }

   // $FF: renamed from: a (java.util.List, java.util.List, java.util.List) java.util.List
   private static List<DataSet> method_5040(List<RawDataSet> var0, List<DataSource> var1, List<DataType> var2) {
      ArrayList var3 = new ArrayList(var0.size());
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         var3.add(new DataSet((RawDataSet)var4.next(), var1, var2));
      }

      return var3;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Bucket) boolean
   private boolean method_5041(Bucket var1) {
      return this.field_3798 == var1.field_3798 && this.field_3799 == var1.field_3799 && this.field_3801 == var1.field_3801 && class_336.equal(this.field_3802, var1.field_3802) && this.field_3803 == var1.field_3803 && this.field_3804 == var1.field_3804;
   }

   // $FF: renamed from: cJ (int) java.lang.String
   public static String method_5042(int var0) {
      switch(var0) {
      case 0:
         return "unknown";
      case 1:
         return "time";
      case 2:
         return "session";
      case 3:
         return "type";
      case 4:
         return "segment";
      default:
         return "bug";
      }
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.data.Bucket) boolean
   public boolean method_5043(Bucket var1) {
      return this.field_3798 == var1.field_3798 && this.field_3799 == var1.field_3799 && this.field_3801 == var1.field_3801 && this.field_3803 == var1.field_3803;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Bucket && this.method_5041((Bucket)var1);
   }

   public String getActivity() {
      return FitnessActivities.getName(this.field_3801);
   }

   public int getBucketType() {
      return this.field_3803;
   }

   public DataSet getDataSet(DataType var1) {
      Iterator var2 = this.field_3802.iterator();

      DataSet var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (DataSet)var2.next();
      } while(!var3.getDataType().equals(var1));

      return var3;
   }

   public List<DataSet> getDataSets() {
      return this.field_3802;
   }

   public long getEndTime(TimeUnit var1) {
      return var1.convert(this.field_3799, TimeUnit.MILLISECONDS);
   }

   public Session getSession() {
      return this.field_3800;
   }

   public long getStartTime(TimeUnit var1) {
      return var1.convert(this.field_3798, TimeUnit.MILLISECONDS);
   }

   int getVersionCode() {
      return this.field_3797;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_3798), Long.valueOf(this.field_3799), Integer.valueOf(this.field_3801), Integer.valueOf(this.field_3803)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jm () int
   public int method_5044() {
      return this.field_3801;
   }

   // $FF: renamed from: jn () boolean
   public boolean method_5045() {
      if(this.field_3804) {
         return true;
      } else {
         Iterator var1 = this.field_3802.iterator();

         do {
            if(!var1.hasNext()) {
               return false;
            }
         } while(!((DataSet)var1.next()).method_5136());

         return true;
      }
   }

   // $FF: renamed from: jo () long
   public long method_5046() {
      return this.field_3798;
   }

   // $FF: renamed from: jp () long
   public long method_5047() {
      return this.field_3799;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("startTime", Long.valueOf(this.field_3798)).method_3424("endTime", Long.valueOf(this.field_3799)).method_3424("activity", Integer.valueOf(this.field_3801)).method_3424("dataSets", this.field_3802).method_3424("bucketType", method_5042(this.field_3803)).method_3424("serverHasMoreData", Boolean.valueOf(this.field_3804)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1038.method_5723(this, var1, var2);
   }
}
