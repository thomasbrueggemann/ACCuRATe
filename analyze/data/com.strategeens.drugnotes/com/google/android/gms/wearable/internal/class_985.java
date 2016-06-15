package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.internal.al;
import com.google.android.gms.wearable.internal.class_988;

// $FF: renamed from: com.google.android.gms.wearable.internal.al
public class class_985 implements SafeParcelable, Node {
   public static final Creator<al> CREATOR = new class_988();
   // $FF: renamed from: CE java.lang.String
   private final String field_4252;
   // $FF: renamed from: CK int
   final int field_4253;
   // $FF: renamed from: OS java.lang.String
   private final String field_4254;

   class_985(int var1, String var2, String var3) {
      this.field_4253 = var1;
      this.field_4252 = var2;
      this.field_4254 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_985) {
         class_985 var2 = (class_985)var1;
         if(var2.field_4252.equals(this.field_4252) && var2.field_4254.equals(this.field_4254)) {
            return true;
         }
      }

      return false;
   }

   public String getDisplayName() {
      return this.field_4254;
   }

   public String getId() {
      return this.field_4252;
   }

   public int hashCode() {
      return 37 * (629 + this.field_4252.hashCode()) + this.field_4254.hashCode();
   }

   public String toString() {
      return "NodeParcelable{" + this.field_4252 + "," + this.field_4254 + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_988.method_5480(this, var1, var2);
   }
}
