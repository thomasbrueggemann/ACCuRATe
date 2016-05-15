package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
   public static final Creator<BinderWrapper> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzan(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzbQ(var1);
      }

      public BinderWrapper zzan(Parcel var1) {
         return new BinderWrapper(var1, null);
      }

      public BinderWrapper[] zzbQ(int var1) {
         return new BinderWrapper[var1];
      }
   };
   private IBinder zzakD;

   public BinderWrapper() {
      this.zzakD = null;
   }

   private BinderWrapper(Parcel var1) {
      this.zzakD = null;
      this.zzakD = var1.readStrongBinder();
   }

   // $FF: synthetic method
   BinderWrapper(Parcel var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeStrongBinder(this.zzakD);
   }
}
