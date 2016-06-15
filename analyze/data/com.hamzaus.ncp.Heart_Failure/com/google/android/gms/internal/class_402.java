package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_398;
import com.google.android.gms.internal.class_403;
import java.util.BitSet;

// $FF: renamed from: com.google.android.gms.internal.fh
public class class_402 implements SafeParcelable {
   public static final class_403 CREATOR = new class_403();
   // $FF: renamed from: xJ int
   final int field_1781;
   // $FF: renamed from: xK com.google.android.gms.internal.fl[]
   final class_398[] field_1782;
   // $FF: renamed from: xL java.lang.String
   public final String field_1783;
   // $FF: renamed from: xM boolean
   public final boolean field_1784;

   class_402(int var1, class_398[] var2, String var3, boolean var4) {
      this.field_1781 = var1;
      this.field_1782 = var2;
      this.field_1783 = var3;
      this.field_1784 = var4;
   }

   public class_402(String var1, boolean var2, class_398... var3) {
      this(1, var3, var1, var2);
      BitSet var4 = new BitSet(class_389.method_2469());

      for(int var5 = 0; var5 < var3.length; ++var5) {
         int var6 = var3[var5].field_1775;
         if(var6 != -1) {
            if(var4.get(var6)) {
               throw new IllegalArgumentException("Duplicate global search section type " + class_389.method_2467(var6));
            }

            var4.set(var6);
         }
      }

   }

   public int describeContents() {
      class_403 var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_403 var10000 = CREATOR;
      class_403.method_2489(this, var1, var2);
   }
}
