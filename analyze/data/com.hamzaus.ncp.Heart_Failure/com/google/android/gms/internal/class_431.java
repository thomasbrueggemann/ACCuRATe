package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_430;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.dv
public final class class_431 implements SafeParcelable {
   public static final class_430 CREATOR = new class_430();
   public final int errorCode;
   // $FF: renamed from: nr java.util.List
   public final List<String> field_1885;
   // $FF: renamed from: ns java.util.List
   public final List<String> field_1886;
   // $FF: renamed from: nv long
   public final long field_1887;
   public final int orientation;
   // $FF: renamed from: oy java.lang.String
   public final String field_1888;
   // $FF: renamed from: qb java.lang.String
   public final String field_1889;
   // $FF: renamed from: qc long
   public final long field_1890;
   // $FF: renamed from: qd boolean
   public final boolean field_1891;
   // $FF: renamed from: qe long
   public final long field_1892;
   // $FF: renamed from: qf java.util.List
   public final List<String> field_1893;
   // $FF: renamed from: qg java.lang.String
   public final String field_1894;
   // $FF: renamed from: qh long
   public final long field_1895;
   // $FF: renamed from: qi java.lang.String
   public final String field_1896;
   // $FF: renamed from: qj boolean
   public final boolean field_1897;
   // $FF: renamed from: qk java.lang.String
   public final String field_1898;
   // $FF: renamed from: ql java.lang.String
   public final String field_1899;
   public final int versionCode;

   public class_431(int var1) {
      this(7, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, -1L, -1, (String)null, -1L, (String)null, false, (String)null, (String)null);
   }

   public class_431(int var1, long var2) {
      this(7, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, var2, -1, (String)null, -1L, (String)null, false, (String)null, (String)null);
   }

   class_431(int var1, String var2, String var3, List<String> var4, int var5, List<String> var6, long var7, boolean var9, long var10, List<String> var12, long var13, int var15, String var16, long var17, String var19, boolean var20, String var21, String var22) {
      this.versionCode = var1;
      this.field_1888 = var2;
      this.field_1889 = var3;
      List var23;
      if(var4 != null) {
         var23 = Collections.unmodifiableList(var4);
      } else {
         var23 = null;
      }

      this.field_1885 = var23;
      this.errorCode = var5;
      List var24;
      if(var6 != null) {
         var24 = Collections.unmodifiableList(var6);
      } else {
         var24 = null;
      }

      this.field_1886 = var24;
      this.field_1890 = var7;
      this.field_1891 = var9;
      this.field_1892 = var10;
      List var25;
      if(var12 != null) {
         var25 = Collections.unmodifiableList(var12);
      } else {
         var25 = null;
      }

      this.field_1893 = var25;
      this.field_1887 = var13;
      this.orientation = var15;
      this.field_1894 = var16;
      this.field_1895 = var17;
      this.field_1896 = var19;
      this.field_1897 = var20;
      this.field_1898 = var21;
      this.field_1899 = var22;
   }

   public class_431(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, String var18) {
      this(7, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, false, (String)null, var18);
   }

   public class_431(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, boolean var18, String var19, String var20) {
      this(7, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, var18, var19, var20);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_430.method_2595(this, var1, var2);
   }
}
