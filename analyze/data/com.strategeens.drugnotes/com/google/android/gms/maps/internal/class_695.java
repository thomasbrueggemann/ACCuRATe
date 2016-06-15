package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_697;

// $FF: renamed from: com.google.android.gms.maps.internal.y
public class class_695 implements SafeParcelable {
   public static final class_697 CREATOR = new class_697();
   private final Point alK;
   private final int versionCode;

   public class_695(int var1, Point var2) {
      this.versionCode = var1;
      this.alK = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_695)) {
         return false;
      } else {
         class_695 var2 = (class_695)var1;
         return this.alK.equals(var2.alK);
      }
   }

   int getVersionCode() {
      return this.versionCode;
   }

   public int hashCode() {
      return this.alK.hashCode();
   }

   // $FF: renamed from: oa () android.graphics.Point
   public Point method_3988() {
      return this.alK;
   }

   public String toString() {
      return this.alK.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_697.method_3996(this, var1, var2);
   }
}
