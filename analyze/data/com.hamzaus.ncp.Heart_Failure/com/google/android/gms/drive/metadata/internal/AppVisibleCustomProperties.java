package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.class_679;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
   public static final Creator<AppVisibleCustomProperties> CREATOR = new class_679();
   // $FF: renamed from: JK com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
   public static final AppVisibleCustomProperties field_2785 = (new AppVisibleCustomProperties.class_1007()).method_4358();
   // $FF: renamed from: JL java.util.List
   final List<CustomProperty> field_2786;
   // $FF: renamed from: xJ int
   final int field_2787;

   AppVisibleCustomProperties(int var1, Collection<CustomProperty> var2) {
      this.field_2787 = var1;
      class_347.method_2170(var2);
      this.field_2786 = new ArrayList(var2);
   }

   private AppVisibleCustomProperties(Collection<CustomProperty> var1) {
      this(1, var1);
   }

   // $FF: synthetic method
   AppVisibleCustomProperties(Collection var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public Iterator<CustomProperty> iterator() {
      return this.field_2786.iterator();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_679.method_3955(this, var1, var2);
   }

   public static class class_1007 {
      // $FF: renamed from: JM java.util.Map
      private final Map<CustomPropertyKey, CustomProperty> field_4126 = new HashMap();

      // $FF: renamed from: gy () com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
      public AppVisibleCustomProperties method_4358() {
         return new AppVisibleCustomProperties(this.field_4126.values());
      }
   }
}
