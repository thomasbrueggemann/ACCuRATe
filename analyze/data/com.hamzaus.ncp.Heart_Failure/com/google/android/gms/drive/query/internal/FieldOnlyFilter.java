package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.class_730;
import com.google.android.gms.drive.query.internal.class_734;

public class FieldOnlyFilter implements SafeParcelable, Filter {
   public static final Creator<FieldOnlyFilter> CREATOR = new class_730();
   // $FF: renamed from: KJ com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4123;
   // $FF: renamed from: KK com.google.android.gms.drive.metadata.MetadataField
   private final MetadataField<?> field_4124;
   // $FF: renamed from: xJ int
   final int field_4125;

   FieldOnlyFilter(int var1, MetadataBundle var2) {
      this.field_4125 = var1;
      this.field_4123 = var2;
      this.field_4124 = class_734.method_4145(var2);
   }

   public FieldOnlyFilter(SearchableMetadataField<?> var1) {
      this(1, MetadataBundle.method_1711(var1, (Object)null));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_730.method_4133(this, var1, var2);
   }
}
