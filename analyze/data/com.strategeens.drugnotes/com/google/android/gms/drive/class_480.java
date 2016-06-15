package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.drive.i
public abstract class class_480 implements Parcelable {
   // $FF: renamed from: OW boolean
   private transient volatile boolean field_1659 = false;

   // $FF: renamed from: I (android.os.Parcel, int) void
   protected abstract void method_3026(Parcel var1, int var2);

   // $FF: renamed from: iB () boolean
   public final boolean method_3027() {
      return this.field_1659;
   }

   public void writeToParcel(Parcel var1, int var2) {
      boolean var3;
      if(!this.method_3027()) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2300(var3);
      this.field_1659 = true;
      this.method_3026(var1, var2);
   }
}
