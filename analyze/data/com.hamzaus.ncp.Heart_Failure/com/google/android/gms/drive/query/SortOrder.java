package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.class_664;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class SortOrder implements SafeParcelable {
   public static final Creator<SortOrder> CREATOR = new class_664();
   // $FF: renamed from: KH java.util.List
   final List<FieldWithSortOrder> field_903;
   // $FF: renamed from: xJ int
   final int field_904;

   SortOrder(int var1, List<FieldWithSortOrder> var2) {
      this.field_904 = var1;
      this.field_903 = var2;
   }

   private SortOrder(List<FieldWithSortOrder> var1) {
      this(1, var1);
   }

   // $FF: synthetic method
   SortOrder(List var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_664.method_3826(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: KH java.util.List
      private final List<FieldWithSortOrder> field_3671 = new ArrayList();

      public SortOrder.Builder addSortAscending(SortableMetadataField var1) {
         this.field_3671.add(new FieldWithSortOrder(var1.getName(), true));
         return this;
      }

      public SortOrder.Builder addSortDescending(SortableMetadataField var1) {
         this.field_3671.add(new FieldWithSortOrder(var1.getName(), false));
         return this;
      }

      public SortOrder build() {
         return new SortOrder(this.field_3671);
      }
   }
}
