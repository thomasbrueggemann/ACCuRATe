package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
   @Deprecated
   public static final Creator<Command> CREATOR = new Creator() {
      // $FF: synthetic method
      @Deprecated
      public Object createFromParcel(Parcel var1) {
         return this.zzq(var1);
      }

      // $FF: synthetic method
      @Deprecated
      public Object[] newArray(int var1) {
         return this.zzag(var1);
      }

      @Deprecated
      public Command[] zzag(int var1) {
         return new Command[var1];
      }

      @Deprecated
      public Command zzq(Parcel var1) {
         return new Command(var1);
      }
   };
   private String mValue;
   private String zzRt;
   private String zzyv;

   @Deprecated
   public Command() {
   }

   @Deprecated
   Command(Parcel var1) {
      this.readFromParcel(var1);
   }

   @Deprecated
   private void readFromParcel(Parcel var1) {
      this.zzyv = var1.readString();
      this.zzRt = var1.readString();
      this.mValue = var1.readString();
   }

   @Deprecated
   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.zzyv;
   }

   public String getValue() {
      return this.mValue;
   }

   @Deprecated
   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.zzyv);
      var1.writeString(this.zzRt);
      var1.writeString(this.mValue);
   }
}
