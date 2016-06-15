package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_729;

public class FieldWithSortOrder implements SafeParcelable {
   public static final class_729 CREATOR = new class_729();
   // $FF: renamed from: JE java.lang.String
   final String field_2916;
   // $FF: renamed from: KL boolean
   final boolean field_2917;
   // $FF: renamed from: xJ int
   final int field_2918;

   FieldWithSortOrder(int var1, String var2, boolean var3) {
      this.field_2918 = var1;
      this.field_2916 = var2;
      this.field_2917 = var3;
   }

   public FieldWithSortOrder(String var1, boolean var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_729.method_4130(this, var1, var2);
   }
}
