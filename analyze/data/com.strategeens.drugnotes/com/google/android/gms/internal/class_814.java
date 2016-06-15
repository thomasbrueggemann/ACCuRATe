package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_804;

// $FF: renamed from: com.google.android.gms.internal.ov
public class class_814 implements SafeParcelable {
   public static final class_804 CREATOR = new class_804();
   public final int ang;
   public final int anh;
   public final String ani;
   public final String anj;
   public final boolean ank;
   public final String anl;
   public final String packageName;
   public final int versionCode;

   public class_814(int var1, String var2, int var3, int var4, String var5, String var6, boolean var7, String var8) {
      this.versionCode = var1;
      this.packageName = var2;
      this.ang = var3;
      this.anh = var4;
      this.ani = var5;
      this.anj = var6;
      this.ank = var7;
      this.anl = var8;
   }

   @Deprecated
   public class_814(String var1, int var2, int var3, String var4, String var5, boolean var6) {
      this.versionCode = 1;
      this.packageName = (String)class_335.method_2311(var1);
      this.ang = var2;
      this.anh = var3;
      this.anl = null;
      this.ani = var4;
      this.anj = var5;
      this.ank = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_814)) {
            return false;
         }

         class_814 var2 = (class_814)var1;
         if(!this.packageName.equals(var2.packageName) || this.ang != var2.ang || this.anh != var2.anh || !class_336.equal(this.anl, var2.anl) || !class_336.equal(this.ani, var2.ani) || !class_336.equal(this.anj, var2.anj) || this.ank != var2.ank) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.packageName, Integer.valueOf(this.ang), Integer.valueOf(this.anh), this.ani, this.anj, Boolean.valueOf(this.ank)};
      return class_336.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("PlayLoggerContext[");
      var1.append("package=").append(this.packageName).append(',');
      var1.append("versionCode=").append(this.versionCode).append(',');
      var1.append("logSource=").append(this.anh).append(',');
      var1.append("logSourceName=").append(this.anl).append(',');
      var1.append("uploadAccount=").append(this.ani).append(',');
      var1.append("loggingId=").append(this.anj).append(',');
      var1.append("logAndroidId=").append(this.ank);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_804.method_4446(this, var1, var2);
   }
}
