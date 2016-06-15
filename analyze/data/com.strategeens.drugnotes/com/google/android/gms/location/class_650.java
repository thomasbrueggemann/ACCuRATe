package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.location.class_648;

// $FF: renamed from: com.google.android.gms.location.e
public class class_650 implements SafeParcelable {
   public static final class_648 CREATOR = new class_648();
   // $FF: renamed from: CK int
   private final int field_2819;
   int agw;
   int agx;
   long agy;

   public class_650(int var1, int var2, int var3, long var4) {
      this.field_2819 = var1;
      this.agw = var2;
      this.agx = var3;
      this.agy = var4;
   }

   // $FF: renamed from: eB (int) java.lang.String
   private String method_3721(int var1) {
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
      if(var1 instanceof class_650) {
         class_650 var2 = (class_650)var1;
         if(this.agw == var2.agw && this.agx == var2.agx && this.agy == var2.agy) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.field_2819;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.agw), Integer.valueOf(this.agx), Long.valueOf(this.agy)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("LocationStatus[cell status: ").append(this.method_3721(this.agw));
      var1.append(", wifi status: ").append(this.method_3721(this.agx));
      var1.append(", elapsed realtime ns: ").append(this.agy);
      var1.append(']');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_648.method_3715(this, var1, var2);
   }
}
