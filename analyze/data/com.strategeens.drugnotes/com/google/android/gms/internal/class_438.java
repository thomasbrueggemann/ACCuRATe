package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.ey;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fj
@ey
public final class class_438 implements SafeParcelable {
   public static final class_439 CREATOR = new class_439();
   public final int errorCode;
   public final int orientation;
   // $FF: renamed from: qA long
   public final long field_1440;
   // $FF: renamed from: qw java.util.List
   public final List<String> field_1441;
   // $FF: renamed from: qx java.util.List
   public final List<String> field_1442;
   // $FF: renamed from: sg java.lang.String
   public final String field_1443;
   // $FF: renamed from: tT boolean
   public final boolean field_1444;
   // $FF: renamed from: tU java.lang.String
   public final String field_1445;
   // $FF: renamed from: tV long
   public final long field_1446;
   // $FF: renamed from: tW boolean
   public final boolean field_1447;
   // $FF: renamed from: tX long
   public final long field_1448;
   // $FF: renamed from: tY java.util.List
   public final List<String> field_1449;
   // $FF: renamed from: tZ java.lang.String
   public final String field_1450;
   // $FF: renamed from: ua long
   public final long field_1451;
   // $FF: renamed from: ub java.lang.String
   public final String field_1452;
   // $FF: renamed from: uc boolean
   public final boolean field_1453;
   // $FF: renamed from: ud java.lang.String
   public final String field_1454;
   // $FF: renamed from: ue java.lang.String
   public final String field_1455;
   // $FF: renamed from: uf boolean
   public final boolean field_1456;
   // $FF: renamed from: ug boolean
   public final boolean field_1457;
   // $FF: renamed from: uh boolean
   public final boolean field_1458;
   public final int versionCode;

   public class_438(int var1) {
      this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, -1L, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
   }

   public class_438(int var1, long var2) {
      this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, var2, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
   }

   class_438(int var1, String var2, String var3, List<String> var4, int var5, List<String> var6, long var7, boolean var9, long var10, List<String> var12, long var13, int var15, String var16, long var17, String var19, boolean var20, String var21, String var22, boolean var23, boolean var24, boolean var25, boolean var26) {
      this.versionCode = var1;
      this.field_1443 = var2;
      this.field_1445 = var3;
      List var27;
      if(var4 != null) {
         var27 = Collections.unmodifiableList(var4);
      } else {
         var27 = null;
      }

      this.field_1441 = var27;
      this.errorCode = var5;
      List var28;
      if(var6 != null) {
         var28 = Collections.unmodifiableList(var6);
      } else {
         var28 = null;
      }

      this.field_1442 = var28;
      this.field_1446 = var7;
      this.field_1447 = var9;
      this.field_1448 = var10;
      List var29;
      if(var12 != null) {
         var29 = Collections.unmodifiableList(var12);
      } else {
         var29 = null;
      }

      this.field_1449 = var29;
      this.field_1440 = var13;
      this.orientation = var15;
      this.field_1450 = var16;
      this.field_1451 = var17;
      this.field_1452 = var19;
      this.field_1453 = var20;
      this.field_1454 = var21;
      this.field_1455 = var22;
      this.field_1456 = var23;
      this.field_1457 = var24;
      this.field_1444 = var25;
      this.field_1458 = var26;
   }

   public class_438(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, String var18, boolean var19, boolean var20, boolean var21, boolean var22) {
      this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, false, (String)null, var18, var19, var20, var21, var22);
   }

   public class_438(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, boolean var18, String var19, String var20, boolean var21, boolean var22, boolean var23, boolean var24) {
      this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, var18, var19, var20, var21, var22, var23, var24);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_439.method_2879(this, var1, var2);
   }
}
