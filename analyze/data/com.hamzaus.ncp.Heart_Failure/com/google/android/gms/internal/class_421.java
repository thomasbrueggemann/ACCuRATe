package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_420;

// $FF: renamed from: com.google.android.gms.internal.cf
public final class class_421 implements SafeParcelable {
   public static final class_420 CREATOR = new class_420();
   public final String mimeType;
   // $FF: renamed from: nY java.lang.String
   public final String field_1840;
   // $FF: renamed from: nZ java.lang.String
   public final String field_1841;
   // $FF: renamed from: oa java.lang.String
   public final String field_1842;
   // $FF: renamed from: ob java.lang.String
   public final String field_1843;
   // $FF: renamed from: oc java.lang.String
   public final String field_1844;
   public final String packageName;
   public final int versionCode;

   public class_421(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
      this.versionCode = var1;
      this.field_1840 = var2;
      this.field_1841 = var3;
      this.mimeType = var4;
      this.packageName = var5;
      this.field_1842 = var6;
      this.field_1843 = var7;
      this.field_1844 = var8;
   }

   public class_421(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      this(1, var1, var2, var3, var4, var5, var6, var7);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_420.method_2550(this, var1, var2);
   }
}
