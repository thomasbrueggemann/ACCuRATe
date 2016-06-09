package com.comscore.android.id;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// $FF: renamed from: com.comscore.android.id.c
final class class_89 implements IInterface {
   // $FF: renamed from: a android.os.IBinder
   private IBinder field_613;

   public class_89(IBinder var1) {
      this.field_613 = var1;
   }

   public IBinder asBinder() {
      return this.field_613;
   }

   public String getId() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      String var5;
      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         this.field_613.transact(1, var1, var2, 0);
         var2.readException();
         var5 = var2.readString();
      } finally {
         var2.recycle();
         var1.recycle();
      }

      return var5;
   }

   public boolean isLimitAdTrackingEnabled(boolean param1) {
      // $FF: Couldn't be decompiled
   }
}
