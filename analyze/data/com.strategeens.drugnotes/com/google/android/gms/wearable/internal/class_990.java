package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.aw;
import com.google.android.gms.wearable.internal.class_989;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.aw
public class class_990 implements SafeParcelable {
   public static final Creator<aw> CREATOR = new class_989();
   public final long ayc;
   public final List<an> aye;
   public final int statusCode;
   public final int versionCode;

   class_990(int var1, int var2, long var3, List<an> var5) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.ayc = var3;
      this.aye = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_989.method_5483(this, var1, var2);
   }
}
