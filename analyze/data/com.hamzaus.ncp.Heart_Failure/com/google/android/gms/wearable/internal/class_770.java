package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.class_771;

// $FF: renamed from: com.google.android.gms.wearable.internal.ai
public class class_770 implements SafeParcelable, Node {
   public static final Creator<ai> CREATOR = new class_771();
   // $FF: renamed from: Lk java.lang.String
   private final String field_4112;
   // $FF: renamed from: xD java.lang.String
   private final String field_4113;
   // $FF: renamed from: xJ int
   final int field_4114;

   class_770(int var1, String var2, String var3) {
      this.field_4114 = var1;
      this.field_4113 = var2;
      this.field_4112 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_770) {
         class_770 var2 = (class_770)var1;
         if(var2.field_4113.equals(this.field_4113) && var2.field_4112.equals(this.field_4112)) {
            return true;
         }
      }

      return false;
   }

   public String getDisplayName() {
      return this.field_4112;
   }

   public String getId() {
      return this.field_4113;
   }

   public int hashCode() {
      return 37 * (629 + this.field_4113.hashCode()) + this.field_4112.hashCode();
   }

   public String toString() {
      return "NodeParcelable{" + this.field_4113 + "," + this.field_4112 + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_771.method_4350(this, var1, var2);
   }
}
