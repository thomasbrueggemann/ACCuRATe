package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.class_949;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
   public static final class_949 CREATOR = new class_949();
   // $FF: renamed from: CK int
   final int field_2773;
   // $FF: renamed from: QY java.lang.String
   final String field_2774;
   // $FF: renamed from: Sk boolean
   final boolean field_2775;

   FieldWithSortOrder(int var1, String var2, boolean var3) {
      this.field_2773 = var1;
      this.field_2774 = var2;
      this.field_2775 = var3;
   }

   public FieldWithSortOrder(String var1, boolean var2) {
      this(1, var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.field_2774, null};
      String var3;
      if(this.field_2775) {
         var3 = "ASC";
      } else {
         var3 = "DESC";
      }

      var2[1] = var3;
      return String.format(var1, "FieldWithSortOrder[%s %s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_949.method_5246(this, var1, var2);
   }
}
