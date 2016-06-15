package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_306;
import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.class_349;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.jr
public final class class_305 implements SafeParcelable {
   public static final class_306 CREATOR = new class_306();
   // $FF: renamed from: Wj long
   static final long field_1151;
   // $FF: renamed from: Vi long
   private final long field_1152;
   // $FF: renamed from: Wk com.google.android.gms.internal.jn
   private final class_310 field_1153;
   private final int mPriority;
   // $FF: renamed from: xJ int
   final int field_1154;

   static {
      field_1151 = TimeUnit.HOURS.toMillis(1L);
   }

   public class_305(int var1, class_310 var2, long var3, int var5) {
      this.field_1154 = var1;
      this.field_1153 = var2;
      this.field_1152 = var3;
      this.mPriority = var5;
   }

   public int describeContents() {
      class_306 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_305)) {
            return false;
         }

         class_305 var2 = (class_305)var1;
         if(!class_349.equal(this.field_1153, var2.field_1153) || this.field_1152 != var2.field_1152 || this.mPriority != var2.mPriority) {
            return false;
         }
      }

      return true;
   }

   public long getInterval() {
      return this.field_1152;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1153, Long.valueOf(this.field_1152), Integer.valueOf(this.mPriority)};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: ja () com.google.android.gms.internal.jn
   public class_310 method_2002() {
      return this.field_1153;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("filter", this.field_1153).method_4301("interval", Long.valueOf(this.field_1152)).method_4301("priority", Integer.valueOf(this.mPriority)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_306 var10000 = CREATOR;
      class_306.method_2003(this, var1, var2);
   }
}
