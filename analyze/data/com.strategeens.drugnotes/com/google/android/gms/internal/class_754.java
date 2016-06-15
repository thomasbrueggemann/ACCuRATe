package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_756;
import com.google.android.gms.internal.class_763;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.ny
public final class class_754 implements SafeParcelable {
   public static final class_756 CREATOR = new class_756();
   public static final long ahz;
   // $FF: renamed from: CK int
   final int field_3415;
   private final long agr;
   private final class_763 ahA;
   private final int mPriority;

   static {
      ahz = TimeUnit.HOURS.toMillis(1L);
   }

   public class_754(int var1, class_763 var2, long var3, int var5) {
      this.field_3415 = var1;
      this.ahA = var2;
      this.agr = var3;
      this.mPriority = var5;
   }

   public int describeContents() {
      class_756 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_754)) {
            return false;
         }

         class_754 var2 = (class_754)var1;
         if(!class_336.equal(this.ahA, var2.ahA) || this.agr != var2.agr || this.mPriority != var2.mPriority) {
            return false;
         }
      }

      return true;
   }

   public long getInterval() {
      return this.agr;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.ahA, Long.valueOf(this.agr), Integer.valueOf(this.mPriority)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: nt () com.google.android.gms.internal.nu
   public class_763 method_4333() {
      return this.ahA;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("filter", this.ahA).method_3424("interval", Long.valueOf(this.agr)).method_3424("priority", Integer.valueOf(this.mPriority)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_756 var10000 = CREATOR;
      class_756.method_4337(this, var1, var2);
   }
}
