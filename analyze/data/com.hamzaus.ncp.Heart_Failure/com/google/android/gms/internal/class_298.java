package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_634;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.kb
public class class_298 implements SafeParcelable {
   public static final class_634 CREATOR = new class_634();
   // $FF: renamed from: YS java.lang.String
   public final String field_1008;
   // $FF: renamed from: YT java.lang.String
   public final String field_1009;
   public final int versionCode;

   public class_298(int var1, String var2, String var3) {
      this.versionCode = var1;
      this.field_1008 = var2;
      this.field_1009 = var3;
   }

   public class_298(String var1, Locale var2) {
      this.versionCode = 0;
      this.field_1008 = var1;
      this.field_1009 = var2.toString();
   }

   public int describeContents() {
      class_634 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1 instanceof class_298) {
            class_298 var2 = (class_298)var1;
            if(this.field_1009.equals(var2.field_1009) && this.field_1008.equals(var2.field_1008)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1008, this.field_1009};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("clientPackageName", this.field_1008).method_4301("locale", this.field_1009).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_634 var10000 = CREATOR;
      class_634.method_3631(this, var1, var2);
   }
}
