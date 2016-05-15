package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.gcm.Task;

public class OneoffTask extends Task {
   public static final Creator<OneoffTask> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeI(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzhf(var1);
      }

      public OneoffTask zzeI(Parcel var1) {
         return new OneoffTask(var1, null);
      }

      public OneoffTask[] zzhf(int var1) {
         return new OneoffTask[var1];
      }
   };
   private final long zzaLW;
   private final long zzaLX;

   @Deprecated
   private OneoffTask(Parcel var1) {
      super(var1);
      this.zzaLW = var1.readLong();
      this.zzaLX = var1.readLong();
   }

   // $FF: synthetic method
   OneoffTask(Parcel var1, Object var2) {
      this(var1);
   }

   public long getWindowEnd() {
      return this.zzaLX;
   }

   public long getWindowStart() {
      return this.zzaLW;
   }

   public String toString() {
      return super.toString() + " " + "windowStart=" + this.getWindowStart() + " " + "windowEnd=" + this.getWindowEnd();
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeLong(this.zzaLW);
      var1.writeLong(this.zzaLX);
   }
}
