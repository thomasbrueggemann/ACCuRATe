package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.location.class_550;

// $FF: renamed from: com.google.android.gms.location.b
public class class_549 implements SafeParcelable {
   public static final class_550 CREATOR = new class_550();
   // $FF: renamed from: Vn int
   int field_2948;
   // $FF: renamed from: Vo int
   int field_2949;
   // $FF: renamed from: Vp long
   long field_2950;
   // $FF: renamed from: xJ int
   private final int field_2951;

   class_549(int var1, int var2, int var3, long var4) {
      this.field_2951 = var1;
      this.field_2948 = var2;
      this.field_2949 = var3;
      this.field_2950 = var4;
   }

   // $FF: renamed from: cI (int) java.lang.String
   private String method_3117(int var1) {
      switch(var1) {
      case 0:
         return "STATUS_SUCCESSFUL";
      case 1:
      default:
         return "STATUS_UNKNOWN";
      case 2:
         return "STATUS_TIMED_OUT_ON_SCAN";
      case 3:
         return "STATUS_NO_INFO_IN_DATABASE";
      case 4:
         return "STATUS_INVALID_SCAN";
      case 5:
         return "STATUS_UNABLE_TO_QUERY_DATABASE";
      case 6:
         return "STATUS_SCANS_DISABLED_IN_SETTINGS";
      case 7:
         return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
      case 8:
         return "STATUS_IN_PROGRESS";
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_549) {
         class_549 var2 = (class_549)var1;
         if(this.field_2948 == var2.field_2948 && this.field_2949 == var2.field_2949 && this.field_2950 == var2.field_2950) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.field_2951;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_2948), Integer.valueOf(this.field_2949), Long.valueOf(this.field_2950)};
      return class_349.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("LocationStatus[cell status: ").append(this.method_3117(this.field_2948));
      var1.append(", wifi status: ").append(this.method_3117(this.field_2949));
      var1.append(", elapsed realtime ns: ").append(this.field_2950);
      var1.append(']');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_550.method_3118(this, var1, var2);
   }
}
