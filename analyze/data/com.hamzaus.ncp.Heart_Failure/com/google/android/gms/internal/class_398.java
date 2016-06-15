package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.class_399;

// $FF: renamed from: com.google.android.gms.internal.fl
public class class_398 implements SafeParcelable {
   public static final class_399 CREATOR = new class_399();
   // $FF: renamed from: xQ int
   public static final int field_1771 = Integer.parseInt("-1");
   // $FF: renamed from: xJ int
   final int field_1772;
   // $FF: renamed from: xR java.lang.String
   public final String field_1773;
   // $FF: renamed from: xS com.google.android.gms.internal.fq
   final class_388 field_1774;
   // $FF: renamed from: xT int
   public final int field_1775;
   // $FF: renamed from: xU byte[]
   public final byte[] field_1776;

   class_398(int var1, String var2, class_388 var3, int var4, byte[] var5) {
      boolean var6;
      if(var4 != field_1771 && class_389.method_2467(var4) == null) {
         var6 = false;
      } else {
         var6 = true;
      }

      class_347.method_2168(var6, "Invalid section type " + var4);
      this.field_1772 = var1;
      this.field_1773 = var2;
      this.field_1774 = var3;
      this.field_1775 = var4;
      this.field_1776 = var5;
      String var7 = this.method_2482();
      if(var7 != null) {
         throw new IllegalArgumentException(var7);
      }
   }

   public class_398(String var1, class_388 var2) {
      this(1, var1, var2, field_1771, (byte[])null);
   }

   public class_398(String var1, class_388 var2, String var3) {
      this(1, var1, var2, class_389.method_2468(var3), (byte[])null);
   }

   public class_398(byte[] var1, class_388 var2) {
      this(1, (String)null, var2, field_1771, var1);
   }

   // $FF: renamed from: dJ () java.lang.String
   public String method_2482() {
      return this.field_1775 != field_1771 && class_389.method_2467(this.field_1775) == null?"Invalid section type " + this.field_1775:(this.field_1773 != null && this.field_1776 != null?"Both content and blobContent set":null);
   }

   public int describeContents() {
      class_399 var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_399 var10000 = CREATOR;
      class_399.method_2483(this, var1, var2);
   }
}
