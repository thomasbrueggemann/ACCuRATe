package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_812;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.oh
public class class_813 implements SafeParcelable {
   public static final class_812 CREATOR;
   public static final class_813 akf;
   public final String akg;
   public final String akh;
   public final String aki;
   public final String akj;
   public final int versionCode;

   static {
      akf = new class_813("com.google.android.gms", Locale.ENGLISH, (String)null);
      CREATOR = new class_812();
   }

   public class_813(int var1, String var2, String var3, String var4, String var5) {
      this.versionCode = var1;
      this.akg = var2;
      this.akh = var3;
      this.aki = var4;
      this.akj = var5;
   }

   public class_813(String var1, Locale var2, String var3) {
      this(1, var1, var2.toString(), var3, (String)null);
   }

   public int describeContents() {
      class_812 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1 instanceof class_813) {
            class_813 var2 = (class_813)var1;
            if(this.akh.equals(var2.akh) && this.akg.equals(var2.akg) && class_336.equal(this.aki, var2.aki) && class_336.equal(this.akj, var2.akj)) {
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
      Object[] var1 = new Object[]{this.akg, this.akh, this.aki};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("clientPackageName", this.akg).method_3424("locale", this.akh).method_3424("accountName", this.aki).method_3424("gCoreClientName", this.akj).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_812 var10000 = CREATOR;
      class_812.method_4459(this, var1, var2);
   }
}
