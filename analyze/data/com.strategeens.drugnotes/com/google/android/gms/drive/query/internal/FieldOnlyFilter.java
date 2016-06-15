package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_950;
import com.google.android.gms.drive.query.internal.class_953;
import com.google.android.gms.drive.query.internal.f;

public class FieldOnlyFilter extends AbstractFilter {
   public static final Creator<FieldOnlyFilter> CREATOR = new class_950();
   // $FF: renamed from: CK int
   final int field_1708;
   // $FF: renamed from: Si com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_1709;
   // $FF: renamed from: Sj com.google.android.gms.drive.metadata.MetadataField
   private final MetadataField<?> field_1710;

   FieldOnlyFilter(int var1, MetadataBundle var2) {
      this.field_1708 = var1;
      this.field_1709 = var2;
      this.field_1710 = class_953.method_5258(var2);
   }

   public FieldOnlyFilter(SearchableMetadataField<?> var1) {
      this(1, MetadataBundle.method_2079(var1, (Object)null));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <T> T method_7(f<T> var1) {
      return var1.method_928(this.field_1710);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_950.method_5249(this, var1, var2);
   }
}
