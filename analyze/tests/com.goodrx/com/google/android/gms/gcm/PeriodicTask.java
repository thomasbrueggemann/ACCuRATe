package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.gcm.Task;

public class PeriodicTask extends Task {
   public static final Creator<PeriodicTask> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeK(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzhh(var1);
      }

      public PeriodicTask zzeK(Parcel var1) {
         return new PeriodicTask(var1, null);
      }

      public PeriodicTask[] zzhh(int var1) {
         return new PeriodicTask[var1];
      }
   };
   protected long mFlexInSeconds;
   protected long mIntervalInSeconds;

   @Deprecated
   private PeriodicTask(Parcel var1) {
      super(var1);
      this.mIntervalInSeconds = -1L;
      this.mFlexInSeconds = -1L;
      this.mIntervalInSeconds = var1.readLong();
      this.mFlexInSeconds = Math.min(var1.readLong(), this.mIntervalInSeconds);
   }

   // $FF: synthetic method
   PeriodicTask(Parcel var1, Object var2) {
      this(var1);
   }

   public long getFlex() {
      return this.mFlexInSeconds;
   }

   public long getPeriod() {
      return this.mIntervalInSeconds;
   }

   public String toString() {
      return super.toString() + " " + "period=" + this.getPeriod() + " " + "flex=" + this.getFlex();
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeLong(this.mIntervalInSeconds);
      var1.writeLong(this.mFlexInSeconds);
   }
}
