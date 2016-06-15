package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.data.e
public class class_436<T extends SafeParcelable> extends DataBuffer<T> {
   // $FF: renamed from: EB java.lang.String[]
   private static final String[] field_1921 = new String[]{"data"};
   // $FF: renamed from: EC android.os.Parcelable.Creator
   private final Creator<T> field_1922;

   public class_436(DataHolder var1, Creator<T> var2) {
      super(var1);
      this.field_1922 = var2;
   }

   // $FF: renamed from: ad (int) com.google.android.gms.common.internal.safeparcel.SafeParcelable
   public T method_2617(int var1) {
      byte[] var2 = this.DD.method_4567("data", var1, 0);
      Parcel var3 = Parcel.obtain();
      var3.unmarshall(var2, 0, var2.length);
      var3.setDataPosition(0);
      SafeParcelable var4 = (SafeParcelable)this.field_1922.createFromParcel(var3);
      var3.recycle();
      return var4;
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2617(var1);
   }
}
