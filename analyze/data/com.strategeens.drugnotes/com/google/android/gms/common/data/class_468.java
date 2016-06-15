package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.data.e
public class class_468<T extends SafeParcelable> extends DataBuffer<T> {
   // $FF: renamed from: Lb java.lang.String[]
   private static final String[] field_1597 = new String[]{"data"};
   // $FF: renamed from: Lc android.os.Parcelable.Creator
   private final Creator<T> field_1598;

   public class_468(DataHolder var1, Creator<T> var2) {
      super(var1);
      this.field_1598 = var2;
   }

   // $FF: renamed from: at (int) com.google.android.gms.common.internal.safeparcel.SafeParcelable
   public T method_2977(int var1) {
      byte[] var2 = this.JG.method_5835("data", var1, this.JG.method_5829(var1));
      Parcel var3 = Parcel.obtain();
      var3.unmarshall(var2, 0, var2.length);
      var3.setDataPosition(0);
      SafeParcelable var4 = (SafeParcelable)this.field_1598.createFromParcel(var3);
      var3.recycle();
      return var4;
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2977(var1);
   }
}
