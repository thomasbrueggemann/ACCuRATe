package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.class_266;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.class_732;
import com.google.android.gms.drive.query.internal.class_734;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
   public static final class_732 CREATOR = new class_732();
   // $FF: renamed from: KJ com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4138;
   // $FF: renamed from: KU com.google.android.gms.drive.metadata.b
   private final b<T> field_4139;
   // $FF: renamed from: xJ int
   final int field_4140;

   InFilter(int var1, MetadataBundle var2) {
      this.field_4140 = var1;
      this.field_4138 = var2;
      this.field_4139 = (class_266)class_734.method_4145(var2);
   }

   public InFilter(SearchableCollectionMetadataField<T> var1, T var2) {
      this(1, MetadataBundle.method_1711(var1, Collections.singleton(var2)));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_732.method_4139(this, var1, var2);
   }
}
