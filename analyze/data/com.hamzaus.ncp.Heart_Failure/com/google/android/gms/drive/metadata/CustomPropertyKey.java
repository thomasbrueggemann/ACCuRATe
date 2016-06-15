package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.class_774;
import com.google.android.gms.internal.class_347;

public class CustomPropertyKey implements SafeParcelable {
   public static final Creator<CustomPropertyKey> CREATOR = new class_774();
   // $FF: renamed from: JI java.lang.String
   final String field_1911;
   // $FF: renamed from: JJ int
   final int field_1912;
   // $FF: renamed from: xJ int
   final int field_1913;

   CustomPropertyKey(int var1, String var2, int var3) {
      byte var4 = 1;
      super();
      this.field_1913 = var1;
      class_347.method_2166(var2, "key");
      if(var3 != 0 && var3 != var4) {
         var4 = 0;
      }

      class_347.method_2161((boolean)var4, "visibility must be either PUBLIC or PRIVATE");
      this.field_1911 = var2;
      this.field_1912 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null) {
         if(var1 == this) {
            return var2;
         }

         if(var1 instanceof CustomPropertyKey) {
            CustomPropertyKey var3 = (CustomPropertyKey)var1;
            if(!var3.getKey().equals(this.field_1911) || var3.getVisibility() != this.field_1912) {
               var2 = false;
            }

            return var2;
         }
      }

      return false;
   }

   public String getKey() {
      return this.field_1911;
   }

   public int getVisibility() {
      return this.field_1912;
   }

   public int hashCode() {
      return (this.field_1911 + this.field_1912).hashCode();
   }

   public String toString() {
      return "CustomPropertyKey(" + this.field_1911 + "," + this.field_1912 + ")";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_774.method_4354(this, var1, var2);
   }
}
