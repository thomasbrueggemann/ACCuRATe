package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_393;
import com.google.android.gms.internal.class_395;

// $FF: renamed from: com.google.android.gms.internal.hh
public class class_394 implements SafeParcelable {
   public static final class_393 CREATOR = new class_393();
   // $FF: renamed from: CV int
   public static final int field_1222 = Integer.parseInt("-1");
   // $FF: renamed from: CW com.google.android.gms.internal.hp
   private static final class_388 field_1223 = (new class_388.class_1553("SsbContext")).method_4110(true).method_4113("blob").method_4115();
   // $FF: renamed from: CK int
   final int field_1224;
   // $FF: renamed from: CX java.lang.String
   public final String field_1225;
   // $FF: renamed from: CY com.google.android.gms.internal.hp
   final class_388 field_1226;
   // $FF: renamed from: CZ int
   public final int field_1227;
   // $FF: renamed from: Da byte[]
   public final byte[] field_1228;

   class_394(int var1, String var2, class_388 var3, int var4, byte[] var5) {
      boolean var6;
      if(var4 != field_1222 && class_395.method_2681(var4) == null) {
         var6 = false;
      } else {
         var6 = true;
      }

      class_335.method_2308(var6, "Invalid section type " + var4);
      this.field_1224 = var1;
      this.field_1225 = var2;
      this.field_1226 = var3;
      this.field_1227 = var4;
      this.field_1228 = var5;
      String var7 = this.method_2680();
      if(var7 != null) {
         throw new IllegalArgumentException(var7);
      }
   }

   public class_394(String var1, class_388 var2) {
      this(1, var1, var2, field_1222, (byte[])null);
   }

   public class_394(String var1, class_388 var2, String var3) {
      this(1, var1, var2, class_395.method_2682(var3), (byte[])null);
   }

   public class_394(byte[] var1, class_388 var2) {
      this(1, (String)null, var2, field_1222, var1);
   }

   public int describeContents() {
      class_393 var10000 = CREATOR;
      return 0;
   }

   // $FF: renamed from: fE () java.lang.String
   public String method_2680() {
      return this.field_1227 != field_1222 && class_395.method_2681(this.field_1227) == null?"Invalid section type " + this.field_1227:(this.field_1225 != null && this.field_1228 != null?"Both content and blobContent set":null);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_393 var10000 = CREATOR;
      class_393.method_2677(this, var1, var2);
   }
}
