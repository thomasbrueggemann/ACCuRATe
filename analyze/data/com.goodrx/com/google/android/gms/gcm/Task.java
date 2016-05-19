package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.gcm.zzd;

public abstract class Task implements Parcelable {
   private final Bundle mExtras;
   private final String mTag;
   private final String zzaMh;
   private final boolean zzaMi;
   private final boolean zzaMj;
   private final int zzaMk;
   private final boolean zzaMl;
   private final zzd zzaMm;

   @Deprecated
   Task(Parcel var1) {
      byte var2 = 1;
      super();
      Log.e("Task", "Constructing a Task object using a parcel.");
      this.zzaMh = var1.readString();
      this.mTag = var1.readString();
      byte var4;
      if(var1.readInt() == var2) {
         var4 = var2;
      } else {
         var4 = 0;
      }

      this.zzaMi = (boolean)var4;
      if(var1.readInt() != var2) {
         var2 = 0;
      }

      this.zzaMj = (boolean)var2;
      this.zzaMk = 2;
      this.zzaMl = false;
      this.zzaMm = zzd.zzaMc;
      this.mExtras = null;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.zzaMh);
      var1.writeString(this.mTag);
      byte var4;
      if(this.zzaMi) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeInt(var4);
      if(!this.zzaMj) {
         var3 = 0;
      }

      var1.writeInt(var3);
   }
}
